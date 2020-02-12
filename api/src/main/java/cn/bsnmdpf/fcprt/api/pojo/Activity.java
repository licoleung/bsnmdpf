package cn.bsnmdpf.fcprt.api.pojo;

import java.util.Date;

public class Activity {
    private Integer aid;

    private String activityname;

    private String atype;

    private String operator;

    private String operatorphone;

    private Date createtime;

    private Date begintime;

    private Date endtime;

    private Integer mid;

    private String mname;

    private String mtag;

    private Integer nnum;

    private Double money;

    private Integer minviplevel;

    private Integer maxviplevel;

    private Double fullreductionmoney;

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getActivityname() {
        return activityname;
    }

    public void setActivityname(String activityname) {
        this.activityname = activityname == null ? null : activityname.trim();
    }

    public String getAtype() {
        return atype;
    }

    public void setAtype(String atype) {
        this.atype = atype == null ? null : atype.trim();
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    public String getOperatorphone() {
        return operatorphone;
    }

    public void setOperatorphone(String operatorphone) {
        this.operatorphone = operatorphone == null ? null : operatorphone.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getBegintime() {
        return begintime;
    }

    public void setBegintime(Date begintime) {
        this.begintime = begintime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname == null ? null : mname.trim();
    }

    public String getMtag() {
        return mtag;
    }

    public void setMtag(String mtag) {
        this.mtag = mtag == null ? null : mtag.trim();
    }

    public Integer getNnum() {
        return nnum;
    }

    public void setNnum(Integer nnum) {
        this.nnum = nnum;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Integer getMinviplevel() {
        return minviplevel;
    }

    public void setMinviplevel(Integer minviplevel) {
        this.minviplevel = minviplevel;
    }

    public Integer getMaxviplevel() {
        return maxviplevel;
    }

    public void setMaxviplevel(Integer maxviplevel) {
        this.maxviplevel = maxviplevel;
    }

    public Double getFullreductionmoney() {
        return fullreductionmoney;
    }

    public void setFullreductionmoney(Double fullreductionmoney) {
        this.fullreductionmoney = fullreductionmoney;
    }
}