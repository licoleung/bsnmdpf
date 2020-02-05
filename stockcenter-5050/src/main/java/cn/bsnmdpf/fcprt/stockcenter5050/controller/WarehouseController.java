package cn.bsnmdpf.fcprt.stockcenter5050.controller;

import cn.bsnmdpf.fcprt.api.pojo.Warehouse;
import cn.bsnmdpf.fcprt.stockcenter5050.service.WarehouseService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author LicoLeung
 * @create 2020-02-05 11:52
 */
@Controller
public class WarehouseController {

    @Autowired
    private WarehouseService warehouseService;

    /**
     * 根据条件获取仓位列表
     *
     * @param page               页码
     * @param pageSize           一页显示多少数据
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
    @GetMapping("warehouse")
    public PageInfo<Warehouse> getWarehouse(@RequestParam(value = "pageSize") int pageSize,
                                            @RequestParam(value = "page") int page,
                                            @RequestParam(value = "whid", required = false) Integer whid,
                                            @RequestParam(value = "sid", required = false) Integer sid,
                                            @RequestParam(value = "warehousename", required = false) String warehousename,
                                            @RequestParam(value = "lessVolumn", required = false) Double lessVolumn,
                                            @RequestParam(value = "greaterVolumn", required = false) Double greaterVolumn,
                                            @RequestParam(value = "lessUsedVolumn", required = false) Double lessUsedVolumn,
                                            @RequestParam(value = "greaterUsedVolumn", required = false) Double greaterUsedVolumn,
                                            @RequestParam(value = "address", required = false) String address,
                                            @RequestParam(value = "charge", required = false) String charge,
                                            @RequestParam(value = "chargePhone", required = false) String chargePhone,
                                            @RequestParam(value = "whtype", required = false) String whtype,
                                            @RequestParam(value = "creator", required = false) String creator,
                                            @RequestParam(value = "lessCreateTime", required = false) Date lessCreateTime,
                                            @RequestParam(value = "greaterCreateTime", required = false) Date greaterCreateTime,
                                            @RequestParam(value = "modifier", required = false) String modifier,
                                            @RequestParam(value = "lessModifyTime", required = false) Date lessModifyTime,
                                            @RequestParam(value = "greaterModifyTime", required = false) Date greaterModifiyTime,
                                            @RequestParam(value = "isActive", required = false) Integer isActive) {
        PageHelper.startPage(page, pageSize);
        List<Warehouse> warehouses = warehouseService.getWarehouses(whid, sid, warehousename, lessVolumn, greaterVolumn, lessUsedVolumn, greaterUsedVolumn,
                address, charge, chargePhone, whtype, creator, lessCreateTime, greaterCreateTime, modifier, lessModifyTime,
                greaterModifiyTime, isActive);
        PageInfo<Warehouse> pageInfo = new PageInfo<>(warehouses);
        return pageInfo;
    }

    /***
     * 添加仓位
     *
     * @param whid          仓位编码
     * @param sid           仓库编码
     * @param warehousename 仓库名称
     * @param volumn        容量
     * @param usedVolumn    已使用容量
     * @param address       地址
     * @param charge        负责人
     * @param chargePhone   负责人电话
     * @param whtype        仓位类型
     * @param creator       创建者
     * @param isActive      是否启用
     * @return 成功返回true，失败返回false
     */
    public boolean addWarehouse(@RequestParam(value = "whid", required = false) Integer whid,
                                @RequestParam(value = "sid") Integer sid,
                                @RequestParam(value = "warehousename") String warehousename,
                                @RequestParam(value = "volumn") Double volumn,
                                @RequestParam(value = "uedVolumn", required = false) Double usedVolumn,
                                @RequestParam(value = "address") String address,
                                @RequestParam(value = "charge") String charge,
                                @RequestParam(value = "chargePhone") String chargePhone,
                                @RequestParam(value = "whtype") String whtype,
                                @RequestParam(value = "creator") String creator,
                                @RequestParam(value = "isActive", required = false) Integer isActive) {
        Warehouse warehouse = new Warehouse();
        if (whid != null) {
            warehouse.setWhid(whid);
        }
        warehouse.setSid(sid);
        warehouse.setWarehousename(warehousename);
        warehouse.setVolumn(volumn);
        if (usedVolumn != null) {
            warehouse.setUsedvolumn(usedVolumn);
        } else {
            warehouse.setUsedvolumn(0.0);
        }
        warehouse.setAddress(address);
        warehouse.setCharge(charge);
        warehouse.setChargephone(chargePhone);
        warehouse.setWhtype(whtype);
        warehouse.setCreator(creator);
        warehouse.setCreatetime(new Date());
        if (isActive != null) {
            warehouse.setIsactive(isActive);
        } else {
            warehouse.setIsactive(1);
        }
        boolean b = warehouseService.addWarehouse(warehouse);
        return b;
    }

