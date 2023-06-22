package com.hotel.ProjectHotels.controller;

import com.hotel.ProjectHotels.entity.Hotel;
import com.hotel.ProjectHotels.service.HotelService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/hotels")
@Tag(name = "Services of Hotels", description = "Services to the Hotel entity.")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @Operation(summary = "Method to save a hotel register.")
    @PostMapping("/new")
    public ResponseEntity<Hotel> saveHotel(@RequestBody Hotel hotel) {
        Hotel request = hotelService.saveHotel(hotel);
        return ResponseEntity.status(HttpStatus.CREATED).body(request);
    }

    @Operation(summary = "Method to get a hotel register.")
    @GetMapping("/{idHotel}")
    public ResponseEntity<Hotel> getHotel(@PathVariable String idHotel) {
        Hotel hotel = hotelService.getHotel(idHotel);
        return ResponseEntity.ok(hotel);
    }

    @Operation(summary = "Method to get all hotel registers.")
    @GetMapping("/findAll")
    public ResponseEntity<List<Hotel>> getAllHotels() {
        List<Hotel> hotels = hotelService.getAllHotels();
        return ResponseEntity.ok(hotels);
    }
}
