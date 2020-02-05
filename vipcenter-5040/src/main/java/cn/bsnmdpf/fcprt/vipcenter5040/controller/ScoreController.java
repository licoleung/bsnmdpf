package cn.bsnmdpf.fcprt.vipcenter5040.controller;

import cn.bsnmdpf.fcprt.api.pojo.Score;
import cn.bsnmdpf.fcprt.vipcenter5040.service.ScoreService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author LicoLeung
 * @create 2020-02-04 13:28
 */
@RestController
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    /**
     * 获取积分明细
     *
     * @param pageSize
     * @param page
     * @param scoreid
     * @param vipid
     * @param lessGetTime
     * @param greaterGetTime
     * @param score
     * @return 积分明细
     */
    @GetMapping("score")
    public PageInfo<Score> getScoreDetail(@RequestParam(value = "pageSize") int pageSize,
                                          @RequestParam(value = "page") int page,
                                          @RequestParam(value = "screid", required = false) Integer scoreid,
                                          @RequestParam(value = "vipid", required = false) Integer vipid,
                                          @RequestParam(value = "lessGetTime", required = false) Date lessGetTime,
                                          @RequestParam(value = "greaterGetTime", required = false) Date greaterGetTime,
                                          @RequestParam(value = "score", required = false) Integer score) {
        PageHelper.startPage(page, pageSize);
        List<Score> scores = scoreService.getScore(scoreid, vipid, lessGetTime, greaterGetTime, score);
        PageInfo<Score> pageInfo = new PageInfo<>(scores);
        return pageInfo;
    }

    /**
     * 删除积分记录
     * 所有条件为空时会在service层报错
     *
     * @param scoreid
     * @param vipid
     * @param lessGetTime
     * @return 返回删除条数
     */
    @DeleteMapping("score")
    public int deleteScore(@RequestParam(value = "screid", required = false) Integer scoreid,
                           @RequestParam(value = "vipid", required = false) Integer vipid,
                           @RequestParam(value = "lessGetTime", required = false) Date lessGetTime) {
        int i = scoreService.deleteScoreRecord(scoreid, vipid, lessGetTime);
        return i;
    }

    /**
     * 添加积分
     *
     * @param vipid
     * @param score
     * @return 成功返回true，失败返回false
     */
    @PostMapping("score")
    public boolean addScore(@RequestParam(value = "vipid") Integer vipid, @RequestParam("score") Integer score) {
        Score scorePojo = new Score();
        scorePojo.setGettime(new Date());
        scorePojo.setScore(score);
        scorePojo.setVipid(vipid);
        boolean b = scoreService.addScore(scorePojo);
        return b;
    }

    /**
     * 每个vip总的积分
     * @param pageSize
     * @param page
     * @return score的list，但只含vipid及score字段
     */
    @GetMapping("scores")
    public PageInfo<Score> getScore(@RequestParam(value = "pageSize") int pageSize,
                                    @RequestParam(value = "page") int page) {
        PageHelper.startPage(page, pageSize);
        List<Score> scores = scoreService.keyofvipidandvalueofscore();
        PageInfo<Score> pageInfo = new PageInfo<>(scores);
        return pageInfo;
    }
}
