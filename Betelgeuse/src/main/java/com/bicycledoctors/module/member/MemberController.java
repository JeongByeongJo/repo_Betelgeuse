package com.bicycledoctors.module.member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bicycledoctors.common.base.BaseController;
import com.bicycledoctors.common.util.UtilDateTime;
import com.bicycledoctors.module.bicycle.BicycleDto;
import com.bicycledoctors.module.bicycle.BicycleService;
import com.bicycledoctors.module.code.CodeController;
import com.bicycledoctors.module.codegroup.CodeGroupDto;
import com.bicycledoctors.module.codegroup.CodeGroupVo;
import com.bicycledoctors.module.mail.MailService;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@Controller
public class MemberController extends BaseController {

	
	@Autowired
	MemberService service;
	
	@Autowired
	MailService mailService;
	
	@Autowired
	BicycleService bicycleService;
	
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
	public String userInfosettingUsrForm(MemberDto memberDto, Model model, HttpSession httpSession) {
		memberDto.setSeq((String)httpSession.getAttribute("sessSeqUsr"));
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


	@RequestMapping(value = "/member/userProfileUsrForm")
	public String userProfileUsrForm(MemberDto memberDto, Model model, HttpSession httpSession) {
		memberDto.setSeq((String)httpSession.getAttribute("sessSeqUsr"));
		model.addAttribute("item", service.selectOne(memberDto));
		return "usr/member/account-profile";
	}
	@RequestMapping(value = "/member/userBicycleUsrForm")
	public String userBicycleUsrForm(MemberDto memberDto, Model model, HttpSession httpSession) {
		memberDto.setSeq((String)httpSession.getAttribute("sessSeqUsr"));
		model.addAttribute("item", service.selectOne(memberDto));
		return "usr/member/account-profile";
	}
	@RequestMapping(value = "/member/userBicycleUsrList")
	public String userBicycleUsrList(Model model, HttpSession httpSession, BicycleDto bicycleDto) {
		bicycleDto.setUserCustomer_seq((String)httpSession.getAttribute("sessSeqUsr"));
		model.addAttribute("list", bicycleService.selectOneList(bicycleDto));
		model.addAttribute("listR", bicycleService.selectList4Reservation(bicycleDto));
		return "usr/member/account-listings";
	}
	@RequestMapping(value = "/member/shopUsrServiceAdmin")
	public String shopUsrServiceAdmin(Model model, MemberVo vo, HttpSession httpSession, BicycleDto bicycleDto) {
		bicycleDto.setUserCustomer_seq((String)httpSession.getAttribute("sessSeqUsr"));
		vo.setSeq((String)httpSession.getAttribute("sessSeqUsr"));
		bicycleDto.setUserShopSeq(service.select4ShopSeq(vo).getUserShopSeq());
//		bicycleDto.setShopSeq("1");
		model.addAttribute("list", bicycleService.selectList4ReservationCheck(bicycleDto));
		model.addAttribute("listR", bicycleService.selectList4iNr(bicycleDto));
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
}
