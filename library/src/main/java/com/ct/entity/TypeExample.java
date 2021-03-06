package com.ct.entity;

import java.util.ArrayList;
import java.util.List;

public class TypeExample extends BaseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TypeExample() {
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

        public Criteria andTypenumberIsNull() {
            addCriterion("typenumber is null");
            return (Criteria) this;
        }

        public Criteria andTypenumberIsNotNull() {
            addCriterion("typenumber is not null");
            return (Criteria) this;
        }

        public Criteria andTypenumberEqualTo(Integer value) {
            addCriterion("typenumber =", value, "typenumber");
            return (Criteria) this;
        }

        public Criteria andTypenumberNotEqualTo(Integer value) {
            addCriterion("typenumber <>", value, "typenumber");
            return (Criteria) this;
        }

        public Criteria andTypenumberGreaterThan(Integer value) {
            addCriterion("typenumber >", value, "typenumber");
            return (Criteria) this;
        }

        public Criteria andTypenumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("typenumber >=", value, "typenumber");
            return (Criteria) this;
        }

        public Criteria andTypenumberLessThan(Integer value) {
            addCriterion("typenumber <", value, "typenumber");
            return (Criteria) this;
        }

        public Criteria andTypenumberLessThanOrEqualTo(Integer value) {
            addCriterion("typenumber <=", value, "typenumber");
            return (Criteria) this;
        }

        public Criteria andTypenumberIn(List<Integer> values) {
            addCriterion("typenumber in", values, "typenumber");
            return (Criteria) this;
        }

        public Criteria andTypenumberNotIn(List<Integer> values) {
            addCriterion("typenumber not in", values, "typenumber");
            return (Criteria) this;
        }

        public Criteria andTypenumberBetween(Integer value1, Integer value2) {
            addCriterion("typenumber between", value1, value2, "typenumber");
            return (Criteria) this;
        }

        public Criteria andTypenumberNotBetween(Integer value1, Integer value2) {
            addCriterion("typenumber not between", value1, value2, "typenumber");
            return (Criteria) this;
        }

        public Criteria andBooktypeIsNull() {
            addCriterion("booktype is null");
            return (Criteria) this;
        }

        public Criteria andBooktypeIsNotNull() {
            addCriterion("booktype is not null");
            return (Criteria) this;
        }

        public Criteria andBooktypeEqualTo(String value) {
            addCriterion("booktype =", value, "booktype");
            return (Criteria) this;
        }

        public Criteria andBooktypeNotEqualTo(String value) {
            addCriterion("booktype <>", value, "booktype");
            return (Criteria) this;
        }

        public Criteria andBooktypeGreaterThan(String value) {
            addCriterion("booktype >", value, "booktype");
            return (Criteria) this;
        }

        public Criteria andBooktypeGreaterThanOrEqualTo(String value) {
            addCriterion("booktype >=", value, "booktype");
            return (Criteria) this;
        }

        public Criteria andBooktypeLessThan(String value) {
            addCriterion("booktype <", value, "booktype");
            return (Criteria) this;
        }

        public Criteria andBooktypeLessThanOrEqualTo(String value) {
            addCriterion("booktype <=", value, "booktype");
            return (Criteria) this;
        }

        public Criteria andBooktypeLike(String value) {
            addCriterion("booktype like", value, "booktype");
            return (Criteria) this;
        }

        public Criteria andBooktypeNotLike(String value) {
            addCriterion("booktype not like", value, "booktype");
            return (Criteria) this;
        }

        public Criteria andBooktypeIn(List<String> values) {
            addCriterion("booktype in", values, "booktype");
            return (Criteria) this;
        }

        public Criteria andBooktypeNotIn(List<String> values) {
            addCriterion("booktype not in", values, "booktype");
            return (Criteria) this;
        }

        public Criteria andBooktypeBetween(String value1, String value2) {
            addCriterion("booktype between", value1, value2, "booktype");
            return (Criteria) this;
        }

        public Criteria andBooktypeNotBetween(String value1, String value2) {
            addCriterion("booktype not between", value1, value2, "booktype");
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