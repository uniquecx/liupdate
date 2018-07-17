package com.ct.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ct.dao.ManagerDao;
import com.ct.entity.Manager;
import com.ct.entity.ManagerExample;
import com.ct.service.ManagerService;
@Service
public class ManagerServiceImpl  implements ManagerService{
	@Autowired
	private ManagerDao managerDao;

	@Override
	public int countByExample(ManagerExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByExample(ManagerExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByPrimaryKey(Integer managerid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Manager record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(Manager record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Manager> selectByExample(ManagerExample example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Manager selectByPrimaryKey(Integer managerid) {
		// TODO Auto-generated method stub
		return managerDao.selectByPrimaryKey(managerid);
	}

	@Override
	public int updateByExampleSelective(Manager record, ManagerExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByExample(Manager record, ManagerExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKeySelective(Manager record) {
		// TODO Auto-generated method stub
		return managerDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Manager record) {
		// TODO Auto-generated method stub
		return managerDao.updateByPrimaryKey(record);
	}
	

}
