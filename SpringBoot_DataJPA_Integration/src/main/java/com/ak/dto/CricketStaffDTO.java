package com.ak.dto;

public class CricketStaffDTO {

    private int staffId;
    private String staffName;
    private String staffDept;
    private int staffAge;
    private int staffNoOfYearsToBCCI;
	
    public CricketStaffDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CricketStaffDTO(int staffId, String staffName, String staffDept, int staffAge, int staffNoOfYearsToBCCI) {
		super();
		this.staffId = staffId;
		this.staffName = staffName;
		this.staffDept = staffDept;
		this.staffAge = staffAge;
		this.staffNoOfYearsToBCCI = staffNoOfYearsToBCCI;
	}

	public CricketStaffDTO(String staffName, String staffDept, int staffAge, int staffNoOfYearsToBCCI) {
		super();
		this.staffName = staffName;
		this.staffDept = staffDept;
		this.staffAge = staffAge;
		this.staffNoOfYearsToBCCI = staffNoOfYearsToBCCI;
	}

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

	@Override
	public String toString() {
		return "CricketStaffDTO [staffId=" + staffId + ", staffName=" + staffName + ", staffDept=" + staffDept
				+ ", staffAge=" + staffAge + ", staffNoOfYearsToBCCI=" + staffNoOfYearsToBCCI + "]";
	}
}
