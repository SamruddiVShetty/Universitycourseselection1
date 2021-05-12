package com.cg.mts.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cg.mts.entities.Admission;
import com.cg.mts.exception.AdmissionNotGrantedException;

public interface IAdmissionRepository extends CrudRepository<Admission,Integer> {
//	public Admission addAdmission(Admission admission) throws AdmissionNotGrantedException;
//	public Admission updateAdmission(Admission admission) throws AdmissionNotGrantedException;
//	public Admission cancelAdmission(int admissionid) throws AdmissionNotGrantedException;
	//public List<Admission> showAllAdmissionsByDate(LocalDate admissiondate);
	//public List<Admission> showAllAdmissionsByApplicant(int applicantid);
	//public double calculateTotalCost(int bookingid);
	public List<Admission> findAllBycourseId(int courseId);
	public Admission findByadmissionId(int admissionId);
	public List<Admission> findAllByadmissionDate(LocalDate admissionDate);
	
	
	
}
