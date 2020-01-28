package cn.bsnmdpf.fcprt.goodcenter5030.mapper;

import cn.bsnmdpf.fcprt.api.pojo.Materialclass;
import cn.bsnmdpf.fcprt.api.pojo.MaterialclassExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MaterialclassMapper {
    long countByExample(MaterialclassExample example);

    int deleteByExample(MaterialclassExample example);

    int insert(Materialclass record);

    int insertSelective(Materialclass record);

    List<Materialclass> selectByExample(MaterialclassExample example);

    int updateByExampleSelective(@Param("record") Materialclass record, @Param("example") MaterialclassExample example);

    int updateByExample(@Param("record") Materialclass record, @Param("example") MaterialclassExample example);
}