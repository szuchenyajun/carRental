package cn.szu.car_rental.mapper;

import cn.szu.car_rental.bean.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CustomerMapper {

    List<Customer> getCustomerOnProbation();

    @Select("select customer_id,first_name from customer where customer_id = #{id}")
    Customer getCustomerById(String id);

    @Select("select * from customer")
    List<Customer> getAllCustomer();
}
