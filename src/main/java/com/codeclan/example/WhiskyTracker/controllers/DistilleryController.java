package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Distillery;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository.DistilleryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/distilleries")
public class DistilleryController {


    @Autowired
    private DistilleryRepository distilleryRepository;

    @GetMapping(value = "/distilleries")
    public ResponseEntity<List<Distillery>> getAllDistilleries() {
        return new ResponseEntity<>(distilleryRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/distilleries/{id}")
    public Optional<Distillery> getDistillery(@PathVariable Long id) {
        return distilleryRepository.findById(id);
    }


    @PostMapping(value = "/distilleries")
    public ResponseEntity<Distillery> createDistillery(@RequestBody Distillery distillery) {
        distilleryRepository.save(distillery);
        return new ResponseEntity<>(distillery, HttpStatus.CREATED);
    }

    @PatchMapping(value = "/distilleries/{id}")
    public ResponseEntity<Distillery> updateDistillery(@RequestBody Distillery distillery,
                                                       @PathVariable Long id) {
        distilleryRepository.save(distillery);
        return new ResponseEntity<>(distillery, HttpStatus.CREATED);
    }

    @GetMapping(value = "/distilleries/region/{region}")
    public List<Distillery> getDistilleryByRegion(@PathVariable String region) {
        return distilleryRepository.findByRegion(region);
    }
//    http://localhost:8080/distilleries/distilleries/region/Highland

    @GetMapping(value = "/distilleries/age")
    public ResponseEntity<List<Distillery>> getDistilleriesByWhiskyAge(@RequestParam(name = "age") int age) {
        List<Distillery> distilleries = distilleryRepository.readByWhiskiesAge(age);
        return new ResponseEntity<>(distilleries, HttpStatus.OK);
    }

//    http://localhost:8080/distilleries/distilleries/year/?year=1995
//    http://localhost:8080/distilleries/distilleries/year/?year=2018
//    Problem - returns same twice
}