package cn.bsnmdpf.fcprt.api.service;

import cn.bsnmdpf.fcprt.api.pojo.*;
import com.github.pagehelper.PageInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


/**
 * @author LicoLeung
 * @create 2020-02-06 13:37
 */
@FeignClient(value = "stockcenter-5050")
public interface StockCenterService {

    //InstockbillController

    /**
     * 根据条件查询入库单
     *
     * @param pageSize           一页展示的数量
     * @param page               页码
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
     * @return 入库单列表
     */
    @GetMapping("instockbill")
    public PageInfo<Instockbill> getInstockbills(@RequestParam(value = "pageSize") int pageSize,
                                                 @RequestParam(value = "page") int page,
                                                 @RequestParam(value = "inid", required = false) Integer inid,
                                                 @RequestParam(value = "inbillcode", required = false) String inbillcode,
                                                 @RequestParam(value = "whid", required = false) Integer whid,
                                                 @RequestParam(value = "mid", required = false) Integer mid,
                                                 @RequestParam(value = "mname", required = false) String mname,
                                                 @RequestParam(value = "lessInTime", required = false) String lessInTime,
                                                 @RequestParam(value = "greaterInTime", required = false) String greaterInTime,
                                                 @RequestParam(value = "inType", required = false) String inType,
                                                 @RequestParam(value = "poid", required = false) Integer poid,
                                                 @RequestParam(value = "creator", required = false) String creator,
                                                 @RequestParam(value = "lessCreateTime", required = false) String lessCreateTime,
                                                 @RequestParam(value = "greaterCreateTime", required = false) String greaterCreateTime,
                                                 @RequestParam(value = "modifier", required = false) String modifier,
                                                 @RequestParam(value = "lessModifyTime", required = false) String lessModifyTime,
                                                 @RequestParam(value = "greaterModifyTime", required = false) String greaterModifiyTime,
                                                 @RequestParam(value = "isActive", required = false) Integer isActive,
                                                 @RequestParam(value = "nnum", required = false) Integer nnum,
                                                 @RequestParam(value = "volumn", required = false) Double volumn,
                                                 @RequestParam(value = "weight", required = false) Double weight);

    /**
     * 添加入库单
     *
     * @param inid       主键
     * @param inbillcode 单据号
     * @param whid       仓位id
     * @param mid        物料id
     * @param mname      物料名称
     * @param inTime     入库时间
     * @param inType     入库类型
     * @param poid       订单号，非必填
     * @param creator    创建者
     * @param isActive   是否启用
     * @param nnum       数量
     * @param volumn     体积
     * @param weight     重量
     * @return 成功返回true，失败返回false
     */
    @PostMapping("instockbill")
    public boolean addInstockbill(@RequestParam(value = "inid", required = false) Integer inid,
                                  @RequestParam(value = "inbillcode") String inbillcode,
                                  @RequestParam(value = "whid") Integer whid,
                                  @RequestParam(value = "mid") Integer mid,
                                  @RequestParam(value = "mname") String mname,
                                  @RequestParam(value = "inTime") Date inTime,
                                  @RequestParam(value = "inType") String inType,
                                  @RequestParam(value = "poid", required = false) Integer poid,
                                  @RequestParam(value = "creator") String creator,
                                  @RequestParam(value = "isActive", required = false) Integer isActive,
                                  @RequestParam(value = "nnum") Integer nnum,
                                  @RequestParam(value = "volumn") Double volumn,
                                  @RequestParam(value = "weight") Double weight);

    /**
     * 根据主键或者单据号删除/封锁入库单
     * 主键和单据号必须存在一个，否则在service会报错
     *
     * @param inid       主键
     * @param inbillcode 单据号
     * @return 返回删除条数
     */
    @DeleteMapping("instockbill")
    public int deleteInstockbill(@RequestParam(value = "inid", required = false) Integer inid,
                                 @RequestParam(value = "inbillcode", required = false) String inbillcode);

