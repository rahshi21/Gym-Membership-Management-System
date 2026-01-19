package com.gm.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gm.entity.EquipmentBooking;

@Repository
public interface EquipmentBookingRepository extends JpaRepository<EquipmentBooking, Long> {

	List<EquipmentBooking> findByCustomerId(Long customerId);

	List<EquipmentBooking> findByEquipmentId(Long equipmentId);

	List<EquipmentBooking> findByBookingDateBetween(LocalDateTime start, LocalDateTime end);

}
