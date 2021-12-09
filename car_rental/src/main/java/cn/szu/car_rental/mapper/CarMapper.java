package cn.szu.car_rental.mapper;

import cn.szu.car_rental.bean.Car;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface CarMapper {

    @Select("select * from car")
    List<Car> getAllCar();

    Car getCarById(Integer carId);

    List<Car> getNumberOfPassenger(Integer number);

    List<Map<String,Object>> getRentalTrend();

    @Update("UPDATE car SET Price_Per_Hour=Price_Per_Hour+0.5,Price_Per_Day=Price_Per_Day+5;")
    int updateCarPrice();
}
