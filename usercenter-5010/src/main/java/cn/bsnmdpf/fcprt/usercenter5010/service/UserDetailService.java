package cn.bsnmdpf.fcprt.usercenter5010.service;

import cn.bsnmdpf.fcprt.api.pojo.Role;
import cn.bsnmdpf.fcprt.api.pojo.User;
import cn.bsnmdpf.fcprt.usercenter5010.mapper.RoleMapper;
import cn.bsnmdpf.fcprt.usercenter5010.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LicoLeung
 * @create 2020-02-02 15:35
 */
@Service
public class UserDetailService implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userMapper.loadUserByUsername(s);
        System.out.println(user);
        if(user != null){
            List<Role> roles = roleMapper.getRolesByUserId(user.getUid());
            user.setAuthorities(roles);
        }
        return user;
    }
}
