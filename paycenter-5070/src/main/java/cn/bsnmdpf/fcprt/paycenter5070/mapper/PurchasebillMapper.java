package cn.bsnmdpf.fcprt.paycenter5070.mapper;

import cn.bsnmdpf.fcprt.api.pojo.Purchasebill;
import cn.bsnmdpf.fcprt.api.pojo.PurchasebillExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PurchasebillMapper {
    long countByExample(PurchasebillExample example);

    int deleteByExample(PurchasebillExample example);

    int insert(Purchasebill record);

    int insertSelective(Purchasebill record);

    List<Purchasebill> selectByExample(PurchasebillExample example);

    int updateByExampleSelective(@Param("record") Purchasebill record, @Param("example") PurchasebillExample example);

    int updateByExample(@Param("record") Purchasebill record, @Param("example") PurchasebillExample example);
}