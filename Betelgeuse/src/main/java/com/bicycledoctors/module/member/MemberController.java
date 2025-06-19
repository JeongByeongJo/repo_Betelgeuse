package com.bicycledoctors.module.member;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.bicycledoctors.common.base.BaseController;
import com.bicycledoctors.common.base.BaseDto;
import com.bicycledoctors.common.util.UtilDateTime;
import com.bicycledoctors.module.bicycle.BicycleDto;
import com.bicycledoctors.module.bicycle.BicycleService;
import com.bicycledoctors.module.index.IndexService;
import com.bicycledoctors.module.index.IndexVo;
import com.bicycledoctors.module.mail.MailService;
import com.bicycledoctors.module.reservation.ReservationService;
import com.bicycledoctors.module.reservation.ReservationVo;
import com.bicycledoctors.module.shop.ShopDto;
import com.bicycledoctors.module.shop.ShopService;
import com.bicycledoctors.module.shop.ShopVo;
import com.fasterxml.jackson.core.JsonProcessingException;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@Controller
public class MemberController extends BaseController {

	
	@Autowired
	MemberService service;
	
	@Autowired
	IndexService indexService;
	
	@Autowired
	MailService mailService;
	
	@Autowired
	BicycleService bicycleService;
	
	@Autowired
	ReservationService reservationService;
	
	@Autowired
	ShopService shopService;
	
	@RequestMapping(value = "/member/memberXdmList")
	public String memberXdmList(MemberVo vo, Model model) {
		utildatetime(vo);
		
		vo.setParamsPaging(service.selectOneCount(vo));
		
		model.addAttribute("list", service.selectList(vo));
		model.addAttribute("vo", vo);
		return "xdm/member/MemberXdmList";
	}
	
	@RequestMapping(value = "/member/memberXdmMfom")
	public String memberXdmMfom(Model model, MemberDto memberDto) {
		model.addAttribute("item", service.selectOne(memberDto));
		return "xdm/member/MemberXdmMfom";
	}
	
	@RequestMapping(value = "/member/memberXdmUpdt")
	public String memberXdmUpdt(MemberDto memberDto) {
		service.update(memberDto);
		return "redirect:/member/memberXdmList";
	}
	
	@RequestMapping(value = "/member/signinXdmForm")
	public String signinXdmForm(MemberVo vo, HttpSession httpSession) {		
		return "xdm/member/SigninXdmForm";
	}
	
	@ResponseBody
	@RequestMapping(value = "/member/signinXdmProc")
	public Map<String, Object> signinXdmProc(MemberDto dto, HttpSession httpSession) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		MemberDto rtMember = service.selectOneIdChk(dto);		
		
