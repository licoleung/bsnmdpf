package cn.bsnmdpf.fcprt.ordercenter5020.mapper;

import cn.bsnmdpf.fcprt.api.pojo.Purchaseorder;
import cn.bsnmdpf.fcprt.api.pojo.PurchaseorderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PurchaseorderMapper {
    long countByExample(PurchaseorderExample example);

    int deleteByExample(PurchaseorderExample example);

    int insert(Purchaseorder record);

    int insertSelective(Purchaseorder record);

    List<Purchaseorder> selectByExample(PurchaseorderExample example);

    int updateByExampleSelective(@Param("record") Purchaseorder record, @Param("example") PurchaseorderExample example);

    int updateByExample(@Param("record") Purchaseorder record, @Param("example") PurchaseorderExample example);
}