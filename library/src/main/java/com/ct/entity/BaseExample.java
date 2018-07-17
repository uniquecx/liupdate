package com.ct.entity;

public class BaseExample  {
	private Integer pageNow; 
	private  Integer total; 
	private Integer pageSize=10; 
	private Integer offset; 
	private Integer pageTotal; 
	public Integer getPageNow() {
		return pageNow;
	}
	public void setPageNow(Integer pageNow) {
		this.pageNow = pageNow;
		 
		this.offset=this.pageSize*(this.pageNow-1);
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
		 
		if(this.total%this.pageSize==0){
			this.pageTotal=this.total/this.pageSize;
		}else{
			this.pageTotal=this.total/this.pageSize+1;
		}
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getOffset() {
		return offset;
	}
	public void setOffset(Integer offset) {
		this.offset = offset;
	}
	public Integer getPageTotal() {
		return pageTotal;
	}
	public void setPageTotal(Integer pageTotal) {
		this.pageTotal = pageTotal;
	}
	

}
