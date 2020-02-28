package cn.bsnmdpf.fcprt.headquarters9001.service;

import cn.bsnmdpf.fcprt.api.pojo.Role;
import cn.bsnmdpf.fcprt.api.pojo.User;
import cn.bsnmdpf.fcprt.api.service.UserCenterService;
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
    private UserCenterService userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("at user detail un="+username);
        User user = userMapper.loadUserByUsername(username);
        System.out.println(user+"**************");
        if(user != null){
            List<Role> roles = userMapper.getRolesByUserId(user.getUid());
            System.out.println(roles.toString());
            user.setAuthorities(roles);
        }
        return user;
    }
}
