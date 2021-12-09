package cn.szu.car_rental.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Car {

    private Integer carId;
    private String make;
    private  String model;
    private  Integer numOfPassengers;
    private String description;
    private  double pricePerHour;
    private  double pricePerDay;

}
