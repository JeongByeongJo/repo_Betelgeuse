package com.bicycledoctors.module.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bicycledoctors.common.base.BaseController;
import com.bicycledoctors.module.index.IndexDto;
import com.bicycledoctors.module.index.IndexService;

import jakarta.servlet.http.HttpSession;

@Controller
public class ShopController extends BaseController{

	@Autowired
	ShopService service;
	
	@Autowired
	IndexService indexService;
	
	@RequestMapping(value = "/shop/shopUsrList")
	public String shopUsrList(Model model, IndexDto dto, HttpSession httpSession) {
		dto.setSeq(httpSession.getAttribute("sessSeqUsr").toString());
		model.addAttribute("itemH", indexService.selectOneUserShopSeq(dto));
		System.out.println("자전거 등록 들어올때 dto.getUserCustomer_seq(): " + dto.getUserCustomer_seq());

		return "usr/shop/ShopUsrList";
	}
	@RequestMapping(value = "/shop/shopUsrView")
	public String shopUsrView() {
		return "usr/shop/ShopUsrView";
	}
	@RequestMapping(value = "/shop/shopaddlocationUsrForm")
	public String shopaddlocationUsrForm(Model model, ShopDto vo, HttpSession httpSession) {
		System.out.println("매장등록 들어올때 vo.getUserCustomer_seq(): " + vo.getUserCustomer_seq());
		if (vo.getUserCustomer_seq().equals("") || vo.getUserCustomer_seq().equals("0")) {
//			insert mode
			vo.setSeq(httpSession.getAttribute("sessSeqUsr").toString());

		} else {
//			update mode
			model.addAttribute("item", service.selectOne4ShopLocation(vo));
		}
		
		return "usr/shop/ShopaddlocationUsrForm";
	}
	@RequestMapping(value = "/shop/shopaddservicesUsrForm")
	public String shopaddservicesUsrForm() {
		return "usr/shop/ShopaddservicesUsrForm";
	}
	@RequestMapping(value = "/shop/shopaddprofileUsrForm")
	public String shopaddprofileUsrForm() {
		return "usr/shop/ShopaddprofileUsrForm";
	}
	@RequestMapping(value = "/shop/shopaddhoursUsrForm")
	public String shopaddhoursUsrForm() {
		return "usr/shop/ShopaddhoursUsrForm";
	}
	@RequestMapping(value = "/shop/shopaddpicUsrForm")
	public String shopaddpicUsrForm() {
		return "usr/shop/ShopaddpicUsrForm";
	}
	
	@RequestMapping(value = "/shop/shopaddlocationUsrInst")
	public String shopaddlocationUsrInst(ShopDto dto) {
		service.insert(dto);
		return "redirect:/shop/shopaddservicesUsrForm";
	}
	@RequestMapping(value = "/shop/shopaddlocationUsrUpdt")
	public String shopaddlocationUsrUpdt(ShopDto dto) {
		service.update(dto);
		return "redirect:/shop/shopaddservicesUsrForm";
	}
}
