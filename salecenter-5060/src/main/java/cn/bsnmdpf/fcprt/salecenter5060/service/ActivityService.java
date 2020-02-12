package cn.bsnmdpf.fcprt.salecenter5060.service;

import cn.bsnmdpf.fcprt.api.pojo.Activity;
import cn.bsnmdpf.fcprt.api.pojo.ActivityExample;
import cn.bsnmdpf.fcprt.salecenter5060.mapper.ActivityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author LicoLeung
 * @create 2020-02-12 11:58
 */
@Service
public class ActivityService {

    @Autowired
    private ActivityMapper activityMapper;

    public List<Activity> getActivities(Integer aid, String activityname, String atype, String operator, String operatorPhone,
                                         Date lessCreateTime,Date greaterCreateTime,Date lessBeginTime,Date greaterBeginTime,
                                        Date lessEndTime,Date greaterEndTime, Integer mid,String mname,String mtag,
                                        Integer nnum,Double money,Integer minVipLevel,Integer maxVipLevel,Double fullReductionMoney){
        ActivityExample activityExample = new ActivityExample();
        ActivityExample.Criteria criteria = activityExample.createCriteria();
        if(aid!=null){
            criteria.andAidEqualTo(aid);
        }
        if(activityname!=null){
            criteria.andActivitynameLike("%"+activityname+"%");
        }
        if(atype!=null){
            criteria.andAtypeEqualTo(atype);
        }
        if(operator!=null){
            criteria.andOperatorEqualTo(operator);
        }
        if(operatorPhone!=null){
            criteria.andOperatorphoneEqualTo(operatorPhone);
        }
        if(lessCreateTime!=null){
            criteria.andCreatetimeLessThanOrEqualTo(lessCreateTime);
        }
        if(greaterCreateTime!=null){
            criteria.andCreatetimeGreaterThanOrEqualTo(greaterCreateTime);
        }
        if(lessBeginTime!=null){
            criteria.andBegintimeLessThanOrEqualTo(lessBeginTime);
        }
        if(greaterBeginTime!=null){
            criteria.andBegintimeGreaterThanOrEqualTo(greaterBeginTime);
        }
        if(lessEndTime!=null){
            criteria.andEndtimeLessThanOrEqualTo(lessBeginTime);
        }
        if(greaterEndTime!=null){
            criteria.andEndtimeGreaterThanOrEqualTo(greaterEndTime);
        }
        if(mid!=null){
            criteria.andMidEqualTo(mid);
        }
        if(mname!=null){
            criteria.andMnameLike("%"+mname+"%");
        }
        if(mtag!=null){
            criteria.andMtagLike("%"+mtag+"%");
        }
        if(nnum!=null){
            criteria.andNnumEqualTo(nnum);
        }
        if(money!=null){
            criteria.andMoneyEqualTo(money);
        }
        if(minVipLevel!=null){
            criteria.andMinviplevelEqualTo(minVipLevel);
        }
        if(maxVipLevel!=null){
            criteria.andMaxviplevelEqualTo(maxVipLevel);
        }
        if(fullReductionMoney!=null){
            criteria.andFullreductionmoneyEqualTo(fullReductionMoney);
        }
        List<Activity> activities = activityMapper.selectByExample(activityExample);
        return activities;
    }

    @Transactional
    public boolean addActivity(Integer aid, String activityname, String atype, String operator, String operatorPhone,
                               Date beginTime, Date endTime, Integer mid,String mname,String mtag,
                               Integer nnum,Double money,Integer minVipLevel,Integer maxVipLevel,Double fullReductionMoney) throws RuntimeException{
        Activity activity = new Activity();
        activity.setActivityname(activityname);
        activity.setAtype(atype);
        activity.setOperator(operator);
        activity.setOperatorphone(operatorPhone);
        activity.setCreatetime(new Date());
        activity.setBegintime(beginTime);
        activity.setEndtime(endTime);
        activity.setMid(mid);
        activity.setMname(mname);
        activity.setMtag(mtag);
        activity.setNnum(nnum);
        activity.setMoney(money);
        activity.setMinviplevel(minVipLevel);
        activity.setMaxviplevel(maxVipLevel);
        activity.setFullreductionmoney(fullReductionMoney);
        int i = activityMapper.insertSelective(activity);
        if(i==1){
            return true;
        }else{
            throw new RuntimeException("增加活动失败，请检查必填字段是否完整");
        }
    }

    @Transactional
    public boolean updateActivity(Integer aid, String activityname, String atype, String operator, String operatorPhone,
                                  Date beginTime, Date endTime, Integer mid,String mname,String mtag,
                                  Integer nnum,Double money,Integer minVipLevel,Integer maxVipLevel,Double fullReductionMoney) throws RuntimeException{
        Activity activity = new Activity();
        activity.setAid(aid);
        activity.setActivityname(activityname);
        activity.setAtype(atype);
        activity.setOperator(operator);
        activity.setOperatorphone(operatorPhone);
        activity.setBegintime(beginTime);
        activity.setEndtime(endTime);
        activity.setMid(mid);
        activity.setMname(mname);
        activity.setMtag(mtag);
        activity.setNnum(nnum);
        activity.setMoney(money);
        activity.setMinviplevel(minVipLevel);
        activity.setMaxviplevel(maxVipLevel);
        activity.setFullreductionmoney(fullReductionMoney);
        ActivityExample activityExample = new ActivityExample();
        ActivityExample.Criteria criteria = activityExample.createCriteria();
        criteria.andAidEqualTo(aid);
        int i = activityMapper.updateByExampleSelective(activity, activityExample);
        if(i==1){
            return true;
        }else{
            throw new RuntimeException("更新活动失败，请检查aid是否正确");
        }
    }

    @Transactional
    public boolean deleteActivity(Integer aid) throws RuntimeException{
        ActivityExample activityExample = new ActivityExample();
        ActivityExample.Criteria criteria = activityExample.createCriteria();
        criteria.andAidEqualTo(aid);
        int i = activityMapper.deleteByExample(activityExample);
        if(i==1){
            return true;
        }else{
            throw new RuntimeException("删除活动失败，请检查aid是否正确");
        }
    }
}
