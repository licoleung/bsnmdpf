package cn.bsnmdpf.fcprt.ordercenter5020.service;

import cn.bsnmdpf.fcprt.api.pojo.Saleorder;
import cn.bsnmdpf.fcprt.api.pojo.SaleorderExample;
import cn.bsnmdpf.fcprt.ordercenter5020.mapper.SaleorderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author LicoLeung
 * @create 2020-02-08 18:04
 */
@Service
public class SaleorderService {

    @Autowired
    private SaleorderMapper saleorderMapper;

    /**
     * 根据条件获取销售订单列表
     *
     * @param soid               销售订单主键
     * @param cid                公司主键
     * @param companyname        公司名称
     * @param billcode           单据号
     * @param lessBilldate       最大单据日期
     * @param greaterBilldate    最小单据日期
     * @param vipid              vip id
     * @param vipname            vip姓名
     * @param mid                物料编码
     * @param material           物料名称
     * @param nnum               数量
     * @param unit               单位
     * @param money              金额
     * @param orderState         订单状态（0：封锁，1：未审批，2：已审批）
     * @param creator            创建者
     * @param lessCreateTime     最大创建时间
     * @param greaterCreateTime  最小创建时间
     * @param modifier           修改者
     * @param lessModifyTime     最大修改时间
     * @param greaterModifiyTime 最小修改时间
     * @param approver           审批人
     * @param lessTaudittime     最大审批时间
     * @param greaterTaudittime  最小审批时间
     * @param address            地址
     * @return 符合条件的销售订单列表
     */
    public List<Saleorder> getSaleorders(Integer soid, Integer cid, String companyname, String billcode,
                                         Date lessBilldate, Date greaterBilldate, Integer vipid,
                                         String vipname, Integer mid, String material, Integer nnum,
                                         String unit, Double money, Integer orderState, String creator, Date lessCreateTime,
                                         Date greaterCreateTime, String modifier, Date lessModifyTime, Date greaterModifiyTime,
                                         String approver, Date lessTaudittime, Date greaterTaudittime, String address) {
        SaleorderExample saleorderExample = new SaleorderExample();
        SaleorderExample.Criteria criteria = saleorderExample.createCriteria();

        if (soid != null) {
            criteria.andSoidEqualTo(soid);
        }
        if (cid != null) {
            criteria.andCidEqualTo(cid);
        }
        if (companyname != null) {
            criteria.andCompanynameLike("%" + companyname + "%");
        }
        if (billcode != null) {
            criteria.andBillcodeEqualTo(billcode);
        }
        if (lessBilldate != null) {
            criteria.andBilldateLessThanOrEqualTo(lessBilldate);
        }
        if (greaterBilldate != null) {
            criteria.andBilldateGreaterThanOrEqualTo(greaterBilldate);
        }
        if (vipid != null) {
            criteria.andVipidEqualTo(vipid);
        }
        if (vipname != null) {
            criteria.andVipnameLike("%" + vipname + "%");
        }
        if (mid != null) {
            criteria.andMidEqualTo(mid);
        }
        if (material != null) {
            criteria.andMaterialLike("%" + material + "%");
        }
        if (nnum != null) {
            criteria.andNnumEqualTo(nnum);
        }
        if (unit != null) {
            criteria.andUnitEqualTo(unit);
        }
        if (money != null) {
            criteria.andMoneyEqualTo(money);
        }
        if (orderState != null) {
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
        if (approver != null) {
            criteria.andApproverLike("%" + approver + "%");
        }
        if (lessTaudittime != null) {
            criteria.andTaudittimeLessThanOrEqualTo(lessTaudittime);
        }
        if (greaterTaudittime != null) {
            criteria.andTaudittimeGreaterThanOrEqualTo(greaterTaudittime);
        }
        if (address != null) {
            criteria.andAddressLike("%" + address + "%");
        }
        List<Saleorder> saleorders = saleorderMapper.selectByExample(saleorderExample);
        return saleorders;
    }

    /**
     * 添加销售订单
     *
     * @param saleorder 销售订单
     * @return 成功返回true，失败返回false
     * @throws RuntimeException
     */
    @Transactional
    public boolean addSaleorder(Saleorder saleorder) throws RuntimeException {
        int i = saleorderMapper.insertSelective(saleorder);
        if (i == 1) {
            return true;
        } else {
            throw new RuntimeException("增加购买订单失败，请检查必填项是否完整");
        }
    }

    /**
     * 更新销售订单
     *
     * @param saleorder 销售订单
     * @return 成功返回true，失败返回false
     * @throws RuntimeException
     */
    @Transactional
    public boolean updateSaleorder(Saleorder saleorder) throws RuntimeException {
        SaleorderExample saleorderExample = new SaleorderExample();
        SaleorderExample.Criteria criteria = saleorderExample.createCriteria();
        criteria.andSoidEqualTo(saleorder.getSoid());
        int i = saleorderMapper.updateByExampleSelective(saleorder, saleorderExample);
        if (i == 1) {
            return true;
        } else {
            throw new RuntimeException("未知错误，无法更新，或可能找不到对应soid的销售订单");
        }
    }

    /**
     * 设置订单状态
     * 若想删除或废弃订单，则将订单状态设置为0
     *
     * @param soid       购买订单主键
     * @param orderState 订单状态（0：封锁，1：未审批，2：已审批）
     * @return 成功返回true，失败返回false
     * @throws RuntimeException
     */
    @Transactional
    public boolean setState(Integer soid, Integer orderState) throws RuntimeException {
        SaleorderExample saleorderExample = new SaleorderExample();
        SaleorderExample.Criteria criteria = saleorderExample.createCriteria();
        criteria.andSoidEqualTo(soid);
        Saleorder saleorder = new Saleorder();
        saleorder.setOrderstate(orderState);
        int i = saleorderMapper.updateByExampleSelective(saleorder, saleorderExample);
        if (i == 1) {
            return true;
        } else {
            throw new RuntimeException("未知错误，无法更改订单状态，或可能找不到对应soid的销售订单");
        }
    }
}
