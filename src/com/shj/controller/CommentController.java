package com.shj.controller;

import com.shj.po.ResultInfo;
import com.shj.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;

@RestController
public class CommentController {
    @Autowired
    private CommentService commentService;

    //    发表评论
    @RequestMapping("/addComment")
    public ResultInfo addComment(int uid,int bid, String content){
        try {
            content=new String(content.getBytes("ISO-8859-1"),"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Date time=new Date();
        HashMap<String,Object> map = new HashMap<String, Object>();
        map.put("uid", uid);
        map.put("bid", bid);
        map.put("content",content);
        map.put("time", time);
        int n=commentService.addComment(map);
        if(n>0){
            //添加成功
            return new ResultInfo(true,"新增成功!",map);
        }
        return new ResultInfo(false,"未知错误");
    }
}
