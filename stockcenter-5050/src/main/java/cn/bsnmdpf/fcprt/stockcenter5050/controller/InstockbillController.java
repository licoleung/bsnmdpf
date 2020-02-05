package cn.bsnmdpf.fcprt.stockcenter5050.controller;

import cn.bsnmdpf.fcprt.api.pojo.Instockbill;
import cn.bsnmdpf.fcprt.api.pojo.Warehouse;
import cn.bsnmdpf.fcprt.stockcenter5050.service.InstockbillService;
import cn.bsnmdpf.fcprt.stockcenter5050.service.WarehouseService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author LicoLeung
 * @create 2020-02-05 12:22
 */
@RestController
public class InstockbillController {

    @Autowired
    private InstockbillService instockbillService;

    @Autowired
    private WarehouseService warehouseService;

    /**
     * 根据条件查询入库单
     *
     * @param pageSize           一页展示的数量
     * @param page               页码
     * @param inid               主键
     * @param inbillcode         单据号
     * @param whid               仓位id
     * @param mid                物料id
     * @param mname              物料名称
     * @param lessInTime         最大入库时间
     * @param greaterInTime      最小入库时间
     * @param inType             入库类型
     * @param poid               订单id
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
     * @return 入库单列表
     */
    @GetMapping("instockbill")
    public PageInfo<Instockbill> getInstockbills(@RequestParam(value = "pageSize") int pageSize,
                                                 @RequestParam(value = "page") int page,
                                                 @RequestParam(value = "inid", required = false) Integer inid,
                                                 @RequestParam(value = "inbillcode", required = false) String inbillcode,
                                                 @RequestParam(value = "whid", required = false) Integer whid,
                                                 @RequestParam(value = "mid", required = false) Integer mid,
                                                 @RequestParam(value = "mname", required = false) String mname,
                                                 @RequestParam(value = "lessInTime", required = false) Date lessInTime,
                                                 @RequestParam(value = "greaterInTime", required = false) Date greaterInTime,
                                                 @RequestParam(value = "inType", required = false) String inType,
                                                 @RequestParam(value = "poid", required = false) Integer poid,
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
        List<Instockbill> instockbills = instockbillService.getInstockbills(inid, inbillcode, whid, mid, mname, lessInTime,
                greaterInTime, inType, poid, creator, lessCreateTime, greaterCreateTime, modifier, lessModifyTime,
                greaterModifiyTime, isActive, nnum, volumn, weight);
        PageInfo<Instockbill> pageInfo = new PageInfo<>(instockbills);
        return pageInfo;
    }

    /**
     * 添加入库单
     *
     * @param inid       主键
     * @param inbillcode 单据号
     * @param whid       仓位id
     * @param mid        物料id
     * @param mname      物料名称
     * @param inTime     入库时间
     * @param inType     入库类型
     * @param poid       订单号，非必填
     * @param creator    创建者
     * @param isActive   是否启用
     * @param nnum       数量
     * @param volumn     体积
     * @param weight     重量
     * @return 成功返回true，失败返回false
     */
    @PostMapping("instockbill")
    public boolean addInstockbill(@RequestParam(value = "inid", required = false) Integer inid,
                                  @RequestParam(value = "inbillcode") String inbillcode,
                                  @RequestParam(value = "whid") Integer whid,
                                  @RequestParam(value = "mid") Integer mid,
                                  @RequestParam(value = "mname") String mname,
                                  @RequestParam(value = "inTime") Date inTime,
                                  @RequestParam(value = "inType") String inType,
                                  @RequestParam(value = "poid", required = false) Integer poid,
                                  @RequestParam(value = "creator") String creator,
                                  @RequestParam(value = "isActive", required = false) Integer isActive,
                                  @RequestParam(value = "nnum") Integer nnum,
                                  @RequestParam(value = "volumn") Double volumn,
                                  @RequestParam(value = "weight") Double weight) {
        Instockbill instockbill = new Instockbill();
        if (inid != null) {
            instockbill.setInid(inid);
        }
        instockbill.setInbillcode(inbillcode);
        instockbill.setWhid(whid);
        instockbill.setMid(mid);
        instockbill.setMname(mname);
        instockbill.setIntime(inTime);
        instockbill.setIntype(inType);
        if (poid != null) {
            instockbill.setPoid(poid);
        }
        instockbill.setCreator(creator);
        instockbill.setNnum(nnum);
        instockbill.setVolumn(volumn);
        instockbill.setWeight(weight);
        if (isActive != null) {
            instockbill.setIsactive(isActive);
        } else {
            instockbill.setIsactive(1);
        }
        instockbill.setCreatetime(new Date());
//        Warehouse warehouse = new Warehouse();
//        warehouse.setWhid(whid);
//        warehouseService.updateWarehouse()

        boolean b = instockbillService.addInstockbill(instockbill);
        return b;
    }

