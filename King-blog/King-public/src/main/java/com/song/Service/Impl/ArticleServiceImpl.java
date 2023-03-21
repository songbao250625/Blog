package com.song.Service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.song.Dao.ArticleMapper;
import com.song.Dao.ArticleTagMapper;
import com.song.Entity.Article;
import com.song.Entity.ArticleTag;
import com.song.Entity.Category;
import com.song.Entity.Dto.ArticleVo;
import com.song.Entity.Dto.HotArticleVo;
import com.song.Entity.Dto.QueryParams;
import com.song.Entity.Tag;
import com.song.Service.ArticleService;
import com.song.Service.CategoryService;
import com.song.common.DateUtils;
import com.song.common.Result;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 文章表(Article)表服务实现类
 *
 * @author makejava
 * @since 2022-11-25 19:08:55
 */
@Service("articleService")
@Log4j2
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private ArticleTagMapper articleTagMapper;

    @Override
    public Result<List> articleList(QueryParams queryParams) {
        Page<Article> pageInfo = new Page<>(queryParams.getPageNum(), queryParams.getPageSize());
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Article::getStatus, 0);
        queryWrapper.orderByDesc(Article::getViewCount);
        log.info("开始查询文章列表");
        page(pageInfo, queryWrapper);

        List<Article> records = pageInfo.getRecords();

        List<ArticleVo> articleVoList = new ArrayList<>();

        for (Article record : records) {

            ArticleVo articleVo = new ArticleVo();

            String createTime = String.valueOf(record.getCreateTime());
            BeanUtils.copyProperties(record, articleVo);

            articleVo.setCategoryName(categoryName(record));

            articleVoList.add(articleVo);
        }
        return Result.okResult(articleVoList);
    }

    public String categoryName(Article article) {
        Long categoryId = article.getCategoryId();
        LambdaQueryWrapper<Category> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Category::getId, categoryId);
        log.info("开始查询文章作者姓名");
        Category category = categoryService.getOne(queryWrapper);

        String categoryName = category.getName();
        return categoryName;
    }

    @Override
    public Result<List> hotArticleList() {
        Page<Article> pageInfo = new Page<>(1, 5);
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.orderByDesc(Article::getViewCount);
        queryWrapper.eq(Article::getStatus, 0);
        log.info("开始查询最热文章列表");
        page(pageInfo, queryWrapper);

        List<Article> records = pageInfo.getRecords();
        List<HotArticleVo> hotArticleVos = new ArrayList<>();
        for (Article record : records) {
            HotArticleVo hotArticleVo = new HotArticleVo();
            BeanUtils.copyProperties(record, hotArticleVo);
            hotArticleVos.add(hotArticleVo);
        }
        return Result.okResult(hotArticleVos);
    }

    @Override
    public Result<Article> selectById(Long id) {
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Article::getId, id);
        Article article = this.getOne(queryWrapper);
        String categoryName = categoryName(article);

        ArticleVo articleVo = new ArticleVo();
        BeanUtils.copyProperties(article, articleVo);
        articleVo.setCategoryName(categoryName);

        if (articleVo == null) {
            return Result.errorResult(6000, "查询失败");
        }
        return Result.okResult(articleVo);
    }

    //发布文章
    @Override
    @Transactional
    public Result pubicText(Article article, List<Tag> tags) {
        try {
            articleMapper.pubicText(article);
            Long articleId = article.getId();
            if (articleId == null) {
                return Result.errorResult(205, "文章发布失败");
            }
            List<ArticleTag> articleTags = new ArrayList<>();

            for (Tag tag : tags) {
                ArticleTag articleTag = new ArticleTag();
                Long tagId = tag.getId();
                articleTag.setTagId(tagId);
                articleTag.setArticleId(articleId);
                int i = articleTagMapper.add(articleTag);
                if (i == 0) {
                    return Result.errorResult(205, "文章所属标签发布失败");
                }
                articleTags.add(articleTag);
            }
            log.info(articleTags);
            return Result.okResult(article);
        } catch (Exception e) {
            System.out.println(e);
            return Result.errorResult(800, "发布失败联系管理员");
        }
    }

}

