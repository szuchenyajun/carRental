package cn.szu.car_rental.serviceImpl;

import cn.szu.car_rental.bean.Reservation;
import cn.szu.car_rental.service.ReservationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ReservationServiceImplTest {

    @Autowired
    ReservationService reservationService;

    @Test
    public void test1() throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date dt=sdf.parse("2010-07-01");
        //List<Reservation> list = reservationService.getReservationByDate(dt);
        //System.out.println(list);
    }

}