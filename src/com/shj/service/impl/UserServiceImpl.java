package com.shj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shj.dao.UserDao;
import com.shj.po.User;
import com.shj.service.UserService;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;

	@Override
	public List<User> findUA(int id) {
		return this.userDao.findUA(id);
	}

	@Override
	public List<User> findUU(int id) {
		return this.userDao.findUU(id);
	}

	@Override
	public List<User> findUB(int id) {
		return this.userDao.findUB(id);
	}

	@Override
	public List<User> findUC(int id) {
		return this.userDao.findUC(id);
	}

	@Override
	//用户登录
	public User findUser(String name,String pwd) { return this.userDao.findUser(name,pwd); }
	@Override
	public List<User> findname(String name) { return this.userDao.findname(name); }
	@Override
	//用户注册
	public Integer register(User user) {
		return this.userDao.register(user);
	}
	//查询所有用户
	@Override
	public List<User> findall() {
		return this.userDao.findall();
	}
	//通过用户id删除用户
	@Override
	public Integer userdel(int id) {
		return this.userDao.userdel(id);
	}

	//通过用户id查找用户
	@Override
	public User findwithid(int id) {
		return this.userDao.findwithid(id) ;
	}

	@Override
	//修改用户phone
	public Integer userupd(User user) {
		// TODO Auto-generated method stub
		return this.userDao.userupd(user);
	}
	//添加用户
	@Override
	public Integer useradd(User user) {
		// TODO Auto-generated method stub
		return this.userDao.useradd(user);
	}
	//通过用户名查找用户
	@Override
	public List<User> findwithname(String name) {
		// TODO Auto-generated method stub
		return this.userDao.findwithname(name);
	}

	@Override
	public Integer delbc(int uid, int bid) {
		return this.userDao.delbc(uid, bid);
	}

	//将书籍加入书架
	@Override
	public Integer addbc(int uid, int bid) {
		return this.userDao.addbc(uid, bid);
	}
	
	//判断书籍是否在用户的书架中
	@Override
	public User find(int uid,int bid) {
		return this.userDao.find(uid, bid);
		
	}	
	

}
