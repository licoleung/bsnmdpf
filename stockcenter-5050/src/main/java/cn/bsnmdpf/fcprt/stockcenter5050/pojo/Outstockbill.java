package cn.bsnmdpf.fcprt.stockcenter5050.pojo;

import java.util.Date;

public class Outstockbill {
    private Integer outid;

    private String outbillcode;

    private Integer whid;

    private Integer mid;

    private String mname;

    private Date outtime;

    private String outtype;

    private Integer soid;

    private String creator;

    private Date createtime;

    private String modifier;

    private Date modifytime;

    private Integer isactive;

    private Integer nnum;

    private Double volumn;

    private Double weight;

    public Integer getOutid() {
        return outid;
    }

    public void setOutid(Integer outid) {
        this.outid = outid;
    }

    public String getOutbillcode() {
        return outbillcode;
    }

    public void setOutbillcode(String outbillcode) {
        this.outbillcode = outbillcode == null ? null : outbillcode.trim();
    }

    public Integer getWhid() {
        return whid;
    }

    public void setWhid(Integer whid) {
        this.whid = whid;
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

    public Date getOuttime() {
        return outtime;
    }

    public void setOuttime(Date outtime) {
        this.outtime = outtime;
    }

    public String getOuttype() {
        return outtype;
    }

    public void setOuttype(String outtype) {
        this.outtype = outtype == null ? null : outtype.trim();
    }

    public Integer getSoid() {
        return soid;
    }

    public void setSoid(Integer soid) {
        this.soid = soid;
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

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier == null ? null : modifier.trim();
    }

    public Date getModifytime() {
        return modifytime;
    }

    public void setModifytime(Date modifytime) {
        this.modifytime = modifytime;
    }

    public Integer getIsactive() {
        return isactive;
    }

    public void setIsactive(Integer isactive) {
        this.isactive = isactive;
    }

    public Integer getNnum() {
        return nnum;
    }

    public void setNnum(Integer nnum) {
        this.nnum = nnum;
    }

    public Double getVolumn() {
        return volumn;
    }

    public void setVolumn(Double volumn) {
        this.volumn = volumn;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }
}