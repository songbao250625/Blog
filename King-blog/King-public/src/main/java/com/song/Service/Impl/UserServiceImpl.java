package com.song.Service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.song.Dao.UserMapper;
import com.song.Entity.User;
import com.song.Service.UserService;
import com.song.Utils.DESUtil;
import com.song.Utils.ValidateCodeUtils;
import com.song.common.BaseContext;
import com.song.common.Result;
import com.song.common.TokenResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



/**
 * 用户表(User)表服务实现类
 *
 * @author makejava
 * @since 2022-11-27 20:12:15
 */
@Slf4j
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {



    @Override
    public TokenResult<User> login(User user) {
        String password = user.getPassword();
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUserName, user.getUserName());
        User user1 = this.getOne(queryWrapper);
        String password1 = user1.getPassword();
        password1 = DESUtil.decrypt(password1,DESUtil.KEY);
        log.info("解密后的密码"+password1);

        BaseContext.set(user1.getId());
        log.info("设置当前用户id为"+BaseContext.getCurrentId());
        if (password.equals(password1)) {
            user1.setPassword(password1);
            Integer token = ValidateCodeUtils.generateValidateCode(6);

            return TokenResult.success(200,user1,"登录成功",token);
        }

        return TokenResult.errorResult(201, "账户或密码错误，请检查重试");
    }

    @Override
    @Transactional
    public Result register(User user) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUserName, user.getUserName());

        User one = this.getOne(queryWrapper);
        if (one != null) {
            return Result.errorResult(600,"账户已存在，请登录");
        }

        String password = user.getPassword();
        password = DESUtil.encrypt(password,DESUtil.KEY);
        log.info("加密后的密码"+password);
        user.setPassword(password);
        boolean save = this.save(user);
        if (!save){
            return Result.errorResult(601,"注册失败");
        }
        return Result.okResult(200,"注册成功");
    }

    @Override
    @Transactional
    public TokenResult<User> updateUserById(User user) {
        String password = user.getPassword();
       String password1 = DESUtil.encrypt(password,DESUtil.KEY);
        log.info("加密后的密码"+password);
        user.setPassword(password1);
        boolean update = this.updateById(user);
        if (update){
            user.setPassword(password);
            Integer token = ValidateCodeUtils.generateValidateCode(6);
            return TokenResult.success(200,user,"更新成功",token);
        }
        return TokenResult.errorResult(201,"更新失败，检查重试");
    }
}

