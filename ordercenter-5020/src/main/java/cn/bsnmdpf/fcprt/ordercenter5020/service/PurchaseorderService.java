package cn.bsnmdpf.fcprt.ordercenter5020.service;

import cn.bsnmdpf.fcprt.api.pojo.Purchaseorder;
import cn.bsnmdpf.fcprt.api.pojo.PurchaseorderExample;
import cn.bsnmdpf.fcprt.ordercenter5020.mapper.PurchaseorderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author LicoLeung
 * @create 2020-02-07 22:21
 */
@Service
public class PurchaseorderService {

    @Autowired
    private PurchaseorderMapper purchaseorderMapper;

    public List<Purchaseorder> getPurchaseorders(Integer poid, Integer cid, String companyname, String billcode,
                                                 Date lessBilldate,Date greaterBilldate, Integer supplierid,
                                                 String suppliername,Integer mid, String material,Integer nnum,
                                                 String unit,Double money,Integer orderState,String creator, Date lessCreateTime,
                                                 Date greaterCreateTime, String modifier, Date lessModifyTime, Date greaterModifiyTime,
                                                 String approver,Date lessTaudittime,Date greaterTaudittime,String address){
        PurchaseorderExample purchaseorderExample = new PurchaseorderExample();
        PurchaseorderExample.Criteria criteria = purchaseorderExample.createCriteria();
        if(poid!=null){
            criteria.andPoidEqualTo(poid);
        }
        if(cid!=null){
            criteria.andCidEqualTo(cid);
        }
        if(companyname!=null){
            criteria.andCompanynameLike("%"+companyname+"%");
        }
        if(billcode!=null){
            criteria.andBillcodeEqualTo(billcode);
        }
        if(lessBilldate!=null){
            criteria.andBilldateLessThanOrEqualTo(lessBilldate);
        }
        if(greaterBilldate!=null){
            criteria.andBilldateGreaterThanOrEqualTo(greaterBilldate);
        }
        if(supplierid!=null){
            criteria.andSupplieridEqualTo(supplierid);
        }
        if(suppliername!=null){
            criteria.andSuppliernameLike("%"+suppliername+"%");
        }
        if(mid!=null){
            criteria.andMidEqualTo(mid);
        }
        if(material!=null){
            criteria.andMaterialLike("%"+material+"%");
        }
        if(nnum!=null){
            criteria.andNnumEqualTo(nnum);
        }
        if(unit!=null){
            criteria.andUnitEqualTo(unit);
        }
        if(money!=null){
            criteria.andMoneyEqualTo(money);
        }
        if(orderState!=null){
            criteria.andOrderstateEqualTo(orderState);
        }
        if (modifier != null) {
            modifier = "%" + modifier + "%";
            criteria.andModifierLike(modifier);
        }
        if (lessModifyTime != null) {
            criteria.andModifytimeLessThanOrEqualTo(lessModifyTime);
        }
        if (greaterModifiyTime != null) {
            criteria.andModifytimeGreaterThanOrEqualTo(greaterModifiyTime);
        }
        if (lessCreateTime != null) {
            criteria.andCreatetimeLessThanOrEqualTo(lessCreateTime);
        }
        if (greaterCreateTime != null) {
            criteria.andCreatetimeGreaterThanOrEqualTo(greaterCreateTime);
        }
        if (creator != null) {
            criteria.andCreatorLike("%" + creator + "%");
        }
        if(approver!=null){
            criteria.andApproverLike("%"+approver+"%");
        }
        if(lessTaudittime!=null){
            criteria.andTaudittimeLessThanOrEqualTo(lessTaudittime);
        }
        if(greaterTaudittime!=null){
            criteria.andTaudittimeGreaterThanOrEqualTo(greaterTaudittime);
        }
        if(address!=null){
            criteria.andAddressLike("%"+address+"%");
        }
        List<Purchaseorder> purchaseorders = purchaseorderMapper.selectByExample(purchaseorderExample);
        return purchaseorders;
    }
}
