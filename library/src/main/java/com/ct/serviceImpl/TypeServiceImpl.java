package com.ct.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ct.dao.TypeDao;
import com.ct.entity.Type;
import com.ct.entity.TypeExample;
import com.ct.service.TypeService;

@Service
public class TypeServiceImpl implements TypeService {
	@Autowired
	private TypeDao typeDao;

	@Override
	public int countByExample(TypeExample example) {
		// TODO Auto-generated method stub
		return typeDao.countByExample(example);
	}

	@Override
	public int deleteByExample(TypeExample example) {
		// TODO Auto-generated method stub
		return typeDao.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Integer typenumber) {
		// TODO Auto-generated method stub
		return typeDao.deleteByPrimaryKey(typenumber);
	}

	@Override
	public int insert(Type record) {
		// TODO Auto-generated method stub
		return typeDao.insert(record);
	}

	@Override
	public int insertSelective(Type record) {
		// TODO Auto-generated method stub
		return typeDao.insertSelective(record);
	}

	@Override
	public List<Type> selectByExample(TypeExample example) {
		// TODO Auto-generated method stub
		return typeDao.selectByExample(example);
	}

	@Override
	public Type selectByPrimaryKey(Integer typenumber) {
		// TODO Auto-generated method stub
		return typeDao.selectByPrimaryKey(typenumber);
	}

	@Override
	public int updateByExampleSelective(Type record, TypeExample example) {
		// TODO Auto-generated method stub
		return typeDao.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(Type record, TypeExample example) {
		// TODO Auto-generated method stub
		return typeDao.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(Type record) {
		// TODO Auto-generated method stub
		return typeDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Type record) {
		// TODO Auto-generated method stub
		return typeDao.updateByPrimaryKey(record);
	}

}
