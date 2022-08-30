package com.steven.hotel.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author shkstart
 * @create 2021-07-27 17:19
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@TableName(value = "pay")
public class Pay {
    @TableId(value = "id" ,type = IdType.AUTO)
    private Integer pid;

    @TableField(value = "username")
    private String username;

    @TableField(value = "hotel_id")
    private Long hotelId;

    @TableField(value = "pay")
    private boolean pay;

    @TableField(value = "total_number")
    private double totalNumber;

    @TableLogic
    @TableField(value = "deleted")
    private Integer deleted;
}
