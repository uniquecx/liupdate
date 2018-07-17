package com.ct.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ct.dao.ReadertypeDao;
import com.ct.entity.Readertype;
import com.ct.entity.ReadertypeExample;
import com.ct.service.ReadertypeService;
@Service
public class ReadertypeServiceImpl  implements ReadertypeService{

	@Autowired
	private ReadertypeDao readertypeDao;

	@Override
	public int countByExample(ReadertypeExample example) {
		// TODO Auto-generated method stub
		return readertypeDao.countByExample(example);
	}

	@Override
	public int deleteByExample(ReadertypeExample example) {
		// TODO Auto-generated method stub
		return readertypeDao.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Integer rid) {
		// TODO Auto-generated method stub
		return readertypeDao.deleteByPrimaryKey(rid);
	}

	@Override
	public int insert(Readertype record) {
		// TODO Auto-generated method stub
		return readertypeDao.insert(record);
	}

	@Override
	public int insertSelective(Readertype record) {
		// TODO Auto-generated method stub
		return readertypeDao.insertSelective(record);
	}

	@Override
	public List<Readertype> selectByExample(ReadertypeExample example) {
		// TODO Auto-generated method stub
		return readertypeDao.selectByExample(example);
	}

	@Override
	public Readertype selectByPrimaryKey(Integer rid) {
		// TODO Auto-generated method stub
		return readertypeDao.selectByPrimaryKey(rid);
	}

	@Override
	public int updateByExampleSelective(Readertype record,
			ReadertypeExample example) {
		// TODO Auto-generated method stub
		return readertypeDao.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(Readertype record, ReadertypeExample example) {
		// TODO Auto-generated method stub
		return readertypeDao.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(Readertype record) {
		// TODO Auto-generated method stub
		return readertypeDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Readertype record) {
		// TODO Auto-generated method stub
		return readertypeDao.updateByPrimaryKey(record);
	}
	
}
