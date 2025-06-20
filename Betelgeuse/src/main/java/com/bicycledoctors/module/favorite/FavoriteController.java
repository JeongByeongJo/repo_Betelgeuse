package com.bicycledoctors.module.favorite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FavoriteController {

	@Autowired
	FavoriteService service;
	
	@RequestMapping(value = "/favorite/favorUeleAll")
	public String favorUeleAll(FavoriteDto dto) {
		service.ueleteAll(dto);
		return "redirect:/member/userFavorite";
	}
	
}
