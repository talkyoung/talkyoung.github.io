package cn.sjxy.overdue.pojo;

import java.util.ArrayList;
import java.util.List;

public class StudentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StudentExample() {
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

        public Criteria andStuPasswordIsNull() {
            addCriterion("stu_password is null");
            return (Criteria) this;
        }

        public Criteria andStuPasswordIsNotNull() {
            addCriterion("stu_password is not null");
            return (Criteria) this;
        }

        public Criteria andStuPasswordEqualTo(String value) {
            addCriterion("stu_password =", value, "stuPassword");
            return (Criteria) this;
        }

        public Criteria andStuPasswordNotEqualTo(String value) {
            addCriterion("stu_password <>", value, "stuPassword");
            return (Criteria) this;
        }

        public Criteria andStuPasswordGreaterThan(String value) {
            addCriterion("stu_password >", value, "stuPassword");
            return (Criteria) this;
        }

        public Criteria andStuPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("stu_password >=", value, "stuPassword");
            return (Criteria) this;
        }

        public Criteria andStuPasswordLessThan(String value) {
            addCriterion("stu_password <", value, "stuPassword");
            return (Criteria) this;
        }

        public Criteria andStuPasswordLessThanOrEqualTo(String value) {
            addCriterion("stu_password <=", value, "stuPassword");
            return (Criteria) this;
        }

        public Criteria andStuPasswordLike(String value) {
            addCriterion("stu_password like", value, "stuPassword");
            return (Criteria) this;
        }

        public Criteria andStuPasswordNotLike(String value) {
            addCriterion("stu_password not like", value, "stuPassword");
            return (Criteria) this;
        }

        public Criteria andStuPasswordIn(List<String> values) {
            addCriterion("stu_password in", values, "stuPassword");
            return (Criteria) this;
        }

        public Criteria andStuPasswordNotIn(List<String> values) {
            addCriterion("stu_password not in", values, "stuPassword");
            return (Criteria) this;
        }

        public Criteria andStuPasswordBetween(String value1, String value2) {
            addCriterion("stu_password between", value1, value2, "stuPassword");
            return (Criteria) this;
        }

        public Criteria andStuPasswordNotBetween(String value1, String value2) {
            addCriterion("stu_password not between", value1, value2, "stuPassword");
            return (Criteria) this;
        }

        public Criteria andStuCourseIdIsNull() {
            addCriterion("stu_course_id is null");
            return (Criteria) this;
        }

        public Criteria andStuCourseIdIsNotNull() {
            addCriterion("stu_course_id is not null");
            return (Criteria) this;
        }

        public Criteria andStuCourseIdEqualTo(String value) {
            addCriterion("stu_course_id =", value, "stuCourseId");
            return (Criteria) this;
        }

        public Criteria andStuCourseIdNotEqualTo(String value) {
            addCriterion("stu_course_id <>", value, "stuCourseId");
            return (Criteria) this;
        }

        public Criteria andStuCourseIdGreaterThan(String value) {
            addCriterion("stu_course_id >", value, "stuCourseId");
            return (Criteria) this;
        }

        public Criteria andStuCourseIdGreaterThanOrEqualTo(String value) {
            addCriterion("stu_course_id >=", value, "stuCourseId");
            return (Criteria) this;
        }

        public Criteria andStuCourseIdLessThan(String value) {
            addCriterion("stu_course_id <", value, "stuCourseId");
            return (Criteria) this;
        }

        public Criteria andStuCourseIdLessThanOrEqualTo(String value) {
            addCriterion("stu_course_id <=", value, "stuCourseId");
            return (Criteria) this;
        }

        public Criteria andStuCourseIdLike(String value) {
            addCriterion("stu_course_id like", value, "stuCourseId");
            return (Criteria) this;
        }

        public Criteria andStuCourseIdNotLike(String value) {
            addCriterion("stu_course_id not like", value, "stuCourseId");
            return (Criteria) this;
        }

        public Criteria andStuCourseIdIn(List<String> values) {
            addCriterion("stu_course_id in", values, "stuCourseId");
            return (Criteria) this;
        }

        public Criteria andStuCourseIdNotIn(List<String> values) {
            addCriterion("stu_course_id not in", values, "stuCourseId");
            return (Criteria) this;
        }

        public Criteria andStuCourseIdBetween(String value1, String value2) {
            addCriterion("stu_course_id between", value1, value2, "stuCourseId");
            return (Criteria) this;
        }

        public Criteria andStuCourseIdNotBetween(String value1, String value2) {
            addCriterion("stu_course_id not between", value1, value2, "stuCourseId");
            return (Criteria) this;
        }

        public Criteria andStuTeacherIdIsNull() {
            addCriterion("stu_teacher_id is null");
            return (Criteria) this;
        }

        public Criteria andStuTeacherIdIsNotNull() {
            addCriterion("stu_teacher_id is not null");
            return (Criteria) this;
        }

        public Criteria andStuTeacherIdEqualTo(String value) {
            addCriterion("stu_teacher_id =", value, "stuTeacherId");
            return (Criteria) this;
        }

        public Criteria andStuTeacherIdNotEqualTo(String value) {
            addCriterion("stu_teacher_id <>", value, "stuTeacherId");
            return (Criteria) this;
        }

        public Criteria andStuTeacherIdGreaterThan(String value) {
            addCriterion("stu_teacher_id >", value, "stuTeacherId");
            return (Criteria) this;
        }

        public Criteria andStuTeacherIdGreaterThanOrEqualTo(String value) {
            addCriterion("stu_teacher_id >=", value, "stuTeacherId");
            return (Criteria) this;
        }

        public Criteria andStuTeacherIdLessThan(String value) {
            addCriterion("stu_teacher_id <", value, "stuTeacherId");
            return (Criteria) this;
        }

        public Criteria andStuTeacherIdLessThanOrEqualTo(String value) {
            addCriterion("stu_teacher_id <=", value, "stuTeacherId");
            return (Criteria) this;
        }

        public Criteria andStuTeacherIdLike(String value) {
            addCriterion("stu_teacher_id like", value, "stuTeacherId");
            return (Criteria) this;
        }

        public Criteria andStuTeacherIdNotLike(String value) {
            addCriterion("stu_teacher_id not like", value, "stuTeacherId");
            return (Criteria) this;
        }

        public Criteria andStuTeacherIdIn(List<String> values) {
            addCriterion("stu_teacher_id in", values, "stuTeacherId");
            return (Criteria) this;
        }

        public Criteria andStuTeacherIdNotIn(List<String> values) {
            addCriterion("stu_teacher_id not in", values, "stuTeacherId");
            return (Criteria) this;
        }

        public Criteria andStuTeacherIdBetween(String value1, String value2) {
            addCriterion("stu_teacher_id between", value1, value2, "stuTeacherId");
            return (Criteria) this;
        }

        public Criteria andStuTeacherIdNotBetween(String value1, String value2) {
            addCriterion("stu_teacher_id not between", value1, value2, "stuTeacherId");
            return (Criteria) this;
        }

        public Criteria andStuStatusIsNull() {
            addCriterion("stu_status is null");
            return (Criteria) this;
        }

        public Criteria andStuStatusIsNotNull() {
            addCriterion("stu_status is not null");
            return (Criteria) this;
        }

        public Criteria andStuStatusEqualTo(Integer value) {
            addCriterion("stu_status =", value, "stuStatus");
            return (Criteria) this;
        }

        public Criteria andStuStatusNotEqualTo(Integer value) {
            addCriterion("stu_status <>", value, "stuStatus");
            return (Criteria) this;
        }

        public Criteria andStuStatusGreaterThan(Integer value) {
            addCriterion("stu_status >", value, "stuStatus");
            return (Criteria) this;
        }

        public Criteria andStuStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("stu_status >=", value, "stuStatus");
            return (Criteria) this;
        }

        public Criteria andStuStatusLessThan(Integer value) {
            addCriterion("stu_status <", value, "stuStatus");
            return (Criteria) this;
        }

        public Criteria andStuStatusLessThanOrEqualTo(Integer value) {
            addCriterion("stu_status <=", value, "stuStatus");
            return (Criteria) this;
        }

        public Criteria andStuStatusIn(List<Integer> values) {
            addCriterion("stu_status in", values, "stuStatus");
            return (Criteria) this;
        }

        public Criteria andStuStatusNotIn(List<Integer> values) {
            addCriterion("stu_status not in", values, "stuStatus");
            return (Criteria) this;
        }

        public Criteria andStuStatusBetween(Integer value1, Integer value2) {
            addCriterion("stu_status between", value1, value2, "stuStatus");
            return (Criteria) this;
        }

        public Criteria andStuStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("stu_status not between", value1, value2, "stuStatus");
            return (Criteria) this;
        }

        public Criteria andStuPhoneIsNull() {
            addCriterion("stu_phone is null");
            return (Criteria) this;
        }

        public Criteria andStuPhoneIsNotNull() {
            addCriterion("stu_phone is not null");
            return (Criteria) this;
        }

        public Criteria andStuPhoneEqualTo(String value) {
            addCriterion("stu_phone =", value, "stuPhone");
            return (Criteria) this;
        }

        public Criteria andStuPhoneNotEqualTo(String value) {
            addCriterion("stu_phone <>", value, "stuPhone");
            return (Criteria) this;
        }

        public Criteria andStuPhoneGreaterThan(String value) {
            addCriterion("stu_phone >", value, "stuPhone");
            return (Criteria) this;
        }

        public Criteria andStuPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("stu_phone >=", value, "stuPhone");
            return (Criteria) this;
        }

        public Criteria andStuPhoneLessThan(String value) {
            addCriterion("stu_phone <", value, "stuPhone");
            return (Criteria) this;
        }

        public Criteria andStuPhoneLessThanOrEqualTo(String value) {
            addCriterion("stu_phone <=", value, "stuPhone");
            return (Criteria) this;
        }

        public Criteria andStuPhoneLike(String value) {
            addCriterion("stu_phone like", value, "stuPhone");
            return (Criteria) this;
        }

        public Criteria andStuPhoneNotLike(String value) {
            addCriterion("stu_phone not like", value, "stuPhone");
            return (Criteria) this;
        }

        public Criteria andStuPhoneIn(List<String> values) {
            addCriterion("stu_phone in", values, "stuPhone");
            return (Criteria) this;
        }

        public Criteria andStuPhoneNotIn(List<String> values) {
            addCriterion("stu_phone not in", values, "stuPhone");
            return (Criteria) this;
        }

        public Criteria andStuPhoneBetween(String value1, String value2) {
            addCriterion("stu_phone between", value1, value2, "stuPhone");
            return (Criteria) this;
        }

        public Criteria andStuPhoneNotBetween(String value1, String value2) {
            addCriterion("stu_phone not between", value1, value2, "stuPhone");
            return (Criteria) this;
        }

        public Criteria andStuProfessionIdIsNull() {
            addCriterion("stu_profession_id is null");
            return (Criteria) this;
        }

        public Criteria andStuProfessionIdIsNotNull() {
            addCriterion("stu_profession_id is not null");
            return (Criteria) this;
        }

        public Criteria andStuProfessionIdEqualTo(String value) {
            addCriterion("stu_profession_id =", value, "stuProfessionId");
            return (Criteria) this;
        }

        public Criteria andStuProfessionIdNotEqualTo(String value) {
            addCriterion("stu_profession_id <>", value, "stuProfessionId");
            return (Criteria) this;
        }

        public Criteria andStuProfessionIdGreaterThan(String value) {
            addCriterion("stu_profession_id >", value, "stuProfessionId");
            return (Criteria) this;
        }

        public Criteria andStuProfessionIdGreaterThanOrEqualTo(String value) {
            addCriterion("stu_profession_id >=", value, "stuProfessionId");
            return (Criteria) this;
        }

        public Criteria andStuProfessionIdLessThan(String value) {
            addCriterion("stu_profession_id <", value, "stuProfessionId");
            return (Criteria) this;
        }

        public Criteria andStuProfessionIdLessThanOrEqualTo(String value) {
            addCriterion("stu_profession_id <=", value, "stuProfessionId");
            return (Criteria) this;
        }

        public Criteria andStuProfessionIdLike(String value) {
            addCriterion("stu_profession_id like", value, "stuProfessionId");
            return (Criteria) this;
        }

        public Criteria andStuProfessionIdNotLike(String value) {
            addCriterion("stu_profession_id not like", value, "stuProfessionId");
            return (Criteria) this;
        }

        public Criteria andStuProfessionIdIn(List<String> values) {
            addCriterion("stu_profession_id in", values, "stuProfessionId");
            return (Criteria) this;
        }

        public Criteria andStuProfessionIdNotIn(List<String> values) {
            addCriterion("stu_profession_id not in", values, "stuProfessionId");
            return (Criteria) this;
        }

        public Criteria andStuProfessionIdBetween(String value1, String value2) {
            addCriterion("stu_profession_id between", value1, value2, "stuProfessionId");
            return (Criteria) this;
        }

        public Criteria andStuProfessionIdNotBetween(String value1, String value2) {
            addCriterion("stu_profession_id not between", value1, value2, "stuProfessionId");
            return (Criteria) this;
        }

        public Criteria andStuDepartmentIdIsNull() {
            addCriterion("stu_department_id is null");
            return (Criteria) this;
        }

        public Criteria andStuDepartmentIdIsNotNull() {
            addCriterion("stu_department_id is not null");
            return (Criteria) this;
        }

        public Criteria andStuDepartmentIdEqualTo(String value) {
            addCriterion("stu_department_id =", value, "stuDepartmentId");
            return (Criteria) this;
        }

        public Criteria andStuDepartmentIdNotEqualTo(String value) {
            addCriterion("stu_department_id <>", value, "stuDepartmentId");
            return (Criteria) this;
        }

        public Criteria andStuDepartmentIdGreaterThan(String value) {
            addCriterion("stu_department_id >", value, "stuDepartmentId");
            return (Criteria) this;
        }

        public Criteria andStuDepartmentIdGreaterThanOrEqualTo(String value) {
            addCriterion("stu_department_id >=", value, "stuDepartmentId");
            return (Criteria) this;
        }

        public Criteria andStuDepartmentIdLessThan(String value) {
            addCriterion("stu_department_id <", value, "stuDepartmentId");
            return (Criteria) this;
        }

        public Criteria andStuDepartmentIdLessThanOrEqualTo(String value) {
            addCriterion("stu_department_id <=", value, "stuDepartmentId");
            return (Criteria) this;
        }

        public Criteria andStuDepartmentIdLike(String value) {
            addCriterion("stu_department_id like", value, "stuDepartmentId");
            return (Criteria) this;
        }

        public Criteria andStuDepartmentIdNotLike(String value) {
            addCriterion("stu_department_id not like", value, "stuDepartmentId");
            return (Criteria) this;
        }

        public Criteria andStuDepartmentIdIn(List<String> values) {
            addCriterion("stu_department_id in", values, "stuDepartmentId");
            return (Criteria) this;
        }

        public Criteria andStuDepartmentIdNotIn(List<String> values) {
            addCriterion("stu_department_id not in", values, "stuDepartmentId");
            return (Criteria) this;
        }

        public Criteria andStuDepartmentIdBetween(String value1, String value2) {
            addCriterion("stu_department_id between", value1, value2, "stuDepartmentId");
            return (Criteria) this;
        }

        public Criteria andStuDepartmentIdNotBetween(String value1, String value2) {
            addCriterion("stu_department_id not between", value1, value2, "stuDepartmentId");
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