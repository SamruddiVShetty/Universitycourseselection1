package com.cg.mts.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cg.mts.entities.AdmissionStatus;
import com.cg.mts.entities.Applicant;
import com.cg.mts.exception.ApplicantNotFoundException;


public interface IApplicantRepository extends CrudRepository<Applicant,String>{
	//public Applicant addApplicant(Applicant applicant);
	//public Applicant updateApplicant(Applicant applicant) throws ApplicantNotFoundException;
	//public Applicant deleteApplicant(Applicant applicant) throws ApplicantNotFoundException;
	public Applicant findByapplicantId(String applicantid); 
	//public List<Applicant> viewAllApplicantsByCourse(int courseid);
	public List<Applicant> findByStatus(AdmissionStatus status);
	

}
