package com.demo.springsec;

import com.demo.springsec.MyuserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DemoConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    MyuserDetailService myuserDetailService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myuserDetailService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().and() //httpbasic used for rendering json response in postman otherwise it gives a html page
                .authorizeRequests()
                .antMatchers("/testcode/**").hasAuthority("qa")
                .antMatchers("/devcode/**").hasAuthority("dev")
                .antMatchers("/accessserver/**").hasAnyAuthority("dev", "qa")
                .antMatchers("/home").permitAll()
                .and()
                .formLogin();
    }

    @Bean
    PasswordEncoder getPE(){

        return new BCryptPasswordEncoder();
    }
}