    /**
     * 根据主键或者单据号恢复/解封入库单
     * 主键和单据号必须存在一个，否则在service会报错
     *
     * @param inid       主键
     * @param inbillcode 单据号
     * @return 返回恢复条数
     */
    @GetMapping("ableinstockbill")
    public int ableInstockbill(@RequestParam(value = "inid", required = false) Integer inid,
                               @RequestParam(value = "inbillcode", required = false) String inbillcode);

    /**
     * 更新入库单，有参则更，无参则不变
     *
     * @param inid       主键
     * @param inbillcode 单据号
     * @param whid       仓位id
     * @param mid        物料id
     * @param mname      物料名称
     * @param inTime     入库时间
     * @param inType     入库类型
     * @param poid       订单号，非必填
     * @param modifier   修改者
     * @param isActive   是否启用
     * @param nnum       数量
     * @param volumn     体积
     * @param weight     重量
     * @return 成功返回true，失败返回false
     */
    @PutMapping("instockbill/{inid}")
    public boolean updateInstockbill(@PathVariable(value = "inid") Integer inid,
                                     @RequestParam(value = "inbillcode", required = false) String inbillcode,
                                     @RequestParam(value = "whid", required = false) Integer whid,
                                     @RequestParam(value = "mid", required = false) Integer mid,
                                     @RequestParam(value = "mname", required = false) String mname,
                                     @RequestParam(value = "inTime", required = false) Date inTime,
                                     @RequestParam(value = "inType", required = false) String inType,
                                     @RequestParam(value = "poid", required = false) Integer poid,
                                     @RequestParam(value = "modifier") String modifier,
                                     @RequestParam(value = "isActive", required = false) Integer isActive,
                                     @RequestParam(value = "nnum", required = false) Integer nnum,
                                     @RequestParam(value = "volumn", required = false) Double volumn,
                                     @RequestParam(value = "weight", required = false) Double weight);

    //OnHandController

    /**
     * 查询现存量
     *
     * @param pageSize      页面大小
     * @param page          页码
     * @param ohid          主键
     * @param mid           物料id
     * @param mname         物料名称
     * @param whid          仓位id
     * @param whname        仓位名称
     * @param sid           仓库id
     * @param stockname     仓位名称
     * @param lessNnum      最大数量
     * @param greaterNnum   最小数量
     * @param lessVolumn    最大体积
     * @param greaterVolumn 最小体积
     * @param lessWeight    最大重量
     * @param greaterWeight 最小重量
     * @return
     */
    @GetMapping("onhand")
    public PageInfo<OnHand> getOnHand(@RequestParam(value = "pageSize") int pageSize,
                                      @RequestParam(value = "page") int page,
                                      @RequestParam(value = "ohid", required = false) Integer ohid,
                                      @RequestParam(value = "mid", required = false) Integer mid,
                                      @RequestParam(value = "mname", required = false) String mname,
                                      @RequestParam(value = "whid", required = false) Integer whid,
                                      @RequestParam(value = "whname", required = false) String whname,
                                      @RequestParam(value = "sid", required = false) Integer sid,
                                      @RequestParam(value = "stockname", required = false) String stockname,
                                      @RequestParam(value = "lessNnum", required = false) Integer lessNnum,
                                      @RequestParam(value = "greaterNnum", required = false) Integer greaterNnum,
                                      @RequestParam(value = "lessVolumn", required = false) Double lessVolumn,
                                      @RequestParam(value = "greaterVolumn", required = false) Double greaterVolumn,
                                      @RequestParam(value = "lessWeight", required = false) Double lessWeight,
                                      @RequestParam(value = "greaterWeight", required = false) Double greaterWeight);

    /**
     * 添加现存量信息
     *
     * @param ohid      主键
     * @param mid       物料id
     * @param mname     物料名称
     * @param whid      仓位id
     * @param whname    仓位名称
     * @param sid       仓库id
     * @param stockname 仓位名称
     * @param nnum      数量
     * @param volumn    体积
     * @param weight    重量
     * @return
     */
    @PostMapping("onhand")
    public boolean addOnHand(@RequestParam(value = "ohid", required = false) Integer ohid,
                             @RequestParam(value = "mid") Integer mid,
                             @RequestParam(value = "mname") String mname,
                             @RequestParam(value = "whid") Integer whid,
                             @RequestParam(value = "whname") String whname,
                             @RequestParam(value = "sid") Integer sid,
                             @RequestParam(value = "stockname") String stockname,
                             @RequestParam(value = "nnum") Integer nnum,
                             @RequestParam(value = "volumn") Double volumn,
                             @RequestParam(value = "weight") Double weight);


