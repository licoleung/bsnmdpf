package cn.bsnmdpf.fcprt.headquarters9001.controller;

import cn.bsnmdpf.fcprt.api.pojo.Purchaseorder;
import cn.bsnmdpf.fcprt.api.pojo.Saleorder;
import cn.bsnmdpf.fcprt.api.pojo.Warehouseorder;
import cn.bsnmdpf.fcprt.api.service.OrderCenterService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author LicoLeung
 * @create 2020-02-19 16:19
 */
@Controller
public class OrderBaseController {

    @Autowired
    private OrderCenterService orderCenterService;

    @GetMapping("purchaseorder")
    public String getOrders(Model model,
                            @RequestParam(value = "pageSize", required = false, defaultValue = "6") int pageSize,
                            @RequestParam(value = "page", required = false, defaultValue = "1") int page,
                            @RequestParam(value = "poid", required = false) Integer poid,
                            @RequestParam(value = "cid", required = false) Integer cid,
                            @RequestParam(value = "companyname", required = false) String companyname,
                            @RequestParam(value = "billcode", required = false) String billcode,
                            @RequestParam(value = "lessBilldate", required = false) String lessBilldate,
                            @RequestParam(value = "greaterBilldate", required = false) String greaterBilldate,
                            @RequestParam(value = "supplierid", required = false) Integer supplierid,
                            @RequestParam(value = "suppliername", required = false) String suppliername,
                            @RequestParam(value = "mid", required = false) Integer mid,
                            @RequestParam(value = "material", required = false) String material,
                            @RequestParam(value = "nnum", required = false) Integer nnum,
                            @RequestParam(value = "unit", required = false) String unit,
                            @RequestParam(value = "money", required = false) Double money,
                            @RequestParam(value = "orderState", required = false) Integer orderState,
                            @RequestParam(value = "creator", required = false) String creator,
                            @RequestParam(value = "lessCreateTime", required = false) String lessCreateTime,
                            @RequestParam(value = "greaterCreateTime", required = false) String greaterCreateTime,
                            @RequestParam(value = "modifier", required = false) String modifier,
                            @RequestParam(value = "lessModifyTime", required = false) String lessModifyTime,
                            @RequestParam(value = "greaterModifyTime", required = false) String greaterModifiyTime,
                            @RequestParam(value = "approver", required = false) String approver,
                            @RequestParam(value = "lessTaudittime", required = false) String lessTaudittime,
                            @RequestParam(value = "greaterTaudittime", required = false) String greaterTaudittime,
                            @RequestParam(value = "address", required = false) String address,
                            @RequestParam(value = "flag", defaultValue = "1", required = false) int flag,
                            HttpSession httpSession) {
        if (billcode == "") {
            billcode = null;
        }
        PageInfo<Purchaseorder> pageInfo = null;
        if (flag == 1) {
            pageInfo = orderCenterService.getPurchaseorders(pageSize, page, poid, cid, companyname, billcode, lessBilldate, greaterBilldate, supplierid,
                    suppliername, mid, material, nnum, unit, money, orderState, creator, lessCreateTime, greaterCreateTime,
                    modifier, lessModifyTime, greaterModifiyTime, approver, lessTaudittime, greaterTaudittime, address);
            httpSession.setAttribute("cid", cid);
            httpSession.setAttribute("companyname", companyname);
            httpSession.setAttribute("billcode", billcode);
            httpSession.setAttribute("lessBilldate", lessBilldate);
            httpSession.setAttribute("greaterBilldate", greaterBilldate);
            httpSession.setAttribute("supplierid", supplierid);
            httpSession.setAttribute("suppliername", suppliername);
            httpSession.setAttribute("mid", mid);
            httpSession.setAttribute("material", material);
            httpSession.setAttribute("orderState", orderState);
        } else {
            cid = (Integer) httpSession.getAttribute("cid");
            companyname = (String) httpSession.getAttribute("companyname");
            billcode = (String) httpSession.getAttribute("billcode");
            lessBilldate = (String) httpSession.getAttribute("lessBilldate");
            greaterBilldate = (String) httpSession.getAttribute("greaterBilldate");
            supplierid = (Integer) httpSession.getAttribute("supplierid");
            suppliername = (String) httpSession.getAttribute("suppliername");
            mid = (Integer) httpSession.getAttribute("mid");
            material = (String) httpSession.getAttribute("material");
            orderState = (Integer) httpSession.getAttribute("orderState");
            pageInfo = orderCenterService.getPurchaseorders(pageSize, page, poid, cid, companyname, billcode, lessBilldate, greaterBilldate, supplierid,
                    suppliername, mid, material, nnum, unit, money, orderState, creator, lessCreateTime, greaterCreateTime,
                    modifier, lessModifyTime, greaterModifiyTime, approver, lessTaudittime, greaterTaudittime, address);
        }
        int nowPage = pageInfo.getPageNum();//当前页面
        int[] nums = pageInfo.getNavigatepageNums();

        //previous page
        if (pageInfo.isIsFirstPage()) {
            model.addAttribute("prePage", nowPage);
        } else {
            model.addAttribute("prePage", nowPage - 1);
        }

        //next page
        if (pageInfo.isIsLastPage()) {
            model.addAttribute("nextPage", nowPage);
        } else {
            model.addAttribute("nextPage", nowPage + 1);
        }
        model.addAttribute("nowPage", nowPage);
        model.addAttribute("nums", nums);
        model.addAttribute("orderlist", pageInfo.getList());
        return "order/purchase-order-list";
    }

