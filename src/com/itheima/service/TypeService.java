package com.itheima.service;

import com.itheima.po.Type;

import java.util.List;

public interface TypeService {
    public List<Type> findTB(int id);

    public int findName(String name);

    public int addType(String name);



}
