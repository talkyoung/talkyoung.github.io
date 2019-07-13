package cn.sjxy.overdue.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudyprocessExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StudyprocessExample() {
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

        public Criteria andStuProIdIsNull() {
            addCriterion("stu_pro_id is null");
            return (Criteria) this;
        }

        public Criteria andStuProIdIsNotNull() {
            addCriterion("stu_pro_id is not null");
            return (Criteria) this;
        }

        public Criteria andStuProIdEqualTo(Integer value) {
            addCriterion("stu_pro_id =", value, "stuProId");
            return (Criteria) this;
        }

        public Criteria andStuProIdNotEqualTo(Integer value) {
            addCriterion("stu_pro_id <>", value, "stuProId");
            return (Criteria) this;
        }

        public Criteria andStuProIdGreaterThan(Integer value) {
            addCriterion("stu_pro_id >", value, "stuProId");
            return (Criteria) this;
        }

        public Criteria andStuProIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("stu_pro_id >=", value, "stuProId");
            return (Criteria) this;
        }

        public Criteria andStuProIdLessThan(Integer value) {
            addCriterion("stu_pro_id <", value, "stuProId");
            return (Criteria) this;
        }

        public Criteria andStuProIdLessThanOrEqualTo(Integer value) {
            addCriterion("stu_pro_id <=", value, "stuProId");
            return (Criteria) this;
        }

        public Criteria andStuProIdIn(List<Integer> values) {
            addCriterion("stu_pro_id in", values, "stuProId");
            return (Criteria) this;
        }

        public Criteria andStuProIdNotIn(List<Integer> values) {
            addCriterion("stu_pro_id not in", values, "stuProId");
            return (Criteria) this;
        }

        public Criteria andStuProIdBetween(Integer value1, Integer value2) {
            addCriterion("stu_pro_id between", value1, value2, "stuProId");
            return (Criteria) this;
        }

        public Criteria andStuProIdNotBetween(Integer value1, Integer value2) {
            addCriterion("stu_pro_id not between", value1, value2, "stuProId");
            return (Criteria) this;
        }

        public Criteria andStuIdIsNull() {
            addCriterion("stu_id is null");
            return (Criteria) this;
        }

        public Criteria andStuIdIsNotNull() {
            addCriterion("stu_id is not null");
            return (Criteria) this;
        }

        public Criteria andStuIdEqualTo(Integer value) {
            addCriterion("stu_id =", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdNotEqualTo(Integer value) {
            addCriterion("stu_id <>", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdGreaterThan(Integer value) {
            addCriterion("stu_id >", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("stu_id >=", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdLessThan(Integer value) {
            addCriterion("stu_id <", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdLessThanOrEqualTo(Integer value) {
            addCriterion("stu_id <=", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdIn(List<Integer> values) {
            addCriterion("stu_id in", values, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdNotIn(List<Integer> values) {
            addCriterion("stu_id not in", values, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdBetween(Integer value1, Integer value2) {
            addCriterion("stu_id between", value1, value2, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdNotBetween(Integer value1, Integer value2) {
            addCriterion("stu_id not between", value1, value2, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuNameIsNull() {
            addCriterion("stu_name is null");
            return (Criteria) this;
        }

        public Criteria andStuNameIsNotNull() {
            addCriterion("stu_name is not null");
            return (Criteria) this;
        }

        public Criteria andStuNameEqualTo(String value) {
            addCriterion("stu_name =", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameNotEqualTo(String value) {
            addCriterion("stu_name <>", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameGreaterThan(String value) {
            addCriterion("stu_name >", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameGreaterThanOrEqualTo(String value) {
            addCriterion("stu_name >=", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameLessThan(String value) {
            addCriterion("stu_name <", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameLessThanOrEqualTo(String value) {
            addCriterion("stu_name <=", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameLike(String value) {
            addCriterion("stu_name like", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameNotLike(String value) {
            addCriterion("stu_name not like", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameIn(List<String> values) {
            addCriterion("stu_name in", values, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameNotIn(List<String> values) {
            addCriterion("stu_name not in", values, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameBetween(String value1, String value2) {
            addCriterion("stu_name between", value1, value2, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameNotBetween(String value1, String value2) {
            addCriterion("stu_name not between", value1, value2, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuLogintimeIsNull() {
            addCriterion("stu_logintime is null");
            return (Criteria) this;
        }

        public Criteria andStuLogintimeIsNotNull() {
            addCriterion("stu_logintime is not null");
            return (Criteria) this;
        }

        public Criteria andStuLogintimeEqualTo(Date value) {
            addCriterion("stu_logintime =", value, "stuLogintime");
            return (Criteria) this;
        }

        public Criteria andStuLogintimeNotEqualTo(Date value) {
            addCriterion("stu_logintime <>", value, "stuLogintime");
            return (Criteria) this;
        }

        public Criteria andStuLogintimeGreaterThan(Date value) {
            addCriterion("stu_logintime >", value, "stuLogintime");
            return (Criteria) this;
        }

        public Criteria andStuLogintimeGreaterThanOrEqualTo(Date value) {
            addCriterion("stu_logintime >=", value, "stuLogintime");
            return (Criteria) this;
        }

        public Criteria andStuLogintimeLessThan(Date value) {
            addCriterion("stu_logintime <", value, "stuLogintime");
            return (Criteria) this;
        }

        public Criteria andStuLogintimeLessThanOrEqualTo(Date value) {
            addCriterion("stu_logintime <=", value, "stuLogintime");
            return (Criteria) this;
        }

        public Criteria andStuLogintimeIn(List<Date> values) {
            addCriterion("stu_logintime in", values, "stuLogintime");
            return (Criteria) this;
        }

        public Criteria andStuLogintimeNotIn(List<Date> values) {
            addCriterion("stu_logintime not in", values, "stuLogintime");
            return (Criteria) this;
        }

        public Criteria andStuLogintimeBetween(Date value1, Date value2) {
            addCriterion("stu_logintime between", value1, value2, "stuLogintime");
            return (Criteria) this;
        }

        public Criteria andStuLogintimeNotBetween(Date value1, Date value2) {
            addCriterion("stu_logintime not between", value1, value2, "stuLogintime");
            return (Criteria) this;
        }

        public Criteria andStuLogouttimeIsNull() {
            addCriterion("stu_logouttime is null");
            return (Criteria) this;
        }

        public Criteria andStuLogouttimeIsNotNull() {
            addCriterion("stu_logouttime is not null");
            return (Criteria) this;
        }

        public Criteria andStuLogouttimeEqualTo(Date value) {
            addCriterion("stu_logouttime =", value, "stuLogouttime");
            return (Criteria) this;
        }

        public Criteria andStuLogouttimeNotEqualTo(Date value) {
            addCriterion("stu_logouttime <>", value, "stuLogouttime");
            return (Criteria) this;
        }

        public Criteria andStuLogouttimeGreaterThan(Date value) {
            addCriterion("stu_logouttime >", value, "stuLogouttime");
            return (Criteria) this;
        }

        public Criteria andStuLogouttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("stu_logouttime >=", value, "stuLogouttime");
            return (Criteria) this;
        }

        public Criteria andStuLogouttimeLessThan(Date value) {
            addCriterion("stu_logouttime <", value, "stuLogouttime");
            return (Criteria) this;
        }

        public Criteria andStuLogouttimeLessThanOrEqualTo(Date value) {
            addCriterion("stu_logouttime <=", value, "stuLogouttime");
            return (Criteria) this;
        }

        public Criteria andStuLogouttimeIn(List<Date> values) {
            addCriterion("stu_logouttime in", values, "stuLogouttime");
            return (Criteria) this;
        }

        public Criteria andStuLogouttimeNotIn(List<Date> values) {
            addCriterion("stu_logouttime not in", values, "stuLogouttime");
            return (Criteria) this;
        }

        public Criteria andStuLogouttimeBetween(Date value1, Date value2) {
            addCriterion("stu_logouttime between", value1, value2, "stuLogouttime");
            return (Criteria) this;
        }

        public Criteria andStuLogouttimeNotBetween(Date value1, Date value2) {
            addCriterion("stu_logouttime not between", value1, value2, "stuLogouttime");
            return (Criteria) this;
        }

        public Criteria andAccumStudytimeIsNull() {
            addCriterion("accum_studytime is null");
            return (Criteria) this;
        }

        public Criteria andAccumStudytimeIsNotNull() {
            addCriterion("accum_studytime is not null");
            return (Criteria) this;
        }

        public Criteria andAccumStudytimeEqualTo(String value) {
            addCriterion("accum_studytime =", value, "accumStudytime");
            return (Criteria) this;
        }

        public Criteria andAccumStudytimeNotEqualTo(String value) {
            addCriterion("accum_studytime <>", value, "accumStudytime");
            return (Criteria) this;
        }

        public Criteria andAccumStudytimeGreaterThan(String value) {
            addCriterion("accum_studytime >", value, "accumStudytime");
            return (Criteria) this;
        }

        public Criteria andAccumStudytimeGreaterThanOrEqualTo(String value) {
            addCriterion("accum_studytime >=", value, "accumStudytime");
            return (Criteria) this;
        }

        public Criteria andAccumStudytimeLessThan(String value) {
            addCriterion("accum_studytime <", value, "accumStudytime");
            return (Criteria) this;
        }

        public Criteria andAccumStudytimeLessThanOrEqualTo(String value) {
            addCriterion("accum_studytime <=", value, "accumStudytime");
            return (Criteria) this;
        }

        public Criteria andAccumStudytimeLike(String value) {
            addCriterion("accum_studytime like", value, "accumStudytime");
            return (Criteria) this;
        }

        public Criteria andAccumStudytimeNotLike(String value) {
            addCriterion("accum_studytime not like", value, "accumStudytime");
            return (Criteria) this;
        }

        public Criteria andAccumStudytimeIn(List<String> values) {
            addCriterion("accum_studytime in", values, "accumStudytime");
            return (Criteria) this;
        }

        public Criteria andAccumStudytimeNotIn(List<String> values) {
            addCriterion("accum_studytime not in", values, "accumStudytime");
            return (Criteria) this;
        }

        public Criteria andAccumStudytimeBetween(String value1, String value2) {
            addCriterion("accum_studytime between", value1, value2, "accumStudytime");
            return (Criteria) this;
        }

        public Criteria andAccumStudytimeNotBetween(String value1, String value2) {
            addCriterion("accum_studytime not between", value1, value2, "accumStudytime");
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