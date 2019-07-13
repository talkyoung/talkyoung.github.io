package cn.sjxy.overdue.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LogdetailExample{
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LogdetailExample() {
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

        public Criteria andLogIdIsNull() {
            addCriterion("log_id is null");
            return (Criteria) this;
        }

        public Criteria andLogIdIsNotNull() {
            addCriterion("log_id is not null");
            return (Criteria) this;
        }

        public Criteria andLogIdEqualTo(Integer value) {
            addCriterion("log_id =", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdNotEqualTo(Integer value) {
            addCriterion("log_id <>", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdGreaterThan(Integer value) {
            addCriterion("log_id >", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("log_id >=", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdLessThan(Integer value) {
            addCriterion("log_id <", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdLessThanOrEqualTo(Integer value) {
            addCriterion("log_id <=", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdIn(List<Integer> values) {
            addCriterion("log_id in", values, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdNotIn(List<Integer> values) {
            addCriterion("log_id not in", values, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdBetween(Integer value1, Integer value2) {
            addCriterion("log_id between", value1, value2, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdNotBetween(Integer value1, Integer value2) {
            addCriterion("log_id not between", value1, value2, "logId");
            return (Criteria) this;
        }

        public Criteria andLogModuleIsNull() {
            addCriterion("log_module is null");
            return (Criteria) this;
        }

        public Criteria andLogModuleIsNotNull() {
            addCriterion("log_module is not null");
            return (Criteria) this;
        }

        public Criteria andLogModuleEqualTo(String value) {
            addCriterion("log_module =", value, "logModule");
            return (Criteria) this;
        }

        public Criteria andLogModuleNotEqualTo(String value) {
            addCriterion("log_module <>", value, "logModule");
            return (Criteria) this;
        }

        public Criteria andLogModuleGreaterThan(String value) {
            addCriterion("log_module >", value, "logModule");
            return (Criteria) this;
        }

        public Criteria andLogModuleGreaterThanOrEqualTo(String value) {
            addCriterion("log_module >=", value, "logModule");
            return (Criteria) this;
        }

        public Criteria andLogModuleLessThan(String value) {
            addCriterion("log_module <", value, "logModule");
            return (Criteria) this;
        }

        public Criteria andLogModuleLessThanOrEqualTo(String value) {
            addCriterion("log_module <=", value, "logModule");
            return (Criteria) this;
        }

        public Criteria andLogModuleLike(String value) {
            addCriterion("log_module like", value, "logModule");
            return (Criteria) this;
        }

        public Criteria andLogModuleNotLike(String value) {
            addCriterion("log_module not like", value, "logModule");
            return (Criteria) this;
        }

        public Criteria andLogModuleIn(List<String> values) {
            addCriterion("log_module in", values, "logModule");
            return (Criteria) this;
        }

        public Criteria andLogModuleNotIn(List<String> values) {
            addCriterion("log_module not in", values, "logModule");
            return (Criteria) this;
        }

        public Criteria andLogModuleBetween(String value1, String value2) {
            addCriterion("log_module between", value1, value2, "logModule");
            return (Criteria) this;
        }

        public Criteria andLogModuleNotBetween(String value1, String value2) {
            addCriterion("log_module not between", value1, value2, "logModule");
            return (Criteria) this;
        }

        public Criteria andLogActionIsNull() {
            addCriterion("log_action is null");
            return (Criteria) this;
        }

        public Criteria andLogActionIsNotNull() {
            addCriterion("log_action is not null");
            return (Criteria) this;
        }

        public Criteria andLogActionEqualTo(String value) {
            addCriterion("log_action =", value, "logAction");
            return (Criteria) this;
        }

        public Criteria andLogActionNotEqualTo(String value) {
            addCriterion("log_action <>", value, "logAction");
            return (Criteria) this;
        }

        public Criteria andLogActionGreaterThan(String value) {
            addCriterion("log_action >", value, "logAction");
            return (Criteria) this;
        }

        public Criteria andLogActionGreaterThanOrEqualTo(String value) {
            addCriterion("log_action >=", value, "logAction");
            return (Criteria) this;
        }

        public Criteria andLogActionLessThan(String value) {
            addCriterion("log_action <", value, "logAction");
            return (Criteria) this;
        }

        public Criteria andLogActionLessThanOrEqualTo(String value) {
            addCriterion("log_action <=", value, "logAction");
            return (Criteria) this;
        }

        public Criteria andLogActionLike(String value) {
            addCriterion("log_action like", value, "logAction");
            return (Criteria) this;
        }

        public Criteria andLogActionNotLike(String value) {
            addCriterion("log_action not like", value, "logAction");
            return (Criteria) this;
        }

        public Criteria andLogActionIn(List<String> values) {
            addCriterion("log_action in", values, "logAction");
            return (Criteria) this;
        }

        public Criteria andLogActionNotIn(List<String> values) {
            addCriterion("log_action not in", values, "logAction");
            return (Criteria) this;
        }

        public Criteria andLogActionBetween(String value1, String value2) {
            addCriterion("log_action between", value1, value2, "logAction");
            return (Criteria) this;
        }

        public Criteria andLogActionNotBetween(String value1, String value2) {
            addCriterion("log_action not between", value1, value2, "logAction");
            return (Criteria) this;
        }

        public Criteria andLogTimeIsNull() {
            addCriterion("log_time is null");
            return (Criteria) this;
        }

        public Criteria andLogTimeIsNotNull() {
            addCriterion("log_time is not null");
            return (Criteria) this;
        }

        public Criteria andLogTimeEqualTo(Date value) {
            addCriterion("log_time =", value, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeNotEqualTo(Date value) {
            addCriterion("log_time <>", value, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeGreaterThan(Date value) {
            addCriterion("log_time >", value, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("log_time >=", value, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeLessThan(Date value) {
            addCriterion("log_time <", value, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeLessThanOrEqualTo(Date value) {
            addCriterion("log_time <=", value, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeIn(List<Date> values) {
            addCriterion("log_time in", values, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeNotIn(List<Date> values) {
            addCriterion("log_time not in", values, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeBetween(Date value1, Date value2) {
            addCriterion("log_time between", value1, value2, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeNotBetween(Date value1, Date value2) {
            addCriterion("log_time not between", value1, value2, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogRoleIsNull() {
            addCriterion("log_role is null");
            return (Criteria) this;
        }

        public Criteria andLogRoleIsNotNull() {
            addCriterion("log_role is not null");
            return (Criteria) this;
        }

        public Criteria andLogRoleEqualTo(String value) {
            addCriterion("log_role =", value, "logRole");
            return (Criteria) this;
        }

        public Criteria andLogRoleNotEqualTo(String value) {
            addCriterion("log_role <>", value, "logRole");
            return (Criteria) this;
        }

        public Criteria andLogRoleGreaterThan(String value) {
            addCriterion("log_role >", value, "logRole");
            return (Criteria) this;
        }

        public Criteria andLogRoleGreaterThanOrEqualTo(String value) {
            addCriterion("log_role >=", value, "logRole");
            return (Criteria) this;
        }

        public Criteria andLogRoleLessThan(String value) {
            addCriterion("log_role <", value, "logRole");
            return (Criteria) this;
        }

        public Criteria andLogRoleLessThanOrEqualTo(String value) {
            addCriterion("log_role <=", value, "logRole");
            return (Criteria) this;
        }

        public Criteria andLogRoleLike(String value) {
            addCriterion("log_role like", value, "logRole");
            return (Criteria) this;
        }

        public Criteria andLogRoleNotLike(String value) {
            addCriterion("log_role not like", value, "logRole");
            return (Criteria) this;
        }

        public Criteria andLogRoleIn(List<String> values) {
            addCriterion("log_role in", values, "logRole");
            return (Criteria) this;
        }

        public Criteria andLogRoleNotIn(List<String> values) {
            addCriterion("log_role not in", values, "logRole");
            return (Criteria) this;
        }

        public Criteria andLogRoleBetween(String value1, String value2) {
            addCriterion("log_role between", value1, value2, "logRole");
            return (Criteria) this;
        }

        public Criteria andLogRoleNotBetween(String value1, String value2) {
            addCriterion("log_role not between", value1, value2, "logRole");
            return (Criteria) this;
        }

        public Criteria andLogNameIsNull() {
            addCriterion("log_name is null");
            return (Criteria) this;
        }

        public Criteria andLogNameIsNotNull() {
            addCriterion("log_name is not null");
            return (Criteria) this;
        }

        public Criteria andLogNameEqualTo(String value) {
            addCriterion("log_name =", value, "logName");
            return (Criteria) this;
        }

        public Criteria andLogNameNotEqualTo(String value) {
            addCriterion("log_name <>", value, "logName");
            return (Criteria) this;
        }

        public Criteria andLogNameGreaterThan(String value) {
            addCriterion("log_name >", value, "logName");
            return (Criteria) this;
        }

        public Criteria andLogNameGreaterThanOrEqualTo(String value) {
            addCriterion("log_name >=", value, "logName");
            return (Criteria) this;
        }

        public Criteria andLogNameLessThan(String value) {
            addCriterion("log_name <", value, "logName");
            return (Criteria) this;
        }

        public Criteria andLogNameLessThanOrEqualTo(String value) {
            addCriterion("log_name <=", value, "logName");
            return (Criteria) this;
        }

        public Criteria andLogNameLike(String value) {
            addCriterion("log_name like", value, "logName");
            return (Criteria) this;
        }

        public Criteria andLogNameNotLike(String value) {
            addCriterion("log_name not like", value, "logName");
            return (Criteria) this;
        }

        public Criteria andLogNameIn(List<String> values) {
            addCriterion("log_name in", values, "logName");
            return (Criteria) this;
        }

        public Criteria andLogNameNotIn(List<String> values) {
            addCriterion("log_name not in", values, "logName");
            return (Criteria) this;
        }

        public Criteria andLogNameBetween(String value1, String value2) {
            addCriterion("log_name between", value1, value2, "logName");
            return (Criteria) this;
        }

        public Criteria andLogNameNotBetween(String value1, String value2) {
            addCriterion("log_name not between", value1, value2, "logName");
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