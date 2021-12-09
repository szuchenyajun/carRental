package cn.szu.car_rental.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Location {

    private Integer locationId;
    private String streetAddress;
    private String locationPhone;
    private Integer numberOfRentals;
}
