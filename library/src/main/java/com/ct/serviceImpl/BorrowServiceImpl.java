package com.ct.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ct.dao.BorrowDao;
import com.ct.entity.Borrow;
import com.ct.entity.BorrowExample;
import com.ct.service.BorrowService;
@Service
public class BorrowServiceImpl implements BorrowService {

	@Autowired
	private BorrowDao borrowDao;
	@Override
	public int countByExample(BorrowExample example) {
		// TODO Auto-generated method stub
		return borrowDao.countByExample(example);
	}

	@Override
	public int deleteByExample(BorrowExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByPrimaryKey(Integer bid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Borrow record) {
		// TODO Auto-generated method stub
		return borrowDao.insert(record);
	}

	@Override
	public int insertSelective(Borrow record) {
		// TODO Auto-generated method stub
		return borrowDao.insertSelective(record);
	}

	@Override
	public List<Borrow> selectByExample(BorrowExample example) {
		// TODO Auto-generated method stub
		return borrowDao.selectByExample(example);
	}

	@Override
	public Borrow selectByPrimaryKey(Integer bid) {
		// TODO Auto-generated method stub
		return borrowDao.selectByPrimaryKey(bid);
	}

	@Override
	public int updateByExampleSelective(Borrow record, BorrowExample example) {
		// TODO Auto-generated method stub
		return borrowDao.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(Borrow record, BorrowExample example) {
		// TODO Auto-generated method stub
		return borrowDao.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(Borrow record) {
		// TODO Auto-generated method stub
		return borrowDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Borrow record) {
		// TODO Auto-generated method stub
		return borrowDao.updateByPrimaryKey(record);
	}

	@Override
	public List<Borrow> selectForPage(BorrowExample example) {
		// TODO Auto-generated method stub
		return borrowDao.selectForPage( example);
	}
	

}
