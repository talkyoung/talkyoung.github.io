package cn.sjxy.overdue.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommentsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CommentsExample() {
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

        public Criteria andComIdIsNull() {
            addCriterion("com_id is null");
            return (Criteria) this;
        }

        public Criteria andComIdIsNotNull() {
            addCriterion("com_id is not null");
            return (Criteria) this;
        }

        public Criteria andComIdEqualTo(Integer value) {
            addCriterion("com_id =", value, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdNotEqualTo(Integer value) {
            addCriterion("com_id <>", value, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdGreaterThan(Integer value) {
            addCriterion("com_id >", value, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("com_id >=", value, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdLessThan(Integer value) {
            addCriterion("com_id <", value, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdLessThanOrEqualTo(Integer value) {
            addCriterion("com_id <=", value, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdIn(List<Integer> values) {
            addCriterion("com_id in", values, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdNotIn(List<Integer> values) {
            addCriterion("com_id not in", values, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdBetween(Integer value1, Integer value2) {
            addCriterion("com_id between", value1, value2, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdNotBetween(Integer value1, Integer value2) {
            addCriterion("com_id not between", value1, value2, "comId");
            return (Criteria) this;
        }

        public Criteria andComContentIsNull() {
            addCriterion("com_content is null");
            return (Criteria) this;
        }

        public Criteria andComContentIsNotNull() {
            addCriterion("com_content is not null");
            return (Criteria) this;
        }

        public Criteria andComContentEqualTo(String value) {
            addCriterion("com_content =", value, "comContent");
            return (Criteria) this;
        }

        public Criteria andComContentNotEqualTo(String value) {
            addCriterion("com_content <>", value, "comContent");
            return (Criteria) this;
        }

        public Criteria andComContentGreaterThan(String value) {
            addCriterion("com_content >", value, "comContent");
            return (Criteria) this;
        }

        public Criteria andComContentGreaterThanOrEqualTo(String value) {
            addCriterion("com_content >=", value, "comContent");
            return (Criteria) this;
        }

        public Criteria andComContentLessThan(String value) {
            addCriterion("com_content <", value, "comContent");
            return (Criteria) this;
        }

        public Criteria andComContentLessThanOrEqualTo(String value) {
            addCriterion("com_content <=", value, "comContent");
            return (Criteria) this;
        }

        public Criteria andComContentLike(String value) {
            addCriterion("com_content like", value, "comContent");
            return (Criteria) this;
        }

        public Criteria andComContentNotLike(String value) {
            addCriterion("com_content not like", value, "comContent");
            return (Criteria) this;
        }

        public Criteria andComContentIn(List<String> values) {
            addCriterion("com_content in", values, "comContent");
            return (Criteria) this;
        }

        public Criteria andComContentNotIn(List<String> values) {
            addCriterion("com_content not in", values, "comContent");
            return (Criteria) this;
        }

        public Criteria andComContentBetween(String value1, String value2) {
            addCriterion("com_content between", value1, value2, "comContent");
            return (Criteria) this;
        }

        public Criteria andComContentNotBetween(String value1, String value2) {
            addCriterion("com_content not between", value1, value2, "comContent");
            return (Criteria) this;
        }

        public Criteria andComJudgeIsNull() {
            addCriterion("com_judge is null");
            return (Criteria) this;
        }

        public Criteria andComJudgeIsNotNull() {
            addCriterion("com_judge is not null");
            return (Criteria) this;
        }

        public Criteria andComJudgeEqualTo(String value) {
            addCriterion("com_judge =", value, "comJudge");
            return (Criteria) this;
        }

        public Criteria andComJudgeNotEqualTo(String value) {
            addCriterion("com_judge <>", value, "comJudge");
            return (Criteria) this;
        }

        public Criteria andComJudgeGreaterThan(String value) {
            addCriterion("com_judge >", value, "comJudge");
            return (Criteria) this;
        }

        public Criteria andComJudgeGreaterThanOrEqualTo(String value) {
            addCriterion("com_judge >=", value, "comJudge");
            return (Criteria) this;
        }

        public Criteria andComJudgeLessThan(String value) {
            addCriterion("com_judge <", value, "comJudge");
            return (Criteria) this;
        }

        public Criteria andComJudgeLessThanOrEqualTo(String value) {
            addCriterion("com_judge <=", value, "comJudge");
            return (Criteria) this;
        }

        public Criteria andComJudgeLike(String value) {
            addCriterion("com_judge like", value, "comJudge");
            return (Criteria) this;
        }

        public Criteria andComJudgeNotLike(String value) {
            addCriterion("com_judge not like", value, "comJudge");
            return (Criteria) this;
        }

        public Criteria andComJudgeIn(List<String> values) {
            addCriterion("com_judge in", values, "comJudge");
            return (Criteria) this;
        }

        public Criteria andComJudgeNotIn(List<String> values) {
            addCriterion("com_judge not in", values, "comJudge");
            return (Criteria) this;
        }

        public Criteria andComJudgeBetween(String value1, String value2) {
            addCriterion("com_judge between", value1, value2, "comJudge");
            return (Criteria) this;
        }

        public Criteria andComJudgeNotBetween(String value1, String value2) {
            addCriterion("com_judge not between", value1, value2, "comJudge");
            return (Criteria) this;
        }

        public Criteria andComTeaidIsNull() {
            addCriterion("com_teaId is null");
            return (Criteria) this;
        }

        public Criteria andComTeaidIsNotNull() {
            addCriterion("com_teaId is not null");
            return (Criteria) this;
        }

        public Criteria andComTeaidEqualTo(Integer value) {
            addCriterion("com_teaId =", value, "comTeaid");
            return (Criteria) this;
        }

        public Criteria andComTeaidNotEqualTo(Integer value) {
            addCriterion("com_teaId <>", value, "comTeaid");
            return (Criteria) this;
        }

        public Criteria andComTeaidGreaterThan(Integer value) {
            addCriterion("com_teaId >", value, "comTeaid");
            return (Criteria) this;
        }

        public Criteria andComTeaidGreaterThanOrEqualTo(Integer value) {
            addCriterion("com_teaId >=", value, "comTeaid");
            return (Criteria) this;
        }

        public Criteria andComTeaidLessThan(Integer value) {
            addCriterion("com_teaId <", value, "comTeaid");
            return (Criteria) this;
        }

        public Criteria andComTeaidLessThanOrEqualTo(Integer value) {
            addCriterion("com_teaId <=", value, "comTeaid");
            return (Criteria) this;
        }

        public Criteria andComTeaidIn(List<Integer> values) {
            addCriterion("com_teaId in", values, "comTeaid");
            return (Criteria) this;
        }

        public Criteria andComTeaidNotIn(List<Integer> values) {
            addCriterion("com_teaId not in", values, "comTeaid");
            return (Criteria) this;
        }

        public Criteria andComTeaidBetween(Integer value1, Integer value2) {
            addCriterion("com_teaId between", value1, value2, "comTeaid");
            return (Criteria) this;
        }

        public Criteria andComTeaidNotBetween(Integer value1, Integer value2) {
            addCriterion("com_teaId not between", value1, value2, "comTeaid");
            return (Criteria) this;
        }

        public Criteria andComStuidIsNull() {
            addCriterion("com_stuId is null");
            return (Criteria) this;
        }

        public Criteria andComStuidIsNotNull() {
            addCriterion("com_stuId is not null");
            return (Criteria) this;
        }

        public Criteria andComStuidEqualTo(Integer value) {
            addCriterion("com_stuId =", value, "comStuid");
            return (Criteria) this;
        }

        public Criteria andComStuidNotEqualTo(Integer value) {
            addCriterion("com_stuId <>", value, "comStuid");
            return (Criteria) this;
        }

        public Criteria andComStuidGreaterThan(Integer value) {
            addCriterion("com_stuId >", value, "comStuid");
            return (Criteria) this;
        }

        public Criteria andComStuidGreaterThanOrEqualTo(Integer value) {
            addCriterion("com_stuId >=", value, "comStuid");
            return (Criteria) this;
        }

        public Criteria andComStuidLessThan(Integer value) {
            addCriterion("com_stuId <", value, "comStuid");
            return (Criteria) this;
        }

        public Criteria andComStuidLessThanOrEqualTo(Integer value) {
            addCriterion("com_stuId <=", value, "comStuid");
            return (Criteria) this;
        }

        public Criteria andComStuidIn(List<Integer> values) {
            addCriterion("com_stuId in", values, "comStuid");
            return (Criteria) this;
        }

        public Criteria andComStuidNotIn(List<Integer> values) {
            addCriterion("com_stuId not in", values, "comStuid");
            return (Criteria) this;
        }

        public Criteria andComStuidBetween(Integer value1, Integer value2) {
            addCriterion("com_stuId between", value1, value2, "comStuid");
            return (Criteria) this;
        }

        public Criteria andComStuidNotBetween(Integer value1, Integer value2) {
            addCriterion("com_stuId not between", value1, value2, "comStuid");
            return (Criteria) this;
        }

        public Criteria andComDateIsNull() {
            addCriterion("com_date is null");
            return (Criteria) this;
        }

        public Criteria andComDateIsNotNull() {
            addCriterion("com_date is not null");
            return (Criteria) this;
        }

        public Criteria andComDateEqualTo(Date value) {
            addCriterion("com_date =", value, "comDate");
            return (Criteria) this;
        }

        public Criteria andComDateNotEqualTo(Date value) {
            addCriterion("com_date <>", value, "comDate");
            return (Criteria) this;
        }

        public Criteria andComDateGreaterThan(Date value) {
            addCriterion("com_date >", value, "comDate");
            return (Criteria) this;
        }

        public Criteria andComDateGreaterThanOrEqualTo(Date value) {
            addCriterion("com_date >=", value, "comDate");
            return (Criteria) this;
        }

        public Criteria andComDateLessThan(Date value) {
            addCriterion("com_date <", value, "comDate");
            return (Criteria) this;
        }

        public Criteria andComDateLessThanOrEqualTo(Date value) {
            addCriterion("com_date <=", value, "comDate");
            return (Criteria) this;
        }

        public Criteria andComDateIn(List<Date> values) {
            addCriterion("com_date in", values, "comDate");
            return (Criteria) this;
        }

        public Criteria andComDateNotIn(List<Date> values) {
            addCriterion("com_date not in", values, "comDate");
            return (Criteria) this;
        }

        public Criteria andComDateBetween(Date value1, Date value2) {
            addCriterion("com_date between", value1, value2, "comDate");
            return (Criteria) this;
        }

        public Criteria andComDateNotBetween(Date value1, Date value2) {
            addCriterion("com_date not between", value1, value2, "comDate");
            return (Criteria) this;
        }

        public Criteria andComStunameIsNull() {
            addCriterion("com_stuName is null");
            return (Criteria) this;
        }

        public Criteria andComStunameIsNotNull() {
            addCriterion("com_stuName is not null");
            return (Criteria) this;
        }

        public Criteria andComStunameEqualTo(String value) {
            addCriterion("com_stuName =", value, "comStuname");
            return (Criteria) this;
        }

        public Criteria andComStunameNotEqualTo(String value) {
            addCriterion("com_stuName <>", value, "comStuname");
            return (Criteria) this;
        }

        public Criteria andComStunameGreaterThan(String value) {
            addCriterion("com_stuName >", value, "comStuname");
            return (Criteria) this;
        }

        public Criteria andComStunameGreaterThanOrEqualTo(String value) {
            addCriterion("com_stuName >=", value, "comStuname");
            return (Criteria) this;
        }

        public Criteria andComStunameLessThan(String value) {
            addCriterion("com_stuName <", value, "comStuname");
            return (Criteria) this;
        }

        public Criteria andComStunameLessThanOrEqualTo(String value) {
            addCriterion("com_stuName <=", value, "comStuname");
            return (Criteria) this;
        }

        public Criteria andComStunameLike(String value) {
            addCriterion("com_stuName like", value, "comStuname");
            return (Criteria) this;
        }

        public Criteria andComStunameNotLike(String value) {
            addCriterion("com_stuName not like", value, "comStuname");
            return (Criteria) this;
        }

        public Criteria andComStunameIn(List<String> values) {
            addCriterion("com_stuName in", values, "comStuname");
            return (Criteria) this;
        }

        public Criteria andComStunameNotIn(List<String> values) {
            addCriterion("com_stuName not in", values, "comStuname");
            return (Criteria) this;
        }

        public Criteria andComStunameBetween(String value1, String value2) {
            addCriterion("com_stuName between", value1, value2, "comStuname");
            return (Criteria) this;
        }

        public Criteria andComStunameNotBetween(String value1, String value2) {
            addCriterion("com_stuName not between", value1, value2, "comStuname");
            return (Criteria) this;
        }

        public Criteria andCouTeanameIsNull() {
            addCriterion("cou_teaName is null");
            return (Criteria) this;
        }

        public Criteria andCouTeanameIsNotNull() {
            addCriterion("cou_teaName is not null");
            return (Criteria) this;
        }

        public Criteria andCouTeanameEqualTo(String value) {
            addCriterion("cou_teaName =", value, "couTeaname");
            return (Criteria) this;
        }

        public Criteria andCouTeanameNotEqualTo(String value) {
            addCriterion("cou_teaName <>", value, "couTeaname");
            return (Criteria) this;
        }

        public Criteria andCouTeanameGreaterThan(String value) {
            addCriterion("cou_teaName >", value, "couTeaname");
            return (Criteria) this;
        }

        public Criteria andCouTeanameGreaterThanOrEqualTo(String value) {
            addCriterion("cou_teaName >=", value, "couTeaname");
            return (Criteria) this;
        }

        public Criteria andCouTeanameLessThan(String value) {
            addCriterion("cou_teaName <", value, "couTeaname");
            return (Criteria) this;
        }

        public Criteria andCouTeanameLessThanOrEqualTo(String value) {
            addCriterion("cou_teaName <=", value, "couTeaname");
            return (Criteria) this;
        }

        public Criteria andCouTeanameLike(String value) {
            addCriterion("cou_teaName like", value, "couTeaname");
            return (Criteria) this;
        }

        public Criteria andCouTeanameNotLike(String value) {
            addCriterion("cou_teaName not like", value, "couTeaname");
            return (Criteria) this;
        }

        public Criteria andCouTeanameIn(List<String> values) {
            addCriterion("cou_teaName in", values, "couTeaname");
            return (Criteria) this;
        }

        public Criteria andCouTeanameNotIn(List<String> values) {
            addCriterion("cou_teaName not in", values, "couTeaname");
            return (Criteria) this;
        }

        public Criteria andCouTeanameBetween(String value1, String value2) {
            addCriterion("cou_teaName between", value1, value2, "couTeaname");
            return (Criteria) this;
        }

        public Criteria andCouTeanameNotBetween(String value1, String value2) {
            addCriterion("cou_teaName not between", value1, value2, "couTeaname");
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