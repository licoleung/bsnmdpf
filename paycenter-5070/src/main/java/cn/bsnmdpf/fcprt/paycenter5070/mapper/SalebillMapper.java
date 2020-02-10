package cn.bsnmdpf.fcprt.paycenter5070.mapper;

import java.util.List;

import cn.bsnmdpf.fcprt.api.pojo.Salebill;
import cn.bsnmdpf.fcprt.api.pojo.SalebillExample;
import org.apache.ibatis.annotations.Param;

public interface SalebillMapper {
    long countByExample(SalebillExample example);

    int deleteByExample(SalebillExample example);

    int insert(Salebill record);

    int insertSelective(Salebill record);

    List<Salebill> selectByExample(SalebillExample example);

    int updateByExampleSelective(@Param("record") Salebill record, @Param("example") SalebillExample example);

    int updateByExample(@Param("record") Salebill record, @Param("example") SalebillExample example);
}