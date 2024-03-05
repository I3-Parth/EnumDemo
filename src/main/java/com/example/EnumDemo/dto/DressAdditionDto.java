package com.example.EnumDemo.dto;

import com.example.EnumDemo.enumPackage.Color;
import com.example.EnumDemo.enumPackage.DressType;
import com.example.EnumDemo.enumPackage.Size;
import jakarta.persistence.Column;
import lombok.Data;

@Data
public class DressAdditionDto {

    private String  brand;

    private DressType type;

    private int size;

    private Color color;

    private Long price;
}
