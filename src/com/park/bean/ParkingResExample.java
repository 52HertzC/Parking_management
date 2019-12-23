package com.park.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ParkingResExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ParkingResExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andResCarIdIsNull() {
            addCriterion("res_car_id is null");
            return (Criteria) this;
        }

        public Criteria andResCarIdIsNotNull() {
            addCriterion("res_car_id is not null");
            return (Criteria) this;
        }

        public Criteria andResCarIdEqualTo(String value) {
            addCriterion("res_car_id =", value, "resCarId");
            return (Criteria) this;
        }

        public Criteria andResCarIdNotEqualTo(String value) {
            addCriterion("res_car_id <>", value, "resCarId");
            return (Criteria) this;
        }

        public Criteria andResCarIdGreaterThan(String value) {
            addCriterion("res_car_id >", value, "resCarId");
            return (Criteria) this;
        }

        public Criteria andResCarIdGreaterThanOrEqualTo(String value) {
            addCriterion("res_car_id >=", value, "resCarId");
            return (Criteria) this;
        }

        public Criteria andResCarIdLessThan(String value) {
            addCriterion("res_car_id <", value, "resCarId");
            return (Criteria) this;
        }

        public Criteria andResCarIdLessThanOrEqualTo(String value) {
            addCriterion("res_car_id <=", value, "resCarId");
            return (Criteria) this;
        }

        public Criteria andResCarIdLike(String value) {
            addCriterion("res_car_id like", value, "resCarId");
            return (Criteria) this;
        }

        public Criteria andResCarIdNotLike(String value) {
            addCriterion("res_car_id not like", value, "resCarId");
            return (Criteria) this;
        }

        public Criteria andResCarIdIn(List<String> values) {
            addCriterion("res_car_id in", values, "resCarId");
            return (Criteria) this;
        }

        public Criteria andResCarIdNotIn(List<String> values) {
            addCriterion("res_car_id not in", values, "resCarId");
            return (Criteria) this;
        }

        public Criteria andResCarIdBetween(String value1, String value2) {
            addCriterion("res_car_id between", value1, value2, "resCarId");
            return (Criteria) this;
        }

        public Criteria andResCarIdNotBetween(String value1, String value2) {
            addCriterion("res_car_id not between", value1, value2, "resCarId");
            return (Criteria) this;
        }

        public Criteria andResStaIdIsNull() {
            addCriterion("res_sta_id is null");
            return (Criteria) this;
        }

        public Criteria andResStaIdIsNotNull() {
            addCriterion("res_sta_id is not null");
            return (Criteria) this;
        }

        public Criteria andResStaIdEqualTo(String value) {
            addCriterion("res_sta_id =", value, "resStaId");
            return (Criteria) this;
        }

        public Criteria andResStaIdNotEqualTo(String value) {
            addCriterion("res_sta_id <>", value, "resStaId");
            return (Criteria) this;
        }

        public Criteria andResStaIdGreaterThan(String value) {
            addCriterion("res_sta_id >", value, "resStaId");
            return (Criteria) this;
        }

        public Criteria andResStaIdGreaterThanOrEqualTo(String value) {
            addCriterion("res_sta_id >=", value, "resStaId");
            return (Criteria) this;
        }

        public Criteria andResStaIdLessThan(String value) {
            addCriterion("res_sta_id <", value, "resStaId");
            return (Criteria) this;
        }

        public Criteria andResStaIdLessThanOrEqualTo(String value) {
            addCriterion("res_sta_id <=", value, "resStaId");
            return (Criteria) this;
        }

        public Criteria andResStaIdLike(String value) {
            addCriterion("res_sta_id like", value, "resStaId");
            return (Criteria) this;
        }

        public Criteria andResStaIdNotLike(String value) {
            addCriterion("res_sta_id not like", value, "resStaId");
            return (Criteria) this;
        }

        public Criteria andResStaIdIn(List<String> values) {
            addCriterion("res_sta_id in", values, "resStaId");
            return (Criteria) this;
        }

        public Criteria andResStaIdNotIn(List<String> values) {
            addCriterion("res_sta_id not in", values, "resStaId");
            return (Criteria) this;
        }

        public Criteria andResStaIdBetween(String value1, String value2) {
            addCriterion("res_sta_id between", value1, value2, "resStaId");
            return (Criteria) this;
        }

        public Criteria andResStaIdNotBetween(String value1, String value2) {
            addCriterion("res_sta_id not between", value1, value2, "resStaId");
            return (Criteria) this;
        }

        public Criteria andResStartTimeIsNull() {
            addCriterion("res_start_time is null");
            return (Criteria) this;
        }

        public Criteria andResStartTimeIsNotNull() {
            addCriterion("res_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andResStartTimeEqualTo(Date value) {
            addCriterion("res_start_time =", value, "resStartTime");
            return (Criteria) this;
        }

        public Criteria andResStartTimeNotEqualTo(Date value) {
            addCriterion("res_start_time <>", value, "resStartTime");
            return (Criteria) this;
        }

        public Criteria andResStartTimeGreaterThan(Date value) {
            addCriterion("res_start_time >", value, "resStartTime");
            return (Criteria) this;
        }

        public Criteria andResStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("res_start_time >=", value, "resStartTime");
            return (Criteria) this;
        }

        public Criteria andResStartTimeLessThan(Date value) {
            addCriterion("res_start_time <", value, "resStartTime");
            return (Criteria) this;
        }

        public Criteria andResStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("res_start_time <=", value, "resStartTime");
            return (Criteria) this;
        }

        public Criteria andResStartTimeIn(List<Date> values) {
            addCriterion("res_start_time in", values, "resStartTime");
            return (Criteria) this;
        }

        public Criteria andResStartTimeNotIn(List<Date> values) {
            addCriterion("res_start_time not in", values, "resStartTime");
            return (Criteria) this;
        }

        public Criteria andResStartTimeBetween(Date value1, Date value2) {
            addCriterion("res_start_time between", value1, value2, "resStartTime");
            return (Criteria) this;
        }

        public Criteria andResStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("res_start_time not between", value1, value2, "resStartTime");
            return (Criteria) this;
        }

        public Criteria andResEndTimeIsNull() {
            addCriterion("res_end_time is null");
            return (Criteria) this;
        }

        public Criteria andResEndTimeIsNotNull() {
            addCriterion("res_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andResEndTimeEqualTo(Date value) {
            addCriterion("res_end_time =", value, "resEndTime");
            return (Criteria) this;
        }

        public Criteria andResEndTimeNotEqualTo(Date value) {
            addCriterion("res_end_time <>", value, "resEndTime");
            return (Criteria) this;
        }

        public Criteria andResEndTimeGreaterThan(Date value) {
            addCriterion("res_end_time >", value, "resEndTime");
            return (Criteria) this;
        }

        public Criteria andResEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("res_end_time >=", value, "resEndTime");
            return (Criteria) this;
        }

        public Criteria andResEndTimeLessThan(Date value) {
            addCriterion("res_end_time <", value, "resEndTime");
            return (Criteria) this;
        }

        public Criteria andResEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("res_end_time <=", value, "resEndTime");
            return (Criteria) this;
        }

        public Criteria andResEndTimeIn(List<Date> values) {
            addCriterion("res_end_time in", values, "resEndTime");
            return (Criteria) this;
        }

        public Criteria andResEndTimeNotIn(List<Date> values) {
            addCriterion("res_end_time not in", values, "resEndTime");
            return (Criteria) this;
        }

        public Criteria andResEndTimeBetween(Date value1, Date value2) {
            addCriterion("res_end_time between", value1, value2, "resEndTime");
            return (Criteria) this;
        }

        public Criteria andResEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("res_end_time not between", value1, value2, "resEndTime");
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