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
	
	public int insert(MemberDto memberDto) {
		return memberDao.insert(memberDto);				
	}
	public int update(MemberDto memberDto) {
		return memberDao.update(memberDto);				
	}
	public int pwUpdate(MemberDto memberDto) {
		return memberDao.pwUpdate(memberDto);				
	}
	public int uelete(MemberDto memberDto) {
		return memberDao.uelete(memberDto);				
	}
	
	public MemberDto selectOneIdChk(MemberDto memberDto) {
		return memberDao.selectOneIdChk(memberDto);
	}
	public MemberDto pswdrecoveryChk(MemberDto memberDto) {
		return memberDao.pswdrecoveryChk(memberDto);
	}

}
