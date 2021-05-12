package com.cg.mts.controllers;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.mts.entities.Admission;
import com.cg.mts.entities.Applicant;
import com.cg.mts.exception.AdmissionNotGrantedException;
import com.cg.mts.exception.CourseNotFoundException;
import com.cg.mts.service.AdmissionServiceImpl;

@RestController
public class AdmissionController {
	
	@Autowired
	private AdmissionServiceImpl admissionservice;
	
	@RequestMapping("/admissions/course/{courseId}")
	public List<Admission> showAllAdmissionsByCourseId(@PathVariable int courseId)
	{
		return admissionservice.showAllAdmissionsByCourseId(courseId);
	}
	
	@RequestMapping("/admissions/{admissionDate}")
	public List<Admission> showAllAdmissionsByDate(@RequestParam("admissionDate")@DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate admissionDate)
	{
		return admissionservice.showAllAdmissionsByDate(admissionDate);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/admissions")
	public ResponseEntity<Object> addAdmission(@RequestBody Admission admission)
	{
		admissionservice.addAdmission(admission);
		return new ResponseEntity<Object>("Admission Added Successfully",HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/admissions/{admissionId}")
	public ResponseEntity<Object> updateAdmission(@RequestBody Admission admission,@PathVariable int admissionId) throws AdmissionNotGrantedException
	{
		Admission a = admissionservice.showAdmissionByAdmissionId(admissionId);
		if(a==null)
			throw new AdmissionNotGrantedException("No admission found for AdmissionID:"+ admissionId);
		else
		{
			admissionservice.updateAdmission(admission);
			return new ResponseEntity<Object>("Admission Updated Successfully",HttpStatus.ACCEPTED);
		}
			
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/admissions/{admissionId}")
	public ResponseEntity<Object> deleteAdmission(@PathVariable int admissionId) throws AdmissionNotGrantedException
	{
		Admission a = admissionservice.showAdmissionByAdmissionId(admissionId);
		if(a==null)
			throw new AdmissionNotGrantedException("No admission found for for AdmissionID:"+ admissionId);
		else
		{
			admissionservice.cancelAdmission(admissionId);
			return new ResponseEntity<Object>("Admission Deleted Successfully",HttpStatus.ACCEPTED);
		}
			
	}
	
	

}
