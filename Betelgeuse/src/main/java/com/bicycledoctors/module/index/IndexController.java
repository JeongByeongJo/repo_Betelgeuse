   package com.bicycledoctors.module.index;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class IndexController {
	
	@Autowired
	IndexService service;

	@RequestMapping(value = "/xdm/indexXdm")
	public String xdmIndex() {
		return "xdm/index/index";
	}
	@RequestMapping(value = "/index")
	public String Home() {
		return "usr/index/home";
	}
	@RequestMapping(value = "/index/home-logined")
	public String homelogined(Model model, IndexVo vo, HttpSession httpSession) {
		vo.setSeq(httpSession.getAttribute("sessSeqUsr").toString());
		model.addAttribute("itemH", service.selectOneUserShopSeq(vo));
		return "usr/index/home-logined";
	}
	@RequestMapping(value = "/member/SigninUsrForm")
	public String signinUsrForm() {
		return "usr/member/SigninUsrForm";
	}
	@RequestMapping(value = "/member/signupUsrForm")
	public String signupUsrForm() {
		return "usr/member/SignupUsrForm";
	}
	@RequestMapping(value = "/member/passwordrecoveryUsrForm")
	public String passwordrecoveryUsrForm() {
		return "usr/member/PasswordrecoveryUsrForm";
	}
	
}
