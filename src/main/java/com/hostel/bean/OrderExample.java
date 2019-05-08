package com.hostel.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class OrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andOrdIdIsNull() {
            addCriterion("ord_id is null");
            return (Criteria) this;
        }

        public Criteria andOrdIdIsNotNull() {
            addCriterion("ord_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrdIdEqualTo(Integer value) {
            addCriterion("ord_id =", value, "ordId");
            return (Criteria) this;
        }

        public Criteria andOrdIdNotEqualTo(Integer value) {
            addCriterion("ord_id <>", value, "ordId");
            return (Criteria) this;
        }

        public Criteria andOrdIdGreaterThan(Integer value) {
            addCriterion("ord_id >", value, "ordId");
            return (Criteria) this;
        }

        public Criteria andOrdIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ord_id >=", value, "ordId");
            return (Criteria) this;
        }

        public Criteria andOrdIdLessThan(Integer value) {
            addCriterion("ord_id <", value, "ordId");
            return (Criteria) this;
        }

        public Criteria andOrdIdLessThanOrEqualTo(Integer value) {
            addCriterion("ord_id <=", value, "ordId");
            return (Criteria) this;
        }

        public Criteria andOrdIdIn(List<Integer> values) {
            addCriterion("ord_id in", values, "ordId");
            return (Criteria) this;
        }

        public Criteria andOrdIdNotIn(List<Integer> values) {
            addCriterion("ord_id not in", values, "ordId");
            return (Criteria) this;
        }

        public Criteria andOrdIdBetween(Integer value1, Integer value2) {
            addCriterion("ord_id between", value1, value2, "ordId");
            return (Criteria) this;
        }

        public Criteria andOrdIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ord_id not between", value1, value2, "ordId");
            return (Criteria) this;
        }

        public Criteria andOrdPeoNameIsNull() {
            addCriterion("ord_peo_name is null");
            return (Criteria) this;
        }

        public Criteria andOrdPeoNameIsNotNull() {
            addCriterion("ord_peo_name is not null");
            return (Criteria) this;
        }

        public Criteria andOrdPeoNameEqualTo(String value) {
            addCriterion("ord_peo_name =", value, "ordPeoName");
            return (Criteria) this;
        }

        public Criteria andOrdPeoNameNotEqualTo(String value) {
            addCriterion("ord_peo_name <>", value, "ordPeoName");
            return (Criteria) this;
        }

        public Criteria andOrdPeoNameGreaterThan(String value) {
            addCriterion("ord_peo_name >", value, "ordPeoName");
            return (Criteria) this;
        }

        public Criteria andOrdPeoNameGreaterThanOrEqualTo(String value) {
            addCriterion("ord_peo_name >=", value, "ordPeoName");
            return (Criteria) this;
        }

        public Criteria andOrdPeoNameLessThan(String value) {
            addCriterion("ord_peo_name <", value, "ordPeoName");
            return (Criteria) this;
        }

        public Criteria andOrdPeoNameLessThanOrEqualTo(String value) {
            addCriterion("ord_peo_name <=", value, "ordPeoName");
            return (Criteria) this;
        }

        public Criteria andOrdPeoNameLike(String value) {
            addCriterion("ord_peo_name like", value, "ordPeoName");
            return (Criteria) this;
        }

        public Criteria andOrdPeoNameNotLike(String value) {
            addCriterion("ord_peo_name not like", value, "ordPeoName");
            return (Criteria) this;
        }

        public Criteria andOrdPeoNameIn(List<String> values) {
            addCriterion("ord_peo_name in", values, "ordPeoName");
            return (Criteria) this;
        }

        public Criteria andOrdPeoNameNotIn(List<String> values) {
            addCriterion("ord_peo_name not in", values, "ordPeoName");
            return (Criteria) this;
        }

        public Criteria andOrdPeoNameBetween(String value1, String value2) {
            addCriterion("ord_peo_name between", value1, value2, "ordPeoName");
            return (Criteria) this;
        }

        public Criteria andOrdPeoNameNotBetween(String value1, String value2) {
            addCriterion("ord_peo_name not between", value1, value2, "ordPeoName");
            return (Criteria) this;
        }

        public Criteria andOrdPeoPhoneIsNull() {
            addCriterion("ord_peo_phone is null");
            return (Criteria) this;
        }

        public Criteria andOrdPeoPhoneIsNotNull() {
            addCriterion("ord_peo_phone is not null");
            return (Criteria) this;
        }

        public Criteria andOrdPeoPhoneEqualTo(String value) {
            addCriterion("ord_peo_phone =", value, "ordPeoPhone");
            return (Criteria) this;
        }

        public Criteria andOrdPeoPhoneNotEqualTo(String value) {
            addCriterion("ord_peo_phone <>", value, "ordPeoPhone");
            return (Criteria) this;
        }

        public Criteria andOrdPeoPhoneGreaterThan(String value) {
            addCriterion("ord_peo_phone >", value, "ordPeoPhone");
            return (Criteria) this;
        }

        public Criteria andOrdPeoPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("ord_peo_phone >=", value, "ordPeoPhone");
            return (Criteria) this;
        }

        public Criteria andOrdPeoPhoneLessThan(String value) {
            addCriterion("ord_peo_phone <", value, "ordPeoPhone");
            return (Criteria) this;
        }

        public Criteria andOrdPeoPhoneLessThanOrEqualTo(String value) {
            addCriterion("ord_peo_phone <=", value, "ordPeoPhone");
            return (Criteria) this;
        }

        public Criteria andOrdPeoPhoneLike(String value) {
            addCriterion("ord_peo_phone like", value, "ordPeoPhone");
            return (Criteria) this;
        }

        public Criteria andOrdPeoPhoneNotLike(String value) {
            addCriterion("ord_peo_phone not like", value, "ordPeoPhone");
            return (Criteria) this;
        }

        public Criteria andOrdPeoPhoneIn(List<String> values) {
            addCriterion("ord_peo_phone in", values, "ordPeoPhone");
            return (Criteria) this;
        }

        public Criteria andOrdPeoPhoneNotIn(List<String> values) {
            addCriterion("ord_peo_phone not in", values, "ordPeoPhone");
            return (Criteria) this;
        }

        public Criteria andOrdPeoPhoneBetween(String value1, String value2) {
            addCriterion("ord_peo_phone between", value1, value2, "ordPeoPhone");
            return (Criteria) this;
        }

        public Criteria andOrdPeoPhoneNotBetween(String value1, String value2) {
            addCriterion("ord_peo_phone not between", value1, value2, "ordPeoPhone");
            return (Criteria) this;
        }

        public Criteria andOrdTimeIsNull() {
            addCriterion("ord_time is null");
            return (Criteria) this;
        }

        public Criteria andOrdTimeIsNotNull() {
            addCriterion("ord_time is not null");
            return (Criteria) this;
        }

        public Criteria andOrdTimeEqualTo(Date value) {
            addCriterionForJDBCDate("ord_time =", value, "ordTime");
            return (Criteria) this;
        }

        public Criteria andOrdTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("ord_time <>", value, "ordTime");
            return (Criteria) this;
        }

        public Criteria andOrdTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("ord_time >", value, "ordTime");
            return (Criteria) this;
        }

        public Criteria andOrdTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ord_time >=", value, "ordTime");
            return (Criteria) this;
        }

        public Criteria andOrdTimeLessThan(Date value) {
            addCriterionForJDBCDate("ord_time <", value, "ordTime");
            return (Criteria) this;
        }

        public Criteria andOrdTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ord_time <=", value, "ordTime");
            return (Criteria) this;
        }

        public Criteria andOrdTimeIn(List<Date> values) {
            addCriterionForJDBCDate("ord_time in", values, "ordTime");
            return (Criteria) this;
        }

        public Criteria andOrdTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("ord_time not in", values, "ordTime");
            return (Criteria) this;
        }

        public Criteria andOrdTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ord_time between", value1, value2, "ordTime");
            return (Criteria) this;
        }

        public Criteria andOrdTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ord_time not between", value1, value2, "ordTime");
            return (Criteria) this;
        }

        public Criteria andNightIsNull() {
            addCriterion("night is null");
            return (Criteria) this;
        }

        public Criteria andNightIsNotNull() {
            addCriterion("night is not null");
            return (Criteria) this;
        }

        public Criteria andNightEqualTo(Integer value) {
            addCriterion("night =", value, "night");
            return (Criteria) this;
        }

        public Criteria andNightNotEqualTo(Integer value) {
            addCriterion("night <>", value, "night");
            return (Criteria) this;
        }

        public Criteria andNightGreaterThan(Integer value) {
            addCriterion("night >", value, "night");
            return (Criteria) this;
        }

        public Criteria andNightGreaterThanOrEqualTo(Integer value) {
            addCriterion("night >=", value, "night");
            return (Criteria) this;
        }

        public Criteria andNightLessThan(Integer value) {
            addCriterion("night <", value, "night");
            return (Criteria) this;
        }

        public Criteria andNightLessThanOrEqualTo(Integer value) {
            addCriterion("night <=", value, "night");
            return (Criteria) this;
        }

        public Criteria andNightIn(List<Integer> values) {
            addCriterion("night in", values, "night");
            return (Criteria) this;
        }

        public Criteria andNightNotIn(List<Integer> values) {
            addCriterion("night not in", values, "night");
            return (Criteria) this;
        }

        public Criteria andNightBetween(Integer value1, Integer value2) {
            addCriterion("night between", value1, value2, "night");
            return (Criteria) this;
        }

        public Criteria andNightNotBetween(Integer value1, Integer value2) {
            addCriterion("night not between", value1, value2, "night");
            return (Criteria) this;
        }

        public Criteria andOrdStatusIsNull() {
            addCriterion("ord_status is null");
            return (Criteria) this;
        }

        public Criteria andOrdStatusIsNotNull() {
            addCriterion("ord_status is not null");
            return (Criteria) this;
        }

        public Criteria andOrdStatusEqualTo(String value) {
            addCriterion("ord_status =", value, "ordStatus");
            return (Criteria) this;
        }

        public Criteria andOrdStatusNotEqualTo(String value) {
            addCriterion("ord_status <>", value, "ordStatus");
            return (Criteria) this;
        }

        public Criteria andOrdStatusGreaterThan(String value) {
            addCriterion("ord_status >", value, "ordStatus");
            return (Criteria) this;
        }

        public Criteria andOrdStatusGreaterThanOrEqualTo(String value) {
            addCriterion("ord_status >=", value, "ordStatus");
            return (Criteria) this;
        }

        public Criteria andOrdStatusLessThan(String value) {
            addCriterion("ord_status <", value, "ordStatus");
            return (Criteria) this;
        }

        public Criteria andOrdStatusLessThanOrEqualTo(String value) {
            addCriterion("ord_status <=", value, "ordStatus");
            return (Criteria) this;
        }

        public Criteria andOrdStatusLike(String value) {
            addCriterion("ord_status like", value, "ordStatus");
            return (Criteria) this;
        }

        public Criteria andOrdStatusNotLike(String value) {
            addCriterion("ord_status not like", value, "ordStatus");
            return (Criteria) this;
        }

        public Criteria andOrdStatusIn(List<String> values) {
            addCriterion("ord_status in", values, "ordStatus");
            return (Criteria) this;
        }

        public Criteria andOrdStatusNotIn(List<String> values) {
            addCriterion("ord_status not in", values, "ordStatus");
            return (Criteria) this;
        }

        public Criteria andOrdStatusBetween(String value1, String value2) {
            addCriterion("ord_status between", value1, value2, "ordStatus");
            return (Criteria) this;
        }

        public Criteria andOrdStatusNotBetween(String value1, String value2) {
            addCriterion("ord_status not between", value1, value2, "ordStatus");
            return (Criteria) this;
        }

        public Criteria andOrdFeeIsNull() {
            addCriterion("ord_fee is null");
            return (Criteria) this;
        }

        public Criteria andOrdFeeIsNotNull() {
            addCriterion("ord_fee is not null");
            return (Criteria) this;
        }

        public Criteria andOrdFeeEqualTo(Long value) {
            addCriterion("ord_fee =", value, "ordFee");
            return (Criteria) this;
        }

        public Criteria andOrdFeeNotEqualTo(Long value) {
            addCriterion("ord_fee <>", value, "ordFee");
            return (Criteria) this;
        }

        public Criteria andOrdFeeGreaterThan(Long value) {
            addCriterion("ord_fee >", value, "ordFee");
            return (Criteria) this;
        }

        public Criteria andOrdFeeGreaterThanOrEqualTo(Long value) {
            addCriterion("ord_fee >=", value, "ordFee");
            return (Criteria) this;
        }

        public Criteria andOrdFeeLessThan(Long value) {
            addCriterion("ord_fee <", value, "ordFee");
            return (Criteria) this;
        }

        public Criteria andOrdFeeLessThanOrEqualTo(Long value) {
            addCriterion("ord_fee <=", value, "ordFee");
            return (Criteria) this;
        }

        public Criteria andOrdFeeIn(List<Long> values) {
            addCriterion("ord_fee in", values, "ordFee");
            return (Criteria) this;
        }

        public Criteria andOrdFeeNotIn(List<Long> values) {
            addCriterion("ord_fee not in", values, "ordFee");
            return (Criteria) this;
        }

        public Criteria andOrdFeeBetween(Long value1, Long value2) {
            addCriterion("ord_fee between", value1, value2, "ordFee");
            return (Criteria) this;
        }

        public Criteria andOrdFeeNotBetween(Long value1, Long value2) {
            addCriterion("ord_fee not between", value1, value2, "ordFee");
            return (Criteria) this;
        }

        public Criteria andOrdRoomIdIsNull() {
            addCriterion("ord_room_id is null");
            return (Criteria) this;
        }

        public Criteria andOrdRoomIdIsNotNull() {
            addCriterion("ord_room_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrdRoomIdEqualTo(Integer value) {
            addCriterion("ord_room_id =", value, "ordRoomId");
            return (Criteria) this;
        }

        public Criteria andOrdRoomIdNotEqualTo(Integer value) {
            addCriterion("ord_room_id <>", value, "ordRoomId");
            return (Criteria) this;
        }

        public Criteria andOrdRoomIdGreaterThan(Integer value) {
            addCriterion("ord_room_id >", value, "ordRoomId");
            return (Criteria) this;
        }

        public Criteria andOrdRoomIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ord_room_id >=", value, "ordRoomId");
            return (Criteria) this;
        }

        public Criteria andOrdRoomIdLessThan(Integer value) {
            addCriterion("ord_room_id <", value, "ordRoomId");
            return (Criteria) this;
        }

        public Criteria andOrdRoomIdLessThanOrEqualTo(Integer value) {
            addCriterion("ord_room_id <=", value, "ordRoomId");
            return (Criteria) this;
        }

        public Criteria andOrdRoomIdIn(List<Integer> values) {
            addCriterion("ord_room_id in", values, "ordRoomId");
            return (Criteria) this;
        }

        public Criteria andOrdRoomIdNotIn(List<Integer> values) {
            addCriterion("ord_room_id not in", values, "ordRoomId");
            return (Criteria) this;
        }

        public Criteria andOrdRoomIdBetween(Integer value1, Integer value2) {
            addCriterion("ord_room_id between", value1, value2, "ordRoomId");
            return (Criteria) this;
        }

        public Criteria andOrdRoomIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ord_room_id not between", value1, value2, "ordRoomId");
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