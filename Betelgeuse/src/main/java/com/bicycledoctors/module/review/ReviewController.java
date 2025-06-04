package com.bicycledoctors.module.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bicycledoctors.common.base.BaseController;
import com.bicycledoctors.module.shop.ShopVo;

import jakarta.servlet.http.HttpSession;

@Controller
public class ReviewController extends BaseController{

	@Autowired
	ReviewService service;
	
	@RequestMapping(value="/review/reviewUsrInst")
	public String reviewUsrInst(ReviewDto dto, ShopVo vo) {
		service.insert(dto);
		String shopSeq = dto.getShop_shopSeq();
		return "redirect:/shop/shopUsrView?shopSeq=" + shopSeq;
	}
	@RequestMapping(value="/review/reviewUsrList")
	public String reviewUsrList(ReviewDto dto, Model model, HttpSession httpSession) {
		dto.setSeq((String)httpSession.getAttribute("sessSeqUsr"));
		
		return "usr/member/account-reviews";
	}
	
}
