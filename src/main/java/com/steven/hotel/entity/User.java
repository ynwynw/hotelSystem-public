package com.steven.hotel.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.steven.hotel.service.Encoder.AESEncryptHandler;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author shkstart
 * @create 2021-07-25 11:20
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@TableName(autoResultMap = true)
public class User extends Model<User> {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String username;

    @TableField(typeHandler = AESEncryptHandler.class)
    private String password;

    @TableField(typeHandler = AESEncryptHandler.class)
    private String email;

    @TableField("lastlogintime")
    private Date lastLoginTime;

    @TableLogic
    @TableField(value = "deleted")
    private Integer deleted;

}
