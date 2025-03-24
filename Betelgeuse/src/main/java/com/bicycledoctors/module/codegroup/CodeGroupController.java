package com.bicycledoctors.module.codegroup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class CodeGroupController {
	
	@Autowired
	CodeGroupService codeGroupService;
	
	@RequestMapping(value = "/codegroup/CodegroupXdmList")
	public String CodegroupXdmList(CodeGroupVo vo, Model model) throws Exception {
		
		vo.setParamsPaging(codeGroupService.selectOneCount());
		
		model.addAttribute("list", codeGroupService.selectList(vo));
		model.addAttribute("vo", vo);
		
		return "xdm/codegroup/CodegroupXdmList";
	}
	
	@RequestMapping(value = "/codegroup/CodegroupXdmForm")
	public String CodegroupXdmForm() {		
		return "xdm/codegroup/CodegroupXdmForm";
	}
	
	@RequestMapping(value = "/codegroup/CodegroupXdmMfom")
	public String CodegroupXdmMfom(Model model, CodeGroupDto codeGroupDto) {
		model.addAttribute("item", codeGroupService.selectOne(codeGroupDto));
		return "xdm/codegroup/CodegroupXdmMfom";
	}
	
	@RequestMapping(value = "/codegroup/CodegroupXdmInst")
	public String CodegroupXdmInst(CodeGroupDto codeGroupDto) {
		codeGroupService.insert(codeGroupDto);
		return "redirect:/codegroup/CodegroupXdmList";
	}
	
	@RequestMapping(value = "/codegroup/CodegroupXdmUpdt")
	public String CodegroupXdmUpdt(CodeGroupDto codeGroupDto) {
		codeGroupService.update(codeGroupDto);
		return "redirect:/codegroup/CodegroupXdmList";
	}
	
	@RequestMapping(value = "/codegroup/CodegroupXdmUele")
	public String CodegroupXdmUele(CodeGroupDto codeGroupDto) {
		codeGroupService.uelete(codeGroupDto);
		return "redirect:/codegroup/CodegroupXdmList";
	}

}
