package com.bicycledoctors.module.codegroup;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class CodeGroupController {
	
	@Autowired
	CodeGroupService codeGroupService;
	
	@RequestMapping(value = "/codegroup/codegroupXdmList")
	public String codegroupXdmList(CodeGroupVo vo, Model model) throws Exception {
		LocalDate now = LocalDate.now();        // 포맷 정의        
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");        // 포맷 적용        
		String formatedNow = now.format(formatter);        // 결과 출력        
		
		if (vo.getShDateStart() != null || vo.getShDateEnd() != null) {
			vo.setShDateStart(vo.getShDateStart() + " 00:00:00");
			vo.setShDateEnd(vo.getShDateEnd() + " 23:59:59");
		}
		
//		System.out.println("vo.getShDateStart(): " + vo.getShDateStart());
//		System.out.println("vo.getShDateEnd(): " + vo.getShDateEnd());
		
		vo.setParamsPaging(codeGroupService.selectOneCount(vo));
		
		if (vo.getShDateStart() == null || vo.getShDateEnd() == null) {
			vo.setShDateStart(formatedNow);
			vo.setShDateEnd(formatedNow);
		}
		model.addAttribute("list", codeGroupService.selectList(vo));
		model.addAttribute("vo", vo);
		
		return "xdm/codegroup/CodegroupXdmList";
	}
	
	@RequestMapping(value = "/codegroup/codegroupXdmForm")
	public String codegroupXdmForm(@ModelAttribute("vo") CodeGroupVo vo, CodeGroupDto dto, Model model) {
		if (vo.getCdgSeq().equals("0") || vo.getCdgSeq().equals("")) {
//			insert mode
		} else {
//			update mode
			model.addAttribute("item", codeGroupService.selectOne(vo));
		}
		System.out.println("dto.getCdgUpdtDate() " + dto.getCdgUpdtDate());
		return "xdm/codegroup/CodegroupXdmForm";
	}
	
	@RequestMapping(value = "/codegroup/codegroupXdmMfom")
	public String codegroupXdmMfom(Model model, CodeGroupDto codeGroupDto) {
		model.addAttribute("item", codeGroupService.selectOne(codeGroupDto));
		return "xdm/codegroup/CodegroupXdmMfom";
	}
	
	@RequestMapping(value = "/codegroup/codegroupXdmInst")
	public String codegroupXdmInst(CodeGroupDto codeGroupDto) {
		codeGroupService.insert(codeGroupDto);
		return "redirect:/codegroup/codegroupXdmList";
	}
	
	@RequestMapping(value = "/codegroup/codegroupXdmUpdt")
	public String codegroupXdmUpdt(CodeGroupDto codeGroupDto) {
		codeGroupService.update(codeGroupDto);
		return "redirect:/codegroup/codegroupXdmList";
	}
	
	@RequestMapping(value = "/codegroup/codegroupXdmUele")
	public String codegroupXdmUele(CodeGroupDto codeGroupDto) {
		codeGroupService.uelete(codeGroupDto);
		return "redirect:/codegroup/codegroupXdmList";
	}

}
