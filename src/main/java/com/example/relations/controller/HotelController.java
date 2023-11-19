package com.example.relations.controller;

import com.example.relations.dto.Request.HotelRequest;
import com.example.relations.dto.Response.HotelResponse;
import com.example.relations.service.HotelService;;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("hotels/v1")
public class HotelController {
        private final HotelService hotelService;

        @GetMapping
        public ResponseEntity<List<HotelResponse>> findAll(){
            return new ResponseEntity<>(hotelService.findAll(), HttpStatus.OK);
        }
        @PostMapping
        private ResponseEntity<HotelResponse> save(@RequestBody HotelRequest hotelRequest){
            return new ResponseEntity<>(hotelService.save(hotelRequest), HttpStatus.CREATED);
        }
        @GetMapping("/{id}")
        public ResponseEntity<HotelResponse> findById(@PathVariable Long id){
            return new ResponseEntity<>(hotelService.findById(id), HttpStatus.OK);

        }
        @PutMapping("/{id}")
        public ResponseEntity<HotelResponse> update(@PathVariable Long id,@RequestBody HotelRequest hotelRequest){
            return new ResponseEntity<>(hotelService.update(id, hotelRequest), HttpStatus.CREATED);
        }
        @DeleteMapping("/{id}")
        public void delete(@PathVariable Long id){
            hotelService.delete(id);
        }


}
