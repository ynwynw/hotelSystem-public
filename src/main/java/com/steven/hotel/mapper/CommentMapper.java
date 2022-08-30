package com.steven.hotel.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.steven.hotel.entity.Comment;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author shkstart
 * @create 2021-07-29 17:25
 */
@Mapper
public interface CommentMapper extends BaseMapper<Comment> {
}
