package cn.bsnmdpf.fcprt.stockcenter5050.controller;

import cn.bsnmdpf.fcprt.api.pojo.Instockbill;
import cn.bsnmdpf.fcprt.stockcenter5050.service.InstockbillService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

/**
 * @author LicoLeung
 * @create 2020-02-05 12:22
 */
@Controller
public class InstockbillController {

    @Autowired
    private InstockbillService instockbillService;

    public PageInfo<Instockbill> getInstockbills(@RequestParam(value = "pageSize") int pageSize,
                                                 @RequestParam(value = "page") int page,
                                                 @RequestParam(value = "inid",required = false) Integer inid,
                                                 @RequestParam(value = "inbillcode",required = false) String inbillcode,
                                                 @RequestParam(value = "whid",required = false) Integer whid,
                                                 @RequestParam(value = "mid",required = false) Integer mid,
                                                 @RequestParam(value = "mname",required = false) String mname,
                                                 @RequestParam(value = "lessInTime",required = false) Date lessInTime,
                                                 @RequestParam(value = "greaterInTime",required = false) Date greaterInTime,
                                                 @RequestParam(value = "inType",required = false) String inType,
                                                 @RequestParam(value = "poid",required = false) Integer poid,
                                                 @RequestParam(value = "creator", required = false) String creator,
                                                 @RequestParam(value = "lessCreateTime", required = false) Date lessCreateTime,
                                                 @RequestParam(value = "greaterCreateTime", required = false) Date greaterCreateTime,
                                                 @RequestParam(value = "modifier", required = false) String modifier,
                                                 @RequestParam(value = "lessModifyTime", required = false) Date lessModifyTime,
                                                 @RequestParam(value = "greaterModifyTime", required = false) Date greaterModifiyTime,
                                                 @RequestParam(value = "isActive", required = false) Integer isActive,
                                                 @RequestParam(value = "nnum",required = false) Integer nnum,
                                                 @RequestParam(value = "volumn",required = false) Double volumn,
                                                 @RequestParam(value = "weight",required = false) Double weight){
        PageHelper.startPage(page, pageSize);
        List<Instockbill> instockbills = instockbillService.getInstockbills(inid, inbillcode, whid, mid, mname, lessInTime,
                greaterInTime, inType, poid, creator, lessCreateTime, greaterCreateTime, modifier, lessModifyTime,
                greaterModifiyTime, isActive, nnum, volumn, weight);
        PageInfo<Instockbill> pageInfo = new PageInfo<>(instockbills);
        return pageInfo;
    }
}
