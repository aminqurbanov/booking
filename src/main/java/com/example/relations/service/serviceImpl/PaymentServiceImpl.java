package com.example.relations.service.serviceImpl;

import com.example.relations.domain.Payment;
import com.example.relations.domain.User;
import com.example.relations.dto.Request.PaymentRequest;
import com.example.relations.dto.Response.PaymentResponse;
import com.example.relations.dto.Response.UserResponse;
import com.example.relations.repository.PaymentRepository;
import com.example.relations.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<PaymentResponse> findAll() {
        return paymentRepository
                .findAll()
                .stream()
                .map(payment -> modelMapper.map(payment, PaymentResponse.class))
                .collect(Collectors.toList());

    }

    @Override
    public PaymentResponse save(PaymentRequest paymentRequest) {
        Payment payment = modelMapper.map(paymentRequest, Payment.class);
        Payment save = paymentRepository.save(payment);
        return modelMapper.map(save, PaymentResponse.class);
    }

    @Override
    public PaymentResponse findById(Long paymentId) {
        Payment payment = paymentRepository.findById(paymentId).orElseThrow(() -> new RuntimeException(
                String.format("Payment not found by id-%s", paymentId)
        ));
        return modelMapper.map(payment, PaymentResponse.class);
    }

    @Override
    public PaymentResponse update(Long paymentId, PaymentRequest paymentRequest) {
        paymentRepository.findById(paymentId).orElseThrow(() -> new RuntimeException(
                String.format("Payment not found for updating by id -%s", paymentId)));
        Payment responsePayment = modelMapper.map(paymentRequest, Payment.class);
        responsePayment.setPaymentId(paymentId);
        return modelMapper.map(paymentRepository.save(responsePayment), PaymentResponse.class);
    }
    @Override
    public void delete(Long paymentId) {
        Payment payment = paymentRepository.findById(paymentId).orElseThrow(() -> new RuntimeException(
                String.format("Payment not found by Id-%s", paymentId)
        ));
        paymentRepository.delete(payment);
    }

}
