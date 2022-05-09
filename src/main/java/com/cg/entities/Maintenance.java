package com.cg.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "Maintenance")
public class Maintenance {
	@Id
	@GeneratedValue
	@Column(name = "maintenanceId")
	private int maintenanceId ;
	
	@Column(name = "maintenanceType")
	@NotBlank(message = "MaintenanceType cannot be Blank")
	private String maintenanceType;
	
	@Column(name = "maintenanceCharges")
	private Double maintenanceCharges;
	
	
	@Column(name = "propertyId")
	private long propertyId;
	
	
	@Column(name = "Duration_Months")
	private int months ; 
	
	@NotBlank(message = "Property Name cannot be Blank")
	private String propertyName;

	public int getMaintenanceId() {
		return maintenanceId;
	}

	public void setMaintenanceId(int maintenanceId) {
		this.maintenanceId = maintenanceId;
	}

	public String getMaintenanceType() {
		return maintenanceType;
	}

	public void setMaintenanceType(String maintenanceType) {
		this.maintenanceType = maintenanceType;
	}

	

	public double getMaintenanceCharges() {
		return maintenanceCharges;
	}

	public void setMaintenanceCharges(double maintenanceCharges) {
		this.maintenanceCharges = maintenanceCharges;
	}
	

	public int getMonths() {
		return months;
	}

	public void setMonths(int months) {
		this.months = months;
	}

	public long getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(long propertyId) {
		this.propertyId = propertyId;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	@Override
	public String toString() {
		return "Maintenance [maintenanceId=" + maintenanceId + ", maintenanceType=" + maintenanceType
				+ ", maintenanceCharges=" + maintenanceCharges + ", propertyId=" + propertyId + ", months=" + months
				+ ", propertyName=" + propertyName + "]";
	}

	
	

	
}