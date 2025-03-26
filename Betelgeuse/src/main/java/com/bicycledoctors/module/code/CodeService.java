package com.bicycledoctors.module.code;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

@Service
public class CodeService {
	
	@Autowired
	CodeDao codeDao;
	
	public List<CodeDto> selectList(CodeVo vo) {
		return codeDao.selectList(vo);
	}
	public List<CodeDto> selectGroupList() {
		return codeDao.selectGroupList();
	}
	public CodeDto selectOne(CodeDto codeDto) {
		return codeDao.selectOne(codeDto);
	}
	public CodeDto selectOne(CodeVo vo) {
		return codeDao.selectOne(vo);
	}
	public int insert(CodeDto codeDto) {
		return codeDao.insert(codeDto);				
	}
	public int update(CodeDto codeDto) {
		return codeDao.update(codeDto);				
	}
	public int uelete(CodeDto codeDto) {
		return codeDao.uelete(codeDto);				
	}
	public int selectOneCount(CodeVo vo) {
		return codeDao.selectOneCount(vo);				
	}
//	-----
	
	@PostConstruct
	public void selectListCachedCodeArrayList() throws Exception {
		List<CodeDto> codeListFromDb = (ArrayList<CodeDto>) codeDao.selectListCachedCodeArrayList();
		CodeDto.cachedCodeArrayList.clear(); 
		CodeDto.cachedCodeArrayList.addAll(codeListFromDb);
		System.out.println("cachedCodeArrayList: " + CodeDto.cachedCodeArrayList.size() + " chached !");
	}
    
    
	public static void clear() throws Exception {
		CodeDto.cachedCodeArrayList.clear();
	}
	
	
	public static List<CodeDto> selectListCachedCode(String cdgSeq) throws Exception {
		List<CodeDto> rt = new ArrayList<CodeDto>();
		for(CodeDto codeRow : CodeDto.cachedCodeArrayList) {
			if (codeRow.getCodegroup_cdgSeq().equals(cdgSeq)) {
				rt.add(codeRow);
			} else {
				// by pass
			}
		}
		return rt;
	}

	
	public static String selectOneCachedCode(int code) throws Exception {
		String rt = "";
		for(CodeDto codeRow : CodeDto.cachedCodeArrayList) {
			if (codeRow.getCdSeq().equals(Integer.toString(code))) {
				rt = codeRow.getCdName();
			} else {
				// by pass
			}
		}
		return rt;
	}
}
