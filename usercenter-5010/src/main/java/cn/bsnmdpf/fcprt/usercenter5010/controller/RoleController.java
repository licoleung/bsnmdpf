package cn.bsnmdpf.fcprt.usercenter5010.controller;

import cn.bsnmdpf.fcprt.api.pojo.Role;
import cn.bsnmdpf.fcprt.usercenter5010.service.RoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author LicoLeung
 * @create 2020-02-01 15:34
 */
@RestController
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("roleUser")
    boolean addRolesInUserByUserId(@RequestParam("uid")Integer uid,@RequestParam("rid")Integer rid){
        boolean b = roleService.addRoleUser(uid, rid);
        return b;
    }
    /**
     * 根据参数获取角色列表
     *
     * @param rid
     * @param rolename
     * @param creator
     * @param modifier
     * @param isActive
     * @param spare
     * @return 符合条件的角色列表
     */
    @GetMapping("role")
    public PageInfo<Role> getRoles(@RequestParam("pageSize") int pageSize,
                                   @RequestParam("page") int page,
                                   @RequestParam(value = "rid", required = false) Integer rid,
                                   @RequestParam(value = "rolename", required = false) String rolename,
                                   @RequestParam(value = "creator", required = false) String creator,
                                   @RequestParam(value = "modifier", required = false) String modifier,
                                   @RequestParam(value = "isActive", required = false) Integer isActive,
                                   @RequestParam(value = "spare", required = false) String spare) {
        PageHelper.startPage(page, pageSize);
        List<Role> roles = roleService.getRoles(rid, rolename, creator, modifier, isActive, spare);
        PageInfo<Role> pageInfo = new PageInfo<>(roles);
        return pageInfo;
    }

    /**
     * 添加角色
     *
     * @param role
     * @return 成功返回true，失败返回false
     */
    @PostMapping("role")
    public boolean addRole(Role role) {
        boolean b = roleService.addRole(role);
        return b;
    }

    /**
     * 删除角色/封号
     *
     * @param rid
     * @return 成功返回true，失败返回false
     */
    @DeleteMapping("role/{rid}")
    public boolean deleteRole(@PathVariable("rid") Integer rid) {
        boolean b = roleService.unableRoleByRid(rid);
        return b;
    }

    /**
     * 根据uid更新角色，有参则更，无参则不变
     *
     * @param rid
     * @param rolename
     * @param modifier
     * @param isActive
     * @param spare
     * @return 成功返回true，失败返回false
     */
    @PutMapping("role/{rid}")
    public boolean updateRole(@PathVariable("rid") Integer rid, @RequestParam(value = "rolename", required = false) String rolename, @RequestParam(value = "modifier", required = false) String modifier, @RequestParam(value = "isActive", required = false) Integer isActive, @RequestParam(value = "spare", required = false) String spare) {
        Role role = new Role();
        role.setIsactive(isActive);
        role.setModifier(modifier);
        role.setModifytime(new Date());
        role.setRid(rid);
        role.setRolename(rolename);
        role.setSpare(spare);
        boolean b = roleService.updateRole(role);
        return b;
    }

    @RequestMapping("getRolesByUserId")
    public List<Role> getRolesByUserId(@RequestParam("uid") Integer uid){
    List<Role> rolesByUserId = roleService.getRolesByUserId(uid);
    return rolesByUserId;
    }
}