    @GetMapping("onepo")
    public String showDetail(Integer poid, Model model) {
        PageInfo<Purchaseorder> pageInfo = orderCenterService.getPurchaseorders(1, 1, poid, null, null,
                null, null, null, null, null, null,
                null, null, null, null, null, null, null,
                null, null, null, null, null,
                null, null, null);
        List<Purchaseorder> list = pageInfo.getList();
        Purchaseorder purchaseorder = list.get(0);
        model.addAttribute("order", purchaseorder);
        return "order/purchase-order-detail";
    }

    @DeleteMapping("purchase/{poid}")
    public String lockOrder(@PathVariable("poid") Integer poid, @RequestParam("nowState") Integer nowState) {
        if (nowState > 0) {
            boolean b = orderCenterService.deletePurchaseorder(poid);
        } else {
            orderCenterService.updatePurchaseorder(poid, null, null,
                    null, null, null, null, null, null,
                    null, null, null, 1, "someone", null, null,
                    null);
        }
        return "order/purchase-order-list";
    }

    @GetMapping("approve")
    @ResponseBody
    public String approve(@RequestParam("oid") Integer oid, @RequestParam("flag") Integer flag) {
        if (flag == 1) {
            orderCenterService.approvePurchaseorder(oid);
        } else {
            orderCenterService.approveSaleorder(oid);
        }
        return "审批成功";
    }

    @GetMapping("addPoPage")
    public String addPoPage() {
        return "order/purchase-order-add";
    }

    @PostMapping("purchaseorder")
    @ResponseBody
    public String addPo(@RequestParam("cid") Integer cid,
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
                        @RequestParam(value = "orderState", required = false, defaultValue = "1") Integer orderState,
                        @RequestParam("creator") String creator,
                        @RequestParam(value = "approver", required = false) String approver,
                        @RequestParam(value = "taudittime", required = false) String taudittime,
                        @RequestParam("address") String address) {
        boolean b = orderCenterService.addPurchaseorder(null, cid, companyname, billcode, billdate, supplierid,
                suppliername, mid, material, nnum, unit, money, orderState, creator, approver, taudittime, address);
        return "添加成功";
    }

