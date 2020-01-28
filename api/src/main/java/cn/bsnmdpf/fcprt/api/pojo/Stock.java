package cn.bsnmdpf.fcprt.api.pojo;

import java.util.Date;

public class Stock {
    private Integer sid;

    private String stockname;

    private Double volumn;

    private Double usedvolumn;

    private String address;

    private Integer whnum;

    private String creator;

    private Date createtime;

    private String modifier;

    private Date modifytime;

    private Integer isactive;

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getStockname() {
        return stockname;
    }

    public void setStockname(String stockname) {
        this.stockname = stockname == null ? null : stockname.trim();
    }

    public Double getVolumn() {
        return volumn;
    }

    public void setVolumn(Double volumn) {
        this.volumn = volumn;
    }

    public Double getUsedvolumn() {
        return usedvolumn;
    }

    public void setUsedvolumn(Double usedvolumn) {
        this.usedvolumn = usedvolumn;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getWhnum() {
        return whnum;
    }

    public void setWhnum(Integer whnum) {
        this.whnum = whnum;
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
}