package com.bicycledoctors.module.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	
	@Autowired
	MemberDao memberDao;
	
	public List<MemberDto> selectList(MemberVo vo) {
		return memberDao.selectList(vo);
	}
	
	public int selectOneCount() {
		return memberDao.selectOneCount();
	}
	
	public MemberDto selectOne(MemberDto memberDto) {
		return memberDao.selectOne(memberDto);
	}
	
	public int update(MemberDto memberDto) {
		return memberDao.update(memberDto);				
	}

}
