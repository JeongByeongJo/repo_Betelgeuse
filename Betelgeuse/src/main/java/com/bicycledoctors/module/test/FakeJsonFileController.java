package com.bicycledoctors.module.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import com.bicycledoctors.module.shop.ShopDto;
import com.bicycledoctors.module.shop.ShopMarkerResponseDto;
import com.bicycledoctors.module.shop.ShopService;
import com.bicycledoctors.module.shop.ShopVo;

@RestController
public class FakeJsonFileController {
	
	@Autowired
	ShopService shopService;
	
	@GetMapping(value = "/map-real-estate.json", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ShopMarkerResponseDto> getShopMarkers(@ModelAttribute ShopVo shopVo) {
		shopVo.setShValue(shopVo.getShValue());
		shopVo.setShOption(shopVo.getShOption());
		System.out.println("shopVo.getShValue(): " + shopVo.getShValue());
		System.out.println("shopVo.getShOption(): " + shopVo.getShOption());
		List<ShopDto> shops = shopService.selectList4Marker(shopVo);
		
		return shops.stream()
		        .map(shop -> new ShopMarkerResponseDto(
		                shop.getUserCustomer_seq(),
		                shop.getShopSeq(),
		                shop.getPath(),
		                shop.getShopName(),
		                shop.getShopTel(),
		                shop.getShopAddress1(),
		                shop.getShopLatitude(),
		                shop.getShopLongitude()
		        ))
		        .toList();
	}
	
}
