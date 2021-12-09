package cn.szu.car_rental.controller;

import cn.szu.car_rental.bean.Car;
import cn.szu.car_rental.bean.Customer;
import cn.szu.car_rental.bean.Location;
import cn.szu.car_rental.bean.Reservation;
import cn.szu.car_rental.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Controller
public class ReservationController {

    @Autowired
    ReservationService reservationService;

    @GetMapping("/reservation")
    public String showReservation(Model model){

        model.addAttribute("reservation",reservationService.getReservationAndPrice());
        return "table/reservation";
    }

    @PostMapping("/reservation/monthPrice")
    public String monthReservation(Model model,@RequestParam String reservationDate) throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date dt=sdf.parse(reservationDate);
        Map<String,Object> map = reservationService.getReservationByDate(dt);
        List<Reservation> reservationList = (List<Reservation>) map.get("reservationList");
        model.addAttribute("monthReservation",reservationList);
        model.addAttribute("monthPrice",map.get("monthPrice"));
        return "table/monthReservation";
    }

    //@ResponseBody
    @PostMapping("reservation/add")
    public String addReservation(@RequestParam("pickUp") String pickUp,
                               @RequestParam("dropOff") String dropOff,
                               @RequestParam("locationId") Integer locationId,
                               @RequestParam("valuateModel") Integer valuateModel,
                               @RequestParam("customerId") String customerId,
                               @RequestParam("carId") Integer carId) throws ParseException {
        Reservation reservation = new Reservation();
       SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date pickUpDate=sdf.parse(pickUp.replace("T"," "));
        Date dropOffDate=sdf.parse(dropOff.replace("T"," "));
//        System.out.println(pickUpDate.toString());
        String pickUp1 = pickUp.replace("T"," ");
        Timestamp pick = new Timestamp(pickUpDate.getTime());
        Timestamp drop = new Timestamp(dropOffDate.getTime());
        reservation.setPickUp(pickUpDate);
        reservation.setDropOff(dropOffDate);

        //reservation.getLocation().setLocationId(locationId);
        reservation.setValuateModel(valuateModel);
        Location location = new Location();
        location.setLocationId(locationId);
        reservation.setLocation(location);
        reservation.setReservedDate(new java.sql.Date(new Date().getTime()));
        String sDate = new Date().toString().substring(4,7);
        System.out.println(sDate);
        int no =  (int)(Math.random()*900)+100;
        reservation.setReservationNo(sDate+"-"+no);
        Customer customer = new Customer();
        customer.setCustomerId(customerId);
        reservation.setCustomer(customer);
        Car car = new Car();
        car.setCarId(carId);
        reservation.setCar(car);
        System.out.println(reservation);

        reservationService.addReservation(reservation);
        return "reservation";
    }
}
