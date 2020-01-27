package cn.bsnmdpf.fcprt.stockcenter5050.mapper;

import cn.bsnmdpf.fcprt.stockcenter5050.pojo.Outstockbill;
import cn.bsnmdpf.fcprt.stockcenter5050.pojo.OutstockbillExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OutstockbillMapper {
    long countByExample(OutstockbillExample example);

    int deleteByExample(OutstockbillExample example);

    int insert(Outstockbill record);

    int insertSelective(Outstockbill record);

    List<Outstockbill> selectByExample(OutstockbillExample example);

    int updateByExampleSelective(@Param("record") Outstockbill record, @Param("example") OutstockbillExample example);

    int updateByExample(@Param("record") Outstockbill record, @Param("example") OutstockbillExample example);
}