package com.ak.dao;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ak.entity.CricketStaff;

@Repository
public interface CricketStaffRepository extends JpaRepository<CricketStaff, Integer>{

	Optional<CricketStaff> findByStaffName(String name);

	List<CricketStaff> findByStaffDept(String dept);

	List<CricketStaff> findByStaffAge(int age);

	List<CricketStaff> findByStaffNoOfYearsToBCCIGreaterThan(int years);

	
}
