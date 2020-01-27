package cn.bsnmdpf.fcprt.vipcenter5040.mapper;

import cn.bsnmdpf.fcprt.vipcenter5040.pojo.VIP;
import cn.bsnmdpf.fcprt.vipcenter5040.pojo.VIPExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VIPMapper {
    long countByExample(VIPExample example);

    int deleteByExample(VIPExample example);

    int insert(VIP record);

    int insertSelective(VIP record);

    List<VIP> selectByExample(VIPExample example);

    int updateByExampleSelective(@Param("record") VIP record, @Param("example") VIPExample example);

    int updateByExample(@Param("record") VIP record, @Param("example") VIPExample example);
}