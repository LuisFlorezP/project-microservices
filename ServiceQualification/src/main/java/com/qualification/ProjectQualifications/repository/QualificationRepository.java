package com.qualification.ProjectQualifications.repository;

import com.qualification.ProjectQualifications.entity.Qualification;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface QualificationRepository extends MongoRepository<Qualification, String> {

    List<Qualification> findByUserId(String userId);

    List<Qualification> findByHotelId(String hotelId);
}
