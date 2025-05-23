package com.bicycledoctors.module.bicycle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bicycledoctors.common.base.BaseController;
import com.bicycledoctors.module.index.IndexService;
import com.bicycledoctors.module.index.IndexVo;

import jakarta.servlet.http.HttpSession;


@Controller
public class BicycleController extends BaseController{
	
	@Autowired
	BicycleService bicycleService;
	
	@Autowired
	IndexService indexService;
	
	@RequestMapping(value = "/bicycle/bicycleXdmList")
	public String bicycleXdmList(Model model, BicycleVo vo) {
		
		utildatetime(vo);
		
		vo.setParamsPaging(bicycleService.selectOneCount(vo));
		
		model.addAttribute("list", bicycleService.selectList(vo));
		model.addAttribute("vo", vo);
		
		return "xdm/bicycle/BicycleXdmList";
	}
	@RequestMapping(value = "/bicycle/bicycleXdmView")
	public String bicycleXdmView(Model model, BicycleVo vo) {
		
		model.addAttribute("item", bicycleService.selectOne(vo));
		
		return "xdm/bicycle/BicycleXdmView";
	}
	
	@RequestMapping(value = "/bicycle/bicycleUsrForm")
	public String bicycleUsrForm(IndexVo vo, Model model, HttpSession httpSession) {
		vo.setSeq(httpSession.getAttribute("sessSeqUsr").toString());
		model.addAttribute("itemH", indexService.selectOneUserShopSeq(vo));
		indexService.selectOneUserShopSeq(vo);
		System.out.println("자전거 등록 들어올때 dto.getUserCustomer_seq(): " + vo.getUserCustomer_seq());

		return "usr/bicycle/BicycleUsrForm";
	}
	@RequestMapping(value = "/bicycle/bicycleUsrMfom")
	public String bicycleUsrMfom(BicycleDto dto, Model model) {
		model.addAttribute("item", bicycleService.selectOne(dto));
		model.addAttribute("list", bicycleService.selectOnePicList(dto));
		
		return "usr/bicycle/BicycleUsrMfom";
	}
	
	@RequestMapping(value = "/bicycle/bicycleUsrInst")
	public String bicycleUsrInst(BicycleDto dto, HttpSession httpSession) throws Exception {
		dto.setUserCustomer_seq((String)httpSession.getAttribute("sessSeqUsr"));
		bicycleService.insert(dto);
		return "redirect:/index/home-logined";
	}
	@RequestMapping(value = "/bicycle/bicycleUsrUpdt")
	public String bicycleUsrUpdt(BicycleDto dto) throws Exception {
		bicycleService.update(dto);
		return "redirect:/member/userBicycleUsrList";
	}

}
