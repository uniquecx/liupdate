package com.ct.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ct.dao.MenuDao;
import com.ct.entity.Menu;
import com.ct.entity.MenuExample;
import com.ct.service.MenuService;
import com.ct.vo.MenuVo;
@Service
public class MenuServiceImpl  implements MenuService{
	@Autowired
	private MenuDao menuDao;

	@Override
	public int countByExample(MenuExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByExample(MenuExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Menu record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(Menu record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Menu> selectByExample(MenuExample example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Menu selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByExampleSelective(Menu record, MenuExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByExample(Menu record, MenuExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKeySelective(Menu record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Menu record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Menu> selectRoot() {
		// TODO Auto-generated method stub
		return menuDao.selectRoot();
	}

	@Override
	public List<Menu> selectChildren(int parentid) {
		// TODO Auto-generated method stub
		return menuDao.selectChildren(parentid);
	}
	//查找根节点
	public List<MenuVo> selectRootMenuVoTree() {
		 List<MenuVo> list=new ArrayList<MenuVo>();
		List<Menu> list2= this.selectRoot();
		if(list2!=null&&list2.size()>0){
			for (int i = 0; i < list2.size(); i++) {
				Menu m=list2.get(i);
				MenuVo vo=new MenuVo();
				vo.setId(m.getId());
				vo.setText(m.getText());
				vo.setUrl(m.getUrl());
				list.add(vo);
				
				
			}
		}
		return list;
	}
	
	
	
	
	
	
	//递归查询 递归查询父节点集合下所有子节点列表
	public void selectMenuVoTree( List<MenuVo> parentMenus){
		if(parentMenus!=null&&parentMenus.size()>0){
		for (int i = 0; i < parentMenus.size(); i++) {
			MenuVo parentMenuVo=parentMenus.get(i);
			List<Menu> childrenMenus=selectChildren(parentMenuVo.getId());
			if(childrenMenus!=null&&childrenMenus.size()>0){
				//存放子节点对象MenuVo
				List<MenuVo> list_1=new ArrayList<MenuVo>();
				for (int j = 0; j < childrenMenus.size(); j++) {
					Menu m=childrenMenus.get(j);
					MenuVo vo=new MenuVo();
					vo.setId(m.getId());
					vo.setText(m.getText());
					vo.setUrl(m.getUrl());
					list_1.add(vo);

				}
				selectMenuVoTree(list_1);
				parentMenuVo.setChildren(list_1);
			}
			
		}
		}
	} 
	//创建树形菜单
	public List<MenuVo> createMenuTree() {
		 //查询根节点
		List<MenuVo> list=this.selectRootMenuVoTree();
		//递归查询子节点
		this.selectMenuVoTree(list);
		return list;
	}

}
