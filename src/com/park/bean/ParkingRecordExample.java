package com.park.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ParkingRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ParkingRecordExample() {
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

        public Criteria andRecIdIsNull() {
            addCriterion("rec_id is null");
            return (Criteria) this;
        }

        public Criteria andRecIdIsNotNull() {
            addCriterion("rec_id is not null");
            return (Criteria) this;
        }

        public Criteria andRecIdEqualTo(Long value) {
            addCriterion("rec_id =", value, "recId");
            return (Criteria) this;
        }

        public Criteria andRecIdNotEqualTo(Long value) {
            addCriterion("rec_id <>", value, "recId");
            return (Criteria) this;
        }

        public Criteria andRecIdGreaterThan(Long value) {
            addCriterion("rec_id >", value, "recId");
            return (Criteria) this;
        }

        public Criteria andRecIdGreaterThanOrEqualTo(Long value) {
            addCriterion("rec_id >=", value, "recId");
            return (Criteria) this;
        }

        public Criteria andRecIdLessThan(Long value) {
            addCriterion("rec_id <", value, "recId");
            return (Criteria) this;
        }

        public Criteria andRecIdLessThanOrEqualTo(Long value) {
            addCriterion("rec_id <=", value, "recId");
            return (Criteria) this;
        }

        public Criteria andRecIdIn(List<Long> values) {
            addCriterion("rec_id in", values, "recId");
            return (Criteria) this;
        }

        public Criteria andRecIdNotIn(List<Long> values) {
            addCriterion("rec_id not in", values, "recId");
            return (Criteria) this;
        }

        public Criteria andRecIdBetween(Long value1, Long value2) {
            addCriterion("rec_id between", value1, value2, "recId");
            return (Criteria) this;
        }

        public Criteria andRecIdNotBetween(Long value1, Long value2) {
            addCriterion("rec_id not between", value1, value2, "recId");
            return (Criteria) this;
        }

        public Criteria andRecCarIdIsNull() {
            addCriterion("rec_car_id is null");
            return (Criteria) this;
        }

        public Criteria andRecCarIdIsNotNull() {
            addCriterion("rec_car_id is not null");
            return (Criteria) this;
        }

        public Criteria andRecCarIdEqualTo(String value) {
            addCriterion("rec_car_id =", value, "recCarId");
            return (Criteria) this;
        }

        public Criteria andRecCarIdNotEqualTo(String value) {
            addCriterion("rec_car_id <>", value, "recCarId");
            return (Criteria) this;
        }

        public Criteria andRecCarIdGreaterThan(String value) {
            addCriterion("rec_car_id >", value, "recCarId");
            return (Criteria) this;
        }

        public Criteria andRecCarIdGreaterThanOrEqualTo(String value) {
            addCriterion("rec_car_id >=", value, "recCarId");
            return (Criteria) this;
        }

        public Criteria andRecCarIdLessThan(String value) {
            addCriterion("rec_car_id <", value, "recCarId");
            return (Criteria) this;
        }

        public Criteria andRecCarIdLessThanOrEqualTo(String value) {
            addCriterion("rec_car_id <=", value, "recCarId");
            return (Criteria) this;
        }

        public Criteria andRecCarIdLike(String value) {
            addCriterion("rec_car_id like", value, "recCarId");
            return (Criteria) this;
        }

        public Criteria andRecCarIdNotLike(String value) {
            addCriterion("rec_car_id not like", value, "recCarId");
            return (Criteria) this;
        }

        public Criteria andRecCarIdIn(List<String> values) {
            addCriterion("rec_car_id in", values, "recCarId");
            return (Criteria) this;
        }

        public Criteria andRecCarIdNotIn(List<String> values) {
            addCriterion("rec_car_id not in", values, "recCarId");
            return (Criteria) this;
        }

        public Criteria andRecCarIdBetween(String value1, String value2) {
            addCriterion("rec_car_id between", value1, value2, "recCarId");
            return (Criteria) this;
        }

        public Criteria andRecCarIdNotBetween(String value1, String value2) {
            addCriterion("rec_car_id not between", value1, value2, "recCarId");
            return (Criteria) this;
        }

        public Criteria andRecEntryDateIsNull() {
            addCriterion("rec_entry_date is null");
            return (Criteria) this;
        }

        public Criteria andRecEntryDateIsNotNull() {
            addCriterion("rec_entry_date is not null");
            return (Criteria) this;
        }

        public Criteria andRecEntryDateEqualTo(Date value) {
            addCriterion("rec_entry_date =", value, "recEntryDate");
            return (Criteria) this;
        }

        public Criteria andRecEntryDateNotEqualTo(Date value) {
            addCriterion("rec_entry_date <>", value, "recEntryDate");
            return (Criteria) this;
        }

        public Criteria andRecEntryDateGreaterThan(Date value) {
            addCriterion("rec_entry_date >", value, "recEntryDate");
            return (Criteria) this;
        }

        public Criteria andRecEntryDateGreaterThanOrEqualTo(Date value) {
            addCriterion("rec_entry_date >=", value, "recEntryDate");
            return (Criteria) this;
        }

        public Criteria andRecEntryDateLessThan(Date value) {
            addCriterion("rec_entry_date <", value, "recEntryDate");
            return (Criteria) this;
        }

        public Criteria andRecEntryDateLessThanOrEqualTo(Date value) {
            addCriterion("rec_entry_date <=", value, "recEntryDate");
            return (Criteria) this;
        }

        public Criteria andRecEntryDateIn(List<Date> values) {
            addCriterion("rec_entry_date in", values, "recEntryDate");
            return (Criteria) this;
        }

        public Criteria andRecEntryDateNotIn(List<Date> values) {
            addCriterion("rec_entry_date not in", values, "recEntryDate");
            return (Criteria) this;
        }

        public Criteria andRecEntryDateBetween(Date value1, Date value2) {
            addCriterion("rec_entry_date between", value1, value2, "recEntryDate");
            return (Criteria) this;
        }

        public Criteria andRecEntryDateNotBetween(Date value1, Date value2) {
            addCriterion("rec_entry_date not between", value1, value2, "recEntryDate");
            return (Criteria) this;
        }

        public Criteria andRecLeaveDateIsNull() {
            addCriterion("rec_leave_date is null");
            return (Criteria) this;
        }

        public Criteria andRecLeaveDateIsNotNull() {
            addCriterion("rec_leave_date is not null");
            return (Criteria) this;
        }

        public Criteria andRecLeaveDateEqualTo(Date value) {
            addCriterion("rec_leave_date =", value, "recLeaveDate");
            return (Criteria) this;
        }

        public Criteria andRecLeaveDateNotEqualTo(Date value) {
            addCriterion("rec_leave_date <>", value, "recLeaveDate");
            return (Criteria) this;
        }

        public Criteria andRecLeaveDateGreaterThan(Date value) {
            addCriterion("rec_leave_date >", value, "recLeaveDate");
            return (Criteria) this;
        }

        public Criteria andRecLeaveDateGreaterThanOrEqualTo(Date value) {
            addCriterion("rec_leave_date >=", value, "recLeaveDate");
            return (Criteria) this;
        }

        public Criteria andRecLeaveDateLessThan(Date value) {
            addCriterion("rec_leave_date <", value, "recLeaveDate");
            return (Criteria) this;
        }

        public Criteria andRecLeaveDateLessThanOrEqualTo(Date value) {
            addCriterion("rec_leave_date <=", value, "recLeaveDate");
            return (Criteria) this;
        }

        public Criteria andRecLeaveDateIn(List<Date> values) {
            addCriterion("rec_leave_date in", values, "recLeaveDate");
            return (Criteria) this;
        }

        public Criteria andRecLeaveDateNotIn(List<Date> values) {
            addCriterion("rec_leave_date not in", values, "recLeaveDate");
            return (Criteria) this;
        }

        public Criteria andRecLeaveDateBetween(Date value1, Date value2) {
            addCriterion("rec_leave_date between", value1, value2, "recLeaveDate");
            return (Criteria) this;
        }

        public Criteria andRecLeaveDateNotBetween(Date value1, Date value2) {
            addCriterion("rec_leave_date not between", value1, value2, "recLeaveDate");
            return (Criteria) this;
        }

        public Criteria andRecTimeIsNull() {
            addCriterion("rec_time is null");
            return (Criteria) this;
        }

        public Criteria andRecTimeIsNotNull() {
            addCriterion("rec_time is not null");
            return (Criteria) this;
        }

        public Criteria andRecTimeEqualTo(Long value) {
            addCriterion("rec_time =", value, "recTime");
            return (Criteria) this;
        }

        public Criteria andRecTimeNotEqualTo(Long value) {
            addCriterion("rec_time <>", value, "recTime");
            return (Criteria) this;
        }

        public Criteria andRecTimeGreaterThan(Long value) {
            addCriterion("rec_time >", value, "recTime");
            return (Criteria) this;
        }

        public Criteria andRecTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("rec_time >=", value, "recTime");
            return (Criteria) this;
        }

        public Criteria andRecTimeLessThan(Long value) {
            addCriterion("rec_time <", value, "recTime");
            return (Criteria) this;
        }

        public Criteria andRecTimeLessThanOrEqualTo(Long value) {
            addCriterion("rec_time <=", value, "recTime");
            return (Criteria) this;
        }

        public Criteria andRecTimeIn(List<Long> values) {
            addCriterion("rec_time in", values, "recTime");
            return (Criteria) this;
        }

        public Criteria andRecTimeNotIn(List<Long> values) {
            addCriterion("rec_time not in", values, "recTime");
            return (Criteria) this;
        }

        public Criteria andRecTimeBetween(Long value1, Long value2) {
            addCriterion("rec_time between", value1, value2, "recTime");
            return (Criteria) this;
        }

        public Criteria andRecTimeNotBetween(Long value1, Long value2) {
            addCriterion("rec_time not between", value1, value2, "recTime");
            return (Criteria) this;
        }

        public Criteria andRecChargeIsNull() {
            addCriterion("rec_charge is null");
            return (Criteria) this;
        }

        public Criteria andRecChargeIsNotNull() {
            addCriterion("rec_charge is not null");
            return (Criteria) this;
        }

        public Criteria andRecChargeEqualTo(String value) {
            addCriterion("rec_charge =", value, "recCharge");
            return (Criteria) this;
        }

        public Criteria andRecChargeNotEqualTo(String value) {
            addCriterion("rec_charge <>", value, "recCharge");
            return (Criteria) this;
        }

        public Criteria andRecChargeGreaterThan(String value) {
            addCriterion("rec_charge >", value, "recCharge");
            return (Criteria) this;
        }

        public Criteria andRecChargeGreaterThanOrEqualTo(String value) {
            addCriterion("rec_charge >=", value, "recCharge");
            return (Criteria) this;
        }

        public Criteria andRecChargeLessThan(String value) {
            addCriterion("rec_charge <", value, "recCharge");
            return (Criteria) this;
        }

        public Criteria andRecChargeLessThanOrEqualTo(String value) {
            addCriterion("rec_charge <=", value, "recCharge");
            return (Criteria) this;
        }

        public Criteria andRecChargeLike(String value) {
            addCriterion("rec_charge like", value, "recCharge");
            return (Criteria) this;
        }

        public Criteria andRecChargeNotLike(String value) {
            addCriterion("rec_charge not like", value, "recCharge");
            return (Criteria) this;
        }

        public Criteria andRecChargeIn(List<String> values) {
            addCriterion("rec_charge in", values, "recCharge");
            return (Criteria) this;
        }

        public Criteria andRecChargeNotIn(List<String> values) {
            addCriterion("rec_charge not in", values, "recCharge");
            return (Criteria) this;
        }

        public Criteria andRecChargeBetween(String value1, String value2) {
            addCriterion("rec_charge between", value1, value2, "recCharge");
            return (Criteria) this;
        }

        public Criteria andRecChargeNotBetween(String value1, String value2) {
            addCriterion("rec_charge not between", value1, value2, "recCharge");
            return (Criteria) this;
        }

        public Criteria andRecCostIsNull() {
            addCriterion("rec_cost is null");
            return (Criteria) this;
        }

        public Criteria andRecCostIsNotNull() {
            addCriterion("rec_cost is not null");
            return (Criteria) this;
        }

        public Criteria andRecCostEqualTo(String value) {
            addCriterion("rec_cost =", value, "recCost");
            return (Criteria) this;
        }

        public Criteria andRecCostNotEqualTo(String value) {
            addCriterion("rec_cost <>", value, "recCost");
            return (Criteria) this;
        }

        public Criteria andRecCostGreaterThan(String value) {
            addCriterion("rec_cost >", value, "recCost");
            return (Criteria) this;
        }

        public Criteria andRecCostGreaterThanOrEqualTo(String value) {
            addCriterion("rec_cost >=", value, "recCost");
            return (Criteria) this;
        }

        public Criteria andRecCostLessThan(String value) {
            addCriterion("rec_cost <", value, "recCost");
            return (Criteria) this;
        }

        public Criteria andRecCostLessThanOrEqualTo(String value) {
            addCriterion("rec_cost <=", value, "recCost");
            return (Criteria) this;
        }

        public Criteria andRecCostLike(String value) {
            addCriterion("rec_cost like", value, "recCost");
            return (Criteria) this;
        }

        public Criteria andRecCostNotLike(String value) {
            addCriterion("rec_cost not like", value, "recCost");
            return (Criteria) this;
        }

        public Criteria andRecCostIn(List<String> values) {
            addCriterion("rec_cost in", values, "recCost");
            return (Criteria) this;
        }

        public Criteria andRecCostNotIn(List<String> values) {
            addCriterion("rec_cost not in", values, "recCost");
            return (Criteria) this;
        }

        public Criteria andRecCostBetween(String value1, String value2) {
            addCriterion("rec_cost between", value1, value2, "recCost");
            return (Criteria) this;
        }

        public Criteria andRecCostNotBetween(String value1, String value2) {
            addCriterion("rec_cost not between", value1, value2, "recCost");
            return (Criteria) this;
        }

        public Criteria andRecOwnIdIsNull() {
            addCriterion("rec_own_id is null");
            return (Criteria) this;
        }

        public Criteria andRecOwnIdIsNotNull() {
            addCriterion("rec_own_id is not null");
            return (Criteria) this;
        }

        public Criteria andRecOwnIdEqualTo(Long value) {
            addCriterion("rec_own_id =", value, "recOwnId");
            return (Criteria) this;
        }

        public Criteria andRecOwnIdNotEqualTo(Long value) {
            addCriterion("rec_own_id <>", value, "recOwnId");
            return (Criteria) this;
        }

        public Criteria andRecOwnIdGreaterThan(Long value) {
            addCriterion("rec_own_id >", value, "recOwnId");
            return (Criteria) this;
        }

        public Criteria andRecOwnIdGreaterThanOrEqualTo(Long value) {
            addCriterion("rec_own_id >=", value, "recOwnId");
            return (Criteria) this;
        }

        public Criteria andRecOwnIdLessThan(Long value) {
            addCriterion("rec_own_id <", value, "recOwnId");
            return (Criteria) this;
        }

        public Criteria andRecOwnIdLessThanOrEqualTo(Long value) {
            addCriterion("rec_own_id <=", value, "recOwnId");
            return (Criteria) this;
        }

        public Criteria andRecOwnIdIn(List<Long> values) {
            addCriterion("rec_own_id in", values, "recOwnId");
            return (Criteria) this;
        }

        public Criteria andRecOwnIdNotIn(List<Long> values) {
            addCriterion("rec_own_id not in", values, "recOwnId");
            return (Criteria) this;
        }

        public Criteria andRecOwnIdBetween(Long value1, Long value2) {
            addCriterion("rec_own_id between", value1, value2, "recOwnId");
            return (Criteria) this;
        }

        public Criteria andRecOwnIdNotBetween(Long value1, Long value2) {
            addCriterion("rec_own_id not between", value1, value2, "recOwnId");
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