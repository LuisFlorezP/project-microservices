package com.qualification.ProjectQualifications.service.impl;

import com.qualification.ProjectQualifications.entity.Qualification;
import com.qualification.ProjectQualifications.repository.QualificationRepository;
import com.qualification.ProjectQualifications.service.QualificationService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class QualificationServiceImpl implements QualificationService {

    @Autowired
    private QualificationRepository qualificationRepository;

    @Override
    public Qualification saveQualification(Qualification qualification) {
        return qualificationRepository.save(qualification);
    }

    @Override
    public List<Qualification> getAllQualifications() {
        return qualificationRepository.findAll();
    }

    @Override
    public List<Qualification> getQualificationsByUserId(String userId) {
        return qualificationRepository.findByUserId(userId);
    }

    @Override
    public List<Qualification> getQualificationsByHotelId(String hotelId) {
        return qualificationRepository.findByHotelId(hotelId);
    }
}
