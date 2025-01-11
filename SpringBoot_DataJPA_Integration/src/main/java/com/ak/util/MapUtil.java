package com.ak.util;

import com.ak.dto.CricketStaffDTO;
import com.ak.entity.CricketStaff;

public class MapUtil {

	public static CricketStaffDTO convertToDTO(CricketStaff staff) {
		return new CricketStaffDTO(staff.getStaffId(), staff.getStaffName(), staff.getStaffDept(), staff.getStaffAge(), staff.getStaffNoOfYearsToBCCI());
	}
	
	public static CricketStaff convertToEntity(CricketStaffDTO staffDTO) {
		return new CricketStaff(staffDTO.getStaffId(), staffDTO.getStaffName(), staffDTO.getStaffDept(), staffDTO.getStaffAge(), staffDTO.getStaffNoOfYearsToBCCI());
	}
}
