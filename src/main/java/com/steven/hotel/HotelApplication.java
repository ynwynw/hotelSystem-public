package com.steven.hotel;

import com.steven.hotel.entity.User;
import com.steven.hotel.service.UserService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
@MapperScan({"com.steven.hotel.mapper"})
public class HotelApplication {



    public static void main(String[] args) { SpringApplication.run(HotelApplication.class, args); }

}
