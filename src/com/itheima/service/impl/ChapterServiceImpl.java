package com.itheima.service.impl;

import com.itheima.dao.ChapterDao;
import com.itheima.po.Chapter;
import com.itheima.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;

@Service("chapterService")
@Transactional
public class ChapterServiceImpl implements ChapterService {
    @Autowired
    private ChapterDao chapterDao;

    @Override
    public Chapter findId(int id) {
        return this.chapterDao.findId(id);
    }

    @Override
    public int addChapter(HashMap map) {
        return this.chapterDao.addChapter(map);
    }

    @Override
    public int delId(int id) {
        return this.chapterDao.delId(id);
    }

    @Override
    public int updChapter(HashMap map) {
        return this.chapterDao.updChapter(map);
    }
}
