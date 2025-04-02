package com.bicycledoctors.module.index;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping(value = "/xdm/indexXdm")
	public String xdmIndex() {
		return "xdm/index/index";
	}
	@RequestMapping(value = "/index")
	public String Home() {
		return "usr/index/home";
	}
	@RequestMapping(value = "/index/home-logined")
	public String homelogined() {
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
