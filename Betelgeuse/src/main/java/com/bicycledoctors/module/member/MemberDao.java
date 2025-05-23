package com.bicycledoctors.module.member;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bicycledoctors.module.shop.ShopDto;

@Repository
public interface MemberDao {
	
	public List<MemberDto> selectList(MemberVo vo);
	public MemberDto selectOne(MemberDto memberDto);
	public MemberDto selectOne(MemberVo membervo);
	public MemberDto select4ShopSeq(MemberVo membervo);
	
	public int insert(MemberDto memberDto);
	public int update(MemberDto memberDto);
	public int updateInfo(MemberDto memberDto);
	public int updateShopSeq(ShopDto shopDto);
	public int pwUpdate(MemberDto memberDto);
	public int uelete(MemberDto memberDto);
	public int selectOneCount(MemberVo vo);
	public MemberDto selectOneIdChk(MemberDto memberDto);
	public MemberDto selectOneId(MemberDto memberDto);
	public MemberDto selectOneEmailChk(MemberDto memberDto);
	public MemberDto pswdrecoveryChk(MemberDto memberDto);

}
