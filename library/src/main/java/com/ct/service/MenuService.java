package com.ct.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ct.entity.Menu;
import com.ct.entity.MenuExample;
import com.ct.vo.MenuVo;

public interface MenuService {
	 int countByExample(MenuExample example);

	    int deleteByExample(MenuExample example);

	    int deleteByPrimaryKey(Integer id);

	    int insert(Menu record);

	    int insertSelective(Menu record);

	    List<Menu> selectByExample(MenuExample example);

	    Menu selectByPrimaryKey(Integer id);

	    int updateByExampleSelective(@Param("record") Menu record, @Param("example") MenuExample example);

	    int updateByExample(@Param("record") Menu record, @Param("example") MenuExample example);

	    int updateByPrimaryKeySelective(Menu record);

	    int updateByPrimaryKey(Menu record);
	    //查询所有的一节菜单 parentid=0
	    //select * from menu where parentid=0
	    List<Menu> selectRoot();
	    
	    //查找各个1级节点下的子节点 
	    List<Menu> selectChildren(int parentid);
	    
	    public List<MenuVo> selectRootMenuVoTree();
	    
	    public void selectMenuVoTree( List<MenuVo> parentMenus);
	    
	    public List<MenuVo> createMenuTree() ;
	     

}
