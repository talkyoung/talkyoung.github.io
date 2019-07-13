package cn.sjxy.overdue.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VideoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public VideoExample() {
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

        public Criteria andVIdIsNull() {
            addCriterion("v_id is null");
            return (Criteria) this;
        }

        public Criteria andVIdIsNotNull() {
            addCriterion("v_id is not null");
            return (Criteria) this;
        }

        public Criteria andVIdEqualTo(Integer value) {
            addCriterion("v_id =", value, "vId");
            return (Criteria) this;
        }

        public Criteria andVIdNotEqualTo(Integer value) {
            addCriterion("v_id <>", value, "vId");
            return (Criteria) this;
        }

        public Criteria andVIdGreaterThan(Integer value) {
            addCriterion("v_id >", value, "vId");
            return (Criteria) this;
        }

        public Criteria andVIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("v_id >=", value, "vId");
            return (Criteria) this;
        }

        public Criteria andVIdLessThan(Integer value) {
            addCriterion("v_id <", value, "vId");
            return (Criteria) this;
        }

        public Criteria andVIdLessThanOrEqualTo(Integer value) {
            addCriterion("v_id <=", value, "vId");
            return (Criteria) this;
        }

        public Criteria andVIdIn(List<Integer> values) {
            addCriterion("v_id in", values, "vId");
            return (Criteria) this;
        }

        public Criteria andVIdNotIn(List<Integer> values) {
            addCriterion("v_id not in", values, "vId");
            return (Criteria) this;
        }

        public Criteria andVIdBetween(Integer value1, Integer value2) {
            addCriterion("v_id between", value1, value2, "vId");
            return (Criteria) this;
        }

        public Criteria andVIdNotBetween(Integer value1, Integer value2) {
            addCriterion("v_id not between", value1, value2, "vId");
            return (Criteria) this;
        }

        public Criteria andVNameIsNull() {
            addCriterion("v_name is null");
            return (Criteria) this;
        }

        public Criteria andVNameIsNotNull() {
            addCriterion("v_name is not null");
            return (Criteria) this;
        }

        public Criteria andVNameEqualTo(String value) {
            addCriterion("v_name =", value, "vName");
            return (Criteria) this;
        }

        public Criteria andVNameNotEqualTo(String value) {
            addCriterion("v_name <>", value, "vName");
            return (Criteria) this;
        }

        public Criteria andVNameGreaterThan(String value) {
            addCriterion("v_name >", value, "vName");
            return (Criteria) this;
        }

        public Criteria andVNameGreaterThanOrEqualTo(String value) {
            addCriterion("v_name >=", value, "vName");
            return (Criteria) this;
        }

        public Criteria andVNameLessThan(String value) {
            addCriterion("v_name <", value, "vName");
            return (Criteria) this;
        }

        public Criteria andVNameLessThanOrEqualTo(String value) {
            addCriterion("v_name <=", value, "vName");
            return (Criteria) this;
        }

        public Criteria andVNameLike(String value) {
            addCriterion("v_name like", value, "vName");
            return (Criteria) this;
        }

        public Criteria andVNameNotLike(String value) {
            addCriterion("v_name not like", value, "vName");
            return (Criteria) this;
        }

        public Criteria andVNameIn(List<String> values) {
            addCriterion("v_name in", values, "vName");
            return (Criteria) this;
        }

        public Criteria andVNameNotIn(List<String> values) {
            addCriterion("v_name not in", values, "vName");
            return (Criteria) this;
        }

        public Criteria andVNameBetween(String value1, String value2) {
            addCriterion("v_name between", value1, value2, "vName");
            return (Criteria) this;
        }

        public Criteria andVNameNotBetween(String value1, String value2) {
            addCriterion("v_name not between", value1, value2, "vName");
            return (Criteria) this;
        }

        public Criteria andTIdIsNull() {
            addCriterion("t_id is null");
            return (Criteria) this;
        }

        public Criteria andTIdIsNotNull() {
            addCriterion("t_id is not null");
            return (Criteria) this;
        }

        public Criteria andTIdEqualTo(Integer value) {
            addCriterion("t_id =", value, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdNotEqualTo(Integer value) {
            addCriterion("t_id <>", value, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdGreaterThan(Integer value) {
            addCriterion("t_id >", value, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("t_id >=", value, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdLessThan(Integer value) {
            addCriterion("t_id <", value, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdLessThanOrEqualTo(Integer value) {
            addCriterion("t_id <=", value, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdIn(List<Integer> values) {
            addCriterion("t_id in", values, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdNotIn(List<Integer> values) {
            addCriterion("t_id not in", values, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdBetween(Integer value1, Integer value2) {
            addCriterion("t_id between", value1, value2, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdNotBetween(Integer value1, Integer value2) {
            addCriterion("t_id not between", value1, value2, "tId");
            return (Criteria) this;
        }

        public Criteria andVDetailIsNull() {
            addCriterion("v_detail is null");
            return (Criteria) this;
        }

        public Criteria andVDetailIsNotNull() {
            addCriterion("v_detail is not null");
            return (Criteria) this;
        }

        public Criteria andVDetailEqualTo(String value) {
            addCriterion("v_detail =", value, "vDetail");
            return (Criteria) this;
        }

        public Criteria andVDetailNotEqualTo(String value) {
            addCriterion("v_detail <>", value, "vDetail");
            return (Criteria) this;
        }

        public Criteria andVDetailGreaterThan(String value) {
            addCriterion("v_detail >", value, "vDetail");
            return (Criteria) this;
        }

        public Criteria andVDetailGreaterThanOrEqualTo(String value) {
            addCriterion("v_detail >=", value, "vDetail");
            return (Criteria) this;
        }

        public Criteria andVDetailLessThan(String value) {
            addCriterion("v_detail <", value, "vDetail");
            return (Criteria) this;
        }

        public Criteria andVDetailLessThanOrEqualTo(String value) {
            addCriterion("v_detail <=", value, "vDetail");
            return (Criteria) this;
        }

        public Criteria andVDetailLike(String value) {
            addCriterion("v_detail like", value, "vDetail");
            return (Criteria) this;
        }

        public Criteria andVDetailNotLike(String value) {
            addCriterion("v_detail not like", value, "vDetail");
            return (Criteria) this;
        }

        public Criteria andVDetailIn(List<String> values) {
            addCriterion("v_detail in", values, "vDetail");
            return (Criteria) this;
        }

        public Criteria andVDetailNotIn(List<String> values) {
            addCriterion("v_detail not in", values, "vDetail");
            return (Criteria) this;
        }

        public Criteria andVDetailBetween(String value1, String value2) {
            addCriterion("v_detail between", value1, value2, "vDetail");
            return (Criteria) this;
        }

        public Criteria andVDetailNotBetween(String value1, String value2) {
            addCriterion("v_detail not between", value1, value2, "vDetail");
            return (Criteria) this;
        }

        public Criteria andCIdIsNull() {
            addCriterion("c_id is null");
            return (Criteria) this;
        }

        public Criteria andCIdIsNotNull() {
            addCriterion("c_id is not null");
            return (Criteria) this;
        }

        public Criteria andCIdEqualTo(Integer value) {
            addCriterion("c_id =", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdNotEqualTo(Integer value) {
            addCriterion("c_id <>", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdGreaterThan(Integer value) {
            addCriterion("c_id >", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("c_id >=", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdLessThan(Integer value) {
            addCriterion("c_id <", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdLessThanOrEqualTo(Integer value) {
            addCriterion("c_id <=", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdIn(List<Integer> values) {
            addCriterion("c_id in", values, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdNotIn(List<Integer> values) {
            addCriterion("c_id not in", values, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdBetween(Integer value1, Integer value2) {
            addCriterion("c_id between", value1, value2, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdNotBetween(Integer value1, Integer value2) {
            addCriterion("c_id not between", value1, value2, "cId");
            return (Criteria) this;
        }

        public Criteria andVUptimeIsNull() {
            addCriterion("v_uptime is null");
            return (Criteria) this;
        }

        public Criteria andVUptimeIsNotNull() {
            addCriterion("v_uptime is not null");
            return (Criteria) this;
        }

        public Criteria andVUptimeEqualTo(Date value) {
            addCriterion("v_uptime =", value, "vUptime");
            return (Criteria) this;
        }

        public Criteria andVUptimeNotEqualTo(Date value) {
            addCriterion("v_uptime <>", value, "vUptime");
            return (Criteria) this;
        }

        public Criteria andVUptimeGreaterThan(Date value) {
            addCriterion("v_uptime >", value, "vUptime");
            return (Criteria) this;
        }

        public Criteria andVUptimeGreaterThanOrEqualTo(Date value) {
            addCriterion("v_uptime >=", value, "vUptime");
            return (Criteria) this;
        }

        public Criteria andVUptimeLessThan(Date value) {
            addCriterion("v_uptime <", value, "vUptime");
            return (Criteria) this;
        }

        public Criteria andVUptimeLessThanOrEqualTo(Date value) {
            addCriterion("v_uptime <=", value, "vUptime");
            return (Criteria) this;
        }

        public Criteria andVUptimeIn(List<Date> values) {
            addCriterion("v_uptime in", values, "vUptime");
            return (Criteria) this;
        }

        public Criteria andVUptimeNotIn(List<Date> values) {
            addCriterion("v_uptime not in", values, "vUptime");
            return (Criteria) this;
        }

        public Criteria andVUptimeBetween(Date value1, Date value2) {
            addCriterion("v_uptime between", value1, value2, "vUptime");
            return (Criteria) this;
        }

        public Criteria andVUptimeNotBetween(Date value1, Date value2) {
            addCriterion("v_uptime not between", value1, value2, "vUptime");
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