package com.example.EnumDemo.repository;

import com.example.EnumDemo.model.DressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DressesRepository extends JpaRepository<DressEntity, Long> {
}
