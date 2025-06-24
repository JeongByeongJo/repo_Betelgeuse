package com.bicycledoctors.module.bicycle;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bicycledoctors.common.base.BaseController;
import com.bicycledoctors.module.code.CodeService;
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
		return "redirect:/index/homeUsr";
	}
	@RequestMapping(value = "/bicycle/bicycleUsrUpdt")
	public String bicycleUsrUpdt(BicycleDto dto) throws Exception {
		bicycleService.update(dto);
		return "redirect:/member/userBicycleUsrList";
	}
	@RequestMapping(value = "/bicycle/bicycleUsrUele")
	public String bicycleUsrUele(BicycleDto dto) throws Exception {
		bicycleService.uelete(dto);
		return "redirect:/member/userBicycleUsrList";
	}

	@ResponseBody
	@RequestMapping(value = "/bicycle/bicycleUsrProc")
	public Map<String, String> bicycleUsrProc(BicycleDto dto) throws Exception {

	    Map<String, String> result = new HashMap<>();

	    result.put("bicycleCateCdName", CodeService.selectOneCachedCode(dto.getBicycleCateCd()));
	    result.put("bicycleBrandCdName", CodeService.selectOneCachedCodeEng(dto.getBicycleBrandCd()));
	    result.put("drivetrainBrandCdName", CodeService.selectOneCachedCodeEng(dto.getDrivetrainBrandCd()));
	    result.put("brakeBrandCdName", CodeService.selectOneCachedCodeEng(dto.getBrakeBrandCd()));
	    result.put("wheelBrandCdName", CodeService.selectOneCachedCodeEng(dto.getWheelBrandCd()));
	    result.put("bicycleModel", dto.getBicycleModel());
	    result.put("bicycleYears", dto.getBicycleYears().toString());
	    result.put("bicycleMiles", dto.getBicycleMiles().toString());
	    result.put("bicycleName", dto.getBicycleName());
	    result.put("drivetrainModel", dto.getDrivetrainModel());
	    result.put("wheelModel", dto.getWheelModel());

	    return result;
	}

}
