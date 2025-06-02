package com.bicycledoctors.module.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bicycledoctors.common.base.BaseController;

@Controller
public class ReviewController extends BaseController{

	@Autowired
	ReviewService service;
	
	@RequestMapping(value="/review/reviewUsrInst")
	public String reviewUsrInst(ReviewDto dto) {
		service.insert(dto);
		return "redirect:/shop/shopUsrView";
	}
	
}
