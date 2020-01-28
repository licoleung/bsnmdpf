package cn.bsnmdpf.fcprt.api.pojo;

public class VIPTag {
    private Integer vtid;

    private Integer vipid;

    private String tagname;

    public Integer getVtid() {
        return vtid;
    }

    public void setVtid(Integer vtid) {
        this.vtid = vtid;
    }

    public Integer getVipid() {
        return vipid;
    }

    public void setVipid(Integer vipid) {
        this.vipid = vipid;
    }

    public String getTagname() {
        return tagname;
    }

    public void setTagname(String tagname) {
        this.tagname = tagname == null ? null : tagname.trim();
    }
}