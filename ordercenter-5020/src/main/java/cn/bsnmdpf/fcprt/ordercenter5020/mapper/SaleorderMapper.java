package cn.bsnmdpf.fcprt.ordercenter5020.mapper;

import java.util.List;

import cn.bsnmdpf.fcprt.api.pojo.Saleorder;
import cn.bsnmdpf.fcprt.api.pojo.SaleorderExample;
import org.apache.ibatis.annotations.Param;

public interface SaleorderMapper {
    long countByExample(SaleorderExample example);

    int deleteByExample(SaleorderExample example);

    int insert(Saleorder record);

    int insertSelective(Saleorder record);

    List<Saleorder> selectByExample(SaleorderExample example);

    int updateByExampleSelective(@Param("record") Saleorder record, @Param("example") SaleorderExample example);

    int updateByExample(@Param("record") Saleorder record, @Param("example") SaleorderExample example);
}