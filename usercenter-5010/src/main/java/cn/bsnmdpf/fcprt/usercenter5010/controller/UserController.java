package cn.bsnmdpf.fcprt.usercenter5010.controller;

import cn.bsnmdpf.fcprt.api.pojo.User;
import cn.bsnmdpf.fcprt.usercenter5010.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author LicoLeung
 * @create 2020-01-31 16:53
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 根据参数查询用户列表
     *
     * @param username
     * @param creator
     * @param modifier
     * @param isActive
     * @param did
     * @param uid
     * @return 用户列表
     */
    @GetMapping("user")
    public PageInfo<User> getUsersByParam(@RequestParam("pageSize") int pageSize,
                                          @RequestParam("page") int page,
                                          @RequestParam(value = "username", required = false) String username,
                                          @RequestParam(value = "creator", required = false) String creator,
                                          @RequestParam(value = "modifier", required = false) String modifier,
                                          @RequestParam(value = "isActive", required = false) Integer isActive,
                                          @RequestParam(value = "did", required = false) Integer did,
                                          @RequestParam(value = "uid", required = false) Integer uid,
                                          @RequestParam(value = "spare", required = false) String spare) {
        PageHelper.startPage(page, pageSize);
        List<User> usersByParams = userService.getUsersByParams(username, creator, modifier, isActive, did, uid, spare);
        PageInfo<User> pageInfo = new PageInfo<>(usersByParams);
        return pageInfo;
    }

    /**
     * 添加用户
     *
     * @param user
     * @return 成功返回true，失败返回false
     */
    @PostMapping("user")
    public boolean addUser(User user) {
        boolean b = userService.addUser(user);
        return b;
    }

    /**
     * 根据uid删除用户/将用户设为不可用
     *
     * @param uid
     * @return 成功返回true，失败返回false
     */
    @DeleteMapping("user/{uid}")
    public boolean deleteUser(@PathVariable("uid") Integer uid) {
        boolean b = userService.unableUserByUid(uid);
        return b;
    }

    /**
     * 根据uid更新user，有参则更，无参则不变
     *
     * @param username
     * @param modifier
     * @param isActive
     * @param did
     * @param uid
     * @param password
     * @param spare
     * @return 成功返回true，失败返回false
     */
    @PutMapping("user/{uid}")
    public boolean updateUser(@RequestParam(value = "username", required = false) String username, @RequestParam(value = "modifier", required = false) String modifier, @RequestParam(value = "isActive", required = false) Integer isActive, @RequestParam(value = "did", required = false) Integer did, @PathVariable("uid") Integer uid, @RequestParam(value = "password", required = false) String password, @RequestParam(value = "spare", required = false) String spare) {
        User user = new User();
        user.setUid(uid);
        user.setIsactive(isActive);
        user.setDid(did);
        user.setModifier(modifier);
        user.setModifytime(new Date());
        user.setPassword(password);
        user.setUsername(username);
        user.setSpare(spare);
        boolean b = userService.updateUser(user);
        return b;
    }

    @RequestMapping("loadUserByUsername")
    public User loadUserByUsername(@RequestParam("username") String username){
        System.out.println("at user controller un="+username);
        User user = userService.loadUserByUsername(username);
        return user;
    }
}
