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
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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

    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request) {
        //转换日期 注意这里的转化要和传进来的字符串的格式一直 如2015-9-9 就应该为yyyy-MM-dd
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));// CustomDateEditor为自定义日期编辑器
    }
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
                          @RequestParam(value ="spare",required = false)String spare){
        VIP vip = new VIP();
        if(vipid!=null){
            vip.setVipid(vipid);
        }
        vip.setVipname(vipname);
        vip.setPhone(phone);
        if(email!=null){
            vip.setEmail(email);
        }
        if(qq!=null){
            vip.setQq(qq);
        }
        if(cunsumption!=null){
            vip.setCunsumption(cunsumption);
        }else{
            vip.setCunsumption(0.0);
        }
        if(cstTime!=null){
            vip.setCsttime(cstTime);
        }else{
            vip.setCsttime(0);
        }
        if(cstCycle!=null){
            vip.setCstcycle(cstCycle);
        }else{
            vip.setCstcycle("无消费");
        }
        if(level!=null){
            vip.setLevel(level);
        }else{
            vip.setLevel(1);
        }
        if(balance!=null){
            vip.setBalance(balance);
        }else{
            vip.setBalance(0.0);
        }
        if(isStuff!=null){
            vip.setIsstuff(isStuff);
        }else{
            vip.setIsstuff(0);
        }
        if(isActive!=null){
            vip.setIsactive(isActive);
        }else{
            vip.setIsactive(1);
        }
        if(bandid!=null){
            vip.setBandid(bandid);
        }
        if(spare!=null){
            vip.setSpare(spare);
        }
        vip.setRegisttime(new Date());
        boolean b = vipService.addVip(vip);
        return b;
    }

    /**
     * 根据id封锁vip账号
     * @param vipid
     * @return 成功返回true，失败返回false
     */
    @DeleteMapping("vip/{vipid}")
    public boolean deleteVIP(@PathVariable("vipid") Integer vipid){
        boolean b = vipService.unableVIPByVIPid(vipid);
        return b;
    }

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
                             @RequestParam(value ="spare",required = false)String spare){
        VIP vip = new VIP();
        vip.setVipid(vipid);
        if(vipname!=null){
            vip.setVipname(vipname);
        }
        if(phone!=null) {
            vip.setPhone(phone);
        }
        if(email!=null){
            vip.setEmail(email);
        }
        if(qq!=null){
            vip.setQq(qq);
        }
        if(cunsumption!=null){
            vip.setCunsumption(cunsumption);
        }
        if(cstTime!=null){
            vip.setCsttime(cstTime);
        }
        if(cstCycle!=null){
            vip.setCstcycle(cstCycle);
        }
        if(level!=null){
            vip.setLevel(level);
        }
        if(balance!=null){
            vip.setBalance(balance);
        }
        if(isStuff!=null){
            vip.setIsstuff(isStuff);
        }
        if(isActive!=null){
            vip.setIsactive(isActive);
        }
        if(bandid!=null){
            vip.setBandid(bandid);
        }
        if(spare!=null){
            vip.setSpare(spare);
        }
        boolean b = vipService.updateVIP(vip);
        return b;
    }

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
                                             @RequestParam("tagnames") String tagnames){
        PageHelper.startPage(page,pageSize);
        List<VIP> vips = vipService.selectVIPwithTagScreen(tagnames);
        for(VIP vip:vips){
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
        PageInfo<VIP> pageInfo = new PageInfo<>(vips);
        return pageInfo;
    }
}
