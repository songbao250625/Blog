package com.song.Utils;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.song.common.BaseContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * 自定义元数据处理器
 */
@Component
@Slf4j
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("insert自动填充");
        metaObject.setValue("createTime",  DateUtils.format(LocalDateTime.now()));
        metaObject.setValue("updateTime", DateUtils.format(LocalDateTime.now()));
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("update自动填充");
        log.info("当前线程id：" + Thread.currentThread().getId());
        metaObject.setValue("updateTime", DateUtils.format(LocalDateTime.now()));
    }
}
