package com.bicycledoctors.module.insRep;

import org.springframework.stereotype.Repository;

@Repository
public interface InsRepDao {

	public InsRepDto selectOne4IrSeq(InsRepVo vo);
	public InsRepDto selectOne(InsRepVo vo);
	public int insert(InsRepDto dto);
	public int update(InsRepDto dto);
	public int inrComplete(InsRepDto dto);
	public int inrCompleteBike(InsRepDto dto);
}
