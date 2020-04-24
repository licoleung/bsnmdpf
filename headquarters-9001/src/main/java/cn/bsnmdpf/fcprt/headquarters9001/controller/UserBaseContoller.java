package cn.bsnmdpf.fcprt.headquarters9001.controller;

import cn.bsnmdpf.fcprt.api.pojo.User;
import cn.bsnmdpf.fcprt.api.pojo.VIP;
import cn.bsnmdpf.fcprt.api.service.UserCenterService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author LicoLeung
 * @create 2020-02-02 1:00
 */
@Controller
public class UserBaseContoller {

    @Autowired
    private UserCenterService userCenterService;

    @GetMapping("user")
    public String getUsersByParam(@RequestParam(value = "pageSize", defaultValue = "6") int pageSize,
                                  @RequestParam(value = "page", defaultValue = "1") int page,
                                  @RequestParam(value = "username", required = false) String username,
                                  @RequestParam(value = "creator", required = false) String creator,
                                  @RequestParam(value = "modifier", required = false) String modifier,
                                  @RequestParam(value = "isActive", required = false) Integer isActive,
                                  @RequestParam(value = "did", required = false) Integer did,
                                  @RequestParam(value = "uid", required = false) Integer uid,
                                  @RequestParam(value = "spare", required = false) String spare,
                                  @RequestParam(value = "flag", defaultValue = "1", required = false) int flag,
                                  HttpSession httpSession,
                                  Model model) {
        PageInfo<User> pageInfo = null;
        if (flag == 1) {
            pageInfo = userCenterService.getUsersByParam(pageSize, page, username, creator, modifier, isActive, did, uid, spare);
            httpSession.setAttribute("username", username);
            httpSession.setAttribute("isStuff", creator);
            httpSession.setAttribute("isActive", isActive);
            httpSession.setAttribute("vipname", modifier);
            httpSession.setAttribute("lessCunsumption", did);
            httpSession.setAttribute("greaterCunsumption", uid);
        } else {
            uid = (Integer) httpSession.getAttribute("uid");
            did = (Integer) httpSession.getAttribute("did");
            isActive = (Integer) httpSession.getAttribute("isActive");
            username = (String) httpSession.getAttribute("username");
            modifier = (String) httpSession.getAttribute("modifier");
            creator = (String) httpSession.getAttribute("creator");
            pageInfo = userCenterService.getUsersByParam(pageSize, page, username, creator, modifier, isActive, did, uid, spare);
        }

        int nowPage = pageInfo.getPageNum();//当前页面
        int[] nums = pageInfo.getNavigatepageNums();

        //previous page
        if (pageInfo.isIsFirstPage()) {
            model.addAttribute("prePage", nowPage);
        } else {
            model.addAttribute("prePage", nowPage - 1);
        }

        //next page
        if (pageInfo.isIsLastPage()) {
            model.addAttribute("nextPage", nowPage);
        } else {
            model.addAttribute("nextPage", nowPage + 1);
        }
        model.addAttribute("nowPage", nowPage);
        model.addAttribute("nums", nums);
        model.addAttribute("userlist", pageInfo.getList());
        return "user/user-list";
    }

    @DeleteMapping("user/{userid}")
    public String unableUser(@PathVariable("userid") Integer userid, @RequestParam("nowState") Integer nowState) {
        if (nowState == 1) {
            boolean b = userCenterService.deleteUser(userid);
        } else {
            userCenterService.updateUser(null, null, 1, null, userid,null, null);
        }
        return "user/user-list";
    }

    @GetMapping("editUserPage")
    public String editPage(Integer userid, Model model) {
        PageInfo<User> aa = userCenterService.getUsersByParam(1, 1, null,
                null, null, null, null, userid, null);
        List<User> list = aa.getList();
//        System.out.println(list);
        User user = list.get(0);
        model.addAttribute("user", user);
        return "user/user-edit";
    }

    @PutMapping("user/{userid}")
    public String editUser(@RequestParam(value = "username", required = false) String username,
                           @RequestParam(value = "modifier", required = false) String modifier,
                           @RequestParam(value = "isActive", required = false) Integer isActive,
                           @RequestParam(value = "did", required = false) Integer did,
                           @PathVariable("uid") Integer uid,
                           @RequestParam(value = "password",required = false) String password,
                           @RequestParam(value = "spare", required = false) String spare){
        boolean b = userCenterService.updateUser(username, modifier, isActive, did, uid,password, spare);
        return "user/user-list";
    }
}
