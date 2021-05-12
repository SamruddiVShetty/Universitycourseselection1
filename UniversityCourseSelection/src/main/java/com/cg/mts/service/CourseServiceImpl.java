package com.cg.mts.service;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.mts.entities.Course;
import com.cg.mts.exception.CourseNotFoundException;
import com.cg.mts.repository.ICourseRepository;


@Service
public class CourseServiceImpl implements ICourseService{

	@Autowired
	private ICourseRepository courserepository;
	
	public CourseServiceImpl(ICourseRepository courserepository){
		this.courserepository = courserepository ; 
	}
	
	@Override
	public Course addCourse(Course course) {
		return courserepository.save(course);
	}

	@Override
	public void removeCourse(int courseId) {
		courserepository.deleteById(courseId);
	}

	@Override
	public Course updateCourse(Course course) {
		return courserepository.save(course);
	}

	@Override
	public Course viewCourse(int courseId)  {
		
		return courserepository.findBycourseId(courseId);
	}

	@Override
	public List<Course> viewAllCourses() {
		return (List<Course>) courserepository.findAll();
	}

}
