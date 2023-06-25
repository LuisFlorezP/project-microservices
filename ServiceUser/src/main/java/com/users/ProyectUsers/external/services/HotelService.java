package com.users.ProyectUsers.external.services;

import com.users.ProyectUsers.entities.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "SERVICE-HOTEL")
public interface HotelService {

    @GetMapping("/hotelsUdemy/hotels/{hotelId}")
    Hotel getHotel(@PathVariable String hotelId);
}
