package com.shj.service.impl;

import com.shj.dao.CommentDao;
import com.shj.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;

@Service("commentService")
@Transactional
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentDao commentDao;
    @Override
    public int addComment(HashMap map) {
        return this.commentDao.addComment(map);
    }
}
