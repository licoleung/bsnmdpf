package cn.bsnmdpf.fcprt.ordercenter5020.controller;

import cn.bsnmdpf.fcprt.api.pojo.Purchaseorder;
import cn.bsnmdpf.fcprt.ordercenter5020.service.PurchaseorderService;
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
 * @create 2020-02-08 19:09
 */
@RestController
public class PurchaseorderController {

    @Autowired
    private PurchaseorderService purchaseorderService;

    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request) {
        //转换日期 注意这里的转化要和传进来的字符串的格式一直 如2015-9-9 就应该为yyyy-MM-dd
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));// CustomDateEditor为自定义日期编辑器
    }


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
                                                     @RequestParam("poid") Integer poid,
                                                     @RequestParam("cid") Integer cid,
                                                     @RequestParam("companyname") String companyname,
                                                     @RequestParam("billcode") String billcode,
                                                     @RequestParam("lessBilldate") Date lessBilldate,
                                                     @RequestParam("greaterBilldate") Date greaterBilldate,
                                                     @RequestParam("supplierid") Integer supplierid,
                                                     @RequestParam("suppliername") String suppliername,
                                                     @RequestParam("mid") Integer mid,
                                                     @RequestParam("material") String material,
                                                     @RequestParam("nnum") Integer nnum,
                                                     @RequestParam("unit") String unit,
                                                     @RequestParam("money") Double money,
                                                     @RequestParam("orderState") Integer orderState,
                                                     @RequestParam("creator") String creator,
                                                     @RequestParam("lessCreateTime") Date lessCreateTime,
                                                     @RequestParam("greaterCreateTime") Date greaterCreateTime,
                                                     @RequestParam("modifier") String modifier,
                                                     @RequestParam("lessModifyTime") Date lessModifyTime,
                                                     @RequestParam("greaterModifyTime") Date greaterModifiyTime,
                                                     @RequestParam("approver") String approver,
                                                     @RequestParam("lessTaudittime") Date lessTaudittime,
                                                     @RequestParam("greaterTaudittime") Date greaterTaudittime,
                                                     @RequestParam("address") String address) {
        PageHelper.startPage(page, pageSize);
        List<Purchaseorder> purchaseorders = purchaseorderService.getPurchaseorders(poid, cid, companyname, billcode, lessBilldate, greaterBilldate, supplierid,
                suppliername, mid, material, nnum, unit, money, orderState, creator, lessCreateTime, greaterCreateTime,
                modifier, lessModifyTime, greaterModifiyTime, approver, lessTaudittime, greaterTaudittime, address);
        PageInfo<Purchaseorder> purchaseorderPageInfo = new PageInfo<>(purchaseorders);
        return purchaseorderPageInfo;
    }

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
                                    @RequestParam("billdate") Date billdate,
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
                                    @RequestParam(value = "taudittime", required = false) Date taudittime,
                                    @RequestParam("address") String address) {
        Purchaseorder purchaseorder = new Purchaseorder();
        purchaseorder.setPoid(poid);
        purchaseorder.setCid(cid);
        purchaseorder.setCompanyname(companyname);
        purchaseorder.setBillcode(billcode);
        purchaseorder.setBilldate(billdate);
        purchaseorder.setSupplierid(supplierid);
        purchaseorder.setSuppliername(suppliername);
        purchaseorder.setMaterial(material);
        purchaseorder.setMid(mid);
        purchaseorder.setNnum(nnum);
        purchaseorder.setUnit(unit);
        purchaseorder.setMoney(money);
        purchaseorder.setOrderstate(orderState);
        purchaseorder.setCreator(creator);
        purchaseorder.setCreatetime(new Date());
        purchaseorder.setApprover(approver);
        purchaseorder.setTaudittime(taudittime);
        purchaseorder.setAddress(address);
        boolean b = purchaseorderService.addPurchaseorder(purchaseorder);
        return b;
    }

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
                                       @RequestParam(value = "billdate", required = false) Date billdate,
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
                                       @RequestParam(value = "taudittime", required = false) Date taudittime,
                                       @RequestParam(value = "address", required = false) String address) {
        Purchaseorder purchaseorder = new Purchaseorder();
        purchaseorder.setPoid(poid);
        purchaseorder.setCid(cid);
        purchaseorder.setCompanyname(companyname);
        purchaseorder.setBillcode(billcode);
        purchaseorder.setBilldate(billdate);
        purchaseorder.setSupplierid(supplierid);
        purchaseorder.setSuppliername(suppliername);
        purchaseorder.setMaterial(material);
        purchaseorder.setMid(mid);
        purchaseorder.setNnum(nnum);
        purchaseorder.setUnit(unit);
        purchaseorder.setMoney(money);
        purchaseorder.setOrderstate(orderState);
        purchaseorder.setModifier(modifier);
        purchaseorder.setModifytime(new Date());
        purchaseorder.setApprover(approver);
        purchaseorder.setTaudittime(taudittime);
        purchaseorder.setAddress(address);
        boolean b = purchaseorderService.updatePurchaseorder(purchaseorder);
        return b;
    }

    /**
     * 根据主键删除购买订单
     * 将购买订单的订单状态设置为0（封锁）
     *
     * @param poid 购买订单主键
     * @return 成功返回true，失败返回false
     */
    @DeleteMapping("purchaseorder/{poid}")
    public boolean deletePurchaseorder(@PathVariable("poid") Integer poid) {
        boolean b = purchaseorderService.setState(poid, 0);
        return b;
    }

    /**
     * 审批购买订单
     * 将购买订单的订单状态设置为2（已审批）
     *
     * @param poid
     * @return 成功返回true，失败返回false
     */
    @PutMapping("approvePurchaseorder/{poid}")
    public boolean approvePurchaseorder(@PathVariable("poid") Integer poid) {
        boolean b = purchaseorderService.setState(poid, 2);
        return b;
    }

    /**
     * 恢复购买订单
     * 将购买订单的订单状态设置为1（未审批）
     *
     * @param poid
     * @return 成功返回true，失败返回false
     */
    @PutMapping("recoverPurchaseorder/{poid}")
    public boolean recoverPurchaseorder(@PathVariable("poid") Integer poid) {
        boolean b = purchaseorderService.setState(poid, 1);
        return b;
    }
}
