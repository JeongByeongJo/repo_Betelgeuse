package com.bicycledoctors.module.codegroup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bicycledoctors.common.base.BaseController;


@Controller
public class CodeGroupController extends BaseController {
	
	@Autowired
	CodeGroupService codeGroupService;
	
	@RequestMapping(value = "/codegroup/codegroupXdmList")
	public String codegroupXdmList(CodeGroupVo vo, Model model) throws Exception {
		
		utildatetime(vo);
		
		vo.setParamsPaging(codeGroupService.selectOneCount(vo));
		
		model.addAttribute("list", codeGroupService.selectList(vo));
		model.addAttribute("vo", vo);
		
		return "xdm/codegroup/CodegroupXdmList";
	}
	
	@RequestMapping(value = "/codegroup/codegroupXdmForm")
	public String codegroupXdmForm(@ModelAttribute("vo") CodeGroupVo vo, Model model) {
		if (vo.getCdgSeq().equals("0") || vo.getCdgSeq().equals("")) {
//			insert mode
		} else {
//			update mode
			model.addAttribute("item", codeGroupService.selectOne(vo));
		}
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
