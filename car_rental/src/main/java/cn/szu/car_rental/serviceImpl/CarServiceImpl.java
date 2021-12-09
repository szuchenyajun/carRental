package cn.szu.car_rental.serviceImpl;

import cn.szu.car_rental.bean.Car;
import cn.szu.car_rental.mapper.CarMapper;
import cn.szu.car_rental.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CarServiceImpl implements CarService {
    @Autowired
    CarMapper carMapper;
    @Override
    public List<Car> getAllCar() {
        List<Car> allCar = carMapper.getAllCar();
        return allCar;
    }

    @Override
    public List<Map<String, Object>> getRentalTrend() {

        return carMapper.getRentalTrend();
    }

    @Override
    public List<Car> getCarByPassenger(Integer number) {
        return carMapper.getNumberOfPassenger(number);
    }

    @Override
    public boolean updateCarPrice() {
        int i = carMapper.updateCarPrice();
        return i != 0;
    }
}
