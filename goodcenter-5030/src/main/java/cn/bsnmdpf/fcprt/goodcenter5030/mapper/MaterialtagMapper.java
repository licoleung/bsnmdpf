package cn.bsnmdpf.fcprt.goodcenter5030.mapper;

import cn.bsnmdpf.fcprt.api.pojo.Materialtag;
import cn.bsnmdpf.fcprt.api.pojo.MaterialtagExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MaterialtagMapper {
    long countByExample(MaterialtagExample example);

    int deleteByExample(MaterialtagExample example);

    int insert(Materialtag record);

    int insertSelective(Materialtag record);

    List<Materialtag> selectByExample(MaterialtagExample example);

    int updateByExampleSelective(@Param("record") Materialtag record, @Param("example") MaterialtagExample example);

    int updateByExample(@Param("record") Materialtag record, @Param("example") MaterialtagExample example);
}