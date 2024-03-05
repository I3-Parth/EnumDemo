package com.example.EnumDemo.repository;

import com.example.EnumDemo.dto.DressDisplayDto;
import com.example.EnumDemo.enumPackage.Color;
import com.example.EnumDemo.enumPackage.DressType;
import com.example.EnumDemo.enumPackage.Size;
import com.example.EnumDemo.model.DressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.*;
import java.util.List;

@Repository
public interface DressesRepository extends JpaRepository<DressEntity, Long> {
    List<DressEntity> findByBrandIn(String[] brands);
    List<DressEntity> findBySizeAndColorAndTypeAndPrice(Size size, Color color, DressType type, Long price);
    List<DressEntity> findByTypeAndSizeAndColorOrPrice(DressType type, Size size, Color color, Long price);
    List<DressEntity> findByPriceBetween(Long price1, Long Price2);
}
