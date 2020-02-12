package cn.bsnmdpf.fcprt.api.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ActivityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ActivityExample() {
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

        public Criteria andAidIsNull() {
            addCriterion("aid is null");
            return (Criteria) this;
        }

        public Criteria andAidIsNotNull() {
            addCriterion("aid is not null");
            return (Criteria) this;
        }

        public Criteria andAidEqualTo(Integer value) {
            addCriterion("aid =", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidNotEqualTo(Integer value) {
            addCriterion("aid <>", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidGreaterThan(Integer value) {
            addCriterion("aid >", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidGreaterThanOrEqualTo(Integer value) {
            addCriterion("aid >=", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidLessThan(Integer value) {
            addCriterion("aid <", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidLessThanOrEqualTo(Integer value) {
            addCriterion("aid <=", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidIn(List<Integer> values) {
            addCriterion("aid in", values, "aid");
            return (Criteria) this;
        }

        public Criteria andAidNotIn(List<Integer> values) {
            addCriterion("aid not in", values, "aid");
            return (Criteria) this;
        }

        public Criteria andAidBetween(Integer value1, Integer value2) {
            addCriterion("aid between", value1, value2, "aid");
            return (Criteria) this;
        }

        public Criteria andAidNotBetween(Integer value1, Integer value2) {
            addCriterion("aid not between", value1, value2, "aid");
            return (Criteria) this;
        }

        public Criteria andActivitynameIsNull() {
            addCriterion("activityname is null");
            return (Criteria) this;
        }

        public Criteria andActivitynameIsNotNull() {
            addCriterion("activityname is not null");
            return (Criteria) this;
        }

        public Criteria andActivitynameEqualTo(String value) {
            addCriterion("activityname =", value, "activityname");
            return (Criteria) this;
        }

        public Criteria andActivitynameNotEqualTo(String value) {
            addCriterion("activityname <>", value, "activityname");
            return (Criteria) this;
        }

        public Criteria andActivitynameGreaterThan(String value) {
            addCriterion("activityname >", value, "activityname");
            return (Criteria) this;
        }

        public Criteria andActivitynameGreaterThanOrEqualTo(String value) {
            addCriterion("activityname >=", value, "activityname");
            return (Criteria) this;
        }

        public Criteria andActivitynameLessThan(String value) {
            addCriterion("activityname <", value, "activityname");
            return (Criteria) this;
        }

        public Criteria andActivitynameLessThanOrEqualTo(String value) {
            addCriterion("activityname <=", value, "activityname");
            return (Criteria) this;
        }

        public Criteria andActivitynameLike(String value) {
            addCriterion("activityname like", value, "activityname");
            return (Criteria) this;
        }

        public Criteria andActivitynameNotLike(String value) {
            addCriterion("activityname not like", value, "activityname");
            return (Criteria) this;
        }

        public Criteria andActivitynameIn(List<String> values) {
            addCriterion("activityname in", values, "activityname");
            return (Criteria) this;
        }

        public Criteria andActivitynameNotIn(List<String> values) {
            addCriterion("activityname not in", values, "activityname");
            return (Criteria) this;
        }

        public Criteria andActivitynameBetween(String value1, String value2) {
            addCriterion("activityname between", value1, value2, "activityname");
            return (Criteria) this;
        }

        public Criteria andActivitynameNotBetween(String value1, String value2) {
            addCriterion("activityname not between", value1, value2, "activityname");
            return (Criteria) this;
        }

        public Criteria andAtypeIsNull() {
            addCriterion("atype is null");
            return (Criteria) this;
        }

        public Criteria andAtypeIsNotNull() {
            addCriterion("atype is not null");
            return (Criteria) this;
        }

        public Criteria andAtypeEqualTo(String value) {
            addCriterion("atype =", value, "atype");
            return (Criteria) this;
        }

        public Criteria andAtypeNotEqualTo(String value) {
            addCriterion("atype <>", value, "atype");
            return (Criteria) this;
        }

        public Criteria andAtypeGreaterThan(String value) {
            addCriterion("atype >", value, "atype");
            return (Criteria) this;
        }

        public Criteria andAtypeGreaterThanOrEqualTo(String value) {
            addCriterion("atype >=", value, "atype");
            return (Criteria) this;
        }

        public Criteria andAtypeLessThan(String value) {
            addCriterion("atype <", value, "atype");
            return (Criteria) this;
        }

        public Criteria andAtypeLessThanOrEqualTo(String value) {
            addCriterion("atype <=", value, "atype");
            return (Criteria) this;
        }

        public Criteria andAtypeLike(String value) {
            addCriterion("atype like", value, "atype");
            return (Criteria) this;
        }

        public Criteria andAtypeNotLike(String value) {
            addCriterion("atype not like", value, "atype");
            return (Criteria) this;
        }

        public Criteria andAtypeIn(List<String> values) {
            addCriterion("atype in", values, "atype");
            return (Criteria) this;
        }

        public Criteria andAtypeNotIn(List<String> values) {
            addCriterion("atype not in", values, "atype");
            return (Criteria) this;
        }

        public Criteria andAtypeBetween(String value1, String value2) {
            addCriterion("atype between", value1, value2, "atype");
            return (Criteria) this;
        }

        public Criteria andAtypeNotBetween(String value1, String value2) {
            addCriterion("atype not between", value1, value2, "atype");
            return (Criteria) this;
        }

        public Criteria andOperatorIsNull() {
            addCriterion("operator is null");
            return (Criteria) this;
        }

        public Criteria andOperatorIsNotNull() {
            addCriterion("operator is not null");
            return (Criteria) this;
        }

        public Criteria andOperatorEqualTo(String value) {
            addCriterion("operator =", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotEqualTo(String value) {
            addCriterion("operator <>", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorGreaterThan(String value) {
            addCriterion("operator >", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorGreaterThanOrEqualTo(String value) {
            addCriterion("operator >=", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLessThan(String value) {
            addCriterion("operator <", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLessThanOrEqualTo(String value) {
            addCriterion("operator <=", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLike(String value) {
            addCriterion("operator like", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotLike(String value) {
            addCriterion("operator not like", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorIn(List<String> values) {
            addCriterion("operator in", values, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotIn(List<String> values) {
            addCriterion("operator not in", values, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorBetween(String value1, String value2) {
            addCriterion("operator between", value1, value2, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotBetween(String value1, String value2) {
            addCriterion("operator not between", value1, value2, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorphoneIsNull() {
            addCriterion("operatorPhone is null");
            return (Criteria) this;
        }

        public Criteria andOperatorphoneIsNotNull() {
            addCriterion("operatorPhone is not null");
            return (Criteria) this;
        }

        public Criteria andOperatorphoneEqualTo(String value) {
            addCriterion("operatorPhone =", value, "operatorphone");
            return (Criteria) this;
        }

        public Criteria andOperatorphoneNotEqualTo(String value) {
            addCriterion("operatorPhone <>", value, "operatorphone");
            return (Criteria) this;
        }

        public Criteria andOperatorphoneGreaterThan(String value) {
            addCriterion("operatorPhone >", value, "operatorphone");
            return (Criteria) this;
        }

        public Criteria andOperatorphoneGreaterThanOrEqualTo(String value) {
            addCriterion("operatorPhone >=", value, "operatorphone");
            return (Criteria) this;
        }

        public Criteria andOperatorphoneLessThan(String value) {
            addCriterion("operatorPhone <", value, "operatorphone");
            return (Criteria) this;
        }

        public Criteria andOperatorphoneLessThanOrEqualTo(String value) {
            addCriterion("operatorPhone <=", value, "operatorphone");
            return (Criteria) this;
        }

        public Criteria andOperatorphoneLike(String value) {
            addCriterion("operatorPhone like", value, "operatorphone");
            return (Criteria) this;
        }

        public Criteria andOperatorphoneNotLike(String value) {
            addCriterion("operatorPhone not like", value, "operatorphone");
            return (Criteria) this;
        }

        public Criteria andOperatorphoneIn(List<String> values) {
            addCriterion("operatorPhone in", values, "operatorphone");
            return (Criteria) this;
        }

        public Criteria andOperatorphoneNotIn(List<String> values) {
            addCriterion("operatorPhone not in", values, "operatorphone");
            return (Criteria) this;
        }

        public Criteria andOperatorphoneBetween(String value1, String value2) {
            addCriterion("operatorPhone between", value1, value2, "operatorphone");
            return (Criteria) this;
        }

        public Criteria andOperatorphoneNotBetween(String value1, String value2) {
            addCriterion("operatorPhone not between", value1, value2, "operatorphone");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createTime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("createTime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("createTime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("createTime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createTime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("createTime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("createTime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("createTime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("createTime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("createTime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("createTime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andBegintimeIsNull() {
            addCriterion("beginTime is null");
            return (Criteria) this;
        }

        public Criteria andBegintimeIsNotNull() {
            addCriterion("beginTime is not null");
            return (Criteria) this;
        }

        public Criteria andBegintimeEqualTo(Date value) {
            addCriterion("beginTime =", value, "begintime");
            return (Criteria) this;
        }

        public Criteria andBegintimeNotEqualTo(Date value) {
            addCriterion("beginTime <>", value, "begintime");
            return (Criteria) this;
        }

        public Criteria andBegintimeGreaterThan(Date value) {
            addCriterion("beginTime >", value, "begintime");
            return (Criteria) this;
        }

        public Criteria andBegintimeGreaterThanOrEqualTo(Date value) {
            addCriterion("beginTime >=", value, "begintime");
            return (Criteria) this;
        }

        public Criteria andBegintimeLessThan(Date value) {
            addCriterion("beginTime <", value, "begintime");
            return (Criteria) this;
        }

        public Criteria andBegintimeLessThanOrEqualTo(Date value) {
            addCriterion("beginTime <=", value, "begintime");
            return (Criteria) this;
        }

        public Criteria andBegintimeIn(List<Date> values) {
            addCriterion("beginTime in", values, "begintime");
            return (Criteria) this;
        }

        public Criteria andBegintimeNotIn(List<Date> values) {
            addCriterion("beginTime not in", values, "begintime");
            return (Criteria) this;
        }

        public Criteria andBegintimeBetween(Date value1, Date value2) {
            addCriterion("beginTime between", value1, value2, "begintime");
            return (Criteria) this;
        }

        public Criteria andBegintimeNotBetween(Date value1, Date value2) {
            addCriterion("beginTime not between", value1, value2, "begintime");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNull() {
            addCriterion("endTime is null");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNotNull() {
            addCriterion("endTime is not null");
            return (Criteria) this;
        }

        public Criteria andEndtimeEqualTo(Date value) {
            addCriterion("endTime =", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotEqualTo(Date value) {
            addCriterion("endTime <>", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThan(Date value) {
            addCriterion("endTime >", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("endTime >=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThan(Date value) {
            addCriterion("endTime <", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThanOrEqualTo(Date value) {
            addCriterion("endTime <=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeIn(List<Date> values) {
            addCriterion("endTime in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotIn(List<Date> values) {
            addCriterion("endTime not in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeBetween(Date value1, Date value2) {
            addCriterion("endTime between", value1, value2, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotBetween(Date value1, Date value2) {
            addCriterion("endTime not between", value1, value2, "endtime");
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

        public Criteria andMtagIsNull() {
            addCriterion("mtag is null");
            return (Criteria) this;
        }

        public Criteria andMtagIsNotNull() {
            addCriterion("mtag is not null");
            return (Criteria) this;
        }

        public Criteria andMtagEqualTo(String value) {
            addCriterion("mtag =", value, "mtag");
            return (Criteria) this;
        }

        public Criteria andMtagNotEqualTo(String value) {
            addCriterion("mtag <>", value, "mtag");
            return (Criteria) this;
        }

        public Criteria andMtagGreaterThan(String value) {
            addCriterion("mtag >", value, "mtag");
            return (Criteria) this;
        }

        public Criteria andMtagGreaterThanOrEqualTo(String value) {
            addCriterion("mtag >=", value, "mtag");
            return (Criteria) this;
        }

        public Criteria andMtagLessThan(String value) {
            addCriterion("mtag <", value, "mtag");
            return (Criteria) this;
        }

        public Criteria andMtagLessThanOrEqualTo(String value) {
            addCriterion("mtag <=", value, "mtag");
            return (Criteria) this;
        }

        public Criteria andMtagLike(String value) {
            addCriterion("mtag like", value, "mtag");
            return (Criteria) this;
        }

        public Criteria andMtagNotLike(String value) {
            addCriterion("mtag not like", value, "mtag");
            return (Criteria) this;
        }

        public Criteria andMtagIn(List<String> values) {
            addCriterion("mtag in", values, "mtag");
            return (Criteria) this;
        }

        public Criteria andMtagNotIn(List<String> values) {
            addCriterion("mtag not in", values, "mtag");
            return (Criteria) this;
        }

        public Criteria andMtagBetween(String value1, String value2) {
            addCriterion("mtag between", value1, value2, "mtag");
            return (Criteria) this;
        }

        public Criteria andMtagNotBetween(String value1, String value2) {
            addCriterion("mtag not between", value1, value2, "mtag");
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

        public Criteria andMoneyIsNull() {
            addCriterion("money is null");
            return (Criteria) this;
        }

        public Criteria andMoneyIsNotNull() {
            addCriterion("money is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyEqualTo(Double value) {
            addCriterion("money =", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotEqualTo(Double value) {
            addCriterion("money <>", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyGreaterThan(Double value) {
            addCriterion("money >", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("money >=", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLessThan(Double value) {
            addCriterion("money <", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLessThanOrEqualTo(Double value) {
            addCriterion("money <=", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyIn(List<Double> values) {
            addCriterion("money in", values, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotIn(List<Double> values) {
            addCriterion("money not in", values, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyBetween(Double value1, Double value2) {
            addCriterion("money between", value1, value2, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotBetween(Double value1, Double value2) {
            addCriterion("money not between", value1, value2, "money");
            return (Criteria) this;
        }

        public Criteria andMinviplevelIsNull() {
            addCriterion("minVipLevel is null");
            return (Criteria) this;
        }

        public Criteria andMinviplevelIsNotNull() {
            addCriterion("minVipLevel is not null");
            return (Criteria) this;
        }

        public Criteria andMinviplevelEqualTo(Integer value) {
            addCriterion("minVipLevel =", value, "minviplevel");
            return (Criteria) this;
        }

        public Criteria andMinviplevelNotEqualTo(Integer value) {
            addCriterion("minVipLevel <>", value, "minviplevel");
            return (Criteria) this;
        }

        public Criteria andMinviplevelGreaterThan(Integer value) {
            addCriterion("minVipLevel >", value, "minviplevel");
            return (Criteria) this;
        }

        public Criteria andMinviplevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("minVipLevel >=", value, "minviplevel");
            return (Criteria) this;
        }

        public Criteria andMinviplevelLessThan(Integer value) {
            addCriterion("minVipLevel <", value, "minviplevel");
            return (Criteria) this;
        }

        public Criteria andMinviplevelLessThanOrEqualTo(Integer value) {
            addCriterion("minVipLevel <=", value, "minviplevel");
            return (Criteria) this;
        }

        public Criteria andMinviplevelIn(List<Integer> values) {
            addCriterion("minVipLevel in", values, "minviplevel");
            return (Criteria) this;
        }

        public Criteria andMinviplevelNotIn(List<Integer> values) {
            addCriterion("minVipLevel not in", values, "minviplevel");
            return (Criteria) this;
        }

        public Criteria andMinviplevelBetween(Integer value1, Integer value2) {
            addCriterion("minVipLevel between", value1, value2, "minviplevel");
            return (Criteria) this;
        }

        public Criteria andMinviplevelNotBetween(Integer value1, Integer value2) {
            addCriterion("minVipLevel not between", value1, value2, "minviplevel");
            return (Criteria) this;
        }

        public Criteria andMaxviplevelIsNull() {
            addCriterion("maxVipLevel is null");
            return (Criteria) this;
        }

        public Criteria andMaxviplevelIsNotNull() {
            addCriterion("maxVipLevel is not null");
            return (Criteria) this;
        }

        public Criteria andMaxviplevelEqualTo(Integer value) {
            addCriterion("maxVipLevel =", value, "maxviplevel");
            return (Criteria) this;
        }

        public Criteria andMaxviplevelNotEqualTo(Integer value) {
            addCriterion("maxVipLevel <>", value, "maxviplevel");
            return (Criteria) this;
        }

        public Criteria andMaxviplevelGreaterThan(Integer value) {
            addCriterion("maxVipLevel >", value, "maxviplevel");
            return (Criteria) this;
        }

        public Criteria andMaxviplevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("maxVipLevel >=", value, "maxviplevel");
            return (Criteria) this;
        }

        public Criteria andMaxviplevelLessThan(Integer value) {
            addCriterion("maxVipLevel <", value, "maxviplevel");
            return (Criteria) this;
        }

        public Criteria andMaxviplevelLessThanOrEqualTo(Integer value) {
            addCriterion("maxVipLevel <=", value, "maxviplevel");
            return (Criteria) this;
        }

        public Criteria andMaxviplevelIn(List<Integer> values) {
            addCriterion("maxVipLevel in", values, "maxviplevel");
            return (Criteria) this;
        }

        public Criteria andMaxviplevelNotIn(List<Integer> values) {
            addCriterion("maxVipLevel not in", values, "maxviplevel");
            return (Criteria) this;
        }

        public Criteria andMaxviplevelBetween(Integer value1, Integer value2) {
            addCriterion("maxVipLevel between", value1, value2, "maxviplevel");
            return (Criteria) this;
        }

        public Criteria andMaxviplevelNotBetween(Integer value1, Integer value2) {
            addCriterion("maxVipLevel not between", value1, value2, "maxviplevel");
            return (Criteria) this;
        }

        public Criteria andFullreductionmoneyIsNull() {
            addCriterion("fullReductionMoney is null");
            return (Criteria) this;
        }

        public Criteria andFullreductionmoneyIsNotNull() {
            addCriterion("fullReductionMoney is not null");
            return (Criteria) this;
        }

        public Criteria andFullreductionmoneyEqualTo(Double value) {
            addCriterion("fullReductionMoney =", value, "fullreductionmoney");
            return (Criteria) this;
        }

        public Criteria andFullreductionmoneyNotEqualTo(Double value) {
            addCriterion("fullReductionMoney <>", value, "fullreductionmoney");
            return (Criteria) this;
        }

        public Criteria andFullreductionmoneyGreaterThan(Double value) {
            addCriterion("fullReductionMoney >", value, "fullreductionmoney");
            return (Criteria) this;
        }

        public Criteria andFullreductionmoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("fullReductionMoney >=", value, "fullreductionmoney");
            return (Criteria) this;
        }

        public Criteria andFullreductionmoneyLessThan(Double value) {
            addCriterion("fullReductionMoney <", value, "fullreductionmoney");
            return (Criteria) this;
        }

        public Criteria andFullreductionmoneyLessThanOrEqualTo(Double value) {
            addCriterion("fullReductionMoney <=", value, "fullreductionmoney");
            return (Criteria) this;
        }

        public Criteria andFullreductionmoneyIn(List<Double> values) {
            addCriterion("fullReductionMoney in", values, "fullreductionmoney");
            return (Criteria) this;
        }

        public Criteria andFullreductionmoneyNotIn(List<Double> values) {
            addCriterion("fullReductionMoney not in", values, "fullreductionmoney");
            return (Criteria) this;
        }

        public Criteria andFullreductionmoneyBetween(Double value1, Double value2) {
            addCriterion("fullReductionMoney between", value1, value2, "fullreductionmoney");
            return (Criteria) this;
        }

        public Criteria andFullreductionmoneyNotBetween(Double value1, Double value2) {
            addCriterion("fullReductionMoney not between", value1, value2, "fullreductionmoney");
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