package cn.sjxy.overdue.pojo;

import java.util.ArrayList;
import java.util.List;

public class TeacherExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TeacherExample() {
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

        public Criteria andTeaIdIsNull() {
            addCriterion("tea_id is null");
            return (Criteria) this;
        }

        public Criteria andTeaIdIsNotNull() {
            addCriterion("tea_id is not null");
            return (Criteria) this;
        }

        public Criteria andTeaIdEqualTo(Integer value) {
            addCriterion("tea_id =", value, "teaId");
            return (Criteria) this;
        }

        public Criteria andTeaIdNotEqualTo(Integer value) {
            addCriterion("tea_id <>", value, "teaId");
            return (Criteria) this;
        }

        public Criteria andTeaIdGreaterThan(Integer value) {
            addCriterion("tea_id >", value, "teaId");
            return (Criteria) this;
        }

        public Criteria andTeaIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("tea_id >=", value, "teaId");
            return (Criteria) this;
        }

        public Criteria andTeaIdLessThan(Integer value) {
            addCriterion("tea_id <", value, "teaId");
            return (Criteria) this;
        }

        public Criteria andTeaIdLessThanOrEqualTo(Integer value) {
            addCriterion("tea_id <=", value, "teaId");
            return (Criteria) this;
        }

        public Criteria andTeaIdIn(List<Integer> values) {
            addCriterion("tea_id in", values, "teaId");
            return (Criteria) this;
        }

        public Criteria andTeaIdNotIn(List<Integer> values) {
            addCriterion("tea_id not in", values, "teaId");
            return (Criteria) this;
        }

        public Criteria andTeaIdBetween(Integer value1, Integer value2) {
            addCriterion("tea_id between", value1, value2, "teaId");
            return (Criteria) this;
        }

        public Criteria andTeaIdNotBetween(Integer value1, Integer value2) {
            addCriterion("tea_id not between", value1, value2, "teaId");
            return (Criteria) this;
        }

        public Criteria andTeaNameIsNull() {
            addCriterion("tea_name is null");
            return (Criteria) this;
        }

        public Criteria andTeaNameIsNotNull() {
            addCriterion("tea_name is not null");
            return (Criteria) this;
        }

        public Criteria andTeaNameEqualTo(String value) {
            addCriterion("tea_name =", value, "teaName");
            return (Criteria) this;
        }

        public Criteria andTeaNameNotEqualTo(String value) {
            addCriterion("tea_name <>", value, "teaName");
            return (Criteria) this;
        }

        public Criteria andTeaNameGreaterThan(String value) {
            addCriterion("tea_name >", value, "teaName");
            return (Criteria) this;
        }

        public Criteria andTeaNameGreaterThanOrEqualTo(String value) {
            addCriterion("tea_name >=", value, "teaName");
            return (Criteria) this;
        }

        public Criteria andTeaNameLessThan(String value) {
            addCriterion("tea_name <", value, "teaName");
            return (Criteria) this;
        }

        public Criteria andTeaNameLessThanOrEqualTo(String value) {
            addCriterion("tea_name <=", value, "teaName");
            return (Criteria) this;
        }

        public Criteria andTeaNameLike(String value) {
            addCriterion("tea_name like", value, "teaName");
            return (Criteria) this;
        }

        public Criteria andTeaNameNotLike(String value) {
            addCriterion("tea_name not like", value, "teaName");
            return (Criteria) this;
        }

        public Criteria andTeaNameIn(List<String> values) {
            addCriterion("tea_name in", values, "teaName");
            return (Criteria) this;
        }

        public Criteria andTeaNameNotIn(List<String> values) {
            addCriterion("tea_name not in", values, "teaName");
            return (Criteria) this;
        }

        public Criteria andTeaNameBetween(String value1, String value2) {
            addCriterion("tea_name between", value1, value2, "teaName");
            return (Criteria) this;
        }

        public Criteria andTeaNameNotBetween(String value1, String value2) {
            addCriterion("tea_name not between", value1, value2, "teaName");
            return (Criteria) this;
        }

        public Criteria andTeaPasswordIsNull() {
            addCriterion("tea_password is null");
            return (Criteria) this;
        }

        public Criteria andTeaPasswordIsNotNull() {
            addCriterion("tea_password is not null");
            return (Criteria) this;
        }

        public Criteria andTeaPasswordEqualTo(String value) {
            addCriterion("tea_password =", value, "teaPassword");
            return (Criteria) this;
        }

        public Criteria andTeaPasswordNotEqualTo(String value) {
            addCriterion("tea_password <>", value, "teaPassword");
            return (Criteria) this;
        }

        public Criteria andTeaPasswordGreaterThan(String value) {
            addCriterion("tea_password >", value, "teaPassword");
            return (Criteria) this;
        }

        public Criteria andTeaPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("tea_password >=", value, "teaPassword");
            return (Criteria) this;
        }

        public Criteria andTeaPasswordLessThan(String value) {
            addCriterion("tea_password <", value, "teaPassword");
            return (Criteria) this;
        }

        public Criteria andTeaPasswordLessThanOrEqualTo(String value) {
            addCriterion("tea_password <=", value, "teaPassword");
            return (Criteria) this;
        }

        public Criteria andTeaPasswordLike(String value) {
            addCriterion("tea_password like", value, "teaPassword");
            return (Criteria) this;
        }

        public Criteria andTeaPasswordNotLike(String value) {
            addCriterion("tea_password not like", value, "teaPassword");
            return (Criteria) this;
        }

        public Criteria andTeaPasswordIn(List<String> values) {
            addCriterion("tea_password in", values, "teaPassword");
            return (Criteria) this;
        }

        public Criteria andTeaPasswordNotIn(List<String> values) {
            addCriterion("tea_password not in", values, "teaPassword");
            return (Criteria) this;
        }

        public Criteria andTeaPasswordBetween(String value1, String value2) {
            addCriterion("tea_password between", value1, value2, "teaPassword");
            return (Criteria) this;
        }

        public Criteria andTeaPasswordNotBetween(String value1, String value2) {
            addCriterion("tea_password not between", value1, value2, "teaPassword");
            return (Criteria) this;
        }

        public Criteria andTeaCourseIsNull() {
            addCriterion("tea_course is null");
            return (Criteria) this;
        }

        public Criteria andTeaCourseIsNotNull() {
            addCriterion("tea_course is not null");
            return (Criteria) this;
        }

        public Criteria andTeaCourseEqualTo(String value) {
            addCriterion("tea_course =", value, "teaCourse");
            return (Criteria) this;
        }

        public Criteria andTeaCourseNotEqualTo(String value) {
            addCriterion("tea_course <>", value, "teaCourse");
            return (Criteria) this;
        }

        public Criteria andTeaCourseGreaterThan(String value) {
            addCriterion("tea_course >", value, "teaCourse");
            return (Criteria) this;
        }

        public Criteria andTeaCourseGreaterThanOrEqualTo(String value) {
            addCriterion("tea_course >=", value, "teaCourse");
            return (Criteria) this;
        }

        public Criteria andTeaCourseLessThan(String value) {
            addCriterion("tea_course <", value, "teaCourse");
            return (Criteria) this;
        }

        public Criteria andTeaCourseLessThanOrEqualTo(String value) {
            addCriterion("tea_course <=", value, "teaCourse");
            return (Criteria) this;
        }

        public Criteria andTeaCourseLike(String value) {
            addCriterion("tea_course like", value, "teaCourse");
            return (Criteria) this;
        }

        public Criteria andTeaCourseNotLike(String value) {
            addCriterion("tea_course not like", value, "teaCourse");
            return (Criteria) this;
        }

        public Criteria andTeaCourseIn(List<String> values) {
            addCriterion("tea_course in", values, "teaCourse");
            return (Criteria) this;
        }

        public Criteria andTeaCourseNotIn(List<String> values) {
            addCriterion("tea_course not in", values, "teaCourse");
            return (Criteria) this;
        }

        public Criteria andTeaCourseBetween(String value1, String value2) {
            addCriterion("tea_course between", value1, value2, "teaCourse");
            return (Criteria) this;
        }

        public Criteria andTeaCourseNotBetween(String value1, String value2) {
            addCriterion("tea_course not between", value1, value2, "teaCourse");
            return (Criteria) this;
        }

        public Criteria andTeaPhoneIsNull() {
            addCriterion("tea_phone is null");
            return (Criteria) this;
        }

        public Criteria andTeaPhoneIsNotNull() {
            addCriterion("tea_phone is not null");
            return (Criteria) this;
        }

        public Criteria andTeaPhoneEqualTo(String value) {
            addCriterion("tea_phone =", value, "teaPhone");
            return (Criteria) this;
        }

        public Criteria andTeaPhoneNotEqualTo(String value) {
            addCriterion("tea_phone <>", value, "teaPhone");
            return (Criteria) this;
        }

        public Criteria andTeaPhoneGreaterThan(String value) {
            addCriterion("tea_phone >", value, "teaPhone");
            return (Criteria) this;
        }

        public Criteria andTeaPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("tea_phone >=", value, "teaPhone");
            return (Criteria) this;
        }

        public Criteria andTeaPhoneLessThan(String value) {
            addCriterion("tea_phone <", value, "teaPhone");
            return (Criteria) this;
        }

        public Criteria andTeaPhoneLessThanOrEqualTo(String value) {
            addCriterion("tea_phone <=", value, "teaPhone");
            return (Criteria) this;
        }

        public Criteria andTeaPhoneLike(String value) {
            addCriterion("tea_phone like", value, "teaPhone");
            return (Criteria) this;
        }

        public Criteria andTeaPhoneNotLike(String value) {
            addCriterion("tea_phone not like", value, "teaPhone");
            return (Criteria) this;
        }

        public Criteria andTeaPhoneIn(List<String> values) {
            addCriterion("tea_phone in", values, "teaPhone");
            return (Criteria) this;
        }

        public Criteria andTeaPhoneNotIn(List<String> values) {
            addCriterion("tea_phone not in", values, "teaPhone");
            return (Criteria) this;
        }

        public Criteria andTeaPhoneBetween(String value1, String value2) {
            addCriterion("tea_phone between", value1, value2, "teaPhone");
            return (Criteria) this;
        }

        public Criteria andTeaPhoneNotBetween(String value1, String value2) {
            addCriterion("tea_phone not between", value1, value2, "teaPhone");
            return (Criteria) this;
        }

        public Criteria andAssignStudentIsNull() {
            addCriterion("assign_student is null");
            return (Criteria) this;
        }

        public Criteria andAssignStudentIsNotNull() {
            addCriterion("assign_student is not null");
            return (Criteria) this;
        }

        public Criteria andAssignStudentEqualTo(String value) {
            addCriterion("assign_student =", value, "assignStudent");
            return (Criteria) this;
        }

        public Criteria andAssignStudentNotEqualTo(String value) {
            addCriterion("assign_student <>", value, "assignStudent");
            return (Criteria) this;
        }

        public Criteria andAssignStudentGreaterThan(String value) {
            addCriterion("assign_student >", value, "assignStudent");
            return (Criteria) this;
        }

        public Criteria andAssignStudentGreaterThanOrEqualTo(String value) {
            addCriterion("assign_student >=", value, "assignStudent");
            return (Criteria) this;
        }

        public Criteria andAssignStudentLessThan(String value) {
            addCriterion("assign_student <", value, "assignStudent");
            return (Criteria) this;
        }

        public Criteria andAssignStudentLessThanOrEqualTo(String value) {
            addCriterion("assign_student <=", value, "assignStudent");
            return (Criteria) this;
        }

        public Criteria andAssignStudentLike(String value) {
            addCriterion("assign_student like", value, "assignStudent");
            return (Criteria) this;
        }

        public Criteria andAssignStudentNotLike(String value) {
            addCriterion("assign_student not like", value, "assignStudent");
            return (Criteria) this;
        }

        public Criteria andAssignStudentIn(List<String> values) {
            addCriterion("assign_student in", values, "assignStudent");
            return (Criteria) this;
        }

        public Criteria andAssignStudentNotIn(List<String> values) {
            addCriterion("assign_student not in", values, "assignStudent");
            return (Criteria) this;
        }

        public Criteria andAssignStudentBetween(String value1, String value2) {
            addCriterion("assign_student between", value1, value2, "assignStudent");
            return (Criteria) this;
        }

        public Criteria andAssignStudentNotBetween(String value1, String value2) {
            addCriterion("assign_student not between", value1, value2, "assignStudent");
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