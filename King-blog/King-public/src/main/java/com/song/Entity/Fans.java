package com.song.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * (Fans)表实体类
 *
 * @author makejava
 * @since 2022-12-11 17:13:46
 */

@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Fans {
    //id
    private Long id;
    //粉丝id
    private Long fanId;
    //昵称
    private String userNickName;
    //签名
    private String userDesign;
    //关注用户id
    private Long followId;
    //用户id
    private Long userId;

}

