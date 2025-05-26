package com.bicycledoctors.module.insRep;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class InsRepController {

	@Autowired
	InsRepService service;
	
	@RequestMapping(value = "/shop/InsRepUsrInst")
	public String InsRepUsrInst(InsRepDto dto, Model model) {
		service.insert(dto);
		return "redirect:/member/shopUsrServiceAdmin";
	}
}
