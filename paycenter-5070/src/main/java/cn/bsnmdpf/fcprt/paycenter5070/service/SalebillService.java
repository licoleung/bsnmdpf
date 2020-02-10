package cn.bsnmdpf.fcprt.paycenter5070.service;

import cn.bsnmdpf.fcprt.api.pojo.Salebill;
import cn.bsnmdpf.fcprt.api.pojo.SalebillExample;
import cn.bsnmdpf.fcprt.paycenter5070.mapper.SalebillMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author LicoLeung
 * @create 2020-02-10 12:29
 */
@Service
public class SalebillService {

    @Autowired
    private SalebillMapper salebillMapper;

    @Transactional
    public boolean addSalebill(String trade_no,String out_trade_no,Double money,String operator) throws RuntimeException{
        Salebill salebill = new Salebill();
        salebill.setSbid(trade_no);
        salebill.setBillcode(out_trade_no);
        salebill.setBilldate(new Date());
        salebill.setMoney(money);
        salebill.setOperator(operator);
        salebill.setIsactive(1);
        int insert = salebillMapper.insert(salebill);
        if(insert==1){
            return true;
        }else{
            throw new RuntimeException("添加失败，原因不明");
        }
    }

    public List<Salebill> getSalebills(String sbid,String billcode,Double lessMoney,Double greaterMoney,
                                       Date lessBilldate,Date greaterBilldate,String operator,Integer isActive,
                                       String account,String spare){
        SalebillExample salebillExample = new SalebillExample();
        SalebillExample.Criteria criteria = salebillExample.createCriteria();
        if(sbid!=null){
            criteria.andSbidEqualTo(sbid);
        }
        if(billcode!=null){
            criteria.andBillcodeEqualTo(billcode);
        }
        if(lessMoney!=null){
            criteria.andMoneyLessThanOrEqualTo(lessMoney);
        }
        if(greaterMoney!=null){
            criteria.andMoneyGreaterThanOrEqualTo(greaterMoney);
        }
        if(lessBilldate!=null){
            criteria.andBilldateLessThanOrEqualTo(lessBilldate);
        }
        if(greaterBilldate!=null){
            criteria.andBilldateGreaterThanOrEqualTo(greaterBilldate);
        }
        if(operator!=null){
            criteria.andOperatorEqualTo(operator);
        }
        if(isActive!=null){
            criteria.andIsactiveEqualTo(isActive);
        }
        if(account!=null){
            criteria.andAccountEqualTo(account);
        }
        if(spare!=null){
            criteria.andSpareEqualTo(spare);
        }
        List<Salebill> salebills = salebillMapper.selectByExample(salebillExample);
        return salebills;
    }

    @Transactional
    public boolean unableSalebills(String sbid) throws RuntimeException{
        Salebill salebill = new Salebill();
        salebill.setIsactive(0);
        SalebillExample salebillExample = new SalebillExample();
        SalebillExample.Criteria criteria = salebillExample.createCriteria();
        criteria.andSbidEqualTo(sbid);
        int i = salebillMapper.updateByExampleSelective(salebill, salebillExample);
        if(i==1){
            return true;
        }else{
            throw new RuntimeException("无法删除，请检查销售单据主键");
        }
    }
}
