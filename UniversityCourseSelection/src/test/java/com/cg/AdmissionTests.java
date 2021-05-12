package com.cg;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.mts.entities.Admission;
import com.cg.mts.entities.AdmissionStatus;
import com.cg.mts.entities.Course;
import com.cg.mts.exception.AdmissionNotGrantedException;
import com.cg.mts.exception.CourseNotFoundException;
import com.cg.mts.repository.IAdmissionRepository;
import com.cg.mts.service.IAdmissionService;

@SpringBootTest
class AdmissionTests {

	@Autowired
	private IAdmissionService service;

	@MockBean
	private IAdmissionRepository repo;

	@Test
	public void testAddAdmission() {
		Admission admission = new Admission(102, 112, "1", LocalDate.parse("2021-05-20"), AdmissionStatus.Applied);
		Mockito.when(repo.save(admission)).thenReturn(admission);

		assertEquals(admission, service.addAdmission(admission));

	}

	@Test
	public void testUpdateAdmission() throws AdmissionNotGrantedException {
		Admission admission = new Admission();
		admission.setAdmissionId(102);
		Mockito.when(repo.save(admission)).thenReturn(admission);
		Mockito.when(repo.existsById(102)).thenReturn(true);
		Admission updatedAdmission = service.updateAdmission(admission);

		assertEquals(admission.getAdmissionId(), updatedAdmission.getAdmissionId());

	}

	@Test
	public void testRemoveAdmission() throws AdmissionNotGrantedException {
		Admission admission = new Admission(102, 112, "1", LocalDate.parse("2021-05-20"), AdmissionStatus.Applied);
		service.cancelAdmission(102);
		verify(repo, times(1)).deleteById(102);
	}

	@Test
	public void testShowAllByCourseId() {
		Mockito.when(repo.findAllBycourseId(112))
				.thenReturn(Stream
						.of(new Admission(102, 112, "1", LocalDate.parse("2021-05-20"), AdmissionStatus.Applied),
								new Admission(103, 112, "1", LocalDate.parse("2021-05-20"), AdmissionStatus.Applied))
						.collect(Collectors.toList()));
		assertEquals(2, service.showAllAdmissionsByCourseId(112).size());

	}

	@Test
	public void testShowAllByDate() {
		Mockito.when(repo.findAllByadmissionDate(LocalDate.parse("2021-05-20")))
				.thenReturn(Stream
						.of(new Admission(102, 112, "1", LocalDate.parse("2021-05-20"), AdmissionStatus.Applied),
								new Admission(103, 112, "1", LocalDate.parse("2021-05-20"), AdmissionStatus.Applied))
						.collect(Collectors.toList()));
		assertEquals(2, service.showAllAdmissionsByDate(LocalDate.parse("2021-05-20")).size());

	}
	
	
	


}

/*@Test
public void testViewadmission() {
	Mockito.when(repo.findByadmissionId(1)).thenReturn(
			new Admission(1, 112, "1", LocalDate.parse("2021-05-20"), AdmissionStatus.Applied));
	assertEquals(1, service.showAdmissionByAdmissionId(1).getAdmissionId());
}*/