    @GetMapping("saleorder")
    public String getSaleorders(Model model,
                                @RequestParam(value = "pageSize", required = false, defaultValue = "6") int pageSize,
                                @RequestParam(value = "page", required = false, defaultValue = "1") int page,
                                @RequestParam(value = "poid", required = false) Integer poid,
                                @RequestParam(value = "cid", required = false) Integer cid,
                                @RequestParam(value = "companyname", required = false) String companyname,
                                @RequestParam(value = "billcode", required = false) String billcode,
                                @RequestParam(value = "lessBilldate", required = false) String lessBilldate,
                                @RequestParam(value = "greaterBilldate", required = false) String greaterBilldate,
                                @RequestParam(value = "supplierid", required = false) Integer supplierid,
                                @RequestParam(value = "suppliername", required = false) String suppliername,
                                @RequestParam(value = "mid", required = false) Integer mid,
                                @RequestParam(value = "material", required = false) String material,
                                @RequestParam(value = "nnum", required = false) Integer nnum,
                                @RequestParam(value = "unit", required = false) String unit,
                                @RequestParam(value = "money", required = false) Double money,
                                @RequestParam(value = "orderState", required = false) Integer orderState,
                                @RequestParam(value = "creator", required = false) String creator,
                                @RequestParam(value = "lessCreateTime", required = false) String lessCreateTime,
                                @RequestParam(value = "greaterCreateTime", required = false) String greaterCreateTime,
                                @RequestParam(value = "modifier", required = false) String modifier,
                                @RequestParam(value = "lessModifyTime", required = false) String lessModifyTime,
                                @RequestParam(value = "greaterModifyTime", required = false) String greaterModifiyTime,
                                @RequestParam(value = "approver", required = false) String approver,
                                @RequestParam(value = "lessTaudittime", required = false) String lessTaudittime,
                                @RequestParam(value = "greaterTaudittime", required = false) String greaterTaudittime,
                                @RequestParam(value = "address", required = false) String address,
                                @RequestParam(value = "flag", defaultValue = "1", required = false) int flag,
                                HttpSession httpSession) {
        if (billcode == "") {
            billcode = null;
        }

        PageInfo<Saleorder> pageInfo = null;
        if (flag == 1) {
            pageInfo = orderCenterService.getSaleorders(pageSize, page, poid, cid, companyname, billcode, lessBilldate, greaterBilldate, supplierid,
                    suppliername, mid, material, nnum, unit, money, orderState, creator, lessCreateTime, greaterCreateTime,
                    modifier, lessModifyTime, greaterModifiyTime, approver, lessTaudittime, greaterTaudittime, address);
            httpSession.setAttribute("cid", cid);
            httpSession.setAttribute("companyname", companyname);
            httpSession.setAttribute("billcode", billcode);
            httpSession.setAttribute("lessBilldate", lessBilldate);
            httpSession.setAttribute("greaterBilldate", greaterBilldate);
            httpSession.setAttribute("supplierid", supplierid);
            httpSession.setAttribute("suppliername", suppliername);
            httpSession.setAttribute("mid", mid);
            httpSession.setAttribute("material", material);
            httpSession.setAttribute("orderState", orderState);
        } else {
            cid = (Integer) httpSession.getAttribute("cid");
            companyname = (String) httpSession.getAttribute("companyname");
            billcode = (String) httpSession.getAttribute("billcode");
            lessBilldate = (String) httpSession.getAttribute("lessBilldate");
            greaterBilldate = (String) httpSession.getAttribute("greaterBilldate");
            supplierid = (Integer) httpSession.getAttribute("supplierid");
            suppliername = (String) httpSession.getAttribute("suppliername");
            mid = (Integer) httpSession.getAttribute("mid");
            material = (String) httpSession.getAttribute("material");
            orderState = (Integer) httpSession.getAttribute("orderState");
            pageInfo = orderCenterService.getSaleorders(pageSize, page, poid, cid, companyname, billcode, lessBilldate, greaterBilldate, supplierid,
                    suppliername, mid, material, nnum, unit, money, orderState, creator, lessCreateTime, greaterCreateTime,
                    modifier, lessModifyTime, greaterModifiyTime, approver, lessTaudittime, greaterTaudittime, address);
        }

        int nowPage = pageInfo.getPageNum();//当前页面
        int[] nums = pageInfo.getNavigatepageNums();

        //previous page
        if (pageInfo.isIsFirstPage()) {
            model.addAttribute("prePage", nowPage);
        } else {
            model.addAttribute("prePage", nowPage - 1);
        }

        //next page
        if (pageInfo.isIsLastPage()) {
            model.addAttribute("nextPage", nowPage);
        } else {
            model.addAttribute("nextPage", nowPage + 1);
        }
        model.addAttribute("nowPage", nowPage);
        model.addAttribute("nums", nums);
        model.addAttribute("orderlist", pageInfo.getList());
        return "order/sale-order-list";
    }

    @DeleteMapping("saleorder/{soid}")
    public String lockSOrder(@PathVariable("soid") Integer soid, @RequestParam("nowState") Integer nowState) {
        if (nowState > 0) {
            boolean b = orderCenterService.deleteSaleorder(soid);
        } else {
            orderCenterService.updateSaleorder(soid, null, null,
                    null, null, null, null, null, null,
                    null, null, null, 1, "someone", null, null,
                    null);
        }
        return "order/sale-order-list";
    }

    @GetMapping("oneso")
    public String showSDetail(Integer poid, Model model) {
        PageInfo<Saleorder> pageInfo = orderCenterService.getSaleorders(1, 1, poid, null, null,
                null, null, null, null, null, null,
                null, null, null, null, null, null, null,
                null, null, null, null, null,
                null, null, null);
        List<Saleorder> list = pageInfo.getList();
        Saleorder purchaseorder = list.get(0);
        model.addAttribute("order", purchaseorder);
        return "order/sale-order-detail";
    }

    @GetMapping("addSoPage")
    public String addSoPage() {
        return "order/sale-order-add";
    }

