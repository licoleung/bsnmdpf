package cn.bsnmdpf.fcprt.api.service;

import cn.bsnmdpf.fcprt.api.pojo.Purchaseorder;
import cn.bsnmdpf.fcprt.api.pojo.Saleorder;
import cn.bsnmdpf.fcprt.api.pojo.Warehouseorder;
import com.github.pagehelper.PageInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;



/**
 * @author LicoLeung
 * @create 2020-02-09 16:39
 */
@FeignClient(value = "ordercenter-5020")
public interface OrderCenterService {

    //PurchaseorderController

    /**
     * 根据条件查询购买订单列表
     *
     * @param pageSize           页面大小
     * @param page               页码
     * @param poid               购买订单主键
     * @param cid                公司主键
     * @param companyname        公司名称
     * @param billcode           单据号
     * @param lessBilldate       最大单据日期
     * @param greaterBilldate    最小单据日期
     * @param supplierid         供应商id
     * @param suppliername       供应商名称
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
     * @return 符合条件的购买订单列表
     */
    @GetMapping("purchaseorder")
    public PageInfo<Purchaseorder> getPurchaseorders(@RequestParam("pageSize") int pageSize,
                                                     @RequestParam("page") int page,
                                                     @RequestParam(value = "poid",required = false) Integer poid,
                                                     @RequestParam(value = "cid",required = false) Integer cid,
                                                     @RequestParam(value = "companyname",required = false) String companyname,
                                                     @RequestParam(value = "billcode",required = false) String billcode,
                                                     @RequestParam(value = "lessBilldate",required = false) String lessBilldate,
                                                     @RequestParam(value = "greaterBilldate",required = false) String greaterBilldate,
                                                     @RequestParam(value = "supplierid",required = false) Integer supplierid,
                                                     @RequestParam(value = "suppliername",required = false) String suppliername,
                                                     @RequestParam(value = "mid",required = false) Integer mid,
                                                     @RequestParam(value = "material",required = false) String material,
                                                     @RequestParam(value = "nnum",required = false) Integer nnum,
                                                     @RequestParam(value = "unit",required = false) String unit,
                                                     @RequestParam(value = "money",required = false) Double money,
                                                     @RequestParam(value = "orderState",required = false) Integer orderState,
                                                     @RequestParam(value = "creator",required = false) String creator,
                                                     @RequestParam(value = "lessCreateTime",required = false) String lessCreateTime,
                                                     @RequestParam(value = "greaterCreateTime",required = false) String greaterCreateTime,
                                                     @RequestParam(value = "modifier",required = false) String modifier,
                                                     @RequestParam(value = "lessModifyTime",required = false) String lessModifyTime,
                                                     @RequestParam(value = "greaterModifyTime",required = false) String greaterModifiyTime,
                                                     @RequestParam(value = "approver",required = false) String approver,
                                                     @RequestParam(value = "lessTaudittime",required = false) String lessTaudittime,
                                                     @RequestParam(value = "greaterTaudittime",required = false) String greaterTaudittime,
                                                     @RequestParam(value = "address",required = false) String address);

    /**
     * 添加购买订单
     *
     * @param poid         购买订单主键
     * @param cid          公司主键
     * @param companyname  公司名称
     * @param billcode     单据号
     * @param billdate     单据日期
     * @param supplierid   供应商id
     * @param suppliername 供应商名称
     * @param mid          物料编码
     * @param material     物料名称
     * @param nnum         数量
     * @param unit         单位
     * @param money        金额
     * @param orderState   订单状态
     * @param creator      创建者
     * @param approver     审批人
     * @param taudittime   审批时间
     * @param address      地址
     * @return 成功返回true，失败返回false
     */
    @PostMapping("purchaseorder")
    public boolean addPurchaseorder(@RequestParam(value = "poid", required = false) Integer poid,
                                    @RequestParam("cid") Integer cid,
                                    @RequestParam("companyname") String companyname,
                                    @RequestParam("billcode") String billcode,
                                    @RequestParam("billdate") String billdate,
                                    @RequestParam(value = "supplierid", required = false) Integer supplierid,
                                    @RequestParam("suppliername") String suppliername,
                                    @RequestParam(value = "mid", required = false) Integer mid,
                                    @RequestParam("material") String material,
                                    @RequestParam("nnum") Integer nnum,
                                    @RequestParam("unit") String unit,
                                    @RequestParam("money") Double money,
                                    @RequestParam("orderState") Integer orderState,
                                    @RequestParam("creator") String creator,
                                    @RequestParam(value = "approver", required = false) String approver,
                                    @RequestParam(value = "taudittime", required = false) String taudittime,
                                    @RequestParam("address") String address);

