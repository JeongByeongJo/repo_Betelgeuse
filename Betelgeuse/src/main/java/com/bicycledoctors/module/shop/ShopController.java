package com.bicycledoctors.module.shop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bicycledoctors.common.base.BaseController;
import com.bicycledoctors.module.index.IndexService;
import com.bicycledoctors.module.index.IndexVo;

import jakarta.servlet.http.HttpSession;

@Controller
public class ShopController extends BaseController{


	@Autowired
	ShopService service;
	
	@Autowired
	IndexService indexService;

	
	@RequestMapping(value = "/shop/shopUsrList")
	public String shopUsrList(Model model, IndexVo vo, HttpSession httpSession) {
		vo.setSeq(httpSession.getAttribute("sessSeqUsr").toString());
		model.addAttribute("itemH", indexService.selectOneUserShopSeq(vo));
		return "usr/shop/ShopUsrList";
	}
	@RequestMapping(value = "/shop/shopUsrView")
	public String shopUsrView() {
		return "usr/shop/ShopUsrView";
	}
	@RequestMapping(value = "/shop/shopaddlocationUsrForm")
	public String shopaddlocationUsrForm(Model model, ShopDto dto, IndexVo vo, HttpSession httpSession) {
		vo.setSeq(httpSession.getAttribute("sessSeqUsr").toString());
		model.addAttribute("itemH", indexService.selectOneUserShopSeq(vo));
		indexService.selectOneUserShopSeq(vo);
		if (dto.getUserCustomer_seq().equals("") || dto.getUserCustomer_seq().equals("0")) {
//			insert mode
			dto.setSeq(httpSession.getAttribute("sessSeqUsr").toString());

		} else {
//			update mode
			model.addAttribute("item", service.selectOne4ShopLocation(dto));
		}
		
		return "usr/shop/ShopaddlocationUsrForm";
	}
	@RequestMapping(value = "/shop/shopaddservicesUsrForm")
	public String shopaddservicesUsrForm(Model model, ShopDto dto, HttpSession httpSession, ShopAvailableServiceDto shopAvailableServiceDto, ShopBikeBrandDto shopBikeBrandDto) {
		dto.setSeq(httpSession.getAttribute("sessSeqUsr").toString());
		shopAvailableServiceDto.setSeq(httpSession.getAttribute("sessSeqUsr").toString());
		shopBikeBrandDto.setSeq(httpSession.getAttribute("sessSeqUsr").toString());
		model.addAttribute("item", service.selectOne4ShopService(dto));
		model.addAttribute("lists", service.selectShopServiceCd(shopAvailableServiceDto));
		model.addAttribute("listb", service.selectShopBrandCd(shopBikeBrandDto));
		return "usr/shop/ShopaddservicesUsrForm";
	}
	@RequestMapping(value = "/shop/shopaddprofileUsrForm")
	public String shopaddprofileUsrForm(@ModelAttribute ShopAvailableServicesDto dtos,@ModelAttribute ShopBikeBrandsDto bbdtos, ShopDto Dto) {
		 List<ShopAvailableServiceDto> dtoList = new ArrayList<>();
		 List<ShopBikeBrandDto> bbdtoList = new ArrayList<>();
		 
		for (Integer code : dtos.getAvailableServiceCd()) {
			ShopAvailableServiceDto dto = new ShopAvailableServiceDto();
	        dto.setShopSeq(dtos.getShopSeq());
	        dto.setAvailableServiceCd(code);
	        dtoList.add(dto);
	    }
		for (Integer code : bbdtos.getBikeBrandCd()) {
			ShopBikeBrandDto dto = new ShopBikeBrandDto();
			dto.setShopSeq(bbdtos.getShopSeq());
			dto.setBikeBrandCd(code);
			bbdtoList.add(dto);
		}
		
		service.insertAvailableServices(dtoList, Dto);
		service.insertHandlingBicycleBrands(bbdtoList, Dto);
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
	public String shopaddlocationUsrInst(ShopDto dto, Model model, ShopDto vo) {
		service.insert(dto);
		model.addAttribute("item", service.selectOne4ShopLocation(vo));
		return "redirect:/shop/shopaddservicesUsrForm";
	}
	@RequestMapping(value = "/shop/shopaddlocationUsrUpdt")
	public String shopaddlocationUsrUpdt(ShopDto dto, Model model) {
		service.update(dto);
		return "redirect:/shop/shopaddservicesUsrForm";
	}
}
