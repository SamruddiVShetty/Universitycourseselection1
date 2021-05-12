package com.cg.mts.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cg.mts.entities.Course;
import com.cg.mts.exception.CourseNotFoundException;

public interface ICourseRepository extends CrudRepository<Course,Integer>{
	//public Course addCourse(Course course);
	//public Course removeCourse(int courseid) throws CourseNotFoundException;
	//public Course updateCourse(Course course) throws CourseNotFoundException;
	public Course findBycourseId(int courseid);
	//public List<Course> viewCourseList();
	
	
}
