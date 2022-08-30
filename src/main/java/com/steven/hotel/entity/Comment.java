package com.steven.hotel.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author shkstart
 * @create 2021-07-29 17:21
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@TableName("comment")
public class Comment {

    @TableId(value = "id",type = IdType.AUTO)
    private Long id;

    @TableField(value = "hotel_id")
    private Long hotelId;

    private String username;

    private String comment;

    private Date time;

    @TableLogic
    @TableField(value = "deleted")
    private Integer deleted;
}
