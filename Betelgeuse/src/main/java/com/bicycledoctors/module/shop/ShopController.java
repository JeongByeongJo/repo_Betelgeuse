package com.bicycledoctors.module.shop;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bicycledoctors.common.base.BaseController;
import com.bicycledoctors.common.base.BaseDto;
import com.bicycledoctors.module.index.IndexService;
import com.bicycledoctors.module.index.IndexVo;

import jakarta.servlet.http.HttpSession;

@Controller
public class ShopController extends BaseController {


	@Autowired
	ShopService service;
	
	@Autowired
	IndexService indexService;

	
	@RequestMapping(value = "/shop/shopUsrList")
	public String shopUsrList(Model model, IndexVo vo, ShopDto dto, HttpSession httpSession) {
		vo.setSeq(httpSession.getAttribute("sessSeqUsr").toString());
		model.addAttribute("itemH", indexService.selectOneUserShopSeq(vo));
		
		List<ShopDto> shopList = service.selectList(dto);  // 가게 정보 리스트
		List<BaseDto> picList = service.selectOneList4Pic(dto);  // 이미지 정보 리스트

		// 각 가게에 해당하는 이미지들만 매칭하여 picList에 할당합니다.
		for (ShopDto shop : shopList) {
		    List<BaseDto> matchedPics = picList.stream()
		        .filter(pic -> pic.getPseq().equals(shop.getShopSeq())) // shopSeq와 pSeq가 일치하는 것만 찾기
		        .collect(Collectors.toList());
		    
		    shop.setPicList(matchedPics); // ShopDto에 picList 필드를 추가하여 연결
		}

		model.addAttribute("list", shopList);  // 가게 정보 리스트
		model.addAttribute("listPic", picList);  // 이미지 정보 리스트 (혹시 필요하다면)
		
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
	public String shopaddservicesUsrForm(Model model, ShopDto dto, HttpSession httpSession, ShopAvailableServiceDto shopAvailableServiceDto, ShopBikeBrandDto shopBikeBrandDto, ShopWheelBrandDto shopWheelBrandDto) throws Exception {
		dto.setSeq(httpSession.getAttribute("sessSeqUsr").toString());
		shopAvailableServiceDto.setSeq(httpSession.getAttribute("sessSeqUsr").toString());
		shopBikeBrandDto.setSeq(httpSession.getAttribute("sessSeqUsr").toString());
		shopWheelBrandDto.setSeq(httpSession.getAttribute("sessSeqUsr").toString());
		model.addAttribute("item", service.selectOne4ShopService(dto));
		model.addAttribute("lists", service.selectShopServiceCd(shopAvailableServiceDto));
		model.addAttribute("listb", service.selectShopBrandCd(shopBikeBrandDto));
		model.addAttribute("listw", service.selectShopWBrandCd(shopWheelBrandDto));
		return "usr/shop/ShopaddservicesUsrForm";
	}
	@RequestMapping(value = "/shop/shopaddprofileUsrForm")
	public String shopaddprofileUsrForm(@ModelAttribute ShopAvailableServicesDto dtos,@ModelAttribute ShopBikeBrandsDto bbdtos,@ModelAttribute ShopWheelBrandsDto wbdtos,Model model, ShopDto dto, HttpSession httpSession) throws Exception {
		dto.setSeq(httpSession.getAttribute("sessSeqUsr").toString());
		List<ShopAvailableServiceDto> dtoList = new ArrayList<>();
		List<ShopBikeBrandDto> bbdtoList = new ArrayList<>();
		List<ShopWheelBrandDto> wbdtoList = new ArrayList<>();
		
		// [1] availableServiceCd 목록 처리
	    if (dtos.getAvailableServiceCd() != null && !dtos.getAvailableServiceCd().isEmpty()) {
	        for (Integer code : dtos.getAvailableServiceCd()) {
	            ShopAvailableServiceDto availableServiceDto = new ShopAvailableServiceDto();
	            availableServiceDto.setShopSeq(dtos.getShopSeq());
	            availableServiceDto.setAvailableServiceCd(code);
	            dtoList.add(availableServiceDto);
	        }
	    }

	    // [2] bikeBrandCd 목록 처리
	    if (bbdtos.getBikeBrandCd() != null && !bbdtos.getBikeBrandCd().isEmpty()) {
	        for (Integer code : bbdtos.getBikeBrandCd()) {
	            ShopBikeBrandDto bikeBrandDto = new ShopBikeBrandDto();
	            bikeBrandDto.setShopSeq(bbdtos.getShopSeq());
	            bikeBrandDto.setBikeBrandCd(code);
	            bbdtoList.add(bikeBrandDto);
	        }
	    }
	    // [2] bikeBrandCd 목록 처리
	    if (wbdtos.getWheelBrandCd() != null && !wbdtos.getWheelBrandCd().isEmpty()) {
	    	for (Integer code : wbdtos.getWheelBrandCd()) {
	    		ShopWheelBrandDto shopWheelBrandDto = new ShopWheelBrandDto();
	    		shopWheelBrandDto.setShopSeq(wbdtos.getShopSeq());
	    		shopWheelBrandDto.setWheelBrandCd(code);
	    		wbdtoList.add(shopWheelBrandDto);
	    	}
	    }

	    // [3] insertAvailableServices 호출 (있을 때만)
	    if (!dtoList.isEmpty()) {
	        service.insertAvailableServices(dtoList, dto);
	    } else {
	    	service.deleteAS(dto);
	    }

	    // [4] insertHandlingBicycleBrands 호출 (있을 때만)
	    if (!bbdtoList.isEmpty()) {
	        service.insertHandlingBicycleBrands(bbdtoList, dto);
	    } else {
	    	service.deleteBB(dto);
	    }
	 
	    // [4] insertHandlingBicycleBrands 호출 (있을 때만)
	    if (!wbdtoList.isEmpty()) {
	    	service.insertHandlingWheelBrands(wbdtoList, dto);
	    } else {
	    	service.deleteWB(dto);
	    }
	    service.update1(dto);
		model.addAttribute("item", service.selectOne4ShopProfile(dto));

	    System.out.println("아랄랄" + dto.getUserCustomer_seq());

		return "usr/shop/ShopaddprofileUsrForm";
	}
	@RequestMapping(value = "/shop/shopaddhoursUsrForm")
	public String shopaddhoursUsrForm(Model model, ShopDto dto, HttpSession httpSession) throws Exception {
		service.update2(dto);
		dto.setSeq(httpSession.getAttribute("sessSeqUsr").toString());
	    System.out.println(dto.getShopSeq());
		model.addAttribute("item", service.selectOne4Hour(dto));

		return "usr/shop/ShopaddhoursUsrForm";
	}
	@RequestMapping(value = "/shop/shopaddpicUsrForm")
	public String shopaddpicUsrForm(Model model, ShopDto dto, HttpSession httpSession) {
		service.update3(dto);
		dto.setSeq(httpSession.getAttribute("sessSeqUsr").toString());
		model.addAttribute("item", service.selectOne4Pic(dto));
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
	@RequestMapping(value = "/shop/shopaddpicUsrUpdt")
	public String shopaddpicUsrUpdt(ShopDto dto, Model model) throws Exception {
		service.update4(dto);
		return "redirect:/index/home-logined";
	}
}
