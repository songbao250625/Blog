package com.song.Service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.song.Dao.FansMapper;
import com.song.Entity.Dto.FansDto;
import com.song.Entity.Fans;
import com.song.Service.FansService;
import com.song.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;

/**
 * (Fans)表服务实现类
 *
 * @author makejava
 * @since 2022-12-11 17:13:47
 */
@Service("fansService")
@Slf4j
public class FansServiceImpl extends ServiceImpl<FansMapper, Fans> implements FansService {
    @Autowired
    private FansMapper fansMapper;

    @Override
    public Result<FansDto> getFans(Long id) {
        Map<String, Integer> counts = fansMapper.counts(id);
        Map<String, Integer> countGoods = fansMapper.countGoods(id);
        FansDto fansDto = new FansDto();
        if (countGoods == null && counts == null) {
            return Result.errorResult(666, "统计失败");
        }
        Integer goodCounts = countGoods.get("goodCounts");
        Number fanCounts = counts.get("fanCounts");
        Number followCounts = counts.get("followCounts");

        fansDto.setFanCounts(fanCounts.intValue());
        fansDto.setFollowCounts(followCounts.intValue());
        fansDto.setGoodCounts(goodCounts);

        return Result.okResult(fansDto);
    }
}

