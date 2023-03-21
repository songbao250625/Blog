package com.song.Dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.song.Entity.Dto.TagVo;
import com.song.Entity.Tag;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 标签(Tag)表数据库访问层
 *
 * @author makejava
 * @since 2022-12-27 20:18:00
 */
@Mapper
public interface TagMapper extends BaseMapper<Tag> {

    List<Tag> getAllTags();
}

