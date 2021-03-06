package cn.bsnmdpf.fcprt.vipcenter5040.mapper;

import cn.bsnmdpf.fcprt.api.pojo.Score;
import cn.bsnmdpf.fcprt.api.pojo.ScoreExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface ScoreMapper {
    long countByExample(ScoreExample example);

    int deleteByExample(ScoreExample example);

    int insert(Score record);

    int insertSelective(Score record);

    List<Score> selectByExample(ScoreExample example);

    int updateByExampleSelective(@Param("record") Score record, @Param("example") ScoreExample example);

    int updateByExample(@Param("record") Score record, @Param("example") ScoreExample example);

    @Select("select vipid,sum(score) from tbl_score group by vipid")
    List<Score> selectScoreGroupByVIPID();

}