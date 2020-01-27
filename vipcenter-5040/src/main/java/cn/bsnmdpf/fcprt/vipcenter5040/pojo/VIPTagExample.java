package cn.bsnmdpf.fcprt.vipcenter5040.pojo;

import java.util.ArrayList;
import java.util.List;

public class VIPTagExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public VIPTagExample() {
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

        public Criteria andVtidIsNull() {
            addCriterion("vtid is null");
            return (Criteria) this;
        }

        public Criteria andVtidIsNotNull() {
            addCriterion("vtid is not null");
            return (Criteria) this;
        }

        public Criteria andVtidEqualTo(Integer value) {
            addCriterion("vtid =", value, "vtid");
            return (Criteria) this;
        }

        public Criteria andVtidNotEqualTo(Integer value) {
            addCriterion("vtid <>", value, "vtid");
            return (Criteria) this;
        }

        public Criteria andVtidGreaterThan(Integer value) {
            addCriterion("vtid >", value, "vtid");
            return (Criteria) this;
        }

        public Criteria andVtidGreaterThanOrEqualTo(Integer value) {
            addCriterion("vtid >=", value, "vtid");
            return (Criteria) this;
        }

        public Criteria andVtidLessThan(Integer value) {
            addCriterion("vtid <", value, "vtid");
            return (Criteria) this;
        }

        public Criteria andVtidLessThanOrEqualTo(Integer value) {
            addCriterion("vtid <=", value, "vtid");
            return (Criteria) this;
        }

        public Criteria andVtidIn(List<Integer> values) {
            addCriterion("vtid in", values, "vtid");
            return (Criteria) this;
        }

        public Criteria andVtidNotIn(List<Integer> values) {
            addCriterion("vtid not in", values, "vtid");
            return (Criteria) this;
        }

        public Criteria andVtidBetween(Integer value1, Integer value2) {
            addCriterion("vtid between", value1, value2, "vtid");
            return (Criteria) this;
        }

        public Criteria andVtidNotBetween(Integer value1, Integer value2) {
            addCriterion("vtid not between", value1, value2, "vtid");
            return (Criteria) this;
        }

        public Criteria andVipidIsNull() {
            addCriterion("vipid is null");
            return (Criteria) this;
        }

        public Criteria andVipidIsNotNull() {
            addCriterion("vipid is not null");
            return (Criteria) this;
        }

        public Criteria andVipidEqualTo(Integer value) {
            addCriterion("vipid =", value, "vipid");
            return (Criteria) this;
        }

        public Criteria andVipidNotEqualTo(Integer value) {
            addCriterion("vipid <>", value, "vipid");
            return (Criteria) this;
        }

        public Criteria andVipidGreaterThan(Integer value) {
            addCriterion("vipid >", value, "vipid");
            return (Criteria) this;
        }

        public Criteria andVipidGreaterThanOrEqualTo(Integer value) {
            addCriterion("vipid >=", value, "vipid");
            return (Criteria) this;
        }

        public Criteria andVipidLessThan(Integer value) {
            addCriterion("vipid <", value, "vipid");
            return (Criteria) this;
        }

        public Criteria andVipidLessThanOrEqualTo(Integer value) {
            addCriterion("vipid <=", value, "vipid");
            return (Criteria) this;
        }

        public Criteria andVipidIn(List<Integer> values) {
            addCriterion("vipid in", values, "vipid");
            return (Criteria) this;
        }

        public Criteria andVipidNotIn(List<Integer> values) {
            addCriterion("vipid not in", values, "vipid");
            return (Criteria) this;
        }

        public Criteria andVipidBetween(Integer value1, Integer value2) {
            addCriterion("vipid between", value1, value2, "vipid");
            return (Criteria) this;
        }

        public Criteria andVipidNotBetween(Integer value1, Integer value2) {
            addCriterion("vipid not between", value1, value2, "vipid");
            return (Criteria) this;
        }

        public Criteria andTagnameIsNull() {
            addCriterion("tagname is null");
            return (Criteria) this;
        }

        public Criteria andTagnameIsNotNull() {
            addCriterion("tagname is not null");
            return (Criteria) this;
        }

        public Criteria andTagnameEqualTo(String value) {
            addCriterion("tagname =", value, "tagname");
            return (Criteria) this;
        }

        public Criteria andTagnameNotEqualTo(String value) {
            addCriterion("tagname <>", value, "tagname");
            return (Criteria) this;
        }

        public Criteria andTagnameGreaterThan(String value) {
            addCriterion("tagname >", value, "tagname");
            return (Criteria) this;
        }

        public Criteria andTagnameGreaterThanOrEqualTo(String value) {
            addCriterion("tagname >=", value, "tagname");
            return (Criteria) this;
        }

        public Criteria andTagnameLessThan(String value) {
            addCriterion("tagname <", value, "tagname");
            return (Criteria) this;
        }

        public Criteria andTagnameLessThanOrEqualTo(String value) {
            addCriterion("tagname <=", value, "tagname");
            return (Criteria) this;
        }

        public Criteria andTagnameLike(String value) {
            addCriterion("tagname like", value, "tagname");
            return (Criteria) this;
        }

        public Criteria andTagnameNotLike(String value) {
            addCriterion("tagname not like", value, "tagname");
            return (Criteria) this;
        }

        public Criteria andTagnameIn(List<String> values) {
            addCriterion("tagname in", values, "tagname");
            return (Criteria) this;
        }

        public Criteria andTagnameNotIn(List<String> values) {
            addCriterion("tagname not in", values, "tagname");
            return (Criteria) this;
        }

        public Criteria andTagnameBetween(String value1, String value2) {
            addCriterion("tagname between", value1, value2, "tagname");
            return (Criteria) this;
        }

        public Criteria andTagnameNotBetween(String value1, String value2) {
            addCriterion("tagname not between", value1, value2, "tagname");
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