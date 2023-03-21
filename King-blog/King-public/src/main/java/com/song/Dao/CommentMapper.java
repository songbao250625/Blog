package com.song.Dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.song.Entity.Comment;
import org.apache.ibatis.annotations.Mapper;

/**
 * 评论表(Comment)表数据库访问层
 *
 * @author makejava
 * @since 2022-12-08 11:40:49
 */
@Mapper
public interface CommentMapper extends BaseMapper<Comment> {

}

