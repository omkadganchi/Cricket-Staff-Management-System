package com.ak.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CricketStaff {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int staffId;
	private String staffName;
	private String staffDept;
	private int staffAge;
	private int staffNoOfYearsToBCCI;

	// Getters and Setters
	public int getStaffId() {
		return staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getStaffDept() {
		return staffDept;
	}

	public void setStaffDept(String staffDept) {
		this.staffDept = staffDept;
	}

	public int getStaffAge() {
		return staffAge;
	}

	public void setStaffAge(int staffAge) {
		this.staffAge = staffAge;
	}

	public int getStaffNoOfYearsToBCCI() {
		return staffNoOfYearsToBCCI;
	}

	public void setStaffNoOfYearsToBCCI(int staffNoOfYearsToBCCI) {
		this.staffNoOfYearsToBCCI = staffNoOfYearsToBCCI;
	}

	public CricketStaff() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CricketStaff(int staffId, String staffName, String staffDept, int staffAge, int staffNoOfYearsToBCCI) {
		super();
		this.staffId = staffId;
		this.staffName = staffName;
		this.staffDept = staffDept;
		this.staffAge = staffAge;
		this.staffNoOfYearsToBCCI = staffNoOfYearsToBCCI;
	}

	public CricketStaff(String staffName, String staffDept, int staffAge, int staffNoOfYearsToBCCI) {
		super();
		this.staffName = staffName;
		this.staffDept = staffDept;
		this.staffAge = staffAge;
		this.staffNoOfYearsToBCCI = staffNoOfYearsToBCCI;
	}

	@Override
	public String toString() {
		return "CricketStaff [staffId=" + staffId + ", staffName=" + staffName + ", staffDept=" + staffDept
				+ ", staffAge=" + staffAge + ", staffNoOfYearsToBCCI=" + staffNoOfYearsToBCCI + "]";
	}
}