    /**
     * 更新购买订单
     *
     * @param poid         购买订单主键
     * @param cid          公司主键
     * @param companyname  公司名称
     * @param billcode     单据号
     * @param billdate     单据日期
     * @param supplierid   供应商id
     * @param suppliername 供应商名称
     * @param mid          物料编码
     * @param material     物料名称
     * @param nnum         数量
     * @param unit         单位
     * @param money        金额
     * @param orderState   订单状态
     * @param modifier     修改者
     * @param approver     审批人
     * @param taudittime   审批时间
     * @param address      地址
     * @return 成功返回true，失败返回false
     */
    @PutMapping("purchaseorder/{poid}")
    public boolean updatePurchaseorder(@PathVariable(value = "poid") Integer poid,
                                       @RequestParam(value = "cid", required = false) Integer cid,
                                       @RequestParam(value = "companyname", required = false) String companyname,
                                       @RequestParam(value = "billcode", required = false) String billcode,
                                       @RequestParam(value = "billdate", required = false) String billdate,
                                       @RequestParam(value = "supplierid", required = false) Integer supplierid,
                                       @RequestParam(value = "suppliername", required = false) String suppliername,
                                       @RequestParam(value = "mid", required = false) Integer mid,
                                       @RequestParam(value = "material", required = false) String material,
                                       @RequestParam(value = "nnum", required = false) Integer nnum,
                                       @RequestParam(value = "unit", required = false) String unit,
                                       @RequestParam(value = "money", required = false) Double money,
                                       @RequestParam(value = "orderState", required = false) Integer orderState,
                                       @RequestParam("modifier") String modifier,
                                       @RequestParam(value = "approver", required = false) String approver,
                                       @RequestParam(value = "taudittime", required = false) String taudittime,
                                       @RequestParam(value = "address", required = false) String address);


    /**
     * 根据主键删除购买订单
     * 将购买订单的订单状态设置为0（封锁）
     *
     * @param poid 购买订单主键
     * @return 成功返回true，失败返回false
     */
    @DeleteMapping("purchaseorder/{poid}")
    public boolean deletePurchaseorder(@PathVariable("poid") Integer poid);


    /**
     * 审批购买订单
     * 将购买订单的订单状态设置为2（已审批）
     *
     * @param poid
     * @return 成功返回true，失败返回false
     */
    @PutMapping("approvePurchaseorder/{poid}")
    public boolean approvePurchaseorder(@PathVariable("poid") Integer poid);


    /**
     * 恢复购买订单
     * 将购买订单的订单状态设置为1（未审批）
     *
     * @param poid
     * @return 成功返回true，失败返回false
     */
    @PutMapping("recoverPurchaseorder/{poid}")
    public boolean recoverPurchaseorder(@PathVariable("poid") Integer poid);

    //SaleorderController


