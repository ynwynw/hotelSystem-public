package com.steven.hotel.Controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.steven.hotel.entity.Comment;
import com.steven.hotel.service.CommentService;
import com.steven.hotel.util.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * @author shkstart
 * @create 2021-07-29 17:26
 */
@Controller
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @RequestMapping("/showCommentByhotel")
    @ResponseBody
    public JsonResponse showCommentByhotel(@RequestParam(required = false,defaultValue = "1") Integer pageNo,
                                           @RequestParam(required = false,defaultValue = "4") Integer pageSize, Comment comment){
        QueryWrapper<Comment> commentQueryWrapper = new QueryWrapper<>();
        commentQueryWrapper.eq("hotel_id",comment.getHotelId());
        Page<Comment> page = commentService.page(new Page<>(pageNo, pageSize), commentQueryWrapper);

        return  JsonResponse.success(page);
    }

    @RequestMapping("/addComment")
    @ResponseBody
    public JsonResponse showCommentByhotel(Comment comment){
        comment.setTime(new Date());
        commentService.save(comment);
        return  JsonResponse.successMessage("ok");
    }

    @RequestMapping("/showCommentByUser")
    @ResponseBody
    public JsonResponse showCommentByUser(@RequestParam(required = false,defaultValue = "1") Integer pageNo,
                                          @RequestParam(required = false,defaultValue = "4") Integer pageSize, Comment comment){
        QueryWrapper<Comment> commentQueryWrapper = new QueryWrapper<>();
        commentQueryWrapper.eq("username",comment.getUsername());
        Page<Comment> page = commentService.page(new Page<>(pageNo, pageSize), commentQueryWrapper);
        return JsonResponse.success(page);
    }

    @RequestMapping("/deleteCommentByUser")
    @ResponseBody
    public JsonResponse showCommentByUser(@RequestParam("ids[]") List<Long> ids){
        commentService.removeByIds(ids);
        return JsonResponse.successMessage("remove");
    }

}
