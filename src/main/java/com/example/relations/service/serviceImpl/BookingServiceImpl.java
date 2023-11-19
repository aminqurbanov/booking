package com.example.relations.service.serviceImpl;

import com.example.relations.domain.Booking;
import com.example.relations.domain.Payment;
import com.example.relations.domain.User;
import com.example.relations.dto.Request.BookingRequest;
import com.example.relations.dto.Response.BookingResponse;
import com.example.relations.repository.BookingRepository;
import com.example.relations.repository.PaymentRepository;
import com.example.relations.repository.UserRepository;
import com.example.relations.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final PaymentRepository paymentRepository;


    public List<BookingResponse> findAll() {
        List<BookingResponse> bookingResponses = bookingRepository
                .findAll()
                .stream()
                .map(booking -> modelMapper.map(booking, BookingResponse.class))
                .collect(Collectors.toList());
        return bookingResponses;


    }

    public BookingResponse findById(Long id) {
        Booking booking = bookingRepository.findById(id).orElseThrow(() -> new RuntimeException(
                String.format("Booking not found by id -%s", id)
        ));
        BookingResponse bookingResponse = modelMapper.map(booking, BookingResponse.class);
        return bookingResponse;
    }

    @Override
    public BookingResponse save(Long userId, Long paymentId, BookingRequest bookingRequest) {
        User user = getUserById(userId);
        Payment payment = getPaymentById(paymentId);
        Booking booking = createBooking(user, payment, bookingRequest);
        return mapToBookingResponse(booking);
    }

    private User getUserById(Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new RuntimeException(
                String.format("User not found by id -%s", userId)
        ));
    }

    private Payment getPaymentById(Long paymentId) {
        return paymentRepository.findById(paymentId).orElseThrow(() -> new RuntimeException(
                String.format("User not found by id -%s", paymentId)
        ));
    }

    private Booking createBooking(User user, Payment payment, BookingRequest bookingRequest) {
        Booking booking = modelMapper.map(bookingRequest, Booking.class);
        booking.setPayment(payment);
        booking.setUser(user);
        return bookingRepository.save(booking);
    }

    private BookingResponse mapToBookingResponse(Booking booking) {
        return modelMapper.map(booking, BookingResponse.class);
    }

    @Override
    public void delete(Long id) {
        bookingRepository.findById(id).orElseThrow(() -> new RuntimeException(
                String.format("Booking not found by id -%s", id)
        ));

    }

}