    /**
     * 根据whid删除/封锁仓位
     *
     * @param whid 仓位编码
     * @return 成功返回true，失败返回false
     */
    @DeleteMapping("warehouse/{whid}")
    public boolean deleteWarehouse(@PathVariable("whid") Integer whid) {
        boolean b = warehouseService.unableWarehouse(whid);
        return b;
    }

    /**
     * 根据whid恢复/解封仓位
     *
     * @param whid 仓位编码
     * @return 成功返回true，失败返回false
     */
    @GetMapping("ableStock/{whid}")
    public boolean ableStock(@PathVariable("whid") Integer whid) {
        return warehouseService.ableWarehouse(whid);
    }

    /**
     * 更新仓位
     *
     * @param whid          仓位编码
     * @param sid           仓库编码
     * @param warehousename 仓库名称
     * @param volumn        容量
     * @param usedVolumn    已使用容量
     * @param address       地址
     * @param charge        负责人
     * @param chargePhone   负责人电话
     * @param whtype        仓位类型
     * @param modifier      修改者
     * @param isActive      是否启用
     * @return 成功返回true，失败返回false
     */
    @PutMapping("warehouse/{whid}")
    public boolean updateWarehouse(@PathVariable("whid") Integer whid,
                                   @RequestParam(value = "sid") Integer sid,
                                   @RequestParam(value = "warehousename", required = false) String warehousename,
                                   @RequestParam(value = "volumn", required = false) Double volumn,
                                   @RequestParam(value = "uedVolumn", required = false) Double usedVolumn,
                                   @RequestParam(value = "address", required = false) String address,
                                   @RequestParam(value = "charge", required = false) String charge,
                                   @RequestParam(value = "chargePhone", required = false) String chargePhone,
                                   @RequestParam(value = "whtype", required = false) String whtype,
                                   @RequestParam(value = "modifier") String modifier,
                                   @RequestParam(value = "isActive", required = false) Integer isActive) {
        Warehouse warehouse = new Warehouse();
        warehouse.setWhid(whid);
        if (sid != null) {
            warehouse.setSid(sid);
        }
        if (warehousename != null) {
            warehouse.setWarehousename(warehousename);
        }
        if (volumn != null) {
            warehouse.setVolumn(volumn);
        }
        if (usedVolumn != null) {
            warehouse.setUsedvolumn(usedVolumn);
        }
        if (address != null) {
            warehouse.setAddress(address);
        }
        if (charge != null) {
            warehouse.setCharge(charge);
        }
        if (chargePhone != null) {
            warehouse.setChargephone(chargePhone);
        }
        if (whtype != null) {
            warehouse.setWhtype(whtype);
        }
        warehouse.setModifier(modifier);
        warehouse.setModifytime(new Date());
        if (isActive != null) {
            warehouse.setIsactive(isActive);
        }
        return warehouseService.updateWarehouse(warehouse);
    }
}
