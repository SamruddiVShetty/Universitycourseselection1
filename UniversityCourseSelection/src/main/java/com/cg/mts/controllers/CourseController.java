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
import com.cg.mts.exception.CourseNotFoundException;
import com.cg.mts.service.CourseServiceImpl;


@RestController
public class CourseController {
	
	@Autowired
	private CourseServiceImpl courseservice;
	
	@RequestMapping("/courses")
	public List<Course> viewAllCourses()
	{
		return courseservice.viewAllCourses();
	}
	
	@RequestMapping(value="/courses/{courseId}",produces="application/json")
	public ResponseEntity<Course> viewCourse(@PathVariable Integer courseId) throws CourseNotFoundException 
	{
		Course c = courseservice.viewCourse(courseId);
		if(c!=null)
			return new ResponseEntity<Course>(c,HttpStatus.OK);
		else
			throw new CourseNotFoundException("No course found with CourseID:"+ courseId);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/courses")
	public ResponseEntity<Object> addCourse(@RequestBody Course course)
	{
		courseservice.addCourse(course);
		return new ResponseEntity<Object>("Course Added Successfully",HttpStatus.ACCEPTED);
	}
	
	@SuppressWarnings("unlikely-arg-type")
	@RequestMapping(method=RequestMethod.PUT, value="/courses/{courseId}")
	public ResponseEntity<Object> updateCourse(@RequestBody Course course, @PathVariable Integer courseId) throws CourseNotFoundException
	{
		Course c = courseservice.viewCourse(courseId);
		if(c==null)
			throw new CourseNotFoundException("No course found with CourseID:"+ courseId);
		else {
			courseservice.updateCourse(course);
			return new ResponseEntity<Object>("Course Updated Successfully",HttpStatus.ACCEPTED);
		}
		
	}
	
	@SuppressWarnings("unlikely-arg-type")
	@RequestMapping(method=RequestMethod.DELETE, value="/courses/{courseId}")
	public ResponseEntity<Object> deleteCourse(@PathVariable Integer courseId) throws CourseNotFoundException
	{
		Course c = courseservice.viewCourse(courseId);
		if(c==null)
			throw new CourseNotFoundException("No course found with CourseID:"+ courseId);
		else
		{
			courseservice.removeCourse(courseId);
			return new ResponseEntity<Object>("Course Deleted Successfully",HttpStatus.ACCEPTED);
		}
			
	}
}
