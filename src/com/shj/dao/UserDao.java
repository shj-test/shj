package com.shj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shj.po.User;

public interface UserDao {

	public List<User> findUA(@Param("id")int id) ;

	public List<User> findUU(@Param("id")int id) ;

	public List<User> findUB(@Param("id")int id) ;

	public List<User> findUC(@Param("id")int id) ;


	// 通过账号和密码查询用户
	public User findUser(@Param("name") String name,@Param("pwd") String pwd);
	
	public Integer register(User user); //判断该用户是否已注册
		
	public List<User> findall() ;		//查找所有用户

    public List<User> findname(String name) ;		//通过用户名查找用户
		
	public Integer userdel(int id); 	//通过用户id删除用户
		
	public User findwithid(int id); 		//通过用户id查找用户
	
	public Integer userupd(User user);		//修改用户信息

	public Integer useradd(User user) ;		//添加新用户
		
	public List<User> findwithname(String name) ;		//通过用户名（模糊）查找用户

	public Integer delbc(@Param("uid")int uid,@Param("bid")int bid);	//删除书架上的书籍
	
	public Integer addbc(@Param("uid")int uid,@Param("bid")int bid);	//将书籍加入书架
	
	public User find(@Param("uid")int uid,@Param("bid")int bid);	//判断书籍是否在用户的书架中
}
