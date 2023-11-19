package com.example.relations.service;

import com.example.relations.dto.Request.PaymentRequest;
import com.example.relations.dto.Response.PaymentResponse;

import java.util.List;

public interface PaymentService {
    List<PaymentResponse> findAll();

    PaymentResponse save(PaymentRequest paymentRequest);
    PaymentResponse findById(Long paymentId);
    PaymentResponse update(Long paymentId,PaymentRequest paymentRequest);
    void delete(Long paymentId);
}
