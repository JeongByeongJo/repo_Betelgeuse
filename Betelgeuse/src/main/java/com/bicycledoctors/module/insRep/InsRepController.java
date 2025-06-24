package com.bicycledoctors.module.insRep;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bicycledoctors.common.base.BaseController;


@Controller
public class InsRepController extends BaseController{

	@Autowired
	InsRepService service;
	
	@RequestMapping(value = "/inr/InsRepUsrInst")
	public String InsRepUsrInst(InsRepDto dto, Model model) {
		service.insert(dto);
		return "redirect:/member/shopUsrServiceAdmin";
	}
	@RequestMapping(value = "/inr/InsRepUsrUpdt")
	public String InsRepUsrUpdt(InsRepDto dto, Model model) {
		service.update(dto);
		return "redirect:/member/shopUsrServiceAdmin";
	}
	@RequestMapping(value = "/inr/InsRepUsrCompl")
	public String InsRepUsrCompl(InsRepDto dto, Model model) {
		service.inrComplete(dto);
		service.inrCompleteBike(dto);
		return "redirect:/member/shopUsrServiceAdmin";
	}
}
