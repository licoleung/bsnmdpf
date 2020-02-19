package cn.bsnmdpf.fcprt.headquarters9001.controller;

import cn.bsnmdpf.fcprt.api.pojo.VIP;
import cn.bsnmdpf.fcprt.api.service.VIPCenterService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author LicoLeung
 * @create 2020-02-18 13:22
 */
@Controller
public class VIPBaseController {

    @Autowired
    private VIPCenterService vipCenterService;

    @GetMapping("vip")
    public String getVips(Model model,
                          @RequestParam(value = "page", required = false, defaultValue = "1") int page,
                          @RequestParam(value = "pageSize", required = false, defaultValue = "6") int pageSize,
                          @RequestParam(value = "vipid", required = false) Integer vipid,
                          @RequestParam(value = "vipname", required = false) String vipname,
                          @RequestParam(value = "phone", required = false) String phone,
                          @RequestParam(value = "email", required = false) String email,
                          @RequestParam(value = "qq", required = false) String qq,
                          @RequestParam(value = "lessCunsumption", required = false) Double lessCunsumption,
                          @RequestParam(value = "greaterCunsumption", required = false) Double greaterCunsumption,
                          @RequestParam(value = "lesscstTime", required = false) Integer lesscstTime,
                          @RequestParam(value = "greatercstTime", required = false) Integer greatercstTime,
                          @RequestParam(value = "cstCycle", required = false) String cstCycle,
                          @RequestParam(value = "level", required = false) Integer level,
                          @RequestParam(value = "lessRegistTime", required = false) String lessRegistTime,
                          @RequestParam(value = "greaterRegistTime", required = false) String greaterRegistTime,
                          @RequestParam(value = "lessBalance", required = false) Double lessBalance,
                          @RequestParam(value = "greaterBalance", required = false) Double greaterBalance,
                          @RequestParam(value = "isStuff", required = false) Integer isStuff,
                          @RequestParam(value = "isActive", required = false) Integer isActive,
                          @RequestParam(value = "bandid", required = false) String bandid,
                          @RequestParam(value = "spare", required = false) String spare,
                          @RequestParam(value = "flag",defaultValue = "1",required = false) int flag,
                          HttpSession httpSession) {
        PageInfo<VIP> pageInfo = null;
        if (flag == 1) {
            pageInfo = vipCenterService.getVIPwithScoreAndTag(pageSize, page, vipid, vipname, phone,
                    email, qq, lessCunsumption, greaterCunsumption, lesscstTime, greatercstTime, cstCycle, level, lessRegistTime,
                    greaterRegistTime, lessBalance, greaterBalance, isStuff, isActive, bandid, spare);
            httpSession.setAttribute("level", level);
            httpSession.setAttribute("isStuff", isStuff);
            httpSession.setAttribute("isActive", isActive);
            httpSession.setAttribute("vipname", vipname);
            httpSession.setAttribute("lessCunsumption", lessCunsumption);
            httpSession.setAttribute("greaterCunsumption", greaterCunsumption);
            httpSession.setAttribute("lessRegistTime", lessRegistTime);
            httpSession.setAttribute("greaterRegistTime", greaterRegistTime);
        } else {
            level = (Integer) httpSession.getAttribute("level");
            isStuff = (Integer) httpSession.getAttribute("isStuff");
            isActive = (Integer) httpSession.getAttribute("isActive");
            vipname = (String) httpSession.getAttribute("vipname");
            lessCunsumption = (Double) httpSession.getAttribute("lessCunsumption");
            greaterCunsumption = (Double) httpSession.getAttribute("greaterCunsumption");
            lessRegistTime = (String) httpSession.getAttribute("lessRegistTime");
            greaterRegistTime = (String) httpSession.getAttribute("greaterRegistTime");
            pageInfo = vipCenterService.getVIPwithScoreAndTag(pageSize, page, vipid, vipname, phone,
                    email, qq, lessCunsumption, greaterCunsumption, lesscstTime, greatercstTime, cstCycle, level, lessRegistTime,
                    greaterRegistTime, lessBalance, greaterBalance, isStuff, isActive, bandid, spare);
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
        model.addAttribute("viplist", pageInfo.getList());
        return "vip/vip-list";
    }

    @DeleteMapping("vip/{vipid}")
    public String unableVIP(@PathVariable("vipid") Integer vipid, @RequestParam("nowState") Integer nowState) {
        if (nowState == 1) {
            boolean b = vipCenterService.deleteVIP(vipid);
        } else {
            vipCenterService.updateVIP(vipid, null, null, null, null, null,
                    null, null, null, null, null, 1, null, null);
        }
        return "vip/vip-list";
    }

    @GetMapping("editPage")
    public String editPage(Integer vipid, Model model) {
        PageInfo<VIP> viPwithScoreAndTag = vipCenterService.getVIPwithScoreAndTag(10, 1, vipid, null, null, null,
                null, null, null, null, null,
                null, null, null, null, null,
                null, null, null, null, null);
        List<VIP> list = viPwithScoreAndTag.getList();
//        System.out.println(list);
        VIP vip = list.get(0);
        model.addAttribute("vip", vip);
        return "vip/vip-edit";
    }

    @PutMapping("vip/{vipid}")
    public String editVIP(@PathVariable("vipid") Integer vipid,
                          @RequestParam(value = "vipname", required = false) String vipname,
                          @RequestParam(value = "phone", required = false) String phone,
                          @RequestParam(value = "email", required = false) String email,
                          @RequestParam(value = "qq", required = false) String qq,
                          @RequestParam(value = "cunsumption", required = false) Double cunsumption,
                          @RequestParam(value = "cstTime", required = false) Integer cstTime,
                          @RequestParam(value = "cstCycle", required = false) String cstCycle,
                          @RequestParam(value = "level", required = false) Integer level,
                          @RequestParam(value = "balance", required = false) Double balance,
                          @RequestParam(value = "isStuff", required = false) Integer isStuff,
                          @RequestParam(value = "isActive", required = false) Integer isActive,
                          @RequestParam(value = "bandid", required = false) String bandid,
                          @RequestParam(value = "spare", required = false) String spare) {
        boolean b = vipCenterService.updateVIP(vipid, vipname, phone, email, qq, cunsumption, cstTime, cstCycle, level, balance, isStuff, isActive, bandid, spare);
        return "vip/vip-list";
    }
}
