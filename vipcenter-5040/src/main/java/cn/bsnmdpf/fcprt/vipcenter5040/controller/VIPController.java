package cn.bsnmdpf.fcprt.vipcenter5040.controller;

import cn.bsnmdpf.fcprt.api.pojo.Score;
import cn.bsnmdpf.fcprt.api.pojo.VIP;
import cn.bsnmdpf.fcprt.api.pojo.VIPTag;
import cn.bsnmdpf.fcprt.vipcenter5040.service.ScoreService;
import cn.bsnmdpf.fcprt.vipcenter5040.service.VIPService;
import cn.bsnmdpf.fcprt.vipcenter5040.service.VIPTagService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * @author LicoLeung
 * @create 2020-02-03 22:51
 */
@RestController
public class VIPController {

    @Autowired
    private VIPService vipService;

    @Autowired
    private ScoreService scoreService;

    @Autowired
    private VIPTagService vipTagService;

    @GetMapping("vip")
    public PageInfo<VIP> getVIPwithScoreAndTag(@RequestParam(value = "pageSize") int pageSize,
                                               @RequestParam(value = "page") int page,
                                               @RequestParam(value = "vipid",required = false) Integer vipid,
                                               @RequestParam(value ="vipname",required = false) String vipname,
                                               @RequestParam(value ="phone",required = false) String phone,
                                               @RequestParam(value ="email",required = false) String email,
                                               @RequestParam(value ="qq",required = false) String qq,
                                               @RequestParam(value ="lessCunsumption",required = false) Double lessCunsumption,
                                               @RequestParam(value ="greaterCunsumption",required = false) Double greaterCunsumption,
                                               @RequestParam(value ="lesscstTime",required = false) Integer lesscstTime,
                                               @RequestParam(value ="greatercstTime",required = false) Integer greatercstTime,
                                               @RequestParam(value ="cstCycle",required = false) String cstCycle,
                                               @RequestParam(value ="level",required = false) Integer level,
                                               @RequestParam(value ="lessRegistTime",required = false) Date lessRegistTime,
                                               @RequestParam(value ="greaterRegistTime",required = false) Date greaterRegistTime,
                                               @RequestParam(value ="lessBalance",required = false) Double lessBalance,
                                               @RequestParam(value ="greaterBalance",required = false) Double greaterBalance,
                                               @RequestParam(value ="isStuff",required = false)Integer isStuff,
                                               @RequestParam(value ="isActive",required = false)Integer isActive,
                                               @RequestParam(value ="bandid",required = false)String bandid,
                                               @RequestParam(value ="spare",required = false)String spare){
        PageHelper.startPage(page,pageSize);
        List<VIP> viPs = vipService.getVIPs(vipid, vipname, phone, email, qq, lessCunsumption, greaterCunsumption, lesscstTime, greatercstTime, cstCycle, level, lessRegistTime, greaterRegistTime, lessBalance, greaterBalance, isStuff, isActive, bandid, spare);
        for(VIP vip:viPs){
            ///将积分注入vip
            List<Score> scores = scoreService.getScore(null, vip.getVipid(), null, null, null);
            int res = 0;
            for(Score score:scores){
                Integer sc = score.getScore();
                res+=sc;
            }
            vip.setScore(res);

            ///将标签注入vip
            List<VIPTag> vipTags = vipTagService.selectTagByVIPidorTagid(vip.getVipid(), null, null);
            vip.setVipTags(vipTags);
        }
        PageInfo<VIP> pageInfo = new PageInfo<>(viPs);
        return pageInfo;
    }
}
