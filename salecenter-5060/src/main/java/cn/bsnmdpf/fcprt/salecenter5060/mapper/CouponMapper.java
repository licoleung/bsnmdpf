package cn.bsnmdpf.fcprt.salecenter5060.mapper;

import java.util.List;

import cn.bsnmdpf.fcprt.api.pojo.Coupon;
import cn.bsnmdpf.fcprt.api.pojo.CouponExample;
import org.apache.ibatis.annotations.Param;

public interface CouponMapper {
    long countByExample(CouponExample example);

    int deleteByExample(CouponExample example);

    int insert(Coupon record);

    int insertSelective(Coupon record);

    List<Coupon> selectByExample(CouponExample example);

    int updateByExampleSelective(@Param("record") Coupon record, @Param("example") CouponExample example);

    int updateByExample(@Param("record") Coupon record, @Param("example") CouponExample example);
}