    /**
     * 根据条件获取销售订单列表
     *
     * @param pageSize           页面大小
     * @param page               页码
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
    @GetMapping("saleorder")
    public PageInfo<Saleorder> getSaleorders(@RequestParam("pageSize") int pageSize,
                                             @RequestParam("page") int page,
                                             @RequestParam("soid") Integer soid,
                                             @RequestParam("cid") Integer cid,
                                             @RequestParam("companyname") String companyname,
                                             @RequestParam("billcode") String billcode,
                                             @RequestParam("lessBilldate") String lessBilldate,
                                             @RequestParam("greaterBilldate") String greaterBilldate,
                                             @RequestParam("vipid") Integer vipid,
                                             @RequestParam("vipname") String vipname,
                                             @RequestParam("mid") Integer mid,
                                             @RequestParam("material") String material,
                                             @RequestParam("nnum") Integer nnum,
                                             @RequestParam("unit") String unit,
                                             @RequestParam("money") Double money,
                                             @RequestParam("orderState") Integer orderState,
                                             @RequestParam("creator") String creator,
                                             @RequestParam("lessCreateTime") String lessCreateTime,
                                             @RequestParam("greaterCreateTime") String greaterCreateTime,
                                             @RequestParam("modifier") String modifier,
                                             @RequestParam("lessModifyTime") String lessModifyTime,
                                             @RequestParam("greaterModifyTime") String greaterModifiyTime,
                                             @RequestParam("approver") String approver,
                                             @RequestParam("lessTaudittime") String lessTaudittime,
                                             @RequestParam("greaterTaudittime") String greaterTaudittime,
                                             @RequestParam("address") String address);

    /**
     * 添加销售订单
     *
     * @param soid        销售订单主键
     * @param cid         公司主键
     * @param companyname 公司名称
     * @param billcode    单据号
     * @param billdate    单据日期
     * @param vipid       vip id
     * @param vipname     vip姓名
     * @param mid         物料编码
     * @param material    物料名称
     * @param nnum        数量
     * @param unit        单位
     * @param money       金额
     * @param orderState  订单状态
     * @param creator     创建者
     * @param approver    审批人
     * @param taudittime  审批时间
     * @param address     地址
     * @return 成功返回true，失败返回false
     */
    @PostMapping("saleorder")
    public boolean addSaleorder(@RequestParam(value = "soid", required = false) Integer soid,
                                @RequestParam("cid") Integer cid,
                                @RequestParam("companyname") String companyname,
                                @RequestParam("billcode") String billcode,
                                @RequestParam("billdate") String billdate,
                                @RequestParam(value = "vipid", required = false) Integer vipid,
                                @RequestParam("vipname") String vipname,
                                @RequestParam(value = "mid", required = false) Integer mid,
                                @RequestParam("material") String material,
                                @RequestParam("nnum") Integer nnum,
                                @RequestParam("unit") String unit,
                                @RequestParam("money") Double money,
                                @RequestParam("orderState") Integer orderState,
                                @RequestParam("creator") String creator,
                                @RequestParam(value = "approver", required = false) String approver,
                                @RequestParam(value = "taudittime", required = false) String taudittime,
                                @RequestParam("address") String address);

    /**
     * 更新销售订单
     *
     * @param soid        销售订单主键
     * @param cid         公司主键
     * @param companyname 公司名称
     * @param billcode    单据号
     * @param billdate    单据日期
     * @param vipid       vip id
     * @param vipname     vip姓名
     * @param mid         物料编码
     * @param material    物料名称
     * @param nnum        数量
     * @param unit        单位
     * @param money       金额
     * @param orderState  订单状态
     * @param modifier    修改者
     * @param approver    审批人
     * @param taudittime  审批时间
     * @param address     地址
     * @return 成功返回true，失败返回false
     */
    @PutMapping("saleorder/{poid}")
    public boolean updateSaleorder(@PathVariable(value = "soid") Integer soid,
                                   @RequestParam(value = "cid", required = false) Integer cid,
                                   @RequestParam(value = "companyname", required = false) String companyname,
                                   @RequestParam(value = "billcode", required = false) String billcode,
                                   @RequestParam(value = "billdate", required = false) String billdate,
                                   @RequestParam(value = "vipid", required = false) Integer vipid,
                                   @RequestParam(value = "vipname", required = false) String vipname,
                                   @RequestParam(value = "mid", required = false) Integer mid,
                                   @RequestParam(value = "material", required = false) String material,
                                   @RequestParam(value = "nnum", required = false) Integer nnum,
                                   @RequestParam(value = "unit", required = false) String unit,
                                   @RequestParam(value = "money", required = false) Double money,
                                   @RequestParam(value = "orderState", required = false) Integer orderState,
                                   @RequestParam("modifier") String modifier,
                                   @RequestParam(value = "approver", required = false) String approver,
                                   @RequestParam(value = "taudittime", required = false) String taudittime,
                                   @RequestParam(value = "address", required = false) String address);


