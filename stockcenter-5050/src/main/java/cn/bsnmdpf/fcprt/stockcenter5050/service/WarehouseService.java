package cn.bsnmdpf.fcprt.stockcenter5050.service;

import cn.bsnmdpf.fcprt.api.pojo.VIP;
import cn.bsnmdpf.fcprt.api.pojo.VIPExample;
import cn.bsnmdpf.fcprt.api.pojo.Warehouse;
import cn.bsnmdpf.fcprt.api.pojo.WarehouseExample;
import cn.bsnmdpf.fcprt.stockcenter5050.mapper.WarehouseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author LicoLeung
 * @create 2020-02-04 17:01
 */
@Service
public class WarehouseService {

    @Autowired
    private WarehouseMapper warehouseMapper;

    /**
     * 根据条件获取仓位列表
     *
     * @param whid               仓位编码
     * @param sid                仓库编码
     * @param warehousename      仓库名称
     * @param lessVolumn         最大容量
     * @param greaterVolumn      最小容量
     * @param lessUsedVolumn     最大已使用容量
     * @param greaterUsedVolumn  最小已使用容量
     * @param address            地址
     * @param charge             负责人
     * @param chargePhone        负责人电话
     * @param whtype             仓位类型
     * @param creator            创建人
     * @param lessCreateTime     最大创建时间
     * @param greaterCreateTime  最小创建时间
     * @param modifier           修改人
     * @param lessModifyTime     最大修改时间
     * @param greaterModifiyTime 最小修改时间
     * @param isActive           是否启用
     * @return 符合条件的仓位列表
     */
    public List<Warehouse> getWarehouses(Integer whid, Integer sid, String warehousename, Double lessVolumn,
                                         Double greaterVolumn, Double lessUsedVolumn, Double greaterUsedVolumn,
                                         String address, String charge, String chargePhone, String whtype, String creator,
                                         Date lessCreateTime, Date greaterCreateTime, String modifier,
                                         Date lessModifyTime, Date greaterModifiyTime, Integer isActive) {
        WarehouseExample warehouseExample = new WarehouseExample();
        WarehouseExample.Criteria criteria = warehouseExample.createCriteria();
        if (whid != null) {
            criteria.andWhidEqualTo(whid);
        }
        if (sid != null) {
            criteria.andSidEqualTo(sid);
        }
        if (warehousename != null) {
            warehousename = "%" + warehousename + "%";
            criteria.andWarehousenameLike(warehousename);
        }
        if (lessVolumn != null) {
            criteria.andVolumnLessThanOrEqualTo(lessVolumn);
        }
        if (greaterVolumn != null) {
            criteria.andVolumnGreaterThanOrEqualTo(greaterVolumn);
        }
        if (greaterUsedVolumn != null) {
            criteria.andUsedvolumnGreaterThanOrEqualTo(greaterUsedVolumn);
        }
        if (lessUsedVolumn != null) {
            criteria.andUsedvolumnLessThanOrEqualTo(lessUsedVolumn);
        }
        if (address != null) {
            criteria.andAddressLike("%" + address + "%");
        }
        if (charge != null) {
            criteria.andChargeLike("%" + charge + "%");
        }
        if (chargePhone != null) {
            criteria.andChargephoneLike(chargePhone);
        }
        if (whtype != null) {
            criteria.andWhtypeEqualTo(whtype);
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
        List<Warehouse> warehouses = warehouseMapper.selectByExample(warehouseExample);
        return warehouses;
    }

    /**
     * 增加仓位
     *
     * @param warehouse
     * @return 成功返回true，失败返回false
     */
    public boolean addWarehouse(Warehouse warehouse) {
        int insert = warehouseMapper.insert(warehouse);
        try {
            if (insert == 1) {
                return true;
            } else {
                throw new Exception("未知错误，请检查Warehouse中的必填字段是否完整");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 封锁/删除仓位
     *
     * @param whid
     * @return 成功返回true，失败返回false
     */
    public boolean unableWarehouse(Integer whid) {
        Warehouse warehouse = new Warehouse();
        warehouse.setIsactive(0);
        WarehouseExample warehouseExample = new WarehouseExample();
        WarehouseExample.Criteria criteria = warehouseExample.createCriteria();
        criteria.andWhidEqualTo(whid);
        int i = warehouseMapper.updateByExampleSelective(warehouse, warehouseExample);
        try {
            if (i == 1) {
                return true;
            } else {
                throw new Exception("未知错误，无法删除，或可能找不到对应whid的warehouse");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 解封仓位
     *
     * @param whid
     * @return 成功返回true，失败返回false
     */
    public boolean ableWarehouse(Integer whid) {
        Warehouse warehouse = new Warehouse();
        warehouse.setIsactive(1);
        WarehouseExample warehouseExample = new WarehouseExample();
        WarehouseExample.Criteria criteria = warehouseExample.createCriteria();
        criteria.andWhidEqualTo(whid);
        int i = warehouseMapper.updateByExampleSelective(warehouse, warehouseExample);
        try {
            if (i == 1) {
                return true;
            } else {
                throw new Exception("未知错误，无法解封，或可能找不到对应whid的warehouse");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 更新仓位
     *
     * @param warehouse
     * @return 成功返回true，失败返回false
     */
    public boolean updateWarehouse(Warehouse warehouse) {
        WarehouseExample warehouseExample = new WarehouseExample();
        WarehouseExample.Criteria criteria = warehouseExample.createCriteria();
        criteria.andWhidEqualTo(warehouse.getWhid());
        int i = warehouseMapper.updateByExampleSelective(warehouse, warehouseExample);
        try {
            if (i == 1) {
                return true;
            } else {
                throw new Exception("未知错误，无法更新，或可能找不到对应whid的warehouse");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
