package com.bicycledoctors.module.review;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bicycledoctors.common.base.BaseController;
import com.bicycledoctors.module.index.IndexService;
import com.bicycledoctors.module.index.IndexVo;
import com.bicycledoctors.module.shop.ShopVo;

import jakarta.servlet.http.HttpSession;

@Controller
public class ReviewController extends BaseController{

	@Autowired
	ReviewService service;
	
	@Autowired
	IndexService indexService;
	
	@RequestMapping(value="/review/reviewUsrInst")
	public String reviewUsrInst(ReviewDto dto, ShopVo vo) {
		service.insert(dto);
		String shopSeq = dto.getShop_shopSeq();
		return "redirect:/shop/shopUsrView?shopSeq=" + shopSeq;
	}
	@RequestMapping(value="/review/reviewUsrUpdt")
	public String reviewUsrUpdt(ReviewDto dto) {
		service.update(dto);
		return "redirect:/review/reviewUsrList";
	}
	@RequestMapping(value="/review/reviewUsrUele")
	public String reviewUsrUele(ReviewDto dto) {
		service.uelete(dto);
		return "redirect:/review/reviewUsrList";
	}
	@ResponseBody
	@RequestMapping(value="/review/reviewUsrOne")
	public Map<String, Object> reviewUsrOne(ReviewVo vo) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("revwSeq", service.selectOne(vo).getRevwSeq());
		returnMap.put("revwReviews", service.selectOne(vo).getRevwReviews());
		returnMap.put("revwRate", service.selectOne(vo).getRevwRate());
		return returnMap;
	}
	@RequestMapping(value="/review/reviewUsrList")
	public String reviewUsrList(@ModelAttribute("vo") ReviewVo vo, IndexVo indexVo, Model model, HttpSession httpSession) {
		vo.setSeq((String)httpSession.getAttribute("sessSeqUsr"));
		vo.setParamsPaging(service.selectOneCount4Shop(vo));
		indexVo.setSeq((String)httpSession.getAttribute("sessSeqUsr"));
		model.addAttribute("itemH", indexService.selectOneUserShopSeq(indexVo));
		model.addAttribute("list", service.selectListByUser(vo));
		return "usr/member/account-reviews";
	}
	@RequestMapping(value="/review/reviewXdmList")
	public String reviewXdmList(@ModelAttribute("vo") ReviewVo vo, Model model) {
		vo.setParamsPaging(service.selectOneCount(vo));
		model.addAttribute("list", service.selectList(vo));
		return "xdm/review/ReviewXdmList";
	}
	@RequestMapping(value="/review/reviewXdmMfom")
	public String reviewXdmMfom(@ModelAttribute("vo") ReviewVo vo, Model model) {
		model.addAttribute("item", service.selectOne(vo));
		return "xdm/review/ReviewXdmMfom";
	}
	@RequestMapping(value="/review/reviewXdmUele")
	public String reviewXdmUele(ReviewDto dto) {
		service.uelete(dto);
		return "redirect:/review/reviewXdmList";
	}
}
