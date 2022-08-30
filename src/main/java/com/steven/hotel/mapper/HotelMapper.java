package com.steven.hotel.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.steven.hotel.entity.Hotel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author shkstart
 * @create 2021-07-23 23:12
 */
@Mapper
public interface HotelMapper  extends BaseMapper<Hotel> {
    IPage<Hotel> hotelPage(@Param("page") Page<Hotel> page, @Param("hotel") Hotel  hotel);

}
