package com.bicycledoctors.module.bicycle;

import com.bicycledoctors.common.base.BaseDto;

public class BicycleDto extends BaseDto{

	private String bikeSeq;
	private String bicycleName;
	private Integer bicycleCateCd;
	private Integer bicycleBrandCd;
    private String bicycleModel;
    private Integer bicycleYears;
    private Integer bicycleMiles;
    private String bicycleSN;
    private Integer drivetrainBrandCd;
    private String drivetrainModel;
    private Integer brakeBrandCd;
    private String isElectDrivetrain;
    private String isDiskBrakes;
    private String isHydrauric;
    private String isInternal;
    private Integer wheelBrandCd;
    private String wheelModel;
    private String bicycleDescribe;
    private Integer isInspectingNy;
    private Integer isRepairingNy;
    private Integer delNy;
    private String instDate;
    private String updtDate;
    private String userCustomer_seq;
//    -----
    private Integer uploadImg1Type = 1001;
	private Integer uploadImg1MaxNumber = 1001;
//    -----
    
    public String getBikeSeq() {
    	return bikeSeq;
    }
    public void setBikeSeq(String bikeSeq) {
    	this.bikeSeq = bikeSeq;
    }
	public String getBicycleName() {
		return bicycleName;
	}
	public void setBicycleName(String bicycleName) {
		this.bicycleName = bicycleName;
	}
	public Integer getBicycleCateCd() {
		return bicycleCateCd;
	}
	public void setBicycleCateCd(Integer bicycleCateCd) {
		this.bicycleCateCd = bicycleCateCd;
	}
	public Integer getBicycleBrandCd() {
		return bicycleBrandCd;
	}
	public void setBicycleBrandCd(Integer bicycleBrandCd) {
		this.bicycleBrandCd = bicycleBrandCd;
	}
	public String getBicycleModel() {
		return bicycleModel;
	}
	public void setBicycleModel(String bicycleModel) {
		this.bicycleModel = bicycleModel;
	}
	public Integer getBicycleYears() {
		return bicycleYears;
	}
	public void setBicycleYears(Integer bicycleYears) {
		this.bicycleYears = bicycleYears;
	}
	public Integer getBicycleMiles() {
		return bicycleMiles;
	}
	public void setBicycleMiles(Integer bicycleMiles) {
		this.bicycleMiles = bicycleMiles;
	}
	public String getBicycleSN() {
		return bicycleSN;
	}
	public void setBicycleSN(String bicycleSN) {
		this.bicycleSN = bicycleSN;
	}
	public Integer getDrivetrainBrandCd() {
		return drivetrainBrandCd;
	}
	public void setDrivetrainBrandCd(Integer drivetrainBrandCd) {
		this.drivetrainBrandCd = drivetrainBrandCd;
	}
	public String getDrivetrainModel() {
		return drivetrainModel;
	}
	public void setDrivetrainModel(String drivetrainModel) {
		this.drivetrainModel = drivetrainModel;
	}
	public Integer getBrakeBrandCd() {
		return brakeBrandCd;
	}
	public void setBrakeBrandCd(Integer brakeBrandCd) {
		this.brakeBrandCd = brakeBrandCd;
	}
	public String getIsElectDrivetrain() {
		return isElectDrivetrain;
	}
	public void setIsElectDrivetrain(String isElectDrivetrain) {
		this.isElectDrivetrain = isElectDrivetrain;
	}
	public String getIsDiskBrakes() {
		return isDiskBrakes;
	}
	public void setIsDiskBrakes(String isDiskBrakes) {
		this.isDiskBrakes = isDiskBrakes;
	}
	public String getIsHydrauric() {
		return isHydrauric;
	}
	public void setIsHydrauric(String isHydrauric) {
		this.isHydrauric = isHydrauric;
	}
	public String getIsInternal() {
		return isInternal;
	}
	public void setIsInternal(String isInternal) {
		this.isInternal = isInternal;
	}
	public Integer getWheelBrandCd() {
		return wheelBrandCd;
	}
	public void setWheelBrandCd(Integer wheelBrandCd) {
		this.wheelBrandCd = wheelBrandCd;
	}
	public String getWheelModel() {
		return wheelModel;
	}
	public void setWheelModel(String wheelModel) {
		this.wheelModel = wheelModel;
	}
	public String getBicycleDescribe() {
		return bicycleDescribe;
	}
	public void setBicycleDescribe(String bicycleDescribe) {
		this.bicycleDescribe = bicycleDescribe;
	}
	public Integer getIsInspectingNy() {
		return isInspectingNy;
	}
	public void setIsInspectingNy(Integer isInspectingNy) {
		this.isInspectingNy = isInspectingNy;
	}
	public Integer getIsRepairingNy() {
		return isRepairingNy;
	}
	public void setIsRepairingNy(Integer isRepairingNy) {
		this.isRepairingNy = isRepairingNy;
	}
	public Integer getDelNy() {
		return delNy;
	}
	public void setDelNy(Integer delNy) {
		this.delNy = delNy;
	}
	public String getInstDate() {
		return instDate;
	}
	public void setInstDate(String instDate) {
		this.instDate = instDate;
	}
	public String getUpdtDate() {
		return updtDate;
	}
	public void setUpdtDate(String updtDate) {
		this.updtDate = updtDate;
	}
	public String getUserCustomer_seq() {
		return userCustomer_seq;
	}
	public void setUserCustomer_seq(String userCustomer_seq) {
		this.userCustomer_seq = userCustomer_seq;
	}
//    ----
	private String userId;
	private String userName;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
//	-----
	public Integer getUploadImg1Type() {
		return uploadImg1Type;
	}
	public void setUploadImg1Type(Integer uploadImg1Type) {
		this.uploadImg1Type = uploadImg1Type;
	}
	public Integer getUploadImg1MaxNumber() {
		return uploadImg1MaxNumber;
	}
	public void setUploadImg1MaxNumber(Integer uploadImg1MaxNumber) {
		this.uploadImg1MaxNumber = uploadImg1MaxNumber;
	}
	
}
