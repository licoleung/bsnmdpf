package cn.bsnmdpf.fcprt.usercenter5010.service;

import cn.bsnmdpf.fcprt.api.pojo.User;
import cn.bsnmdpf.fcprt.api.pojo.UserExample;
import cn.bsnmdpf.fcprt.usercenter5010.mapper.UserMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author LicoLeung
 * @create 2020-01-31 16:34
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 查询用户
     *
     * @param username 名字
     * @param creator  创建者
     * @param modifier 修改者
     * @param isActive 是否启用
     * @param did      部门id
     * @param uid      用户id
     * @return 符合条件用户
     */
    public List<User> getUsersByParams(String username, String creator, String modifier, Integer isActive, Integer did, Integer uid, String spare) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        if (username != null) {
            username = "%" + username + "%";
            criteria.andUsernameLike(username);
        }
        if (creator != null) {
            creator = "%" + creator + "%";
            criteria.andCreatorLike(creator);
        }
        if (modifier != null) {
            modifier = "%" + modifier + "%";
            criteria.andModifierLike(modifier);
        }
        if (isActive != null) {
            criteria.andIsactiveEqualTo(isActive);
        }
        if (did != null) {
            criteria.andDidEqualTo(did);
        }
        if (uid != null) {
            criteria.andUidEqualTo(uid);
        }
        if (spare != null) {
            criteria.andSpareEqualTo(spare);
        }
        List<User> users = userMapper.selectByExample(userExample);
        return users;
    }

    /**
     * 添加用户
     *
     * @param user 用户
     * @return 成功返回true，失败返回false
     */
    @Transactional
    public boolean addUser(User user) throws RuntimeException {
        int insert = userMapper.insert(user);
        if (insert == 1) {
            return true;
        } else {
            throw new RuntimeException("未知错误，请检查User中的必填字段是否完整");
        }
    }

    /**
     * 根据uid将用户的isActive设成0 即用户不可用
     *
     * @param uid 编码
     * @return 成功返回true，失败返回false
     */
    @Transactional
    public boolean unableUserByUid(Integer uid) throws RuntimeException {
        User user = new User();
        user.setIsactive(0);
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria1 = userExample.createCriteria();
        criteria1.andUidEqualTo(uid);
        int i = userMapper.updateByExampleSelective(user, userExample);
        if (i == 1) {
            return true;
        } else {
            throw new RuntimeException("未知错误，无法删除，或可能找不到对应uid的user");
        }
    }

    /**
     * 根据uid将用户的isActive设成1 即用户可用
     *
     * @param uid 编码
     * @return 成功返回true，失败返回false
     */
    @Transactional
    public boolean ableUserByUid(Integer uid) throws RuntimeException {
        User user = new User();
        user.setIsactive(1);
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria1 = userExample.createCriteria();
        criteria1.andUidEqualTo(uid);
        int i = userMapper.updateByExampleSelective(user, userExample);
        if (i == 1) {
            return true;
        } else {
            throw new RuntimeException("未知错误，无法解封，或可能找不到对应uid的user");
        }
    }

    /**
     * 根据uid更新user，user字段为空时不更新，只更新不为空的字段
     *
     * @param user 用户
     * @return 成功返回true，失败返回false
     */
    @Transactional
    public boolean updateUser(User user) throws RuntimeException {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria1 = userExample.createCriteria();
        criteria1.andUidEqualTo(user.getUid());
        int i = userMapper.updateByExampleSelective(user, userExample);
        if (i == 1) {
            return true;
        } else {
            throw new RuntimeException("未知错误，无法更新，或可能找不到对应uid的user");
        }
    }

    public User loadUserByUsername(String username){
        User user = userMapper.loadUserByUsername(username);
        return user;
    }

}
