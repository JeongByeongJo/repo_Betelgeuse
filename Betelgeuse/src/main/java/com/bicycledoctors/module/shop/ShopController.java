package com.bicycledoctors.module.shop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShopController {

	
	@RequestMapping(value = "/shop/shopUsrList")
	public String shopUsrList() {
		return "usr/shop/ShopUsrList";
	}
	@RequestMapping(value = "/shop/shopUsrView")
	public String shopUsrView() {
		return "usr/shop/ShopUsrView";
	}
	@RequestMapping(value = "/shop/shopaddlocationUsrForm")
	public String shopaddlocationUsrForm() {
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
}