		if(rtMember != null) {
			returnMap.put("rt", "success");
			httpSession.setMaxInactiveInterval(60 * 30); 						// 60second * 30 = 30minute
			httpSession.setAttribute("sessSeqXdm", rtMember.getSeq());
			httpSession.setAttribute("sessIdXdm", rtMember.getUserId());
			httpSession.setAttribute("sessNameXdm", rtMember.getUserName());
		} else {
			returnMap.put("rt", "fail");
		}
		return returnMap;
	}

	@ResponseBody
	@RequestMapping(value = "/member/signoutXdmProc")
	public Map<String, Object> signoutXdmProc(HttpSession httpSession) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		httpSession.setAttribute("sessSeqXdm", null);
		httpSession.setAttribute("sessIdXdm", null);
		httpSession.setAttribute("sessNameXdm", null);
		returnMap.put("rt", "success");
		return returnMap;
	}
	
	
	@RequestMapping(value = "/member/memberUsrUele")
	public String memberUsrUele(MemberDto memberDto, HttpSession httpSession) {
		memberDto.setSeq((String)httpSession.getAttribute("sessSeqUsr"));
		service.uelete(memberDto);
		return "redirect:/member/signinUsrForm";
	}
	
	@RequestMapping(value = "/member/memberUsrInst")
	public String memberUsrInst(MemberDto memberDto) {
		memberDto.setUserPassword(encodeBcrypt(memberDto.getUserPassword(), 10));
		service.insert(memberDto);
		
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					mailService.sendMailWelcome(memberDto);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		thread.start();
		
		return "redirect:/member/signinUsrForm";
	}
	
	@ResponseBody
	@RequestMapping(value = "/member/signinUsrProc")
	public Map<String, Object> signinUsrProc(MemberDto dto, HttpSession httpSession) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		MemberDto rtMemberId = service.selectOneId(dto);
		if(Integer.valueOf(rtMemberId.getSeq()) > 11) {
			if(rtMemberId != null && matchesBcrypt(dto.getUserPassword(), rtMemberId.getUserPassword(), 10)) {
				returnMap.put("rt", "success");
				httpSession.setMaxInactiveInterval(60 * 30); 						// 60second * 30 = 30minute
				httpSession.setAttribute("sessSeqUsr", rtMemberId.getSeq());
				httpSession.setAttribute("sessIdUsr", rtMemberId.getUserId());
				httpSession.setAttribute("sessNameUsr", rtMemberId.getUserName());
				httpSession.setAttribute("sessEmailUsr", rtMemberId.getUserEmail());
				httpSession.setAttribute("sessCateUsr", rtMemberId.getUserCate());
			} else {
				returnMap.put("rt", "fail");
			}
		} else {
			MemberDto rtMember = service.selectOneIdChk(dto);
			
			if(rtMember != null) {
				returnMap.put("rt", "success");
				httpSession.setMaxInactiveInterval(60 * 30); 						// 60second * 30 = 30minute
				httpSession.setAttribute("sessSeqUsr", rtMember.getSeq());
				httpSession.setAttribute("sessIdUsr", rtMember.getUserId());
				httpSession.setAttribute("sessNameUsr", rtMember.getUserName());
				httpSession.setAttribute("sessEmailUsr", rtMemberId.getUserEmail());
				httpSession.setAttribute("sessCateUsr", rtMemberId.getUserCate());
			} else {
				returnMap.put("rt", "fail");
			}
		}
		return returnMap;
	}
	
	@ResponseBody
	@RequestMapping(value = "/member/signoutUsrProc")
	public Map<String, Object> signoutUsrProc(HttpSession httpSession) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		httpSession.setAttribute("sessSeqUsr", null);
		httpSession.setAttribute("sessIdUsr", null);
		httpSession.setAttribute("sessNameUsr", null);
		httpSession.setAttribute("sessEmailUsr", null);
		returnMap.put("rt", "success");
		return returnMap;
	}
	
	@ResponseBody
	@RequestMapping(value = "/member/idChkUsrProc")
	public Map<String, Object> idChkUsrProc(MemberDto dto) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		MemberDto rtMember = service.selectOneIdChk(dto);		
		
		if(rtMember != null) {
			returnMap.put("rt", "success");
		} else {
			returnMap.put("rt", "fail");
		}
		return returnMap;
	}
	@ResponseBody
	@RequestMapping(value = "/member/emailChkUsrProc")
	public Map<String, Object> emailChkUsrProc(MemberDto dto) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		MemberDto rtMember = service.selectOneEmailChk(dto);		
		
		if(rtMember != null) {
			returnMap.put("rt", "success");
		} else {
			returnMap.put("rt", "fail");
		}
		return returnMap;
	}
	
	@ResponseBody
	@RequestMapping(value = "/member/pwChkUsrProc")
	public Map<String, Object> pwChkUsrProc(MemberDto dto, HttpSession httpSession) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		dto.setUserId((String)httpSession.getAttribute("sessIdUsr"));
		dto.setSeq((String)httpSession.getAttribute("sessSeqUsr"));
//		MemberDto rtMember = service.selectOneIdChk(dto);		
		MemberDto rtMemberId = service.selectOneId(dto);
		if(Integer.valueOf(dto.getSeq()) > 11) {
			if(rtMemberId != null && matchesBcrypt(dto.getUserPassword(), rtMemberId.getUserPassword(), 10)) {
				returnMap.put("rt", "success");
			} else {
				returnMap.put("rt", "fail");
			}
		} else {
			MemberDto rtMember = service.selectOneIdChk(dto);
			
			if(rtMember != null) {
				returnMap.put("rt", "success");
				service.pwUpdate(rtMemberId);
			} else {
				returnMap.put("rt", "fail");
			}
		}
		
