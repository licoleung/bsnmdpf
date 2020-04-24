package cn.bsnmdpf.fcprt.vipshop9002.controller;

import cn.bsnmdpf.fcprt.api.service.PayCenterService;
import cn.bsnmdpf.fcprt.vipshop9002.config.AlipayConfig;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author LicoLeung
 * @create 2020-02-09 18:30
 */
@RestController
public class AliPayController {

    @Autowired
    private PayCenterService payCenterService;

    @RequestMapping("pay")
    public String alipayOperation(@RequestParam("WIDout_trade_no") String WIDout_trade_no, @RequestParam("WIDtotal_amount") String WIDtotal_amount, @RequestParam("WIDsubject") String WIDsubject, @RequestParam("WIDbody") String WIDbody) throws AlipayApiException {
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);

        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);

        //商户订单号，商户网站订单系统中唯一订单号，必填
        String out_trade_no = WIDout_trade_no;
        //付款金额，必填
        String total_amount = WIDtotal_amount;
        //订单名称，必填
        String subject = WIDsubject;
        //商品描述，可空
        String body = WIDbody;

        alipayRequest.setBizContent("{\"out_trade_no\":\"" + out_trade_no + "\","
                + "\"total_amount\":\"" + total_amount + "\","
                + "\"subject\":\"" + subject + "\","
                + "\"body\":\"" + body + "\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

        //请求
        String result = alipayClient.pageExecute(alipayRequest).getBody();

        return result;
    }

    @RequestMapping("notify_url")
    public String notify_url(HttpServletRequest request) {
        String out_trade_no = request.getParameter("out_trade_no");
        String trade_no = request.getParameter("trade_no");
        String total_amount = request.getParameter("total_amount");
        Double money = Double.parseDouble(total_amount);
        System.out.println("out:  "+out_trade_no);
        System.out.println("tra   "+trade_no);
        System.out.println("money  "+money);
        boolean b = payCenterService.addSalebill(trade_no,out_trade_no,money,null);
        return "index";
    }

    @RequestMapping("return_url")
    public String return_url(HttpServletRequest request) {
        String out_trade_no = request.getParameter("out_trade_no");
        String trade_no = request.getParameter("trade_no");
        String total_amount = request.getParameter("total_amount");
        Double money = Double.parseDouble(total_amount);
        System.out.println("out:  "+out_trade_no);
        System.out.println("tra   "+trade_no);
        System.out.println("money  "+money);
        boolean b = payCenterService.addSalebill(trade_no,out_trade_no,money,"me");
        if(b){
            return "index";
        }else{
            return "login";
        }
    }

}
