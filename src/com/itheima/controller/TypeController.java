package com.itheima.controller;

import com.itheima.po.ResultInfo;
import com.itheima.po.Type;
import com.itheima.po.User;
import com.itheima.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TypeController {
    @Autowired
    private TypeService typeService;

//    查询某一类型的书籍
    @RequestMapping("/findTB")
    public ResultInfo find(@RequestParam(required = false,defaultValue = "-1") int id){
        List<Type> list=typeService.findTB(id);
        return new ResultInfo(true,list);
    }

//    通过typename获得type_id
    @RequestMapping("/findName")
    public ResultInfo findName(String name){
        try {
            name=new String(name.getBytes("ISO-8859-1"),"UTF-8");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("不能辨别中文！");
        }
        int type=typeService.findName(name);
        return new ResultInfo(true,type);
    }

//    新增类型
    @RequestMapping("/addType")
    public ResultInfo addType(String name){
        System.out.println(name);
        int n=typeService.addType(name);
        if(n>0){
            //添加成功
            return new ResultInfo(true,"新增成功!");
        }
        return new ResultInfo(false,"未知错误");
    }
}
