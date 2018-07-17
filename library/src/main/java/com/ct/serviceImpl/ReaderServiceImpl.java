package com.ct.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ct.dao.ReaderDao;
import com.ct.entity.Reader;
import com.ct.entity.ReaderExample;
import com.ct.service.ReaderService;
@Service
public class ReaderServiceImpl implements ReaderService {

	@Autowired
	private ReaderDao readerDao;
	@Override
	public int countByExample(ReaderExample example) {
		// TODO Auto-generated method stub
		return readerDao.countByExample(example);
	}

	@Override
	public int deleteByExample(ReaderExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByPrimaryKey(Integer readerid) {
		// TODO Auto-generated method stub
		return readerDao.deleteByPrimaryKey(readerid);
	}

	@Override
	public int insert(Reader record) {
		// TODO Auto-generated method stub
		return readerDao.insert(record);
	}

	@Override
	public int insertSelective(Reader record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Reader> selectByExample(ReaderExample example) {
		// TODO Auto-generated method stub
		return readerDao.selectByExample(example);
	}

	@Override
	public Reader selectByPrimaryKey(Integer readerid) {
		// TODO Auto-generated method stub
		return readerDao.selectByPrimaryKey(readerid);
	}

	@Override
	public int updateByExampleSelective(Reader record, ReaderExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByExample(Reader record, ReaderExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKeySelective(Reader record) {
		// TODO Auto-generated method stub
		return readerDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Reader record) {
		// TODO Auto-generated method stub
		return readerDao.updateByPrimaryKey(record);
	}

	@Override
	public List<Reader> selectForPage(ReaderExample example) {
		// TODO Auto-generated method stub
		return readerDao.selectForPage(example);
	} 

}
