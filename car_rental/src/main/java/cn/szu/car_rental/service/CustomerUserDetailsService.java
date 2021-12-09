//package cn.szu.car_rental.service;
//
//import cn.szu.car_rental.bean.Customer;
//import cn.szu.car_rental.mapper.CustomerMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.Collection;
//
//@Service("UserDetailsService")
//public class CustomerUserDetailsService implements UserDetailsService {
//    @Autowired
//    CustomerMapper customerMapper;
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        //1.查询用户
//        Customer customer = customerMapper.getCustomerById(username);
//        if(customer == null){
//
//        }
//        //2.设置角色
//        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
//        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_ADMIN");
//        grantedAuthorities.add(grantedAuthority);
//        //3.security的用户 设置name 密码  角色控制
//        User user = new User(username, "12345", grantedAuthorities);
//        return user;
//    }
//}
