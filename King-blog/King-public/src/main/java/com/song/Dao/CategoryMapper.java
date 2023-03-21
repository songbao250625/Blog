package com.song.Dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.song.Entity.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 分类表(Category)表数据库访问层
 *
 * @author makejava
 * @since 2022-12-25 18:45:26
 */
@Mapper
public interface CategoryMapper extends BaseMapper<Category> {
    List<Category> categoryList();
}

