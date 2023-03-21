package com.song.Controller;



import com.song.Service.TagService;
import com.song.common.Result;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * 标签(Tag)表控制层
 *
 * @author makejava
 * @since 2022-12-27 20:18:38
 */
@RestController
@RequestMapping("/tag")
public class TagController{
   @Autowired
    private TagService tagService;

   @RequestMapping(value = "/tagList",method = RequestMethod.GET)
    public Result getAllTags(){
      Result<List>  listResult= tagService.getAllTags();
      return listResult;
   }
}

