package com.park.bean;

import java.util.ArrayList;
import java.util.List;

public class ParkingOwnerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ParkingOwnerExample() {
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

        public Criteria andOwnIdIsNull() {
            addCriterion("own_id is null");
            return (Criteria) this;
        }

        public Criteria andOwnIdIsNotNull() {
            addCriterion("own_id is not null");
            return (Criteria) this;
        }

        public Criteria andOwnIdEqualTo(Long value) {
            addCriterion("own_id =", value, "ownId");
            return (Criteria) this;
        }

        public Criteria andOwnIdNotEqualTo(Long value) {
            addCriterion("own_id <>", value, "ownId");
            return (Criteria) this;
        }

        public Criteria andOwnIdGreaterThan(Long value) {
            addCriterion("own_id >", value, "ownId");
            return (Criteria) this;
        }

        public Criteria andOwnIdGreaterThanOrEqualTo(Long value) {
            addCriterion("own_id >=", value, "ownId");
            return (Criteria) this;
        }

        public Criteria andOwnIdLessThan(Long value) {
            addCriterion("own_id <", value, "ownId");
            return (Criteria) this;
        }

        public Criteria andOwnIdLessThanOrEqualTo(Long value) {
            addCriterion("own_id <=", value, "ownId");
            return (Criteria) this;
        }

        public Criteria andOwnIdIn(List<Long> values) {
            addCriterion("own_id in", values, "ownId");
            return (Criteria) this;
        }

        public Criteria andOwnIdNotIn(List<Long> values) {
            addCriterion("own_id not in", values, "ownId");
            return (Criteria) this;
        }

        public Criteria andOwnIdBetween(Long value1, Long value2) {
            addCriterion("own_id between", value1, value2, "ownId");
            return (Criteria) this;
        }

        public Criteria andOwnIdNotBetween(Long value1, Long value2) {
            addCriterion("own_id not between", value1, value2, "ownId");
            return (Criteria) this;
        }

        public Criteria andCarIdIsNull() {
            addCriterion("car_id is null");
            return (Criteria) this;
        }

        public Criteria andCarIdIsNotNull() {
            addCriterion("car_id is not null");
            return (Criteria) this;
        }

