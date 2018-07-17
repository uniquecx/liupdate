package com.ct.vo;

import java.util.List;

public class MenuVo {
	  private Integer id;
	  private String text;
	  private List<MenuVo> children;
	  
	  private String url;//自定义个属性，存放数据库查询出来的url路径，在树形结构中默认没有

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<MenuVo> getChildren() {
		return children;
	}

	public void setChildren(List<MenuVo> children) {
		this.children = children;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}


}