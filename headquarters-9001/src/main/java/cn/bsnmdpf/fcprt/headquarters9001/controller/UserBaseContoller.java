package cn.bsnmdpf.fcprt.headquarters9001.controller;

import cn.bsnmdpf.fcprt.api.pojo.User;
import cn.bsnmdpf.fcprt.api.service.UserCenterService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author LicoLeung
 * @create 2020-02-02 1:00
 */
@Controller
public class UserBaseContoller {

    @Autowired
    private UserCenterService userCenterService;

    @GetMapping("/user")
    public String getUsers(@RequestParam(value = "page", required = false, defaultValue = "1") int page,@RequestParam(value = "pageSize", required = false, defaultValue = "3") int pageSize,Model model, @RequestParam(value = "username", required = false) String username, @RequestParam(value = "creator", required = false) String creator, @RequestParam(value = "modifier", required = false) String modifier, @RequestParam(value = "isActive", required = false) Integer isActive, @RequestParam(value = "did", required = false) Integer did, @RequestParam(value = "uid", required = false) Integer uid, @RequestParam(value = "spare", required = false) String spare){
        PageInfo<User> usersByParam = userCenterService.getUsersByParam(pageSize, page, username, creator, modifier, isActive, did, uid, spare);
        model.addAttribute("userlist",usersByParam.getList());
        return "getUserListPage";
    }

    @DeleteMapping("user/{uid}")
    public boolean deleteUser(@PathVariable("uid") Integer uid){
        boolean b = userCenterService.deleteUser(uid);
        return b;
    }
}