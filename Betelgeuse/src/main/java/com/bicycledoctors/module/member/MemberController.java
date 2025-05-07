package com.bicycledoctors.module.member;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bicycledoctors.common.base.BaseController;
import com.bicycledoctors.module.bicycle.BicycleDto;
import com.bicycledoctors.module.bicycle.BicycleService;
import com.bicycledoctors.module.mail.MailService;

import jakarta.servlet.http.HttpSession;


@Controller
public class MemberController extends BaseController {

	
	@Autowired
	MemberService memberService;
	
	@Autowired
	MailService mailService;
	
	@Autowired
	BicycleService bicycleService;
	
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
	
	@RequestMapping(value = "/member/signinXdmForm")
	public String signinXdmForm(MemberVo vo, HttpSession httpSession) {		
		return "xdm/member/SigninXdmForm";
	}
	
	@ResponseBody
	@RequestMapping(value = "/member/signinXdmProc")
	public Map<String, Object> signinXdmProc(MemberDto dto, HttpSession httpSession) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		MemberDto rtMember = memberService.selectOneIdChk(dto);		
		
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
	@RequestMapping(value = "/member/signoutXdmProc")
	public Map<String, Object> signoutXdmProc(HttpSession httpSession) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		httpSession.setAttribute("sessSeqXdm", null);
		httpSession.setAttribute("sessIdXdm", null);
		httpSession.setAttribute("sessNameXdm", null);
		returnMap.put("rt", "success");
		return returnMap;
	}
	
	
	@RequestMapping(value = "/member/memberUsrPwUpdt")
	public String memberUsrPwUpdt(MemberDto memberDto, HttpSession httpSession) {
		memberDto.setSeq((String)httpSession.getAttribute("sessSeqUsr"));
		memberService.pwUpdate(memberDto);
		return "redirect:/member/signinUsrForm";
	}
	
	@RequestMapping(value = "/member/memberUsrUele")
	public String memberUsrUele(MemberDto memberDto, HttpSession httpSession) {
		memberDto.setSeq((String)httpSession.getAttribute("sessSeqUsr"));
		memberService.uelete(memberDto);
		return "redirect:/member/signinUsrForm";
	}
	
	@RequestMapping(value = "/member/memberUsrInst")
	public String memberUsrInst(MemberDto memberDto) {
		memberDto.setUserPassword(encodeBcrypt(memberDto.getUserPassword(), 10));
		memberService.insert(memberDto);
		
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					mailService.sendMailWelcome(memberDto);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		thread.start();
		
		return "redirect:/member/signinUsrForm";
	}
	
	@ResponseBody
	@RequestMapping(value = "/member/signinUsrProc")
	public Map<String, Object> signinUsrProc(MemberDto dto, HttpSession httpSession) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		MemberDto rtMemberId = memberService.selectOneId(dto);
		if(Integer.valueOf(rtMemberId.getSeq()) > 11) {
			if(rtMemberId != null && matchesBcrypt(dto.getUserPassword(), rtMemberId.getUserPassword(), 10)) {
				returnMap.put("rt", "success");
				httpSession.setMaxInactiveInterval(60 * 30); 						// 60second * 30 = 30minute
				httpSession.setAttribute("sessSeqUsr", rtMemberId.getSeq());
				httpSession.setAttribute("sessIdUsr", rtMemberId.getUserId());
				httpSession.setAttribute("sessNameUsr", rtMemberId.getUserName());
			} else {
				returnMap.put("rt", "fail");
			}
		} else {
			MemberDto rtMember = memberService.selectOneIdChk(dto);
			
			if(rtMember != null) {
				returnMap.put("rt", "success");
				httpSession.setMaxInactiveInterval(60 * 30); 						// 60second * 30 = 30minute
				httpSession.setAttribute("sessSeqUsr", rtMember.getSeq());
				httpSession.setAttribute("sessIdUsr", rtMember.getUserId());
				httpSession.setAttribute("sessNameUsr", rtMember.getUserName());
			} else {
				returnMap.put("rt", "fail");
			}
		}
