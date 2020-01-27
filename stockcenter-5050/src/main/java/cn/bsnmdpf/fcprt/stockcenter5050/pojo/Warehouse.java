package cn.bsnmdpf.fcprt.stockcenter5050.pojo;

import java.util.Date;

public class Warehouse {
    private Integer whid;

    private Integer sid;

    private String warehousename;

    private Double volumn;

    private Double usedvolumn;

    private String address;

    private String charge;

    private String chargephone;

    private String whtype;

    private String creator;

    private Date createtime;

    private String modifier;

    private Date modifytime;

    private Integer isactive;

    public Integer getWhid() {
        return whid;
    }

    public void setWhid(Integer whid) {
        this.whid = whid;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getWarehousename() {
        return warehousename;
    }

    public void setWarehousename(String warehousename) {
        this.warehousename = warehousename == null ? null : warehousename.trim();
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

    public String getCharge() {
        return charge;
    }

    public void setCharge(String charge) {
        this.charge = charge == null ? null : charge.trim();
    }

    public String getChargephone() {
        return chargephone;
    }

    public void setChargephone(String chargephone) {
        this.chargephone = chargephone == null ? null : chargephone.trim();
    }

    public String getWhtype() {
        return whtype;
    }

    public void setWhtype(String whtype) {
        this.whtype = whtype == null ? null : whtype.trim();
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