//		if(rtMember != null) {
//			returnMap.put("rt", "success");
//		} else {
//			returnMap.put("rt", "fail");
//		}
		return returnMap;
	}
	
	@RequestMapping(value = "/member/signinUsrForm")
	public String signinUsrForm(MemberVo vo, HttpSession httpSession) {		
		return "usr/member/SigninUsrForm";
	}
	
	@RequestMapping(value = "/member/userInfosettingUsrForm")
	public String userInfosettingUsrForm(MemberDto memberDto, IndexVo indexVo, Model model, HttpSession httpSession) {
		memberDto.setSeq((String)httpSession.getAttribute("sessSeqUsr"));
		indexVo.setSeq((String)httpSession.getAttribute("sessSeqUsr"));
		model.addAttribute("itemH", indexService.selectOneUserShopSeq(indexVo));
		model.addAttribute("item", service.selectOne(memberDto));
		return "usr/member/account-settings";
	}
	
	@RequestMapping(value = "/member/memberUsrUpdt")
	public String memberUsrUpdt(MemberDto memberDto) {
		service.updateInfo(memberDto);
		return "redirect:/member/userInfosettingUsrForm";
	}
	
	@ResponseBody
	@RequestMapping(value = "/member/pswdfindUsrProc")
	public Map<String, Object> pswdfindUsrProc(MemberDto dto, HttpSession httpSession) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		MemberDto rt = service.pswdrecoveryChk(dto);
		if(rt != null) {
			returnMap.put("rt", "success");
			rt.setUserPassword(encodeBcrypt(rt.getUserName(), 10));
			service.pwUpdate(rt);
			Thread threads = new Thread(new Runnable() {
				
				@Override
				public void run() {
					try {
						mailService.sendMailPWRecovery(rt);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			
			threads.start();
		} else {
			returnMap.put("rt", "fail");
		}
		return returnMap;
	}
	
	@RequestMapping(value = "/member/memberUsrPwUpdt")
	public String memberUsrPwUpdt(MemberDto memberDto, HttpSession httpSession) {
		memberDto.setSeq((String)httpSession.getAttribute("sessSeqUsr"));
		if(Integer.valueOf(memberDto.getSeq()) > 11) {
			memberDto.setUserPassword(encodeBcrypt(memberDto.getUserPassword(), 10));
			service.pwUpdate(memberDto);

		} else {
			service.pwUpdate(memberDto);

		}
		
		return "redirect:/member/signinUsrForm";
	}

	@RequestMapping(value = "/member/userBicycleUsrList")
	public String userBicycleUsrList(Model model, IndexVo indexVo, HttpSession httpSession, BicycleDto bicycleDto) {
		bicycleDto.setUserCustomer_seq((String)httpSession.getAttribute("sessSeqUsr"));
		indexVo.setSeq((String)httpSession.getAttribute("sessSeqUsr"));
		model.addAttribute("itemH", indexService.selectOneUserShopSeq(indexVo));
		model.addAttribute("list", bicycleService.selectOneList(bicycleDto));
		model.addAttribute("listR", bicycleService.selectList4Reservation(bicycleDto));
		return "usr/member/account-listings";
	}

	@RequestMapping(value = "/member/userFavorite")
	public String userFavorite(Model model, IndexVo vo, ShopDto dto,@ModelAttribute ShopVo shopVo, HttpSession httpSession) throws JsonProcessingException {
		vo.setSeq(httpSession.getAttribute("sessSeqUsr").toString());
		shopVo.setSeq(httpSession.getAttribute("sessSeqUsr").toString());
		model.addAttribute("itemH", indexService.selectOneUserShopSeq(vo));
		shopVo.setParamsPaging(shopService.selectOneCount(shopVo));
		List<ShopDto> shopList = shopService.selectList4Favorite(shopVo);  // 가게 정보 리스트
		List<BaseDto> picList = shopService.selectOneList4Pic(dto);  // 이미지 정보 리스트
		
		// 각 가게에 해당하는 이미지들만 매칭하여 picList에 할당합니다.
		for (ShopDto shop : shopList) {
		    List<BaseDto> matchedPics = picList.stream()
		        .filter(pic -> pic.getPseq().equals(shop.getShopSeq())) // shopSeq와 pSeq가 일치하는 것만 찾기
		        .collect(Collectors.toList());
		    
		    shop.setPicList(matchedPics); // ShopDto에 picList 필드를 추가하여 연결
		}
		model.addAttribute("list", shopList);  // 가게 정보 리스트
		model.addAttribute("listPic", picList);  // 이미지 정보 리스트 (혹시 필요하다면)
		return "usr/member/account-favorites";
	}

	@RequestMapping(value = "/member/shopUsrServiceAdmin")
	public String shopUsrServiceAdmin(Model model, MemberVo vo, IndexVo indexVo, HttpSession httpSession, BicycleDto bicycleDto, ReservationVo reservationVo) {
		bicycleDto.setUserCustomer_seq((String)httpSession.getAttribute("sessSeqUsr"));
		vo.setSeq((String)httpSession.getAttribute("sessSeqUsr"));
		indexVo.setSeq((String)httpSession.getAttribute("sessSeqUsr"));
		model.addAttribute("itemH", indexService.selectOneUserShopSeq(indexVo));
		reservationVo.setUserShopSeq(service.select4ShopSeq(vo).getUserShopSeq());
		model.addAttribute("list", reservationService.selectList4ReservationCheck(reservationVo));
		model.addAttribute("listR", reservationService.selectList4iNr(reservationVo));
		return "usr/member/ServiceAdministration";
	}
	
	@RequestMapping("/member/excelDownload")
    public void excelDownload(MemberVo vo, HttpServletResponse httpServletResponse) throws Exception {
		
		vo.setParamsPaging(service.selectOneCount(vo));

		if (vo.getTotalRows() > 0) {
			List<MemberDto> list = service.selectList(vo);
			
//			Workbook workbook = new HSSFWorkbook();	// for xls
	        Workbook workbook = new XSSFWorkbook();
	        Sheet sheet = workbook.createSheet("첫번째 시트");
	        CellStyle cellStyle = workbook.createCellStyle();        
	        Row row = null;
	        Cell cell = null;
	        int rowNum = 0;
			
//	        each column width setting
	        sheet.setColumnWidth(0, 2100);
	        sheet.setColumnWidth(1, 3100);

//	        Header
	        String[] tableHeader = {"멤버 코드", "회원분류", "ID", "이름", "성별", "Tel", "Email", "등록일", "수정일", "생년월일", "우편번호", "주소", "상세주소", "위도", "경도"};

	        row = sheet.createRow(rowNum++);
			for(int i=0; i<tableHeader.length; i++) {
				cell = row.createCell(i);
	        	cellStyle.setAlignment(HorizontalAlignment.CENTER);
	        	cell.setCellStyle(cellStyle);
				cell.setCellValue(tableHeader[i]);
			}

//	        Body
	        for (int i=0; i<list.size(); i++) {
	            row = sheet.createRow(rowNum++);
	            
//	            String type: null 전달 되어도 ok
//	            int, date type: null 시 오류 발생 하므로 null check
//	            String type 이지만 정수형 데이터가 전체인 seq 의 경우 캐스팅
	            
	            cell = row.createCell(0);
	        	cellStyle.setAlignment(HorizontalAlignment.CENTER);
	        	cell.setCellStyle(cellStyle);
	            cell.setCellValue(Integer.parseInt(list.get(i).getSeq()));
	            
	            cell = row.createCell(1);
	        	cellStyle.setAlignment(HorizontalAlignment.CENTER);
	        	cell.setCellStyle(cellStyle);
	        	cell.setCellValue(list.get(i).getUserCate());
	        	
	            cell = row.createCell(2);
	        	cellStyle.setAlignment(HorizontalAlignment.CENTER);
	        	cell.setCellStyle(cellStyle);
	        	cell.setCellValue(list.get(i).getUserId());

	        	cell = row.createCell(3);
	        	cellStyle.setAlignment(HorizontalAlignment.CENTER);
	        	cell.setCellStyle(cellStyle);
	        	cell.setCellValue(list.get(i).getUserName());
	        	
	            cell = row.createCell(4);
	            cellStyle.setAlignment(HorizontalAlignment.CENTER);
	            cell.setCellStyle(cellStyle);
	            if(list.get(i).getUserGender() != null) cell.setCellValue(list.get(i).getUserGender() == 1 ? "남성" : "여성");
	            
	            cell = row.createCell(5);
	            cellStyle.setAlignment(HorizontalAlignment.CENTER);
	            cell.setCellStyle(cellStyle);
	            cell.setCellValue(list.get(i).getUserTel());
	            
	            cell = row.createCell(6);
	        	cellStyle.setAlignment(HorizontalAlignment.CENTER);
	        	cell.setCellStyle(cellStyle);
	        	cell.setCellValue(list.get(i).getUserEmail());
	        	
	        	cell = row.createCell(7);
	        	cellStyle.setAlignment(HorizontalAlignment.CENTER);
	        	cell.setCellStyle(cellStyle);
	        	if(list.get(i).getUserInstDate() != null) cell.setCellValue(list.get(i).getUserInstDate());
	        	
	        	cell = row.createCell(8);
	        	cellStyle.setAlignment(HorizontalAlignment.CENTER);
	        	cell.setCellStyle(cellStyle);
	        	if(list.get(i).getUserUpdtDate() != null) cell.setCellValue(list.get(i).getUserUpdtDate());

	            cell = row.createCell(9);
	        	cellStyle.setAlignment(HorizontalAlignment.CENTER);
	        	cell.setCellStyle(cellStyle);
	        	cell.setCellValue(list.get(i).getUserDob());

	            cell = row.createCell(10);
	        	cellStyle.setAlignment(HorizontalAlignment.CENTER);
	        	cell.setCellStyle(cellStyle);
	        	cell.setCellValue(list.get(i).getUserZip());

	        	cell = row.createCell(11);
	        	cellStyle.setAlignment(HorizontalAlignment.CENTER);
	        	cell.setCellStyle(cellStyle);
	        	cell.setCellValue(list.get(i).getUserAddress1());

	        	cell = row.createCell(12);
	        	cellStyle.setAlignment(HorizontalAlignment.CENTER);
	        	cell.setCellStyle(cellStyle);
	        	cell.setCellValue(list.get(i).getUserAddress3());
	        	
	        	cell = row.createCell(13);
	        	cellStyle.setAlignment(HorizontalAlignment.CENTER);
	        	cell.setCellStyle(cellStyle);
	        	cell.setCellValue(list.get(i).getUserLatitude());
	        	
	        	cell = row.createCell(14);
	        	cellStyle.setAlignment(HorizontalAlignment.CENTER);
	        	cell.setCellStyle(cellStyle);
	        	cell.setCellValue(list.get(i).getUserLongitude());
	        }
	        
	        httpServletResponse.setContentType("ms-vnd/excel");
//	        httpServletResponse.setHeader("Content-Disposition", "attachment;filename=example.xls");	// for xls
	        httpServletResponse.setHeader("Content-Disposition", "attachment;filename=MemberTabel"+UtilDateTime.nowString()+".xlsx");

	        workbook.write(httpServletResponse.getOutputStream());
	        workbook.close();
		}
    }
	
 	@Value("${google.client.id}")
    private String googleClientId;
    @Value("${google.client.pw}")
    private String googleClientPw;
    @Value("${naver.client.id}")
    private String naverClientId;
    @Value("${naver.client.pw}")
    private String naverClientPw;
    @Value("${kakao.client.id}")
    private String kakaoClientId;

    @RequestMapping(value="/kakao/oauth2")
    public void loginUrlKakao(HttpServletResponse response) throws IOException{
    	String reqUrl = "https://kauth.kakao.com/oauth/authorize?response_type=code&client_id=" + kakaoClientId
    			+ "&redirect_uri=http://bicycledoctors.p-e.kr:8010/api/v1/oauth2/kakao";
    	response.sendRedirect(reqUrl);
    }
    @RequestMapping(value = "/api/v1/oauth2/kakao", method = RequestMethod.GET)
    public String loginKakao(@RequestParam("code") String authCode, MemberDto dto, HttpSession session, Model model) {
    	RestTemplate rest = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "authorization_code");
        params.add("client_id", kakaoClientId);
        params.add("redirect_uri", "http://bicycledoctors.p-e.kr:8010/api/v1/oauth2/kakao");
        params.add("code", authCode);

        HttpEntity<?> tokenReq = new HttpEntity<>(params, headers);
        Map tokenRes = rest.postForObject("https://kauth.kakao.com/oauth/token", tokenReq, Map.class);
        String accessToken = (String) tokenRes.get("access_token");

        HttpHeaders infoHeaders = new HttpHeaders();
        infoHeaders.set("Authorization", "Bearer " + accessToken);
        HttpEntity<?> infoReq = new HttpEntity<>(infoHeaders);
        Map userRes = rest.exchange("https://kapi.kakao.com/v2/user/me", HttpMethod.GET, infoReq, Map.class).getBody();

        Map kakaoAccount = (Map) userRes.get("kakao_account");
        Map profile = (Map) kakaoAccount.get("profile");

        String email = (String) kakaoAccount.get("email");
        String name = (String) profile.get("nickname");

        dto.setUserEmail(email);
        MemberDto rtMemberEmail = service.selectOneEmailChk(dto);

        if (rtMemberEmail != null) {
            session.setAttribute("sessSeqUsr", rtMemberEmail.getSeq());
            session.setAttribute("sessIdUsr", rtMemberEmail.getUserId());
            session.setAttribute("sessNameUsr", rtMemberEmail.getUserName());
            session.setAttribute("sessEmailUsr", rtMemberEmail.getUserEmail());
            session.setAttribute("sessCateUsr", rtMemberEmail.getUserCate());
            return "redirect:/index/homeUsr";
        } else {
            dto.setUserId(email.split("@")[0]);
            dto.setUserName(name);
            model.addAttribute("item", dto);
            return "usr/member/SignupUsrForm";
        }
    }
    
    @RequestMapping(value="/naver/oauth2")
    public void loginUrlNaver(HttpServletResponse response) throws IOException{
    	String reqUrl = "https://nid.naver.com/oauth2.0/authorize?client_id=" + naverClientId
    			+ "&redirect_uri=http://bicycledoctors.p-e.kr:8010/api/v1/oauth2/naver&response_type=code&state=RANDOM_STATE";
    	response.sendRedirect(reqUrl);
    }
    @RequestMapping(value = "/api/v1/oauth2/naver", method = RequestMethod.GET)
    public String loginNaver(@RequestParam("code") String authCode, @RequestParam("state") String state, MemberDto dto, HttpSession session, Model model) {
        RestTemplate restTemplate = new RestTemplate();
        String tokenUrl = "https://nid.naver.com/oauth2.0/token" +
                "?grant_type=authorization_code" +
                "&client_id=" + naverClientId +
                "&client_secret=" + naverClientPw +
                "&code=" + authCode +
                "&state=" + state;

        ResponseEntity<Map> tokenResponse = restTemplate.getForEntity(tokenUrl, Map.class);

        String accessToken = (String) tokenResponse.getBody().get("access_token");
        // 2. 사용자 정보 요청
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + accessToken);

        HttpEntity<String> entity = new HttpEntity<>("", headers);

        ResponseEntity<Map> userInfoResponse = restTemplate.exchange("https://openapi.naver.com/v1/nid/me", HttpMethod.GET, entity, Map.class);

        Map response = (Map) userInfoResponse.getBody().get("response");

        String email = (String) response.get("email");
        String name = (String) response.get("name");
        String id = (String) response.get("id");

        dto.setUserEmail(email);

        MemberDto rtMemberEmail = service.selectOneEmailChk(dto);
        if (rtMemberEmail != null) {
            session.setMaxInactiveInterval(60 * 30);
            session.setAttribute("sessSeqUsr", rtMemberEmail.getSeq());
            session.setAttribute("sessIdUsr", rtMemberEmail.getUserId());
            session.setAttribute("sessNameUsr", rtMemberEmail.getUserName());
            session.setAttribute("sessEmailUsr", rtMemberEmail.getUserEmail());
            session.setAttribute("sessCateUsr", rtMemberEmail.getUserCate());
            return "redirect:/index/homeUsr";
        } else {
            dto.setUserId(id);
            dto.setUserName(name);
            model.addAttribute("item", dto);
            return "usr/member/SignupUsrForm";
        }
    }
    
    @RequestMapping(value="/google/oauth2")
    public void loginUrlGoogle(HttpServletResponse response) throws IOException{
        String reqUrl = "https://accounts.google.com/o/oauth2/v2/auth?client_id=" + googleClientId
                + "&redirect_uri=http://bicycledoctors.p-e.kr:8010/api/v1/oauth2/google&response_type=code&scope=email%20profile%20openid&access_type=offline";
        //return reqUrl;
        response.sendRedirect(reqUrl);
    }
    @RequestMapping(value="/api/v1/oauth2/google", method = RequestMethod.GET)
    public String loginGoogle(@RequestParam(value = "code") String authCode, MemberDto dto, HttpSession httpSession, Model model){
        RestTemplate restTemplate = new RestTemplate();
        GoogleRequestDto googleOAuthRequestParam = new GoogleRequestDto();
        googleOAuthRequestParam.setClientId(googleClientId);
        googleOAuthRequestParam.setClientSecret(googleClientPw);
        googleOAuthRequestParam.setCode(authCode);
        googleOAuthRequestParam.setRedirectUri("http://bicycledoctors.p-e.kr:8010/api/v1/oauth2/google");
        googleOAuthRequestParam.setGrantType("authorization_code");
        ResponseEntity<GoogleResponseDto> resultEntity = restTemplate.postForEntity("https://oauth2.googleapis.com/token",
                googleOAuthRequestParam, GoogleResponseDto.class);
        String jwtToken=resultEntity.getBody().getId_token();
        String tokenInfoUrl = "https://oauth2.googleapis.com/tokeninfo?id_token=" + jwtToken;
        ResponseEntity<GoogleInfResponseDto> resultEntity2 = restTemplate.getForEntity(tokenInfoUrl, GoogleInfResponseDto.class);
        String email=resultEntity2.getBody().getEmail();
        //String name=resultEntity2.getBody().getFamily_name() + resultEntity2.getBody().getGiven_name();
        dto.setUserEmail(email);
        MemberDto rtMemberEmail = service.selectOneEmailChk(dto);
        if(rtMemberEmail != null) {
			httpSession.setMaxInactiveInterval(60 * 30); 						// 60second * 30 = 30minute
			httpSession.setAttribute("sessSeqUsr", rtMemberEmail.getSeq());
			httpSession.setAttribute("sessIdUsr", rtMemberEmail.getUserId());
			httpSession.setAttribute("sessNameUsr", rtMemberEmail.getUserName());
			httpSession.setAttribute("sessEmailUsr", rtMemberEmail.getUserEmail());
			httpSession.setAttribute("sessCateUsr", rtMemberEmail.getUserCate());
			return "redirect:/index/homeUsr";
		} else {
			dto.setUserId(resultEntity2.getBody().getEmail().split("@")[0]);
	    	dto.setUserEmail(resultEntity2.getBody().getEmail());
	    	dto.setUserName(resultEntity2.getBody().getName());
	    	model.addAttribute("item", dto);
	    	return "usr/member/SignupUsrForm";
		}
    }

}
