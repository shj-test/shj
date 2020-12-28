package com.itheima.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.dao.BookDao;
import com.itheima.po.Book;
import com.itheima.service.BookService;

@Service("bookService")
@Transactional
public class BookServiceImpl implements BookService{
	@Autowired
	private BookDao bookDao;

	@Override
	public List<Book> findBC(int id) {
		return this.bookDao.findBC(id);
	}

	@Override
	public List<Book> findBU(int id) {
		return this.bookDao.findBU(id);
	}

	@Override
    public List<Book> findBCh(int id) {
        return this.bookDao.findBCh(id);
    }

    //按书籍类型查找
	@Override
	public List<Book> findwithtype(String type) {
		return this.bookDao.findwithtype(type);
	}

	//按书籍名称模糊查找
	@Override
	public List<Book> findwithname(String key) {
		return this.bookDao.findwithname(key);
	}

	//按书籍id删除书籍
	@Override
	public Integer delbook(int id) {
		return this.bookDao.delbook(id);
	}
	
	//修改书籍信息
	@Override
	public Integer updbook(HashMap map) {
		// TODO Auto-generated method stub
		return this.bookDao.updbook(map);
	}

	//添加书籍
	@Override
	public Integer addbook(HashMap map) {
		return this.bookDao.addbook(map);
	}

	//查询所有书籍
	@Override
	public List<Book> findBook(int id) {
		return this.bookDao.findBook(id);
	}

}
