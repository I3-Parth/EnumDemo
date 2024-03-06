package com.example.EnumDemo.controller;

import com.example.EnumDemo.dto.DressAdditionDto;
import com.example.EnumDemo.dto.DressDisplayDto;
import com.example.EnumDemo.enumPackage.Color;
import com.example.EnumDemo.enumPackage.DressType;
import com.example.EnumDemo.enumPackage.Size;
import com.example.EnumDemo.repository.DressesRepository;
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
    public List<DressDisplayDto> getAllDresses(@RequestParam(name = "Brand", required = false)String[] brands,
                                               @RequestParam(name = "Size", required = false)Size size,
                                               @RequestParam(name = "Type", required = false)DressType type,
                                               @RequestParam(name = "Color", required = false)Color color,
                                               @RequestParam(name = "Exclude color", required = false)Color Nocolor,
                                               @RequestParam(name = "Price", required = false)Long price,
                                               @RequestParam(name = "Lower Price", required = false)Long price1,
                                               @RequestParam(name = "Higher Price", required = false)Long price2){
        if(size != null && type != null && color != null && price != null) return dressService.getDressesBySizeAndColorAndTypeAndPrice(size, color, type, price);
        else if (brands != null ) return dressService.getDressesByPrices(brands);
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