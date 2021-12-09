package cn.szu.car_rental.service;

import cn.szu.car_rental.bean.Customer;
import cn.szu.car_rental.bean.Reservation;

import java.util.List;
import java.util.Map;

public interface CustomerService {

    List<Customer> getCustomerOnProbation();

    Customer getCustomerById(String id);

    Map<String,Object> getReservationByCustomer(String customerId);

    List<Customer> getAllCustomer();
}
