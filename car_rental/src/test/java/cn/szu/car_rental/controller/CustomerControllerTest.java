package cn.szu.car_rental.controller;

import cn.szu.car_rental.bean.Customer;
import cn.szu.car_rental.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CustomerControllerTest {
     @Autowired
    CustomerService customerService;
     @Test
    public  void test1(){
         List<Customer> customerOnProbation = customerService.getCustomerOnProbation();
         customerOnProbation.forEach(System.out::println);
     }
}