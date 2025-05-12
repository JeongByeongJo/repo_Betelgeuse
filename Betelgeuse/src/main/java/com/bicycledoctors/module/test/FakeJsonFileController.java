package com.bicycledoctors.module.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bicycledoctors.module.shop.ShopDto;
import com.bicycledoctors.module.shop.ShopMarkerResponseDto;
import com.bicycledoctors.module.shop.ShopService;

@RestController
public class FakeJsonFileController {
	
	@Autowired
	ShopService shopService;

	 @GetMapping(value = "/usr/template/Finder/assets/json/map-real-estate.json", produces = MediaType.APPLICATION_JSON_VALUE)
	    public List<ShopMarkerResponseDto> getShopMarkers() {
	        // 필요한 DTO 변환
	        List<ShopDto> shops = shopService.selectList4Marker(new ShopDto());
	        
	        return shops.stream()
	                .map(shop -> new ShopMarkerResponseDto(
	                        shop.getUserCustomer_seq(),
	                        shop.getShopSeq(),
	                        shop.getPath(),
	                        shop.getShopName(),
	                        shop.getShopTel(),
	                        shop.getShopAddress1(), // 주소 조합 필요 시
	                        shop.getShopLatitude(),
	                        shop.getShopLongitude()
	                ))
	                .toList();
	    }
	
}
