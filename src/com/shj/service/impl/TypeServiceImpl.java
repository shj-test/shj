package com.shj.service.impl;

import com.shj.dao.TypeDao;
import com.shj.po.Type;
import com.shj.service.TypeService;
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
