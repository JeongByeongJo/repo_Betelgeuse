package com.bicycledoctors.module.codegroup;

import java.util.List;

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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bicycledoctors.common.base.BaseController;
import com.bicycledoctors.common.util.UtilDateTime;

import jakarta.servlet.http.HttpServletResponse;


@Controller
public class CodeGroupController extends BaseController {
	
	@Autowired
	CodeGroupService service;
	
	@RequestMapping(value = "/codegroup/codegroupXdmList")
	public String codegroupXdmList(CodeGroupVo vo, Model model) throws Exception {
		
		utildatetime(vo);
		
		vo.setParamsPaging(service.selectOneCount(vo));
		
		model.addAttribute("list", service.selectList(vo));
		model.addAttribute("vo", vo);
		
		return "xdm/codegroup/CodegroupXdmList";
	}
	
	@RequestMapping(value = "/codegroup/codegroupXdmForm")
	public String codegroupXdmForm(@ModelAttribute("vo") CodeGroupVo vo, Model model) {
		if (vo.getCdgSeq().equals("0") || vo.getCdgSeq().equals("")) {
//			insert mode
		} else {
//			update mode
			model.addAttribute("item", service.selectOne(vo));
		}
		return "xdm/codegroup/CodegroupXdmForm";
	}
	
	@RequestMapping(value = "/codegroup/codegroupXdmUpExls")
	public String codegroupXdmUpExls(Model model, CodeGroupDto codeGroupDto) {
		model.addAttribute("item", service.selectOne(codeGroupDto));
		return "xdm/codegroup/CodegroupXdmUpExls";
	}
	
	@RequestMapping(value = "/codegroup/codegroupXdmInst")
	public String codegroupXdmInst(CodeGroupDto codeGroupDto) {
		service.insert(codeGroupDto);
		return "redirect:/codegroup/codegroupXdmList";
	}
	
	@RequestMapping(value = "/codegroup/codegroupXdmUpdt")
	public String codegroupXdmUpdt(CodeGroupDto codeGroupDto) {
		service.update(codeGroupDto);
		return "redirect:/codegroup/codegroupXdmList";
	}
	
	@RequestMapping(value = "/codegroup/codegroupXdmUele")
	public String codegroupXdmUele(CodeGroupDto codeGroupDto) {
		service.uelete(codeGroupDto);
		return "redirect:/codegroup/codegroupXdmList";
	}

	@RequestMapping("/excelDownload")
    public void excelDownload(CodeGroupVo vo, HttpServletResponse httpServletResponse) throws Exception {
		
		vo.setParamsPaging(service.selectOneCount(vo));

		if (vo.getTotalRows() > 0) {
			List<CodeGroupDto> list = service.selectList(vo);
			
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
	        String[] tableHeader = {"코드그룹 코드", "코드그룹 이름", "코드그룹 이름 (영문)", "갯수", "사용", "삭제", "등록일", "수정일"};

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
	            cell.setCellValue(Integer.parseInt(list.get(i).getCdgSeq()));
	            
	            cell = row.createCell(1);
	        	cellStyle.setAlignment(HorizontalAlignment.CENTER);
	        	cell.setCellStyle(cellStyle);
	        	cell.setCellValue(list.get(i).getCdgName());
	        	
	            cell = row.createCell(2);
	        	cellStyle.setAlignment(HorizontalAlignment.CENTER);
	        	cell.setCellStyle(cellStyle);
	        	cell.setCellValue(list.get(i).getCdgNameEng());

	        	cell = row.createCell(3);
	        	cellStyle.setAlignment(HorizontalAlignment.CENTER);
	        	cell.setCellStyle(cellStyle);
	        	cell.setCellValue(list.get(i).getXcdSeqCount());
	        	
	            cell = row.createCell(4);
	            cellStyle.setAlignment(HorizontalAlignment.CENTER);
	            cell.setCellStyle(cellStyle);
	            if(list.get(i).getCdgUseNy() != null) cell.setCellValue(list.get(i).getCdgUseNy() == 0 ? "N" : "Y");

	            cell = row.createCell(5);
	            cellStyle.setAlignment(HorizontalAlignment.CENTER);
	            cell.setCellStyle(cellStyle);
	            if(list.get(i).getCdgDelNy() != null) cell.setCellValue(list.get(i).getCdgDelNy() == 0 ? "N" : "Y");
	            
	            cell = row.createCell(6);
	        	cellStyle.setAlignment(HorizontalAlignment.CENTER);
	        	cell.setCellStyle(cellStyle);
	        	if(list.get(i).getCdgInstDate() != null) cell.setCellValue(list.get(i).getCdgInstDate());
	        	
	        	cell = row.createCell(7);
	        	cellStyle.setAlignment(HorizontalAlignment.CENTER);
	        	cell.setCellStyle(cellStyle);
	        	if(list.get(i).getCdgUpdtDate() != null) cell.setCellValue(list.get(i).getCdgUpdtDate());
	        }
	        
	        httpServletResponse.setContentType("ms-vnd/excel");
//	        httpServletResponse.setHeader("Content-Disposition", "attachment;filename=example.xls");	// for xls
	        httpServletResponse.setHeader("Content-Disposition", "attachment;filename=CodeGroupTabel"+UtilDateTime.nowString()+".xlsx");

	        workbook.write(httpServletResponse.getOutputStream());
	        workbook.close();
		}
    }
}
