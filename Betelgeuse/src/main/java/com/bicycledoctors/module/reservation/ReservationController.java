package com.bicycledoctors.module.reservation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bicycledoctors.common.base.BaseController;
import com.bicycledoctors.module.insRep.InsRepService;
import com.bicycledoctors.module.insRep.InsRepVo;
import com.bicycledoctors.module.shop.ShopAvailableServiceDto;
import com.bicycledoctors.module.shop.ShopAvailableServicesDto;

@Controller
public class ReservationController extends BaseController {

	@Autowired
	ReservationService service;
	
	@Autowired
	InsRepService insRepService;
	
	
	@RequestMapping(value = "/reservation/reservationXdmList")
	public String reservationXdmList(Model model,@ModelAttribute("vo") ReservationVo vo) {
		utildatetime(vo);
		vo.setParamsPaging(service.selectOneCount(vo));
		
		model.addAttribute("list", service.selectList(vo));
		return "xdm/reservation/ReservationXdmList";
	}
	
	@RequestMapping(value = "/reservation/reservationXdmMfom")
	public String reservationXdmMfom(Model model, ReservationVo vo) {
		model.addAttribute("item", service.selectOne(vo));
		return "xdm/reservation/ReservationXdmMfom";
	}
	
	@RequestMapping(value = "/reservation/reservationXdmUpdt")
	public String reservationXdmUpdt(ReservationDto dto) {
		service.rsrvUpdt(dto);
		return "redirect:/reservation/reservationXdmList";
	}
	
	@RequestMapping(value = "/shop/shopResrvInst")
	public String shopResrvInst(Model model, ReservationDto dto, ShopAvailableServicesDto listAS) {
		List<ShopAvailableServiceDto> dtoList = new ArrayList<>();
		service.insert(dto);
		if (listAS.getReservServicesCd() != null && !listAS.getReservServicesCd().isEmpty()) {
			for (Integer code : listAS.getReservServicesCd()) {
				ShopAvailableServiceDto availableServiceDto = new ShopAvailableServiceDto();
				availableServiceDto.setShopSeq(listAS.getShopSeq());
				availableServiceDto.setReservServicesCd(code);
				availableServiceDto.setRsrvSeq(dto.getRsrvSeq());
				dtoList.add(availableServiceDto);
			}
		}
		service.rsrvServicesInst(dtoList);
		return "redirect:/member/userBicycleUsrList";
	}

	@RequestMapping(value = "/shop/resrvUsrViewProc")
	public String resrvUsrViewProc(Model model, ReservationVo vo) {
		model.addAttribute("view", service.selectOne4View(vo));
		model.addAttribute("serviceList", service.selectList4ServiceView(vo));
		return "usr/member/ServiceAdministration :: modalContent";
	}
	@RequestMapping(value = "/shop/InRUsrForm")
	public String inRUsrform(Model model, ReservationVo vo, InsRepVo insRepVo) {
		if(service.selectOne4InR(vo) == null) {
			model.addAttribute("item", service.selectOne4View(vo));
			return "usr/shop/InRUsrForm";
		} else {
			model.addAttribute("item", service.selectOne4View(vo));
			model.addAttribute("itemR", insRepService.selectOne(insRepVo));
			return "usr/shop/InRUsrMfom";
		}
	}

	@ResponseBody
	@RequestMapping(value = "/shop/resrvUsrProc")
	public void resrvUsrProc(ReservationDto dto) {
		if (dto.getBikeStatus() == 122) {
			service.rsrvYesUpdt(dto);
		} else {
			service.rsrvNoUpdt(dto);
		}
	}
}
