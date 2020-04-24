package cn.bsnmdpf.fcprt.usercenter5010.service;

import cn.bsnmdpf.fcprt.api.pojo.Permission;
import cn.bsnmdpf.fcprt.usercenter5010.mapper.PermissionMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LicoLeung
 * @create 2020-02-27 23:01
 */
@Service
public class PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    public List<Permission> getRolePermissions(){
        List<Permission> rolePermissions = permissionMapper.getRolePermissions();
        return rolePermissions;
    }


    public boolean addrolePermission(Integer rid,Integer pid){
        boolean b = permissionMapper.addrolePermission(rid, pid);
        return b;
    }
}
