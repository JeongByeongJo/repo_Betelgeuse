package com.bicycledoctors.module.member;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bicycledoctors.common.base.BaseController;

import jakarta.servlet.http.HttpSession;


@Controller
public class MemberController extends BaseController {

	
	@Autowired
	MemberService memberService;
	
	@RequestMapping(value = "/member/memberXdmList")
	public String memberXdmList(MemberVo vo, Model model) {
		utildatetime(vo);
		
		vo.setParamsPaging(memberService.selectOneCount(vo));
		
		model.addAttribute("list", memberService.selectList(vo));
		model.addAttribute("vo", vo);
		return "xdm/member/MemberXdmList";
	}
	
	@RequestMapping(value = "/member/memberXdmMfom")
	public String memberXdmMfom(Model model, MemberDto memberDto) {
		model.addAttribute("item", memberService.selectOne(memberDto));
		return "xdm/member/MemberXdmMfom";
	}
	
	@RequestMapping(value = "/member/memberXdmUpdt")
	public String memberXdmUpdt(MemberDto memberDto) {
		memberService.update(memberDto);
		return "redirect:/member/memberXdmList";
	}
	
	@ResponseBody
	@RequestMapping(value = "/member/signinXdmProc")
	public Map<String, Object> signinXdmProc(MemberDto dto, HttpSession httpSession) throws Exception {
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
	@RequestMapping(value = "/member/signinUsrProc")
	public Map<String, Object> signinUsrProc(MemberDto dto, HttpSession httpSession) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		MemberDto rtMember = memberService.signinChk(dto);		
		
		if(rtMember != null) {
			returnMap.put("rt", "success");
			httpSession.setMaxInactiveInterval(60 * 30); 						// 60second * 30 = 30minute
			httpSession.setAttribute("sessSeqUsr", rtMember.getSeq());
			httpSession.setAttribute("sessIdUsr", rtMember.getUserId());
			httpSession.setAttribute("sessNameUsr", rtMember.getUserName());
		} else {
			returnMap.put("rt", "fail");
		}
		
		return returnMap;
	}
	
	@ResponseBody
	@RequestMapping(value = "/member/signoutXdmProc")
	public Map<String, Object> signoutXdmProc(HttpSession httpSession) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		httpSession.setAttribute("sessSeqXdm", null);
		httpSession.setAttribute("sessIdXdm", null);
		httpSession.setAttribute("sessNameXdm", null);
		returnMap.put("rt", "success");
		return returnMap;
	}
	@ResponseBody
	@RequestMapping(value = "/member/signoutUsrProc")
	public Map<String, Object> signoutUsrProc(HttpSession httpSession) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		httpSession.setAttribute("sessSeqUsr", null);
		httpSession.setAttribute("sessIdUsr", null);
		httpSession.setAttribute("sessNameUsr", null);
		returnMap.put("rt", "success");
		return returnMap;
	}
	
	@RequestMapping(value = "/member/signinXdmForm")
	public String signinXdmForm(MemberVo vo, HttpSession httpSession) {		
		return "xdm/member/SigninXdmForm";
	}
	@RequestMapping(value = "/member/signinUsrForm")
	public String signinUsrForm(MemberVo vo, HttpSession httpSession) {		
		return "usr/member/SigninUsrForm";
	}
	@RequestMapping(value = "/member/userInfosettingUsrForm")
	public String userInfosettingUsrForm(MemberDto memberDto, Model model, HttpSession httpSession) {
		memberDto.setSeq((String)httpSession.getAttribute("sessSeqUsr"));
		model.addAttribute("item", memberService.selectOne(memberDto));
		return "usr/member/account-settings";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/member/pswdfindXdmProc")
	public Map<String, Object> pswdfindXdmProc(MemberDto dto, HttpSession httpSession) throws Exception {
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
