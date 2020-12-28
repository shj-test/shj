package com.itheima.dao;

import java.util.HashMap;
import java.util.List;

import com.itheima.po.Book;
import org.apache.ibatis.annotations.Param;

public interface BookDao {
	public List<Book> findBC(@Param("id")int id);

	public List<Book> findBU(@Param("id")int id);

	public List<Book> findBCh(@Param("id")int id);

	public List<Book> findBook(@Param("id")int id);	//查询所有书籍
	
	public List<Book> findwithtype(String str);	//按书籍类型查找
		
	public List<Book> findwithname(String name);	//按书籍名称模糊查找

	public Integer delbook(int id);		//按书籍id删除书籍
	
	public Integer updbook(HashMap map);	//修改书籍信息
		
	public Integer addbook(HashMap map);	//添加书籍
	
}
