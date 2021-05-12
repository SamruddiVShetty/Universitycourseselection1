package com.cg.mts.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.mts.entities.Course;
import com.cg.mts.entities.UniversityStaffMember;
import com.cg.mts.repository.ICourseRepository;
import com.cg.mts.repository.IUniversityStaffRepository;

@Service
public class UniversityStaffServiceImpl implements IUniversityStaffService {

	@Autowired
	private IUniversityStaffRepository universitystaffrepository;
	
	@Autowired
	private ICourseRepository courserepository;
	
	@Override
	public UniversityStaffMember addStaff(UniversityStaffMember user) {
		return universitystaffrepository.save(user);
		
	}

	@Override
	public UniversityStaffMember updateStaff(UniversityStaffMember user) {
		return universitystaffrepository.save(user);
		
	}

	@Override
	public UniversityStaffMember viewStaff(int staffid) {
		return universitystaffrepository.findBystaffId(staffid);
	}

	@Override
	public void removeStaff(int staffid) {
		universitystaffrepository.deleteById(staffid);
		
	}

	@Override
	public List<UniversityStaffMember> viewAllStaffs() {
		return (List<UniversityStaffMember>) universitystaffrepository.findAll();
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

}
