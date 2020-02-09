package cn.bsnmdpf.fcprt.ordercenter5020.controller;

import cn.bsnmdpf.fcprt.api.pojo.Warehouseorder;
import cn.bsnmdpf.fcprt.ordercenter5020.service.WarehouseorderService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author LicoLeung
 * @create 2020-02-09 15:54
 */
@RestController
public class WarehouseorderController {

    @Autowired
    private WarehouseorderService warehouseorderService;

    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request) {
        //转换日期 注意这里的转化要和传进来的字符串的格式一直 如2015-9-9 就应该为yyyy-MM-dd
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));// CustomDateEditor为自定义日期编辑器
    }


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
                                                      @RequestParam("lessBilldate") Date lessBilldate,
                                                      @RequestParam("greaterBilldate") Date greaterBilldate,
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
                                                      @RequestParam("lessCreateTime") Date lessCreateTime,
                                                      @RequestParam("greaterCreateTime") Date greaterCreateTime,
                                                      @RequestParam("modifier") String modifier,
                                                      @RequestParam("lessModifyTime") Date lessModifyTime,
                                                      @RequestParam("greaterModifyTime") Date greaterModifiyTime,
                                                      @RequestParam("whid") Integer whid,
                                                      @RequestParam("warehouseName") String warehouseName,
                                                      @RequestParam("sid") Integer sid,
                                                      @RequestParam("stockName") String stockName) {
        PageHelper.startPage(page, pageSize);
        List<Warehouseorder> warehouseorders = warehouseorderService.getWarehouseorders(whoid, cid, companyname, billcode, lessBilldate, greaterBilldate, vipid,
                vipname, mid, material, nnum, weight, volumn, money, orderState, creator, lessCreateTime, greaterCreateTime,
                modifier, lessModifyTime, greaterModifiyTime, whid, warehouseName, sid, stockName);
        PageInfo<Warehouseorder> warehouseorderPageInfo = new PageInfo<>(warehouseorders);
        return warehouseorderPageInfo;
    }

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
                                     @RequestParam("billdate") Date billdate,
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
                                     @RequestParam("stockName") String stockName) {
        Warehouseorder warehouseorder = new Warehouseorder();
        warehouseorder.setWhoid(whoid);
        warehouseorder.setCid(cid);
        warehouseorder.setCompanyname(companyname);
        warehouseorder.setBillcode(billcode);
        warehouseorder.setBilldate(billdate);
        warehouseorder.setVipid(vipid);
        warehouseorder.setVipname(vipname);
        warehouseorder.setMid(mid);
        warehouseorder.setMaterial(material);
        warehouseorder.setNnum(nnum);
        warehouseorder.setMoney(money);
        warehouseorder.setWeight(weight);
        warehouseorder.setVolumn(volumn);
        warehouseorder.setOrderstate(orderState);
        warehouseorder.setCreator(creator);
        warehouseorder.setCreatetime(new Date());
        warehouseorder.setWhid(whid);
        warehouseorder.setSid(sid);
        warehouseorder.setWarehousename(warehouseName);
        warehouseorder.setStockname(stockName);
        boolean b = warehouseorderService.addWarehouseorder(warehouseorder);
        return b;
    }

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
                                        @RequestParam(value = "billdate", required = false) Date billdate,
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
                                        @RequestParam(value = "stockName", required = false) String stockName) {
        Warehouseorder warehouseorder = new Warehouseorder();
        warehouseorder.setWhoid(whoid);
        warehouseorder.setCid(cid);
        warehouseorder.setCompanyname(companyname);
        warehouseorder.setBillcode(billcode);
        warehouseorder.setBilldate(billdate);
        warehouseorder.setVipid(vipid);
        warehouseorder.setVipname(vipname);
        warehouseorder.setMid(mid);
        warehouseorder.setMaterial(material);
        warehouseorder.setNnum(nnum);
        warehouseorder.setMoney(money);
        warehouseorder.setWeight(weight);
        warehouseorder.setVolumn(volumn);
        warehouseorder.setOrderstate(orderState);
        warehouseorder.setCreator(creator);
        warehouseorder.setCreatetime(new Date());
        warehouseorder.setWhid(whid);
        warehouseorder.setSid(sid);
        warehouseorder.setWarehousename(warehouseName);
        warehouseorder.setStockname(stockName);
        boolean b = warehouseorderService.updateWarehouseorder(warehouseorder);
        return b;
    }

    /**
     * 根据主键删除存储订单
     * 将存储订单的订单状态设置为0（封锁）
     *
     * @param whoid 存储订单主键
     * @return 成功返回true，失败返回false
     */
    @DeleteMapping("warehouseorder/{whoid}")
    public boolean deleteWarehouseorder(@PathVariable("whoid") Integer whoid) {
        boolean b = warehouseorderService.setState(whoid, 0);
        return b;
    }

    /**
     * 审批存储订单
     * 将存储订单的订单状态设置为2（已审批）
     *
     * @param whoid
     * @return 成功返回true，失败返回false
     */
    @PutMapping("approveWarehouseorder/{whoid}")
    public boolean approveWarehouseorder(@PathVariable("whoid") Integer whoid) {
        boolean b = warehouseorderService.setState(whoid, 2);
        return b;
    }

    /**
     * 恢复存储订单
     * 将存储订单的订单状态设置为1（未审批）
     *
     * @param whoid
     * @return 成功返回true，失败返回false
     */
    @PutMapping("recoverWarehouseorder/{whoid}")
    public boolean recoverWarehouseorder(@PathVariable("whoid") Integer whoid) {
        boolean b = warehouseorderService.setState(whoid, 1);
        return b;
    }
}
