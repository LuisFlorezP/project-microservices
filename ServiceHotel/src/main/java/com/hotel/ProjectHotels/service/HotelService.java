package com.hotel.ProjectHotels.service;

import com.hotel.ProjectHotels.entity.Hotel;
import java.util.List;

public interface HotelService {

    Hotel saveHotel(Hotel hotel);

    List<Hotel> getAllHotels();

    Hotel getHotel(String idHotel);
}
