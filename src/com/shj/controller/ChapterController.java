package com.shj.controller;

import com.shj.po.Chapter;
import com.shj.po.ResultInfo;
import com.shj.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class ChapterController {
    @Autowired
    private ChapterService chapterService;

//    通过id查询章节
    @RequestMapping("/findId")
    public ResultInfo findID(int id){
        Chapter chapter=chapterService.findId(id);
        return new ResultInfo(true,chapter);
    }

//    修改章节
    @RequestMapping("/updChapter")
    public ResultInfo updChapter(int id,String name,String content){
        try {
            name=new String(name.getBytes("ISO-8859-1"),"UTF-8");
            content=new String(content.getBytes("ISO-8859-1"),"UTF-8");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("不能辨别中文！");
        }
        HashMap<String,Object> map = new HashMap<String, Object>();
        map.put("id", id);
        map.put("name", name);
        map.put("content", content);
        int n=chapterService.updChapter(map);
        if(n>0){
            //修改成功
            return new ResultInfo(true,"修改成功!");
        }
        return new ResultInfo(false,"未知错误");
    }

//    插入章节
    @RequestMapping("/addChapter")
    public ResultInfo addChapter(int id,String name,String content){
        try {
            name=new String(name.getBytes("ISO-8859-1"),"UTF-8");
            content=new String(content.getBytes("ISO-8859-1"),"UTF-8");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("不能辨别中文！");
        }
        HashMap<String,Object> map = new HashMap<String, Object>();
        map.put("book_id", id);
        map.put("chaptername", name);
        map.put("content", content);
        int n= chapterService.addChapter(map);
        if(n>0){
            //添加成功
            return new ResultInfo(true,"新增成功!",map);
        }
        return new ResultInfo(false,"未知错误");
    }

//    删除章节
    @RequestMapping("/delId")
    public ResultInfo delID(int id){
        int n=chapterService.delId(id);
        if(n>0){
            //删除成功
            return new ResultInfo(true,"删除成功!");
        }
        return new ResultInfo(false,"未知错误");
    }
}
