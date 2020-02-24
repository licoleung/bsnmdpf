package cn.bsnmdpf.fcprt.paycenter5070.service;

import cn.bsnmdpf.fcprt.api.pojo.Purchasebill;
import cn.bsnmdpf.fcprt.api.pojo.PurchasebillExample;
import cn.bsnmdpf.fcprt.paycenter5070.mapper.PurchasebillMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author LicoLeung
 * @create 2020-02-10 19:56
 */
@Service
public class PurchasebillService {

    @Autowired
    private PurchasebillMapper purchasebillMapper;

    public List<Purchasebill> getPurchasebills(String pbid, String billcode, Double lessMoney, Double greaterMoney,
                                               Date lessBilldate, Date greaterBilldate, String operator, Integer isActive,
                                               String account, String spare){
        PurchasebillExample purchasebillExample = new PurchasebillExample();
        PurchasebillExample.Criteria criteria = purchasebillExample.createCriteria();
        if(pbid!=null){
            criteria.andPbidEqualTo(pbid);
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
        List<Purchasebill> purchasebills = purchasebillMapper.selectByExample(purchasebillExample);
        return purchasebills;
    }
    
    @Transactional
    public boolean addPurchasebill(String trade_no,String out_trade_no,Double money,String operator) throws RuntimeException{
        Purchasebill purchasebill = new Purchasebill();
        purchasebill.setOperator(operator);
        purchasebill.setIsactive(1);
        purchasebill.setPbid(trade_no);
        purchasebill.setBillcode(out_trade_no);
        purchasebill.setBilldate(new Date());
        purchasebill.setMoney(money);
        int insert = purchasebillMapper.insert(purchasebill);
        if(insert==1){
            return true;
        }else{
            throw new RuntimeException("添加购买单据失败，原因不明");
        }
    }
    
    @Transactional
    public boolean unablePurchasebills(String pbid) throws RuntimeException{
        Purchasebill purchasebill = new Purchasebill();
        purchasebill.setIsactive(0);
        PurchasebillExample purchasebillExample = new PurchasebillExample();
        PurchasebillExample.Criteria criteria = purchasebillExample.createCriteria();
        criteria.andPbidEqualTo(pbid);
        int i = purchasebillMapper.updateByExampleSelective(purchasebill, purchasebillExample);
        if(i==1){
            return true;
        }else{
            throw new RuntimeException("无法删除，请检查销售单据主键");
        }
    }

    @Transactional
    public boolean ablePurchasebills(String pbid) throws RuntimeException{
        Purchasebill purchasebill = new Purchasebill();
        purchasebill.setIsactive(1);
        PurchasebillExample purchasebillExample = new PurchasebillExample();
        PurchasebillExample.Criteria criteria = purchasebillExample.createCriteria();
        criteria.andPbidEqualTo(pbid);
        int i = purchasebillMapper.updateByExampleSelective(purchasebill, purchasebillExample);
        if(i==1){
            return true;
        }else{
            throw new RuntimeException("无法恢复，请检查销售单据主键");
        }
    }
}
