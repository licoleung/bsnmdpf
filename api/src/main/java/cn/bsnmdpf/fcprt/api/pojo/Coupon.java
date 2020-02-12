package cn.bsnmdpf.fcprt.api.pojo;

import java.util.Date;

public class Coupon {
    private Integer cpid;

    private String couponname;

    private Integer mid;

    private String mname;

    private String mtag;

    private Integer nnum;

    private Double descmoney;

    private Double needmoney;

    private Date begintime;

    private Date endtime;

    private Integer isactive;

    private String creator;

    private Date createtime;

    public Integer getCpid() {
        return cpid;
    }

    public void setCpid(Integer cpid) {
        this.cpid = cpid;
    }

    public String getCouponname() {
        return couponname;
    }

    public void setCouponname(String couponname) {
        this.couponname = couponname == null ? null : couponname.trim();
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

    public Double getDescmoney() {
        return descmoney;
    }

    public void setDescmoney(Double descmoney) {
        this.descmoney = descmoney;
    }

    public Double getNeedmoney() {
        return needmoney;
    }

    public void setNeedmoney(Double needmoney) {
        this.needmoney = needmoney;
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

    public Integer getIsactive() {
        return isactive;
    }

    public void setIsactive(Integer isactive) {
        this.isactive = isactive;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}