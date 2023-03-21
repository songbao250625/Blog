package com.song.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

/**
 * 文章标签关联表(ArticleTag)表实体类
 *
 * @author makejava
 * @since 2022-12-30 17:51:14
 */

@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleTag{
    //文章id
    private Long articleId;
    //标签id
    private Long tagId;

    }