    /**
     * 更新现存量信息
     *
     * @param ohid      主键
     * @param mid       物料id
     * @param mname     物料名称
     * @param whid      仓位id
     * @param whname    仓位名称
     * @param sid       仓库id
     * @param stockname 仓位名称
     * @param nnum      数量
     * @param volumn    体积
     * @param weight    重量
     * @return
     */
    @PutMapping("onhand/{ohid}")
    public boolean updateOnHand(@PathVariable(value = "ohid") Integer ohid,
                                @RequestParam(value = "mid", required = false) Integer mid,
                                @RequestParam(value = "mname", required = false) String mname,
                                @RequestParam(value = "whid", required = false) Integer whid,
                                @RequestParam(value = "whname", required = false) String whname,
                                @RequestParam(value = "sid", required = false) Integer sid,
                                @RequestParam(value = "stockname", required = false) String stockname,
                                @RequestParam(value = "nnum", required = false) Integer nnum,
                                @RequestParam(value = "volumn", required = false) Double volumn,
                                @RequestParam(value = "weight", required = false) Double weight);

    //OutsockbillController

    /**
     * 根据条件查询出库单
     *
     * @param pageSize           一页展示的数量
     * @param page               页码
     * @param outid              主键
     * @param outbillcode        单据号
     * @param whid               仓位id
     * @param mid                物料id
     * @param mname              物料名称
     * @param lessOutTime        最大出库时间
     * @param greaterOutTime     最小出库时间
     * @param outType            出库类型
     * @param soid               订单id
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
     * @return 出库单列表
     */
    @GetMapping("outstockbill")
    public PageInfo<Outstockbill> getOutstockbills(@RequestParam(value = "pageSize") int pageSize,
                                                   @RequestParam(value = "page") int page,
                                                   @RequestParam(value = "outid", required = false) Integer outid,
                                                   @RequestParam(value = "outbillcode", required = false) String outbillcode,
                                                   @RequestParam(value = "whid", required = false) Integer whid,
                                                   @RequestParam(value = "mid", required = false) Integer mid,
                                                   @RequestParam(value = "mname", required = false) String mname,
                                                   @RequestParam(value = "lessOutTime", required = false) Date lessOutTime,
                                                   @RequestParam(value = "greaterOutTime", required = false) Date greaterOutTime,
                                                   @RequestParam(value = "outType", required = false) String outType,
                                                   @RequestParam(value = "soid", required = false) Integer soid,
                                                   @RequestParam(value = "creator", required = false) String creator,
                                                   @RequestParam(value = "lessCreateTime", required = false) Date lessCreateTime,
                                                   @RequestParam(value = "greaterCreateTime", required = false) Date greaterCreateTime,
                                                   @RequestParam(value = "modifier", required = false) String modifier,
                                                   @RequestParam(value = "lessModifyTime", required = false) Date lessModifyTime,
                                                   @RequestParam(value = "greaterModifyTime", required = false) Date greaterModifiyTime,
                                                   @RequestParam(value = "isActive", required = false) Integer isActive,
                                                   @RequestParam(value = "nnum", required = false) Integer nnum,
                                                   @RequestParam(value = "volumn", required = false) Double volumn,
                                                   @RequestParam(value = "weight", required = false) Double weight);

