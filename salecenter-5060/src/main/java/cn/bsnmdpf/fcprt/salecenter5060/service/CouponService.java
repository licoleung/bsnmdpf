package cn.bsnmdpf.fcprt.salecenter5060.service;

import cn.bsnmdpf.fcprt.api.pojo.Coupon;
import cn.bsnmdpf.fcprt.api.pojo.CouponExample;
import cn.bsnmdpf.fcprt.salecenter5060.mapper.CouponMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author LicoLeung
 * @create 2020-02-12 12:27
 */
@Transactional
public class CouponService {

    @Autowired
    private CouponMapper couponMapper;

    public List<Coupon> getCoupons(Integer cpid, String couponname, Integer mid, String mname, String mtag, Integer nnum, Double descMoney,
                                   Double needMoney, Date lessCreateTime, Date greaterCreateTime, Date lessBeginTime, Date greaterBeginTime,
                                   Date lessEndTime, Date greaterEndTime, Integer isActive, String creator) {
        CouponExample couponExample = new CouponExample();
        CouponExample.Criteria criteria = couponExample.createCriteria();
        if(cpid!=null){
            criteria.andCpidEqualTo(cpid);
        }
        if(couponname!=null){
            criteria.andCouponnameLike("%"+couponname+"%");
        }
        if(mid!=null){
            criteria.andMidEqualTo(mid);
        }
        if(mname!=null){
            criteria.andMnameLike("%"+mname+"%");
        }
        if(mtag!=null){
            criteria.andMtagLike("%"+mtag+"%");
        }
        if(nnum!=null){
            criteria.andNnumEqualTo(nnum);
        }
        if(descMoney!=null){
            criteria.andDescmoneyEqualTo(descMoney);
        }
        if(needMoney!=null){
            criteria.andNeedmoneyEqualTo(needMoney);
        }
        if(lessCreateTime!=null){
            criteria.andCreatetimeLessThanOrEqualTo(lessCreateTime);
        }
        if(greaterCreateTime!=null){
            criteria.andCreatetimeGreaterThanOrEqualTo(greaterCreateTime);
        }
        if(lessBeginTime!=null){
            criteria.andBegintimeLessThanOrEqualTo(lessBeginTime);
        }
        if(greaterBeginTime!=null){
            criteria.andBegintimeGreaterThanOrEqualTo(greaterBeginTime);
        }
        if(lessEndTime!=null){
            criteria.andEndtimeLessThanOrEqualTo(lessBeginTime);
        }
        if(greaterEndTime!=null){
            criteria.andEndtimeGreaterThanOrEqualTo(greaterEndTime);
        }
        if (creator != null) {
            criteria.andCreatorLike("%" + creator + "%");
        }
        if(isActive!=null){
            criteria.andIsactiveEqualTo(isActive);
        }
        List<Coupon> coupons = couponMapper.selectByExample(couponExample);
        return coupons;
    }

    @Transactional
    public boolean addCoupon(Integer cpid, String couponname, Integer mid, String mname, String mtag, Integer nnum, Double descMoney,
                             Double needMoney,  Date beginTime, Date endTime, Integer isActive, String creator) throws RuntimeException{
        Coupon coupon = new Coupon();
        coupon.setCpid(cpid);
        coupon.setCouponname(couponname);
        coupon.setMid(mid);
        coupon.setMname(mname);
        coupon.setMtag(mtag);
        coupon.setNnum(nnum);
        coupon.setDescmoney(descMoney);
        coupon.setNeedmoney(needMoney);
        coupon.setCreatetime(new Date());
        coupon.setBegintime(beginTime);
        coupon.setEndtime(endTime);
        coupon.setIsactive(isActive);
        coupon.setCreator(creator);
        int i = couponMapper.insertSelective(coupon);
        if(i==1){
            return true;
        }else{
            throw new RuntimeException("增加优惠券失败，请检查必填字段是否完整");
        }
    }

    @Transactional
    public boolean unableCoupon(Integer cpid) throws RuntimeException{
        Coupon coupon = new Coupon();
        coupon.setIsactive(0);
        CouponExample couponExample = new CouponExample();
        CouponExample.Criteria criteria = couponExample.createCriteria();
        criteria.andCpidEqualTo(cpid);
        int i = couponMapper.updateByExampleSelective(coupon, couponExample);
        if(i==1){
            return true;
        }else{
            throw new RuntimeException("删除/封锁优惠券失败，请检查cpid是否正确");
        }
    }

    @Transactional
    public boolean updateCoupon(Integer cpid, String couponname, Integer mid, String mname, String mtag, Integer nnum, Double descMoney,
                                Double needMoney, Date beginTime, Date endTime, Integer isActive, String creator) throws RuntimeException{
        Coupon coupon = new Coupon();
        coupon.setCouponname(couponname);
        coupon.setMid(mid);
        coupon.setMname(mname);
        coupon.setMtag(mtag);
        coupon.setNnum(nnum);
        coupon.setDescmoney(descMoney);
        coupon.setNeedmoney(needMoney);
        coupon.setCreatetime(new Date());
        coupon.setBegintime(beginTime);
        coupon.setEndtime(endTime);
        coupon.setIsactive(isActive);
        coupon.setCreator(creator);
        CouponExample couponExample = new CouponExample();
        CouponExample.Criteria criteria = couponExample.createCriteria();
        criteria.andCpidEqualTo(cpid);
        int i = couponMapper.updateByExampleSelective(coupon, couponExample);
        if(i==1){
            return true;
        }else{
            throw new RuntimeException("修改优惠券失败，请检查cpid是否正确");
        }
    }
}
