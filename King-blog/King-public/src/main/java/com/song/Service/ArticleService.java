package com.song.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.song.Entity.Article;
import com.song.Entity.Dto.QueryParams;
import com.song.Entity.Tag;
import com.song.common.Result;

import java.util.List;

/**
 * 文章表(Article)表服务接口
 *
 * @author makejava
 * @since 2022-11-25 19:08:52
 */
public interface ArticleService extends IService<Article> {

    Result<List> articleList(QueryParams queryParams);

    Result<List> hotArticleList();

    Result<Article> selectById(Long id);

    Result pubicText(Article article,List<Tag> tags);

}

