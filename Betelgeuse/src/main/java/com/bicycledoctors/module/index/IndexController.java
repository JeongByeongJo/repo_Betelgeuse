   package com.bicycledoctors.module.index;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bicycledoctors.common.base.BaseController;
import com.bicycledoctors.module.bicycle.BicycleService;
import com.bicycledoctors.module.bicycle.BicycleVo;
import com.bicycledoctors.module.member.MemberService;
import com.bicycledoctors.module.member.MemberVo;
import com.bicycledoctors.module.reservation.ReservationService;
import com.bicycledoctors.module.reservation.ReservationVo;
import com.bicycledoctors.module.shop.ShopVo;

import jakarta.servlet.http.HttpSession;

@Controller
public class IndexController extends BaseController {
	
	@Autowired
	IndexService service;

	@Autowired
	MemberService memberService;
	
	@Autowired
	BicycleService bicycleService;
	
	@Autowired
	ReservationService reservationService;
	
	@RequestMapping(value = "/xdm/indexXdm")
	public String xdmIndex(Model model, MemberVo memberVo, BicycleVo bicycleVo, ReservationVo reservationVo) {
		model.addAttribute("member", memberService.selectOneCount(memberVo));
		model.addAttribute("bicycle", bicycleService.selectOneCount(bicycleVo));
		model.addAttribute("reservation", reservationService.selectOneCount(reservationVo));
		return "xdm/index/index";
	}
	@RequestMapping(value = "/index")
	public String Home() {
		return "usr/index/home";
	}
	@RequestMapping(value = "/index/homeUsr")
	public String homelogined(Model model, IndexVo vo, @ModelAttribute ShopVo shopVo, HttpSession httpSession) {
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
