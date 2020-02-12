package com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WhiskyRepository extends JpaRepository<Whisky, Long>, WhiskyRepositoryCustom {

    List<Whisky> findByYearEquals(int year);

    List<Whisky> readByAgeAndDistilleryId(int age, Long id);

    List<Whisky> readByDistilleryName(String distillery);

    List<Whisky> findByYear(int year);



}
