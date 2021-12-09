package cn.szu.car_rental.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {

    private String reservationNo;
    private java.sql.Date reservedDate;
    private Date pickUp;
    private Date dropOff;
    private Integer valuateModel;
    private double totalPrice;
    private double monthPrice;
    private Customer customer;
    private  Car car;
    private Location location;
}
