package com.song.Entity.Dto;

import com.song.Entity.Category;
import com.song.Entity.Tag;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.poi.ss.formula.functions.T;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PublishArticleVo {
    //id
    private Integer id;
    //标题
    private String title;
    //简介
    private String summary;
    //内容体
    private String content;
    //分类信息
    private Category category;
    //标签信息
    private List<Tag> tags;
    private Long createBy;
    private Long updateBy;

}
