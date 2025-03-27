package com.bicycledoctors.module.index;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping(value = "/index/Home")
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
	@RequestMapping(value = "/member/SignupUsrForm")
	public String SignupUsrForm() {
		return "usr/member/SignupUsrForm";
	}
}