    /**
     * 根据主键或者单据号删除/封锁入库单
     * 主键和单据号必须存在一个，否则在service会报错
     *
     * @param inid       主键
     * @param inbillcode 单据号
     * @return 返回删除条数
     */
    @DeleteMapping("instockbill")
    public int deleteInstockbill(@RequestParam(value = "inid", required = false) Integer inid,
                                 @RequestParam(value = "inbillcode", required = false) String inbillcode) {
        return instockbillService.unableInstockbill(inid, inbillcode);
    }

    /**
     * 根据主键或者单据号恢复/解封入库单
     * 主键和单据号必须存在一个，否则在service会报错
     *
     * @param inid       主键
     * @param inbillcode 单据号
     * @return 返回恢复条数
     */
    @GetMapping("ableinstockbill")
    public int ableInstockbill(@RequestParam(value = "inid", required = false) Integer inid,
                               @RequestParam(value = "inbillcode", required = false) String inbillcode) {
        return instockbillService.ableInstockbill(inid, inbillcode);
    }

    /**
     * 更新入库单，有参则更，无参则不变
     *
     * @param inid       主键
     * @param inbillcode 单据号
     * @param whid       仓位id
     * @param mid        物料id
     * @param mname      物料名称
     * @param inTime     入库时间
     * @param inType     入库类型
     * @param poid       订单号，非必填
     * @param modifier   修改者
     * @param isActive   是否启用
     * @param nnum       数量
     * @param volumn     体积
     * @param weight     重量
     * @return 成功返回true，失败返回false
     */
    @PutMapping("instockbill/{inid}")
    public boolean updateInstockbill(@PathVariable(value = "inid") Integer inid,
                                     @RequestParam(value = "inbillcode", required = false) String inbillcode,
                                     @RequestParam(value = "whid", required = false) Integer whid,
                                     @RequestParam(value = "mid", required = false) Integer mid,
                                     @RequestParam(value = "mname", required = false) String mname,
                                     @RequestParam(value = "inTime", required = false) Date inTime,
                                     @RequestParam(value = "inType", required = false) String inType,
                                     @RequestParam(value = "poid", required = false) Integer poid,
                                     @RequestParam(value = "modifier") String modifier,
                                     @RequestParam(value = "isActive", required = false) Integer isActive,
                                     @RequestParam(value = "nnum", required = false) Integer nnum,
                                     @RequestParam(value = "volumn", required = false) Double volumn,
                                     @RequestParam(value = "weight", required = false) Double weight) {
        Instockbill instockbill = new Instockbill();
        if (inid != null) {
            instockbill.setInid(inid);
        }
        if (inbillcode != null)
            instockbill.setInbillcode(inbillcode);
        if (whid != null)
            instockbill.setWhid(whid);
        if (mid != null)
            instockbill.setMid(mid);
        if (mname != null)
            instockbill.setMname(mname);
        if (inTime != null)
            instockbill.setIntime(inTime);
        if (inType != null)
            instockbill.setIntype(inType);
        if (poid != null) {
            instockbill.setPoid(poid);
        }
        instockbill.setCreator(modifier);
        if (nnum != null)
            instockbill.setNnum(nnum);
        if (volumn != null)
            instockbill.setVolumn(volumn);
        if (weight != null)
            instockbill.setWeight(weight);
        if (isActive != null)
            instockbill.setIsactive(isActive);
        boolean b = instockbillService.updateInstockbill(instockbill);
        return b;
    }
}
