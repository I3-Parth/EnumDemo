package com.example.EnumDemo.dto;

import com.example.EnumDemo.enumPackage.Color;
import com.example.EnumDemo.enumPackage.DressType;
import com.example.EnumDemo.enumPackage.Size;
import lombok.Data;

@Data
public class DressDisplayDto {
    private Long id;

    private String  brand;

    private DressType type;

    private Size size;

    private Color color;

    private Long price;
}
