package com.bicycledoctors.module.insRep;

import com.bicycledoctors.module.bicycle.BicycleDto;

public class InsRepDto extends BicycleDto {

	private String irSeq;
    private String inspectRepairDate;
    private String drivetrainDate;
    private double drivetrainInsCost;
    private double drivetrainRepCost;
    private String drivetrainInsDesc;
    private String drivetrainRepDesc;
    private String brakeDate;
    private double brakeInsCost;
    private double brakeRepCost;
    private String brakeInsDesc;
    private String brakeRepDesc;
    private String wheelDate;
    private double wheelInsCost;
    private double wheelRepCost;
    private String wheelInsDesc;
    private String wheelRepDesc;
    private String cockpits;
    private String cockpitDate;
    private double cockpitInsCost;
    private double cockpitRepCost;
    private String cockpitInsDesc;
    private String cockpirRepDesc;
    private String etcs;
    private String etcDate;
    private double etcInsCost;
    private double etcRepCost;
    private String etcInsDesc;
    private String etcRepDesc;
    private String expendables;
    private String expendableDate;
    private double expendableCost1;
    private double expendableCost2;
    private double expendableCost3;
    private double expendableCost4;
    private double expendableCost5;
    private double expendableCosts;
    private String expendableDesc;
    private double totalPrice;
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
	public double getDrivetrainInsCost() {
		return drivetrainInsCost;
	}
	public void setDrivetrainInsCost(double drivetrainInsCost) {
		this.drivetrainInsCost = drivetrainInsCost;
	}
	public double getDrivetrainRepCost() {
		return drivetrainRepCost;
	}
	public void setDrivetrainRepCost(double drivetrainRepCost) {
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
	public double getBrakeInsCost() {
		return brakeInsCost;
	}
	public void setBrakeInsCost(double brakeInsCost) {
		this.brakeInsCost = brakeInsCost;
	}
	public double getBrakeRepCost() {
		return brakeRepCost;
	}
	public void setBrakeRepCost(double brakeRepCost) {
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
	public double getWheelInsCost() {
		return wheelInsCost;
	}
	public void setWheelInsCost(double wheelInsCost) {
		this.wheelInsCost = wheelInsCost;
	}
	public double getWheelRepCost() {
		return wheelRepCost;
	}
	public void setWheelRepCost(double wheelRepCost) {
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
	public double getCockpitInsCost() {
		return cockpitInsCost;
	}
	public void setCockpitInsCost(double cockpitInsCost) {
		this.cockpitInsCost = cockpitInsCost;
	}
	public double getCockpitRepCost() {
		return cockpitRepCost;
	}
	public void setCockpitRepCost(double cockpitRepCost) {
		this.cockpitRepCost = cockpitRepCost;
	}
	public String getCockpitInsDesc() {
		return cockpitInsDesc;
	}
	public void setCockpitInsDesc(String cockpitInsDesc) {
		this.cockpitInsDesc = cockpitInsDesc;
	}
	public String getCockpirRepDesc() {
		return cockpirRepDesc;
	}
	public void setCockpirRepDesc(String cockpirRepDesc) {
		this.cockpirRepDesc = cockpirRepDesc;
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
	public double getEtcInsCost() {
		return etcInsCost;
	}
	public void setEtcInsCost(double etcInsCost) {
		this.etcInsCost = etcInsCost;
	}
	public double getEtcRepCost() {
		return etcRepCost;
	}
	public void setEtcRepCost(double etcRepCost) {
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
	public double getExpendableCost1() {
		return expendableCost1;
	}
	public void setExpendableCost1(double expendableCost1) {
		this.expendableCost1 = expendableCost1;
	}
	public double getExpendableCost2() {
		return expendableCost2;
	}
	public void setExpendableCost2(double expendableCost2) {
		this.expendableCost2 = expendableCost2;
	}
	public double getExpendableCost3() {
		return expendableCost3;
	}
	public void setExpendableCost3(double expendableCost3) {
		this.expendableCost3 = expendableCost3;
	}
	public double getExpendableCost4() {
		return expendableCost4;
	}
	public void setExpendableCost4(double expendableCost4) {
		this.expendableCost4 = expendableCost4;
	}
	public double getExpendableCost5() {
		return expendableCost5;
	}
	public void setExpendableCost5(double expendableCost5) {
		this.expendableCost5 = expendableCost5;
	}
	public double getExpendableCosts() {
		return expendableCosts;
	}
	public void setExpendableCosts(double expendableCosts) {
		this.expendableCosts = expendableCosts;
	}
	public String getExpendableDesc() {
		return expendableDesc;
	}
	public void setExpendableDesc(String expendableDesc) {
		this.expendableDesc = expendableDesc;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
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