        public Criteria andCarIdEqualTo(String value) {
            addCriterion("car_id =", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdNotEqualTo(String value) {
            addCriterion("car_id <>", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdGreaterThan(String value) {
            addCriterion("car_id >", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdGreaterThanOrEqualTo(String value) {
            addCriterion("car_id >=", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdLessThan(String value) {
            addCriterion("car_id <", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdLessThanOrEqualTo(String value) {
            addCriterion("car_id <=", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdLike(String value) {
            addCriterion("car_id like", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdNotLike(String value) {
            addCriterion("car_id not like", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdIn(List<String> values) {
            addCriterion("car_id in", values, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdNotIn(List<String> values) {
            addCriterion("car_id not in", values, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdBetween(String value1, String value2) {
            addCriterion("car_id between", value1, value2, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdNotBetween(String value1, String value2) {
            addCriterion("car_id not between", value1, value2, "carId");
            return (Criteria) this;
        }

        public Criteria andCarStaIdIsNull() {
            addCriterion("car_sta_id is null");
            return (Criteria) this;
        }

        public Criteria andCarStaIdIsNotNull() {
            addCriterion("car_sta_id is not null");
            return (Criteria) this;
        }

        public Criteria andCarStaIdEqualTo(String value) {
            addCriterion("car_sta_id =", value, "carStaId");
            return (Criteria) this;
        }

        public Criteria andCarStaIdNotEqualTo(String value) {
            addCriterion("car_sta_id <>", value, "carStaId");
            return (Criteria) this;
        }

        public Criteria andCarStaIdGreaterThan(String value) {
            addCriterion("car_sta_id >", value, "carStaId");
            return (Criteria) this;
        }

        public Criteria andCarStaIdGreaterThanOrEqualTo(String value) {
            addCriterion("car_sta_id >=", value, "carStaId");
            return (Criteria) this;
        }

        public Criteria andCarStaIdLessThan(String value) {
            addCriterion("car_sta_id <", value, "carStaId");
            return (Criteria) this;
        }

        public Criteria andCarStaIdLessThanOrEqualTo(String value) {
            addCriterion("car_sta_id <=", value, "carStaId");
            return (Criteria) this;
        }

        public Criteria andCarStaIdLike(String value) {
            addCriterion("car_sta_id like", value, "carStaId");
            return (Criteria) this;
        }

        public Criteria andCarStaIdNotLike(String value) {
            addCriterion("car_sta_id not like", value, "carStaId");
            return (Criteria) this;
        }

        public Criteria andCarStaIdIn(List<String> values) {
            addCriterion("car_sta_id in", values, "carStaId");
            return (Criteria) this;
        }

        public Criteria andCarStaIdNotIn(List<String> values) {
            addCriterion("car_sta_id not in", values, "carStaId");
            return (Criteria) this;
        }

        public Criteria andCarStaIdBetween(String value1, String value2) {
            addCriterion("car_sta_id between", value1, value2, "carStaId");
            return (Criteria) this;
        }

        public Criteria andCarStaIdNotBetween(String value1, String value2) {
            addCriterion("car_sta_id not between", value1, value2, "carStaId");
            return (Criteria) this;
        }

        public Criteria andCarNameIsNull() {
            addCriterion("car_name is null");
            return (Criteria) this;
        }

        public Criteria andCarNameIsNotNull() {
            addCriterion("car_name is not null");
            return (Criteria) this;
        }

        public Criteria andCarNameEqualTo(String value) {
            addCriterion("car_name =", value, "carName");
            return (Criteria) this;
        }

        public Criteria andCarNameNotEqualTo(String value) {
            addCriterion("car_name <>", value, "carName");
            return (Criteria) this;
        }

        public Criteria andCarNameGreaterThan(String value) {
            addCriterion("car_name >", value, "carName");
            return (Criteria) this;
        }

        public Criteria andCarNameGreaterThanOrEqualTo(String value) {
            addCriterion("car_name >=", value, "carName");
            return (Criteria) this;
        }

        public Criteria andCarNameLessThan(String value) {
            addCriterion("car_name <", value, "carName");
            return (Criteria) this;
        }

        public Criteria andCarNameLessThanOrEqualTo(String value) {
            addCriterion("car_name <=", value, "carName");
            return (Criteria) this;
        }

        public Criteria andCarNameLike(String value) {
            addCriterion("car_name like", value, "carName");
            return (Criteria) this;
        }

        public Criteria andCarNameNotLike(String value) {
            addCriterion("car_name not like", value, "carName");
            return (Criteria) this;
        }

        public Criteria andCarNameIn(List<String> values) {
            addCriterion("car_name in", values, "carName");
            return (Criteria) this;
        }

        public Criteria andCarNameNotIn(List<String> values) {
            addCriterion("car_name not in", values, "carName");
            return (Criteria) this;
        }

        public Criteria andCarNameBetween(String value1, String value2) {
            addCriterion("car_name between", value1, value2, "carName");
            return (Criteria) this;
        }

        public Criteria andCarNameNotBetween(String value1, String value2) {
            addCriterion("car_name not between", value1, value2, "carName");
            return (Criteria) this;
        }

        public Criteria andCarSiteIsNull() {
            addCriterion("car_site is null");
            return (Criteria) this;
        }

        public Criteria andCarSiteIsNotNull() {
            addCriterion("car_site is not null");
            return (Criteria) this;
        }

        public Criteria andCarSiteEqualTo(String value) {
            addCriterion("car_site =", value, "carSite");
            return (Criteria) this;
        }

        public Criteria andCarSiteNotEqualTo(String value) {
            addCriterion("car_site <>", value, "carSite");
            return (Criteria) this;
        }

        public Criteria andCarSiteGreaterThan(String value) {
            addCriterion("car_site >", value, "carSite");
            return (Criteria) this;
        }

        public Criteria andCarSiteGreaterThanOrEqualTo(String value) {
            addCriterion("car_site >=", value, "carSite");
            return (Criteria) this;
        }

        public Criteria andCarSiteLessThan(String value) {
            addCriterion("car_site <", value, "carSite");
            return (Criteria) this;
        }

        public Criteria andCarSiteLessThanOrEqualTo(String value) {
            addCriterion("car_site <=", value, "carSite");
            return (Criteria) this;
        }

        public Criteria andCarSiteLike(String value) {
            addCriterion("car_site like", value, "carSite");
            return (Criteria) this;
        }

        public Criteria andCarSiteNotLike(String value) {
            addCriterion("car_site not like", value, "carSite");
            return (Criteria) this;
        }

        public Criteria andCarSiteIn(List<String> values) {
            addCriterion("car_site in", values, "carSite");
            return (Criteria) this;
        }

        public Criteria andCarSiteNotIn(List<String> values) {
            addCriterion("car_site not in", values, "carSite");
            return (Criteria) this;
        }

        public Criteria andCarSiteBetween(String value1, String value2) {
            addCriterion("car_site between", value1, value2, "carSite");
            return (Criteria) this;
        }

        public Criteria andCarSiteNotBetween(String value1, String value2) {
            addCriterion("car_site not between", value1, value2, "carSite");
            return (Criteria) this;
        }

        public Criteria andCarAgeIsNull() {
            addCriterion("car_age is null");
            return (Criteria) this;
        }

        public Criteria andCarAgeIsNotNull() {
            addCriterion("car_age is not null");
            return (Criteria) this;
        }

        public Criteria andCarAgeEqualTo(String value) {
            addCriterion("car_age =", value, "carAge");
            return (Criteria) this;
        }

        public Criteria andCarAgeNotEqualTo(String value) {
            addCriterion("car_age <>", value, "carAge");
            return (Criteria) this;
        }

        public Criteria andCarAgeGreaterThan(String value) {
            addCriterion("car_age >", value, "carAge");
            return (Criteria) this;
        }

        public Criteria andCarAgeGreaterThanOrEqualTo(String value) {
            addCriterion("car_age >=", value, "carAge");
            return (Criteria) this;
        }

        public Criteria andCarAgeLessThan(String value) {
            addCriterion("car_age <", value, "carAge");
            return (Criteria) this;
        }

        public Criteria andCarAgeLessThanOrEqualTo(String value) {
            addCriterion("car_age <=", value, "carAge");
            return (Criteria) this;
        }

        public Criteria andCarAgeLike(String value) {
            addCriterion("car_age like", value, "carAge");
            return (Criteria) this;
        }

        public Criteria andCarAgeNotLike(String value) {
            addCriterion("car_age not like", value, "carAge");
            return (Criteria) this;
        }

        public Criteria andCarAgeIn(List<String> values) {
            addCriterion("car_age in", values, "carAge");
            return (Criteria) this;
        }

        public Criteria andCarAgeNotIn(List<String> values) {
            addCriterion("car_age not in", values, "carAge");
            return (Criteria) this;
        }

        public Criteria andCarAgeBetween(String value1, String value2) {
            addCriterion("car_age between", value1, value2, "carAge");
            return (Criteria) this;
        }

        public Criteria andCarAgeNotBetween(String value1, String value2) {
            addCriterion("car_age not between", value1, value2, "carAge");
            return (Criteria) this;
        }

        public Criteria andCarPhoneIsNull() {
            addCriterion("car_phone is null");
            return (Criteria) this;
        }

        public Criteria andCarPhoneIsNotNull() {
            addCriterion("car_phone is not null");
            return (Criteria) this;
        }

        public Criteria andCarPhoneEqualTo(String value) {
            addCriterion("car_phone =", value, "carPhone");
            return (Criteria) this;
        }

        public Criteria andCarPhoneNotEqualTo(String value) {
            addCriterion("car_phone <>", value, "carPhone");
            return (Criteria) this;
        }

        public Criteria andCarPhoneGreaterThan(String value) {
            addCriterion("car_phone >", value, "carPhone");
            return (Criteria) this;
        }

        public Criteria andCarPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("car_phone >=", value, "carPhone");
            return (Criteria) this;
        }

        public Criteria andCarPhoneLessThan(String value) {
            addCriterion("car_phone <", value, "carPhone");
            return (Criteria) this;
        }

        public Criteria andCarPhoneLessThanOrEqualTo(String value) {
            addCriterion("car_phone <=", value, "carPhone");
            return (Criteria) this;
        }

        public Criteria andCarPhoneLike(String value) {
            addCriterion("car_phone like", value, "carPhone");
            return (Criteria) this;
        }

        public Criteria andCarPhoneNotLike(String value) {
            addCriterion("car_phone not like", value, "carPhone");
            return (Criteria) this;
        }

        public Criteria andCarPhoneIn(List<String> values) {
            addCriterion("car_phone in", values, "carPhone");
            return (Criteria) this;
        }

        public Criteria andCarPhoneNotIn(List<String> values) {
            addCriterion("car_phone not in", values, "carPhone");
            return (Criteria) this;
        }

        public Criteria andCarPhoneBetween(String value1, String value2) {
            addCriterion("car_phone between", value1, value2, "carPhone");
            return (Criteria) this;
        }

        public Criteria andCarPhoneNotBetween(String value1, String value2) {
            addCriterion("car_phone not between", value1, value2, "carPhone");
            return (Criteria) this;
        }

        public Criteria andCarColorIsNull() {
            addCriterion("car_color is null");
            return (Criteria) this;
        }

        public Criteria andCarColorIsNotNull() {
            addCriterion("car_color is not null");
            return (Criteria) this;
        }

        public Criteria andCarColorEqualTo(String value) {
            addCriterion("car_color =", value, "carColor");
            return (Criteria) this;
        }

        public Criteria andCarColorNotEqualTo(String value) {
            addCriterion("car_color <>", value, "carColor");
            return (Criteria) this;
        }

        public Criteria andCarColorGreaterThan(String value) {
            addCriterion("car_color >", value, "carColor");
            return (Criteria) this;
        }

        public Criteria andCarColorGreaterThanOrEqualTo(String value) {
            addCriterion("car_color >=", value, "carColor");
            return (Criteria) this;
        }

        public Criteria andCarColorLessThan(String value) {
            addCriterion("car_color <", value, "carColor");
            return (Criteria) this;
        }

        public Criteria andCarColorLessThanOrEqualTo(String value) {
            addCriterion("car_color <=", value, "carColor");
            return (Criteria) this;
        }

        public Criteria andCarColorLike(String value) {
            addCriterion("car_color like", value, "carColor");
            return (Criteria) this;
        }

        public Criteria andCarColorNotLike(String value) {
            addCriterion("car_color not like", value, "carColor");
            return (Criteria) this;
        }

        public Criteria andCarColorIn(List<String> values) {
            addCriterion("car_color in", values, "carColor");
            return (Criteria) this;
        }

        public Criteria andCarColorNotIn(List<String> values) {
            addCriterion("car_color not in", values, "carColor");
            return (Criteria) this;
        }

        public Criteria andCarColorBetween(String value1, String value2) {
            addCriterion("car_color between", value1, value2, "carColor");
            return (Criteria) this;
        }

        public Criteria andCarColorNotBetween(String value1, String value2) {
            addCriterion("car_color not between", value1, value2, "carColor");
            return (Criteria) this;
        }

        public Criteria andCarMoneyIsNull() {
            addCriterion("car_money is null");
            return (Criteria) this;
        }

        public Criteria andCarMoneyIsNotNull() {
            addCriterion("car_money is not null");
            return (Criteria) this;
        }

        public Criteria andCarMoneyEqualTo(String value) {
            addCriterion("car_money =", value, "carMoney");
            return (Criteria) this;
        }

        public Criteria andCarMoneyNotEqualTo(String value) {
            addCriterion("car_money <>", value, "carMoney");
            return (Criteria) this;
        }

        public Criteria andCarMoneyGreaterThan(String value) {
            addCriterion("car_money >", value, "carMoney");
            return (Criteria) this;
        }

        public Criteria andCarMoneyGreaterThanOrEqualTo(String value) {
            addCriterion("car_money >=", value, "carMoney");
            return (Criteria) this;
        }

        public Criteria andCarMoneyLessThan(String value) {
            addCriterion("car_money <", value, "carMoney");
            return (Criteria) this;
        }

        public Criteria andCarMoneyLessThanOrEqualTo(String value) {
            addCriterion("car_money <=", value, "carMoney");
            return (Criteria) this;
        }

        public Criteria andCarMoneyLike(String value) {
            addCriterion("car_money like", value, "carMoney");
            return (Criteria) this;
        }

        public Criteria andCarMoneyNotLike(String value) {
            addCriterion("car_money not like", value, "carMoney");
            return (Criteria) this;
        }

        public Criteria andCarMoneyIn(List<String> values) {
            addCriterion("car_money in", values, "carMoney");
            return (Criteria) this;
        }

        public Criteria andCarMoneyNotIn(List<String> values) {
            addCriterion("car_money not in", values, "carMoney");
            return (Criteria) this;
        }

        public Criteria andCarMoneyBetween(String value1, String value2) {
            addCriterion("car_money between", value1, value2, "carMoney");
            return (Criteria) this;
        }

        public Criteria andCarMoneyNotBetween(String value1, String value2) {
            addCriterion("car_money not between", value1, value2, "carMoney");
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