package com.park.bean;

import java.util.ArrayList;
import java.util.List;

public class ParkingStallExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ParkingStallExample() {
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

        public Criteria andStaIdIsNull() {
            addCriterion("sta_id is null");
            return (Criteria) this;
        }

        public Criteria andStaIdIsNotNull() {
            addCriterion("sta_id is not null");
            return (Criteria) this;
        }

        public Criteria andStaIdEqualTo(String value) {
            addCriterion("sta_id =", value, "staId");
            return (Criteria) this;
        }

        public Criteria andStaIdNotEqualTo(String value) {
            addCriterion("sta_id <>", value, "staId");
            return (Criteria) this;
        }

        public Criteria andStaIdGreaterThan(String value) {
            addCriterion("sta_id >", value, "staId");
            return (Criteria) this;
        }

        public Criteria andStaIdGreaterThanOrEqualTo(String value) {
            addCriterion("sta_id >=", value, "staId");
            return (Criteria) this;
        }

        public Criteria andStaIdLessThan(String value) {
            addCriterion("sta_id <", value, "staId");
            return (Criteria) this;
        }

        public Criteria andStaIdLessThanOrEqualTo(String value) {
            addCriterion("sta_id <=", value, "staId");
            return (Criteria) this;
        }

        public Criteria andStaIdLike(String value) {
            addCriterion("sta_id like", value, "staId");
            return (Criteria) this;
        }

        public Criteria andStaIdNotLike(String value) {
            addCriterion("sta_id not like", value, "staId");
            return (Criteria) this;
        }

        public Criteria andStaIdIn(List<String> values) {
            addCriterion("sta_id in", values, "staId");
            return (Criteria) this;
        }

        public Criteria andStaIdNotIn(List<String> values) {
            addCriterion("sta_id not in", values, "staId");
            return (Criteria) this;
        }

        public Criteria andStaIdBetween(String value1, String value2) {
            addCriterion("sta_id between", value1, value2, "staId");
            return (Criteria) this;
        }

        public Criteria andStaIdNotBetween(String value1, String value2) {
            addCriterion("sta_id not between", value1, value2, "staId");
            return (Criteria) this;
        }

        public Criteria andStaPlaceIsNull() {
            addCriterion("sta_place is null");
            return (Criteria) this;
        }

        public Criteria andStaPlaceIsNotNull() {
            addCriterion("sta_place is not null");
            return (Criteria) this;
        }

        public Criteria andStaPlaceEqualTo(Long value) {
            addCriterion("sta_place =", value, "staPlace");
            return (Criteria) this;
        }

        public Criteria andStaPlaceNotEqualTo(Long value) {
            addCriterion("sta_place <>", value, "staPlace");
            return (Criteria) this;
        }

        public Criteria andStaPlaceGreaterThan(Long value) {
            addCriterion("sta_place >", value, "staPlace");
            return (Criteria) this;
        }

        public Criteria andStaPlaceGreaterThanOrEqualTo(Long value) {
            addCriterion("sta_place >=", value, "staPlace");
            return (Criteria) this;
        }

        public Criteria andStaPlaceLessThan(Long value) {
            addCriterion("sta_place <", value, "staPlace");
            return (Criteria) this;
        }

        public Criteria andStaPlaceLessThanOrEqualTo(Long value) {
            addCriterion("sta_place <=", value, "staPlace");
            return (Criteria) this;
        }

        public Criteria andStaPlaceIn(List<Long> values) {
            addCriterion("sta_place in", values, "staPlace");
            return (Criteria) this;
        }

        public Criteria andStaPlaceNotIn(List<Long> values) {
            addCriterion("sta_place not in", values, "staPlace");
            return (Criteria) this;
        }

        public Criteria andStaPlaceBetween(Long value1, Long value2) {
            addCriterion("sta_place between", value1, value2, "staPlace");
            return (Criteria) this;
        }

        public Criteria andStaPlaceNotBetween(Long value1, Long value2) {
            addCriterion("sta_place not between", value1, value2, "staPlace");
            return (Criteria) this;
        }

        public Criteria andStaFixationIsNull() {
            addCriterion("sta_fixation is null");
            return (Criteria) this;
        }

        public Criteria andStaFixationIsNotNull() {
            addCriterion("sta_fixation is not null");
            return (Criteria) this;
        }

        public Criteria andStaFixationEqualTo(Long value) {
            addCriterion("sta_fixation =", value, "staFixation");
            return (Criteria) this;
        }

        public Criteria andStaFixationNotEqualTo(Long value) {
            addCriterion("sta_fixation <>", value, "staFixation");
            return (Criteria) this;
        }

        public Criteria andStaFixationGreaterThan(Long value) {
            addCriterion("sta_fixation >", value, "staFixation");
            return (Criteria) this;
        }

        public Criteria andStaFixationGreaterThanOrEqualTo(Long value) {
            addCriterion("sta_fixation >=", value, "staFixation");
            return (Criteria) this;
        }

        public Criteria andStaFixationLessThan(Long value) {
            addCriterion("sta_fixation <", value, "staFixation");
            return (Criteria) this;
        }

        public Criteria andStaFixationLessThanOrEqualTo(Long value) {
            addCriterion("sta_fixation <=", value, "staFixation");
            return (Criteria) this;
        }

        public Criteria andStaFixationIn(List<Long> values) {
            addCriterion("sta_fixation in", values, "staFixation");
            return (Criteria) this;
        }

        public Criteria andStaFixationNotIn(List<Long> values) {
            addCriterion("sta_fixation not in", values, "staFixation");
            return (Criteria) this;
        }

        public Criteria andStaFixationBetween(Long value1, Long value2) {
            addCriterion("sta_fixation between", value1, value2, "staFixation");
            return (Criteria) this;
        }

        public Criteria andStaFixationNotBetween(Long value1, Long value2) {
            addCriterion("sta_fixation not between", value1, value2, "staFixation");
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