package cn.szu.car_rental.mapper;

import cn.szu.car_rental.bean.Reservation;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

@Mapper
public interface ReservationMapper {

    List<Reservation> getReservationByYearMonth(Integer year,Integer month);

    List<Reservation> getReservationPrice();
    @Insert("insert into reservation(reservation_No,reserved_date,pick_Up,drop_Off,valuate_By_Hour,customer_Id,location_Id,car_id) " +
            "values(#{reservationNo},#{reservedDate},#{pickUp},#{dropOff},#{valuateModel},#{customer.customerId},#{location.locationId},#{car.carId})")
    void addReservation(Reservation reservation);


    @Select("select * from reservation where customer_id = #{customerId")
    List<Reservation> getReservationByCustomerId(String customerId);
}
