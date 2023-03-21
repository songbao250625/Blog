package com.song.Controller;

import com.song.Dao.FansMapper;
import com.song.Entity.Dto.FansDto;
import com.song.Entity.User;
import com.song.Service.FansService;
import com.song.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/fans")
@Slf4j
public class FansController {
   @Autowired
    private FansService fansService;

   @GetMapping("/{id}")
    public Result getFans(@PathVariable Long id){
       Result<FansDto> fans=fansService.getFans(id);
       return fans;
   }
}
