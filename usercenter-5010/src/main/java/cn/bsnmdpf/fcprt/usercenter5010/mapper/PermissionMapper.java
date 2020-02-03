package cn.bsnmdpf.fcprt.usercenter5010.mapper;

import cn.bsnmdpf.fcprt.api.pojo.Permission;
import cn.bsnmdpf.fcprt.api.pojo.PermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface PermissionMapper {
    long countByExample(PermissionExample example);

    int deleteByExample(PermissionExample example);

    int insert(Permission record);

    int insertSelective(Permission record);

    List<Permission> selectByExample(PermissionExample example);

    int updateByExampleSelective(@Param("record") Permission record, @Param("example") PermissionExample example);

    int updateByExample(@Param("record") Permission record, @Param("example") PermissionExample example);

    @Select( "SELECT A.rolename AS name,C.url FROM tbl_role AS A LEFT JOIN role_permission B ON A.rid=B.rid LEFT JOIN tbl_permission AS C ON B.pid=C.pid" )
    List<Permission> getRolePermissions();
}