package com.cg.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="manager")
@DiscriminatorValue(value="manager")
public class Manager extends Person{
	
	@Column
	private String qualification;
	
	@Column
	private String certification;
	
	@Column 
	private String dateOfJoining;

	public Manager() {}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getCertification() {
		return certification;
	}

	public void setCertification(String certification) {
		this.certification = certification;
	}

	public String getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(String dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}


	@Override
	public String toString() {
		return "Manager [qualification=" + qualification + ", certification=" + certification + ", dateOfJoining="
				+ dateOfJoining + "]";
	}



}
