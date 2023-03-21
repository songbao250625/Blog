package com.song.Entity.Dto;

import lombok.Data;

@Data
public class QueryParams {
    private int pageNum;
    private int pageSize;
    private int categoryId;
}
