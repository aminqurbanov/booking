package com.example.relations.controller;

import com.example.relations.dto.Request.PaymentRequest;
import com.example.relations.dto.Response.PaymentResponse;
import com.example.relations.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/payments")
public class PaymentController {
    private final PaymentService paymentService;

    @GetMapping
    public ResponseEntity<List<PaymentResponse>> findAll(){
        return new ResponseEntity<>(paymentService.findAll(), HttpStatus.OK);
    }
    @PostMapping
    private ResponseEntity<PaymentResponse> save(@RequestBody PaymentRequest paymentRequest){
        return new ResponseEntity<>(paymentService.save(paymentRequest), HttpStatus.CREATED);
    }
    @GetMapping("/{id}/")
    public ResponseEntity<PaymentResponse> findById(@PathVariable Long paymentId){
        return new ResponseEntity<>(paymentService.findById(paymentId), HttpStatus.OK);

    }
    @PutMapping("/{id}/")
    public ResponseEntity<PaymentResponse> update(@PathVariable Long paymentId,@RequestBody PaymentRequest paymentRequest){
        return new ResponseEntity<>(paymentService.update(paymentId, paymentRequest), HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}/")
    public void delete(@PathVariable Long paymentId){
        paymentService.delete(paymentId);
    }


}
