package cn.bsnmdpf.fcprt.api.service;

import cn.bsnmdpf.fcprt.api.pojo.Score;
import cn.bsnmdpf.fcprt.api.pojo.VIP;
import cn.bsnmdpf.fcprt.api.pojo.VIPTag;
import com.github.pagehelper.PageInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @author LicoLeung
 * @create 2020-02-04 14:51
 */
@FeignClient(value = "vipcenter-5040")
public interface VIPCenterService {

    //ScoreController

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
                                          @RequestParam(value = "score", required = false) Integer score);
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
                           @RequestParam(value = "lessGetTime", required = false) Date lessGetTime);
    /**
     * 添加积分
     *
     * @param vipid
     * @param score
     * @return 成功返回true，失败返回false
     */
    @PostMapping("score")
    public boolean addScore(@RequestParam(value = "vipid") Integer vipid, @RequestParam("score") Integer score);


    /**
     * 每个vip总的积分
     * @param pageSize
     * @param page
     * @return score的list，但只含vipid及score字段
     */
    @GetMapping("scores")
    public PageInfo<Score> getScore(@RequestParam(value = "pageSize") int pageSize,@RequestParam(value = "page") int page);

    //VIPController

    /**
     * 获取符合条件的vip列表，并且把对应的积分及标签信息注入进去
     * @param pageSize
     * @param page
     * @param vipid 编码（主键）
     * @param vipname 姓名
     * @param phone 手机号
     * @param email 电子邮箱
     * @param qq qq号
     * @param lessCunsumption 消费金额最大值
     * @param greaterCunsumption 消费金额最小值
     * @param lesscstTime 最大消费次数
     * @param greatercstTime 最小消费次数
     * @param cstCycle 消费周期
     * @param level 等级
     * @param lessRegistTime 注册时间最大值
     * @param greaterRegistTime 注册时间最小值
     * @param lessBalance 余额最大值
     * @param greaterBalance 余额最小值
     * @param isStuff 是否员工
     * @param isActive 封锁或不封锁
     * @param bandid 绑定某个平台的id
     * @param spare 备用
     * @return 符合条件的vip列表
     */
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
                                               @RequestParam(value ="spare",required = false)String spare);

    /**
     * 添加/注册vip账号
     * @param vipid 编码，数据库自动递增
     * @param vipname 姓名，必填
     * @param phone 手机号码，必填
     * @param email 邮箱
     * @param qq qq
     * @param cunsumption 消费金额，默认0.0
     * @param cstTime 消费次数，默认0
     * @param cstCycle 消费周期，默认无消费
     * @param level 等级，默认1
     * @param balance 余额，默认0.0
     * @param isStuff 是否员工，默认否
     * @param isActive 是否生效，默认是
     * @param bandid 绑定某平台的id
     * @param spare 备用
     * @return 成功返回true，失败返回false
     */
    @PostMapping("vip")
    public boolean addVIP(@RequestParam(value = "vipid",required = false) Integer vipid,
                          @RequestParam(value ="vipname") String vipname,
                          @RequestParam(value ="phone") String phone,
                          @RequestParam(value ="email",required = false) String email,
                          @RequestParam(value ="qq",required = false) String qq,
                          @RequestParam(value ="cunsumption",required = false) Double cunsumption,
                          @RequestParam(value ="cstTime",required = false) Integer cstTime,
                          @RequestParam(value ="cstCycle",required = false) String cstCycle,
                          @RequestParam(value ="level",required = false) Integer level,
                          @RequestParam(value ="balance",required = false) Double balance,
                          @RequestParam(value ="isStuff",required = false)Integer isStuff,
                          @RequestParam(value ="isActive",required = false)Integer isActive,
                          @RequestParam(value ="bandid",required = false)String bandid,
                          @RequestParam(value ="spare",required = false)String spare);

    /**
     * 根据id封锁vip账号
     * @param vipid
     * @return 成功返回true，失败返回false
     */
    @DeleteMapping("vip/{vipid}")
    public boolean deleteVIP(@PathVariable("vipid") Integer vipid);

    /**
     * 更新vip信息
     * @param vipid
     * @param vipname
     * @param phone
     * @param email
     * @param qq
     * @param cunsumption
     * @param cstTime
     * @param cstCycle
     * @param level
     * @param balance
     * @param isStuff
     * @param isActive
     * @param bandid
     * @param spare
     * @return 成功返回true，失败返回false
     */
    @PutMapping("vip/{vipid}")
    public boolean updateVIP(@PathVariable("vipid") Integer vipid,
                             @RequestParam(value ="vipname",required = false) String vipname,
                             @RequestParam(value ="phone",required = false) String phone,
                             @RequestParam(value ="email",required = false) String email,
                             @RequestParam(value ="qq",required = false) String qq,
                             @RequestParam(value ="cunsumption",required = false) Double cunsumption,
                             @RequestParam(value ="cstTime",required = false) Integer cstTime,
                             @RequestParam(value ="cstCycle",required = false) String cstCycle,
                             @RequestParam(value ="level",required = false) Integer level,
                             @RequestParam(value ="balance",required = false) Double balance,
                             @RequestParam(value ="isStuff",required = false)Integer isStuff,
                             @RequestParam(value ="isActive",required = false)Integer isActive,
                             @RequestParam(value ="bandid",required = false)String bandid,
                             @RequestParam(value ="spare",required = false)String spare);

    /**
     * 含有tagname的vip
     * @param pageSize
     * @param page
     * @param tagnames 一个或多个标签名称，传输格式为('xx','xxx','xxxx')
     * @return
     */
    @GetMapping("vipWithTagScreen")
    public PageInfo<VIP> getVIPwithTagScreen(@RequestParam(value = "pageSize") int pageSize,
                                             @RequestParam(value = "page") int page,
                                             @RequestParam("tagnames") String tagnames);

    //VIPTagController

    /**
     * 给用户添加标签
     *
     * @param vipid
     * @param tagname
     * @return 成功返回true，失败返回false
     */
    @PostMapping("viptag")
    public boolean addTag(@RequestParam(value = "vipid") Integer vipid, @RequestParam(value = "tagname") String tagname);


    /**
     * 删除用户所有标签或某个标签
     * 两个条件不能全为空，否则在service层会报错
     *
     * @param vtid
     * @param vipid
     * @return 成功返回true，失败返回false
     */
    @DeleteMapping("viptag")
    public int deleteTag(@RequestParam(value = "vtid", required = false) Integer vtid,
                         @RequestParam(value = "vipid", required = false) Integer vipid);


    /**
     * 查询标签明细
     * @param pageSize
     * @param page
     * @param vtid
     * @param vipid
     * @param tagname
     * @return 标签列表
     */
    @GetMapping("viptag")
    public PageInfo<VIPTag> getTagDetail(@RequestParam(value = "pageSize") int pageSize,
                                         @RequestParam(value = "page") int page,
                                         @RequestParam(value = "vtid", required = false) Integer vtid,
                                         @RequestParam(value = "vipid", required = false) Integer vipid,
                                         @RequestParam(value = "tagname", required = false) String tagname);
}
