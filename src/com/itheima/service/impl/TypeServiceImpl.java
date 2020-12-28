package com.itheima.service.impl;

import com.itheima.dao.TypeDao;
import com.itheima.po.Type;
import com.itheima.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("typrService")
@Transactional
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TypeDao typeDao;
    @Override
    public List<Type> findTB(int id) {
        return this.typeDao.findTB(id);
    }

    @Override
    public int findName(String name) {
        return this.typeDao.findName(name);
    }

    @Override
    public int addType(String name) {
        return this.typeDao.addType(name);
    }
}