    /**
     * 根据主键删除销售订单
     * 将销售订单的订单状态设置为0（封锁）
     *
     * @param soid 销售订单主键
     * @return 成功返回true，失败返回false
     */
    @DeleteMapping("saleorder/{soid}")
    public boolean deleteSaleorder(@PathVariable("soid") Integer soid);

    /**
     * 审批销售订单
     * 将销售订单的订单状态设置为2（已审批）
     *
     * @param soid
     * @return 成功返回true，失败返回false
     */
    @PutMapping("approveSaleorder/{soid}")
    public boolean approveSaleorder(@PathVariable("soid") Integer soid);

    /**
     * 恢复销售订单
     * 将销售订单的订单状态设置为1（未审批）
     *
     * @param soid
     * @return 成功返回true，失败返回false
     */
    @PutMapping("recoverSaleorder/{soid}")
    public boolean recoverSaleorder(@PathVariable("soid") Integer soid);

    //WarehouseorderController


    /**
     * 根据条件查询购买订单列表
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
     * @return 符合条件的购买订单列表
     */
    @GetMapping("warehouseorder")
    public PageInfo<Warehouseorder> getWarehouseorder(@RequestParam("pageSize") int pageSize,
                                                      @RequestParam("page") int page,
                                                      @RequestParam("whoid") Integer whoid,
                                                      @RequestParam("cid") Integer cid,
                                                      @RequestParam("companyname") String companyname,
                                                      @RequestParam("billcode") String billcode,
                                                      @RequestParam("lessBilldate") String lessBilldate,
                                                      @RequestParam("greaterBilldate") String greaterBilldate,
                                                      @RequestParam("vipid") Integer vipid,
                                                      @RequestParam("vipname") String vipname,
                                                      @RequestParam("mid") Integer mid,
                                                      @RequestParam("material") String material,
                                                      @RequestParam("nnum") Integer nnum,
                                                      @RequestParam("money") Double money,
                                                      @RequestParam("weight") Double weight,
                                                      @RequestParam("volumn") Double volumn,
                                                      @RequestParam("orderState") Integer orderState,
                                                      @RequestParam("creator") String creator,
                                                      @RequestParam("lessCreateTime") String lessCreateTime,
                                                      @RequestParam("greaterCreateTime") String greaterCreateTime,
                                                      @RequestParam("modifier") String modifier,
                                                      @RequestParam("lessModifyTime") String lessModifyTime,
                                                      @RequestParam("greaterModifyTime") String greaterModifiyTime,
                                                      @RequestParam("whid") Integer whid,
                                                      @RequestParam("warehouseName") String warehouseName,
                                                      @RequestParam("sid") Integer sid,
                                                      @RequestParam("stockName") String stockName);

