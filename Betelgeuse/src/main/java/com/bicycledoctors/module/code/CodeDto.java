package com.bicycledoctors.module.code;

import java.util.ArrayList;
import java.util.List;

public class CodeDto {
	private String cdSeq;
	private String cdName;
	private String cdNameEng;
	private String cdgSeq;
	private String cdgName;
	private String cdgNameEng;
	private Integer cdUseNy;
	private Integer cdDelNy;
	private String cdInstDate;
	private String cdUpdtDate;
	private String cdDesc;
	private String codegroup_cdgSeq;
	
//	-----
//	for cache
	public static List<CodeDto> cachedCodeArrayList = new ArrayList<CodeDto>();
	
	public String getCdSeq() {
		return cdSeq;
	}
	public void setCdSeq(String cdSeq) {
		this.cdSeq = cdSeq;
	}
	public String getCdName() {
		return cdName;
	}
	public void setCdName(String cdName) {
		this.cdName = cdName;
	}
	public Integer getCdUseNy() {
		return cdUseNy;
	}
	public void setCdUseNy(Integer cdUseNy) {
		this.cdUseNy = cdUseNy;
	}
	public Integer getCdDelNy() {
		return cdDelNy;
	}
	public void setCdDelNy(Integer cdDelNy) {
		this.cdDelNy = cdDelNy;
	}
	public String getCdDesc() {
		return cdDesc;
	}
	public void setCdDesc(String cdDesc) {
		this.cdDesc = cdDesc;
	}
	public String getCodegroup_cdgSeq() {
		return codegroup_cdgSeq;
	}
	public void setCodegroup_cdgSeq(String codegroup_cdgSeq) {
		this.codegroup_cdgSeq = codegroup_cdgSeq;
	}
	public String getCdgSeq() {
		return cdgSeq;
	}
	public void setCdgSeq(String cdgSeq) {
		this.cdgSeq = cdgSeq;
	}
	public String getCdNameEng() {
		return cdNameEng;
	}
	public void setCdNameEng(String cdNameEng) {
		this.cdNameEng = cdNameEng;
	}
	public String getCdgName() {
		return cdgName;
	}
	public void setCdgName(String cdgName) {
		this.cdgName = cdgName;
	}
	public static List<CodeDto> getCachedCodeArrayList() {
		return cachedCodeArrayList;
	}
	public static void setCachedCodeArrayList(List<CodeDto> cachedCodeArrayList) {
		CodeDto.cachedCodeArrayList = cachedCodeArrayList;
	}
	public String getCdInstDate() {
		return cdInstDate;
	}
	public void setCdInstDate(String cdInstDate) {
		this.cdInstDate = cdInstDate;
	}
	public String getCdUpdtDate() {
		return cdUpdtDate;
	}
	public void setCdUpdtDate(String cdUpdtDate) {
		this.cdUpdtDate = cdUpdtDate;
	}
	public String getCdgNameEng() {
		return cdgNameEng;
	}
	public void setCdgNameEng(String cdgNameEng) {
		this.cdgNameEng = cdgNameEng;
	}
	
	

}
