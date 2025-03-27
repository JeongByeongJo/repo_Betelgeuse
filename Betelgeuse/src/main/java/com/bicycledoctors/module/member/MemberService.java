package com.bicycledoctors.module.member;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	
	@Autowired
	MemberDao memberDao;
	
	public List<MemberDto> selectList(MemberVo vo) {
		return memberDao.selectList(vo);
	}
	
	public int selectOneCount(MemberVo vo) {
		return memberDao.selectOneCount(vo);
	}
	
	public MemberDto selectOne(MemberDto memberDto) {
		return memberDao.selectOne(memberDto);
	}
	public MemberDto selectOne(MemberVo memberVo) {
		return memberDao.selectOne(memberVo);
	}
	
	public int update(MemberDto memberDto) {
		return memberDao.update(memberDto);				
	}
	
	public MemberDto signinChk(MemberDto memberDto) {
		return memberDao.signinChk(memberDto);
	}
	public MemberDto pswdrecoveryChk(MemberDto memberDto) {
		return memberDao.pswdrecoveryChk(memberDto);
	}

}
