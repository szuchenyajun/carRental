package cn.szu.car_rental.serviceImpl;

import cn.szu.car_rental.bean.Reservation;
import cn.szu.car_rental.mapper.ReservationMapper;
import cn.szu.car_rental.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    ReservationMapper reservationMapper;
    @Override
    public Map<String, Object> getReservationByDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        List<Reservation> list = reservationMapper.getReservationByYearMonth(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH)+1);
        double totalPrice =0;
        double monthPrice = 0;
        //System.out.println(list);
        for(Reservation reservation:list){
            double timeDiff = reservation.getDropOff().getTime() - reservation.getPickUp().getTime();
            if(reservation.getValuateModel() == 1){//按小时计费
                totalPrice = reservation.getCar().getPricePerHour() * Math.ceil(timeDiff/(1000*60*60));
            }else{//按天计费
                totalPrice = reservation.getCar().getPricePerDay()*Math.ceil(timeDiff/(1000*60*60*24));
            }
            reservation.setTotalPrice(totalPrice);
            //System.out.println(reservation);
            monthPrice += totalPrice;
        }
        Map<String,Object> map = new HashMap<>();
        map.put("reservationList",list);
        map.put("monthPrice",monthPrice);
        return map;

    }

    public List<Reservation> getReservationAndPrice(){
        double totalPrice =0;
        List<Reservation> list = reservationMapper.getReservationPrice();
        for(Reservation reservation:list){
            double timeDiff = reservation.getDropOff().getTime() - reservation.getPickUp().getTime();
            if(reservation.getValuateModel() == 1){//按小时计费
                totalPrice = reservation.getCar().getPricePerHour() * Math.ceil(timeDiff/(1000*60*60));
            }else{//按天计费
                totalPrice = reservation.getCar().getPricePerDay()*Math.ceil(timeDiff/(1000*60*60*24));
            }
            reservation.setTotalPrice(totalPrice);
            //System.out.println(reservation);
        }
        return list;
    }

    @Override
    public void addReservation(Reservation reservation) {
        reservationMapper.addReservation(reservation);
    }

}
