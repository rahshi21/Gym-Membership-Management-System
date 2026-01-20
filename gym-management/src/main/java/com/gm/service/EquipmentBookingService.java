package com.gm.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gm.dto.request.CancelEquipmentBookingRequest;
import com.gm.dto.request.CreateEquipmentBookingRequest;
import com.gm.dto.response.EquipmentBookingResponse;
import com.gm.entity.Equipment;
import com.gm.entity.EquipmentBooking;
import com.gm.entity.Member;
import com.gm.enums.EquipmentStatus;
import com.gm.exception.BookingNotFoundException;
import com.gm.exception.EquipmentNotFoundException;
import com.gm.exception.MemberNotFoundException;
import com.gm.mapper.EquipmentBookingMapper;
import com.gm.repository.EquipmentBookingRepository;
import com.gm.repository.EquipmentRepository;
import com.gm.repository.MemberRepository;

@Service
public class EquipmentBookingService {

    @Autowired
    private EquipmentBookingRepository bookingRepo;

    @Autowired
    private EquipmentRepository equipmentRepo;

    @Autowired
    private MemberRepository memberRepo;
    
    @Autowired
    private EquipmentBookingMapper mapper;

    
    public EquipmentBookingResponse bookEquipment(CreateEquipmentBookingRequest request) {

        Member member = memberRepo.findById(request.getMemberId())
                .orElseThrow(() -> new MemberNotFoundException("Member not found"));

        Equipment equipment = equipmentRepo.findById(request.getEquipmentId())
                .orElseThrow(() -> new EquipmentNotFoundException("Equipment not found"));

        if (equipment.getStatus() != EquipmentStatus.WORKING ||
            equipment.getAvailableQuantity() <= 0) {
            throw new EquipmentNotFoundException("Equipment not available");
        }

        equipment.setAvailableQuantity(
                equipment.getAvailableQuantity() - 1
        );
        equipmentRepo.save(equipment);

        EquipmentBooking booking = new EquipmentBooking();
        booking.setMember(member);
        booking.setEquipment(equipment);
        booking.setBookingDate(LocalDate.now());
        booking.setTimeslot(request.getTimeslot());
        booking.setCreatedAt(LocalDateTime.now());

        EquipmentBooking saved = bookingRepo.save(booking);

        return mapper.toResponse(saved);
    }

    public List<EquipmentBookingResponse> getBookingsByMember(Long id) {

        List<EquipmentBooking> bookings =
                bookingRepo.findByMemberId(id);

        List<EquipmentBookingResponse> responses = new ArrayList<>();

        for (EquipmentBooking booking : bookings) {
            responses.add(mapper.toResponse(booking));
        }

        return responses;
    }

    public List<EquipmentBookingResponse> getBookingsByEquipment(Long id) {

        List<EquipmentBooking> bookings =
                bookingRepo.findByEquipmentId(id);

        List<EquipmentBookingResponse> responses = new ArrayList<>();

        for (EquipmentBooking booking : bookings) {
            responses.add(mapper.toResponse(booking));
        }

        return responses;
    }
    
    public List<EquipmentBookingResponse> getBookingsByDateRange(
            LocalDateTime startDate,
            LocalDateTime endDate) {

        List<EquipmentBooking> bookings =
                bookingRepo.findByBookingDateBetween(startDate, endDate);

        List<EquipmentBookingResponse> responses = new ArrayList<>();

        for (EquipmentBooking booking : bookings) {
            responses.add(mapper.toResponse(booking));
        }

        return responses;
    }

    
    public void cancelBooking(CancelEquipmentBookingRequest request) {

        EquipmentBooking booking = bookingRepo.findById(request.getBookingId())
                .orElseThrow(() -> new BookingNotFoundException("Booking not found"));

        Equipment equipment = booking.getEquipment();

        // Restore available quantity
        equipment.setAvailableQuantity(
                equipment.getAvailableQuantity() + 1
        );
        equipmentRepo.save(equipment);

        // Delete booking
        bookingRepo.delete(booking);
        
    }
    
    public List<EquipmentBookingResponse> getAllBookings() {

    	return bookingRepo.findAll()
				.stream()
				.map(mapper::toResponse)
				.collect(Collectors.toList());
    }



}
