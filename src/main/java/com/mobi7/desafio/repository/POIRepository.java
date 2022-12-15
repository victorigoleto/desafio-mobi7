package com.mobi7.desafio.repository;

import com.mobi7.desafio.entity.POI;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface POIRepository extends JpaRepository<POI, UUID> {
    List<POI> findAll();
}
