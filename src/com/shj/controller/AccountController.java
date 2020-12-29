package com.shj.controller;

import com.shj.po.Account;
import com.shj.po.ResultInfo;
import com.shj.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RestController
public class AccountController {
    @Autowired
    private AccountService accountService;

//    查询消费记录属于那个用户
    @RequestMapping("/findAU")
    public ResultInfo find(int id){
        Account list=accountService.findAU(id);
        return new ResultInfo(true,list);
    }

//    插入消费记录
    @RequestMapping("/addAccount")
    public ResultInfo addAccount(int user_id,String type,float money,String beizhu){
        try {
            beizhu=new String(beizhu.getBytes("ISO-8859-1"),"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Date time=new Date();
        System.out.println(beizhu);
        HashMap<String,Object> map = new HashMap<String, Object>();
        map.put("user_id", user_id);
        map.put("type", type);
        map.put("money", money);
        map.put("time", time);
        map.put("beizhu",beizhu);
        System.out.println(map);
        int n=accountService.addAccount(map);
        if(n>0){
            //添加成功
            return new ResultInfo(true,"新增成功!",map);
        }
        return new ResultInfo(false,"未知错误");
    }
}