    @PostMapping("saleorder")
    @ResponseBody
    public String addSo(@RequestParam("cid") Integer cid,
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
                        @RequestParam(value = "orderState", required = false, defaultValue = "1") Integer orderState,
                        @RequestParam("creator") String creator,
                        @RequestParam(value = "approver", required = false) String approver,
                        @RequestParam(value = "taudittime", required = false) String taudittime,
                        @RequestParam("address") String address) {
        boolean b = orderCenterService.addSaleorder(null, cid, companyname, billcode, billdate, vipid,
                vipname, mid, material, nnum, unit, money, orderState, creator, approver, taudittime, address);
        return "添加成功";
    }

    @GetMapping("warehouseorder")
    public String getWhs(Model model,
                         @RequestParam(value = "pageSize", required = false, defaultValue = "6") int pageSize,
                         @RequestParam(value = "page", required = false, defaultValue = "1") int page,
                         @RequestParam(value = "whoid", required = false) Integer whoid,
                         @RequestParam(value = "cid", required = false) Integer cid,
                         @RequestParam(value = "companyname", required = false) String companyname,
                         @RequestParam(value = "billcode", required = false) String billcode,
                         @RequestParam(value = "lessBilldate", required = false) String lessBilldate,
                         @RequestParam(value = "greaterBilldate", required = false) String greaterBilldate,
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
                         @RequestParam(value = "lessCreateTime", required = false) String lessCreateTime,
                         @RequestParam(value = "greaterCreateTime", required = false) String greaterCreateTime,
                         @RequestParam(value = "modifier", required = false) String modifier,
                         @RequestParam(value = "lessModifyTime", required = false) String lessModifyTime,
                         @RequestParam(value = "greaterModifyTime", required = false) String greaterModifiyTime,
                         @RequestParam(value = "whid", required = false) Integer whid,
                         @RequestParam(value = "warehouseName", required = false) String warehouseName,
                         @RequestParam(value = "sid", required = false) Integer sid,
                         @RequestParam(value = "stockName", required = false) String stockName,
                         @RequestParam(value = "flag", defaultValue = "1", required = false) int flag,
                         HttpSession httpSession) {
        if (billcode == "") {
            billcode = null;
        }

        PageInfo<Warehouseorder> pageInfo = null;
        if (flag == 1) {
            pageInfo = orderCenterService.getWarehouseorder(pageSize, page, whoid, cid, companyname, billcode, lessBilldate, greaterBilldate, vipid,
                    vipname, mid, material, nnum, weight, volumn, money, orderState, creator, lessCreateTime, greaterCreateTime,
                    modifier, lessModifyTime, greaterModifiyTime, whid, warehouseName, sid, stockName);
            httpSession.setAttribute("cid", cid);
            httpSession.setAttribute("companyname", companyname);
            httpSession.setAttribute("billcode", billcode);
            httpSession.setAttribute("lessBilldate", lessBilldate);
            httpSession.setAttribute("greaterBilldate", greaterBilldate);
            httpSession.setAttribute("vipid", vipid);
            httpSession.setAttribute("vipname", vipname);
            httpSession.setAttribute("mid", mid);
            httpSession.setAttribute("material", material);
            httpSession.setAttribute("orderState", orderState);
        } else {
            cid = (Integer) httpSession.getAttribute("cid");
            companyname = (String) httpSession.getAttribute("companyname");
            billcode = (String) httpSession.getAttribute("billcode");
            lessBilldate = (String) httpSession.getAttribute("lessBilldate");
            greaterBilldate = (String) httpSession.getAttribute("greaterBilldate");
            vipid = (Integer) httpSession.getAttribute("vipid");
            vipname = (String) httpSession.getAttribute("vipname");
            mid = (Integer) httpSession.getAttribute("mid");
            material = (String) httpSession.getAttribute("material");
            orderState = (Integer) httpSession.getAttribute("orderState");
            pageInfo = orderCenterService.getWarehouseorder(pageSize, page, whoid, cid, companyname, billcode, lessBilldate, greaterBilldate, vipid,
                    vipname, mid, material, nnum, weight, volumn, money, orderState, creator, lessCreateTime, greaterCreateTime,
                    modifier, lessModifyTime, greaterModifiyTime, whid, warehouseName, sid, stockName);
        }

        int nowPage = pageInfo.getPageNum();//当前页面
        int[] nums = pageInfo.getNavigatepageNums();

        //previous page
        if (pageInfo.isIsFirstPage()) {
            model.addAttribute("prePage", nowPage);
        } else {
            model.addAttribute("prePage", nowPage - 1);
        }

        //next page
        if (pageInfo.isIsLastPage()) {
            model.addAttribute("nextPage", nowPage);
        } else {
            model.addAttribute("nextPage", nowPage + 1);
        }
        model.addAttribute("nowPage", nowPage);
        model.addAttribute("nums", nums);
        model.addAttribute("orderlist", pageInfo.getList());
        return "order/warehouse-order-list";
    }
}
