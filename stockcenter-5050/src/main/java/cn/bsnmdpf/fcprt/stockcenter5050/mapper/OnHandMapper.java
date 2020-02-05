package cn.bsnmdpf.fcprt.stockcenter5050.mapper;

import cn.bsnmdpf.fcprt.api.pojo.OnHand;
import cn.bsnmdpf.fcprt.api.pojo.OnHandExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OnHandMapper {
    long countByExample(OnHandExample example);

    int deleteByExample(OnHandExample example);

    int insert(OnHand record);

    int insertSelective(OnHand record);

    List<OnHand> selectByExample(OnHandExample example);

    int updateByExampleSelective(@Param("record") OnHand record, @Param("example") OnHandExample example);

    int updateByExample(@Param("record") OnHand record, @Param("example") OnHandExample example);
}