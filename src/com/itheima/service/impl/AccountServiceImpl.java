package com.itheima.service.impl;

import com.itheima.dao.AccountDao;
import com.itheima.po.Account;
import com.itheima.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

@Service("accountService")
@Transactional
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;
    @Override
    public List<Account> find(int id) {
        return this.accountDao.find(id);
    }

    @Override
    public List<Account> findById(int id) {
        return this.accountDao.findById(id);
    }

    @Override
    public int addAccount(HashMap map) {
        return this.accountDao.addAccount(map);
    }

    @Override
    public Account findAU(int id) {
        return this.accountDao.findAU(id);
    }
}
