package com.example.EnumDemo.dto;

import com.example.EnumDemo.enumPackage.Color;
import com.example.EnumDemo.enumPackage.DressType;
import com.example.EnumDemo.enumPackage.Size;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class DressAdditionDto {

    private String  brand;

    @Enumerated(EnumType.STRING)
    private DressType type;

    private int size;

    @Enumerated(EnumType.STRING)
    private Color color;

    private Long price;
}
