package com.itheima.service;

import com.itheima.po.Account;

import java.util.HashMap;
import java.util.List;

public interface AccountService {

    public List<Account> find(int id);

    public List<Account> findById(int id);

    public int addAccount(HashMap map);

    public Account findAU(int id);


}
