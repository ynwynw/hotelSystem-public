package com.steven.hotel.Controller;

import com.steven.hotel.entity.User;
import com.steven.hotel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

/**
 * @author shkstart
 * @create 2021-07-22 11:39
 */
@Controller
public class HtmlController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/hotel_information")
    public String hotel_information(){
        return "hotel_information";
    }

    @RequestMapping("/search_result")
    public String search_result(){
        return "search_result";
    }

    @RequestMapping("/my_order")
    public String my_order(){
        return "my_order";
    }

    @RequestMapping("/management")
    public String management(){
        return "management";
    }

    @RequestMapping("/map")
    public String map(){
        return "map";
    }

    @RequestMapping("/management_user")
    public String management_user(){
        return "management_user";
    }

    @RequestMapping("/management_payM")
    public String management_payM(){
        return "management_payM";
    }

    @RequestMapping("/management_payCancle")
    public String management_payCancle(){
        return "management_payCancle";
    }

    @RequestMapping("/management_room")
    public String management_room(){
        return "management_room";
    }

    @RequestMapping("/personal")
    public String personal(){
        return "personal";
    }


}
