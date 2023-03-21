package com.song.Controller;


import com.song.Entity.*;
import com.song.Entity.Dto.PublishArticleVo;
import com.song.Entity.Dto.QueryParams;
import com.song.Service.ArticleService;
import com.song.Service.UserService;
import com.song.common.BaseContext;
import com.song.common.Result;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 文章表(Article)表控制层
 *
 * @author makejava
 * @since 2022-11-25 19:13:41
 */
@RestController
@RequestMapping("/article")
@Log4j2
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/articleList", method = RequestMethod.POST)
    public Result articleList(@RequestBody QueryParams queryParams) {
        Result<List> result = articleService.articleList(queryParams);
        return result;
    }

    @RequestMapping(value = "/hotArticleList")
    public Result hotArticleList() {
        Result<List> result = articleService.hotArticleList();
        return result;
    }

    @GetMapping("/{id}")
    public Result selectById(@PathVariable Long id) {
        Result<Article> articleResult = articleService.selectById(id);
        return articleResult;
    }

    @PostMapping("/publishArticle")
    public Result publishArticle(@RequestBody PublishArticleVo publishArticleVo) {
        log.info("接收到文章发表请求");
        Article article = new Article();
        BeanUtils.copyProperties(publishArticleVo, article);

        Category category = publishArticleVo.getCategory();

        Long categoryId = category.getId();

        article.setCategoryId(categoryId);
        article.setDelFlag(0);
        article.setIsComment("1");
        article.setViewCount(0l);
        article.setIsTop("1");
        article.setStatus("0");
        article.setThumbnail("空");
        log.info(article);

        List<Tag> tagList = publishArticleVo.getTags();

        Result result = articleService.pubicText(article, tagList);

        return result;
    }
}

