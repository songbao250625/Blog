package com.song.Controller;

import com.song.Service.CommentService;
import com.song.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comment")
@Slf4j
public class CommentController {
    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "/commentList", method = RequestMethod.GET)
    public Result commentList() {

        return null;
    }
}
