package com.example.EnumDemo.mapper;

import com.example.EnumDemo.dto.DressAdditionDto;
import com.example.EnumDemo.dto.DressDisplayDto;
import com.example.EnumDemo.enumPackage.Size;
import com.example.EnumDemo.model.DressEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DressesMapper {

    @Mapping(source = "brand", target = "brand")
    @Mapping(source = "type", target = "type")
    @Mapping(target = "size", expression = "java(convertSizeIntToEnum(dressAdditionDto))")
    @Mapping(source = "color", target = "color")
    @Mapping(source = "price", target = "price")
    DressEntity convertDressAdditionDtoToDressEntity(DressAdditionDto dressAdditionDto);

    default Size convertSizeIntToEnum(DressAdditionDto dressAdditionDto){
        int currentSize = dressAdditionDto.getSize();
        Size size = null;
        for(Size s: Size.values()){
            if(currentSize >= s.getMinRange() && currentSize <= s.getMaxRange()){
                size = s;
                break;
            }
        }
        return size;
    }

    @Mapping(source = "id", target = "id")
    @Mapping(source = "brand", target = "brand")
    @Mapping(source = "type", target = "type")
    @Mapping( source = "size", target = "size")
    @Mapping(source = "color", target = "color")
    @Mapping(source = "price", target = "price")
    DressDisplayDto convertDressEntityToDressDisplayDto(DressEntity dressEntity);

    List<DressDisplayDto> convertListsOfDressEntityToDressDisplayDto(List<DressEntity> dressEntity);

    List<DressEntity> convertListOfDressAdditionDtoToDressEntity(List<DressAdditionDto> dressAdditionDtos);
}
