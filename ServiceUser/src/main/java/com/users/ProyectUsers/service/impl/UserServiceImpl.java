package com.users.ProyectUsers.service.impl;

import com.users.ProyectUsers.entities.Hotel;
import com.users.ProyectUsers.entities.Qualification;
import com.users.ProyectUsers.entities.User;
import com.users.ProyectUsers.exceptions.ResourceNotFoundException;
import com.users.ProyectUsers.external.services.HotelService;
import com.users.ProyectUsers.repository.UserRepository;
import com.users.ProyectUsers.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private HotelService hotelService;

    @Override
    public User saveUser(User user) {
        String randomIdUser = UUID.randomUUID().toString();
        user.setIdUser(randomIdUser);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = userRepository.findAll();
        for (User user : users) {
            Qualification[] qualificationsUser = restTemplate.getForObject("http://SERVICE-QUALIFICATION/qualificationsUdemy/qualifications/users/" + user.getIdUser(), Qualification[].class);
            List<Qualification> qualifications = Arrays.stream(qualificationsUser).collect(Collectors.toList());
            for (Qualification qualification : qualifications) {
                // USE REST TEMPLATE ---> Hotel hotelQualification = restTemplate.getForObject("http://SERVICE-HOTEL/hotelsUdemy/hotels/" + qualification.getHotelId(), Hotel.class);
                Hotel hotelQualification = hotelService.getHotel(qualification.getHotelId());
                qualification.setHotel(hotelQualification);
            }
            user.setQualifications(qualifications);
        }
        return users;
    }

    @Override
    public User getUser(String idUser) {
        User user = userRepository.findById(idUser)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with the id: " + idUser));
        Qualification[] qualificationsUser = restTemplate.getForObject("http://SERVICE-QUALIFICATION/qualificationsUdemy/qualifications/users/" + idUser, Qualification[].class);
        List<Qualification> qualifications = Arrays.stream(qualificationsUser).collect(Collectors.toList());
        for (Qualification qualification : qualifications) {
            // USE REST TEMPLATE ---> Hotel hotelQualification = restTemplate.getForObject("http://SERVICE-HOTEL/hotelsUdemy/hotels/" + qualification.getHotelId(), Hotel.class);
            Hotel hotelQualification = hotelService.getHotel(qualification.getHotelId());
            qualification.setHotel(hotelQualification);
        }
        user.setQualifications(qualifications);
        return user;
    }
}
