package com.bicycledoctors.module.codegroup;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bicycledoctors.common.base.BaseVo;

@Repository
public interface CodeGroupDao {
	
//	public List<CodeGroupDto> selectList(CodeGroupVo vo);	
	public List<CodeGroupDto> selectList(BaseVo vo);	
	public List<CodeGroupDto> selectListWithoutPaging();
	public CodeGroupDto selectOne(CodeGroupDto codeGroupDto);
	public CodeGroupDto selectOne(CodeGroupVo vo);
	
	public int insert(CodeGroupDto codeGroupDto);
	public int update(CodeGroupDto codeGroupDto);
	public int uelete(CodeGroupDto codeGroupDto);
	public int selectOneCount(CodeGroupVo vo);
	public int selectOneCount(BaseVo vo);

}
