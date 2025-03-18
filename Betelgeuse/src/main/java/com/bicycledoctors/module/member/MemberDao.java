package com.bicycledoctors.module.member;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface MemberDao {
	
	public List<MemberDto> selectList(MemberVo vo);
	
	public int selectOneCount();

}
