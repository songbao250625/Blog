package com.song.Service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.song.Dao.TagMapper;
import com.song.Entity.Dto.TagVo;
import com.song.Entity.Tag;
import com.song.Service.TagService;
import com.song.common.Result;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 标签(Tag)表服务实现类
 *
 * @author makejava
 * @since 2022-12-27 20:18:00
 */
@Service("tagService")
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements TagService {

    @Autowired
    private TagMapper tagMapper;
    @Override
    public Result<List> getAllTags() {
      List<Tag> tagList= tagMapper.getAllTags();
      List<TagVo> tagVos=new ArrayList<>();
      //对象拷贝
        for (Tag tag : tagList) {
            TagVo tagVo=new TagVo();
            BeanUtils.copyProperties(tag,tagVo);
            tagVos.add(tagVo);
        }
        return Result.okResult(tagVos);
    }
}

