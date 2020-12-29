package com.shj.dao;

import com.shj.po.Chapter;

import java.util.HashMap;

public interface ChapterDao {
    public Chapter findId(int id);

    public int addChapter(HashMap map);

    public int delId(int id);

    public int updChapter(HashMap map);
}
