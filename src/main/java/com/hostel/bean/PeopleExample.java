package com.hostel.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PeopleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PeopleExample() {
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

        public Criteria andPeoNameIsNull() {
            addCriterion("peo_name is null");
            return (Criteria) this;
        }

        public Criteria andPeoNameIsNotNull() {
            addCriterion("peo_name is not null");
            return (Criteria) this;
        }

        public Criteria andPeoNameEqualTo(String value) {
            addCriterion("peo_name =", value, "peoName");
            return (Criteria) this;
        }

        public Criteria andPeoNameNotEqualTo(String value) {
            addCriterion("peo_name <>", value, "peoName");
            return (Criteria) this;
        }

        public Criteria andPeoNameGreaterThan(String value) {
            addCriterion("peo_name >", value, "peoName");
            return (Criteria) this;
        }

        public Criteria andPeoNameGreaterThanOrEqualTo(String value) {
            addCriterion("peo_name >=", value, "peoName");
            return (Criteria) this;
        }

        public Criteria andPeoNameLessThan(String value) {
            addCriterion("peo_name <", value, "peoName");
            return (Criteria) this;
        }

        public Criteria andPeoNameLessThanOrEqualTo(String value) {
            addCriterion("peo_name <=", value, "peoName");
            return (Criteria) this;
        }

        public Criteria andPeoNameLike(String value) {
            addCriterion("peo_name like", value, "peoName");
            return (Criteria) this;
        }

        public Criteria andPeoNameNotLike(String value) {
            addCriterion("peo_name not like", value, "peoName");
            return (Criteria) this;
        }

        public Criteria andPeoNameIn(List<String> values) {
            addCriterion("peo_name in", values, "peoName");
            return (Criteria) this;
        }

        public Criteria andPeoNameNotIn(List<String> values) {
            addCriterion("peo_name not in", values, "peoName");
            return (Criteria) this;
        }

        public Criteria andPeoNameBetween(String value1, String value2) {
            addCriterion("peo_name between", value1, value2, "peoName");
            return (Criteria) this;
        }

        public Criteria andPeoNameNotBetween(String value1, String value2) {
            addCriterion("peo_name not between", value1, value2, "peoName");
            return (Criteria) this;
        }

        public Criteria andPeoPhoneIsNull() {
            addCriterion("peo_phone is null");
            return (Criteria) this;
        }

        public Criteria andPeoPhoneIsNotNull() {
            addCriterion("peo_phone is not null");
            return (Criteria) this;
        }

        public Criteria andPeoPhoneEqualTo(String value) {
            addCriterion("peo_phone =", value, "peoPhone");
            return (Criteria) this;
        }

        public Criteria andPeoPhoneNotEqualTo(String value) {
            addCriterion("peo_phone <>", value, "peoPhone");
            return (Criteria) this;
        }

        public Criteria andPeoPhoneGreaterThan(String value) {
            addCriterion("peo_phone >", value, "peoPhone");
            return (Criteria) this;
        }

        public Criteria andPeoPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("peo_phone >=", value, "peoPhone");
            return (Criteria) this;
        }

        public Criteria andPeoPhoneLessThan(String value) {
            addCriterion("peo_phone <", value, "peoPhone");
            return (Criteria) this;
        }

        public Criteria andPeoPhoneLessThanOrEqualTo(String value) {
            addCriterion("peo_phone <=", value, "peoPhone");
            return (Criteria) this;
        }

        public Criteria andPeoPhoneLike(String value) {
            addCriterion("peo_phone like", value, "peoPhone");
            return (Criteria) this;
        }

        public Criteria andPeoPhoneNotLike(String value) {
            addCriterion("peo_phone not like", value, "peoPhone");
            return (Criteria) this;
        }

        public Criteria andPeoPhoneIn(List<String> values) {
            addCriterion("peo_phone in", values, "peoPhone");
            return (Criteria) this;
        }

        public Criteria andPeoPhoneNotIn(List<String> values) {
            addCriterion("peo_phone not in", values, "peoPhone");
            return (Criteria) this;
        }

        public Criteria andPeoPhoneBetween(String value1, String value2) {
            addCriterion("peo_phone between", value1, value2, "peoPhone");
            return (Criteria) this;
        }

        public Criteria andPeoPhoneNotBetween(String value1, String value2) {
            addCriterion("peo_phone not between", value1, value2, "peoPhone");
            return (Criteria) this;
        }

        public Criteria andConsumeIsNull() {
            addCriterion("consume is null");
            return (Criteria) this;
        }

        public Criteria andConsumeIsNotNull() {
            addCriterion("consume is not null");
            return (Criteria) this;
        }

        public Criteria andConsumeEqualTo(BigDecimal value) {
            addCriterion("consume =", value, "consume");
            return (Criteria) this;
        }

        public Criteria andConsumeNotEqualTo(BigDecimal value) {
            addCriterion("consume <>", value, "consume");
            return (Criteria) this;
        }

        public Criteria andConsumeGreaterThan(BigDecimal value) {
            addCriterion("consume >", value, "consume");
            return (Criteria) this;
        }

        public Criteria andConsumeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("consume >=", value, "consume");
            return (Criteria) this;
        }

        public Criteria andConsumeLessThan(BigDecimal value) {
            addCriterion("consume <", value, "consume");
            return (Criteria) this;
        }

        public Criteria andConsumeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("consume <=", value, "consume");
            return (Criteria) this;
        }

        public Criteria andConsumeIn(List<BigDecimal> values) {
            addCriterion("consume in", values, "consume");
            return (Criteria) this;
        }

        public Criteria andConsumeNotIn(List<BigDecimal> values) {
            addCriterion("consume not in", values, "consume");
            return (Criteria) this;
        }

        public Criteria andConsumeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("consume between", value1, value2, "consume");
            return (Criteria) this;
        }

        public Criteria andConsumeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("consume not between", value1, value2, "consume");
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