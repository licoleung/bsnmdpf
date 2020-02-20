package cn.bsnmdpf.fcprt.ordercenter5020.controller;

import cn.bsnmdpf.fcprt.api.pojo.Saleorder;
import cn.bsnmdpf.fcprt.ordercenter5020.service.SaleorderService;
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
 * @create 2020-02-09 15:35
 */
@RestController
public class SaleorderController {

    @Autowired
    private SaleorderService saleorderService;

    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request) {
        //转换日期 注意这里的转化要和传进来的字符串的格式一直 如2015-9-9 就应该为yyyy-MM-dd
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));// CustomDateEditor为自定义日期编辑器
    }

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
                                                 @RequestParam("lessBilldate") Date lessBilldate,
                                                 @RequestParam("greaterBilldate") Date greaterBilldate,
                                                 @RequestParam("vipid") Integer vipid,
                                                 @RequestParam("vipname") String vipname,
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
        List<Saleorder> saleorders = saleorderService.getSaleorders(soid, cid, companyname, billcode, lessBilldate, greaterBilldate, vipid,
                vipname, mid, material, nnum, unit, money, orderState, creator, lessCreateTime, greaterCreateTime,
                modifier, lessModifyTime, greaterModifiyTime, approver, lessTaudittime, greaterTaudittime, address);
        PageInfo<Saleorder> saleorderPageInfo = new PageInfo<>(saleorders);
        return saleorderPageInfo;
    }

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
                                    @RequestParam("billdate") Date billdate,
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
                                    @RequestParam(value = "taudittime", required = false) Date taudittime,
                                    @RequestParam("address") String address) {
        Saleorder saleorder = new Saleorder();
        saleorder.setSoid(soid);
        saleorder.setCid(cid);
        saleorder.setCompanyname(companyname);
        saleorder.setBillcode(billcode);
        saleorder.setBilldate(billdate);
        saleorder.setVipid(vipid);
        saleorder.setVipname(vipname);
        saleorder.setMaterial(material);
        saleorder.setMid(mid);
        saleorder.setNnum(nnum);
        saleorder.setUnit(unit);
        saleorder.setMoney(money);
        saleorder.setOrderstate(orderState);
        saleorder.setCreator(creator);
        saleorder.setCreatetime(new Date());
        saleorder.setApprover(approver);
        saleorder.setTaudittime(taudittime);
        saleorder.setAddress(address);
        boolean b = saleorderService.addSaleorder(saleorder);
        return b;
    }

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
                                       @RequestParam(value = "billdate", required = false) Date billdate,
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
                                       @RequestParam(value = "taudittime", required = false) Date taudittime,
                                       @RequestParam(value = "address", required = false) String address) {
        Saleorder saleorder = new Saleorder();
        saleorder.setSoid(soid);
        saleorder.setCid(cid);
        saleorder.setCompanyname(companyname);
        saleorder.setBillcode(billcode);
        saleorder.setBilldate(billdate);
        saleorder.setVipid(vipid);
        saleorder.setVipname(vipname);
        saleorder.setMaterial(material);
        saleorder.setMid(mid);
        saleorder.setNnum(nnum);
        saleorder.setUnit(unit);
        saleorder.setMoney(money);
        saleorder.setOrderstate(orderState);
        saleorder.setModifier(modifier);
        saleorder.setModifytime(new Date());
        saleorder.setApprover(approver);
        saleorder.setTaudittime(taudittime);
        saleorder.setAddress(address);
        boolean b = saleorderService.updateSaleorder(saleorder);
        return b;
    }


    /**
     * 根据主键删除销售订单
     * 将销售订单的订单状态设置为0（封锁）
     *
     * @param soid 销售订单主键
     * @return 成功返回true，失败返回false
     */
    @DeleteMapping("saleorder/{soid}")
    public boolean deleteSaleorder(@PathVariable("soid") Integer soid) {
        boolean b = saleorderService.setState(soid, 0);
        return b;
    }

    /**
     * 审批销售订单
     * 将销售订单的订单状态设置为2（已审批）
     *
     * @param soid
     * @return 成功返回true，失败返回false
     */
    @PutMapping("approveSaleorder/{soid}")
    public boolean approveSaleorder(@PathVariable("soid") Integer soid) {
        boolean b = saleorderService.setState(soid, 2);
        return b;
    }

    /**
     * 恢复销售订单
     * 将销售订单的订单状态设置为1（未审批）
     *
     * @param soid
     * @return 成功返回true，失败返回false
     */
    @PutMapping("recoverSaleorder/{soid}")
    public boolean recoverSaleorder(@PathVariable("soid") Integer soid) {
        boolean b = saleorderService.setState(soid, 1);
        return b;
    }
}
