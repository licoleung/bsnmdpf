package cn.bsnmdpf.fcprt.stockcenter5050.service;

import cn.bsnmdpf.fcprt.api.pojo.Outstockbill;
import cn.bsnmdpf.fcprt.api.pojo.OutstockbillExample;
import cn.bsnmdpf.fcprt.stockcenter5050.mapper.OutstockbillMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author LicoLeung
 * @create 2020-02-04 22:59
 */
@Service
public class OutstockbillService {

    @Autowired
    private OutstockbillMapper outstockbillMapper;

    /**
     * 根据条件查询出库单列表
     *
     * @param outid              主键
     * @param outbillcode        单据号
     * @param whid               仓位id
     * @param mid                物料id
     * @param mname              物料名称
     * @param lessOutTime        最大出库时间
     * @param greaterOutTime     最小出库时间
     * @param inType             出库类型
     * @param poid               订单id
     * @param creator            创建者
     * @param lessCreateTime     最大创建时间
     * @param greaterCreateTime  最小创建时间
     * @param modifier           修改者
     * @param lessModifyTime     最大修改时间
     * @param greaterModifiyTime 最小修改时间
     * @param isActive           是否启用
     * @param nnum               数量
     * @param volumn             体积
     * @param weight             重量
     * @return 符合条件的出库单列表
     */
    public List<Outstockbill> getOutstockbills(Integer outid, String outbillcode, Integer whid, Integer mid, String mname, Date lessOutTime,
                                               Date greaterOutTime, String inType, Integer poid, String creator, Date lessCreateTime, Date greaterCreateTime,
                                               String modifier, Date lessModifyTime, Date greaterModifiyTime, Integer isActive,
                                               Integer nnum, Double volumn, Double weight) {
        OutstockbillExample outstockbillExample = new OutstockbillExample();
        OutstockbillExample.Criteria criteria = outstockbillExample.createCriteria();
        if (outid != null) {
            criteria.andOutidEqualTo(outid);
        }
        if (outbillcode != null) {
            criteria.andOutbillcodeEqualTo(outbillcode);
        }
        if (whid != null) {
            criteria.andWhidEqualTo(whid);
        }
        if (mid != null) {
            criteria.andMidEqualTo(mid);
        }
        if (mname != null) {
            criteria.andMnameLike("%" + mname + "%");
        }
        if (lessOutTime != null) {
            criteria.andOuttimeLessThanOrEqualTo(lessOutTime);
        }
        if (greaterOutTime != null) {
            criteria.andOuttimeGreaterThanOrEqualTo(greaterOutTime);
        }
        if (inType != null) {
            criteria.andOuttypeEqualTo(inType);
        }
        if (poid != null) {
            criteria.andSoidEqualTo(poid);
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
        if (isActive != null) {
            criteria.andIsactiveEqualTo(isActive);
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
        if (nnum != null) {
            criteria.andNnumEqualTo(nnum);
        }
        if (volumn != null) {
            criteria.andVolumnEqualTo(volumn);
        }
        if (weight != null) {
            criteria.andWeightEqualTo(weight);
        }
        List<Outstockbill> outstockbills = outstockbillMapper.selectByExample(outstockbillExample);
        return outstockbills;
    }

    /**
     * 添加出库单
     *
     * @param outstockbill 出库单
     * @return 成功返回true，失败返回false
     */
    public boolean addOutstockbill(Outstockbill outstockbill) {
        int insert = outstockbillMapper.insert(outstockbill);
        try {
            if (insert == 1) {
                return true;
            } else {
                throw new Exception("未知错误，请检查outstockbill中的必填字段是否完整");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 删除/封锁出库单
     * 主键和单据号至少有一个
     *
     * @param outid       主键
     * @param outbillcode 单据号
     * @return 返回被删除/封锁条数
     */
    public int unableOutstockbill(Integer outid, String outbillcode) {
        Outstockbill outstockbill = new Outstockbill();
        outstockbill.setIsactive(0);
        OutstockbillExample outstockbillExample = new OutstockbillExample();
        OutstockbillExample.Criteria criteria = outstockbillExample.createCriteria();
        try {
            if (outid == null && outbillcode == null) {
                throw new Exception("不能无删除条件，请检查outid及outbillcode");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        if (outid != null) {
            criteria.andOutidEqualTo(outid);
        }
        if (outbillcode != null) {
            criteria.andOutbillcodeEqualTo(outbillcode);
        }
        int i = outstockbillMapper.updateByExampleSelective(outstockbill, outstockbillExample);
        try {
            if (i == 0) {
                throw new Exception("未知错误，无法删除/封锁，或可能找不到对应outid或outbillcode的单据");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        return i;
    }


    /**
     * 恢复/解封出库单
     * 主键和单据号至少有一个
     *
     * @param outid       主键
     * @param outbillcode 单据号
     * @return 返回被删除/封锁条数
     */
    public int ableOutstockbill(Integer outid, String outbillcode) {
        Outstockbill outstockbill = new Outstockbill();
        outstockbill.setIsactive(1);
        OutstockbillExample outstockbillExample = new OutstockbillExample();
        OutstockbillExample.Criteria criteria = outstockbillExample.createCriteria();
        try {
            if (outid == null && outbillcode == null) {
                throw new Exception("不能无恢复条件，请检查outid及outbillcode");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        if (outid != null) {
            criteria.andOutidEqualTo(outid);
        }
        if (outbillcode != null) {
            criteria.andOutbillcodeEqualTo(outbillcode);
        }
        int i = outstockbillMapper.updateByExampleSelective(outstockbill, outstockbillExample);
        try {
            if (i == 0) {
                throw new Exception("未知错误，无法恢复/解封，或可能找不到对应outid或outbillcode的单据");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        return i;
    }

    /**
     * 更新出库单
     *
     * @param outstockbill 出库单
     * @return 成功返回true，失败返回false
     */
    public boolean updateOutstockbill(Outstockbill outstockbill) {
        OutstockbillExample outstockbillExample = new OutstockbillExample();
        OutstockbillExample.Criteria criteria = outstockbillExample.createCriteria();
        criteria.andOutidEqualTo(outstockbill.getOutid());
        int i = outstockbillMapper.updateByExampleSelective(outstockbill, outstockbillExample);
        try {
            if (i == 1) {
                return true;
            } else {
                throw new Exception("未知错误，无法更新，或可能找不到对应outid的outstockbill");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
