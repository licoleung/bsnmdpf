package cn.bsnmdpf.fcprt.api.pojo;

import java.util.Date;
import java.util.List;

public class Material {
    private Integer mid;

    private String materialname;

    private Integer mcid;

    private Double length;

    private Double width;

    private Double height;

    private Double weight;

    private Double volumn;

    private String brand;

    private String specifications;

    private String creator;

    private Date createtime;

    private String modifier;

    private Date modifytime;

    private Integer isactive;

    private List<Materialtag> materialtags;

    public List<Materialtag> getMaterialtags() {
        return materialtags;
    }

    public void setMaterialtags(List<Materialtag> materialtags) {
        this.materialtags = materialtags;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getMaterialname() {
        return materialname;
    }

    public void setMaterialname(String materialname) {
        this.materialname = materialname == null ? null : materialname.trim();
    }

    public Integer getMcid() {
        return mcid;
    }

    public void setMcid(Integer mcid) {
        this.mcid = mcid;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getVolumn() {
        return volumn;
    }

    public void setVolumn(Double volumn) {
        this.volumn = volumn;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand == null ? null : brand.trim();
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications == null ? null : specifications.trim();
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