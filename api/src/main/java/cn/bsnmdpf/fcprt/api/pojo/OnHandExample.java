package cn.bsnmdpf.fcprt.api.pojo;

import java.util.ArrayList;
import java.util.List;

public class OnHandExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OnHandExample() {
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

        public Criteria andOhidIsNull() {
            addCriterion("ohid is null");
            return (Criteria) this;
        }

        public Criteria andOhidIsNotNull() {
            addCriterion("ohid is not null");
            return (Criteria) this;
        }

        public Criteria andOhidEqualTo(Integer value) {
            addCriterion("ohid =", value, "ohid");
            return (Criteria) this;
        }

        public Criteria andOhidNotEqualTo(Integer value) {
            addCriterion("ohid <>", value, "ohid");
            return (Criteria) this;
        }

        public Criteria andOhidGreaterThan(Integer value) {
            addCriterion("ohid >", value, "ohid");
            return (Criteria) this;
        }

        public Criteria andOhidGreaterThanOrEqualTo(Integer value) {
            addCriterion("ohid >=", value, "ohid");
            return (Criteria) this;
        }

        public Criteria andOhidLessThan(Integer value) {
            addCriterion("ohid <", value, "ohid");
            return (Criteria) this;
        }

        public Criteria andOhidLessThanOrEqualTo(Integer value) {
            addCriterion("ohid <=", value, "ohid");
            return (Criteria) this;
        }

        public Criteria andOhidIn(List<Integer> values) {
            addCriterion("ohid in", values, "ohid");
            return (Criteria) this;
        }

        public Criteria andOhidNotIn(List<Integer> values) {
            addCriterion("ohid not in", values, "ohid");
            return (Criteria) this;
        }

        public Criteria andOhidBetween(Integer value1, Integer value2) {
            addCriterion("ohid between", value1, value2, "ohid");
            return (Criteria) this;
        }

        public Criteria andOhidNotBetween(Integer value1, Integer value2) {
            addCriterion("ohid not between", value1, value2, "ohid");
            return (Criteria) this;
        }

        public Criteria andMidIsNull() {
            addCriterion("mid is null");
            return (Criteria) this;
        }

        public Criteria andMidIsNotNull() {
            addCriterion("mid is not null");
            return (Criteria) this;
        }

