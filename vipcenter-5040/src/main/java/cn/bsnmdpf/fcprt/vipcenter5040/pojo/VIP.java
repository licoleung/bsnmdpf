package cn.bsnmdpf.fcprt.vipcenter5040.pojo;

import java.util.Date;

public class VIP {
    private Integer vipid;

    private String vipname;

    private String phone;

    private String email;

    private String qq;

    private Double cunsumption;

    private Integer csttime;

    private String cstcycle;

    private Integer level;

    private Date registtime;

    private Double balance;

    private Integer isstuff;

    private Integer isactive;

    private String bandid;

    private String spare;

    public Integer getVipid() {
        return vipid;
    }

    public void setVipid(Integer vipid) {
        this.vipid = vipid;
    }

    public String getVipname() {
        return vipname;
    }

    public void setVipname(String vipname) {
        this.vipname = vipname == null ? null : vipname.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public Double getCunsumption() {
        return cunsumption;
    }

    public void setCunsumption(Double cunsumption) {
        this.cunsumption = cunsumption;
    }

    public Integer getCsttime() {
        return csttime;
    }

    public void setCsttime(Integer csttime) {
        this.csttime = csttime;
    }

    public String getCstcycle() {
        return cstcycle;
    }

    public void setCstcycle(String cstcycle) {
        this.cstcycle = cstcycle == null ? null : cstcycle.trim();
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Date getRegisttime() {
        return registtime;
    }

    public void setRegisttime(Date registtime) {
        this.registtime = registtime;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Integer getIsstuff() {
        return isstuff;
    }

    public void setIsstuff(Integer isstuff) {
        this.isstuff = isstuff;
    }

    public Integer getIsactive() {
        return isactive;
    }

    public void setIsactive(Integer isactive) {
        this.isactive = isactive;
    }

    public String getBandid() {
        return bandid;
    }

    public void setBandid(String bandid) {
        this.bandid = bandid == null ? null : bandid.trim();
    }

    public String getSpare() {
        return spare;
    }

    public void setSpare(String spare) {
        this.spare = spare == null ? null : spare.trim();
    }
}