package cn.bsnmdpf.fcprt.stockcenter5050.service;

import cn.bsnmdpf.fcprt.api.pojo.Stock;
import cn.bsnmdpf.fcprt.stockcenter5050.mapper.StockMapper;
import cn.bsnmdpf.fcprt.api.pojo.Stock;
import cn.bsnmdpf.fcprt.api.pojo.StockExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LicoLeung
 * @create 2020-01-27 13:13
 */
@Service
public class StockBaseService {

    @Autowired
    private StockMapper stockMapper;

    /**
     *
     * @return 仓库列表
     */
    public List<Stock> getStockList(){
        StockExample stockExample = new StockExample();
        List<Stock> stockList = stockMapper.selectByExample(stockExample);
        return stockList;
    }
}
