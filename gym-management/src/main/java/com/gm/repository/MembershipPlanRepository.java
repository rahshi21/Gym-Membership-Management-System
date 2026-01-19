package com.gm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gm.entity.MembershipPlan;
import com.gm.enums.MembershipPlanStatus;

@Repository
public interface MembershipPlanRepository extends JpaRepository<MembershipPlan, Long>{
	
	List<MembershipPlan> findByStatus(MembershipPlanStatus status);

}
