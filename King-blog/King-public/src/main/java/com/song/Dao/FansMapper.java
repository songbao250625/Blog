package com.song.Dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.song.Entity.Dto.FansDto;
import com.song.Entity.Fans;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * (Fans)表数据库访问层
 *
 * @author makejava
 * @since 2022-12-11 17:13:46
 */
@Mapper
public interface FansMapper extends BaseMapper<Fans> {
        Map<String, Integer> countGoods(Long id);
        Map<String, Integer> counts(Long id);
}

