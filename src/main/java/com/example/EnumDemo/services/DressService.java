package com.example.EnumDemo.services;

import com.example.EnumDemo.dto.DressAdditionDto;
import com.example.EnumDemo.dto.DressDisplayDto;
import com.example.EnumDemo.mapper.DressesMapper;
import com.example.EnumDemo.model.DressEntity;
import com.example.EnumDemo.repository.DressesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DressService {
    @Autowired
    DressesRepository dressesRepository;

    @Autowired
    DressesMapper dressesMapper;

    public List<DressDisplayDto> getAllDressEntities(){
        List<DressEntity> dressEntities = dressesRepository.findAll();
        return dressEntities.stream().map(dressesMapper::convertDressEntityToDressDisplayDto).collect(Collectors.toList());
    }

    public DressDisplayDto getDressEntityById(Long id){
        return dressesMapper.convertDressEntityToDressDisplayDto(dressesRepository.findById(id).orElseThrow(()-> new RuntimeException("Id "+id+" does not exist.")));
    }

    public DressDisplayDto createDressEntity(DressAdditionDto dressAdditionDto){
        DressEntity dressEntity = dressesMapper.convertDressAdditionDtoToDressEntity(dressAdditionDto);
        this.dressesRepository.save(dressEntity);
        return dressesMapper.convertDressEntityToDressDisplayDto(dressEntity);
    }
}
