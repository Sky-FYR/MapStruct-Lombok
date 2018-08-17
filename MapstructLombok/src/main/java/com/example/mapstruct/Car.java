package com.example.mapstruct;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    private String make;
    private int numberOfSeats;
    private Map<String,String> type;

    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("asd", "123");
        Car car = new Car("1", 3, map);
        System.out.println(car.getMake());
        CarDto carDto = new CarDto("2",4, "dto");
        System.out.println(carDto.getMake());

        CarDto carDto1 = TestMapper.instance.car2CarDto(car);
        System.out.println(carDto1.toString());
    }
}
