package com.steven.hotel.Controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.steven.hotel.entity.Hotel;
import com.steven.hotel.entity.Pay;
import com.steven.hotel.service.HotelService;
import com.steven.hotel.service.PayService;
import com.steven.hotel.util.JsonResponse;
import org.apache.ibatis.annotations.Param;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author shkstart
 * @create 2021-07-26 23:19
 */


@Controller
@RequestMapping("/hotel")
public class HotelController {
    private final Logger logger = LoggerFactory.getLogger( HotelController.class );

    @Autowired
    private HotelService hotelService;

    @Autowired
    private PayService payService;




    @RequestMapping("/info")
    @ResponseBody
    public JsonResponse info(@RequestParam("hotel_id")Long hotel_id){
        System.out.println(hotelService.getById(hotel_id));
        return JsonResponse.success(hotelService.getById(hotel_id));
    }


    @RequestMapping("/queryHotel")
    @ResponseBody
    public JsonResponse queryHotel(Hotel hotel,@RequestParam(required = false,defaultValue = "1") Integer pageNo,
                                   @RequestParam(required = false,defaultValue = "3") Integer pageSize){
        return JsonResponse.success(hotelService.hotelPage(new Page<>(pageNo, pageSize), hotel));
    }


    @RequestMapping("/pay_yes")
    @ResponseBody
    public JsonResponse pay_yes(Pay pay){

        payService.save(pay);
        return JsonResponse.successMessage("yes");
    }

    @RequestMapping("/pay_no")
    @ResponseBody
    public JsonResponse pay_no(Pay pay){
        payService.save(pay);
        return JsonResponse.successMessage("yes");
    }

    @RequestMapping("/list_pay")
    @ResponseBody
    public JsonResponse list_pay( Pay pay, @RequestParam(required = false,defaultValue = "1") Integer pageNo,
                                         @RequestParam(required = false,defaultValue = "8") Integer pageSize){


        Page<Pay> payPage = payService.listPay(new Page<>(pageNo, pageSize), pay);
        return JsonResponse.success(payPage);
    }


    @RequestMapping("/delete_pay")
    @ResponseBody
    public JsonResponse delete_pay(Pay pay){
        payService.removeById(pay.getPid());
        return JsonResponse.success("delete");
    }

    @RequestMapping("/allHotel")
    @ResponseBody
    public JsonResponse allHotel(@RequestParam("hotelName") String hotelName){
        System.out.println(hotelName);
        List<Hotel> hotel = hotelService.findHotel(hotelName);
        System.out.println(hotel);

        return JsonResponse.success(hotel);
    }

    @RequestMapping("/listAllPay")
    @ResponseBody
    public JsonResponse listAllPay(@RequestParam(required = false,defaultValue = "1") Integer pageNo,
                                   @RequestParam(required = false,defaultValue = "7") Integer pageSize){
        return JsonResponse.success(payService.allPay(new Page(pageNo, pageSize)));
    }

    @RequestMapping("/listUnPay")
    @ResponseBody
    public JsonResponse listUnPay(@RequestParam(required = false,defaultValue = "1") Integer pageNo,
                                   @RequestParam(required = false,defaultValue = "7") Integer pageSize){
        return JsonResponse.success(payService.unPay(new Page(pageNo,pageSize)));
    }


    @RequestMapping("/deletePays")
    @ResponseBody
    public JsonResponse deletePays(@RequestParam("ids[]") List<Integer> ids){
        payService.removeByIds(ids);
        return JsonResponse.successMessage("remove");
    }

    @RequestMapping("/listAllHotels")
    @ResponseBody
    public JsonResponse listAllHotels(@RequestParam(required = false,defaultValue = "1") Integer pageNo,
                                      @RequestParam(required = false,defaultValue = "6") Integer pageSize){
        Page page = hotelService.listAllHotel(new Page<>(pageNo, pageSize));
        return JsonResponse.success(page);
    }

}
