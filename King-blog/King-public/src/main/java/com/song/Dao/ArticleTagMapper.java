package com.song.Dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.song.Entity.ArticleTag;
import org.apache.ibatis.annotations.Mapper;

/**
 * 文章标签关联表(ArticleTag)表数据库访问层
 *
 * @author makejava
 * @since 2023-01-29 16:16:17
 */
@Mapper
public interface ArticleTagMapper extends BaseMapper<ArticleTag> {
    int add(ArticleTag articleTag);
}

