package com.qualification.ProjectQualifications.service;

import com.qualification.ProjectQualifications.entity.Qualification;
import java.util.List;

public interface QualificationService {

    Qualification saveQualification(Qualification qualification);

    List<Qualification> getAllQualifications();

    List<Qualification> getQualificationsByUserId(String userId);

    List<Qualification> getQualificationsByHotelId(String hotelId);
}