    /**
     * 添加出库单
     *
     * @param outid       主键
     * @param outbillcode 单据号
     * @param whid        仓位id
     * @param mid         物料id
     * @param mname       物料名称
     * @param outTime     出库时间
     * @param outType     出库类型
     * @param soid        订单号，非必填
     * @param creator     创建者
     * @param isActive    是否启用
     * @param nnum        数量
     * @param volumn      体积
     * @param weight      重量
     * @return 成功返回true，失败返回false
     */
    @PostMapping("outstockbill")
    public boolean addOutstockbill(@RequestParam(value = "outid", required = false) Integer outid,
                                   @RequestParam(value = "outbillcode") String outbillcode,
                                   @RequestParam(value = "whid") Integer whid,
                                   @RequestParam(value = "mid") Integer mid,
                                   @RequestParam(value = "mname") String mname,
                                   @RequestParam(value = "outTime") Date outTime,
                                   @RequestParam(value = "outType") String outType,
                                   @RequestParam(value = "soid", required = false) Integer soid,
                                   @RequestParam(value = "creator") String creator,
                                   @RequestParam(value = "isActive", required = false) Integer isActive,
                                   @RequestParam(value = "nnum") Integer nnum,
                                   @RequestParam(value = "volumn") Double volumn,
                                   @RequestParam(value = "weight") Double weight);

    /**
     * 根据主键或者单据号删除/封锁出库单
     * 主键和单据号必须存在一个，否则在service会报错
     *
     * @param outid       主键
     * @param outbillcode 单据号
     * @return 返回删除条数
     */
    @DeleteMapping("outstockbill")
    public int deleteOutstockbill(@RequestParam(value = "outid", required = false) Integer outid,
                                  @RequestParam(value = "outbillcode", required = false) String outbillcode);


    /**
     * 根据主键或者单据号恢复/解封出库单
     * 主键和单据号必须存在一个，否则在service会报错
     *
     * @param outid       主键
     * @param outbillcode 单据号
     * @return 返回恢复条数
     */
    @GetMapping("ableoutstockbill")
    public int ableOutstockbill(@RequestParam(value = "outid", required = false) Integer outid,
                                @RequestParam(value = "outbillcode", required = false) String outbillcode);


    @PutMapping("outstockbill/{outid}")
    public boolean updateOutstockbill(@PathVariable(value = "outid") Integer outid,
                                      @RequestParam(value = "outbillcode", required = false) String outbillcode,
                                      @RequestParam(value = "whid", required = false) Integer whid,
                                      @RequestParam(value = "mid", required = false) Integer mid,
                                      @RequestParam(value = "mname", required = false) String mname,
                                      @RequestParam(value = "outTime", required = false) Date outTime,
                                      @RequestParam(value = "outType", required = false) String outType,
                                      @RequestParam(value = "soid", required = false) Integer soid,
                                      @RequestParam(value = "modifier") String modifier,
                                      @RequestParam(value = "isActive", required = false) Integer isActive,
                                      @RequestParam(value = "nnum", required = false) Integer nnum,
                                      @RequestParam(value = "volumn", required = false) Double volumn,
                                      @RequestParam(value = "weight", required = false) Double weight);
    //StockController
    /**
     * 根据条件查询仓库列表,并且注入仓位信息
     *
     * @param sid                仓库编码
     * @param stockname          仓库名称
     * @param lessVolumn         最大容量
     * @param greaterVolumn      最小容量
     * @param lessUsedVolumn     最大已使用容量
     * @param greaterUsedVolumn  最小已使用容量
     * @param address            地址
     * @param lessWhnum          最大仓位数量
     * @param greaterWhnum       最小仓位数量
     * @param creator            添加者
     * @param lessCreateTime     最大添加时间
     * @param greaterCreateTime  最小添加时间
     * @param modifier           修改者
     * @param lessModifyTime     最大修改时间
     * @param greaterModifiyTime 最小修改时间
     * @param isActive           是否启用
     * @return 符合条件的仓库列表
     */
    @GetMapping("stock")
    public PageInfo<Stock> getStocks(@RequestParam(value = "pageSize") int pageSize,
                                     @RequestParam(value = "page") int page,
                                     @RequestParam(value = "sid", required = false) Integer sid,
                                     @RequestParam(value = "stockname", required = false) String stockname,
                                     @RequestParam(value = "lessVolumn", required = false) Double lessVolumn,
                                     @RequestParam(value = "greaterVolumn", required = false) Double greaterVolumn,
                                     @RequestParam(value = "lessUsedVolumn", required = false) Double lessUsedVolumn,
                                     @RequestParam(value = "greaterUsedVolumn", required = false) Double greaterUsedVolumn,
                                     @RequestParam(value = "address", required = false) String address,
                                     @RequestParam(value = "lessWhnum", required = false) Integer lessWhnum,
                                     @RequestParam(value = "greaterWhnum", required = false) Integer greaterWhnum,
                                     @RequestParam(value = "creator", required = false) String creator,
                                     @RequestParam(value = "lessCreateTime", required = false) Date lessCreateTime,
                                     @RequestParam(value = "greaterCreateTime", required = false) Date greaterCreateTime,
                                     @RequestParam(value = "modifier", required = false) String modifier,
                                     @RequestParam(value = "lessModifyTime", required = false) Date lessModifyTime,
                                     @RequestParam(value = "greaterModifyTime", required = false) Date greaterModifiyTime,
                                     @RequestParam(value = "isActive", required = false) Integer isActive);
    /**
     * 添加仓库
     *
     * @param sid        编码
     * @param stockname  名称
     * @param volumn     容量
     * @param usedVolumn 已使用容量，默认0.0
     * @param address    地址
     * @param whnum      仓位数量
     * @param creator    创建者
     * @param isActive   是否启用，默认1（启用）
     * @return
     */
    @PostMapping("stock")
    public boolean addStock(@RequestParam(value = "sid", required = false) Integer sid,
                            @RequestParam(value = "stockname") String stockname,
                            @RequestParam(value = "volumn") Double volumn,
                            @RequestParam(value = "uedVolumn", required = false) Double usedVolumn,
                            @RequestParam(value = "address") String address,
                            @RequestParam(value = "whnum") Integer whnum,
                            @RequestParam(value = "creator") String creator,
                            @RequestParam(value = "isActive", required = false) Integer isActive);

