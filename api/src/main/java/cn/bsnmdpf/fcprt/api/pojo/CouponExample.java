package cn.bsnmdpf.fcprt.api.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CouponExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CouponExample() {
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

        public Criteria andCpidIsNull() {
            addCriterion("cpid is null");
            return (Criteria) this;
        }

        public Criteria andCpidIsNotNull() {
            addCriterion("cpid is not null");
            return (Criteria) this;
        }

        public Criteria andCpidEqualTo(Integer value) {
            addCriterion("cpid =", value, "cpid");
            return (Criteria) this;
        }

        public Criteria andCpidNotEqualTo(Integer value) {
            addCriterion("cpid <>", value, "cpid");
            return (Criteria) this;
        }

        public Criteria andCpidGreaterThan(Integer value) {
            addCriterion("cpid >", value, "cpid");
            return (Criteria) this;
        }

        public Criteria andCpidGreaterThanOrEqualTo(Integer value) {
            addCriterion("cpid >=", value, "cpid");
            return (Criteria) this;
        }

        public Criteria andCpidLessThan(Integer value) {
            addCriterion("cpid <", value, "cpid");
            return (Criteria) this;
        }

        public Criteria andCpidLessThanOrEqualTo(Integer value) {
            addCriterion("cpid <=", value, "cpid");
            return (Criteria) this;
        }

        public Criteria andCpidIn(List<Integer> values) {
            addCriterion("cpid in", values, "cpid");
            return (Criteria) this;
        }

        public Criteria andCpidNotIn(List<Integer> values) {
            addCriterion("cpid not in", values, "cpid");
            return (Criteria) this;
        }

        public Criteria andCpidBetween(Integer value1, Integer value2) {
            addCriterion("cpid between", value1, value2, "cpid");
            return (Criteria) this;
        }

        public Criteria andCpidNotBetween(Integer value1, Integer value2) {
            addCriterion("cpid not between", value1, value2, "cpid");
            return (Criteria) this;
        }

        public Criteria andCouponnameIsNull() {
            addCriterion("couponname is null");
            return (Criteria) this;
        }

        public Criteria andCouponnameIsNotNull() {
            addCriterion("couponname is not null");
            return (Criteria) this;
        }

        public Criteria andCouponnameEqualTo(String value) {
            addCriterion("couponname =", value, "couponname");
            return (Criteria) this;
        }

        public Criteria andCouponnameNotEqualTo(String value) {
            addCriterion("couponname <>", value, "couponname");
            return (Criteria) this;
        }

        public Criteria andCouponnameGreaterThan(String value) {
            addCriterion("couponname >", value, "couponname");
            return (Criteria) this;
        }

        public Criteria andCouponnameGreaterThanOrEqualTo(String value) {
            addCriterion("couponname >=", value, "couponname");
            return (Criteria) this;
        }

        public Criteria andCouponnameLessThan(String value) {
            addCriterion("couponname <", value, "couponname");
            return (Criteria) this;
        }

        public Criteria andCouponnameLessThanOrEqualTo(String value) {
            addCriterion("couponname <=", value, "couponname");
            return (Criteria) this;
        }

        public Criteria andCouponnameLike(String value) {
            addCriterion("couponname like", value, "couponname");
            return (Criteria) this;
        }

        public Criteria andCouponnameNotLike(String value) {
            addCriterion("couponname not like", value, "couponname");
            return (Criteria) this;
        }

        public Criteria andCouponnameIn(List<String> values) {
            addCriterion("couponname in", values, "couponname");
            return (Criteria) this;
        }

        public Criteria andCouponnameNotIn(List<String> values) {
            addCriterion("couponname not in", values, "couponname");
            return (Criteria) this;
        }

        public Criteria andCouponnameBetween(String value1, String value2) {
            addCriterion("couponname between", value1, value2, "couponname");
            return (Criteria) this;
        }

        public Criteria andCouponnameNotBetween(String value1, String value2) {
            addCriterion("couponname not between", value1, value2, "couponname");
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

        public Criteria andDescmoneyIsNull() {
            addCriterion("descMoney is null");
            return (Criteria) this;
        }

        public Criteria andDescmoneyIsNotNull() {
            addCriterion("descMoney is not null");
            return (Criteria) this;
        }

        public Criteria andDescmoneyEqualTo(Double value) {
            addCriterion("descMoney =", value, "descmoney");
            return (Criteria) this;
        }

        public Criteria andDescmoneyNotEqualTo(Double value) {
            addCriterion("descMoney <>", value, "descmoney");
            return (Criteria) this;
        }

        public Criteria andDescmoneyGreaterThan(Double value) {
            addCriterion("descMoney >", value, "descmoney");
            return (Criteria) this;
        }

        public Criteria andDescmoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("descMoney >=", value, "descmoney");
            return (Criteria) this;
        }

        public Criteria andDescmoneyLessThan(Double value) {
            addCriterion("descMoney <", value, "descmoney");
            return (Criteria) this;
        }

        public Criteria andDescmoneyLessThanOrEqualTo(Double value) {
            addCriterion("descMoney <=", value, "descmoney");
            return (Criteria) this;
        }

        public Criteria andDescmoneyIn(List<Double> values) {
            addCriterion("descMoney in", values, "descmoney");
            return (Criteria) this;
        }

        public Criteria andDescmoneyNotIn(List<Double> values) {
            addCriterion("descMoney not in", values, "descmoney");
            return (Criteria) this;
        }

        public Criteria andDescmoneyBetween(Double value1, Double value2) {
            addCriterion("descMoney between", value1, value2, "descmoney");
            return (Criteria) this;
        }

        public Criteria andDescmoneyNotBetween(Double value1, Double value2) {
            addCriterion("descMoney not between", value1, value2, "descmoney");
            return (Criteria) this;
        }

        public Criteria andNeedmoneyIsNull() {
            addCriterion("needMoney is null");
            return (Criteria) this;
        }

        public Criteria andNeedmoneyIsNotNull() {
            addCriterion("needMoney is not null");
            return (Criteria) this;
        }

        public Criteria andNeedmoneyEqualTo(Double value) {
            addCriterion("needMoney =", value, "needmoney");
            return (Criteria) this;
        }

        public Criteria andNeedmoneyNotEqualTo(Double value) {
            addCriterion("needMoney <>", value, "needmoney");
            return (Criteria) this;
        }

        public Criteria andNeedmoneyGreaterThan(Double value) {
            addCriterion("needMoney >", value, "needmoney");
            return (Criteria) this;
        }

        public Criteria andNeedmoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("needMoney >=", value, "needmoney");
            return (Criteria) this;
        }

        public Criteria andNeedmoneyLessThan(Double value) {
            addCriterion("needMoney <", value, "needmoney");
            return (Criteria) this;
        }

        public Criteria andNeedmoneyLessThanOrEqualTo(Double value) {
            addCriterion("needMoney <=", value, "needmoney");
            return (Criteria) this;
        }

        public Criteria andNeedmoneyIn(List<Double> values) {
            addCriterion("needMoney in", values, "needmoney");
            return (Criteria) this;
        }

        public Criteria andNeedmoneyNotIn(List<Double> values) {
            addCriterion("needMoney not in", values, "needmoney");
            return (Criteria) this;
        }

        public Criteria andNeedmoneyBetween(Double value1, Double value2) {
            addCriterion("needMoney between", value1, value2, "needmoney");
            return (Criteria) this;
        }

        public Criteria andNeedmoneyNotBetween(Double value1, Double value2) {
            addCriterion("needMoney not between", value1, value2, "needmoney");
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

        public Criteria andIsactiveIsNull() {
            addCriterion("isActive is null");
            return (Criteria) this;
        }

        public Criteria andIsactiveIsNotNull() {
            addCriterion("isActive is not null");
            return (Criteria) this;
        }

        public Criteria andIsactiveEqualTo(Integer value) {
            addCriterion("isActive =", value, "isactive");
            return (Criteria) this;
        }

        public Criteria andIsactiveNotEqualTo(Integer value) {
            addCriterion("isActive <>", value, "isactive");
            return (Criteria) this;
        }

        public Criteria andIsactiveGreaterThan(Integer value) {
            addCriterion("isActive >", value, "isactive");
            return (Criteria) this;
        }

        public Criteria andIsactiveGreaterThanOrEqualTo(Integer value) {
            addCriterion("isActive >=", value, "isactive");
            return (Criteria) this;
        }

        public Criteria andIsactiveLessThan(Integer value) {
            addCriterion("isActive <", value, "isactive");
            return (Criteria) this;
        }

        public Criteria andIsactiveLessThanOrEqualTo(Integer value) {
            addCriterion("isActive <=", value, "isactive");
            return (Criteria) this;
        }

        public Criteria andIsactiveIn(List<Integer> values) {
            addCriterion("isActive in", values, "isactive");
            return (Criteria) this;
        }

        public Criteria andIsactiveNotIn(List<Integer> values) {
            addCriterion("isActive not in", values, "isactive");
            return (Criteria) this;
        }

        public Criteria andIsactiveBetween(Integer value1, Integer value2) {
            addCriterion("isActive between", value1, value2, "isactive");
            return (Criteria) this;
        }

        public Criteria andIsactiveNotBetween(Integer value1, Integer value2) {
            addCriterion("isActive not between", value1, value2, "isactive");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNull() {
            addCriterion("creator is null");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNotNull() {
            addCriterion("creator is not null");
            return (Criteria) this;
        }

        public Criteria andCreatorEqualTo(String value) {
            addCriterion("creator =", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotEqualTo(String value) {
            addCriterion("creator <>", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThan(String value) {
            addCriterion("creator >", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThanOrEqualTo(String value) {
            addCriterion("creator >=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThan(String value) {
            addCriterion("creator <", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThanOrEqualTo(String value) {
            addCriterion("creator <=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLike(String value) {
            addCriterion("creator like", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotLike(String value) {
            addCriterion("creator not like", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorIn(List<String> values) {
            addCriterion("creator in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotIn(List<String> values) {
            addCriterion("creator not in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorBetween(String value1, String value2) {
            addCriterion("creator between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotBetween(String value1, String value2) {
            addCriterion("creator not between", value1, value2, "creator");
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