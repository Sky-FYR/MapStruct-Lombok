package com.example.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TestMapper {

    TestMapper instance = Mappers.getMapper(TestMapper.class);

    @Mappings({
            @Mapping(target = "seatCount", source = "numberOfSeats"),
            @Mapping(target = "type", expression = "java( JsonHelper.toJsonStr(car.getType()) )")
    })
    CarDto car2CarDto(Car car);

}
