package com.example.EnumDemo.controller;

import com.example.EnumDemo.dto.DressAdditionDto;
import com.example.EnumDemo.dto.DressDisplayDto;
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
//    @GetMapping
//    public List<DressDisplayDto> getAllDresses(){
//        return dressService.getAllDressEntities();
//    }

    @GetMapping("/{id}")
    public DressDisplayDto getDressEntityById(@PathVariable(value = "id")Long id){
        return dressService.getDressEntityById(id);
    }

    @PostMapping
    public DressDisplayDto createDressEntity(@RequestBody DressAdditionDto dressAdditionDto){
        return dressService.createDressEntity(dressAdditionDto);
    }

    @GetMapping
    public List<DressDisplayDto> getDressesByBrands(@RequestParam(name = "brand", required = false)String[] brands){
        if (brands == null) return dressService.getAllDressEntities();
        else return dressService.getDressesByPrices(brands);
    }
}
