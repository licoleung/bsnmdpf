package cn.bsnmdpf.fcprt.vipcenter5040.service;

import cn.bsnmdpf.fcprt.api.pojo.Score;
import cn.bsnmdpf.fcprt.api.pojo.ScoreExample;
import cn.bsnmdpf.fcprt.vipcenter5040.mapper.ScoreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author LicoLeung
 * @create 2020-02-03 22:38
 */
@Service
public class ScoreService {

    @Autowired
    private ScoreMapper scoreMapper;

    /**
     * 获取积分列表
     *
     * @param scoreid
     * @param vipid
     * @param lessGetTime    小于这个获取时间
     * @param greaterGetTime 大于这个获取时间
     * @param score
     * @return
     */
    public List<Score> getScore(Integer scoreid, Integer vipid, Date lessGetTime, Date greaterGetTime, Integer score) {
        ScoreExample scoreExample = new ScoreExample();
        ScoreExample.Criteria criteria = scoreExample.createCriteria();
        if (scoreid != null) {
            criteria.andScoreidEqualTo(scoreid);
        }
        if (vipid != null) {
            criteria.andVipidEqualTo(vipid);
        }
        if (lessGetTime != null) {
            criteria.andGettimeLessThanOrEqualTo(lessGetTime);//<=
        }
        if (greaterGetTime != null) {
            criteria.andGettimeGreaterThanOrEqualTo(greaterGetTime);//>=
        }
        if (score != null) {
            criteria.andScoreEqualTo(score);
        }
        List<Score> scores = scoreMapper.selectByExample(scoreExample);
        return scores;
    }

    /**
     * 删除积分记录
     *
     * @param scoreid
     * @param vipid
     * @param lessGetTime 小于这个时间的记录
     * @return 返回成功条数
     */
    public int deleteScoreRecord(Integer scoreid, Integer vipid, Date lessGetTime) {
        try {
            if (scoreid == null && vipid == null && lessGetTime == null) {
                throw new Exception("不允许无任何删除条件，此操作会删除所有积分记录");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        ScoreExample scoreExample = new ScoreExample();
        ScoreExample.Criteria criteria = scoreExample.createCriteria();
        if (scoreid != null) {
            criteria.andScoreidEqualTo(scoreid);
        }
        if (lessGetTime != null) {
            criteria.andGettimeLessThanOrEqualTo(lessGetTime);//<=这个时间的记录会被删掉
        }
        if (vipid != null) {
            criteria.andVipidEqualTo(vipid);
        }
        int i = scoreMapper.deleteByExample(scoreExample);
        return i;
    }

    /**
     * 增加积分记录
     *
     * @param score
     * @return 成功返回true，失败返回false
     */
    public boolean addScore(Score score) {
        int insert = scoreMapper.insert(score);
        try {
            if (insert == 1) {
                return true;
            } else {
                throw new Exception("未知错误，请检查Score中的必填字段是否完整");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 每个vip总的积分
     *
     * @return score的list，但只含vipid及score字段
     */
    public List<Score> keyofvipidandvalueofscore() {
        List<Score> scores = scoreMapper.selectScoreGroupByVIPID();
        return scores;
    }
}
