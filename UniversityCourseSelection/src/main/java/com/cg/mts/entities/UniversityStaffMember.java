package com.cg.mts.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UniversityStaffMember {
	@Id
	@Column(name = "staffId",length=20)
	private int staffId;
	@Column(name = "password",length=20)
	private String password;
	@Column(name = "role",length=20)
	private String role;

	public UniversityStaffMember() {
	}

	public UniversityStaffMember(int staffId, String password, String role) {

		this.staffId = staffId;
		this.password = password;
		this.role = role;
	}

	public int getStaffId() {
		return staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}