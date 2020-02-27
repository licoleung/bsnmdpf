package cn.bsnmdpf.fcprt.headquarters9001.controller;

import cn.bsnmdpf.fcprt.api.pojo.Activity;
import cn.bsnmdpf.fcprt.api.pojo.Coupon;
import cn.bsnmdpf.fcprt.api.service.SaleCenterService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author LicoLeung
 * @create 2020-02-26 17:21
 */
@Controller
public class SaleBaseController {

    @Autowired
    private SaleCenterService saleCenterService;

    @GetMapping("activity")
    public String getActivities(@RequestParam(value = "pageSize", required = false, defaultValue = "6") int pageSize,
                                @RequestParam(value = "page", required = false, defaultValue = "1") int page,
                                @RequestParam(value = "aid", required = false) Integer aid,
                                @RequestParam(value = "activityname", required = false) String activityname,
                                @RequestParam(value = "atype", required = false) String atype,
                                @RequestParam(value = "operator", required = false) String operator,
                                @RequestParam(value = "operatorPhone", required = false) String operatorPhone,
                                @RequestParam(value = "lessCreateTime", required = false) String lessCreateTime,
                                @RequestParam(value = "greaterCreateTime", required = false) String greaterCreateTime,
                                @RequestParam(value = "lessBeginTime", required = false) String lessBeginTime,
                                @RequestParam(value = "greaterBeginTime", required = false) String greaterBeginTime,
                                @RequestParam(value = "lessEndTime", required = false) String lessEndTime,
                                @RequestParam(value = "greaterEndTime", required = false) String greaterEndTime,
                                @RequestParam(value = "mid", required = false) Integer mid,
                                @RequestParam(value = "mname", required = false) String mname,
                                @RequestParam(value = "mtag", required = false) String mtag,
                                @RequestParam(value = "nnum", required = false) Integer nnum,
                                @RequestParam(value = "money", required = false) Double money,
                                @RequestParam(value = "minVipLevel", required = false) Integer minVipLevel,
                                @RequestParam(value = "maxVipLevel", required = false) Integer maxVipLevel,
                                @RequestParam(value = "fullReductionMoney", required = false) Double fullReductionMoney,
                                @RequestParam(value = "flag", defaultValue = "1", required = false) int flag,
                                Model model,
                                HttpSession httpSession) {
        if (activityname == "")
            activityname = null;
        if (atype == "") {
            atype = null;
        }
        if (operator == "") {
            operator = null;
        }
        if (operatorPhone == "") {
            operatorPhone = null;
        }
        if (mtag == "") {
            mtag = null;
        }
        if (mname == "") {
            mname = null;
        }
        PageInfo<Activity> pageInfo = null;
        if (flag == 1) {
            pageInfo = saleCenterService.getActivities(pageSize, page, aid, activityname, atype, operator, operatorPhone,
                    lessCreateTime, greaterCreateTime, lessBeginTime, greaterBeginTime, lessEndTime, greaterEndTime,
                    mid, mname, mtag, nnum, money, minVipLevel, maxVipLevel, fullReductionMoney);
            httpSession.setAttribute("aid", aid);
            httpSession.setAttribute("activityname", activityname);
            httpSession.setAttribute("atype", atype);
            httpSession.setAttribute("operator", operator);
            httpSession.setAttribute("operatorPhone", operatorPhone);
            httpSession.setAttribute("lessBeginTime", lessBeginTime);
            httpSession.setAttribute("greaterBeginTime", greaterBeginTime);
            httpSession.setAttribute("lessEndTime", lessEndTime);
            httpSession.setAttribute("greaterEndTime", greaterEndTime);
            httpSession.setAttribute("mid", mid);
            httpSession.setAttribute("mname", mname);
            httpSession.setAttribute("mtag", mtag);
//            httpSession.setAttribute("money", money);
            httpSession.setAttribute("minVipLevel", minVipLevel);
            httpSession.setAttribute("maxVipLevel", maxVipLevel);
//            httpSession.setAttribute("fullReductionMoney", fullReductionMoney);
        } else {
            aid = (Integer) httpSession.getAttribute("aid");
            activityname = (String) httpSession.getAttribute("activityname");
            atype = (String) httpSession.getAttribute("atype");
            operator = (String) httpSession.getAttribute("operator");
            operatorPhone = (String) httpSession.getAttribute("operatorPhone");
            lessBeginTime = (String) httpSession.getAttribute("lessBeginTime");
            greaterBeginTime = (String) httpSession.getAttribute("greaterBeginTime");
            lessEndTime = (String) httpSession.getAttribute("lessEndTime");
            greaterEndTime = (String) httpSession.getAttribute("greaterEndTime");
            mid = (Integer) httpSession.getAttribute("mid");
            mname = (String) httpSession.getAttribute("mname");
            mtag = (String) httpSession.getAttribute("mtag");
//            money = (Double) httpSession.getAttribute("money");
            minVipLevel = (Integer) httpSession.getAttribute("minVipLevel");
            maxVipLevel = (Integer) httpSession.getAttribute("maxVipLevel");
//            fullReductionMoney = (Double) httpSession.getAttribute("fullReductionMoney");
            pageInfo = saleCenterService.getActivities(pageSize, page, aid, activityname, atype, operator, operatorPhone,
                    lessCreateTime, greaterCreateTime, lessBeginTime, greaterBeginTime, lessEndTime, greaterEndTime,
                    mid, mname, mtag, nnum, money, minVipLevel, maxVipLevel, fullReductionMoney);
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
        model.addAttribute("atvt", pageInfo.getList());
        return "sale/activity-list";
    }

    @DeleteMapping("activity/{aid}")
    public String delAc(@PathVariable("aid") Integer aid) {
        boolean b = saleCenterService.deleteActivity(aid);
        return "sale/activity-list";
    }

    @GetMapping("oneActivity")
    public String oneForAc(Integer aid, Model model) {
        PageInfo<Activity> activities = saleCenterService.getActivities(1, 1, aid, null, null, null,
                null, null, null, null, null, null,
                null, null, null, null, null, null, null,
                null, null);
        List<Activity> list = activities.getList();
        Activity activity = list.get(0);
        model.addAttribute("activity", activity);
        return "sale/activity-detail";
    }

    @GetMapping("addAcpage")
    public String toAddAcPage() {
        return "sale/activity-add";
    }

    @PostMapping("activity")
    @ResponseBody
    public String addAc(@RequestParam(value = "aid", required = false) Integer aid,
                        @RequestParam("activityname") String activityname,
                        @RequestParam("atype") String atype,
                        @RequestParam("operator") String operator,
                        @RequestParam("operatorPhone") String operatorPhone,
                        @RequestParam("beginTime") String beginTime,
                        @RequestParam("endTime") String endTime,
                        @RequestParam(value = "mid", required = false) Integer mid,
                        @RequestParam(value = "mname", required = false) String mname,
                        @RequestParam(value = "mtag", required = false) String mtag,
                        @RequestParam(value = "nnum", required = false) Integer nnum,
                        @RequestParam(value = "money", required = false) Double money,
                        @RequestParam(value = "minVipLevel", required = false) Integer minVipLevel,
                        @RequestParam(value = "maxVipLevel", required = false) Integer maxVipLevel,
                        @RequestParam(value = "fullReductionMoney", required = false) Double fullReductionMoney) {
        boolean b = saleCenterService.addActivity(aid, activityname, atype, operator, operatorPhone, beginTime, endTime, mid, mname, mtag, nnum, money, minVipLevel, maxVipLevel, fullReductionMoney);
        return "添加成功";
    }

    @GetMapping("coupon")
    public String getCoupon(@RequestParam(value = "pageSize", required = false,defaultValue = "6") int pageSize,
                            @RequestParam(value = "page", required = false,defaultValue = "1") int page,
                            @RequestParam(value = "cpid", required = false) Integer cpid,
                            @RequestParam(value = "couponname", required = false) String couponname,
                            @RequestParam(value = "mid", required = false) Integer mid,
                            @RequestParam(value = "mname", required = false) String mname,
                            @RequestParam(value = "mtag", required = false) String mtag,
                            @RequestParam(value = "nnum", required = false) Integer nnum,
                            @RequestParam(value = "descMoney", required = false) Double descMoney,
                            @RequestParam(value = "needMoney", required = false) Double needMoney,
                            @RequestParam(value = "lessCreateTime", required = false) String lessCreateTime,
                            @RequestParam(value = "greaterCreateTime", required = false) String greaterCreateTime,
                            @RequestParam(value = "lessBeginTime", required = false) String lessBeginTime,
                            @RequestParam(value = "greaterBeginTime", required = false) String greaterBeginTime,
                            @RequestParam(value = "lessEndTime", required = false) String lessEndTime,
                            @RequestParam(value = "greaterEndTime", required = false) String greaterEndTime,
                            @RequestParam(value = "isActive", required = false) Integer isActive,
                            @RequestParam(value = "creator", required = false) String creator,
                            @RequestParam(value = "flag", defaultValue = "1", required = false) int flag,
                            Model model,
                            HttpSession httpSession) {
        if (couponname == "") {
            couponname = null;
        }
        if (mtag == "") {
            mtag = null;
        }
        if(mname==""){
            mname=null;
        }
        PageInfo<Coupon> pageInfo = null;
        if (flag == 1) {
            pageInfo = saleCenterService.getCoupons(pageSize, page, cpid, couponname, mid, mname, mtag, nnum, descMoney, needMoney,
                    lessCreateTime, greaterCreateTime, lessBeginTime, greaterBeginTime, lessEndTime, greaterEndTime, isActive, creator);
            httpSession.setAttribute("lessBeginTime", lessBeginTime);
            httpSession.setAttribute("greaterBeginTime", greaterBeginTime);
            httpSession.setAttribute("lessEndTime", lessEndTime);
            httpSession.setAttribute("greaterEndTime", greaterEndTime);
            httpSession.setAttribute("mid", mid);
            httpSession.setAttribute("mname", mname);
            httpSession.setAttribute("mtag", mtag);
            httpSession.setAttribute("cpid", cpid);
            httpSession.setAttribute("couponname", couponname);
            httpSession.setAttribute("isActive", isActive);
        } else {
            lessBeginTime = (String) httpSession.getAttribute("lessBeginTime");
            greaterBeginTime = (String) httpSession.getAttribute("greaterBeginTime");
            lessEndTime = (String) httpSession.getAttribute("lessEndTime");
            greaterEndTime = (String) httpSession.getAttribute("greaterEndTime");
            mid = (Integer) httpSession.getAttribute("mid");
            mname = (String) httpSession.getAttribute("mname");
            mtag = (String) httpSession.getAttribute("mtag");
            cpid = (Integer) httpSession.getAttribute("cpid");
            couponname = (String) httpSession.getAttribute("couponname");
            isActive = (Integer) httpSession.getAttribute("isActive");
            pageInfo = saleCenterService.getCoupons(pageSize, page, cpid, couponname, mid, mname, mtag, nnum, descMoney, needMoney,
                    lessCreateTime, greaterCreateTime, lessBeginTime, greaterBeginTime, lessEndTime, greaterEndTime, isActive, creator);
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
        model.addAttribute("coupons", pageInfo.getList());
        return "sale/coupon-list";
    }

    @DeleteMapping("coupon/{cpid}")
    public String delCp(@PathVariable("cpid") Integer cpid,@RequestParam("nowState") Integer nowState){
        if(nowState==1){
            boolean b = saleCenterService.deleteCoupon(cpid);
        }else{
            saleCenterService.updateCoupon(cpid,null,null,null,null,null,null,null,null,null,1,null);
        }
        return "sale/coupon-list";
    }

    @PostMapping("coupon")
    @ResponseBody
    public String addCp(@RequestParam(value = "cpid",required = false) Integer cpid,
                        @RequestParam("couponname") String couponname,
                        @RequestParam(value = "mid",required = false) Integer mid,
                        @RequestParam(value = "mname", required = false) String mname,
                        @RequestParam(value = "mtag", required = false) String mtag,
                        @RequestParam(value = "nnum", required = false) Integer nnum,
                        @RequestParam("descMoney") Double descMoney,
                        @RequestParam("needMoney") Double needMoney,
                        @RequestParam("beginTime") String beginTime,
                        @RequestParam("endTime") String endTime,
                        @RequestParam(value = "isActive",required = false,defaultValue = "1") Integer isActive,
                        @RequestParam("creator") String creator){
        boolean b = saleCenterService.addCoupon(cpid, couponname, mid, mname, mtag, nnum, descMoney, needMoney,
                beginTime, endTime, isActive, creator);
        return "添加成功";
    }

    @GetMapping("tocppage")
    public String cpPage(){
        return "sale/coupon-add";
    }
}
