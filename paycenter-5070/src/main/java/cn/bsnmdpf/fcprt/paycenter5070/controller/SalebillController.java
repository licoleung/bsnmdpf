package cn.bsnmdpf.fcprt.paycenter5070.controller;

import cn.bsnmdpf.fcprt.api.pojo.Salebill;
import cn.bsnmdpf.fcprt.paycenter5070.service.SalebillService;
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
 * @create 2020-02-10 13:40
 */
@RestController
public class SalebillController {

    @Autowired
    private SalebillService salebillService;

    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request) {
        //转换日期 注意这里的转化要和传进来的字符串的格式一直 如2015-9-9 就应该为yyyy-MM-dd
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));// CustomDateEditor为自定义日期编辑器
    }

    /**
     * 添加销售单据
     *
     * @param trade_no     交易号
     * @param out_trade_no 订单号
     * @param money        金额
     * @param operator     操作人
     * @return 成功返回true，失败返回false
     */
    @PostMapping("salebill")
    public boolean addSalebill(@RequestParam("trade_no") String trade_no,
                               @RequestParam("out_trade_no") String out_trade_no,
                               @RequestParam("money") Double money,
                               @RequestParam("operator") String operator) {
        boolean b = salebillService.addSalebill(trade_no, out_trade_no, money, operator);
        return b;
    }

    /**
     * 查询销售单据
     *
     * @param pageSize        页面大小
     * @param page            页码
     * @param sbid            交易号
     * @param billcode        订单号
     * @param lessMoney       最大金额
     * @param greaterMoney    最小金额
     * @param lessBilldate    最大单据日期
     * @param greaterBilldate 最小单据日期
     * @param operator        操作人
     * @param isActive        是否启用
     * @param account         账号
     * @param spare           备用
     * @return 符合条件得销售单据列表
     */
    @GetMapping("salebill")
    public PageInfo<Salebill> getSalebill(@RequestParam(value = "pageSize") int pageSize,
                                          @RequestParam(value = "page") int page,
                                          @RequestParam(value = "sbid",required = false) String sbid,
                                          @RequestParam(value = "billcode",required = false) String billcode,
                                          @RequestParam(value = "lessMoney",required = false) Double lessMoney,
                                          @RequestParam(value = "greaterMoney",required = false) Double greaterMoney,
                                          @RequestParam(value = "lessBilldate",required = false) Date lessBilldate,
                                          @RequestParam(value = "greaterBilldate",required = false) Date greaterBilldate,
                                          @RequestParam(value = "operator",required = false) String operator,
                                          @RequestParam(value = "isActive",required = false) Integer isActive,
                                          @RequestParam(value = "account",required = false) String account,
                                          @RequestParam(value = "spare",required = false) String spare) {
        PageHelper.startPage(page, pageSize);
        List<Salebill> salebills = salebillService.getSalebills(sbid, billcode, lessMoney, greaterMoney, lessBilldate, greaterBilldate,
                operator, isActive, account, spare);
        PageInfo<Salebill> pageInfo = new PageInfo<>(salebills);
        return pageInfo;
    }

    /**
     * 删除/封锁销售单据
     *
     * @param sbid 交易号
     * @return 成功返回true，失败返回false
     */
    @DeleteMapping("salebill/{sbid}")
    public boolean deleteSalebill(@PathVariable("sbid") String sbid) {
        boolean b = salebillService.unableSalebills(sbid);
        return b;
    }


    @GetMapping("ablesb/{sbid}")
    public boolean abSb(@PathVariable("sbid") String sbid){
        boolean b = salebillService.ableSalebills(sbid);
        return b;
    }
}
