package com.ms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ms.entity.MembershipPlan;

@Repository
public interface MembershipPlanRepository extends JpaRepository<MembershipPlan, Long>{

}
