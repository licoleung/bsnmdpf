package cn.bsnmdpf.fcprt.ordercenter5020.controller;

import cn.bsnmdpf.fcprt.api.pojo.Purchaseorder;
import cn.bsnmdpf.fcprt.ordercenter5020.service.PurchaseorderService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("purchaseorder")
    public boolean addPurchaseorder(@RequestParam(value = "poid",required = false) Integer poid,
                                    @RequestParam("cid") Integer cid,
                                    @RequestParam("companyname") String companyname,
                                    @RequestParam("billcode") String billcode,
                                    @RequestParam("billdate") Date billdate,
                                    @RequestParam(value = "supplierid",required = false) Integer supplierid,
                                    @RequestParam("suppliername") String suppliername,
                                    @RequestParam(value = "mid",required = false) Integer mid,
                                    @RequestParam("material") String material,
                                    @RequestParam("nnum") Integer nnum,
                                    @RequestParam("unit") String unit,
                                    @RequestParam("money") Double money,
                                    @RequestParam("orderState") Integer orderState,
                                    @RequestParam("creator") String creator,
                                    @RequestParam(value = "approver",required = false) String approver,
                                    @RequestParam(value = "taudittime",required = false) Date taudittime,
                                    @RequestParam("address") String address){
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

    @PutMapping("purchaseorder/{poid}")
    public boolean updatePurchaseorder(@PathVariable(value = "poid") Integer poid,
                                       @RequestParam(value = "cid",required = false) Integer cid,
                                       @RequestParam(value = "companyname",required = false) String companyname,
                                       @RequestParam(value = "billcode",required = false) String billcode,
                                       @RequestParam(value = "billdate",required = false) Date billdate,
                                       @RequestParam(value = "supplierid",required = false) Integer supplierid,
                                       @RequestParam(value = "suppliername",required = false) String suppliername,
                                       @RequestParam(value = "mid",required = false) Integer mid,
                                       @RequestParam(value = "material",required = false) String material,
                                       @RequestParam(value = "nnum",required = false) Integer nnum,
                                       @RequestParam(value = "unit",required = false) String unit,
                                       @RequestParam(value = "money",required = false) Double money,
                                       @RequestParam(value = "orderState",required = false) Integer orderState,
                                       @RequestParam("modifier") String modifier,
                                       @RequestParam(value = "approver",required = false) String approver,
                                       @RequestParam(value = "taudittime",required = false) Date taudittime,
                                       @RequestParam(value = "address",required = false) String address){
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

    @DeleteMapping("purchaseorder/{poid}")
    public boolean deletePurchaseorder(@PathVariable("poid") Integer poid){
        boolean b = purchaseorderService.setState(poid, 0);
        return b;
    }

    @PutMapping("approvePurchaseorder/{poid}")
    public boolean approvePurchaseorder(@PathVariable("poid") Integer poid){
        boolean b = purchaseorderService.setState(poid, 2);
        return b;
    }

    @PutMapping("recoverPurchaseorder/{poid}")
    public boolean recoverPurchaseorder(@PathVariable("poid") Integer poid){
        boolean b = purchaseorderService.setState(poid, 1);
        return b;
    }
}
