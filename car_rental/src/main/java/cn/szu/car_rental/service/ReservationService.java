package cn.szu.car_rental.service;

import cn.szu.car_rental.bean.Reservation;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface ReservationService {

    Map<String,Object> getReservationByDate(Date date);

    List<Reservation> getReservationAndPrice();

    void addReservation(Reservation reservation);
}
