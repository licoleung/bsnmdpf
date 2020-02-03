package cn.bsnmdpf.fcprt.api.pojo;

//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.io.Serializable;
//import java.util.Collection;
import java.util.Date;
//import java.util.List;

public class User /*implements UserDetails, Serializable */{
    private Integer uid;

    private String username;

    private String password;

    private String creator;

    private String modifier;

    private Date createtime;

    private Date modifytime;

    private Integer isactive;

    private Integer did;

    private String spare;

//    private List<Role> authorities;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    /**
     * 用户账号是否没过期
     */
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }

    /**
     * 用户账号是否没被锁定
     */
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }

    /**
     * 用户密码是否没过期
     */
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }

    /**
     * 用户是否可用
     */
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

//    @Override
//    public List<Role> getAuthorities() {
//        return authorities;
//    }
//
//    public void setAuthorities(List<Role> authorities) {
//        this.authorities = authorities;
//    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier == null ? null : modifier.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
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

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getSpare() {
        return spare;
    }

    public void setSpare(String spare) {
        this.spare = spare == null ? null : spare.trim();
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", creator='" + creator + '\'' +
                ", modifier='" + modifier + '\'' +
                ", createtime=" + createtime +
                ", modifytime=" + modifytime +
                ", isactive=" + isactive +
                ", did=" + did +
                ", spare='" + spare + '\'' +
//                ", authorities=" + authorities +
                '}';
    }
}