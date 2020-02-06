package cn.bsnmdpf.fcprt.headquarters9001.controller;

import cn.bsnmdpf.fcprt.api.pojo.Instockbill;
import cn.bsnmdpf.fcprt.api.service.StockCenterService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author LicoLeung
 * @create 2020-02-06 13:43
 */
@Controller
public class StockBaseController {

    @Autowired
    private StockCenterService stockCenterService;


    @GetMapping("instockbill")
    public List<Instockbill> getInstockbills(@RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
                                             @RequestParam(value = "page", defaultValue = "1") int page,
                                             @RequestParam(value = "inid", required = false) Integer inid,
                                             @RequestParam(value = "inbillcode", required = false) String inbillcode,
                                             @RequestParam(value = "whid", required = false) Integer whid,
                                             @RequestParam(value = "mid", required = false) Integer mid,
                                             @RequestParam(value = "mname", required = false) String mname,
                                             @RequestParam(value = "lessInTime", required = false) String lessInTime,
                                             @RequestParam(value = "greaterInTime", required = false) String greaterInTime,
                                             @RequestParam(value = "inType", required = false) String inType,
                                             @RequestParam(value = "poid", required = false) Integer poid,
                                             @RequestParam(value = "creator", required = false) String creator,
                                             @RequestParam(value = "lessCreateTime", required = false) String lessCreateTime,
                                             @RequestParam(value = "greaterCreateTime", required = false) String greaterCreateTime,
                                             @RequestParam(value = "modifier", required = false) String modifier,
                                             @RequestParam(value = "lessModifyTime", required = false) String lessModifyTime,
                                             @RequestParam(value = "greaterModifyTime", required = false) String greaterModifiyTime,
                                             @RequestParam(value = "isActive", required = false) Integer isActive,
                                             @RequestParam(value = "nnum", required = false) Integer nnum,
                                             @RequestParam(value = "volumn", required = false) Double volumn,
                                             @RequestParam(value = "weight", required = false) Double weight,
                                             Model model)  {
        PageInfo<Instockbill> instockbills = stockCenterService.getInstockbills(pageSize, page, inid, inbillcode, whid, mid, mname, lessInTime, greaterInTime, inType, poid, creator, lessCreateTime, greaterCreateTime, modifier, lessModifyTime, greaterModifiyTime, isActive, nnum, volumn, weight);
        model.addAttribute("instockbills", instockbills.getList());
        return instockbills.getList();
    }
}
