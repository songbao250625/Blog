package com.song.Dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.song.Entity.Article;
import com.song.Entity.ArticleTag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 文章表(Article)表数据库访问层
 *
 * @author makejava
 * @since 2022-11-25 19:08:48
 */
@Mapper
public interface ArticleMapper extends BaseMapper<Article> {

    Long pubicText(Article article);



}

