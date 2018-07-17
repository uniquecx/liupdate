package com.ct.entity;

public class Readertype extends BaseEntity {
    private Integer rid;

    private String type;

    private Integer number;

    private Integer datenumber;

    private Integer count;

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getDatenumber() {
        return datenumber;
    }

    public void setDatenumber(Integer datenumber) {
        this.datenumber = datenumber;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}