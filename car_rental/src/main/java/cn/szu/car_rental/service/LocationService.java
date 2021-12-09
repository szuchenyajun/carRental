package cn.szu.car_rental.service;

import cn.szu.car_rental.bean.Location;

import java.util.HashMap;
import java.util.List;

public interface LocationService {

    List<HashMap<String, Object>> getPopularLocation();

    List<Location> getAllLocation();
}
