package com.cg.mts.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.mts.entities.Course;
import com.cg.mts.entities.UniversityStaffMember;
import com.cg.mts.exception.CourseNotFoundException;
import com.cg.mts.service.CourseServiceImpl;
import com.cg.mts.service.UniversityStaffServiceImpl;

@RestController
public class UniversityStaffController {

	@Autowired
	UniversityStaffServiceImpl universitystaffservice;
	@Autowired
	private CourseServiceImpl courseservice;

	@RequestMapping("/universitystaff")
	public List<UniversityStaffMember> viewAllStaffs() {
		return universitystaffservice.viewAllStaffs();
	}

	@RequestMapping("/universitystaff/{staffid}")
	public UniversityStaffMember viewStaff(@PathVariable int staffid) {
		return universitystaffservice.viewStaff(staffid);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/universitystaff/{staffid}")
	public ResponseEntity<Object> removeStaff(@PathVariable int staffid) {
		universitystaffservice.removeStaff(staffid);
		return new ResponseEntity<Object>("UniversityStaff Deleted Successfully",HttpStatus.ACCEPTED);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/universitystaff/{staffid}")
	public ResponseEntity<Object> updateStaff(@RequestBody UniversityStaffMember user, @PathVariable Integer staffid) {
		universitystaffservice.updateStaff(user);
		return new ResponseEntity<Object>("UniversityStaff Updated Successfully",HttpStatus.ACCEPTED);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/universitystaff")
	public ResponseEntity<Object> addStaff(@RequestBody UniversityStaffMember user) {
		universitystaffservice.addStaff(user);
		return new ResponseEntity<Object>("UniversityStaff Added Successfully",HttpStatus.ACCEPTED);

	}

	@RequestMapping(method = RequestMethod.POST, value = "/universitystaff/courses")
	public ResponseEntity<Object> addCourse(@RequestBody Course course) {
		universitystaffservice.addCourse(course);
		return new ResponseEntity<Object>("Course Added Successfully", HttpStatus.ACCEPTED);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/universitystaff/courses/{courseId}")
	public ResponseEntity<Object> updateCourse(@RequestBody Course course, @PathVariable Integer courseId)
			throws CourseNotFoundException {
		Course c = courseservice.viewCourse(courseId);
		if (c == null)
			throw new CourseNotFoundException("No course found with CourseID:" + courseId);
		else {
			courseservice.updateCourse(course);
			return new ResponseEntity<Object>("Course Updated Successfully", HttpStatus.ACCEPTED);
		}

	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/universitystaff/courses/{courseId}")
	public ResponseEntity<Object> deleteCourse(@PathVariable Integer courseId) throws CourseNotFoundException {
		Course c = courseservice.viewCourse(courseId);
		if (c == null)
			throw new CourseNotFoundException("No course found with CourseID:" + courseId);
		else {
			courseservice.removeCourse(courseId);
			return new ResponseEntity<Object>("Course Deleted Successfully", HttpStatus.ACCEPTED);
		}

	}

}