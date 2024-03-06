package com.example.EnumDemo.model;

import com.example.EnumDemo.enumPackage.Color;
import com.example.EnumDemo.enumPackage.DressType;
import com.example.EnumDemo.enumPackage.Size;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "DressesTable")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "brand")
    private String  brand;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private DressType type;

    @Column(name = "size")
    @Enumerated(EnumType.STRING)
    private Size size;

    @Column(name = "color")
    @Enumerated(EnumType.STRING)
    private Color color;

    @Column(name = "price")
    private Long price;
}
