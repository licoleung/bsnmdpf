package cn.bsnmdpf.fcprt.stockcenter5050.mapper;

import cn.bsnmdpf.fcprt.api.pojo.Instockbill;
import cn.bsnmdpf.fcprt.api.pojo.InstockbillExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InstockbillMapper {
    long countByExample(InstockbillExample example);

    int deleteByExample(InstockbillExample example);

    int insert(Instockbill record);

    int insertSelective(Instockbill record);

    List<Instockbill> selectByExample(InstockbillExample example);

    int updateByExampleSelective(@Param("record") Instockbill record, @Param("example") InstockbillExample example);

    int updateByExample(@Param("record") Instockbill record, @Param("example") InstockbillExample example);
}