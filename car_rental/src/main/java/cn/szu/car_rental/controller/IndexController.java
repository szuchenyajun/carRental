package cn.szu.car_rental.controller;

import cn.szu.car_rental.bean.Customer;
import cn.szu.car_rental.service.CustomerService;
import com.sun.deploy.net.HttpResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.jar.Attributes;

@Controller
@Slf4j
public class IndexController {
    @Autowired
    CustomerService customerService;

    @GetMapping({"/","/login"})
    public String loginPage(HttpSession session){
        session.invalidate();

        return "login";//跳转到login.html
    }
    @PostMapping("/login")
    public String toMain(@RequestParam String username, @RequestParam String password, HttpSession session){
        Customer customer = customerService.getCustomerById(username);
       // System.out.println(customer);
        if(customer != null ){
            session.setAttribute("customer",customer);
            return "redirect:/mainPage";
        }else{
            session.setAttribute("msg","账号或密码错误");

            //return "redirect:/";
            return null;
        }



    }
    @GetMapping("/mainPage")
    public String mainPage(){
       // Customer customer1 =(Customer) session.getAttribute("customer");
        //System.out.println(customer1);
        return "index";
    }
}
