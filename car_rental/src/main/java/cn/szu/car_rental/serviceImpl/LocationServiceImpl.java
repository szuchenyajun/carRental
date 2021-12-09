package cn.szu.car_rental.serviceImpl;

import cn.szu.car_rental.bean.Location;
import cn.szu.car_rental.mapper.LocationMapper;
import cn.szu.car_rental.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {
    @Autowired
    LocationMapper locationMapper;

    @Override
    public List<HashMap<String, Object>> getPopularLocation() {
        List<Location> popularLocation = locationMapper.getPopularLocation();
        List<HashMap<String,Object>> list = new ArrayList<>();

        for(Location location:popularLocation){
            HashMap<String,Object> map = new HashMap<>();
            map.put("locationId",location.getLocationId());
            map.put("streetAddress",location.getStreetAddress());
            map.put("numberOfRentals",location.getNumberOfRentals());
            list.add(map);
        }
        return list;
    }

    @Override
    public List<Location> getAllLocation() {
        return locationMapper.getAllLocation();
    }
}
