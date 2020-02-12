package cn.bsnmdpf.fcprt.salecenter5060.mapper;

import java.util.List;

import cn.bsnmdpf.fcprt.api.pojo.Activity;
import cn.bsnmdpf.fcprt.api.pojo.ActivityExample;
import org.apache.ibatis.annotations.Param;

public interface ActivityMapper {
    long countByExample(ActivityExample example);

    int deleteByExample(ActivityExample example);

    int insert(Activity record);

    int insertSelective(Activity record);

    List<Activity> selectByExample(ActivityExample example);

    int updateByExampleSelective(@Param("record") Activity record, @Param("example") ActivityExample example);

    int updateByExample(@Param("record") Activity record, @Param("example") ActivityExample example);
}