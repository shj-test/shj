package com.shj.dao;

import com.shj.po.Account;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

public interface AccountDao {
    public List<Account> find(@Param("id")int id);

    public Account findAU(int id);

    public List<Account> findById(int id);

    public int addAccount(HashMap map);
}
