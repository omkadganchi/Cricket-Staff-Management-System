package com.ak.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ak.dao.CricketStaffRepository;
import com.ak.dto.CricketStaffDTO;
import com.ak.entity.CricketStaff;
import com.ak.exception.IdUpdateNotAllowedException;
import com.ak.exception.ResourceNotFoundException;
import com.ak.util.MapUtil;

@Service
public class CricketStaffService {

	@Autowired
	CricketStaffRepository repository;

	@Transactional(readOnly = true)
	public CricketStaffDTO getStaffById(int id) {
		return repository.findById(id)
				.map(MapUtil::convertToDTO)
				.orElseThrow(() -> new ResourceNotFoundException("Staff not found with ID: " + id));
	}

	@Transactional(readOnly = true)
	public CricketStaffDTO getStaffByName(String name) {
		return repository.findByStaffName(name)
				.map(MapUtil::convertToDTO)
				.orElseThrow(() -> new ResourceNotFoundException("Staff not found with name: " + name));
	}

	@Transactional(readOnly = true)
	public List<CricketStaffDTO> getStaffByDept(String dept) {
		List<CricketStaffDTO> staffDTOs = new ArrayList<>();
		List<CricketStaff> list = repository.findByStaffDept(dept);
		for (CricketStaff cricketStaff : list) {
			staffDTOs.add(MapUtil.convertToDTO(cricketStaff));
		}
		return staffDTOs;
	}

	@Transactional(readOnly = true)
	public List<CricketStaffDTO> getStaffByAge(int age) {
		return repository.findByStaffAge(age).stream()
				.map(MapUtil::convertToDTO)
				.collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public List<CricketStaffDTO> getStaffWithYearsGreaterThan(int years) {
		return repository.findByStaffNoOfYearsToBCCIGreaterThan(years).stream()
				.map(MapUtil::convertToDTO)
				.collect(Collectors.toList());
	}


	@Transactional
	public CricketStaffDTO createStaff(CricketStaffDTO staffDTO){
		CricketStaff staff = MapUtil.convertToEntity(staffDTO);
		CricketStaff cricketStaff = repository.save(staff);
		return MapUtil.convertToDTO(cricketStaff);
	}

	@Transactional
	public CricketStaffDTO updateStaffById(int id, CricketStaffDTO staffDto) throws IdUpdateNotAllowedException {
		if (staffDto.getStaffId() != 0 && staffDto.getStaffId() != id) {
	        throw new IdUpdateNotAllowedException("The staff ID cannot be updated. The ID is immutable.");
	    }
		return repository.findById(id)
				.map(existingStaff -> {
					existingStaff.setStaffName(staffDto.getStaffName());
					existingStaff.setStaffAge(staffDto.getStaffAge());
					existingStaff.setStaffDept(staffDto.getStaffDept());
					existingStaff.setStaffNoOfYearsToBCCI(staffDto.getStaffNoOfYearsToBCCI());
					repository.save(existingStaff);
					return MapUtil.convertToDTO(existingStaff);
				})
				.orElseThrow(() -> new ResourceNotFoundException("Staff not found with ID: " + id));
	}



	@Transactional
	public CricketStaffDTO partialUpdateStaffById(int id, CricketStaffDTO staffDTO) {
		if (staffDTO.getStaffId() != 0 && staffDTO.getStaffId() != id) {
            throw new UnsupportedOperationException("The staff ID cannot be updated. The ID is immutable.");
        }
		 CricketStaff existingStaff = repository.findById(id)
			        .orElseThrow(() -> new ResourceNotFoundException("Staff not found with ID: " + id));

			    if (staffDTO.getStaffName() != null) {
			        existingStaff.setStaffName(staffDTO.getStaffName());
			    }
			    if (staffDTO.getStaffDept() != null) {
			        existingStaff.setStaffDept(staffDTO.getStaffDept());
			    }
			    if (staffDTO.getStaffAge() != 0) {
			        existingStaff.setStaffAge(staffDTO.getStaffAge());
			    }
			    if (staffDTO.getStaffNoOfYearsToBCCI() != 0) {
			        existingStaff.setStaffNoOfYearsToBCCI(staffDTO.getStaffNoOfYearsToBCCI());
			    }
			    CricketStaff updatedStaff = repository.save(existingStaff);
			    return MapUtil.convertToDTO(updatedStaff);
	}

	@Transactional
	public String deleteStaffById(int id) {
		return repository.findById(id)
				.map(staff -> {
					repository.delete(staff);
					return "Staff deleted successfully";
				})
				.orElseThrow(() -> new ResourceNotFoundException("Staff not found with ID: " + id));
	}
}
