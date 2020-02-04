package cn.bsnmdpf.fcprt.stockcenter5050.controller;

import cn.bsnmdpf.fcprt.stockcenter5050.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author LicoLeung
 * @create 2020-02-04 17:00
 */
@Controller
public class StockController {

    @Autowired
    private StockService stockService;

}
