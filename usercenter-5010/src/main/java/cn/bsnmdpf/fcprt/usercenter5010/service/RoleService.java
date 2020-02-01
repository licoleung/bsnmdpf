package cn.bsnmdpf.fcprt.usercenter5010.service;

import cn.bsnmdpf.fcprt.api.pojo.Role;
import cn.bsnmdpf.fcprt.api.pojo.RoleExample;
import cn.bsnmdpf.fcprt.usercenter5010.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LicoLeung
 * @create 2020-02-01 14:53
 */
@Service
public class RoleService {

    @Autowired
    private RoleMapper roleMapper;

    /**
     * 根据条件查询角色列表
     *
     * @param rid
     * @param rolename
     * @param creator
     * @param modifier
     * @param isActive
     * @param spare
     * @return 角色列表
     */
    public List<Role> getRoles(Integer rid, String rolename, String creator, String modifier, Integer isActive, String spare) {
        RoleExample roleExample = new RoleExample();
        RoleExample.Criteria criteria = roleExample.createCriteria();
        if (rid != null) {
            criteria.andRidEqualTo(rid);
        }
        if (rolename != null) {
            rolename = "%" + rolename + "%";
            criteria.andRolenameLike(rolename);
        }
        if (modifier != null) {
            modifier = "%" + modifier + "%";
            criteria.andModifierLike(modifier);
        }
        if (creator != null) {
            creator = "%" + creator + "%";
            criteria.andCreatorLike(creator);
        }
        if (isActive != null) {
            criteria.andIsactiveEqualTo(isActive);
        }
        if (spare != null) {
            criteria.andSpareEqualTo(spare);
        }
        List<Role> roles = roleMapper.selectByExample(roleExample);
        return roles;
    }

    /**
     * 添加角色
     *
     * @param role
     * @return 成功返回true，失败返回false
     */
    public boolean addRole(Role role) {
        int insert = roleMapper.insert(role);
        try {
            if (insert == 1) {
                return true;
            } else {
                throw new Exception("未知错误，请检查字段是否完整");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 根据rid将用户的isActive设成0 即角色不可用
     *
     * @param rid
     * @return 成功返回true，失败返回false
     */
    public boolean unableRoleByRid(Integer rid) {
        Role role = new Role();
        role.setIsactive(0);
        RoleExample roleExample = new RoleExample();
        RoleExample.Criteria criteria = roleExample.createCriteria();
        criteria.andRidEqualTo(rid);
        int res = roleMapper.updateByExampleSelective(role, roleExample);
        try {
            if (res == 1) {
                return true;
            } else {
                throw new Exception("未知错误，无法删除，或可能找不到对应rid的role");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 根据rid将用户的isActive设成1 即角色可用
     *
     * @param rid
     * @return 成功返回true，失败返回false
     */
    public boolean ableRoleByRid(Integer rid) {
        Role role = new Role();
        role.setIsactive(1);
        RoleExample roleExample = new RoleExample();
        RoleExample.Criteria criteria = roleExample.createCriteria();
        criteria.andRidEqualTo(rid);
        int res = roleMapper.updateByExampleSelective(role, roleExample);
        try {
            if (res == 1) {
                return true;
            } else {
                throw new Exception("未知错误，无法解封，或可能找不到对应rid的role");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 根据rid更新role，role字段为空时不更新，只更新不为空的字段
     *
     * @param role
     * @return 成功返回true，失败返回false
     */
    public boolean updateRole(Role role) {
        RoleExample roleExample = new RoleExample();
        RoleExample.Criteria criteria = roleExample.createCriteria();
        criteria.andRidEqualTo(role.getRid());
        int res = roleMapper.updateByExampleSelective(role, roleExample);
        try {
            if (res == 1) {
                return true;
            } else {
                throw new Exception("未知错误，无法更新，或可能找不到对应rid的role");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
