package com.song.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.song.Entity.Category;
import com.song.common.Result;

import java.util.List;

/**
 * 分类表(Category)表服务接口
 *
 * @author makejava
 * @since 2022-12-25 18:45:31
 */
public interface CategoryService extends IService<Category> {

    Result<List> categoryList();

}

