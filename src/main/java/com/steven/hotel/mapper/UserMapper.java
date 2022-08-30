package com.steven.hotel.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.steven.hotel.entity.Hotel;
import com.steven.hotel.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author shkstart
 * @create 2021-07-25 11:30
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
