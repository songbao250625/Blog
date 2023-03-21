package com.song.Entity.Dto;

import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FansDto {
    //关注的数量
    private Integer followCounts;
    //粉丝数量
    private Integer fanCounts;
    //获得的点赞数量
    private Integer goodCounts;
}
