package cn.bsnmdpf.fcprt.api.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WarehouseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WarehouseExample() {
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

        public Criteria andWarehousenameIsNull() {
            addCriterion("warehousename is null");
            return (Criteria) this;
        }

        public Criteria andWarehousenameIsNotNull() {
            addCriterion("warehousename is not null");
            return (Criteria) this;
        }

        public Criteria andWarehousenameEqualTo(String value) {
            addCriterion("warehousename =", value, "warehousename");
            return (Criteria) this;
        }

        public Criteria andWarehousenameNotEqualTo(String value) {
            addCriterion("warehousename <>", value, "warehousename");
            return (Criteria) this;
        }

        public Criteria andWarehousenameGreaterThan(String value) {
            addCriterion("warehousename >", value, "warehousename");
            return (Criteria) this;
        }

        public Criteria andWarehousenameGreaterThanOrEqualTo(String value) {
            addCriterion("warehousename >=", value, "warehousename");
            return (Criteria) this;
        }

        public Criteria andWarehousenameLessThan(String value) {
            addCriterion("warehousename <", value, "warehousename");
            return (Criteria) this;
        }

        public Criteria andWarehousenameLessThanOrEqualTo(String value) {
            addCriterion("warehousename <=", value, "warehousename");
            return (Criteria) this;
        }

        public Criteria andWarehousenameLike(String value) {
            addCriterion("warehousename like", value, "warehousename");
            return (Criteria) this;
        }

        public Criteria andWarehousenameNotLike(String value) {
            addCriterion("warehousename not like", value, "warehousename");
            return (Criteria) this;
        }

        public Criteria andWarehousenameIn(List<String> values) {
            addCriterion("warehousename in", values, "warehousename");
            return (Criteria) this;
        }

        public Criteria andWarehousenameNotIn(List<String> values) {
            addCriterion("warehousename not in", values, "warehousename");
            return (Criteria) this;
        }

        public Criteria andWarehousenameBetween(String value1, String value2) {
            addCriterion("warehousename between", value1, value2, "warehousename");
            return (Criteria) this;
        }

        public Criteria andWarehousenameNotBetween(String value1, String value2) {
            addCriterion("warehousename not between", value1, value2, "warehousename");
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

        public Criteria andUsedvolumnIsNull() {
            addCriterion("usedVolumn is null");
            return (Criteria) this;
        }

        public Criteria andUsedvolumnIsNotNull() {
            addCriterion("usedVolumn is not null");
            return (Criteria) this;
        }

        public Criteria andUsedvolumnEqualTo(Double value) {
            addCriterion("usedVolumn =", value, "usedvolumn");
            return (Criteria) this;
        }

        public Criteria andUsedvolumnNotEqualTo(Double value) {
            addCriterion("usedVolumn <>", value, "usedvolumn");
            return (Criteria) this;
        }

        public Criteria andUsedvolumnGreaterThan(Double value) {
            addCriterion("usedVolumn >", value, "usedvolumn");
            return (Criteria) this;
        }

        public Criteria andUsedvolumnGreaterThanOrEqualTo(Double value) {
            addCriterion("usedVolumn >=", value, "usedvolumn");
            return (Criteria) this;
        }

        public Criteria andUsedvolumnLessThan(Double value) {
            addCriterion("usedVolumn <", value, "usedvolumn");
            return (Criteria) this;
        }

        public Criteria andUsedvolumnLessThanOrEqualTo(Double value) {
            addCriterion("usedVolumn <=", value, "usedvolumn");
            return (Criteria) this;
        }

        public Criteria andUsedvolumnIn(List<Double> values) {
            addCriterion("usedVolumn in", values, "usedvolumn");
            return (Criteria) this;
        }

        public Criteria andUsedvolumnNotIn(List<Double> values) {
            addCriterion("usedVolumn not in", values, "usedvolumn");
            return (Criteria) this;
        }

        public Criteria andUsedvolumnBetween(Double value1, Double value2) {
            addCriterion("usedVolumn between", value1, value2, "usedvolumn");
            return (Criteria) this;
        }

        public Criteria andUsedvolumnNotBetween(Double value1, Double value2) {
            addCriterion("usedVolumn not between", value1, value2, "usedvolumn");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andChargeIsNull() {
            addCriterion("charge is null");
            return (Criteria) this;
        }

        public Criteria andChargeIsNotNull() {
            addCriterion("charge is not null");
            return (Criteria) this;
        }

        public Criteria andChargeEqualTo(String value) {
            addCriterion("charge =", value, "charge");
            return (Criteria) this;
        }

        public Criteria andChargeNotEqualTo(String value) {
            addCriterion("charge <>", value, "charge");
            return (Criteria) this;
        }

        public Criteria andChargeGreaterThan(String value) {
            addCriterion("charge >", value, "charge");
            return (Criteria) this;
        }

        public Criteria andChargeGreaterThanOrEqualTo(String value) {
            addCriterion("charge >=", value, "charge");
            return (Criteria) this;
        }

        public Criteria andChargeLessThan(String value) {
            addCriterion("charge <", value, "charge");
            return (Criteria) this;
        }

        public Criteria andChargeLessThanOrEqualTo(String value) {
            addCriterion("charge <=", value, "charge");
            return (Criteria) this;
        }

        public Criteria andChargeLike(String value) {
            addCriterion("charge like", value, "charge");
            return (Criteria) this;
        }

        public Criteria andChargeNotLike(String value) {
            addCriterion("charge not like", value, "charge");
            return (Criteria) this;
        }

        public Criteria andChargeIn(List<String> values) {
            addCriterion("charge in", values, "charge");
            return (Criteria) this;
        }

        public Criteria andChargeNotIn(List<String> values) {
            addCriterion("charge not in", values, "charge");
            return (Criteria) this;
        }

        public Criteria andChargeBetween(String value1, String value2) {
            addCriterion("charge between", value1, value2, "charge");
            return (Criteria) this;
        }

        public Criteria andChargeNotBetween(String value1, String value2) {
            addCriterion("charge not between", value1, value2, "charge");
            return (Criteria) this;
        }

        public Criteria andChargephoneIsNull() {
            addCriterion("chargePhone is null");
            return (Criteria) this;
        }

        public Criteria andChargephoneIsNotNull() {
            addCriterion("chargePhone is not null");
            return (Criteria) this;
        }

        public Criteria andChargephoneEqualTo(String value) {
            addCriterion("chargePhone =", value, "chargephone");
            return (Criteria) this;
        }

        public Criteria andChargephoneNotEqualTo(String value) {
            addCriterion("chargePhone <>", value, "chargephone");
            return (Criteria) this;
        }

        public Criteria andChargephoneGreaterThan(String value) {
            addCriterion("chargePhone >", value, "chargephone");
            return (Criteria) this;
        }

        public Criteria andChargephoneGreaterThanOrEqualTo(String value) {
            addCriterion("chargePhone >=", value, "chargephone");
            return (Criteria) this;
        }

        public Criteria andChargephoneLessThan(String value) {
            addCriterion("chargePhone <", value, "chargephone");
            return (Criteria) this;
        }

        public Criteria andChargephoneLessThanOrEqualTo(String value) {
            addCriterion("chargePhone <=", value, "chargephone");
            return (Criteria) this;
        }

        public Criteria andChargephoneLike(String value) {
            addCriterion("chargePhone like", value, "chargephone");
            return (Criteria) this;
        }

        public Criteria andChargephoneNotLike(String value) {
            addCriterion("chargePhone not like", value, "chargephone");
            return (Criteria) this;
        }

        public Criteria andChargephoneIn(List<String> values) {
            addCriterion("chargePhone in", values, "chargephone");
            return (Criteria) this;
        }

        public Criteria andChargephoneNotIn(List<String> values) {
            addCriterion("chargePhone not in", values, "chargephone");
            return (Criteria) this;
        }

        public Criteria andChargephoneBetween(String value1, String value2) {
            addCriterion("chargePhone between", value1, value2, "chargephone");
            return (Criteria) this;
        }

        public Criteria andChargephoneNotBetween(String value1, String value2) {
            addCriterion("chargePhone not between", value1, value2, "chargephone");
            return (Criteria) this;
        }

        public Criteria andWhtypeIsNull() {
            addCriterion("whtype is null");
            return (Criteria) this;
        }

        public Criteria andWhtypeIsNotNull() {
            addCriterion("whtype is not null");
            return (Criteria) this;
        }

        public Criteria andWhtypeEqualTo(String value) {
            addCriterion("whtype =", value, "whtype");
            return (Criteria) this;
        }

        public Criteria andWhtypeNotEqualTo(String value) {
            addCriterion("whtype <>", value, "whtype");
            return (Criteria) this;
        }

        public Criteria andWhtypeGreaterThan(String value) {
            addCriterion("whtype >", value, "whtype");
            return (Criteria) this;
        }

        public Criteria andWhtypeGreaterThanOrEqualTo(String value) {
            addCriterion("whtype >=", value, "whtype");
            return (Criteria) this;
        }

        public Criteria andWhtypeLessThan(String value) {
            addCriterion("whtype <", value, "whtype");
            return (Criteria) this;
        }

        public Criteria andWhtypeLessThanOrEqualTo(String value) {
            addCriterion("whtype <=", value, "whtype");
            return (Criteria) this;
        }

        public Criteria andWhtypeLike(String value) {
            addCriterion("whtype like", value, "whtype");
            return (Criteria) this;
        }

        public Criteria andWhtypeNotLike(String value) {
            addCriterion("whtype not like", value, "whtype");
            return (Criteria) this;
        }

        public Criteria andWhtypeIn(List<String> values) {
            addCriterion("whtype in", values, "whtype");
            return (Criteria) this;
        }

        public Criteria andWhtypeNotIn(List<String> values) {
            addCriterion("whtype not in", values, "whtype");
            return (Criteria) this;
        }

        public Criteria andWhtypeBetween(String value1, String value2) {
            addCriterion("whtype between", value1, value2, "whtype");
            return (Criteria) this;
        }

        public Criteria andWhtypeNotBetween(String value1, String value2) {
            addCriterion("whtype not between", value1, value2, "whtype");
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