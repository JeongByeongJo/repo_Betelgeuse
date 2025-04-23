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
	@RequestMapping(value = "/bicycle/bicycleXdmView")
	public String bicycleXdmView(Model model, BicycleVo vo) {
		
		model.addAttribute("item", bicycleService.selectOne(vo));
		
		return "xdm/bicycle/BicycleXdmView";
	}
	
	@RequestMapping(value = "/bicycle/bicycleUsrForm")
	public String bicycleUsrForm(BicycleDto dto, Model model, HttpSession httpSession) {
		
		return "usr/bicycle/BicycleUsrForm";
	}
	@RequestMapping(value = "/bicycle/bicycleUsrMfom")
	public String bicycleUsrMfom(BicycleDto dto, Model model, HttpSession httpSession) {
		model.addAttribute("item", bicycleService.selectOne(dto));
		
		return "usr/bicycle/BicycleUsrMfom";
	}
	
	@RequestMapping(value = "/bicycle/bicycleUsrInst")
	public String bicycleUsrInst(BicycleDto dto, HttpSession httpSession) throws Exception {
		dto.setUserCustomer_seq((String)httpSession.getAttribute("sessSeqUsr"));
		bicycleService.insert(dto);
		return "redirect:/index/home-logined";
	}
	@RequestMapping(value = "/bicycle/bicycleUsrUpdt")
	public String bicycleUsrUpdt(BicycleDto dto) {
		bicycleService.update(dto);
		return "redirect:/index/home-logined";
	}

}
