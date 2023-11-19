package com.example.relations.service.serviceImpl;

import com.example.relations.domain.Hotel;
import com.example.relations.domain.Payment;
import com.example.relations.dto.Request.HotelRequest;
import com.example.relations.dto.Request.PaymentRequest;
import com.example.relations.dto.Response.HotelResponse;
import com.example.relations.dto.Response.PaymentResponse;
import com.example.relations.repository.HotelRepository;
import com.example.relations.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {
    private final HotelRepository hotelRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<HotelResponse> findAll() {
        return hotelRepository
                .findAll()
                .stream()
                .map(hotel -> modelMapper.map(hotel, HotelResponse.class))
                .collect(Collectors.toList());

    }
    @Override
    public HotelResponse save(HotelRequest hotelRequest) {
        Hotel hotel = modelMapper.map(hotelRequest, Hotel.class);
        Hotel save = hotelRepository.save(hotel);
        return modelMapper.map(save, HotelResponse.class);
    }

    @Override
    public HotelResponse findById(Long id) {
        Hotel hotel= hotelRepository.findById(id).orElseThrow(() -> new RuntimeException(
                String.format("Hotel not found by id-%s", id)
        ));
        return modelMapper.map(hotel, HotelResponse.class);
    }


    @Override
    public HotelResponse update(Long id, HotelRequest hotelRequest) {
        hotelRepository.findById(id).orElseThrow(() -> new RuntimeException(
                String.format("Hotel not found for updating by id -%s", id)));
        Hotel responseHotel= modelMapper.map(hotelRequest, Hotel.class);
        responseHotel.setHotelId(id);
        return modelMapper.map(hotelRepository.save(responseHotel), HotelResponse.class);
    }
    @Override
    public void delete(Long id) {
        Hotel hotel= hotelRepository.findById(id).orElseThrow(() -> new RuntimeException(
                String.format("Hotel not found by Id-%s", id)
        ));
        hotelRepository.delete(hotel);
    }

}


