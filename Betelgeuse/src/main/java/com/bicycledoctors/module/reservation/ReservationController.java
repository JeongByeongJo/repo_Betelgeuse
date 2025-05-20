package com.bicycledoctors.module.reservation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bicycledoctors.module.shop.ShopAvailableServiceDto;
import com.bicycledoctors.module.shop.ShopAvailableServicesDto;

@Controller
public class ReservationController {

	@Autowired
	ReservationService service;
	
	@RequestMapping(value = "/shop/shopResrvInst")
	public String shopResrvInst(Model model, ReservationVo vo, ShopAvailableServicesDto listAS) {
		List<ShopAvailableServiceDto> dtoList = new ArrayList<>();
		service.insert(vo);
		if (listAS.getAvailableServiceCd() != null && !listAS.getAvailableServiceCd().isEmpty()) {
			for (Integer code : listAS.getAvailableServiceCd()) {
				ShopAvailableServiceDto availableServiceDto = new ShopAvailableServiceDto();
				availableServiceDto.setShopSeq(listAS.getShopSeq());
				availableServiceDto.setAvailableServiceCd(code);
				availableServiceDto.setRsrvSeq(vo.getRsrvSeq());
				dtoList.add(availableServiceDto);
			}
		}
		service.rsrvServicesInst(dtoList);
		return "redirect:/member/userBicycleUsrList";
	}
}
