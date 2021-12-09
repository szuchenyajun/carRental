package cn.szu.car_rental.mapper;

import cn.szu.car_rental.bean.Reservation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ReservationMapperTest {
    @Autowired
    ReservationMapper reservationMapper;

    @Test
    public void test1(){
        reservationMapper.getReservationByYearMonth(2010,7).forEach(System.out::println);
    }

    @Test
    public void test2(){
        List<Reservation> reservationList = reservationMapper.getReservationPrice();
        System.out.println(reservationList);
    }
}