package com.gm.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gm.entity.DietPlan;
import com.gm.enums.DietPlanStatus;

@Repository
public interface DietPlanRepository extends JpaRepository<DietPlan, Long> {

	Optional<DietPlan> findByMemberIdAndStatusOfDiet(Long memberId, DietPlanStatus status);

	List<DietPlan> findByMemberId(Long memberId);

	List<DietPlan> findByTrainerId(Long trainerId);

}
