package cn.bsnmdpf.fcprt.vipcenter5040.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VIPExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public VIPExample() {
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

        public Criteria andVipnameIsNull() {
            addCriterion("vipname is null");
            return (Criteria) this;
        }

        public Criteria andVipnameIsNotNull() {
            addCriterion("vipname is not null");
            return (Criteria) this;
        }

        public Criteria andVipnameEqualTo(String value) {
            addCriterion("vipname =", value, "vipname");
            return (Criteria) this;
        }

        public Criteria andVipnameNotEqualTo(String value) {
            addCriterion("vipname <>", value, "vipname");
            return (Criteria) this;
        }

        public Criteria andVipnameGreaterThan(String value) {
            addCriterion("vipname >", value, "vipname");
            return (Criteria) this;
        }

        public Criteria andVipnameGreaterThanOrEqualTo(String value) {
            addCriterion("vipname >=", value, "vipname");
            return (Criteria) this;
        }

        public Criteria andVipnameLessThan(String value) {
            addCriterion("vipname <", value, "vipname");
            return (Criteria) this;
        }

        public Criteria andVipnameLessThanOrEqualTo(String value) {
            addCriterion("vipname <=", value, "vipname");
            return (Criteria) this;
        }

        public Criteria andVipnameLike(String value) {
            addCriterion("vipname like", value, "vipname");
            return (Criteria) this;
        }

        public Criteria andVipnameNotLike(String value) {
            addCriterion("vipname not like", value, "vipname");
            return (Criteria) this;
        }

        public Criteria andVipnameIn(List<String> values) {
            addCriterion("vipname in", values, "vipname");
            return (Criteria) this;
        }

        public Criteria andVipnameNotIn(List<String> values) {
            addCriterion("vipname not in", values, "vipname");
            return (Criteria) this;
        }

        public Criteria andVipnameBetween(String value1, String value2) {
            addCriterion("vipname between", value1, value2, "vipname");
            return (Criteria) this;
        }

        public Criteria andVipnameNotBetween(String value1, String value2) {
            addCriterion("vipname not between", value1, value2, "vipname");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andQqIsNull() {
            addCriterion("qq is null");
            return (Criteria) this;
        }

        public Criteria andQqIsNotNull() {
            addCriterion("qq is not null");
            return (Criteria) this;
        }

        public Criteria andQqEqualTo(String value) {
            addCriterion("qq =", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotEqualTo(String value) {
            addCriterion("qq <>", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqGreaterThan(String value) {
            addCriterion("qq >", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqGreaterThanOrEqualTo(String value) {
            addCriterion("qq >=", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqLessThan(String value) {
            addCriterion("qq <", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqLessThanOrEqualTo(String value) {
            addCriterion("qq <=", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqLike(String value) {
            addCriterion("qq like", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotLike(String value) {
            addCriterion("qq not like", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqIn(List<String> values) {
            addCriterion("qq in", values, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotIn(List<String> values) {
            addCriterion("qq not in", values, "qq");
            return (Criteria) this;
        }

        public Criteria andQqBetween(String value1, String value2) {
            addCriterion("qq between", value1, value2, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotBetween(String value1, String value2) {
            addCriterion("qq not between", value1, value2, "qq");
            return (Criteria) this;
        }

        public Criteria andCunsumptionIsNull() {
            addCriterion("cunsumption is null");
            return (Criteria) this;
        }

        public Criteria andCunsumptionIsNotNull() {
            addCriterion("cunsumption is not null");
            return (Criteria) this;
        }

        public Criteria andCunsumptionEqualTo(Double value) {
            addCriterion("cunsumption =", value, "cunsumption");
            return (Criteria) this;
        }

        public Criteria andCunsumptionNotEqualTo(Double value) {
            addCriterion("cunsumption <>", value, "cunsumption");
            return (Criteria) this;
        }

        public Criteria andCunsumptionGreaterThan(Double value) {
            addCriterion("cunsumption >", value, "cunsumption");
            return (Criteria) this;
        }

        public Criteria andCunsumptionGreaterThanOrEqualTo(Double value) {
            addCriterion("cunsumption >=", value, "cunsumption");
            return (Criteria) this;
        }

        public Criteria andCunsumptionLessThan(Double value) {
            addCriterion("cunsumption <", value, "cunsumption");
            return (Criteria) this;
        }

        public Criteria andCunsumptionLessThanOrEqualTo(Double value) {
            addCriterion("cunsumption <=", value, "cunsumption");
            return (Criteria) this;
        }

        public Criteria andCunsumptionIn(List<Double> values) {
            addCriterion("cunsumption in", values, "cunsumption");
            return (Criteria) this;
        }

        public Criteria andCunsumptionNotIn(List<Double> values) {
            addCriterion("cunsumption not in", values, "cunsumption");
            return (Criteria) this;
        }

        public Criteria andCunsumptionBetween(Double value1, Double value2) {
            addCriterion("cunsumption between", value1, value2, "cunsumption");
            return (Criteria) this;
        }

        public Criteria andCunsumptionNotBetween(Double value1, Double value2) {
            addCriterion("cunsumption not between", value1, value2, "cunsumption");
            return (Criteria) this;
        }

        public Criteria andCsttimeIsNull() {
            addCriterion("cstTime is null");
            return (Criteria) this;
        }

        public Criteria andCsttimeIsNotNull() {
            addCriterion("cstTime is not null");
            return (Criteria) this;
        }

        public Criteria andCsttimeEqualTo(Integer value) {
            addCriterion("cstTime =", value, "csttime");
            return (Criteria) this;
        }

        public Criteria andCsttimeNotEqualTo(Integer value) {
            addCriterion("cstTime <>", value, "csttime");
            return (Criteria) this;
        }

        public Criteria andCsttimeGreaterThan(Integer value) {
            addCriterion("cstTime >", value, "csttime");
            return (Criteria) this;
        }

        public Criteria andCsttimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("cstTime >=", value, "csttime");
            return (Criteria) this;
        }

        public Criteria andCsttimeLessThan(Integer value) {
            addCriterion("cstTime <", value, "csttime");
            return (Criteria) this;
        }

        public Criteria andCsttimeLessThanOrEqualTo(Integer value) {
            addCriterion("cstTime <=", value, "csttime");
            return (Criteria) this;
        }

        public Criteria andCsttimeIn(List<Integer> values) {
            addCriterion("cstTime in", values, "csttime");
            return (Criteria) this;
        }

        public Criteria andCsttimeNotIn(List<Integer> values) {
            addCriterion("cstTime not in", values, "csttime");
            return (Criteria) this;
        }

        public Criteria andCsttimeBetween(Integer value1, Integer value2) {
            addCriterion("cstTime between", value1, value2, "csttime");
            return (Criteria) this;
        }

        public Criteria andCsttimeNotBetween(Integer value1, Integer value2) {
            addCriterion("cstTime not between", value1, value2, "csttime");
            return (Criteria) this;
        }

        public Criteria andCstcycleIsNull() {
            addCriterion("cstCycle is null");
            return (Criteria) this;
        }

        public Criteria andCstcycleIsNotNull() {
            addCriterion("cstCycle is not null");
            return (Criteria) this;
        }

        public Criteria andCstcycleEqualTo(String value) {
            addCriterion("cstCycle =", value, "cstcycle");
            return (Criteria) this;
        }

        public Criteria andCstcycleNotEqualTo(String value) {
            addCriterion("cstCycle <>", value, "cstcycle");
            return (Criteria) this;
        }

        public Criteria andCstcycleGreaterThan(String value) {
            addCriterion("cstCycle >", value, "cstcycle");
            return (Criteria) this;
        }

        public Criteria andCstcycleGreaterThanOrEqualTo(String value) {
            addCriterion("cstCycle >=", value, "cstcycle");
            return (Criteria) this;
        }

        public Criteria andCstcycleLessThan(String value) {
            addCriterion("cstCycle <", value, "cstcycle");
            return (Criteria) this;
        }

        public Criteria andCstcycleLessThanOrEqualTo(String value) {
            addCriterion("cstCycle <=", value, "cstcycle");
            return (Criteria) this;
        }

        public Criteria andCstcycleLike(String value) {
            addCriterion("cstCycle like", value, "cstcycle");
            return (Criteria) this;
        }

        public Criteria andCstcycleNotLike(String value) {
            addCriterion("cstCycle not like", value, "cstcycle");
            return (Criteria) this;
        }

        public Criteria andCstcycleIn(List<String> values) {
            addCriterion("cstCycle in", values, "cstcycle");
            return (Criteria) this;
        }

        public Criteria andCstcycleNotIn(List<String> values) {
            addCriterion("cstCycle not in", values, "cstcycle");
            return (Criteria) this;
        }

        public Criteria andCstcycleBetween(String value1, String value2) {
            addCriterion("cstCycle between", value1, value2, "cstcycle");
            return (Criteria) this;
        }

        public Criteria andCstcycleNotBetween(String value1, String value2) {
            addCriterion("cstCycle not between", value1, value2, "cstcycle");
            return (Criteria) this;
        }

        public Criteria andLevelIsNull() {
            addCriterion("level is null");
            return (Criteria) this;
        }

        public Criteria andLevelIsNotNull() {
            addCriterion("level is not null");
            return (Criteria) this;
        }

        public Criteria andLevelEqualTo(Integer value) {
            addCriterion("level =", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotEqualTo(Integer value) {
            addCriterion("level <>", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThan(Integer value) {
            addCriterion("level >", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("level >=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThan(Integer value) {
            addCriterion("level <", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThanOrEqualTo(Integer value) {
            addCriterion("level <=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelIn(List<Integer> values) {
            addCriterion("level in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotIn(List<Integer> values) {
            addCriterion("level not in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelBetween(Integer value1, Integer value2) {
            addCriterion("level between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("level not between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andRegisttimeIsNull() {
            addCriterion("registTime is null");
            return (Criteria) this;
        }

        public Criteria andRegisttimeIsNotNull() {
            addCriterion("registTime is not null");
            return (Criteria) this;
        }

        public Criteria andRegisttimeEqualTo(Date value) {
            addCriterion("registTime =", value, "registtime");
            return (Criteria) this;
        }

        public Criteria andRegisttimeNotEqualTo(Date value) {
            addCriterion("registTime <>", value, "registtime");
            return (Criteria) this;
        }

        public Criteria andRegisttimeGreaterThan(Date value) {
            addCriterion("registTime >", value, "registtime");
            return (Criteria) this;
        }

        public Criteria andRegisttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("registTime >=", value, "registtime");
            return (Criteria) this;
        }

        public Criteria andRegisttimeLessThan(Date value) {
            addCriterion("registTime <", value, "registtime");
            return (Criteria) this;
        }

        public Criteria andRegisttimeLessThanOrEqualTo(Date value) {
            addCriterion("registTime <=", value, "registtime");
            return (Criteria) this;
        }

        public Criteria andRegisttimeIn(List<Date> values) {
            addCriterion("registTime in", values, "registtime");
            return (Criteria) this;
        }

        public Criteria andRegisttimeNotIn(List<Date> values) {
            addCriterion("registTime not in", values, "registtime");
            return (Criteria) this;
        }

        public Criteria andRegisttimeBetween(Date value1, Date value2) {
            addCriterion("registTime between", value1, value2, "registtime");
            return (Criteria) this;
        }

        public Criteria andRegisttimeNotBetween(Date value1, Date value2) {
            addCriterion("registTime not between", value1, value2, "registtime");
            return (Criteria) this;
        }

        public Criteria andBalanceIsNull() {
            addCriterion("balance is null");
            return (Criteria) this;
        }

        public Criteria andBalanceIsNotNull() {
            addCriterion("balance is not null");
            return (Criteria) this;
        }

        public Criteria andBalanceEqualTo(Double value) {
            addCriterion("balance =", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceNotEqualTo(Double value) {
            addCriterion("balance <>", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceGreaterThan(Double value) {
            addCriterion("balance >", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceGreaterThanOrEqualTo(Double value) {
            addCriterion("balance >=", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceLessThan(Double value) {
            addCriterion("balance <", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceLessThanOrEqualTo(Double value) {
            addCriterion("balance <=", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceIn(List<Double> values) {
            addCriterion("balance in", values, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceNotIn(List<Double> values) {
            addCriterion("balance not in", values, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceBetween(Double value1, Double value2) {
            addCriterion("balance between", value1, value2, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceNotBetween(Double value1, Double value2) {
            addCriterion("balance not between", value1, value2, "balance");
            return (Criteria) this;
        }

        public Criteria andIsstuffIsNull() {
            addCriterion("isStuff is null");
            return (Criteria) this;
        }

        public Criteria andIsstuffIsNotNull() {
            addCriterion("isStuff is not null");
            return (Criteria) this;
        }

        public Criteria andIsstuffEqualTo(Integer value) {
            addCriterion("isStuff =", value, "isstuff");
            return (Criteria) this;
        }

        public Criteria andIsstuffNotEqualTo(Integer value) {
            addCriterion("isStuff <>", value, "isstuff");
            return (Criteria) this;
        }

        public Criteria andIsstuffGreaterThan(Integer value) {
            addCriterion("isStuff >", value, "isstuff");
            return (Criteria) this;
        }

        public Criteria andIsstuffGreaterThanOrEqualTo(Integer value) {
            addCriterion("isStuff >=", value, "isstuff");
            return (Criteria) this;
        }

        public Criteria andIsstuffLessThan(Integer value) {
            addCriterion("isStuff <", value, "isstuff");
            return (Criteria) this;
        }

        public Criteria andIsstuffLessThanOrEqualTo(Integer value) {
            addCriterion("isStuff <=", value, "isstuff");
            return (Criteria) this;
        }

        public Criteria andIsstuffIn(List<Integer> values) {
            addCriterion("isStuff in", values, "isstuff");
            return (Criteria) this;
        }

        public Criteria andIsstuffNotIn(List<Integer> values) {
            addCriterion("isStuff not in", values, "isstuff");
            return (Criteria) this;
        }

        public Criteria andIsstuffBetween(Integer value1, Integer value2) {
            addCriterion("isStuff between", value1, value2, "isstuff");
            return (Criteria) this;
        }

        public Criteria andIsstuffNotBetween(Integer value1, Integer value2) {
            addCriterion("isStuff not between", value1, value2, "isstuff");
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

        public Criteria andBandidIsNull() {
            addCriterion("bandid is null");
            return (Criteria) this;
        }

        public Criteria andBandidIsNotNull() {
            addCriterion("bandid is not null");
            return (Criteria) this;
        }

        public Criteria andBandidEqualTo(String value) {
            addCriterion("bandid =", value, "bandid");
            return (Criteria) this;
        }

        public Criteria andBandidNotEqualTo(String value) {
            addCriterion("bandid <>", value, "bandid");
            return (Criteria) this;
        }

        public Criteria andBandidGreaterThan(String value) {
            addCriterion("bandid >", value, "bandid");
            return (Criteria) this;
        }

        public Criteria andBandidGreaterThanOrEqualTo(String value) {
            addCriterion("bandid >=", value, "bandid");
            return (Criteria) this;
        }

        public Criteria andBandidLessThan(String value) {
            addCriterion("bandid <", value, "bandid");
            return (Criteria) this;
        }

        public Criteria andBandidLessThanOrEqualTo(String value) {
            addCriterion("bandid <=", value, "bandid");
            return (Criteria) this;
        }

        public Criteria andBandidLike(String value) {
            addCriterion("bandid like", value, "bandid");
            return (Criteria) this;
        }

        public Criteria andBandidNotLike(String value) {
            addCriterion("bandid not like", value, "bandid");
            return (Criteria) this;
        }

        public Criteria andBandidIn(List<String> values) {
            addCriterion("bandid in", values, "bandid");
            return (Criteria) this;
        }

        public Criteria andBandidNotIn(List<String> values) {
            addCriterion("bandid not in", values, "bandid");
            return (Criteria) this;
        }

        public Criteria andBandidBetween(String value1, String value2) {
            addCriterion("bandid between", value1, value2, "bandid");
            return (Criteria) this;
        }

        public Criteria andBandidNotBetween(String value1, String value2) {
            addCriterion("bandid not between", value1, value2, "bandid");
            return (Criteria) this;
        }

        public Criteria andSpareIsNull() {
            addCriterion("spare is null");
            return (Criteria) this;
        }

        public Criteria andSpareIsNotNull() {
            addCriterion("spare is not null");
            return (Criteria) this;
        }

        public Criteria andSpareEqualTo(String value) {
            addCriterion("spare =", value, "spare");
            return (Criteria) this;
        }

        public Criteria andSpareNotEqualTo(String value) {
            addCriterion("spare <>", value, "spare");
            return (Criteria) this;
        }

        public Criteria andSpareGreaterThan(String value) {
            addCriterion("spare >", value, "spare");
            return (Criteria) this;
        }

        public Criteria andSpareGreaterThanOrEqualTo(String value) {
            addCriterion("spare >=", value, "spare");
            return (Criteria) this;
        }

        public Criteria andSpareLessThan(String value) {
            addCriterion("spare <", value, "spare");
            return (Criteria) this;
        }

        public Criteria andSpareLessThanOrEqualTo(String value) {
            addCriterion("spare <=", value, "spare");
            return (Criteria) this;
        }

        public Criteria andSpareLike(String value) {
            addCriterion("spare like", value, "spare");
            return (Criteria) this;
        }

        public Criteria andSpareNotLike(String value) {
            addCriterion("spare not like", value, "spare");
            return (Criteria) this;
        }

        public Criteria andSpareIn(List<String> values) {
            addCriterion("spare in", values, "spare");
            return (Criteria) this;
        }

        public Criteria andSpareNotIn(List<String> values) {
            addCriterion("spare not in", values, "spare");
            return (Criteria) this;
        }

        public Criteria andSpareBetween(String value1, String value2) {
            addCriterion("spare between", value1, value2, "spare");
            return (Criteria) this;
        }

        public Criteria andSpareNotBetween(String value1, String value2) {
            addCriterion("spare not between", value1, value2, "spare");
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