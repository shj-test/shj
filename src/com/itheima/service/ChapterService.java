package com.itheima.service;

import com.itheima.po.Chapter;

import java.util.HashMap;

public interface ChapterService {

    public Chapter findId(int id);

    public int addChapter(HashMap map);

    public int delId(int id);

    public int updChapter(HashMap map);
}
