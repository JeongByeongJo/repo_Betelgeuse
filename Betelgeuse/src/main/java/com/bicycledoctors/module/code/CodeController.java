package com.bicycledoctors.module.code;

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

	@RequestMapping(value = "/code/CodeXdmList")
	public String CodeXdmList(CodeVo vo, Model model) throws Exception{
		
		vo.setParamsPaging(codeService.selectOneCount());
		
		model.addAttribute("list", codeService.selectList(vo));
		model.addAttribute("vo", vo);
		
		return "xdm/code/CodeXdmList";
	}
	
	@RequestMapping(value = "/code/CodeXdmForm")
	public String CodeXdmForm(@ModelAttribute("vo") CodeVo vo, Model model) {
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
	
	@RequestMapping(value = "/code/CodeXdmInst")
	public String CodeXdmInst(CodeDto codeDto) {
		codeService.insert(codeDto);
		return "redirect:/code/CodeXdmList";
	}
	
	@RequestMapping(value = "/code/CodeXdmMfom")
	public String CodeXdmMfom(Model model, CodeDto codeDto) {
//		model.addAttribute("list", codeService.selectGroupList());
		model.addAttribute("list", codeGroupService.selectListWithoutPaging());
		model.addAttribute("item", codeService.selectOne(codeDto));
		return "xdm/code/CodeXdmMfom";
	}
	
	@RequestMapping(value = "/code/CodeXdmUpdt")
	public String CodeXdmUpdt(CodeDto codeDto) {
		codeService.update(codeDto);
		return "redirect:/code/CodeXdmList";
	}
	@RequestMapping(value = "/code/CodeXdmUele")
	public String CodeXdmUele(CodeDto codeDto) {
		codeService.uelete(codeDto);
		return "redirect:/code/CodeXdmList";
	}
}
