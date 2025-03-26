package com.bicycledoctors.module.member;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public interface MemberDao {
	
	public List<MemberDto> selectList(MemberVo vo);
	public MemberDto selectOne(MemberDto memberDto);
	
	public int update(MemberDto memberDto);
	public int selectOneCount(MemberVo vo);
	public Map<String, Object> signinChk(MemberDto memberDto);

}
