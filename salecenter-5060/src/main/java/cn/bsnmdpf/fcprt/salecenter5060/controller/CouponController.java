package cn.bsnmdpf.fcprt.salecenter5060.controller;

import cn.bsnmdpf.fcprt.api.pojo.Coupon;
import cn.bsnmdpf.fcprt.salecenter5060.service.CouponService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author LicoLeung
 * @create 2020-02-12 14:50
 */
@RestController
public class CouponController {

    @Autowired
    private CouponService couponService;

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
                                       @RequestParam(value = "lessCreateTime",required = false) Date lessCreateTime,
                                       @RequestParam(value = "greaterCreateTime",required = false) Date greaterCreateTime,
                                       @RequestParam(value = "lessBeginTime",required = false) Date lessBeginTime,
                                       @RequestParam(value = "greaterBeginTime",required = false) Date greaterBeginTime,
                                       @RequestParam(value = "lessEndTime",required = false) Date lessEndTime,
                                       @RequestParam(value = "greaterEndTime",required = false) Date greaterEndTime,
                                       @RequestParam(value = "isActive",required = false) Integer isActive,
                                       @RequestParam(value = "creator",required = false) String creator){
        PageHelper.startPage(page,pageSize);
        List<Coupon> coupons = couponService.getCoupons(cpid, couponname, mid, mname, mtag, nnum, descMoney, needMoney,
                lessCreateTime, greaterCreateTime, lessBeginTime, greaterBeginTime, lessEndTime, greaterEndTime, isActive, creator);
        PageInfo<Coupon> pageInfo = new PageInfo<>(coupons);
        return pageInfo;
    }

    @PostMapping("coupon")
    public boolean addCoupon(@RequestParam("cpid") Integer cpid,
                             @RequestParam("couponname") String couponname,
                             @RequestParam("mid") Integer mid,
                             @RequestParam(value = "mname",required = false) String mname,
                             @RequestParam(value = "mtag",required = false) String mtag,
                             @RequestParam(value = "nnum",required = false) Integer nnum,
                             @RequestParam("descMonet") Double descMoney,
                             @RequestParam("needMoney") Double needMoney,
                             @RequestParam("beginTime") Date beginTime,
                             @RequestParam("endTime") Date endTime,
                             @RequestParam("isActive") Integer isActive,
                             @RequestParam("creator") String creator){
        boolean b = couponService.addCoupon(cpid, couponname, mid, mname, mtag, nnum, descMoney, needMoney, beginTime, endTime, isActive, creator);
        return b;
    }

    @PutMapping("coupon/{cpid}")
    public boolean updateCoupon(@PathVariable("cpid") Integer cpid,
                                @RequestParam(value = "couponname",required = false) String couponname,
                                @RequestParam(value = "mid",required = false) Integer mid,
                                @RequestParam(value = "mname",required = false) String mname,
                                @RequestParam(value = "mtag",required = false) String mtag,
                                @RequestParam(value = "nnum",required = false) Integer nnum,
                                @RequestParam(value = "descMonet",required = false) Double descMoney,
                                @RequestParam(value = "needMoney",required = false) Double needMoney,
                                @RequestParam(value = "beginTime",required = false) Date beginTime,
                                @RequestParam(value = "endTime",required = false) Date endTime,
                                @RequestParam(value = "isActive",required = false) Integer isActive,
                                @RequestParam(value = "creator",required = false) String creator){
        boolean b = couponService.updateCoupon(cpid, couponname, mid, mname, mtag, nnum, descMoney, needMoney, beginTime, endTime, isActive, creator);
        return b;
    }

    @DeleteMapping("coupon/{cpid}")
    public boolean deleteCoupon(@PathVariable("cpid") Integer cpid){
        boolean b = couponService.unableCoupon(cpid);
        return b;
    }
}
