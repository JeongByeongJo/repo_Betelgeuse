package com.bicycledoctors.common.base;

import com.bicycledoctors.common.util.UtilDateTime;

public class BaseController {
	
	public void utildatetime(BaseVo vo) {
		vo.setShDateStart(vo.getShDateStart() == null || vo.getShDateStart() == "" ? null : UtilDateTime.add00TimeString(vo.getShDateStart()));
		vo.setShDateEnd(vo.getShDateEnd() == null || vo.getShDateEnd() == "" ? null : UtilDateTime.add59TimeString(vo.getShDateEnd()));
	}
	
	
}
