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
	public MemberDto select4ShopSeq(MemberVo vo) {
		return memberDao.select4ShopSeq(vo);
	}
	
	public int insert(MemberDto memberDto) {
		return memberDao.insert(memberDto);				
	}
	public int update(MemberDto memberDto) {
		return memberDao.update(memberDto);				
	}
	public int updateInfo(MemberDto memberDto) {
		return memberDao.updateInfo(memberDto);				
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
	public MemberDto selectOneId(MemberDto memberDto) {
		return memberDao.selectOneId(memberDto);
	}
	public MemberDto selectOneEmailChk(MemberDto memberDto) {
		return memberDao.selectOneEmailChk(memberDto);
	}
	public MemberDto pswdrecoveryChk(MemberDto memberDto) {
		System.out.println("memberDto.getSeq(): "+memberDto.getSeq());
		return memberDao.pswdrecoveryChk(memberDto);
	}

}
