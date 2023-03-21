package com.song.Service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.song.Dao.CommentMapper;
import com.song.Entity.Comment;
import com.song.Service.CommentService;
import org.springframework.stereotype.Service;

/**
 * 评论表(Comment)表服务实现类
 *
 * @author makejava
 * @since 2022-12-08 11:40:49
 */
@Service("commentService")
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

}

