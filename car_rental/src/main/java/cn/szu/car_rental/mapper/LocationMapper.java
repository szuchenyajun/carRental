package cn.szu.car_rental.mapper;

import cn.szu.car_rental.bean.Location;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LocationMapper {

    List<Location> getPopularLocation();

    @Select("select * from location;")
    List<Location> getAllLocation();

}
