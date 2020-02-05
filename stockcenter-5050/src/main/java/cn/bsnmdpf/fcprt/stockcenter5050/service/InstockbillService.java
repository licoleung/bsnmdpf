package cn.bsnmdpf.fcprt.stockcenter5050.service;

import cn.bsnmdpf.fcprt.api.pojo.Instockbill;
import cn.bsnmdpf.fcprt.api.pojo.InstockbillExample;
import cn.bsnmdpf.fcprt.stockcenter5050.mapper.InstockbillMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author LicoLeung
 * @create 2020-02-04 22:26
 */
@Service
public class InstockbillService {

    @Autowired
    private InstockbillMapper instockbillMapper;

    /**
     * 根据条件查询入库单列表
     *
     * @param inid               主键
     * @param inbillcode         单据号
     * @param whid               仓位id
     * @param mid                物料id
     * @param mname              物料名称
     * @param lessInTime         最大入库时间
     * @param greaterInTime      最小入库时间
     * @param inType             入库类型
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
     * @return 符合条件的入库单列表
     */
    public List<Instockbill> getInstockbills(Integer inid, String inbillcode, Integer whid, Integer mid, String mname, Date lessInTime,
                                             Date greaterInTime, String inType, Integer poid, String creator, Date lessCreateTime, Date greaterCreateTime,
                                             String modifier, Date lessModifyTime, Date greaterModifiyTime, Integer isActive,
                                             Integer nnum, Double volumn, Double weight) {
        InstockbillExample instockbillExample = new InstockbillExample();
        InstockbillExample.Criteria criteria = instockbillExample.createCriteria();
        if (inid != null) {
            criteria.andInidEqualTo(inid);
        }
        if (inbillcode != null) {
            criteria.andInbillcodeEqualTo(inbillcode);
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
        if (lessInTime != null) {
            criteria.andIntimeLessThanOrEqualTo(lessInTime);
        }
        if (greaterInTime != null) {
            criteria.andIntimeGreaterThanOrEqualTo(greaterInTime);
        }
        if (inType != null) {
            criteria.andIntypeEqualTo(inType);
        }
        if (poid != null) {
            criteria.andPoidEqualTo(poid);
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
        List<Instockbill> instockbills = instockbillMapper.selectByExample(instockbillExample);
        return instockbills;
    }

    /**
     * 添加入库单
     *
     * @param instockbill 入库单
     * @return 成功返回true，失败返回false
     */
    @Transactional
    public boolean addInstockbill(Instockbill instockbill) throws RuntimeException {
        int insert = instockbillMapper.insert(instockbill);
        if (insert == 1) {
            return true;
        } else {
            throw new RuntimeException("未知错误，请检查instockbill中的必填字段是否完整");
        }
    }

    /**
     * 删除/封锁入库单
     * 主键和单据号至少有一个
     *
     * @param inid       主键
     * @param inbillcode 单据号
     * @return 返回被删除/封锁条数
     */
    @Transactional
    public int unableInstockbill(Integer inid, String inbillcode) throws RuntimeException {
        Instockbill instockbill = new Instockbill();
        instockbill.setIsactive(0);
        InstockbillExample instockbillExample = new InstockbillExample();
        InstockbillExample.Criteria criteria = instockbillExample.createCriteria();
        if (inid == null && inbillcode == null) {
            throw new RuntimeException("不能无删除条件，请检查inid及inbillcode");
        }
        if (inid != null) {
            criteria.andInidEqualTo(inid);
        }
        if (inbillcode != null) {
            criteria.andInbillcodeEqualTo(inbillcode);
        }
        int i = instockbillMapper.updateByExampleSelective(instockbill, instockbillExample);
        if (i == 0) {
            throw new RuntimeException("未知错误，无法删除/封锁，或可能找不到对应inid或inbillcode的单据");
        }
        return i;
    }


    /**
     * 恢复/解封入库单
     * 主键和单据号至少有一个
     *
     * @param inid       主键
     * @param inbillcode 单据号
     * @return 返回被删除/封锁条数
     */
    @Transactional
    public int ableInstockbill(Integer inid, String inbillcode) throws RuntimeException {
        Instockbill instockbill = new Instockbill();
        instockbill.setIsactive(1);
        InstockbillExample instockbillExample = new InstockbillExample();
        InstockbillExample.Criteria criteria = instockbillExample.createCriteria();
        if (inid == null && inbillcode == null) {
            throw new RuntimeException("不能无恢复条件，请检查inid及inbillcode");
        }
        if (inid != null) {
            criteria.andInidEqualTo(inid);
        }
        if (inbillcode != null) {
            criteria.andInbillcodeEqualTo(inbillcode);
        }
        int i = instockbillMapper.updateByExampleSelective(instockbill, instockbillExample);
        if (i == 0) {
            throw new RuntimeException("未知错误，无法恢复/解封，或可能找不到对应inid或inbillcode的单据");
        }
        return i;
    }

    /**
     * 更新入库单
     *
     * @param instockbill 入库单
     * @return 成功返回true，失败返回false
     */
    @Transactional
    public boolean updateInstockbill(Instockbill instockbill) throws RuntimeException {
        InstockbillExample instockbillExample = new InstockbillExample();
        InstockbillExample.Criteria criteria = instockbillExample.createCriteria();
        criteria.andInidEqualTo(instockbill.getInid());
        int i = instockbillMapper.updateByExampleSelective(instockbill, instockbillExample);
        if (i == 1) {
            return true;
        } else {
            throw new RuntimeException("未知错误，无法更新，或可能找不到对应inid的instockbill");
        }
    }
}
