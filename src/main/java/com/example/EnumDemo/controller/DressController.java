package com.example.EnumDemo.controller;

import com.example.EnumDemo.dto.DressAdditionDto;
import com.example.EnumDemo.dto.DressDisplayDto;
import com.example.EnumDemo.enumPackage.Color;
import com.example.EnumDemo.enumPackage.DressType;
import com.example.EnumDemo.enumPackage.Size;
import com.example.EnumDemo.services.DressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dresses")
public class DressController {
    @Autowired
    DressService dressService;
    @GetMapping
    public List<DressDisplayDto> getAllDresses(@RequestParam(name = "brand", required = false)String[] brands,
                                               @RequestParam(name = "size", required = false)Size size,
                                               @RequestParam(name = "type", required = false)DressType type,
                                               @RequestParam(name = "color", required = false)Color color,
                                               @RequestParam(name = "excludeColor", required = false)Color Nocolor,
                                               @RequestParam(name = "price", required = false)Long price,
                                               @RequestParam(name = "lowerPrice", required = false)Long price1,
                                               @RequestParam(name = "higherPrice", required = false)Long price2){
        if(size != null && type != null && color != null && price != null) return dressService.getDressesBySizeAndColorAndTypeAndPrice(size, color, type, price);
        else if (brands != null ) return dressService.getDressesByBrands(brands);
        else if (price1 != null && price2 != null) return dressService.getDressesByPriceBetween(price1,price2);
        else if (price1 != null) return dressService.getDressesByPriceGreaterThan(price1);
        else if (price2 != null) return dressService.getDressesByPriceLessThan(price2);
        else if (Nocolor != null) return dressService.getDressesByColorNot(Nocolor);
        else return dressService.getAllDressEntities();
    }

    @GetMapping("/{id}")
    public DressDisplayDto getDressEntityById(@PathVariable(value = "id")Long id){
        return dressService.getDressEntityById(id);
    }

    @PostMapping
    public List<DressDisplayDto> createDressEntity(@RequestBody List<DressAdditionDto> dressAdditionDto){
        return dressService.createDressEntity(dressAdditionDto);
    }
}