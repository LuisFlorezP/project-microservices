package com.qualification.ProjectQualifications.controller;

import com.qualification.ProjectQualifications.entity.Qualification;
import com.qualification.ProjectQualifications.service.QualificationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/qualifications")
@Tag(name = "Services of Qualifications", description = "Services to the Qualification entity.")
public class QualificationController {

    @Autowired
    private QualificationService qualificationService;

    @Operation(summary = "Method to save a qualification register.")
    @PostMapping("/new")
    public ResponseEntity<Qualification> saveQualification(@RequestBody Qualification qualification) {
        return ResponseEntity.status(HttpStatus.CREATED).body(qualificationService.saveQualification(qualification));
    }

    @Operation(summary = "Method to get all user registers.")
    @GetMapping("/findAll")
    public ResponseEntity<List<Qualification>> getAllQualifications() {
        return ResponseEntity.ok(qualificationService.getAllQualifications());
    }

    @Operation(summary = "Method to get all qualification registers by userId.")
    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Qualification>> getQualificationsByUserId(@PathVariable String userId) {
        return ResponseEntity.ok(qualificationService.getQualificationsByUserId(userId));
    }

    @Operation(summary = "Method to get all qualification registers by hotelId.")
    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<Qualification>> getQualificationsByHotelId(@PathVariable String hotelId) {
        return ResponseEntity.ok(qualificationService.getQualificationsByHotelId(hotelId));
    }
}
