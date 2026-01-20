package com.gm.mapper;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.gm.dto.response.EquipmentBookingResponse;
import com.gm.entity.EquipmentBooking;

@Component
public class EquipmentBookingMapper {

    public EquipmentBookingResponse toResponse(EquipmentBooking booking) {

        EquipmentBookingResponse response = new EquipmentBookingResponse();
        response.setBookingId(booking.getId());
        response.setMemberId(booking.getMember().getId());
        response.setEquipmentId(booking.getEquipment().getId());
        response.setEquipmentName(booking.getEquipment().getEquipmentName());
        response.setBookingDate(booking.getBookingDate());
        response.setTimeslot(booking.getTimeslot());
        response.setCreatedAt(LocalDateTime.now());
        response.setUpdatedAt(LocalDateTime.now());

        return response;
    }
}

