package cn.bsnmdpf.fcprt.usercenter5010.mapper;

import cn.bsnmdpf.fcprt.api.pojo.Role;
import cn.bsnmdpf.fcprt.api.pojo.RoleExample;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface RoleMapper {
    long countByExample(RoleExample example);

    int deleteByExample(RoleExample example);

    int insert(Role record);

    int insertSelective(Role record);

    List<Role> selectByExample(RoleExample example);

    int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByExample(@Param("record") Role record, @Param("example") RoleExample example);

    @Select( "SELECT A.rid,A.rolename FROM tbl_role A LEFT JOIN user_role B ON A.rid=B.rid WHERE B.uid=${uid}" )
    List<Role> getRolesByUserId(@Param("uid") Integer uid);

    @Insert("insert into user_role(uid,rid) values (${uid},${rid}) ")
    boolean addRolesInUserByUserId(@Param("uid") Integer uid,@Param("rid") Integer rid);
}