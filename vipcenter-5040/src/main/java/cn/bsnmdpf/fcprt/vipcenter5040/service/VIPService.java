package cn.bsnmdpf.fcprt.vipcenter5040.service;

import cn.bsnmdpf.fcprt.api.pojo.VIP;
import cn.bsnmdpf.fcprt.api.pojo.VIPExample;
import cn.bsnmdpf.fcprt.vipcenter5040.mapper.VIPMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Date;

/**
 * @author LicoLeung
 * @create 2020-02-03 17:16
 */
@Service
public class VIPService {

    @Autowired
    private VIPMapper vipMapper;

    /**
     * 根据条件查询vip列表
     *
     * @param vipid              编码（主键）
     * @param vipname            姓名
     * @param phone              手机号
     * @param email              电子邮箱
     * @param qq                 qq号
     * @param lessCunsumption    消费金额最大值
     * @param greaterCunsumption 消费金额最小值
     * @param lesscstTime        最大消费次数
     * @param greatercstTime     最小消费次数
     * @param cstCycle           消费周期
     * @param level              等级
     * @param lessRegistTime     注册时间最大值
     * @param greaterRegistTime  注册时间最小值
     * @param lessBalance        余额最大值
     * @param greaterBalance     余额最小值
     * @param isStuff            是否员工
     * @param isActive           封锁或不封锁
     * @param bandid             绑定某个平台的id
     * @param spare              备用
     * @return 符合条件的vip列表
     */
    public List<VIP> getVIPs(Integer vipid, String vipname, String phone, String email, String qq, Double lessCunsumption, Double greaterCunsumption, Integer lesscstTime, Integer greatercstTime, String cstCycle, Integer level, Date lessRegistTime, Date greaterRegistTime, Double lessBalance, Double greaterBalance, Integer isStuff, Integer isActive, String bandid, String spare) {
        VIPExample vipExample = new VIPExample();
        VIPExample.Criteria criteria = vipExample.createCriteria();
        if (vipid != null) {
            criteria.andVipidEqualTo(vipid);
        }
        if (vipname != null) {
            criteria.andVipnameLike("%" + vipname + "%");
        }
        if (phone != null) {
            criteria.andPhoneEqualTo(phone);
        }
        if (email != null) {
            criteria.andEmailEqualTo(email);
        }
        if (qq != null) {
            criteria.andQqEqualTo(qq);
        }
        if (lessCunsumption != null) {
            criteria.andCunsumptionLessThanOrEqualTo(lessCunsumption);//<=
        }
        if (greaterCunsumption != null) {
            criteria.andCunsumptionGreaterThanOrEqualTo(greaterCunsumption);//>=
        }
        if (lesscstTime != null) {
            criteria.andCsttimeLessThanOrEqualTo(lesscstTime);
        }
        if (greatercstTime != null) {
            criteria.andCsttimeGreaterThanOrEqualTo(greatercstTime);
        }
        if (cstCycle != null) {
            criteria.andCstcycleEqualTo(cstCycle);
        }
        if (level != null) {
            criteria.andLevelEqualTo(level);
        }
        if (lessRegistTime != null) {
            criteria.andRegisttimeLessThanOrEqualTo(lessRegistTime);//<=
        }
        if (greaterRegistTime != null) {
            criteria.andRegisttimeGreaterThanOrEqualTo(greaterRegistTime);//>=
        }
        if (lessBalance != null) {
            criteria.andBalanceLessThanOrEqualTo(lessBalance);
        }
        if (greaterBalance != null) {
            criteria.andBalanceGreaterThanOrEqualTo(greaterBalance);
        }
        if (isStuff != null) {
            criteria.andIsstuffEqualTo(isStuff);
        }
        if (isActive != null) {
            criteria.andIsactiveEqualTo(isActive);
        }
        if (bandid != null) {
            criteria.andBandidEqualTo(bandid);
        }
        if (spare != null) {
            criteria.andSpareEqualTo(spare);
        }
        List<VIP> vips = vipMapper.selectByExample(vipExample);
        return vips;
    }

    /**
     * 增加/注册vip账户
     *
     * @param vip
     * @return 成功返回true，失败返回false
     */
    @Transactional
    public boolean addVip(VIP vip) throws RuntimeException {
        int insert = vipMapper.insert(vip);
        if (insert == 1) {
            return true;
        } else {
            throw new RuntimeException("未知错误，请检查VIP中的必填字段是否完整");
        }
    }

    /**
     * 封锁/删除vip账号
     *
     * @param vipid
     * @return 成功返回true，失败返回false
     */
    @Transactional
    public boolean unableVIPByVIPid(Integer vipid) throws RuntimeException {
        VIP vip = new VIP();
        vip.setIsactive(0);
        VIPExample vipExample = new VIPExample();
        VIPExample.Criteria criteria = vipExample.createCriteria();
        criteria.andVipidEqualTo(vipid);
        int i = vipMapper.updateByExampleSelective(vip, vipExample);
        if (i == 1) {
            return true;
        } else {
            throw new RuntimeException("未知错误，无法删除，或可能找不到对应vipid的vip");
        }
    }

    /**
     * 解封vip账户
     *
     * @param vipid
     * @return 成功返回true，失败返回false
     */
    @Transactional
    public boolean ableVIPByVIPid(Integer vipid) throws RuntimeException {
        VIP vip = new VIP();
        vip.setIsactive(1);
        VIPExample vipExample = new VIPExample();
        VIPExample.Criteria criteria = vipExample.createCriteria();
        criteria.andVipidEqualTo(vipid);
        int i = vipMapper.updateByExampleSelective(vip, vipExample);
        if (i == 1) {
            return true;
        } else {
            throw new RuntimeException("未知错误，无法解封，或可能找不到对应vipid的vip");
        }
    }

    /**
     * 更新vip账户
     *
     * @param vip
     * @return 成功返回true，失败返回false
     */
    @Transactional
    public boolean updateVIP(VIP vip) throws RuntimeException {
        VIPExample vipExample = new VIPExample();
        VIPExample.Criteria criteria = vipExample.createCriteria();
        criteria.andVipidEqualTo(vip.getVipid());
        int i = vipMapper.updateByExampleSelective(vip, vipExample);
        if (i == 1) {
            return true;
        } else {
            throw new RuntimeException("未知错误，无法更新，或可能找不到对应vipid的vip");
        }
    }

    /**
     * 通过标签筛选vip
     *
     * @param tagnames
     * @return 符合条件的vip列表
     */
    public List<VIP> selectVIPwithTagScreen(String tagnames) {
        List<VIP> vips = vipMapper.tagScreen(tagnames);
        return vips;
    }
}
