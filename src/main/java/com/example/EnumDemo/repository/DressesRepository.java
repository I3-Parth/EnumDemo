package com.example.EnumDemo.repository;

import com.example.EnumDemo.dto.DressDisplayDto;
import com.example.EnumDemo.model.DressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.*;
import java.util.List;

@Repository
public interface DressesRepository extends JpaRepository<DressEntity, Long> {
    List<DressEntity> findByBrandIn(String[] brands);
}
