package com.bicycledoctors.module.code;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bicycledoctors.module.codegroup.CodeGroupService;


@Controller
public class CodeController {
	
	@Autowired
	CodeService codeService;
	
	@Autowired
	CodeGroupService codeGroupService;

	@RequestMapping(value = "/code/codeXdmList")
	public String codeXdmList(CodeVo vo, Model model) throws Exception{
		LocalDate now = LocalDate.now();        // 포맷 정의        
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");        // 포맷 적용        
		String formatedNow = now.format(formatter);        // 결과 출력 
		
		if (vo.getShDateStart() != null || vo.getShDateEnd() != null) {
			vo.setShDateStart(vo.getShDateStart() + " 00:00:00");
			vo.setShDateEnd(vo.getShDateEnd() + " 23:59:59");
		}
		
		vo.setParamsPaging(codeService.selectOneCount(vo));
		
		if (vo.getShDateStart() == null || vo.getShDateEnd() == null) {
			vo.setShDateStart(formatedNow);
			vo.setShDateEnd(formatedNow);
		}
		model.addAttribute("list", codeService.selectList(vo));
		model.addAttribute("vo", vo);
		
		return "xdm/code/CodeXdmList";
	}
	
	@RequestMapping(value = "/code/codeXdmForm")
	public String codeXdmForm(@ModelAttribute("vo") CodeVo vo, Model model) {
//		model.addAttribute("list", codeService.selectGroupList());
		model.addAttribute("list", codeGroupService.selectListWithoutPaging());
		
		if (vo.getCdSeq().equals("0") || vo.getCdSeq().equals("")) {
//			insert mode
		} else {
//			update mode
			model.addAttribute("item", codeService.selectOne(vo));
		}
		
		return "xdm/code/CodeXdmForm";
	}
	
	@RequestMapping(value = "/code/codeXdmInst")
	public String codeXdmInst(CodeDto codeDto) {
		codeService.insert(codeDto);
		return "redirect:/code/CodeXdmList";
	}
	
	@RequestMapping(value = "/code/codeXdmMfom")
	public String codeXdmMfom(Model model, CodeDto codeDto) {
//		model.addAttribute("list", codeService.selectGroupList());
		model.addAttribute("list", codeGroupService.selectListWithoutPaging());
		model.addAttribute("item", codeService.selectOne(codeDto));
		return "xdm/code/CodeXdmMfom";
	}
	
	@RequestMapping(value = "/code/codeXdmUpdt")
	public String codeXdmUpdt(CodeDto codeDto) {
		codeService.update(codeDto);
		return "redirect:/code/codeXdmList";
	}
	@RequestMapping(value = "/code/codeXdmUele")
	public String codeXdmUele(CodeDto codeDto) {
		codeService.uelete(codeDto);
		return "redirect:/code/codeXdmList";
	}
}
