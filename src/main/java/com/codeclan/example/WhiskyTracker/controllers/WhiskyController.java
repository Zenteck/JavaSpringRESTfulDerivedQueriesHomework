package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/whiskies")
public class WhiskyController {


    @Autowired
    private WhiskyRepository whiskyRepository;

    @GetMapping(value = "/whiskys")
    public ResponseEntity<List<Whisky>> getAllWhiskys(){
        return new ResponseEntity<>(whiskyRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/whiskys/{id}")
    public Optional<Whisky> getWhisky(@PathVariable Long id){
        return whiskyRepository.findById(id);
    }


    @PostMapping(value = "/whiskys")
    public ResponseEntity<Whisky> createWhisky(@RequestBody Whisky whisky){
        whiskyRepository.save(whisky);
        return new ResponseEntity<>(whisky, HttpStatus.CREATED);
    }

    @PatchMapping(value = "/whiskys/{id}")
    public ResponseEntity<Whisky> updateWhisky(@RequestBody Whisky whisky,
                                               @PathVariable Long id){
        whiskyRepository.save(whisky);
        return new ResponseEntity<>(whisky, HttpStatus.CREATED);
    }

    @GetMapping(value = "/whisky/distillery")
    public ResponseEntity<List<Whisky>> findWhiskyWithDistilleryNamed(@RequestParam(name="named") String distillery){
        List<Whisky> whiskies = whiskyRepository.readByDistilleryName(distillery);
        return new ResponseEntity<>(whiskies, HttpStatus.OK);
    }






}
