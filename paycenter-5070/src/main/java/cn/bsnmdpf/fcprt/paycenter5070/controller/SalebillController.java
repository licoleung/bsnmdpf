package cn.bsnmdpf.fcprt.paycenter5070.controller;

import cn.bsnmdpf.fcprt.paycenter5070.service.SalebillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author LicoLeung
 * @create 2020-02-10 13:40
 */
@RestController
public class SalebillController {

    @Autowired
    private SalebillService salebillService;

    @PostMapping("addSalebill")
    public boolean addSalebill(@RequestParam("trade_no") String trade_no,
                               @RequestParam("out_trade_no") String out_trade_no,
                               @RequestParam("money") Double money,
                               @RequestParam("operator") String operator){
        boolean b = salebillService.addSalebill(trade_no, out_trade_no, money, operator);
        return b;
    }
}
