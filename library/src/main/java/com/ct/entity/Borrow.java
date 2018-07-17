package com.ct.entity;

public class Borrow extends BaseEntity {
    private Integer bid;

    private Integer bookid;

    private String bookname;

    private Integer readerid;

    private String rname;

    private Integer phone;

    private String jdate;

    private String ydate;

    private String gdate;

    private Integer back;

    private Integer count;

    private Integer jadmin;

    private Integer gadmin;

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public Integer getReaderid() {
        return readerid;
    }

    public void setReaderid(Integer readerid) {
        this.readerid = readerid;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getJdate() {
        return jdate;
    }

    public void setJdate(String jdate) {
        this.jdate = jdate;
    }

    public String getYdate() {
        return ydate;
    }

    public void setYdate(String ydate) {
        this.ydate = ydate;
    }

    public String getGdate() {
        return gdate;
    }

    public void setGdate(String gdate) {
        this.gdate = gdate;
    }

    public Integer getBack() {
        return back;
    }

    public void setBack(Integer back) {
        this.back = back;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getJadmin() {
        return jadmin;
    }

    public void setJadmin(Integer jadmin) {
        this.jadmin = jadmin;
    }

    public Integer getGadmin() {
        return gadmin;
    }

    public void setGadmin(Integer gadmin) {
        this.gadmin = gadmin;
    }
}