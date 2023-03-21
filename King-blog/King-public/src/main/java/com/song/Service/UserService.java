package com.song.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.song.Entity.User;
import com.song.common.Result;
import com.song.common.TokenResult;

/**
 * 用户表(User)表服务接口
 *
 * @author makejava
 * @since 2022-11-27 20:12:15
 */
public interface UserService extends IService<User> {

    TokenResult<User> login(User user) throws Exception;

    Result register(User user) throws Exception;

    TokenResult<User> updateUserById(User user);

}

