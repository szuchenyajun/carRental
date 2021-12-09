package cn.szu.car_rental.serviceImpl;

import cn.szu.car_rental.bean.Customer;
import cn.szu.car_rental.bean.Reservation;
import cn.szu.car_rental.mapper.CustomerMapper;
import cn.szu.car_rental.mapper.ReservationMapper;
import cn.szu.car_rental.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerMapper customerMapper;
    @Autowired
    ReservationMapper reservationMapper;
    @Override
    public List<Customer> getCustomerOnProbation() {

        return customerMapper.getCustomerOnProbation();
    }

    @Override
    public Customer getCustomerById(String id) {

        return customerMapper.getCustomerById(id);
    }

    @Override
    public Map<String,Object> getReservationByCustomer(String customerId) {
        double totalPrice =0;
        double allPrice = 0;
        List<Reservation> list = reservationMapper.getReservationByCustomerId(customerId);
        for(Reservation reservation:list){
            double timeDiff = reservation.getDropOff().getTime() - reservation.getPickUp().getTime();
            if(reservation.getValuateModel() == 1){//按小时计费
                totalPrice = reservation.getCar().getPricePerHour() * Math.ceil(timeDiff/(1000*60*60));
            }else{//按天计费
                totalPrice = reservation.getCar().getPricePerDay()*Math.ceil(timeDiff/(1000*60*60*24));
            }
            reservation.setTotalPrice(totalPrice);
            //System.out.println(reservation);
            allPrice += totalPrice;
        }
        Map<String,Object> map = new HashMap<>();
        map.put("reservationList",list);
        map.put("monthPrice",allPrice);
        return map;
       // return reservationMapper.getReservationByCustomerId(customerId);
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerMapper.getAllCustomer();
    }
}
