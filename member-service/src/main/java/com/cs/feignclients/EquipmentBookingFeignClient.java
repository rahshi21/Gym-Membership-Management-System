package com.cs.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cs.dto.response.EquipmentBookingResponse;

@FeignClient(name="equipment-service", path="/api/equipment-bookings")	
public interface EquipmentBookingFeignClient {

	@GetMapping("/{id}")
	public ResponseEntity<EquipmentBookingResponse> getBooking(@PathVariable Long id);
}