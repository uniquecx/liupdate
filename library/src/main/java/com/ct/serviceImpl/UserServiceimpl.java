package com.ct.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ct.dao.UserMapper;
import com.ct.entity.User;
import com.ct.entity.UserExample;
import com.ct.service.UserService;

@Service
public class UserServiceimpl implements UserService{
	
	@Autowired
	private UserMapper UserMapper;
	@Override
	public int countByExample(UserExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByExample(UserExample example) {
		// TODO Auto-generated method stub
		return UserMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(User record) {
		// TODO Auto-generated method stub
		return UserMapper.insert(record);
	}

	@Override
	public int insertSelective(User record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<User> selectByExample(UserExample example) {
		// TODO Auto-generated method stub
		return UserMapper.selectByExample(example);
	}

	@Override
	public User selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return UserMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByExampleSelective(User record, UserExample example) {
		// TODO Auto-generated method stub
		return UserMapper.updateByExample(record, example);
	}

	@Override
	public int updateByExample(User record, UserExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKeySelective(User record) {
		// TODO Auto-generated method stub
		return UserMapper.updateByPrimaryKey(record);
	}

	@Override
	public int updateByPrimaryKey(User record) {
		// TODO Auto-generated method stub
		return UserMapper.updateByPrimaryKey(record);
	}

	@Override
	public User selectByuser(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return UserMapper.selectByuser(map);
	}

	@Override
	public List<User> selectByname(String username) {
		// TODO Auto-generated method stub
		return UserMapper.selectByname(username);
	}

}
