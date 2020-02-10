package cn.bsnmdpf.fcprt.api.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
/**
 * @author LicoLeung
 * @create 2020-02-10 13:01
 */
@FeignClient(value = "paycenter-5070")
public interface PayCenterService {

    @PostMapping("addSalebill")
    public boolean addSalebill(@RequestParam("trade_no") String trade_no,
                               @RequestParam("out_trade_no") String out_trade_no,
                               @RequestParam("money") Double money,
                               @RequestParam("operator") String operator);

}
