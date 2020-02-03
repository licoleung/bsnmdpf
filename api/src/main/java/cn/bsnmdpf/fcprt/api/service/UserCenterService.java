package cn.bsnmdpf.fcprt.api.service;

import cn.bsnmdpf.fcprt.api.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author LicoLeung
 * @create 2020-02-02 1:15
 */
@FeignClient(value = "usercenter-5010")
public interface UserCenterService {

    @GetMapping("user")
    public List<User> getUsersByParam(@RequestParam(value = "username", required = false) String username, @RequestParam(value = "creator", required = false) String creator, @RequestParam(value = "modifier", required = false) String modifier, @RequestParam(value = "isActive", required = false) Integer isActive, @RequestParam(value = "did", required = false) Integer did, @RequestParam(value = "uid", required = false) Integer uid, @RequestParam(value = "spare", required = false) String spare);

}
