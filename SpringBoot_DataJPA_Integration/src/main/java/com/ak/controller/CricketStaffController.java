package com.ak.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ak.dto.CricketStaffDTO;
import com.ak.exception.IdUpdateNotAllowedException;
import com.ak.service.CricketStaffService;

@RestController
@RequestMapping("/api/staff")
public class CricketStaffController {

	@Autowired
	CricketStaffService service;

	@GetMapping("/{id}")
	public ResponseEntity<CricketStaffDTO> getStaffById(@PathVariable int id) {
		return ResponseEntity.ok(service.getStaffById(id));                            // SpringBoot internally handles and returns appropriate HTTP code
		                                   // OR
		//return ResponseEntity.status(HttpStatus.NOT_FOUND).body(service.getStaffById(id));                // explicitly handles the HTTP code
	}

	@GetMapping("/by-name")
	public ResponseEntity<CricketStaffDTO> getStaffByName(@RequestParam String name) {
		return ResponseEntity.ok(service.getStaffByName(name));
	}

	@GetMapping("/by-dept")
	public ResponseEntity<List<CricketStaffDTO>> getStaffByDept(@RequestParam String dept) {
		return ResponseEntity.ok(service.getStaffByDept(dept));
	}

	@GetMapping("/by-age/{age}")
	public ResponseEntity<List<CricketStaffDTO>> getStaffByAge(@PathVariable int age) {
		if (age < 0) {
			throw new IllegalArgumentException("Age cannot be negative");
		}
		return ResponseEntity.ok(service.getStaffByAge(age));
	}

	@GetMapping("/with-years-greater-than")
	public ResponseEntity<List<CricketStaffDTO>> getStaffWithYearsGreaterThan(@RequestParam int years) {
		if (years < 0) {
			throw new IllegalArgumentException("Years cannot be negative");
		}
		return ResponseEntity.ok(service.getStaffWithYearsGreaterThan(years));
	}
	
	@PostMapping("/create-staff")
	public ResponseEntity<CricketStaffDTO> createStaff(@RequestBody CricketStaffDTO staffDTO) {
		return ResponseEntity.ok(service.createStaff(staffDTO));
	}
	
	@PutMapping("/update-staff/{id}")
	public ResponseEntity<CricketStaffDTO> updateStaffById(@PathVariable int id, @RequestBody CricketStaffDTO staffDTO) throws IdUpdateNotAllowedException {
		return ResponseEntity.ok(service.updateStaffById(id,staffDTO));
	}
	
	@PatchMapping("/update-staff/{id}")
	public ResponseEntity<CricketStaffDTO> partialUpdateStaffById(@PathVariable int id, @RequestBody CricketStaffDTO staffDTO){
		return ResponseEntity.ok(service.partialUpdateStaffById(id,staffDTO));
	}
	
	@DeleteMapping("/delete-staff/{id}")
	public ResponseEntity<String> deleteStaffById(@PathVariable int id) {
		return ResponseEntity.ok(service.deleteStaffById(id));
	}
}
