package com.bicycledoctors.common.base;

import org.springframework.web.multipart.MultipartFile;

public class BaseDto {

//	uploaded
	private String tableName;
	
	private String seq;
	private Integer type;
	private Integer defaultNy;
	private Integer sort;
	private String path;
	private String path1;
	private String path2;
	private String path3;
	private String originalName;
	private String uuidName;
	private String ext;
	private long size;
	private Integer delNy;
	private String pseq;

	private MultipartFile[] uploadImg1;
//	-----
 	private String id;
    private String label;
    private boolean checked;
//	-----

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getDefaultNy() {
		return defaultNy;
	}

	public void setDefaultNy(Integer defaultNy) {
		this.defaultNy = defaultNy;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getOriginalName() {
		return originalName;
	}

	public void setOriginalName(String originalName) {
		this.originalName = originalName;
	}

	public String getUuidName() {
		return uuidName;
	}

	public void setUuidName(String uuidName) {
		this.uuidName = uuidName;
	}

	public String getExt() {
		return ext;
	}

	public void setExt(String ext) {
		this.ext = ext;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public Integer getDelNy() {
		return delNy;
	}

	public void setDelNy(Integer delNy) {
		this.delNy = delNy;
	}

	public String getPseq() {
		return pseq;
	}

	public void setPseq(String pseq) {
		this.pseq = pseq;
	}

	public MultipartFile[] getUploadImg1() {
		return uploadImg1;
	}

	public void setUploadImg1(MultipartFile[] uploadImg1) {
		this.uploadImg1 = uploadImg1;
	}

	public String getPath1() {
		return path1;
	}

	public void setPath1(String path1) {
		this.path1 = path1;
	}

	public String getPath2() {
		return path2;
	}

	public void setPath2(String path2) {
		this.path2 = path2;
	}

	public String getPath3() {
		return path3;
	}

	public void setPath3(String path3) {
		this.path3 = path3;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}


	
}
