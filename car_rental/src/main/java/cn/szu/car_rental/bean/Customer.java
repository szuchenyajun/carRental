package cn.szu.car_rental.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    private String customerId;
    private String lastName;
    private String firstName;
    private String address;
    private String telephone;
    private String cellPhone;
    private String email;
    private Long creditCard;
    private Integer isStudent;
    private Integer tickets;
    private Integer licenseNo;

}
