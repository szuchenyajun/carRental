package cn.szu.car_rental.controller;

import cn.szu.car_rental.mapper.CustomerMapper;
import cn.szu.car_rental.service.CustomerService;
import cn.szu.car_rental.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.HttpCookie;
import java.util.Map;

@Controller
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @Autowired
    LocationService locationService;
    //所有的违规用户
    @GetMapping("customer/getCustomerOnProbation")
    public String getCustomerOnProbation(Model model){
        model.addAttribute("customerOnProbation",customerService.getCustomerOnProbation());
        return "table/basic_table";
    }

    //用户订车
    @GetMapping("customer/reserve")
    public String reserveCar(@RequestParam Integer carId, Model model, HttpSession session,
                             HttpServletRequest request){

        model.addAttribute("locations",locationService.getAllLocation());
        model.addAttribute("carId",carId);

        //System.out.println(session.getAttribute("customer"));

        return "addReservation";
    }
    //获取用户订单
    @GetMapping("/customer/getReservation")
    public String getReservationByCustomer(@RequestParam String customerId,Model model){
        Map<String, Object> reservationByCustomer = customerService.getReservationByCustomer(customerId);
        model.addAttribute("customerRes",reservationByCustomer.get("reservationList"));
        model.addAttribute("allPrice",reservationByCustomer.get("allPrice"));
        return "table/customerReservation";
    }

    //获取所有用户
    @GetMapping("customer/allCustomer")
    public String allCustomer(Model model){
        model.addAttribute("customer",customerService.getAllCustomer());

        return "table/allCustomer";
    }
}
