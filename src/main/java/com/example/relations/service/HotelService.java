package com.example.relations.service;

import com.example.relations.dto.Request.HotelRequest;
import com.example.relations.dto.Response.HotelResponse;


import java.util.List;

public interface HotelService {
    List<HotelResponse> findAll();

    HotelResponse save(HotelRequest hotelRequest);
    HotelResponse findById(Long id);
    HotelResponse update(Long id,HotelRequest hotelRequest);
    void delete(Long id);
}
