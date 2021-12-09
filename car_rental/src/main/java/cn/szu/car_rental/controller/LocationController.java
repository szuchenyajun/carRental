package cn.szu.car_rental.controller;

import cn.szu.car_rental.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
public class LocationController {
    @Autowired
    LocationService locationService;

    @ResponseBody
    @GetMapping("/location/popular")
    public List<HashMap<String, Object>> popularLocation(){

        return locationService.getPopularLocation();
    }
    @GetMapping("/location/toPopular")
    public String toLocChart(){
        return "chart/locationChart";
    }
}
