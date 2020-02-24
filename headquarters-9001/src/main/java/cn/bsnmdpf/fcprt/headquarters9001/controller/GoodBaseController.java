package cn.bsnmdpf.fcprt.headquarters9001.controller;

import cn.bsnmdpf.fcprt.api.pojo.Material;
import cn.bsnmdpf.fcprt.api.service.GoodCenterService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @author LicoLeung
 * @create 2020-02-24 22:19
 */
@Controller
public class GoodBaseController {

    @Autowired
    private GoodCenterService goodCenterService;

    @GetMapping("good")
    public String getGoodList(@RequestParam(value = "pageSize",defaultValue = "1000") int pageSize,
                              @RequestParam(value = "page",defaultValue = "1") int page,
                              @RequestParam(value = "mid", required = false) Integer mid,
                              @RequestParam(value = "materialname", required = false) String materialname,
                              @RequestParam(value = "mcid", required = false) Integer mcid,//father id
                              @RequestParam(value = "length", required = false) Double length,
                              @RequestParam(value = "width", required = false) Double width,
                              @RequestParam(value = "height", required = false) Double height,
                              @RequestParam(value = "weight", required = false) Double weight,
                              @RequestParam(value = "volumn", required = false) Double volumn,
                              @RequestParam(value = "brand", required = false) String brand,
                              @RequestParam(value = "specifications", required = false) String specifications,
                              @RequestParam(value = "creator", required = false) String creator,
                              @RequestParam(value = "lessCreateTime", required = false) String lessCreateTime,
                              @RequestParam(value = "greaterCreateTime", required = false) String greaterCreateTime,
                              @RequestParam(value = "modifier", required = false) String modifier,
                              @RequestParam(value = "lessModifyTime", required = false) String lessModifyTime,
                              @RequestParam(value = "greaterModifyTime", required = false) String greaterModifiyTime,
                              @RequestParam(value = "isActive", required = false) Integer isActive,
                              Model model,
                              HttpSession httpSession) {
        PageInfo<Material> pageInfo = goodCenterService.getMaterials(pageSize, page, mid, materialname, mcid, length, width, height, weight,
                volumn, brand, specifications, creator, lessCreateTime, greaterCreateTime, modifier, lessModifyTime,
                greaterModifiyTime, isActive);

        int nowPage = pageInfo.getPageNum();//当前页面
        int[] nums = pageInfo.getNavigatepageNums();

        //previous page
        if (pageInfo.isIsFirstPage()) {
            model.addAttribute("prePage", nowPage);
        } else {
            model.addAttribute("prePage", nowPage - 1);
        }

        //next page
        if (pageInfo.isIsLastPage()) {
            model.addAttribute("nextPage", nowPage);
        } else {
            model.addAttribute("nextPage", nowPage + 1);
        }
        model.addAttribute("nowPage", nowPage);
        model.addAttribute("nums", nums);
        model.addAttribute("goodlist", pageInfo.getList());

        httpSession.setAttribute("test1","<table class='layui-table layui-form'><thead><tr><th width='70'>ID</th> <th>栏目名</th> <th width='250'>操作</th> </tr> </thead> <tbody class='x-cate'> <tr fid='0' cate-id='1'> <td>121212</td> <td>bbbbb</td> <td>ddddd</td> </tr></tbody></table>" );
        return "good/cate";
    }
}
