package com.bicycledoctors.module.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



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
	
	@RequestMapping(value = "/member/MemberXdmMfom")
	public String MemberXdmMfom(Model model, MemberDto memberDto) {
		model.addAttribute("item", memberService.selectOne(memberDto));
		return "xdm/member/MemberXdmMfom";
	}
	
	@RequestMapping(value = "/member/MemberXdmUpdt")
	public String requestMethodName(MemberDto memberDto) {
		memberService.update(memberDto);
		return "redirect:/member/MemberXdmList";
	}
	

}
