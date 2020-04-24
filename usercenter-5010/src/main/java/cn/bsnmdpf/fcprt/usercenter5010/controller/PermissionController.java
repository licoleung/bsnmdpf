package cn.bsnmdpf.fcprt.usercenter5010.controller;

import cn.bsnmdpf.fcprt.api.pojo.Permission;
import cn.bsnmdpf.fcprt.usercenter5010.service.PermissionService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author LicoLeung
 * @create 2020-02-27 23:01
 */
@RestController
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @RequestMapping("getRolePermissions")
    public List<Permission> getRolePermissions(){
        List<Permission> rolePermissions = permissionService.getRolePermissions();
        return rolePermissions;
    }

    @RequestMapping("rolePermission")
    public boolean addrolePermission(@RequestParam("rid") Integer rid, @RequestParam("pid") Integer pid){
        boolean b = permissionService.addrolePermission(rid, pid);
        return b;
    }
}
