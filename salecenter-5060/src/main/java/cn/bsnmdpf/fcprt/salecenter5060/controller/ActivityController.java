package cn.bsnmdpf.fcprt.salecenter5060.controller;

import cn.bsnmdpf.fcprt.api.pojo.Activity;
import cn.bsnmdpf.fcprt.salecenter5060.service.ActivityService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author LicoLeung
 * @create 2020-02-12 14:26
 */
@RestController
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @GetMapping("activity")
    public PageInfo<Activity> getActivities(@RequestParam("pageSize") int pageSize,
                                            @RequestParam("page") int page,
                                            @RequestParam("aid") Integer aid,
                                            @RequestParam("activityname") String activityname,
                                            @RequestParam("atype") String atype,
                                            @RequestParam("operator") String operator,
                                            @RequestParam("operatorPhone") String operatorPhone,
                                            @RequestParam("lessCreateTime") Date lessCreateTime,
                                            @RequestParam("greaterCreateTime") Date greaterCreateTime,
                                            @RequestParam("lessBeginTime") Date lessBeginTime,
                                            @RequestParam("greaterBeginTime") Date greaterBeginTime,
                                            @RequestParam("lessEndTime") Date lessEndTime,
                                            @RequestParam("greaterEndTime") Date greaterEndTime,
                                            @RequestParam("mid") Integer mid,
                                            @RequestParam("mname") String mname,
                                            @RequestParam("mtag") String mtag,
                                            @RequestParam("nnum") Integer nnum,
                                            @RequestParam("money") Double money,
                                            @RequestParam("minVipLevel") Integer minVipLevel,
                                            @RequestParam("maxVipLevel") Integer maxVipLevel,
                                            @RequestParam("fullReductionMoney") Double fullReductionMoney){
        PageHelper.startPage(page,pageSize);
        List<Activity> activities = activityService.getActivities(aid, activityname, atype, operator, operatorPhone, lessCreateTime, greaterCreateTime, lessBeginTime,
                greaterBeginTime, lessEndTime, greaterEndTime, mid, mname, mtag, nnum, money, minVipLevel, maxVipLevel, fullReductionMoney);
        PageInfo<Activity> pageInfo = new PageInfo<>(activities);
        return pageInfo;
    }

    @PostMapping("activity")
    public boolean addActivity(@RequestParam(value = "aid",required = false) Integer aid,
                               @RequestParam("activityname") String activityname,
                               @RequestParam("atype") String atype,
                               @RequestParam("operator") String operator,
                               @RequestParam("operatorPhone") String operatorPhone,
                               @RequestParam("beginTime") Date beginTime,
                               @RequestParam("endTime") Date endTime,
                               @RequestParam(value = "mid",required = false) Integer mid,
                               @RequestParam(value = "mname",required = false) String mname,
                               @RequestParam(value = "mtag",required = false) String mtag,
                               @RequestParam(value = "nnum",required = false) Integer nnum,
                               @RequestParam(value = "money",required = false) Double money,
                               @RequestParam(value = "minVipLevel",required = false) Integer minVipLevel,
                               @RequestParam(value = "maxVipLevel",required = false) Integer maxVipLevel,
                               @RequestParam(value = "fullReductionMoney",required = false) Double fullReductionMoney){
        boolean b = activityService.addActivity(aid, activityname, atype, operator, operatorPhone, beginTime, endTime, mid, mname, mtag, nnum, money, minVipLevel, maxVipLevel, fullReductionMoney);
        return b;
    }

    @PutMapping("activity/{aid}")
    public boolean updateActivity(@PathVariable(value = "aid") Integer aid,
                                  @RequestParam(value = "activityname",required = false) String activityname,
                                  @RequestParam(value = "atype",required = false) String atype,
                                  @RequestParam(value = "operator",required = false) String operator,
                                  @RequestParam(value = "operatorPhone",required = false) String operatorPhone,
                                  @RequestParam(value = "beginTime",required = false) Date beginTime,
                                  @RequestParam(value = "endTime",required = false) Date endTime,
                                  @RequestParam(value = "mid",required = false) Integer mid,
                                  @RequestParam(value = "mname",required = false) String mname,
                                  @RequestParam(value = "mtag",required = false) String mtag,
                                  @RequestParam(value = "nnum",required = false) Integer nnum,
                                  @RequestParam(value = "money",required = false) Double money,
                                  @RequestParam(value = "minVipLevel",required = false) Integer minVipLevel,
                                  @RequestParam(value = "maxVipLevel",required = false) Integer maxVipLevel,
                                  @RequestParam(value = "fullReductionMoney",required = false) Double fullReductionMoney){
        boolean b = activityService.updateActivity(aid, activityname, atype, operator, operatorPhone, beginTime, endTime, mid, mname, mtag, nnum, money, minVipLevel, maxVipLevel, fullReductionMoney);
        return b;
    }

    @DeleteMapping("activity/{aid}")
    public boolean deleteActivity(@PathVariable("aid") Integer aid){
        boolean b = activityService.deleteActivity(aid);
        return b;
    }
}
