package cn.bsnmdpf.fcprt.paycenter5070.service;

import cn.bsnmdpf.fcprt.api.pojo.Salebill;
import cn.bsnmdpf.fcprt.paycenter5070.mapper.SalebillMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author LicoLeung
 * @create 2020-02-10 12:29
 */
@Service
public class SalebillService {

    @Autowired
    private SalebillMapper salebillMapper;

    @Transactional
    public boolean addSalebill(String trade_no,String out_trade_no,Double money,String operator) throws RuntimeException{
        Salebill salebill = new Salebill();
        salebill.setSbid(trade_no);
        salebill.setBillcode(out_trade_no);
        salebill.setBilldate(new Date());
        salebill.setMoney(money);
        salebill.setOperator(operator);
        salebill.setIsactive(1);
        int insert = salebillMapper.insert(salebill);
        if(insert==1){
            return true;
        }else{
            throw new RuntimeException("添加失败，原因不明");
        }
    }
}
