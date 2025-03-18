package com.bicycledoctors.module.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	@RequestMapping(value = "/member/MemberXdmList")
	public String MemberXdmList(MemberVo vo, Model model) {
		vo.setParamsPaging(memberService.selectOneCount());
		
		model.addAttribute("list", memberService.selectList(vo));
		model.addAttribute("vo", vo);
		return "xdm/member/MemberXdmList";
	}
	

}
