package com.ms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.dto.request.PurchaseMembershipRequest;
import com.ms.dto.response.PaymentResponse;
import com.ms.service.PaymentService;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/membership/{planId}")
    public ResponseEntity<PaymentResponse> purchaseMembership(
            @PathVariable Long planId,
            @RequestBody PurchaseMembershipRequest req) {
    	
    	PaymentResponse response = paymentService.purchaseMembership(planId, req.getCustomerId());
		return new ResponseEntity<>(response, HttpStatus.CREATED);

    }
}
