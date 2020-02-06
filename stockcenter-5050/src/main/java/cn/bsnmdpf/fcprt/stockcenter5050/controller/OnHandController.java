package cn.bsnmdpf.fcprt.stockcenter5050.controller;

import cn.bsnmdpf.fcprt.api.pojo.OnHand;
import cn.bsnmdpf.fcprt.stockcenter5050.service.OnHandService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author LicoLeung
 * @create 2020-02-05 23:00
 */
@RestController
public class OnHandController {

    @Autowired
    private OnHandService onHandService;

    /**
     * 查询现存量
     *
     * @param pageSize 页面大小
     * @param page 页码
     * @param ohid 主键
     * @param mid 物料id
     * @param mname 物料名称
     * @param whid 仓位id
     * @param whname 仓位名称
     * @param sid 仓库id
     * @param stockname 仓位名称
     * @param lessNnum 最大数量
     * @param greaterNnum 最小数量
     * @param lessVolumn 最大体积
     * @param greaterVolumn 最小体积
     * @param lessWeight 最大重量
     * @param greaterWeight 最小重量
     * @return
     */
    @GetMapping("onhand")
    public PageInfo<OnHand> getOnHand(@RequestParam(value = "pageSize") int pageSize,
                                      @RequestParam(value = "page") int page,
                                      @RequestParam(value = "ohid",required = false) Integer ohid,
                                      @RequestParam(value = "mid",required = false) Integer mid,
                                      @RequestParam(value = "mname",required = false) String mname,
                                      @RequestParam(value = "whid",required = false) Integer whid,
                                      @RequestParam(value = "whname",required = false) String whname,
                                      @RequestParam(value = "sid",required = false) Integer sid,
                                      @RequestParam(value = "stockname",required = false) String stockname,
                                      @RequestParam(value = "lessNnum",required = false) Integer lessNnum,
                                      @RequestParam(value = "greaterNnum",required = false) Integer greaterNnum,
                                      @RequestParam(value = "lessVolumn",required = false) Double lessVolumn,
                                      @RequestParam(value = "greaterVolumn",required = false) Double greaterVolumn,
                                      @RequestParam(value = "lessWeight",required = false) Double lessWeight,
                                      @RequestParam(value = "greaterWeight",required = false) Double greaterWeight){
        PageHelper.startPage(page, pageSize);
        List<OnHand> onHands = onHandService.getOnHands(ohid, mid, mname, whid, whname, sid, stockname, lessNnum, greaterNnum, lessVolumn, greaterVolumn, lessWeight, greaterWeight);
        PageInfo<OnHand> pageInfo = new PageInfo<>(onHands);
        return pageInfo;
    }

    /**
     * 添加现存量信息
     *
     * @param ohid 主键
     * @param mid 物料id
     * @param mname 物料名称
     * @param whid 仓位id
     * @param whname 仓位名称
     * @param sid 仓库id
     * @param stockname 仓位名称
     * @param nnum 数量
     * @param volumn 体积
     * @param weight 重量
     * @return
     */
    @PostMapping("onhand")
    public boolean addOnHand(@RequestParam(value = "ohid",required = false) Integer ohid,
                             @RequestParam(value = "mid") Integer mid,
                             @RequestParam(value = "mname") String mname,
                             @RequestParam(value = "whid") Integer whid,
                             @RequestParam(value = "whname") String whname,
                             @RequestParam(value = "sid") Integer sid,
                             @RequestParam(value = "stockname") String stockname,
                             @RequestParam(value = "nnum") Integer nnum,
                             @RequestParam(value = "volumn") Double volumn,
                             @RequestParam(value = "weight") Double weight){
        OnHand onHand = new OnHand();
        if(ohid!=null){
            onHand.setOhid(ohid);
        }
        onHand.setMid(mid);
        onHand.setMname(mname);
        onHand.setWhid(whid);
        onHand.setWhname(whname);
        onHand.setSid(sid);
        onHand.setStockname(stockname);
        onHand.setNnum(nnum);
        onHand.setVolumn(volumn);
        onHand.setWeight(weight);
        boolean b = onHandService.addOnHand(onHand);
        return b;
    }

    /**
     * 更新现存量信息
     *
     * @param ohid 主键
     * @param mid 物料id
     * @param mname 物料名称
     * @param whid 仓位id
     * @param whname 仓位名称
     * @param sid 仓库id
     * @param stockname 仓位名称
     * @param nnum 数量
     * @param volumn 体积
     * @param weight 重量
     * @return
     */
    @PutMapping("onhand/{ohid}")
    public boolean updateOnHand(@PathVariable(value = "ohid") Integer ohid,
                                @RequestParam(value = "mid",required = false) Integer mid,
                                @RequestParam(value = "mname",required = false) String mname,
                                @RequestParam(value = "whid",required = false) Integer whid,
                                @RequestParam(value = "whname",required = false) String whname,
                                @RequestParam(value = "sid",required = false) Integer sid,
                                @RequestParam(value = "stockname",required = false) String stockname,
                                @RequestParam(value = "nnum",required = false) Integer nnum,
                                @RequestParam(value = "volumn",required = false) Double volumn,
                                @RequestParam(value = "weight",required = false) Double weight){
        OnHand onHand = new OnHand();
        onHand.setOhid(ohid);
        if(mid!=null){
            onHand.setMid(mid);
        }
        if(mname!=null){
            onHand.setMname(mname);
        }
        if(whid!=null){
            onHand.setWhid(whid);
        }
        if(whname!=null){
            onHand.setWhname(whname);
        }
        if(sid!=null){
            onHand.setSid(sid);
        }
        if(stockname!=null){
            onHand.setStockname(stockname);
        }
        if(nnum!=null){
            onHand.setNnum(nnum);
        }
        if(volumn!=null){
            onHand.setVolumn(volumn);
        }
        if(weight!=null){
            onHand.setWeight(weight);
        }
        boolean update = onHandService.update(onHand);
        return update;
    }
}
