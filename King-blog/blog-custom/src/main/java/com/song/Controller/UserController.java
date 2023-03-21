package com.song.Controller;


import com.song.Dao.UserMapper;
import com.song.Entity.User;
import com.song.Service.UserService;
import com.song.common.Result;
import com.song.common.TokenResult;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 用户表(User)表控制层
 *
 * @author makejava
 * @since 2022-11-27 20:13:05
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;

    @PostMapping("/login")
    public TokenResult login(@RequestBody User user) throws Exception {
        TokenResult<User> userResult = userService.login(user);
        return userResult;
    }
    @PostMapping("/register")
    public Result register(@RequestBody User user) throws Exception {
        Result userResult = userService.register(user);
        return userResult;
    }
    @PostMapping("/updateUserById")
    public TokenResult updateUserById(@RequestBody User user) {
        TokenResult userResult = userService.updateUserById(user);
        return userResult;
    }

    @GetMapping("/test")
    public Result<List> test() {
        List<User> userList = userMapper.getAll();
        return Result.okResult(userList);
    }
}

