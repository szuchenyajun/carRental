package cn.szu.car_rental.mapper;

import cn.szu.car_rental.bean.Location;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class LocationMapperTest {
    @Autowired
    LocationMapper locationMapper;
    @Test
    void test1(){
        List<Location> popularLocation = locationMapper.getPopularLocation();
        for(Location location:popularLocation){
            System.out.println(location);
        }
    }
}