package com.hotel.ProjectHotels.service.impl;

import com.hotel.ProjectHotels.entity.Hotel;
import com.hotel.ProjectHotels.exceptions.ResourceNotFoundException;
import com.hotel.ProjectHotels.repository.HotelRepository;
import com.hotel.ProjectHotels.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Hotel saveHotel(Hotel hotel) {
        String randomIdHotel = UUID.randomUUID().toString();
        hotel.setIdHotel(randomIdHotel);
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getHotel(String idHotel) {
        return hotelRepository.findById(idHotel)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with the id: " + idHotel));
    }
}
