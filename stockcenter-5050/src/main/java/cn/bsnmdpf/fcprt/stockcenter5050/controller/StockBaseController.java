package cn.bsnmdpf.fcprt.stockcenter5050.controller;

import cn.bsnmdpf.fcprt.api.pojo.Stock;
import cn.bsnmdpf.fcprt.stockcenter5050.service.StockBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author LicoLeung
 * @create 2020-01-27 13:20
 */
@Controller
public class StockBaseController {

    @Autowired
    private StockBaseService stockBaseService;

    @GetMapping("stocks")
    @ResponseBody
    public List<Stock> getStockList(){
        List<Stock> stockList = stockBaseService.getStockList();
        return stockList;
    }
}
