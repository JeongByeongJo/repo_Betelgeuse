package com.bicycledoctors.module.insRep;

import com.bicycledoctors.module.bicycle.BicycleDto;

public class InsRepDto extends BicycleDto {

	private String irSeq;
    private String inspectRepairDate;
    private String drivetrainDate;
    private Integer drivetrainInsCost;
    private Integer drivetrainRepCost;
    private String drivetrainInsDesc;
    private String drivetrainRepDesc;
    private String brakeDate;
    private Integer brakeInsCost;
    private Integer brakeRepCost;
    private String brakeInsDesc;
    private String brakeRepDesc;
    private String wheelDate;
    private Integer wheelInsCost;
    private Integer wheelRepCost;
    private String wheelInsDesc;
    private String wheelRepDesc;
    private String cockpits;
    private String cockpitDate;
    private Integer cockpitInsCost;
    private Integer cockpitRepCost;
    private String cockpitInsDesc;
    private String cockpitRepDesc;
    private String etcs;
    private String etcDate;
    private Integer etcInsCost;
    private Integer etcRepCost;
    private String etcInsDesc;
    private String etcRepDesc;
    private String expendables;
    private String expendableDate;
    private Integer expendableCost1;
    private Integer expendableCost2;
    private Integer expendableCost3;
    private Integer expendableCost4;
    private Integer expendableCost5;
    private Integer expendableCosts;
    private String expendableDesc;
    private Integer totalPrice;
    private String instDate;
    private String updtDate;
    private String reservation_rsrvSeq;
    private String shop_shopSeq;
    private String bicycle_bikeSeq;
//  -----
	public String getIrSeq() {
		return irSeq;
	}
	public void setIrSeq(String irSeq) {
		this.irSeq = irSeq;
	}
	public String getInspectRepairDate() {
		return inspectRepairDate;
	}
	public void setInspectRepairDate(String inspectRepairDate) {
		this.inspectRepairDate = inspectRepairDate;
	}
	public String getDrivetrainDate() {
		return drivetrainDate;
	}
	public void setDrivetrainDate(String drivetrainDate) {
		this.drivetrainDate = drivetrainDate;
	}
	public Integer getDrivetrainInsCost() {
		return drivetrainInsCost;
	}
	public void setDrivetrainInsCost(Integer drivetrainInsCost) {
		this.drivetrainInsCost = drivetrainInsCost;
	}
	public Integer getDrivetrainRepCost() {
		return drivetrainRepCost;
	}
	public void setDrivetrainRepCost(Integer drivetrainRepCost) {
		this.drivetrainRepCost = drivetrainRepCost;
	}
	public String getDrivetrainInsDesc() {
		return drivetrainInsDesc;
	}
	public void setDrivetrainInsDesc(String drivetrainInsDesc) {
		this.drivetrainInsDesc = drivetrainInsDesc;
	}
	public String getDrivetrainRepDesc() {
		return drivetrainRepDesc;
	}
	public void setDrivetrainRepDesc(String drivetrainRepDesc) {
		this.drivetrainRepDesc = drivetrainRepDesc;
	}
	public String getBrakeDate() {
		return brakeDate;
	}
	public void setBrakeDate(String brakeDate) {
		this.brakeDate = brakeDate;
	}
	public Integer getBrakeInsCost() {
		return brakeInsCost;
	}
	public void setBrakeInsCost(Integer brakeInsCost) {
		this.brakeInsCost = brakeInsCost;
	}
	public Integer getBrakeRepCost() {
		return brakeRepCost;
	}
	public void setBrakeRepCost(Integer brakeRepCost) {
		this.brakeRepCost = brakeRepCost;
	}
	public String getBrakeInsDesc() {
		return brakeInsDesc;
	}
	public void setBrakeInsDesc(String brakeInsDesc) {
		this.brakeInsDesc = brakeInsDesc;
	}
	public String getBrakeRepDesc() {
		return brakeRepDesc;
	}
	public void setBrakeRepDesc(String brakeRepDesc) {
		this.brakeRepDesc = brakeRepDesc;
	}
	public String getWheelDate() {
		return wheelDate;
	}
	public void setWheelDate(String wheelDate) {
		this.wheelDate = wheelDate;
	}
	public Integer getWheelInsCost() {
		return wheelInsCost;
	}
	public void setWheelInsCost(Integer wheelInsCost) {
		this.wheelInsCost = wheelInsCost;
	}
	public Integer getWheelRepCost() {
		return wheelRepCost;
	}
	public void setWheelRepCost(Integer wheelRepCost) {
		this.wheelRepCost = wheelRepCost;
	}
	public String getWheelInsDesc() {
		return wheelInsDesc;
	}
	public void setWheelInsDesc(String wheelInsDesc) {
		this.wheelInsDesc = wheelInsDesc;
	}
	public String getWheelRepDesc() {
		return wheelRepDesc;
	}
	public void setWheelRepDesc(String wheelRepDesc) {
		this.wheelRepDesc = wheelRepDesc;
	}
	public String getCockpits() {
		return cockpits;
	}
	public void setCockpits(String cockpits) {
		this.cockpits = cockpits;
	}
	public String getCockpitDate() {
		return cockpitDate;
	}
	public void setCockpitDate(String cockpitDate) {
		this.cockpitDate = cockpitDate;
	}
	public Integer getCockpitInsCost() {
		return cockpitInsCost;
	}
	public void setCockpitInsCost(Integer cockpitInsCost) {
		this.cockpitInsCost = cockpitInsCost;
	}
	public Integer getCockpitRepCost() {
		return cockpitRepCost;
	}
	public void setCockpitRepCost(Integer cockpitRepCost) {
		this.cockpitRepCost = cockpitRepCost;
	}
	public String getCockpitInsDesc() {
		return cockpitInsDesc;
	}
	public void setCockpitInsDesc(String cockpitInsDesc) {
		this.cockpitInsDesc = cockpitInsDesc;
	}
	public String getCockpitRepDesc() {
		return cockpitRepDesc;
	}
	public void setCockpitRepDesc(String cockpirRepDesc) {
		this.cockpitRepDesc = cockpirRepDesc;
	}
	public String getEtcs() {
		return etcs;
	}
	public void setEtcs(String etcs) {
		this.etcs = etcs;
	}
	public String getEtcDate() {
		return etcDate;
	}
	public void setEtcDate(String etcDate) {
		this.etcDate = etcDate;
	}
	public Integer getEtcInsCost() {
		return etcInsCost;
	}
	public void setEtcInsCost(Integer etcInsCost) {
		this.etcInsCost = etcInsCost;
	}
	public Integer getEtcRepCost() {
		return etcRepCost;
	}
	public void setEtcRepCost(Integer etcRepCost) {
		this.etcRepCost = etcRepCost;
	}
	public String getEtcInsDesc() {
		return etcInsDesc;
	}
	public void setEtcInsDesc(String etcInsDesc) {
		this.etcInsDesc = etcInsDesc;
	}
	public String getEtcRepDesc() {
		return etcRepDesc;
	}
	public void setEtcRepDesc(String etcRepDesc) {
		this.etcRepDesc = etcRepDesc;
	}
	public String getExpendables() {
		return expendables;
	}
	public void setExpendables(String expendables) {
		this.expendables = expendables;
	}
	public String getExpendableDate() {
		return expendableDate;
	}
	public void setExpendableDate(String expendableDate) {
		this.expendableDate = expendableDate;
	}
	public Integer getExpendableCost1() {
		return expendableCost1;
	}
	public void setExpendableCost1(Integer expendableCost1) {
		this.expendableCost1 = expendableCost1;
	}
	public Integer getExpendableCost2() {
		return expendableCost2;
	}
	public void setExpendableCost2(Integer expendableCost2) {
		this.expendableCost2 = expendableCost2;
	}
	public Integer getExpendableCost3() {
		return expendableCost3;
	}
	public void setExpendableCost3(Integer expendableCost3) {
		this.expendableCost3 = expendableCost3;
	}
	public Integer getExpendableCost4() {
		return expendableCost4;
	}
	public void setExpendableCost4(Integer expendableCost4) {
		this.expendableCost4 = expendableCost4;
	}
	public Integer getExpendableCost5() {
		return expendableCost5;
	}
	public void setExpendableCost5(Integer expendableCost5) {
		this.expendableCost5 = expendableCost5;
	}
	public Integer getExpendableCosts() {
		return expendableCosts;
	}
	public void setExpendableCosts(Integer expendableCosts) {
		this.expendableCosts = expendableCosts;
	}
	public String getExpendableDesc() {
		return expendableDesc;
	}
	public void setExpendableDesc(String expendableDesc) {
		this.expendableDesc = expendableDesc;
	}
	public Integer getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
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
	public String getReservation_rsrvSeq() {
		return reservation_rsrvSeq;
	}
	public void setReservation_rsrvSeq(String reservation_rsrvSeq) {
		this.reservation_rsrvSeq = reservation_rsrvSeq;
	}
	public String getShop_shopSeq() {
		return shop_shopSeq;
	}
	public void setShop_shopSeq(String shop_shopSeq) {
		this.shop_shopSeq = shop_shopSeq;
	}
	public String getBicycle_bikeSeq() {
		return bicycle_bikeSeq;
	}
	public void setBicycle_bikeSeq(String bicycle_bikeSeq) {
		this.bicycle_bikeSeq = bicycle_bikeSeq;
	}

}
