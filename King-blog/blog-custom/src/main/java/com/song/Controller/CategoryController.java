package com.song.Controller;



import com.song.Entity.Category;
import com.song.Service.CategoryService;
import com.song.common.Result;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * 分类表(Category)表控制层
 *
 * @author makejava
 * @since 2022-12-25 18:46:48
 */
@RestController
@RequestMapping("/category")
public class CategoryController{
   @Autowired
    private CategoryService categoryService;

   @RequestMapping(value = "/categoryList",method = RequestMethod.GET)
    public Result categoryList(){
       Result<List> listResult = categoryService.categoryList();
       return listResult;
   }
}

