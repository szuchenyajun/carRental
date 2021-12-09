//package cn.szu.car_rental.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@Configuration
//public class MySecurityConfiguration extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    private UserDetailsService userDetailsService;
//    @Override//认证
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
//        auth.userDetailsService(userDetailsService)//
//                .passwordEncoder(passwordEncoder());
//    }
//
//    @Override//资源访问
//    protected void configure(HttpSecurity httpSecurity) throws Exception{
//        httpSecurity
//                .authorizeRequests()
//                .antMatchers("/**").hasRole("USER")
//                .antMatchers("/**").hasRole("ADMIN")
//                .anyRequest().authenticated()//没有定义的请求 都可访问
//                .and()
//                .formLogin().and()
//                .httpBasic();
//    }
//    @Bean
//    public PasswordEncoder passwordEncoder(){
//        return NoOpPasswordEncoder.getInstance();
//    }
//}
