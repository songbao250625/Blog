package com.song.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.song.Entity.Dto.FansDto;
import com.song.Entity.Fans;
import com.song.common.Result;

/**
 * (Fans)表服务接口
 *
 * @author makejava
 * @since 2022-12-11 17:13:47
 */
public interface FansService extends IService<Fans> {

    Result<FansDto> getFans(Long id);
}

