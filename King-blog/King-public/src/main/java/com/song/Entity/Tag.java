package com.song.Entity;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

/**
 * 标签(Tag)表实体类
 *
 * @author makejava
 * @since 2022-12-27 20:18:00
 */

@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tag{
    
    private Long id;
    //标签名
    private String name;
    
    private Long createBy;
    
    private Date createTime;
    
    private Long updateBy;
    
    private Date updateTime;
    //删除标志（0代表未删除，1代表已删除）
    private Integer delFlag;
    //备注
    private String remark;

    }

