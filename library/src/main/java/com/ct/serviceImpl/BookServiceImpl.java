package com.ct.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ct.dao.BookDao;
import com.ct.entity.Book;
import com.ct.entity.BookExample;
import com.ct.service.BookService;
@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookDao bookDao;

	@Override
	public int countByExample(BookExample example) {
		// TODO Auto-generated method stub
		return bookDao.countByExample(example);
	}

	@Override
	public int deleteByExample(BookExample example) {
		// TODO Auto-generated method stub
		return bookDao.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Integer bookid) {
		// TODO Auto-generated method stub
		return bookDao.deleteByPrimaryKey(bookid);
	}

	@Override
	public int insert(Book record) {
		// TODO Auto-generated method stub
		return bookDao.insert(record);
	}

	@Override
	public int insertSelective(Book record) {
		// TODO Auto-generated method stub
		return bookDao.insertSelective(record);
	}

	@Override
	public List<Book> selectByExample(BookExample example) {
		// TODO Auto-generated method stub
		return bookDao.selectByExample(example);
	}

	@Override
	public Book selectByPrimaryKey(Integer bookid) {
		// TODO Auto-generated method stub
		return bookDao.selectByPrimaryKey(bookid);
	}

	@Override
	public int updateByExampleSelective(Book record, BookExample example) {
		// TODO Auto-generated method stub
		return bookDao.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(Book record, BookExample example) {
		// TODO Auto-generated method stub
		return bookDao.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(Book record) {
		// TODO Auto-generated method stub
		return bookDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Book record) {
		// TODO Auto-generated method stub
		return bookDao.updateByPrimaryKey(record);
	}

	@Override
	public List<Book> selectForPage(BookExample example) {
		// TODO Auto-generated method stub
		return bookDao.selectForPage(example);
	}

}
