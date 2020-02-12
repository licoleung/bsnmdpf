package cn.bsnmdpf.fcprt.api.service;

import cn.bsnmdpf.fcprt.api.pojo.Activity;
import cn.bsnmdpf.fcprt.api.pojo.Coupon;
import com.github.pagehelper.PageInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;



/**
 * @author LicoLeung
 * @create 2020-02-12 15:05
 */
@FeignClient(value = "salecenter-5060")
public interface SaleCenterService {

    //ActivityController

    @GetMapping("activity")
    public PageInfo<Activity> getActivities(@RequestParam(value = "pageSize",required = false) int pageSize,
                                            @RequestParam(value = "page",required = false) int page,
                                            @RequestParam(value = "aid",required = false) Integer aid,
                                            @RequestParam(value = "activityname",required = false) String activityname,
                                            @RequestParam(value = "atype",required = false) String atype,
                                            @RequestParam(value = "operator",required = false) String operator,
                                            @RequestParam(value = "operatorPhone",required = false) String operatorPhone,
                                            @RequestParam(value = "lessCreateTime",required = false) String lessCreateTime,
                                            @RequestParam(value = "greaterCreateTime",required = false) String greaterCreateTime,
                                            @RequestParam(value = "lessBeginTime",required = false) String lessBeginTime,
                                            @RequestParam(value = "greaterBeginTime",required = false) String greaterBeginTime,
                                            @RequestParam(value = "lessEndTime",required = false) String lessEndTime,
                                            @RequestParam(value = "greaterEndTime",required = false) String greaterEndTime,
                                            @RequestParam(value = "mid",required = false) Integer mid,
                                            @RequestParam(value = "mname",required = false) String mname,
                                            @RequestParam(value = "mtag",required = false) String mtag,
                                            @RequestParam(value = "nnum",required = false) Integer nnum,
                                            @RequestParam(value = "money",required = false) Double money,
                                            @RequestParam(value = "minVipLevel",required = false) Integer minVipLevel,
                                            @RequestParam(value = "maxVipLevel",required = false) Integer maxVipLevel,
                                            @RequestParam(value = "fullReductionMoney",required = false) Double fullReductionMoney);

    @PostMapping("activity")
    public boolean addActivity(@RequestParam(value = "aid", required = false) Integer aid,
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
                               @RequestParam(value = "fullReductionMoney", required = false) Double fullReductionMoney);

    @PutMapping("activity/{aid}")
    public boolean updateActivity(@PathVariable(value = "aid") Integer aid,
                                  @RequestParam(value = "activityname", required = false) String activityname,
                                  @RequestParam(value = "atype", required = false) String atype,
                                  @RequestParam(value = "operator", required = false) String operator,
                                  @RequestParam(value = "operatorPhone", required = false) String operatorPhone,
                                  @RequestParam(value = "beginTime", required = false) String beginTime,
                                  @RequestParam(value = "endTime", required = false) String endTime,
                                  @RequestParam(value = "mid", required = false) Integer mid,
                                  @RequestParam(value = "mname", required = false) String mname,
                                  @RequestParam(value = "mtag", required = false) String mtag,
                                  @RequestParam(value = "nnum", required = false) Integer nnum,
                                  @RequestParam(value = "money", required = false) Double money,
                                  @RequestParam(value = "minVipLevel", required = false) Integer minVipLevel,
                                  @RequestParam(value = "maxVipLevel", required = false) Integer maxVipLevel,
                                  @RequestParam(value = "fullReductionMoney", required = false) Double fullReductionMoney);

    @DeleteMapping("activity/{aid}")
    public boolean deleteActivity(@PathVariable("aid") Integer aid);

    //CouponController

    @GetMapping("coupon")
    public PageInfo<Coupon> getCoupons(@RequestParam(value = "pageSize",required = false) int pageSize,
                                       @RequestParam(value = "page",required = false) int page,
                                       @RequestParam(value = "cpid",required = false) Integer cpid,
                                       @RequestParam(value = "couponname",required = false) String couponname,
                                       @RequestParam(value = "mid",required = false) Integer mid,
                                       @RequestParam(value = "mname",required = false) String mname,
                                       @RequestParam(value = "mtag",required = false) String mtag,
                                       @RequestParam(value = "nnum",required = false) Integer nnum,
                                       @RequestParam(value = "descMonet",required = false) Double descMoney,
                                       @RequestParam(value = "needMoney",required = false) Double needMoney,
                                       @RequestParam(value = "lessCreateTime",required = false) String lessCreateTime,
                                       @RequestParam(value = "greaterCreateTime",required = false) String greaterCreateTime,
                                       @RequestParam(value = "lessBeginTime",required = false) String lessBeginTime,
                                       @RequestParam(value = "greaterBeginTime",required = false) String greaterBeginTime,
                                       @RequestParam(value = "lessEndTime",required = false) String lessEndTime,
                                       @RequestParam(value = "greaterEndTime",required = false) String greaterEndTime,
                                       @RequestParam(value = "isActive",required = false) Integer isActive,
                                       @RequestParam(value = "creator",required = false) String creator);

    @PostMapping("coupon")
    public boolean addCoupon(@RequestParam("cpid") Integer cpid,
                             @RequestParam("couponname") String couponname,
                             @RequestParam("mid") Integer mid,
                             @RequestParam(value = "mname", required = false) String mname,
                             @RequestParam(value = "mtag", required = false) String mtag,
                             @RequestParam(value = "nnum", required = false) Integer nnum,
                             @RequestParam("descMonet") Double descMoney,
                             @RequestParam("needMoney") Double needMoney,
                             @RequestParam("beginTime") String beginTime,
                             @RequestParam("endTime") String endTime,
                             @RequestParam("isActive") Integer isActive,
                             @RequestParam("creator") String creator);

    @PutMapping("coupon/{cpid}")
    public boolean updateCoupon(@PathVariable("cpid") Integer cpid,
                                @RequestParam(value = "couponname", required = false) String couponname,
                                @RequestParam(value = "mid", required = false) Integer mid,
                                @RequestParam(value = "mname", required = false) String mname,
                                @RequestParam(value = "mtag", required = false) String mtag,
                                @RequestParam(value = "nnum", required = false) Integer nnum,
                                @RequestParam(value = "descMonet", required = false) Double descMoney,
                                @RequestParam(value = "needMoney", required = false) Double needMoney,
                                @RequestParam(value = "beginTime", required = false) String beginTime,
                                @RequestParam(value = "endTime", required = false) String endTime,
                                @RequestParam(value = "isActive", required = false) Integer isActive,
                                @RequestParam(value = "creator", required = false) String creator);

    @DeleteMapping("coupon/{cpid}")
    public boolean deleteCoupon(@PathVariable("cpid") Integer cpid);
}