        public Criteria andMidEqualTo(Integer value) {
            addCriterion("mid =", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidNotEqualTo(Integer value) {
            addCriterion("mid <>", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidGreaterThan(Integer value) {
            addCriterion("mid >", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidGreaterThanOrEqualTo(Integer value) {
            addCriterion("mid >=", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidLessThan(Integer value) {
            addCriterion("mid <", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidLessThanOrEqualTo(Integer value) {
            addCriterion("mid <=", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidIn(List<Integer> values) {
            addCriterion("mid in", values, "mid");
            return (Criteria) this;
        }

        public Criteria andMidNotIn(List<Integer> values) {
            addCriterion("mid not in", values, "mid");
            return (Criteria) this;
        }

        public Criteria andMidBetween(Integer value1, Integer value2) {
            addCriterion("mid between", value1, value2, "mid");
            return (Criteria) this;
        }

        public Criteria andMidNotBetween(Integer value1, Integer value2) {
            addCriterion("mid not between", value1, value2, "mid");
            return (Criteria) this;
        }

        public Criteria andMnameIsNull() {
            addCriterion("mname is null");
            return (Criteria) this;
        }

        public Criteria andMnameIsNotNull() {
            addCriterion("mname is not null");
            return (Criteria) this;
        }

        public Criteria andMnameEqualTo(String value) {
            addCriterion("mname =", value, "mname");
            return (Criteria) this;
        }

        public Criteria andMnameNotEqualTo(String value) {
            addCriterion("mname <>", value, "mname");
            return (Criteria) this;
        }

        public Criteria andMnameGreaterThan(String value) {
            addCriterion("mname >", value, "mname");
            return (Criteria) this;
        }

        public Criteria andMnameGreaterThanOrEqualTo(String value) {
            addCriterion("mname >=", value, "mname");
            return (Criteria) this;
        }

        public Criteria andMnameLessThan(String value) {
            addCriterion("mname <", value, "mname");
            return (Criteria) this;
        }

        public Criteria andMnameLessThanOrEqualTo(String value) {
            addCriterion("mname <=", value, "mname");
            return (Criteria) this;
        }

        public Criteria andMnameLike(String value) {
            addCriterion("mname like", value, "mname");
            return (Criteria) this;
        }

        public Criteria andMnameNotLike(String value) {
            addCriterion("mname not like", value, "mname");
            return (Criteria) this;
        }

        public Criteria andMnameIn(List<String> values) {
            addCriterion("mname in", values, "mname");
            return (Criteria) this;
        }

        public Criteria andMnameNotIn(List<String> values) {
            addCriterion("mname not in", values, "mname");
            return (Criteria) this;
        }

        public Criteria andMnameBetween(String value1, String value2) {
            addCriterion("mname between", value1, value2, "mname");
            return (Criteria) this;
        }

        public Criteria andMnameNotBetween(String value1, String value2) {
            addCriterion("mname not between", value1, value2, "mname");
            return (Criteria) this;
        }

        public Criteria andWhidIsNull() {
            addCriterion("whid is null");
            return (Criteria) this;
        }

        public Criteria andWhidIsNotNull() {
            addCriterion("whid is not null");
            return (Criteria) this;
        }

        public Criteria andWhidEqualTo(Integer value) {
            addCriterion("whid =", value, "whid");
            return (Criteria) this;
        }

        public Criteria andWhidNotEqualTo(Integer value) {
            addCriterion("whid <>", value, "whid");
            return (Criteria) this;
        }

        public Criteria andWhidGreaterThan(Integer value) {
            addCriterion("whid >", value, "whid");
            return (Criteria) this;
        }

        public Criteria andWhidGreaterThanOrEqualTo(Integer value) {
            addCriterion("whid >=", value, "whid");
            return (Criteria) this;
        }

        public Criteria andWhidLessThan(Integer value) {
            addCriterion("whid <", value, "whid");
            return (Criteria) this;
        }

        public Criteria andWhidLessThanOrEqualTo(Integer value) {
            addCriterion("whid <=", value, "whid");
            return (Criteria) this;
        }

        public Criteria andWhidIn(List<Integer> values) {
            addCriterion("whid in", values, "whid");
            return (Criteria) this;
        }

        public Criteria andWhidNotIn(List<Integer> values) {
            addCriterion("whid not in", values, "whid");
            return (Criteria) this;
        }

        public Criteria andWhidBetween(Integer value1, Integer value2) {
            addCriterion("whid between", value1, value2, "whid");
            return (Criteria) this;
        }

        public Criteria andWhidNotBetween(Integer value1, Integer value2) {
            addCriterion("whid not between", value1, value2, "whid");
            return (Criteria) this;
        }

        public Criteria andWhnameIsNull() {
            addCriterion("whname is null");
            return (Criteria) this;
        }

        public Criteria andWhnameIsNotNull() {
            addCriterion("whname is not null");
            return (Criteria) this;
        }

        public Criteria andWhnameEqualTo(String value) {
            addCriterion("whname =", value, "whname");
            return (Criteria) this;
        }

        public Criteria andWhnameNotEqualTo(String value) {
            addCriterion("whname <>", value, "whname");
            return (Criteria) this;
        }

        public Criteria andWhnameGreaterThan(String value) {
            addCriterion("whname >", value, "whname");
            return (Criteria) this;
        }

        public Criteria andWhnameGreaterThanOrEqualTo(String value) {
            addCriterion("whname >=", value, "whname");
            return (Criteria) this;
        }

        public Criteria andWhnameLessThan(String value) {
            addCriterion("whname <", value, "whname");
            return (Criteria) this;
        }

        public Criteria andWhnameLessThanOrEqualTo(String value) {
            addCriterion("whname <=", value, "whname");
            return (Criteria) this;
        }

        public Criteria andWhnameLike(String value) {
            addCriterion("whname like", value, "whname");
            return (Criteria) this;
        }

        public Criteria andWhnameNotLike(String value) {
            addCriterion("whname not like", value, "whname");
            return (Criteria) this;
        }

        public Criteria andWhnameIn(List<String> values) {
            addCriterion("whname in", values, "whname");
            return (Criteria) this;
        }

        public Criteria andWhnameNotIn(List<String> values) {
            addCriterion("whname not in", values, "whname");
            return (Criteria) this;
        }

        public Criteria andWhnameBetween(String value1, String value2) {
            addCriterion("whname between", value1, value2, "whname");
            return (Criteria) this;
        }

        public Criteria andWhnameNotBetween(String value1, String value2) {
            addCriterion("whname not between", value1, value2, "whname");
            return (Criteria) this;
        }

        public Criteria andSidIsNull() {
            addCriterion("sid is null");
            return (Criteria) this;
        }

        public Criteria andSidIsNotNull() {
            addCriterion("sid is not null");
            return (Criteria) this;
        }

        public Criteria andSidEqualTo(Integer value) {
            addCriterion("sid =", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotEqualTo(Integer value) {
            addCriterion("sid <>", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidGreaterThan(Integer value) {
            addCriterion("sid >", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidGreaterThanOrEqualTo(Integer value) {
            addCriterion("sid >=", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidLessThan(Integer value) {
            addCriterion("sid <", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidLessThanOrEqualTo(Integer value) {
            addCriterion("sid <=", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidIn(List<Integer> values) {
            addCriterion("sid in", values, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotIn(List<Integer> values) {
            addCriterion("sid not in", values, "sid");
            return (Criteria) this;
        }

        public Criteria andSidBetween(Integer value1, Integer value2) {
            addCriterion("sid between", value1, value2, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotBetween(Integer value1, Integer value2) {
            addCriterion("sid not between", value1, value2, "sid");
            return (Criteria) this;
        }

        public Criteria andStocknameIsNull() {
            addCriterion("stockname is null");
            return (Criteria) this;
        }

        public Criteria andStocknameIsNotNull() {
            addCriterion("stockname is not null");
            return (Criteria) this;
        }

        public Criteria andStocknameEqualTo(String value) {
            addCriterion("stockname =", value, "stockname");
            return (Criteria) this;
        }

        public Criteria andStocknameNotEqualTo(String value) {
            addCriterion("stockname <>", value, "stockname");
            return (Criteria) this;
        }

        public Criteria andStocknameGreaterThan(String value) {
            addCriterion("stockname >", value, "stockname");
            return (Criteria) this;
        }

        public Criteria andStocknameGreaterThanOrEqualTo(String value) {
            addCriterion("stockname >=", value, "stockname");
            return (Criteria) this;
        }

        public Criteria andStocknameLessThan(String value) {
            addCriterion("stockname <", value, "stockname");
            return (Criteria) this;
        }

        public Criteria andStocknameLessThanOrEqualTo(String value) {
            addCriterion("stockname <=", value, "stockname");
            return (Criteria) this;
        }

        public Criteria andStocknameLike(String value) {
            addCriterion("stockname like", value, "stockname");
            return (Criteria) this;
        }

        public Criteria andStocknameNotLike(String value) {
            addCriterion("stockname not like", value, "stockname");
            return (Criteria) this;
        }

        public Criteria andStocknameIn(List<String> values) {
            addCriterion("stockname in", values, "stockname");
            return (Criteria) this;
        }

        public Criteria andStocknameNotIn(List<String> values) {
            addCriterion("stockname not in", values, "stockname");
            return (Criteria) this;
        }

        public Criteria andStocknameBetween(String value1, String value2) {
            addCriterion("stockname between", value1, value2, "stockname");
            return (Criteria) this;
        }

        public Criteria andStocknameNotBetween(String value1, String value2) {
            addCriterion("stockname not between", value1, value2, "stockname");
            return (Criteria) this;
        }

        public Criteria andNnumIsNull() {
            addCriterion("nnum is null");
            return (Criteria) this;
        }

        public Criteria andNnumIsNotNull() {
            addCriterion("nnum is not null");
            return (Criteria) this;
        }

        public Criteria andNnumEqualTo(Integer value) {
            addCriterion("nnum =", value, "nnum");
            return (Criteria) this;
        }

        public Criteria andNnumNotEqualTo(Integer value) {
            addCriterion("nnum <>", value, "nnum");
            return (Criteria) this;
        }

        public Criteria andNnumGreaterThan(Integer value) {
            addCriterion("nnum >", value, "nnum");
            return (Criteria) this;
        }

        public Criteria andNnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("nnum >=", value, "nnum");
            return (Criteria) this;
        }

        public Criteria andNnumLessThan(Integer value) {
            addCriterion("nnum <", value, "nnum");
            return (Criteria) this;
        }

        public Criteria andNnumLessThanOrEqualTo(Integer value) {
            addCriterion("nnum <=", value, "nnum");
            return (Criteria) this;
        }

        public Criteria andNnumIn(List<Integer> values) {
            addCriterion("nnum in", values, "nnum");
            return (Criteria) this;
        }

        public Criteria andNnumNotIn(List<Integer> values) {
            addCriterion("nnum not in", values, "nnum");
            return (Criteria) this;
        }

        public Criteria andNnumBetween(Integer value1, Integer value2) {
            addCriterion("nnum between", value1, value2, "nnum");
            return (Criteria) this;
        }

        public Criteria andNnumNotBetween(Integer value1, Integer value2) {
            addCriterion("nnum not between", value1, value2, "nnum");
            return (Criteria) this;
        }

        public Criteria andVolumnIsNull() {
            addCriterion("volumn is null");
            return (Criteria) this;
        }

        public Criteria andVolumnIsNotNull() {
            addCriterion("volumn is not null");
            return (Criteria) this;
        }

        public Criteria andVolumnEqualTo(Double value) {
            addCriterion("volumn =", value, "volumn");
            return (Criteria) this;
        }

        public Criteria andVolumnNotEqualTo(Double value) {
            addCriterion("volumn <>", value, "volumn");
            return (Criteria) this;
        }

        public Criteria andVolumnGreaterThan(Double value) {
            addCriterion("volumn >", value, "volumn");
            return (Criteria) this;
        }

        public Criteria andVolumnGreaterThanOrEqualTo(Double value) {
            addCriterion("volumn >=", value, "volumn");
            return (Criteria) this;
        }

        public Criteria andVolumnLessThan(Double value) {
            addCriterion("volumn <", value, "volumn");
            return (Criteria) this;
        }

        public Criteria andVolumnLessThanOrEqualTo(Double value) {
            addCriterion("volumn <=", value, "volumn");
            return (Criteria) this;
        }

        public Criteria andVolumnIn(List<Double> values) {
            addCriterion("volumn in", values, "volumn");
            return (Criteria) this;
        }

        public Criteria andVolumnNotIn(List<Double> values) {
            addCriterion("volumn not in", values, "volumn");
            return (Criteria) this;
        }

        public Criteria andVolumnBetween(Double value1, Double value2) {
            addCriterion("volumn between", value1, value2, "volumn");
            return (Criteria) this;
        }

        public Criteria andVolumnNotBetween(Double value1, Double value2) {
            addCriterion("volumn not between", value1, value2, "volumn");
            return (Criteria) this;
        }

        public Criteria andWeightIsNull() {
            addCriterion("weight is null");
            return (Criteria) this;
        }

        public Criteria andWeightIsNotNull() {
            addCriterion("weight is not null");
            return (Criteria) this;
        }

        public Criteria andWeightEqualTo(Double value) {
            addCriterion("weight =", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotEqualTo(Double value) {
            addCriterion("weight <>", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThan(Double value) {
            addCriterion("weight >", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThanOrEqualTo(Double value) {
            addCriterion("weight >=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThan(Double value) {
            addCriterion("weight <", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThanOrEqualTo(Double value) {
            addCriterion("weight <=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightIn(List<Double> values) {
            addCriterion("weight in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotIn(List<Double> values) {
            addCriterion("weight not in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightBetween(Double value1, Double value2) {
            addCriterion("weight between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotBetween(Double value1, Double value2) {
            addCriterion("weight not between", value1, value2, "weight");
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