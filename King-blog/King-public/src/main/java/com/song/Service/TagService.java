package com.song.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.song.Entity.Tag;
import com.song.common.Result;

import java.util.List;

/**
 * 标签(Tag)表服务接口
 *
 * @author makejava
 * @since 2022-12-27 20:18:00
 */
public interface TagService extends IService<Tag> {

    Result<List> getAllTags();
}

