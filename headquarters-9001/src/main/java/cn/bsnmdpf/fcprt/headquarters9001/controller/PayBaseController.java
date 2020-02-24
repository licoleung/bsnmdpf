package cn.bsnmdpf.fcprt.headquarters9001.controller;

import cn.bsnmdpf.fcprt.api.pojo.Purchasebill;
import cn.bsnmdpf.fcprt.api.pojo.Salebill;
import cn.bsnmdpf.fcprt.api.service.PayCenterService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @author LicoLeung
 * @create 2020-02-24 16:08
 */
@Controller
public class PayBaseController {

    @Autowired
    private PayCenterService payCenterService;

    @GetMapping("purchasebill")
    public String getPurchaseBills(@RequestParam(value = "pageSize",defaultValue = "6",required = false) int pageSize,
                                   @RequestParam(value = "page",defaultValue = "1",required = false) int page,
                                   @RequestParam(value = "pbid",required = false) String pbid,
                                   @RequestParam(value = "billcode",required = false) String billcode,
                                   @RequestParam(value = "lessMoney",required = false) Double lessMoney,
                                   @RequestParam(value = "greaterMoney",required = false) Double greaterMoney,
                                   @RequestParam(value = "lessBilldate",required = false) String lessBilldate,
                                   @RequestParam(value = "greaterBilldate",required = false) String greaterBilldate,
                                   @RequestParam(value = "operator",required = false) String operator,
                                   @RequestParam(value = "isActive",required = false) Integer isActive,
                                   @RequestParam(value = "account",required = false) String account,
                                   @RequestParam(value = "spare",required = false) String spare,
                                   @RequestParam(value = "flag", defaultValue = "1", required = false) int flag,
                                   Model model,
                                   HttpSession httpSession){
        if(pbid==""){
            pbid=null;
        }
        if(billcode==""){
            billcode=null;
        }
        PageInfo<Purchasebill> pageInfo = null;
        if(flag==1){
            pageInfo = payCenterService.getPurchasebill(pageSize,page,pbid, billcode, lessMoney, greaterMoney,
                    lessBilldate, greaterBilldate, operator, isActive, account, spare);
            httpSession.setAttribute("pbid",pbid);
            httpSession.setAttribute("billcode",billcode);
            httpSession.setAttribute("lessMoney",lessMoney);
            httpSession.setAttribute("greaterMoney",greaterMoney);
            httpSession.setAttribute("lessBilldate",lessBilldate);
            httpSession.setAttribute("greaterBilldate",greaterBilldate);
            httpSession.setAttribute("isActive",isActive);
        }else{
            pbid=(String) httpSession.getAttribute("pbid");
            billcode=(String)httpSession.getAttribute("billcode");
            lessMoney=(Double)httpSession.getAttribute("lessMoney");
            greaterMoney=(Double)httpSession.getAttribute("greaterMoney");
            lessBilldate=(String)httpSession.getAttribute("lessBilldate");
            greaterBilldate=(String)httpSession.getAttribute("greaterBilldate");
            isActive=(Integer)httpSession.getAttribute("isActive");
            pageInfo = payCenterService.getPurchasebill(pageSize,page,pbid, billcode, lessMoney, greaterMoney,
                    lessBilldate, greaterBilldate, operator, isActive, account, spare);
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
        model.addAttribute("purchasebills", pageInfo.getList());
        return "pay/purchase-bill-list";
    }

    @DeleteMapping("purchasebill/{pbid}")
    public String lockpb(@PathVariable("pbid") String pbid, @RequestParam("nowState") Integer nowState){
        System.out.println(pbid);
        if (nowState > 0) {
            boolean b = payCenterService.deletePurchasebill(pbid);
        }else {
            boolean b = payCenterService.abPb(pbid);
        }
        return "pay/purchase-bill-list";
    }

    @PostMapping("purchasebill")
    @ResponseBody
    public String addpb(@RequestParam("trade_no") String trade_no,
                        @RequestParam("out_trade_no") String out_trade_no,
                        @RequestParam("money") Double money,
                        @RequestParam("operator") String operator){
        boolean b = payCenterService.addPurchasebill(trade_no, out_trade_no, money, operator);
        return "添加成功";
    }

    @DeleteMapping("salebill/{sbid}")
    public String locksb(@PathVariable("sbid") String sbid, @RequestParam("nowState") Integer nowState){
        if (nowState > 0) {
            boolean b = payCenterService.deleteSalebill(sbid);
        }else {
            boolean b = payCenterService.abSb(sbid);
        }
        return "pay/sale-bill-list";
    }

    @PostMapping("salebill")
    @ResponseBody
    public String addsb(@RequestParam("trade_no") String trade_no,
                        @RequestParam("out_trade_no") String out_trade_no,
                        @RequestParam("money") Double money,
                        @RequestParam("operator") String operator){
        boolean b = payCenterService.addSalebill(trade_no, out_trade_no, money, operator);
        return "添加成功";
    }

    @GetMapping("salebill")
    public String getSalebills(@RequestParam(value = "pageSize",defaultValue = "6",required = false) int pageSize,
                               @RequestParam(value = "page",defaultValue = "1",required = false) int page,
                               @RequestParam(value = "sbid",required = false) String sbid,
                               @RequestParam(value = "billcode",required = false) String billcode,
                               @RequestParam(value = "lessMoney",required = false) Double lessMoney,
                               @RequestParam(value = "greaterMoney",required = false) Double greaterMoney,
                               @RequestParam(value = "lessBilldate",required = false) String lessBilldate,
                               @RequestParam(value = "greaterBilldate",required = false) String greaterBilldate,
                               @RequestParam(value = "operator",required = false) String operator,
                               @RequestParam(value = "isActive",required = false) Integer isActive,
                               @RequestParam(value = "account",required = false) String account,
                               @RequestParam(value = "spare",required = false) String spare,
                               @RequestParam(value = "flag", defaultValue = "1", required = false) int flag,
                               Model model,
                               HttpSession httpSession){
        if(sbid==""){
            sbid=null;
        }
        if(billcode==""){
            billcode=null;
        }
        PageInfo<Salebill> pageInfo = null;
        if(flag==1){
            pageInfo=payCenterService.getSalebill(pageSize,page,sbid, billcode, lessMoney, greaterMoney, lessBilldate,
                    greaterBilldate, operator, isActive, account, spare);
            httpSession.setAttribute("sbid",sbid);
            httpSession.setAttribute("billcode",billcode);
            httpSession.setAttribute("lessMoney",lessMoney);
            httpSession.setAttribute("greaterMoney",greaterMoney);
            httpSession.setAttribute("lessBilldate",lessBilldate);
            httpSession.setAttribute("greaterBilldate",greaterBilldate);
            httpSession.setAttribute("isActive",isActive);
        }else{
            sbid=(String) httpSession.getAttribute("sbid");
            billcode=(String)httpSession.getAttribute("billcode");
            lessMoney=(Double)httpSession.getAttribute("lessMoney");
            greaterMoney=(Double)httpSession.getAttribute("greaterMoney");
            lessBilldate=(String)httpSession.getAttribute("lessBilldate");
            greaterBilldate=(String)httpSession.getAttribute("greaterBilldate");
            isActive=(Integer)httpSession.getAttribute("isActive");
            pageInfo=payCenterService.getSalebill(pageSize,page,sbid, billcode, lessMoney, greaterMoney, lessBilldate,
                    greaterBilldate, operator, isActive, account, spare);
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
        model.addAttribute("salebills", pageInfo.getList());
        return "pay/sale-bill-list";
    }

    @GetMapping("addPbPage")
    public String addPbPage(){
        return "pay/purchase-bill-add";
    }
}
