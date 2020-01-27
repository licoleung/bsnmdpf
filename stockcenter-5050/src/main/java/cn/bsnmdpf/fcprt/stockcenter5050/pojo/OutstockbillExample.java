package cn.bsnmdpf.fcprt.stockcenter5050.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OutstockbillExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OutstockbillExample() {
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

        public Criteria andOutidIsNull() {
            addCriterion("outid is null");
            return (Criteria) this;
        }

        public Criteria andOutidIsNotNull() {
            addCriterion("outid is not null");
            return (Criteria) this;
        }

        public Criteria andOutidEqualTo(Integer value) {
            addCriterion("outid =", value, "outid");
            return (Criteria) this;
        }

        public Criteria andOutidNotEqualTo(Integer value) {
            addCriterion("outid <>", value, "outid");
            return (Criteria) this;
        }

        public Criteria andOutidGreaterThan(Integer value) {
            addCriterion("outid >", value, "outid");
            return (Criteria) this;
        }

        public Criteria andOutidGreaterThanOrEqualTo(Integer value) {
            addCriterion("outid >=", value, "outid");
            return (Criteria) this;
        }

        public Criteria andOutidLessThan(Integer value) {
            addCriterion("outid <", value, "outid");
            return (Criteria) this;
        }

        public Criteria andOutidLessThanOrEqualTo(Integer value) {
            addCriterion("outid <=", value, "outid");
            return (Criteria) this;
        }

        public Criteria andOutidIn(List<Integer> values) {
            addCriterion("outid in", values, "outid");
            return (Criteria) this;
        }

        public Criteria andOutidNotIn(List<Integer> values) {
            addCriterion("outid not in", values, "outid");
            return (Criteria) this;
        }

        public Criteria andOutidBetween(Integer value1, Integer value2) {
            addCriterion("outid between", value1, value2, "outid");
            return (Criteria) this;
        }

        public Criteria andOutidNotBetween(Integer value1, Integer value2) {
            addCriterion("outid not between", value1, value2, "outid");
            return (Criteria) this;
        }

        public Criteria andOutbillcodeIsNull() {
            addCriterion("outbillcode is null");
            return (Criteria) this;
        }

        public Criteria andOutbillcodeIsNotNull() {
            addCriterion("outbillcode is not null");
            return (Criteria) this;
        }

        public Criteria andOutbillcodeEqualTo(String value) {
            addCriterion("outbillcode =", value, "outbillcode");
            return (Criteria) this;
        }

        public Criteria andOutbillcodeNotEqualTo(String value) {
            addCriterion("outbillcode <>", value, "outbillcode");
            return (Criteria) this;
        }

        public Criteria andOutbillcodeGreaterThan(String value) {
            addCriterion("outbillcode >", value, "outbillcode");
            return (Criteria) this;
        }

        public Criteria andOutbillcodeGreaterThanOrEqualTo(String value) {
            addCriterion("outbillcode >=", value, "outbillcode");
            return (Criteria) this;
        }

        public Criteria andOutbillcodeLessThan(String value) {
            addCriterion("outbillcode <", value, "outbillcode");
            return (Criteria) this;
        }

        public Criteria andOutbillcodeLessThanOrEqualTo(String value) {
            addCriterion("outbillcode <=", value, "outbillcode");
            return (Criteria) this;
        }

        public Criteria andOutbillcodeLike(String value) {
            addCriterion("outbillcode like", value, "outbillcode");
            return (Criteria) this;
        }

        public Criteria andOutbillcodeNotLike(String value) {
            addCriterion("outbillcode not like", value, "outbillcode");
            return (Criteria) this;
        }

        public Criteria andOutbillcodeIn(List<String> values) {
            addCriterion("outbillcode in", values, "outbillcode");
            return (Criteria) this;
        }

        public Criteria andOutbillcodeNotIn(List<String> values) {
            addCriterion("outbillcode not in", values, "outbillcode");
            return (Criteria) this;
        }

        public Criteria andOutbillcodeBetween(String value1, String value2) {
            addCriterion("outbillcode between", value1, value2, "outbillcode");
            return (Criteria) this;
        }

        public Criteria andOutbillcodeNotBetween(String value1, String value2) {
            addCriterion("outbillcode not between", value1, value2, "outbillcode");
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

        public Criteria andOuttimeIsNull() {
            addCriterion("outTime is null");
            return (Criteria) this;
        }

        public Criteria andOuttimeIsNotNull() {
            addCriterion("outTime is not null");
            return (Criteria) this;
        }

        public Criteria andOuttimeEqualTo(Date value) {
            addCriterion("outTime =", value, "outtime");
            return (Criteria) this;
        }

        public Criteria andOuttimeNotEqualTo(Date value) {
            addCriterion("outTime <>", value, "outtime");
            return (Criteria) this;
        }

        public Criteria andOuttimeGreaterThan(Date value) {
            addCriterion("outTime >", value, "outtime");
            return (Criteria) this;
        }

        public Criteria andOuttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("outTime >=", value, "outtime");
            return (Criteria) this;
        }

        public Criteria andOuttimeLessThan(Date value) {
            addCriterion("outTime <", value, "outtime");
            return (Criteria) this;
        }

        public Criteria andOuttimeLessThanOrEqualTo(Date value) {
            addCriterion("outTime <=", value, "outtime");
            return (Criteria) this;
        }

        public Criteria andOuttimeIn(List<Date> values) {
            addCriterion("outTime in", values, "outtime");
            return (Criteria) this;
        }

        public Criteria andOuttimeNotIn(List<Date> values) {
            addCriterion("outTime not in", values, "outtime");
            return (Criteria) this;
        }

        public Criteria andOuttimeBetween(Date value1, Date value2) {
            addCriterion("outTime between", value1, value2, "outtime");
            return (Criteria) this;
        }

        public Criteria andOuttimeNotBetween(Date value1, Date value2) {
            addCriterion("outTime not between", value1, value2, "outtime");
            return (Criteria) this;
        }

        public Criteria andOuttypeIsNull() {
            addCriterion("outType is null");
            return (Criteria) this;
        }

        public Criteria andOuttypeIsNotNull() {
            addCriterion("outType is not null");
            return (Criteria) this;
        }

        public Criteria andOuttypeEqualTo(String value) {
            addCriterion("outType =", value, "outtype");
            return (Criteria) this;
        }

        public Criteria andOuttypeNotEqualTo(String value) {
            addCriterion("outType <>", value, "outtype");
            return (Criteria) this;
        }

        public Criteria andOuttypeGreaterThan(String value) {
            addCriterion("outType >", value, "outtype");
            return (Criteria) this;
        }

        public Criteria andOuttypeGreaterThanOrEqualTo(String value) {
            addCriterion("outType >=", value, "outtype");
            return (Criteria) this;
        }

        public Criteria andOuttypeLessThan(String value) {
            addCriterion("outType <", value, "outtype");
            return (Criteria) this;
        }

        public Criteria andOuttypeLessThanOrEqualTo(String value) {
            addCriterion("outType <=", value, "outtype");
            return (Criteria) this;
        }

        public Criteria andOuttypeLike(String value) {
            addCriterion("outType like", value, "outtype");
            return (Criteria) this;
        }

        public Criteria andOuttypeNotLike(String value) {
            addCriterion("outType not like", value, "outtype");
            return (Criteria) this;
        }

        public Criteria andOuttypeIn(List<String> values) {
            addCriterion("outType in", values, "outtype");
            return (Criteria) this;
        }

        public Criteria andOuttypeNotIn(List<String> values) {
            addCriterion("outType not in", values, "outtype");
            return (Criteria) this;
        }

        public Criteria andOuttypeBetween(String value1, String value2) {
            addCriterion("outType between", value1, value2, "outtype");
            return (Criteria) this;
        }

        public Criteria andOuttypeNotBetween(String value1, String value2) {
            addCriterion("outType not between", value1, value2, "outtype");
            return (Criteria) this;
        }

        public Criteria andSoidIsNull() {
            addCriterion("soid is null");
            return (Criteria) this;
        }

        public Criteria andSoidIsNotNull() {
            addCriterion("soid is not null");
            return (Criteria) this;
        }

        public Criteria andSoidEqualTo(Integer value) {
            addCriterion("soid =", value, "soid");
            return (Criteria) this;
        }

        public Criteria andSoidNotEqualTo(Integer value) {
            addCriterion("soid <>", value, "soid");
            return (Criteria) this;
        }

        public Criteria andSoidGreaterThan(Integer value) {
            addCriterion("soid >", value, "soid");
            return (Criteria) this;
        }

        public Criteria andSoidGreaterThanOrEqualTo(Integer value) {
            addCriterion("soid >=", value, "soid");
            return (Criteria) this;
        }

        public Criteria andSoidLessThan(Integer value) {
            addCriterion("soid <", value, "soid");
            return (Criteria) this;
        }

        public Criteria andSoidLessThanOrEqualTo(Integer value) {
            addCriterion("soid <=", value, "soid");
            return (Criteria) this;
        }

        public Criteria andSoidIn(List<Integer> values) {
            addCriterion("soid in", values, "soid");
            return (Criteria) this;
        }

        public Criteria andSoidNotIn(List<Integer> values) {
            addCriterion("soid not in", values, "soid");
            return (Criteria) this;
        }

        public Criteria andSoidBetween(Integer value1, Integer value2) {
            addCriterion("soid between", value1, value2, "soid");
            return (Criteria) this;
        }

        public Criteria andSoidNotBetween(Integer value1, Integer value2) {
            addCriterion("soid not between", value1, value2, "soid");
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

        public Criteria andModifierIsNull() {
            addCriterion("modifier is null");
            return (Criteria) this;
        }

        public Criteria andModifierIsNotNull() {
            addCriterion("modifier is not null");
            return (Criteria) this;
        }

        public Criteria andModifierEqualTo(String value) {
            addCriterion("modifier =", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierNotEqualTo(String value) {
            addCriterion("modifier <>", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierGreaterThan(String value) {
            addCriterion("modifier >", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierGreaterThanOrEqualTo(String value) {
            addCriterion("modifier >=", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierLessThan(String value) {
            addCriterion("modifier <", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierLessThanOrEqualTo(String value) {
            addCriterion("modifier <=", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierLike(String value) {
            addCriterion("modifier like", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierNotLike(String value) {
            addCriterion("modifier not like", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierIn(List<String> values) {
            addCriterion("modifier in", values, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierNotIn(List<String> values) {
            addCriterion("modifier not in", values, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierBetween(String value1, String value2) {
            addCriterion("modifier between", value1, value2, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierNotBetween(String value1, String value2) {
            addCriterion("modifier not between", value1, value2, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifytimeIsNull() {
            addCriterion("modifyTime is null");
            return (Criteria) this;
        }

        public Criteria andModifytimeIsNotNull() {
            addCriterion("modifyTime is not null");
            return (Criteria) this;
        }

        public Criteria andModifytimeEqualTo(Date value) {
            addCriterion("modifyTime =", value, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeNotEqualTo(Date value) {
            addCriterion("modifyTime <>", value, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeGreaterThan(Date value) {
            addCriterion("modifyTime >", value, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeGreaterThanOrEqualTo(Date value) {
            addCriterion("modifyTime >=", value, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeLessThan(Date value) {
            addCriterion("modifyTime <", value, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeLessThanOrEqualTo(Date value) {
            addCriterion("modifyTime <=", value, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeIn(List<Date> values) {
            addCriterion("modifyTime in", values, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeNotIn(List<Date> values) {
            addCriterion("modifyTime not in", values, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeBetween(Date value1, Date value2) {
            addCriterion("modifyTime between", value1, value2, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeNotBetween(Date value1, Date value2) {
            addCriterion("modifyTime not between", value1, value2, "modifytime");
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