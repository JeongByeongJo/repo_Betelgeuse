package com.bicycledoctors.module.bicycle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bicycledoctors.common.base.BaseController;
import com.bicycledoctors.module.code.CodeDto;

import jakarta.servlet.http.HttpSession;


@Controller
public class BicycleController extends BaseController{
	
	@Autowired
	BicycleService bicycleService;
	
	@RequestMapping(value = "/bicycle/bicycleXdmList")
	public String bicycleXdmList(Model model, BicycleVo vo) {
		
		utildatetime(vo);
		
		vo.setParamsPaging(bicycleService.selectOneCount(vo));
		
		model.addAttribute("list", bicycleService.selectList(vo));
		model.addAttribute("vo", vo);
		
		return "xdm/bicycle/BicycleXdmList";
	}
	
	@RequestMapping(value = "/bicycle/bicycleUsrForm")
	public String bicycleUsrForm(BicycleDto dto, HttpSession httpSession) {
		return "usr/bicycle/BicycleUsrForm";
	}
	
	@RequestMapping(value = "/bicycle/bicycleUsrInst")
	public String bicycleUsrInst(BicycleDto dto, HttpSession httpSession) {
		dto.setUserCustomer_seq((String)httpSession.getAttribute("sessSeqUsr"));
		bicycleService.insert(dto);
		return "redirect:/index";
	}

}
