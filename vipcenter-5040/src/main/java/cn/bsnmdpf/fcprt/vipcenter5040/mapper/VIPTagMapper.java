package cn.bsnmdpf.fcprt.vipcenter5040.mapper;

import cn.bsnmdpf.fcprt.vipcenter5040.pojo.VIPTag;
import cn.bsnmdpf.fcprt.vipcenter5040.pojo.VIPTagExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VIPTagMapper {
    long countByExample(VIPTagExample example);

    int deleteByExample(VIPTagExample example);

    int insert(VIPTag record);

    int insertSelective(VIPTag record);

    List<VIPTag> selectByExample(VIPTagExample example);

    int updateByExampleSelective(@Param("record") VIPTag record, @Param("example") VIPTagExample example);

    int updateByExample(@Param("record") VIPTag record, @Param("example") VIPTagExample example);
}