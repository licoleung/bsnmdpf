package cn.bsnmdpf.fcprt.stockcenter5050.controller;

import cn.bsnmdpf.fcprt.api.pojo.OnHand;
import cn.bsnmdpf.fcprt.api.pojo.Outstockbill;
import cn.bsnmdpf.fcprt.api.pojo.Stock;
import cn.bsnmdpf.fcprt.api.pojo.Warehouse;
import cn.bsnmdpf.fcprt.stockcenter5050.service.OnHandService;
import cn.bsnmdpf.fcprt.stockcenter5050.service.OutstockbillService;
import cn.bsnmdpf.fcprt.stockcenter5050.service.StockService;
import cn.bsnmdpf.fcprt.stockcenter5050.service.WarehouseService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author LicoLeung
 * @create 2020-02-05 12:22
 */
@RestController
public class OutstockbillController {

    @Autowired
    private OutstockbillService outstockbillService;

    @Autowired
    private WarehouseService warehouseService;

    @Autowired
    private OnHandService onHandService;

    @Autowired
    private StockService stockService;

    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request) {
        //转换日期 注意这里的转化要和传进来的字符串的格式一直 如2015-9-9 就应该为yyyy-MM-dd
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));// CustomDateEditor为自定义日期编辑器
    }

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
                                                   @RequestParam(value = "weight", required = false) Double weight) {
        PageHelper.startPage(page, pageSize);
        List<Outstockbill> outstockbills = outstockbillService.getOutstockbills(outid, outbillcode, whid, mid, mname, lessOutTime,
                greaterOutTime, outType, soid, creator, lessCreateTime, greaterCreateTime, modifier, lessModifyTime,
                greaterModifiyTime, isActive, nnum, volumn, weight);
        PageInfo<Outstockbill> pageInfo = new PageInfo<>(outstockbills);
        return pageInfo;
    }

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
    @Transactional
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
                                   @RequestParam(value = "weight") Double weight) {
        Outstockbill outstockbill = new Outstockbill();
        if (outid != null) {
            outstockbill.setOutid(outid);
        }
        outstockbill.setOutbillcode(outbillcode);
        outstockbill.setWhid(whid);
        outstockbill.setMid(mid);
        outstockbill.setMname(mname);
        outstockbill.setOuttime(outTime);
        outstockbill.setOuttype(outType);
        if (soid != null) {
            outstockbill.setSoid(soid);
        }
        outstockbill.setCreator(creator);
        outstockbill.setNnum(nnum);
        outstockbill.setVolumn(volumn);
        outstockbill.setWeight(weight);
        if (isActive != null) {
            outstockbill.setIsactive(isActive);
        } else {
            outstockbill.setIsactive(1);
        }
        outstockbill.setCreatetime(new Date());

        //根据仓位id获取仓库id
        Warehouse wHbyWhid = warehouseService.getWHbyWhid(whid);
        Integer sid = wHbyWhid.getSid();

        //根据mid，whid，sid获取原现存量信息
        List<OnHand> onHands = onHandService.getOnHands(null, mid, null, whid, null, sid, null, null, null, null, null, null, null);
        boolean update = false;
        //if存在现存量信息则更新信息,else不存在现存量则报错
        if(onHands!=null){
            OnHand onHand = onHands.get(0);
            Integer relnnum = onHand.getNnum() - nnum;
            Double relvolumn = onHand.getVolumn() - volumn;
            Double relweight = onHand.getWeight() - weight;
            if(relnnum<0||relvolumn<0||relweight<0)
                return false;
            OnHand newOnHand = new OnHand();
            newOnHand.setOhid(onHand.getOhid());
            newOnHand.setNnum(relnnum);
            newOnHand.setWeight(relweight);
            newOnHand.setVolumn(relvolumn);
            //更新仓位信息
            boolean b1 = warehouseService.decreaseVolumn(whid, volumn);

            //更新仓库信息
            boolean b2 = stockService.decreaseVolumn(sid, volumn);

            boolean b = outstockbillService.addOutstockbill(outstockbill);

            update = onHandService.update(newOnHand);

            return b&update&b1&b2;
        }else{
            throw new RuntimeException("无对应现存量信息");
        }


    }

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
                                  @RequestParam(value = "outbillcode", required = false) String outbillcode) {
        return outstockbillService.unableOutstockbill(outid, outbillcode);
    }

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
                                @RequestParam(value = "outbillcode", required = false) String outbillcode) {
        return outstockbillService.ableOutstockbill(outid, outbillcode);
    }

    /**
     * 更新出库单，有参则更，无参则不变
     *
     * @param outid       主键
     * @param outbillcode 单据号
     * @param whid        仓位id
     * @param mid         物料id
     * @param mname       物料名称
     * @param outTime     出库时间
     * @param outType     出库类型
     * @param soid        订单号，非必填
     * @param modifier    修改者
     * @param isActive    是否启用
     * @param nnum        数量
     * @param volumn      体积
     * @param weight      重量
     * @return 成功返回true，失败返回false
     */
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
                                      @RequestParam(value = "weight", required = false) Double weight) {
        Outstockbill outstockbill = new Outstockbill();
        if (outid != null) {
            outstockbill.setOutid(outid);
        }
        if (outbillcode != null)
            outstockbill.setOutbillcode(outbillcode);
        if (whid != null)
            outstockbill.setWhid(whid);
        if (mid != null)
            outstockbill.setMid(mid);
        if (mname != null)
            outstockbill.setMname(mname);
        if (outTime != null)
            outstockbill.setOuttime(outTime);
        if (outType != null)
            outstockbill.setOuttype(outType);
        if (soid != null) {
            outstockbill.setSoid(soid);
        }
        outstockbill.setCreator(modifier);
        if (nnum != null)
            outstockbill.setNnum(nnum);
        if (volumn != null)
            outstockbill.setVolumn(volumn);
        if (weight != null)
            outstockbill.setWeight(weight);
        if (isActive != null)
            outstockbill.setIsactive(isActive);
        boolean b = outstockbillService.updateOutstockbill(outstockbill);
        return b;
    }
}
