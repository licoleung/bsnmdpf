package cn.bsnmdpf.fcprt.headquarters9001.controller;

import cn.bsnmdpf.fcprt.api.pojo.*;
import cn.bsnmdpf.fcprt.api.service.StockCenterService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * @author LicoLeung
 * @create 2020-02-06 13:43
 */
@Controller
public class StockBaseController {

    @Autowired
    private StockCenterService stockCenterService;


    @GetMapping("instockbill")
    public String getInstockbills(@RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
                                  @RequestParam(value = "page", defaultValue = "1") int page,
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
                                  @RequestParam(value = "weight", required = false) Double weight,
                                  @RequestParam(value = "flag", defaultValue = "1", required = false) int flag,
                                  Model model,
                                  HttpSession httpSession) {
        if (inbillcode == "") {
            inbillcode = null;
        }
        if (inType == "") {
            inType = null;
        }
        PageInfo<Instockbill> pageInfo = null;
        if (flag == 1) {
            pageInfo = stockCenterService.getInstockbills(pageSize, page, inid, inbillcode, whid, mid, mname, lessInTime,
                    greaterInTime, inType, poid, creator, lessCreateTime, greaterCreateTime, modifier, lessModifyTime,
                    greaterModifiyTime, isActive, nnum, volumn, weight);
            httpSession.setAttribute("inbillcode", inbillcode);
            httpSession.setAttribute("whid", whid);
            httpSession.setAttribute("mname", mname);
            httpSession.setAttribute("mid", mid);
            httpSession.setAttribute("lessInTime", lessInTime);
            httpSession.setAttribute("greaterInTime", greaterInTime);
            httpSession.setAttribute("inid", inid);
            httpSession.setAttribute("inType", inType);
            httpSession.setAttribute("isActive", isActive);
        } else {
            inbillcode = (String) httpSession.getAttribute("inbillcode");
            whid = (Integer) httpSession.getAttribute("whid");
            mname = (String) httpSession.getAttribute("mname");
            mid = (Integer) httpSession.getAttribute("mid");
            lessInTime = (String) httpSession.getAttribute("lessInTime");
            greaterInTime = (String) httpSession.getAttribute("greaterInTime");
            inid = (Integer) httpSession.getAttribute("inid");
            inType = (String) httpSession.getAttribute("inType");
            isActive = (Integer) httpSession.getAttribute("isActive");
            pageInfo = stockCenterService.getInstockbills(pageSize, page, inid, inbillcode, whid, mid, mname, lessInTime,
                    greaterInTime, inType, poid, creator, lessCreateTime, greaterCreateTime, modifier, lessModifyTime,
                    greaterModifiyTime, isActive, nnum, volumn, weight);
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
        model.addAttribute("inbills", pageInfo.getList());
        return "stock/inbill-list";
    }

    @GetMapping("oneibo")
    public String showDetail(Integer inid, Model model) {
        PageInfo<Instockbill> pageInfo = stockCenterService.getInstockbills(1, 1, inid, null,
                null, null, null, null, null, null, null,
                null, null, null, null, null,
                null, null, null, null, null);
        List<Instockbill> list = pageInfo.getList();
        Instockbill instockbill = list.get(0);
        model.addAttribute("inbill", instockbill);
        return "stock/inbill-detail";
    }

    @DeleteMapping("instockbill/{inid}")
    public String lockinstockbill(@PathVariable("inid") Integer inid, @RequestParam("nowState") Integer nowState) {
        if (nowState > 0) {
            int b = stockCenterService.deleteInstockbill(inid, null);
        } else {
            stockCenterService.ableInstockbill(inid, null);
        }
        return "stock/inbill-list";
    }

    @GetMapping("addIbPage")
    public String addPageofIB() {
        return "stock/inbill-add";
    }

    @PostMapping("instockbill")
    @ResponseBody
    public String addInstockbill(@RequestParam(value = "inid", required = false) Integer inid,
                                 @RequestParam(value = "inbillcode") String inbillcode,
                                 @RequestParam(value = "whid") Integer whid,
                                 @RequestParam(value = "mid") Integer mid,
                                 @RequestParam(value = "mname") String mname,
                                 @RequestParam(value = "inTime") String inTime,
                                 @RequestParam(value = "inType") String inType,
                                 @RequestParam(value = "poid", required = false) Integer poid,
                                 @RequestParam(value = "creator") String creator,
                                 @RequestParam(value = "isActive", required = false) Integer isActive,
                                 @RequestParam(value = "nnum") Integer nnum,
                                 @RequestParam(value = "volumn") Double volumn,
                                 @RequestParam(value = "weight") Double weight) {
        boolean b = stockCenterService.addInstockbill(inid, inbillcode, whid, mid, mname, inTime, inType, poid, creator, isActive, nnum, volumn, weight);
        return "添加成功";
    }

    @GetMapping("outstockbill")
    public String getOutstockbills(@RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize,
                                   @RequestParam(value = "page", defaultValue = "1", required = false) int page,
                                   @RequestParam(value = "outid", required = false) Integer outid,
                                   @RequestParam(value = "outbillcode", required = false) String outbillcode,
                                   @RequestParam(value = "whid", required = false) Integer whid,
                                   @RequestParam(value = "mid", required = false) Integer mid,
                                   @RequestParam(value = "mname", required = false) String mname,
                                   @RequestParam(value = "lessOutTime", required = false) String lessOutTime,
                                   @RequestParam(value = "greaterOutTime", required = false) String greaterOutTime,
                                   @RequestParam(value = "outType", required = false) String outType,
                                   @RequestParam(value = "soid", required = false) Integer soid,
                                   @RequestParam(value = "creator", required = false) String creator,
                                   @RequestParam(value = "lessCreateTime", required = false) String lessCreateTime,
                                   @RequestParam(value = "greaterCreateTime", required = false) String greaterCreateTime,
                                   @RequestParam(value = "modifier", required = false) String modifier,
                                   @RequestParam(value = "lessModifyTime", required = false) String lessModifyTime,
                                   @RequestParam(value = "greaterModifyTime", required = false) String greaterModifiyTime,
                                   @RequestParam(value = "isActive", required = false) Integer isActive,
                                   @RequestParam(value = "nnum", required = false) Integer nnum,
                                   @RequestParam(value = "volumn", required = false) Double volumn,
                                   @RequestParam(value = "weight", required = false) Double weight,
                                   @RequestParam(value = "flag", defaultValue = "1", required = false) int flag,
                                   Model model,
                                   HttpSession httpSession) {
        if (outbillcode == "") {
            outbillcode = null;
        }
        if (outType == "") {
            outType = null;
        }
        PageInfo<Outstockbill> pageInfo = null;
        if (flag == 1) {
            pageInfo = stockCenterService.getOutstockbills(pageSize, page, outid, outbillcode, whid, mid, mname, lessOutTime,
                    greaterOutTime, outType, soid, creator, lessCreateTime, greaterCreateTime, modifier, lessModifyTime,
                    greaterModifiyTime, isActive, nnum, volumn, weight);
            httpSession.setAttribute("outbillcode", outbillcode);
            httpSession.setAttribute("whid", whid);
            httpSession.setAttribute("mname", mname);
            httpSession.setAttribute("mid", mid);
            httpSession.setAttribute("lessOutTime", lessOutTime);
            httpSession.setAttribute("greaterOutTime", greaterOutTime);
            httpSession.setAttribute("outid", outid);
            httpSession.setAttribute("outType", outType);
            httpSession.setAttribute("isActive", isActive);
        } else {
            outbillcode = (String) httpSession.getAttribute("outbillcode");
            whid = (Integer) httpSession.getAttribute("whid");
            mname = (String) httpSession.getAttribute("mname");
            mid = (Integer) httpSession.getAttribute("mid");
            lessOutTime = (String) httpSession.getAttribute("lessOutTime");
            greaterOutTime = (String) httpSession.getAttribute("greaterOutTime");
            outid = (Integer) httpSession.getAttribute("outid");
            outType = (String) httpSession.getAttribute("outType");
            isActive = (Integer) httpSession.getAttribute("isActive");
            pageInfo = stockCenterService.getOutstockbills(pageSize, page, outid, outbillcode, whid, mid, mname, lessOutTime,
                    greaterOutTime, outType, soid, creator, lessCreateTime, greaterCreateTime, modifier, lessModifyTime,
                    greaterModifiyTime, isActive, nnum, volumn, weight);
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
        model.addAttribute("outbills", pageInfo.getList());
        return "stock/outbill-list";
    }

    @DeleteMapping("outstockbill/{outid}")
    public String lockoutstockbill(@PathVariable("outid") Integer outid, @RequestParam("nowState") Integer nowState) {
        if (nowState > 0) {
            int b = stockCenterService.deleteOutstockbill(outid, null);
        } else {
            stockCenterService.ableOutstockbill(outid, null);
        }
        return "stock/outbill-list";
    }

    @GetMapping("addObPage")
    public String addPageofOB() {
        return "stock/outbill-add";
    }

    @PostMapping("outstockbill")
    @ResponseBody
    public String addOutstockbill(@RequestParam(value = "outid", required = false) Integer outid,
                                  @RequestParam(value = "outbillcode") String outbillcode,
                                  @RequestParam(value = "whid") Integer whid,
                                  @RequestParam(value = "mid") Integer mid,
                                  @RequestParam(value = "mname") String mname,
                                  @RequestParam(value = "outTime") String outTime,
                                  @RequestParam(value = "outType") String outType,
                                  @RequestParam(value = "poid", required = false) Integer poid,
                                  @RequestParam(value = "creator") String creator,
                                  @RequestParam(value = "isActive", required = false) Integer isActive,
                                  @RequestParam(value = "nnum") Integer nnum,
                                  @RequestParam(value = "volumn") Double volumn,
                                  @RequestParam(value = "weight") Double weight) {
        boolean b = stockCenterService.addInstockbill(outid, outbillcode, whid, mid, mname, outTime, outType, poid, creator, isActive, nnum, volumn, weight);
        return "添加成功";
    }

    @GetMapping("oneobo")
    public String showDetailO(Integer outid, Model model) {
        PageInfo<Outstockbill> pageInfo = stockCenterService.getOutstockbills(1, 1, outid, null,
                null, null, null, null, null, null, null,
                null, null, null, null, null,
                null, null, null, null, null);
        List<Outstockbill> list = pageInfo.getList();
        Outstockbill outstockbill = list.get(0);
        model.addAttribute("outbill", outstockbill);
        return "stock/outbill-detail";
    }

    @GetMapping("onhand")
    public String getOnhandList(@RequestParam(value = "pageSize", required = false, defaultValue = "6") int pageSize,
                                @RequestParam(value = "page", required = false, defaultValue = "1") int page,
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
                                @RequestParam(value = "greaterWeight", required = false) Double greaterWeight,
                                @RequestParam(value = "flag", defaultValue = "1", required = false) int flag,
                                Model model,
                                HttpSession httpSession) {
        PageInfo<OnHand> pageInfo = null;
        if (flag == 1) {
            pageInfo = stockCenterService.getOnHand(pageSize, page, ohid, mid, mname, whid, whname, sid, stockname, lessNnum,
                    greaterNnum, lessVolumn, greaterVolumn, lessWeight, greaterWeight);
            httpSession.setAttribute("mname", mname);
            httpSession.setAttribute("mid", mid);
            httpSession.setAttribute("whid", whid);
            httpSession.setAttribute("whname", whname);
            httpSession.setAttribute("sid", sid);
            httpSession.setAttribute("lessNnum", lessNnum);
            httpSession.setAttribute("stockname", stockname);
            httpSession.setAttribute("greaterNnum", greaterNnum);
            httpSession.setAttribute("lessVolumn", lessVolumn);
            httpSession.setAttribute("greaterVolumn", greaterVolumn);
            httpSession.setAttribute("lessWeight", lessWeight);
            httpSession.setAttribute("greaterWeight", greaterWeight);
        } else {
            whid = (Integer) httpSession.getAttribute("whid");
            mname = (String) httpSession.getAttribute("mname");
            mid = (Integer) httpSession.getAttribute("mid");
            whname = (String) httpSession.getAttribute("whname");
            sid = (Integer) httpSession.getAttribute("sid");
            lessNnum = (Integer) httpSession.getAttribute("lessNnum");
            stockname = (String) httpSession.getAttribute("stockname");
            greaterNnum = (Integer) httpSession.getAttribute("greaterNnum");
            lessVolumn = (Double) httpSession.getAttribute("lessVolumn");
            greaterVolumn = (Double) httpSession.getAttribute("greaterVolumn");
            lessWeight = (Double) httpSession.getAttribute("lessWeight");
            greaterWeight = (Double) httpSession.getAttribute("greaterWeight");
            pageInfo = stockCenterService.getOnHand(pageSize, page, ohid, mid, mname, whid, whname, sid, stockname, lessNnum,
                    greaterNnum, lessVolumn, greaterVolumn, lessWeight, greaterWeight);
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
        model.addAttribute("onhands", pageInfo.getList());
        return "stock/onhand-list";
    }

    @GetMapping("stock")
    public String getStocks(@RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize,
                            @RequestParam(value = "page", required = false, defaultValue = "1") int page,
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
                            @RequestParam(value = "lessCreateTime", required = false) String lessCreateTime,
                            @RequestParam(value = "greaterCreateTime", required = false) String greaterCreateTime,
                            @RequestParam(value = "modifier", required = false) String modifier,
                            @RequestParam(value = "lessModifyTime", required = false) String lessModifyTime,
                            @RequestParam(value = "greaterModifyTime", required = false) String greaterModifiyTime,
                            @RequestParam(value = "isActive", required = false) Integer isActive,
                            @RequestParam(value = "flag", defaultValue = "1", required = false) int flag,
                            Model model,
                            HttpSession httpSession) {
        PageInfo<Stock> pageInfo = null;
        if (flag == 1) {
            pageInfo = stockCenterService.getStocks(pageSize, page, sid, stockname, lessVolumn, greaterVolumn,
                    lessUsedVolumn, greaterUsedVolumn, address, lessWhnum, greaterWhnum, creator, lessCreateTime,
                    greaterCreateTime, modifier, lessModifyTime, greaterModifiyTime, isActive);
            httpSession.setAttribute("sid", sid);
            httpSession.setAttribute("stockname", stockname);
            httpSession.setAttribute("lessVolumn", lessVolumn);
            httpSession.setAttribute("greaterVolumn", greaterVolumn);
            httpSession.setAttribute("address", address);
            httpSession.setAttribute("isActive", isActive);
        } else {
            sid = (Integer) httpSession.getAttribute("sid");
            stockname = (String) httpSession.getAttribute("stockname");
            lessVolumn = (Double) httpSession.getAttribute("lessVolumn");
            greaterVolumn = (Double) httpSession.getAttribute("greaterVolumn");
            address = (String) httpSession.getAttribute("address");
            isActive = (Integer) httpSession.getAttribute("isActive");
            pageInfo = stockCenterService.getStocks(pageSize, page, sid, stockname, lessVolumn, greaterVolumn,
                    lessUsedVolumn, greaterUsedVolumn, address, lessWhnum, greaterWhnum, creator, lessCreateTime,
                    greaterCreateTime, modifier, lessModifyTime, greaterModifiyTime, isActive);
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
        model.addAttribute("stocks", pageInfo.getList());
        return "stock/stock-list";
    }

    @GetMapping("warehouse")
    public String getWarehouses(@RequestParam(value = "pageSize",required = false,defaultValue = "10") int pageSize,
                                @RequestParam(value = "page",defaultValue = "1",required = false) int page,
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
                                @RequestParam(value = "lessCreateTime", required = false) String lessCreateTime,
                                @RequestParam(value = "greaterCreateTime", required = false) String greaterCreateTime,
                                @RequestParam(value = "modifier", required = false) String modifier,
                                @RequestParam(value = "lessModifyTime", required = false) String lessModifyTime,
                                @RequestParam(value = "greaterModifyTime", required = false) String greaterModifiyTime,
                                @RequestParam(value = "isActive", required = false) Integer isActive,
                                @RequestParam(value = "flag", defaultValue = "1", required = false) int flag,
                                Model model,
                                HttpSession httpSession){
        PageInfo<Warehouse> pageInfo = null;
        if(flag==1){
            pageInfo = stockCenterService.getWarehouse(pageSize,page,whid, sid, warehousename, lessVolumn, greaterVolumn,
                    lessUsedVolumn, greaterUsedVolumn, address, charge, chargePhone, whtype, creator, lessCreateTime,
                    greaterCreateTime, modifier, lessModifyTime, greaterModifiyTime, isActive);
            httpSession.setAttribute("sid", sid);
            httpSession.setAttribute("whid", whid);
            httpSession.setAttribute("warehousename", warehousename);
            httpSession.setAttribute("lessVolumn", lessVolumn);
            httpSession.setAttribute("greaterVolumn", greaterVolumn);
            httpSession.setAttribute("address", address);
            httpSession.setAttribute("isActive", isActive);
        }else{
            whid = (Integer) httpSession.getAttribute("whid");
            sid = (Integer) httpSession.getAttribute("sid");
            warehousename = (String) httpSession.getAttribute("warehousename");
            lessVolumn = (Double) httpSession.getAttribute("lessVolumn");
            greaterVolumn = (Double) httpSession.getAttribute("greaterVolumn");
            address = (String) httpSession.getAttribute("address");
            isActive = (Integer) httpSession.getAttribute("isActive");
            pageInfo = stockCenterService.getWarehouse(pageSize,page,whid, sid, warehousename, lessVolumn, greaterVolumn,
                    lessUsedVolumn, greaterUsedVolumn, address, charge, chargePhone, whtype, creator, lessCreateTime,
                    greaterCreateTime, modifier, lessModifyTime, greaterModifiyTime, isActive);
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
        model.addAttribute("warehouses", pageInfo.getList());
        return "stock/warehouse-list";
    }
}
