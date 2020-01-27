package cn.bsnmdpf.fcprt.goodcenter5030.pojo;

public class Materialtag {
    private Integer mtid;

    private Integer mid;

    private String tagname;

    public Integer getMtid() {
        return mtid;
    }

    public void setMtid(Integer mtid) {
        this.mtid = mtid;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getTagname() {
        return tagname;
    }

    public void setTagname(String tagname) {
        this.tagname = tagname == null ? null : tagname.trim();
    }
}