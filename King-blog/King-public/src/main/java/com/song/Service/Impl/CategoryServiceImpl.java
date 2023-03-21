package com.song.Service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.song.Dao.CategoryMapper;
import com.song.Entity.Category;
import com.song.Service.CategoryService;
import com.song.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 分类表(Category)表服务实现类
 *
 * @author makejava
 * @since 2022-12-25 18:45:32
 */
@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;
    @Override
    public Result<List> categoryList() {
        List<Category> categoryList = categoryMapper.categoryList();
        if (categoryList==null){
            return Result.errorResult(404,"文章分类为空");
        }
        return Result.okResult(categoryList);
    }



}