//		MemberDto rtMember = memberService.selectOneIdChk(dto);
//		if(Integer.valueOf(rtMember.getSeq()) > 11) {
//			if(rtMember != null && matchesBcrypt(dto.getUserPassword(), rtMember.getUserPassword(), 10)) {
//				returnMap.put("rt", "success");
//				httpSession.setMaxInactiveInterval(60 * 30); 						// 60second * 30 = 30minute
//				httpSession.setAttribute("sessSeqUsr", rtMember.getSeq());
//				httpSession.setAttribute("sessIdUsr", rtMember.getUserId());
//				httpSession.setAttribute("sessNameUsr", rtMember.getUserName());
//			} else {
//				returnMap.put("rt", "fail");
//			}
//		} else {
//			
//			if(rtMember != null) {
//				returnMap.put("rt", "success");
//				httpSession.setMaxInactiveInterval(60 * 30); 						// 60second * 30 = 30minute
//				httpSession.setAttribute("sessSeqUsr", rtMember.getSeq());
//				httpSession.setAttribute("sessIdUsr", rtMember.getUserId());
//				httpSession.setAttribute("sessNameUsr", rtMember.getUserName());
//			} else {
//				returnMap.put("rt", "fail");
//			}
//		}
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
	
	@ResponseBody
	@RequestMapping(value = "/member/idChkUsrProc")
	public Map<String, Object> idChkUsrProc(MemberDto dto) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		MemberDto rtMember = memberService.selectOneIdChk(dto);		
		
		if(rtMember != null) {
			returnMap.put("rt", "success");
		} else {
			returnMap.put("rt", "fail");
		}
		return returnMap;
	}
	@ResponseBody
	@RequestMapping(value = "/member/emailChkUsrProc")
	public Map<String, Object> emailChkUsrProc(MemberDto dto) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		MemberDto rtMember = memberService.selectOneEmailChk(dto);		
		
		if(rtMember != null) {
			returnMap.put("rt", "success");
		} else {
			returnMap.put("rt", "fail");
		}
		return returnMap;
	}
	
	@ResponseBody
	@RequestMapping(value = "/member/pwChkUsrProc")
	public Map<String, Object> pwChkUsrProc(MemberDto dto, HttpSession httpSession) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		dto.setUserId((String)httpSession.getAttribute("sessIdUsr"));
		MemberDto rtMember = memberService.selectOneIdChk(dto);		
		
		if(rtMember != null) {
			returnMap.put("rt", "success");
		} else {
			returnMap.put("rt", "fail");
		}
		return returnMap;
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
	
	@RequestMapping(value = "/member/memberUsrUpdt")
	public String memberUsrUpdt(MemberDto memberDto) {
		memberService.updateInfo(memberDto);
		return "redirect:/member/userInfosettingUsrForm";
	}
	
	@ResponseBody
	@RequestMapping(value = "/member/pswdfindUsrProc")
	public Map<String, Object> pswdfindUsrProc(MemberDto dto, HttpSession httpSession) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		MemberDto rt = memberService.pswdrecoveryChk(dto);
		
		if(rt != null) {
			returnMap.put("rt", "success");
		} else {
			returnMap.put("rt", "fail");
		}
		return returnMap;
	}

	@RequestMapping(value = "/member/userProfileUsrForm")
	public String userProfileUsrForm(MemberDto memberDto, Model model, HttpSession httpSession) {
		memberDto.setSeq((String)httpSession.getAttribute("sessSeqUsr"));
		model.addAttribute("item", memberService.selectOne(memberDto));
		return "usr/member/account-profile";
	}
	@RequestMapping(value = "/member/userBicycleUsrForm")
	public String userBicycleUsrForm(MemberDto memberDto, Model model, HttpSession httpSession) {
		memberDto.setSeq((String)httpSession.getAttribute("sessSeqUsr"));
		model.addAttribute("item", memberService.selectOne(memberDto));
		return "usr/member/account-profile";
	}
	@RequestMapping(value = "/member/userBicycleUsrList")
	public String userBicycleUsrList(Model model, HttpSession httpSession, BicycleDto bicycleDto) {
		bicycleDto.setUserCustomer_seq((String)httpSession.getAttribute("sessSeqUsr"));
		model.addAttribute("list", bicycleService.selectOneList(bicycleDto));
		return "usr/member/account-listings";
	}

}
