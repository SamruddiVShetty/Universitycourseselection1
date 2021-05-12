package com.cg.mts.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.mts.entities.Admission;
import com.cg.mts.exception.AdmissionNotGrantedException;
import com.cg.mts.repository.IAdmissionRepository;

@Service
public class AdmissionServiceImpl implements IAdmissionService {

	@Autowired
	private IAdmissionRepository admissionrepository;

	@Override
	public Admission addAdmission(Admission admission) {
		return admissionrepository.save(admission);

	}

	@Override
	public Admission updateAdmission(Admission admission) {
		return admissionrepository.save(admission);

	}

	@Override
	public void cancelAdmission(int admissionId) {
		admissionrepository.deleteById(admissionId);

	}

	@Override
	public List<Admission> showAllAdmissionsByCourseId(int courseId) {
		return (List<Admission>) admissionrepository.findAllBycourseId(courseId);
	}

	@Override
	public List<Admission> showAllAdmissionsByDate(LocalDate admissionDate) {
		return (List<Admission>) admissionrepository.findAllByadmissionDate(admissionDate);
	}


	public Admission showAdmissionByAdmissionId(int admissionId) {
		return admissionrepository.findByadmissionId(admissionId);
	}

}
