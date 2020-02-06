package cn.bsnmdpf.fcprt.stockcenter5050.controller;

import cn.bsnmdpf.fcprt.api.pojo.Stock;
import cn.bsnmdpf.fcprt.api.pojo.Warehouse;
import cn.bsnmdpf.fcprt.stockcenter5050.service.StockService;
import cn.bsnmdpf.fcprt.stockcenter5050.service.WarehouseService;
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
 * @create 2020-02-04 17:00
 */
@RestController
public class StockController {

    @Autowired
    private StockService stockService;

    @Autowired
    private WarehouseService warehouseService;

    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request) {
        //转换日期 注意这里的转化要和传进来的字符串的格式一直 如2015-9-9 就应该为yyyy-MM-dd
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));// CustomDateEditor为自定义日期编辑器
    }
    /**
     * 根据条件查询仓库列表,并且注入仓位信息
     *
     * @param sid                仓库编码
     * @param stockname          仓库名称
     * @param lessVolumn         最大容量
     * @param greaterVolumn      最小容量
     * @param lessUsedVolumn     最大已使用容量
     * @param greaterUsedVolumn  最小已使用容量
     * @param address            地址
     * @param lessWhnum          最大仓位数量
     * @param greaterWhnum       最小仓位数量
     * @param creator            添加者
     * @param lessCreateTime     最大添加时间
     * @param greaterCreateTime  最小添加时间
     * @param modifier           修改者
     * @param lessModifyTime     最大修改时间
     * @param greaterModifiyTime 最小修改时间
     * @param isActive           是否启用
     * @return 符合条件的仓库列表
     */
    @GetMapping("stock")
    public PageInfo<Stock> getStocks(@RequestParam(value = "pageSize") int pageSize,
                                     @RequestParam(value = "page") int page,
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
                                     @RequestParam(value = "lessCreateTime", required = false) Date lessCreateTime,
                                     @RequestParam(value = "greaterCreateTime", required = false) Date greaterCreateTime,
                                     @RequestParam(value = "modifier", required = false) String modifier,
                                     @RequestParam(value = "lessModifyTime", required = false) Date lessModifyTime,
                                     @RequestParam(value = "greaterModifyTime", required = false) Date greaterModifiyTime,
                                     @RequestParam(value = "isActive", required = false) Integer isActive) {
        PageHelper.startPage(page, pageSize);
        List<Stock> stockList = stockService.getStockList(sid, stockname, lessVolumn, greaterVolumn, lessUsedVolumn, greaterUsedVolumn, address, lessWhnum, greaterWhnum, creator, lessCreateTime, greaterCreateTime, modifier, lessModifyTime, greaterModifiyTime, isActive);
        for (Stock stock : stockList) {
            List<Warehouse> warehouses = warehouseService.selectWarehouseOnlyBySid(stock.getSid());
            stock.setWarehouses(warehouses);
        }
        PageInfo<Stock> pageInfo = new PageInfo<>(stockList);
        return pageInfo;
    }

    /**
     * 添加仓库
     *
     * @param sid        编码
     * @param stockname  名称
     * @param volumn     容量
     * @param usedVolumn 已使用容量，默认0.0
     * @param address    地址
     * @param whnum      仓位数量
     * @param creator    创建者
     * @param isActive   是否启用，默认1（启用）
     * @return
     */
    @PostMapping("stock")
    public boolean addStock(@RequestParam(value = "sid", required = false) Integer sid,
                            @RequestParam(value = "stockname") String stockname,
                            @RequestParam(value = "volumn") Double volumn,
                            @RequestParam(value = "uedVolumn", required = false) Double usedVolumn,
                            @RequestParam(value = "address") String address,
                            @RequestParam(value = "whnum") Integer whnum,
                            @RequestParam(value = "creator") String creator,
                            @RequestParam(value = "isActive", required = false) Integer isActive) {
        Stock stock = new Stock();
        if (sid != null) {
            stock.setSid(sid);
        }
        stock.setStockname(stockname);
        stock.setVolumn(volumn);
        if (usedVolumn != null) {
            stock.setUsedvolumn(usedVolumn);
        } else {
            stock.setUsedvolumn(0.0);
        }
        stock.setAddress(address);
        stock.setWhnum(whnum);
        stock.setCreator(creator);
        stock.setCreatetime(new Date());
        if (isActive != null) {
            stock.setIsactive(isActive);
        } else {
            stock.setIsactive(1);
        }
        boolean b = stockService.addStock(stock);
        return b;
    }

    /**
     * 删除/封锁仓库
     * @param sid 编码
     * @return 成功返回true，失败返回false
     */
    @DeleteMapping("stock/{sid}")
    public boolean deleteStock(@PathVariable("sid") Integer sid) {
        return stockService.unableStockBySid(sid);
    }

    /**
     * 恢复/解封仓库
     * @param sid 编码
     * @return 成功返回true，失败返回false
     */
    @GetMapping("ableStock/{sid}")
    public boolean ableStock(@PathVariable("sid") Integer sid) {
        return stockService.ableStockBySid(sid);
    }

    /**
     * 更新仓库，有参则更，无参则不变
     * @param sid 编码
     * @param stockname 仓库名称
     * @param volumn 容量
     * @param usedVolumn 已使用容量
     * @param address 地址
     * @param whnum 仓位数量
     * @param modifier 修改人，必填
     * @param isActive 是否启用
     * @return
     */
    @PutMapping("stock/{sid}")
    public boolean updateStock(@PathVariable("sid") Integer sid,
                               @RequestParam(value = "stockname", required = false) String stockname,
                               @RequestParam(value = "volumn", required = false) Double volumn,
                               @RequestParam(value = "uedVolumn", required = false) Double usedVolumn,
                               @RequestParam(value = "address", required = false) String address,
                               @RequestParam(value = "whnum", required = false) Integer whnum,
                               @RequestParam(value = "modifier") String modifier,
                               @RequestParam(value = "isActive", required = false) Integer isActive) {
        Stock stock = new Stock();
        stock.setSid(sid);
        if (stockname != null) {
            stock.setStockname(stockname);
        }
        if (volumn != null) {
            stock.setVolumn(volumn);
        }
        if (usedVolumn != null) {
            stock.setUsedvolumn(usedVolumn);
        }
        if (address != null) {
            stock.setAddress(address);
        }
        if (whnum != null) {
            stock.setWhnum(whnum);
        }
        stock.setModifier(modifier);
        stock.setModifytime(new Date());
        if (isActive != null) {
            stock.setIsactive(isActive);
        }
        boolean b = stockService.updateStock(stock);
        return b;
    }
}
