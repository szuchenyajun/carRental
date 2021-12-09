package cn.szu.car_rental.mapper;

import cn.szu.car_rental.bean.Car;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CarMapperTest {

    @Autowired
    CarMapper carMapper;
    @Test
    void getNumberOfPassengerTest() {
        List<Car> list = carMapper.getNumberOfPassenger(4);
        list.forEach(System.out::println);
    }
    @Test
    void test2(){
        List<Map<String, Object>> rentalTrend = carMapper.getRentalTrend();
        for(Map<String,Object> map:rentalTrend){
           // System.out.println(map.keySet()+" "+map.values());
            Object[] objects = map.values().toArray();
            for(Object o :objects){
                System.out.println(o);
            }
        }
    }
    @Test
    public void test3(){
        System.out.println(carMapper.getCarById(101));
    }

}