    /**
     * 删除/封锁仓库
     * @param sid 编码
     * @return 成功返回true，失败返回false
     */
    @DeleteMapping("stock/{sid}")
    public boolean deleteStock(@PathVariable("sid") Integer sid);

    /**
     * 恢复/解封仓库
     * @param sid 编码
     * @return 成功返回true，失败返回false
     */
    @GetMapping("ableStock/{sid}")
    public boolean ableStock(@PathVariable("sid") Integer sid);

    /**
     * 更新仓库，有参则更，无参则不变
     * @param sid 编码
     * @param stockname 仓库名称
     * @param volumn 容量
     * @param usedVolumn 已使用容量
     * @param address 地址
     * @param whnum 仓位数量
     * @param modifier 修改人，必填
     * @param isActive 是否启用
     * @return
     */
    @PutMapping("stock/{sid}")
    public boolean updateStock(@PathVariable("sid") Integer sid,
                               @RequestParam(value = "stockname", required = false) String stockname,
                               @RequestParam(value = "volumn", required = false) Double volumn,
                               @RequestParam(value = "uedVolumn", required = false) Double usedVolumn,
                               @RequestParam(value = "address", required = false) String address,
                               @RequestParam(value = "whnum", required = false) Integer whnum,
                               @RequestParam(value = "modifier") String modifier,
                               @RequestParam(value = "isActive", required = false) Integer isActive);

    //WarehouseController
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
                                            @RequestParam(value = "isActive", required = false) Integer isActive);
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
    @PostMapping("warehouse")
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
                                @RequestParam(value = "isActive", required = false) Integer isActive);
    /**
     * 根据whid删除/封锁仓位
     *
     * @param whid 仓位编码
     * @return 成功返回true，失败返回false
     */
    @DeleteMapping("warehouse/{whid}")
    public boolean deleteWarehouse(@PathVariable("whid") Integer whid);

    /**
     * 根据whid恢复/解封仓位
     *
     * @param whid 仓位编码
     * @return 成功返回true，失败返回false
     */
    @GetMapping("ableWarehouse/{whid}")
    public boolean ableWarehouse(@PathVariable("whid") Integer whid);


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
                                   @RequestParam(value = "isActive", required = false) Integer isActive);

}
