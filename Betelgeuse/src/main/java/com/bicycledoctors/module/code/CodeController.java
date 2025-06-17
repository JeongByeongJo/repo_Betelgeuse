package com.bicycledoctors.module.code;

import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bicycledoctors.common.base.BaseController;
import com.bicycledoctors.module.codegroup.CodeGroupService;

import jakarta.servlet.http.HttpServletResponse;


@Controller
public class CodeController extends BaseController {
	
	@Autowired
	CodeService codeService;
	
	@Autowired
	CodeGroupService codeGroupService;

	@RequestMapping(value = "/code/codeXdmList")
	public String codeXdmList(CodeVo vo, Model model) throws Exception{
		
		utildatetime(vo);
		
		vo.setParamsPaging(codeService.selectOneCount(vo));
		
		model.addAttribute("list", codeService.selectList(vo));
		model.addAttribute("vo", vo);
		
		return "xdm/code/CodeXdmList";
	}
	
	@RequestMapping(value = "/code/codeXdmForm")
	public String codeXdmForm(@ModelAttribute("vo") CodeVo vo, Model model) {
		model.addAttribute("list", codeGroupService.selectListWithoutPaging());
		
		if (vo.getCdSeq().equals("0") || vo.getCdSeq().equals("")) {
//			insert mode
		} else {
//			update mode
			model.addAttribute("item", codeService.selectOne(vo));
		}
		
		return "xdm/code/CodeXdmForm";
	}
	
	@RequestMapping(value = "/code/codeXdmInst")
	public String codeXdmInst(CodeDto codeDto) {
		codeService.insert(codeDto);
		return "redirect:/code/codeXdmList";
	}
	
	@RequestMapping(value = "/code/codeXdmMfom")
	public String codeXdmMfom(Model model, CodeDto codeDto) {
//		model.addAttribute("list", codeService.selectGroupList());
		model.addAttribute("list", codeGroupService.selectListWithoutPaging());
		model.addAttribute("item", codeService.selectOne(codeDto));
		return "xdm/code/CodeXdmMfom";
	}
	
	@RequestMapping(value = "/code/codeXdmUpdt")
	public String codeXdmUpdt(CodeDto codeDto) {
		codeService.update(codeDto);
		return "redirect:/code/codeXdmList";
	}
	@RequestMapping(value = "/code/codeXdmUele")
	public String codeXdmUele(CodeDto codeDto) {
		codeService.uelete(codeDto);
		return "redirect:/code/codeXdmList";
	}
	
	@RequestMapping(value = "/code/codeXdmExls")
	public void codeXdmExls(HttpServletResponse response, CodeVo vo) throws Exception {
	    List<CodeDto> codeDto = codeService.selectList(vo);
	    
	    LocalDate date = LocalDate.now();
	    
	    response.setContentType("text/xls; charset=UTF-8");
	    response.setHeader("Content-Disposition", "attachment; filename = Code"+date+".xls");
	   
	    PrintWriter writer = response.getWriter();
	    writer.println("코드,코드명,코드명(영문),사용여부,삭제여부,등록일,코드그룹코드,코드그룹명,코드그룹명(영문)");

	    for (CodeDto dto : codeDto) {
	        writer.printf("%s,%s,%s,%s,%s,%s,%s,%s,%s\n",
	        	dto.getCdSeq(),
	        	dto.getCdName(),
	        	dto.getCdNameEng(),
	        	dto.getCdUseNy(),
	        	dto.getCdDelNy(),
	        	dto.getCdInstDate(),
	        	dto.getCdgSeq(),
	        	dto.getCdgName(),
	        	dto.getCdgNameEng()
	        );
	    }
	    writer.flush();
	    writer.close();
	}
}
