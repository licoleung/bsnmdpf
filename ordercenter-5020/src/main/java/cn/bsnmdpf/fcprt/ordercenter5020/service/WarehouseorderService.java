package cn.bsnmdpf.fcprt.ordercenter5020.service;

import cn.bsnmdpf.fcprt.api.pojo.Saleorder;
import cn.bsnmdpf.fcprt.api.pojo.SaleorderExample;
import cn.bsnmdpf.fcprt.api.pojo.Warehouseorder;
import cn.bsnmdpf.fcprt.api.pojo.WarehouseorderExample;
import cn.bsnmdpf.fcprt.ordercenter5020.mapper.WarehouseorderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author LicoLeung
 * @create 2020-02-08 18:21
 */
@Service
public class WarehouseorderService {

    @Autowired
    private WarehouseorderMapper warehouseorderMapper;

    /**
     * 根据条件查询存储订单列表
     *
     * @param whoid              存储订单主键
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
     * @param money              金额
     * @param weight             重量
     * @param volumn             体积
     * @param orderState         订单状态
     * @param creator            创建者
     * @param lessCreateTime     最大创建时间
     * @param greaterCreateTime  最小创建时间
     * @param modifier           修改者
     * @param lessModifyTime     最大修改时间
     * @param greaterModifiyTime 最小修改时间
     * @param whid               仓位id
     * @param warehouseName      仓位名称
     * @param sid                仓库id
     * @param stockName          仓库名称
     * @return 符合条件的存储订单列表
     */
    public List<Warehouseorder> getWarehouseorders(Integer whoid, Integer cid, String companyname, String billcode,
                                                   Date lessBilldate, Date greaterBilldate, Integer vipid,
                                                   String vipname, Integer mid, String material, Integer nnum,
                                                   Double money, Double weight, Double volumn, Integer orderState, String creator, Date lessCreateTime,
                                                   Date greaterCreateTime, String modifier, Date lessModifyTime, Date greaterModifiyTime,
                                                   Integer whid, String warehouseName, Integer sid, String stockName) {
        WarehouseorderExample warehouseorderExample = new WarehouseorderExample();
        WarehouseorderExample.Criteria criteria = warehouseorderExample.createCriteria();

        if (whoid != null) {
            criteria.andWhoidEqualTo(whoid);
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
        if (weight != null) {
            criteria.andWeightEqualTo(weight);
        }
        if (volumn != null) {
            criteria.andVolumnEqualTo(volumn);
        }
        if (nnum != null) {
            criteria.andNnumEqualTo(nnum);
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
        if (whid != null) {
            criteria.andWhidEqualTo(whid);
        }
        if (warehouseName != null) {
            criteria.andWarehousenameLike("%" + warehouseName + "%");
        }
        if (sid != null) {
            criteria.andSidEqualTo(sid);
        }
        if (stockName != null) {
            criteria.andStocknameLike("%" + stockName + "%");
        }
        List<Warehouseorder> warehouseorders = warehouseorderMapper.selectByExample(warehouseorderExample);
        return warehouseorders;
    }

    /**
     * 添加存储订单
     *
     * @param warehouseorder 存储订单
     * @return 成功返回true，失败返回false
     * @throws RuntimeException
     */
    @Transactional
    public boolean addWarehouseorder(Warehouseorder warehouseorder) throws RuntimeException {
        int i = warehouseorderMapper.insertSelective(warehouseorder);
        if (i == 1) {
            return true;
        } else {
            throw new RuntimeException("增加存储订单失败，请检查必填项是否完整");
        }
    }


    /**
     * 更新存储订单
     *
     * @param warehouseorder 存储订单
     * @return 成功返回true，失败返回false
     * @throws RuntimeException
     */
    @Transactional
    public boolean updateWarehouseorder(Warehouseorder warehouseorder) throws RuntimeException {
        WarehouseorderExample warehouseorderExample = new WarehouseorderExample();
        WarehouseorderExample.Criteria criteria = warehouseorderExample.createCriteria();
        criteria.andWhoidEqualTo(warehouseorder.getWhoid());
        int i = warehouseorderMapper.updateByExampleSelective(warehouseorder, warehouseorderExample);
        if (i == 1) {
            return true;
        } else {
            throw new RuntimeException("未知错误，无法更新，或可能找不到对应whoid的存储订单");
        }
    }

    /**
     * 设置订单状态
     * 若想删除或废弃订单，则将订单状态设置为0
     *
     * @param whoid      购买订单主键
     * @param orderState 订单状态（0：封锁，1：未审批，2：已审批）
     * @return 成功返回true，失败返回false
     * @throws RuntimeException
     */
    @Transactional
    public boolean setState(Integer whoid, Integer orderState) throws RuntimeException {
        WarehouseorderExample warehouseorderExample = new WarehouseorderExample();
        WarehouseorderExample.Criteria criteria = warehouseorderExample.createCriteria();
        criteria.andWhoidEqualTo(whoid);
        Warehouseorder warehouseorder = new Warehouseorder();
        warehouseorder.setOrderstate(orderState);
        int i = warehouseorderMapper.updateByExampleSelective(warehouseorder, warehouseorderExample);
        if (i == 1) {
            return true;
        } else {
            throw new RuntimeException("未知错误，无法更改订单状态，或可能找不到对应whoid的存储订单");
        }
    }
}
