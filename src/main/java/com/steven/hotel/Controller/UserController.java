package com.steven.hotel.Controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.steven.hotel.entity.Email;
import com.steven.hotel.entity.User;
import com.steven.hotel.service.UserService;
import com.steven.hotel.util.CodeUtil;
import com.steven.hotel.util.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * @author shkstart
 * @create 2021-07-24 23:26
 */


@Controller
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userService;

    @Autowired
    JavaMailSender mailSender;


    @RequestMapping("/sendmail")
    @ResponseBody
    public String sendMail(Email email, HttpServletRequest request,
                           HttpServletResponse response){

        HttpSession session = request.getSession();
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("【Hotel】注册验证码");
        email.setCode(CodeUtil.generateVerifyCode(6));
        message.setText("验证码是：" + email.getCode() + ",两分钟后超时，请确认是否本人操作");
        message.setFrom("931708230@qq.com");
        session.setAttribute("code", email.getCode());
        Cookie newCookie = new Cookie("code", email.getCode());
        newCookie.setPath("/");
        newCookie.setMaxAge(120);
        message.setTo(email.sendTo);
        mailSender.send(message);
        System.out.println(email);
        response.addCookie(newCookie);
        return "success";
    }

    @RequestMapping("/confirm")
    @ResponseBody
    public JsonResponse confirm(User user){
        if(userService.confirmOne(user) == null){
            return JsonResponse.success("success");
        }else{
            return JsonResponse.failure("exist");
        }
    }


    @RequestMapping("/regist")
    @ResponseBody
    public JsonResponse regist(User user){

        userService.save(user);
        return JsonResponse.successMessage("success");
    }

    @RequestMapping("/login")
    @ResponseBody
    public JsonResponse login(User user,HttpServletRequest request,
                              HttpServletResponse response){

        HttpSession session = request.getSession();
        User user1 = userService.userLogin(user);

        System.out.println(user1);
        if (user1 == null){
            return JsonResponse.successMessage("no");
        }else{
            session.setAttribute("username", user1.getUsername());
            Cookie newCookie = new Cookie("username", user1.getUsername());
            user1.setLastLoginTime(new Date());
            userService.saveOrUpdate(user1);
            newCookie.setPath("/");
            newCookie.setMaxAge(900);
            response.addCookie(newCookie);
            return JsonResponse.successMessage("yes");
        }
    }


    @RequestMapping("/listUsers")
    @ResponseBody
    public JsonResponse listUsers(@RequestParam(required = false,defaultValue = "1") Integer pageNo,
                                  @RequestParam(required = false,defaultValue = "5") Integer pageSize){
        Page<User> userPage = userService.pageUsers(new Page(pageNo, pageSize));
        return JsonResponse.success(userPage);
    }


    @RequestMapping("/deleteUsers")
    @ResponseBody
    public JsonResponse deleteUsers(@RequestParam("ids[]") List<Long> ids){
        userService.removeByIds(ids);
        return JsonResponse.successMessage("remove");
    }


    @RequestMapping("/sendUsersMail")
    @ResponseBody
    public JsonResponse sendUsersMail(@RequestParam("emails[]") List<String> emails){
        System.out.println(emails);
        for(String email: emails){
            SimpleMailMessage message = new SimpleMailMessage();
            message.setSubject("【Hotel】提醒");
            message.setText("您的账户不活跃，请注意！！一个月未登录将删除您的账号");
            message.setFrom("931708230@qq.com");
            message.setTo(email);
            mailSender.send(message);
        }
        return JsonResponse.successMessage("sendSuccess");
    }



}