    /**
     * 添加存储订单
     *
     * @param whoid         存储订单主键
     * @param cid           公司主键
     * @param companyname   公司名称
     * @param billcode      单据号
     * @param billdate      单据日期
     * @param vipid         vip id
     * @param vipname       vip姓名
     * @param mid           物料编码
     * @param material      物料名称
     * @param nnum          数量
     * @param money         金额
     * @param weight        重量
     * @param volumn        体积
     * @param orderState    订单状态
     * @param creator       创建者
     * @param whid          仓位id
     * @param warehouseName 仓位名称
     * @param sid           仓库id
     * @param stockName     仓库名称
     * @return 成功返回true，失败返回false
     */
    @PostMapping("warehouseorder")
    public boolean addWarehouseorder(@RequestParam("whoid") Integer whoid,
                                     @RequestParam("cid") Integer cid,
                                     @RequestParam("companyname") String companyname,
                                     @RequestParam("billcode") String billcode,
                                     @RequestParam("billdate") String billdate,
                                     @RequestParam(value = "vipid", required = false) Integer vipid,
                                     @RequestParam("vipname") String vipname,
                                     @RequestParam(value = "mid", required = false) Integer mid,
                                     @RequestParam("material") String material,
                                     @RequestParam("nnum") Integer nnum,
                                     @RequestParam("money") Double money,
                                     @RequestParam("weight") Double weight,
                                     @RequestParam("volumn") Double volumn,
                                     @RequestParam("orderState") Integer orderState,
                                     @RequestParam("creator") String creator,
                                     @RequestParam("whid") Integer whid,
                                     @RequestParam("warehouseName") String warehouseName,
                                     @RequestParam("sid") Integer sid,
                                     @RequestParam("stockName") String stockName);
    /**
     * 更新存储订单
     *
     * @param whoid         存储订单主键
     * @param cid           公司主键
     * @param companyname   公司名称
     * @param billcode      单据号
     * @param billdate      单据日期
     * @param vipid         vip id
     * @param vipname       vip姓名
     * @param mid           物料编码
     * @param material      物料名称
     * @param nnum          数量
     * @param money         金额
     * @param weight        重量
     * @param volumn        体积
     * @param orderState    订单状态
     * @param creator       创建者
     * @param whid          仓位id
     * @param warehouseName 仓位名称
     * @param sid           仓库id
     * @param stockName     仓库名称
     * @return 成功返回true，失败返回false
     */
    @PutMapping("warehouseorder/{whoid}")
    public boolean updateWarehouseorder(@PathVariable("whoid") Integer whoid,
                                        @RequestParam(value = "cid", required = false) Integer cid,
                                        @RequestParam(value = "companyname", required = false) String companyname,
                                        @RequestParam(value = "billcode", required = false) String billcode,
                                        @RequestParam(value = "billdate", required = false) String billdate,
                                        @RequestParam(value = "vipid", required = false) Integer vipid,
                                        @RequestParam(value = "vipname", required = false) String vipname,
                                        @RequestParam(value = "mid", required = false) Integer mid,
                                        @RequestParam(value = "material", required = false) String material,
                                        @RequestParam(value = "nnum", required = false) Integer nnum,
                                        @RequestParam(value = "money", required = false) Double money,
                                        @RequestParam(value = "weight", required = false) Double weight,
                                        @RequestParam(value = "volumn", required = false) Double volumn,
                                        @RequestParam(value = "orderState", required = false) Integer orderState,
                                        @RequestParam(value = "creator", required = false) String creator,
                                        @RequestParam(value = "whid", required = false) Integer whid,
                                        @RequestParam(value = "warehouseName", required = false) String warehouseName,
                                        @RequestParam(value = "sid", required = false) Integer sid,
                                        @RequestParam(value = "stockName", required = false) String stockName);

    /**
     * 根据主键删除存储订单
     * 将存储订单的订单状态设置为0（封锁）
     *
     * @param whoid 存储订单主键
     * @return 成功返回true，失败返回false
     */
    @DeleteMapping("warehouseorder/{whoid}")
    public boolean deleteWarehouseorder(@PathVariable("whoid") Integer whoid);

    /**
     * 审批存储订单
     * 将存储订单的订单状态设置为2（已审批）
     *
     * @param whoid
     * @return 成功返回true，失败返回false
     */
    @PutMapping("approveWarehouseorder/{whoid}")
    public boolean approveWarehouseorder(@PathVariable("whoid") Integer whoid);

    /**
     * 恢复存储订单
     * 将存储订单的订单状态设置为1（未审批）
     *
     * @param whoid
     * @return 成功返回true，失败返回false
     */
    @PutMapping("recoverWarehouseorder/{whoid}")
    public boolean recoverWarehouseorder(@PathVariable("whoid") Integer whoid);
}
