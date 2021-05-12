package com.cg.mts.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cg.mts.entities.AdmissionCommiteeMember;


public interface IAdmissionCommiteeMemberRepository extends CrudRepository<AdmissionCommiteeMember,Integer> {
//public  AdmissionCommiteeMember addCommiteeMember(AdmissionCommiteeMember member);
//public AdmissionCommiteeMember updateCommiteeMember(AdmissionCommiteeMember member);
	public AdmissionCommiteeMember findByadminId(int adminId);
//public void removeCommiteeMember(int adminId);
//public List<AdmissionCommiteeMember> viewAllCommiteeMembers();
}
