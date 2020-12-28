package com.itheima.dao;

import com.itheima.po.Type;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TypeDao {
    public List<Type> findTB(@Param("id") int id);

    public int findName(String name);

    public int addType(String name);
}
