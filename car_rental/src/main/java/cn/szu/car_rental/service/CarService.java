package cn.szu.car_rental.service;

import cn.szu.car_rental.bean.Car;

import java.util.List;
import java.util.Map;

public interface CarService {

    List<Car> getAllCar();

    List<Map<String,Object>> getRentalTrend();

    List<Car> getCarByPassenger(Integer number);

    boolean updateCarPrice();

}
