package com.bicycledoctors.module.member;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpSession;



@Controller
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	@RequestMapping(value = "/member/MemberXdmList")
	public String MemberXdmList(MemberVo vo, Model model) {
		vo.setParamsPaging(memberService.selectOneCount(vo));
		
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
	
	@ResponseBody
	@RequestMapping(value = "/member/SigninXdmProc")
	public Map<String, Object> SigninXdmProc(MemberDto dto, HttpSession httpSession) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		MemberDto rtMember = memberService.signinChk(dto);		
		
		if(rtMember != null) {
			returnMap.put("rt", "success");
			httpSession.setMaxInactiveInterval(60 * 30); 						// 60second * 30 = 30minute
			httpSession.setAttribute("sessSeqXdm", rtMember.getSeq());
			httpSession.setAttribute("sessIdXdm", rtMember.getUserId());
			httpSession.setAttribute("sessNameXdm", rtMember.getUserName());
		} else {
			returnMap.put("rt", "fail");
		}
		
		return returnMap;
	}
	
	@ResponseBody
	@RequestMapping(value = "/member/SignoutXdmProc")
	public Map<String, Object> signoutXdmProc(HttpSession httpSession) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("rt", "success");
		return returnMap;
	}
	
	@RequestMapping(value = "/member/SigninXdmForm")
	public String signinXdmForm(MemberVo vo, HttpSession httpSession) {
		
		return "xdm/member/signinXdmForm";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/member/PswdfindXdmProc")
	public Map<String, Object> PswdfindXdmProc(MemberDto dto, HttpSession httpSession) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		MemberDto rt = memberService.pswdrecoveryChk(dto);
		
		if(rt != null) {
			returnMap.put("rt", "success");
		} else {
			returnMap.put("rt", "fail");
		}
		return returnMap;
	}

	
	

}
