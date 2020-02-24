package cn.bsnmdpf.fcprt.api.service;

import cn.bsnmdpf.fcprt.api.pojo.Purchasebill;
import cn.bsnmdpf.fcprt.api.pojo.Salebill;
import com.github.pagehelper.PageInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;


/**
 * @author LicoLeung
 * @create 2020-02-10 13:01
 */
@FeignClient(value = "paycenter-5070")
public interface PayCenterService {

    //SalebillController

    @PostMapping("salebill")
    public boolean addSalebill(@RequestParam("trade_no") String trade_no,
                               @RequestParam("out_trade_no") String out_trade_no,
                               @RequestParam("money") Double money,
                               @RequestParam("operator") String operator);
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
                                          @RequestParam(value = "lessBilldate",required = false) String lessBilldate,
                                          @RequestParam(value = "greaterBilldate",required = false) String greaterBilldate,
                                          @RequestParam(value = "operator",required = false) String operator,
                                          @RequestParam(value = "isActive",required = false) Integer isActive,
                                          @RequestParam(value = "account",required = false) String account,
                                          @RequestParam(value = "spare",required = false) String spare);

    /**
     * 删除/封锁销售单据
     *
     * @param sbid 交易号
     * @return 成功返回true，失败返回false
     */
    @DeleteMapping("salebill/{sbid}")
    public boolean deleteSalebill(@PathVariable("sbid") String sbid);

    //PurchasebillController

    /**
     * 添加购买单据
     *
     * @param trade_no     交易号
     * @param out_trade_no 订单号
     * @param money        金额
     * @param operator     操作人
     * @return 成功返回true，失败返回false
     */
    @PostMapping("purchasebill")
    public boolean addPurchasebill(@RequestParam("trade_no") String trade_no,
                                   @RequestParam("out_trade_no") String out_trade_no,
                                   @RequestParam("money") Double money,
                                   @RequestParam("operator") String operator);


    /**
     * 查询购买单据
     *
     * @param pageSize        页面大小
     * @param page            页码
     * @param pbid            交易号
     * @param billcode        订单号
     * @param lessMoney       最大金额
     * @param greaterMoney    最小金额
     * @param lessBilldate    最大单据日期
     * @param greaterBilldate 最小单据日期
     * @param operator        操作人
     * @param isActive        是否启用
     * @param account         账号
     * @param spare           备用
     * @return 符合条件得购买单据列表
     */
    @GetMapping("purchasebill")
    public PageInfo<Purchasebill> getPurchasebill(@RequestParam(value = "pageSize") int pageSize,
                                                  @RequestParam(value = "page") int page,
                                                  @RequestParam(value = "pbid",required = false) String pbid,
                                                  @RequestParam(value = "billcode",required = false) String billcode,
                                                  @RequestParam(value = "lessMoney",required = false) Double lessMoney,
                                                  @RequestParam(value = "greaterMoney",required = false) Double greaterMoney,
                                                  @RequestParam(value = "lessBilldate",required = false) String lessBilldate,
                                                  @RequestParam(value = "greaterBilldate",required = false) String greaterBilldate,
                                                  @RequestParam(value = "operator",required = false) String operator,
                                                  @RequestParam(value = "isActive",required = false) Integer isActive,
                                                  @RequestParam(value = "account",required = false) String account,
                                                  @RequestParam(value = "spare",required = false) String spare);

    /**
     * 删除/封锁购买单据
     *
     * @param pbid 交易号
     * @return 成功返回true，失败返回false
     */
    @DeleteMapping("purchasebill/{pbid}")
    public boolean deletePurchasebill(@PathVariable("pbid") String pbid);


    @GetMapping("ablepb/{pbid}")
    public boolean abPb(@PathVariable("pbid") String pbid);


    @GetMapping("ablesb/{sbid}")
    public boolean abSb(@PathVariable("sbid") String sbid);

}
