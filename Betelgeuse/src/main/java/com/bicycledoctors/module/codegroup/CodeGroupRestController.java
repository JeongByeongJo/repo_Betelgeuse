package com.bicycledoctors.module.codegroup;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/codegroup")
public class CodeGroupRestController {

	@Autowired
	CodeGroupService service;
	
	@RequestMapping(value = "", method=RequestMethod.GET)
	public List<CodeGroupDto> selectList(CodeGroupVo vo) {
		return service.selectList(vo);
	}
	
	@RequestMapping(value = "/{seq}", method=RequestMethod.GET)
	public CodeGroupDto selectOne(@PathVariable("seq") String seq, CodeGroupVo vo) {
		vo.setCdgSeq(seq);
	    return service.selectOne(vo);
	}
	
	@RequestMapping(value = "/{seq}", method=RequestMethod.PATCH)
	public void update(@PathVariable("seq") String seq, CodeGroupDto dto) {
		System.out.println(">>>seq: " + seq);
		
		dto.setCdgSeq(seq);
		System.out.println(">>>getCdgName: " + dto.getCdgName());
		System.out.println(">>>getCdgNameEng: " + dto.getCdgNameEng());
		service.update(dto);
	}
	
}
