package com.example.EnumDemo.dto;

import com.example.EnumDemo.enumPackage.Color;
import com.example.EnumDemo.enumPackage.DressType;
import com.example.EnumDemo.enumPackage.Size;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class DressDisplayDto {
    private Long id;

    private String  brand;

    @Enumerated(EnumType.STRING)
    private DressType type;

    @Enumerated(EnumType.STRING)
    private Size size;

    @Enumerated(EnumType.STRING)
    private Color color;

    private Long price;
}
