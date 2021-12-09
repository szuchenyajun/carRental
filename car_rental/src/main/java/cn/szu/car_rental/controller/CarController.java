package cn.szu.car_rental.controller;

import cn.szu.car_rental.bean.Car;
import cn.szu.car_rental.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller

public class CarController {

    @Autowired
    CarService carService;

    @GetMapping("/getAllCar")
    public String getAllCar(Model model){
        //System.out.println(session.getAttribute("customer"));
        model.addAttribute("cars",carService.getAllCar());
        return "table/allCar";
    }
    @ResponseBody
    @GetMapping("/car/getAllCar")
    public List<Car> getAllCar(HttpSession session){
        System.out.println(session.getAttribute("username"));
        //model.addAttribute("cars",);
        return carService.getAllCar();
    }
   // @ResponseBody
    @GetMapping("/car/rentalTrend")
    public String getRentalTrend( Model model){
        model.addAttribute("map",carService.getRentalTrend());
        System.out.println(carService.getRentalTrend());
        return "table/rentalTrend";
    }
    @ResponseBody
    @PostMapping("/car/getByPassengerJson")
    //@RequestMapping(value = "/getByPassenger",method = RequestMethod.GET)
    public List<Car> getCarByPassenger(@RequestParam Integer number){
        //HashMap<String,List<Car>> map = new HashMap<>();
        //map.put("cars",);
        //System.out.println("heoo");

        return carService.getCarByPassenger(number);
    }
    @GetMapping("/test")
    public String  test(){
        //return "locationChart";
        return "table/numPassengerJson";
    }

    @GetMapping("/car/updatePrice")
    public String updateCarPrice(Model model){
        boolean b = carService.updateCarPrice();
        if(b){
            model.addAttribute("","更新成功");
            return "redirect:/getAllCar";
        }
        model.addAttribute("","更新失败");
        return "redirect:/getAllCar";
    }
}
