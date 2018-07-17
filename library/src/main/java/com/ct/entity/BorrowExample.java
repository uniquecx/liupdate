package com.ct.entity;

import java.util.ArrayList;
import java.util.List;

public class BorrowExample extends BaseExample {
	private Integer readerid;
	private Integer bookid;
    public Integer getReaderid() {
		return readerid;
	}

	public void setReaderid(Integer readerid) {
		this.readerid = readerid;
	}

	public Integer getBookid() {
		return bookid;
	}

	public void setBookid(Integer bookid) {
		this.bookid = bookid;
	}

	protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BorrowExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andBidIsNull() {
            addCriterion("bid is null");
            return (Criteria) this;
        }

        public Criteria andBidIsNotNull() {
            addCriterion("bid is not null");
            return (Criteria) this;
        }

        public Criteria andBidEqualTo(Integer value) {
            addCriterion("bid =", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidNotEqualTo(Integer value) {
            addCriterion("bid <>", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidGreaterThan(Integer value) {
            addCriterion("bid >", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidGreaterThanOrEqualTo(Integer value) {
            addCriterion("bid >=", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidLessThan(Integer value) {
            addCriterion("bid <", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidLessThanOrEqualTo(Integer value) {
            addCriterion("bid <=", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidIn(List<Integer> values) {
            addCriterion("bid in", values, "bid");
            return (Criteria) this;
        }

        public Criteria andBidNotIn(List<Integer> values) {
            addCriterion("bid not in", values, "bid");
            return (Criteria) this;
        }

        public Criteria andBidBetween(Integer value1, Integer value2) {
            addCriterion("bid between", value1, value2, "bid");
            return (Criteria) this;
        }

        public Criteria andBidNotBetween(Integer value1, Integer value2) {
            addCriterion("bid not between", value1, value2, "bid");
            return (Criteria) this;
        }

        public Criteria andBookidIsNull() {
            addCriterion("bookid is null");
            return (Criteria) this;
        }

        public Criteria andBookidIsNotNull() {
            addCriterion("bookid is not null");
            return (Criteria) this;
        }

        public Criteria andBookidEqualTo(Integer value) {
            addCriterion("bookid =", value, "bookid");
            return (Criteria) this;
        }

        public Criteria andBookidNotEqualTo(Integer value) {
            addCriterion("bookid <>", value, "bookid");
            return (Criteria) this;
        }

        public Criteria andBookidGreaterThan(Integer value) {
            addCriterion("bookid >", value, "bookid");
            return (Criteria) this;
        }

        public Criteria andBookidGreaterThanOrEqualTo(Integer value) {
            addCriterion("bookid >=", value, "bookid");
            return (Criteria) this;
        }

        public Criteria andBookidLessThan(Integer value) {
            addCriterion("bookid <", value, "bookid");
            return (Criteria) this;
        }

        public Criteria andBookidLessThanOrEqualTo(Integer value) {
            addCriterion("bookid <=", value, "bookid");
            return (Criteria) this;
        }

        public Criteria andBookidIn(List<Integer> values) {
            addCriterion("bookid in", values, "bookid");
            return (Criteria) this;
        }

        public Criteria andBookidNotIn(List<Integer> values) {
            addCriterion("bookid not in", values, "bookid");
            return (Criteria) this;
        }

        public Criteria andBookidBetween(Integer value1, Integer value2) {
            addCriterion("bookid between", value1, value2, "bookid");
            return (Criteria) this;
        }

        public Criteria andBookidNotBetween(Integer value1, Integer value2) {
            addCriterion("bookid not between", value1, value2, "bookid");
            return (Criteria) this;
        }

        public Criteria andBooknameIsNull() {
            addCriterion("bookname is null");
            return (Criteria) this;
        }

        public Criteria andBooknameIsNotNull() {
            addCriterion("bookname is not null");
            return (Criteria) this;
        }

        public Criteria andBooknameEqualTo(String value) {
            addCriterion("bookname =", value, "bookname");
            return (Criteria) this;
        }

        public Criteria andBooknameNotEqualTo(String value) {
            addCriterion("bookname <>", value, "bookname");
            return (Criteria) this;
        }

        public Criteria andBooknameGreaterThan(String value) {
            addCriterion("bookname >", value, "bookname");
            return (Criteria) this;
        }

        public Criteria andBooknameGreaterThanOrEqualTo(String value) {
            addCriterion("bookname >=", value, "bookname");
            return (Criteria) this;
        }

        public Criteria andBooknameLessThan(String value) {
            addCriterion("bookname <", value, "bookname");
            return (Criteria) this;
        }

        public Criteria andBooknameLessThanOrEqualTo(String value) {
            addCriterion("bookname <=", value, "bookname");
            return (Criteria) this;
        }

        public Criteria andBooknameLike(String value) {
            addCriterion("bookname like", value, "bookname");
            return (Criteria) this;
        }

        public Criteria andBooknameNotLike(String value) {
            addCriterion("bookname not like", value, "bookname");
            return (Criteria) this;
        }

        public Criteria andBooknameIn(List<String> values) {
            addCriterion("bookname in", values, "bookname");
            return (Criteria) this;
        }

        public Criteria andBooknameNotIn(List<String> values) {
            addCriterion("bookname not in", values, "bookname");
            return (Criteria) this;
        }

        public Criteria andBooknameBetween(String value1, String value2) {
            addCriterion("bookname between", value1, value2, "bookname");
            return (Criteria) this;
        }

        public Criteria andBooknameNotBetween(String value1, String value2) {
            addCriterion("bookname not between", value1, value2, "bookname");
            return (Criteria) this;
        }

        public Criteria andReaderidIsNull() {
            addCriterion("readerid is null");
            return (Criteria) this;
        }

        public Criteria andReaderidIsNotNull() {
            addCriterion("readerid is not null");
            return (Criteria) this;
        }

        public Criteria andReaderidEqualTo(Integer value) {
            addCriterion("readerid =", value, "readerid");
            return (Criteria) this;
        }

        public Criteria andReaderidNotEqualTo(Integer value) {
            addCriterion("readerid <>", value, "readerid");
            return (Criteria) this;
        }

        public Criteria andReaderidGreaterThan(Integer value) {
            addCriterion("readerid >", value, "readerid");
            return (Criteria) this;
        }

        public Criteria andReaderidGreaterThanOrEqualTo(Integer value) {
            addCriterion("readerid >=", value, "readerid");
            return (Criteria) this;
        }

        public Criteria andReaderidLessThan(Integer value) {
            addCriterion("readerid <", value, "readerid");
            return (Criteria) this;
        }

        public Criteria andReaderidLessThanOrEqualTo(Integer value) {
            addCriterion("readerid <=", value, "readerid");
            return (Criteria) this;
        }

        public Criteria andReaderidIn(List<Integer> values) {
            addCriterion("readerid in", values, "readerid");
            return (Criteria) this;
        }

        public Criteria andReaderidNotIn(List<Integer> values) {
            addCriterion("readerid not in", values, "readerid");
            return (Criteria) this;
        }

        public Criteria andReaderidBetween(Integer value1, Integer value2) {
            addCriterion("readerid between", value1, value2, "readerid");
            return (Criteria) this;
        }

        public Criteria andReaderidNotBetween(Integer value1, Integer value2) {
            addCriterion("readerid not between", value1, value2, "readerid");
            return (Criteria) this;
        }

        public Criteria andRnameIsNull() {
            addCriterion("rname is null");
            return (Criteria) this;
        }

        public Criteria andRnameIsNotNull() {
            addCriterion("rname is not null");
            return (Criteria) this;
        }

        public Criteria andRnameEqualTo(String value) {
            addCriterion("rname =", value, "rname");
            return (Criteria) this;
        }

        public Criteria andRnameNotEqualTo(String value) {
            addCriterion("rname <>", value, "rname");
            return (Criteria) this;
        }

        public Criteria andRnameGreaterThan(String value) {
            addCriterion("rname >", value, "rname");
            return (Criteria) this;
        }

        public Criteria andRnameGreaterThanOrEqualTo(String value) {
            addCriterion("rname >=", value, "rname");
            return (Criteria) this;
        }

        public Criteria andRnameLessThan(String value) {
            addCriterion("rname <", value, "rname");
            return (Criteria) this;
        }

        public Criteria andRnameLessThanOrEqualTo(String value) {
            addCriterion("rname <=", value, "rname");
            return (Criteria) this;
        }

        public Criteria andRnameLike(String value) {
            addCriterion("rname like", value, "rname");
            return (Criteria) this;
        }

        public Criteria andRnameNotLike(String value) {
            addCriterion("rname not like", value, "rname");
            return (Criteria) this;
        }

        public Criteria andRnameIn(List<String> values) {
            addCriterion("rname in", values, "rname");
            return (Criteria) this;
        }

        public Criteria andRnameNotIn(List<String> values) {
            addCriterion("rname not in", values, "rname");
            return (Criteria) this;
        }

        public Criteria andRnameBetween(String value1, String value2) {
            addCriterion("rname between", value1, value2, "rname");
            return (Criteria) this;
        }

        public Criteria andRnameNotBetween(String value1, String value2) {
            addCriterion("rname not between", value1, value2, "rname");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(Integer value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(Integer value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(Integer value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(Integer value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(Integer value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(Integer value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<Integer> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<Integer> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(Integer value1, Integer value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(Integer value1, Integer value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andJdateIsNull() {
            addCriterion("jdate is null");
            return (Criteria) this;
        }

        public Criteria andJdateIsNotNull() {
            addCriterion("jdate is not null");
            return (Criteria) this;
        }

        public Criteria andJdateEqualTo(String value) {
            addCriterion("jdate =", value, "jdate");
            return (Criteria) this;
        }

        public Criteria andJdateNotEqualTo(String value) {
            addCriterion("jdate <>", value, "jdate");
            return (Criteria) this;
        }

        public Criteria andJdateGreaterThan(String value) {
            addCriterion("jdate >", value, "jdate");
            return (Criteria) this;
        }

        public Criteria andJdateGreaterThanOrEqualTo(String value) {
            addCriterion("jdate >=", value, "jdate");
            return (Criteria) this;
        }

        public Criteria andJdateLessThan(String value) {
            addCriterion("jdate <", value, "jdate");
            return (Criteria) this;
        }

        public Criteria andJdateLessThanOrEqualTo(String value) {
            addCriterion("jdate <=", value, "jdate");
            return (Criteria) this;
        }

        public Criteria andJdateLike(String value) {
            addCriterion("jdate like", value, "jdate");
            return (Criteria) this;
        }

        public Criteria andJdateNotLike(String value) {
            addCriterion("jdate not like", value, "jdate");
            return (Criteria) this;
        }

        public Criteria andJdateIn(List<String> values) {
            addCriterion("jdate in", values, "jdate");
            return (Criteria) this;
        }

        public Criteria andJdateNotIn(List<String> values) {
            addCriterion("jdate not in", values, "jdate");
            return (Criteria) this;
        }

        public Criteria andJdateBetween(String value1, String value2) {
            addCriterion("jdate between", value1, value2, "jdate");
            return (Criteria) this;
        }

        public Criteria andJdateNotBetween(String value1, String value2) {
            addCriterion("jdate not between", value1, value2, "jdate");
            return (Criteria) this;
        }

        public Criteria andYdateIsNull() {
            addCriterion("ydate is null");
            return (Criteria) this;
        }

        public Criteria andYdateIsNotNull() {
            addCriterion("ydate is not null");
            return (Criteria) this;
        }

        public Criteria andYdateEqualTo(String value) {
            addCriterion("ydate =", value, "ydate");
            return (Criteria) this;
        }

        public Criteria andYdateNotEqualTo(String value) {
            addCriterion("ydate <>", value, "ydate");
            return (Criteria) this;
        }

        public Criteria andYdateGreaterThan(String value) {
            addCriterion("ydate >", value, "ydate");
            return (Criteria) this;
        }

        public Criteria andYdateGreaterThanOrEqualTo(String value) {
            addCriterion("ydate >=", value, "ydate");
            return (Criteria) this;
        }

        public Criteria andYdateLessThan(String value) {
            addCriterion("ydate <", value, "ydate");
            return (Criteria) this;
        }

        public Criteria andYdateLessThanOrEqualTo(String value) {
            addCriterion("ydate <=", value, "ydate");
            return (Criteria) this;
        }

        public Criteria andYdateLike(String value) {
            addCriterion("ydate like", value, "ydate");
            return (Criteria) this;
        }

        public Criteria andYdateNotLike(String value) {
            addCriterion("ydate not like", value, "ydate");
            return (Criteria) this;
        }

        public Criteria andYdateIn(List<String> values) {
            addCriterion("ydate in", values, "ydate");
            return (Criteria) this;
        }

        public Criteria andYdateNotIn(List<String> values) {
            addCriterion("ydate not in", values, "ydate");
            return (Criteria) this;
        }

        public Criteria andYdateBetween(String value1, String value2) {
            addCriterion("ydate between", value1, value2, "ydate");
            return (Criteria) this;
        }

        public Criteria andYdateNotBetween(String value1, String value2) {
            addCriterion("ydate not between", value1, value2, "ydate");
            return (Criteria) this;
        }

        public Criteria andGdateIsNull() {
            addCriterion("gdate is null");
            return (Criteria) this;
        }

        public Criteria andGdateIsNotNull() {
            addCriterion("gdate is not null");
            return (Criteria) this;
        }

        public Criteria andGdateEqualTo(String value) {
            addCriterion("gdate =", value, "gdate");
            return (Criteria) this;
        }

        public Criteria andGdateNotEqualTo(String value) {
            addCriterion("gdate <>", value, "gdate");
            return (Criteria) this;
        }

        public Criteria andGdateGreaterThan(String value) {
            addCriterion("gdate >", value, "gdate");
            return (Criteria) this;
        }

        public Criteria andGdateGreaterThanOrEqualTo(String value) {
            addCriterion("gdate >=", value, "gdate");
            return (Criteria) this;
        }

        public Criteria andGdateLessThan(String value) {
            addCriterion("gdate <", value, "gdate");
            return (Criteria) this;
        }

        public Criteria andGdateLessThanOrEqualTo(String value) {
            addCriterion("gdate <=", value, "gdate");
            return (Criteria) this;
        }

        public Criteria andGdateLike(String value) {
            addCriterion("gdate like", value, "gdate");
            return (Criteria) this;
        }

        public Criteria andGdateNotLike(String value) {
            addCriterion("gdate not like", value, "gdate");
            return (Criteria) this;
        }

        public Criteria andGdateIn(List<String> values) {
            addCriterion("gdate in", values, "gdate");
            return (Criteria) this;
        }

        public Criteria andGdateNotIn(List<String> values) {
            addCriterion("gdate not in", values, "gdate");
            return (Criteria) this;
        }

        public Criteria andGdateBetween(String value1, String value2) {
            addCriterion("gdate between", value1, value2, "gdate");
            return (Criteria) this;
        }

        public Criteria andGdateNotBetween(String value1, String value2) {
            addCriterion("gdate not between", value1, value2, "gdate");
            return (Criteria) this;
        }

        public Criteria andBackIsNull() {
            addCriterion("back is null");
            return (Criteria) this;
        }

        public Criteria andBackIsNotNull() {
            addCriterion("back is not null");
            return (Criteria) this;
        }

        public Criteria andBackEqualTo(Integer value) {
            addCriterion("back =", value, "back");
            return (Criteria) this;
        }

        public Criteria andBackNotEqualTo(Integer value) {
            addCriterion("back <>", value, "back");
            return (Criteria) this;
        }

        public Criteria andBackGreaterThan(Integer value) {
            addCriterion("back >", value, "back");
            return (Criteria) this;
        }

        public Criteria andBackGreaterThanOrEqualTo(Integer value) {
            addCriterion("back >=", value, "back");
            return (Criteria) this;
        }

        public Criteria andBackLessThan(Integer value) {
            addCriterion("back <", value, "back");
            return (Criteria) this;
        }

        public Criteria andBackLessThanOrEqualTo(Integer value) {
            addCriterion("back <=", value, "back");
            return (Criteria) this;
        }

        public Criteria andBackIn(List<Integer> values) {
            addCriterion("back in", values, "back");
            return (Criteria) this;
        }

        public Criteria andBackNotIn(List<Integer> values) {
            addCriterion("back not in", values, "back");
            return (Criteria) this;
        }

        public Criteria andBackBetween(Integer value1, Integer value2) {
            addCriterion("back between", value1, value2, "back");
            return (Criteria) this;
        }

        public Criteria andBackNotBetween(Integer value1, Integer value2) {
            addCriterion("back not between", value1, value2, "back");
            return (Criteria) this;
        }

        public Criteria andCountIsNull() {
            addCriterion("count is null");
            return (Criteria) this;
        }

        public Criteria andCountIsNotNull() {
            addCriterion("count is not null");
            return (Criteria) this;
        }

        public Criteria andCountEqualTo(Integer value) {
            addCriterion("count =", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotEqualTo(Integer value) {
            addCriterion("count <>", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountGreaterThan(Integer value) {
            addCriterion("count >", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("count >=", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountLessThan(Integer value) {
            addCriterion("count <", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountLessThanOrEqualTo(Integer value) {
            addCriterion("count <=", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountIn(List<Integer> values) {
            addCriterion("count in", values, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotIn(List<Integer> values) {
            addCriterion("count not in", values, "count");
            return (Criteria) this;
        }

        public Criteria andCountBetween(Integer value1, Integer value2) {
            addCriterion("count between", value1, value2, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotBetween(Integer value1, Integer value2) {
            addCriterion("count not between", value1, value2, "count");
            return (Criteria) this;
        }

        public Criteria andJadminIsNull() {
            addCriterion("jadmin is null");
            return (Criteria) this;
        }

        public Criteria andJadminIsNotNull() {
            addCriterion("jadmin is not null");
            return (Criteria) this;
        }

        public Criteria andJadminEqualTo(Integer value) {
            addCriterion("jadmin =", value, "jadmin");
            return (Criteria) this;
        }

        public Criteria andJadminNotEqualTo(Integer value) {
            addCriterion("jadmin <>", value, "jadmin");
            return (Criteria) this;
        }

        public Criteria andJadminGreaterThan(Integer value) {
            addCriterion("jadmin >", value, "jadmin");
            return (Criteria) this;
        }

        public Criteria andJadminGreaterThanOrEqualTo(Integer value) {
            addCriterion("jadmin >=", value, "jadmin");
            return (Criteria) this;
        }

        public Criteria andJadminLessThan(Integer value) {
            addCriterion("jadmin <", value, "jadmin");
            return (Criteria) this;
        }

        public Criteria andJadminLessThanOrEqualTo(Integer value) {
            addCriterion("jadmin <=", value, "jadmin");
            return (Criteria) this;
        }

        public Criteria andJadminIn(List<Integer> values) {
            addCriterion("jadmin in", values, "jadmin");
            return (Criteria) this;
        }

        public Criteria andJadminNotIn(List<Integer> values) {
            addCriterion("jadmin not in", values, "jadmin");
            return (Criteria) this;
        }

        public Criteria andJadminBetween(Integer value1, Integer value2) {
            addCriterion("jadmin between", value1, value2, "jadmin");
            return (Criteria) this;
        }

        public Criteria andJadminNotBetween(Integer value1, Integer value2) {
            addCriterion("jadmin not between", value1, value2, "jadmin");
            return (Criteria) this;
        }

        public Criteria andGadminIsNull() {
            addCriterion("gadmin is null");
            return (Criteria) this;
        }

        public Criteria andGadminIsNotNull() {
            addCriterion("gadmin is not null");
            return (Criteria) this;
        }

        public Criteria andGadminEqualTo(Integer value) {
            addCriterion("gadmin =", value, "gadmin");
            return (Criteria) this;
        }

        public Criteria andGadminNotEqualTo(Integer value) {
            addCriterion("gadmin <>", value, "gadmin");
            return (Criteria) this;
        }

        public Criteria andGadminGreaterThan(Integer value) {
            addCriterion("gadmin >", value, "gadmin");
            return (Criteria) this;
        }

        public Criteria andGadminGreaterThanOrEqualTo(Integer value) {
            addCriterion("gadmin >=", value, "gadmin");
            return (Criteria) this;
        }

        public Criteria andGadminLessThan(Integer value) {
            addCriterion("gadmin <", value, "gadmin");
            return (Criteria) this;
        }

        public Criteria andGadminLessThanOrEqualTo(Integer value) {
            addCriterion("gadmin <=", value, "gadmin");
            return (Criteria) this;
        }

        public Criteria andGadminIn(List<Integer> values) {
            addCriterion("gadmin in", values, "gadmin");
            return (Criteria) this;
        }

        public Criteria andGadminNotIn(List<Integer> values) {
            addCriterion("gadmin not in", values, "gadmin");
            return (Criteria) this;
        }

        public Criteria andGadminBetween(Integer value1, Integer value2) {
            addCriterion("gadmin between", value1, value2, "gadmin");
            return (Criteria) this;
        }

        public Criteria andGadminNotBetween(Integer value1, Integer value2) {
            addCriterion("gadmin not between", value1, value2, "gadmin");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}