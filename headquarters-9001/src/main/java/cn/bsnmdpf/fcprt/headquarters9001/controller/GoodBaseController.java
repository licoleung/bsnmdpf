package cn.bsnmdpf.fcprt.headquarters9001.controller;

import cn.bsnmdpf.fcprt.api.pojo.Material;
import cn.bsnmdpf.fcprt.api.pojo.Materialtag;
import cn.bsnmdpf.fcprt.api.service.GoodCenterService;
import com.github.pagehelper.PageInfo;
import org.bouncycastle.math.raw.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author LicoLeung
 * @create 2020-02-24 22:19
 */
@Controller
public class GoodBaseController {

    @Autowired
    private GoodCenterService goodCenterService;

    @GetMapping("good")
    public String getGoodList(@RequestParam(value = "pageSize", defaultValue = "1000") int pageSize,
                              @RequestParam(value = "page", defaultValue = "1") int page,
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

        List<Material> materials = pageInfo.getList();
        Collections.sort(materials, new Comparator<Material>() {
            @Override
            public int compare(Material o1, Material o2) {
                return o1.getMid().toString().compareTo(o2.getMid().toString());
            }
        });

        String res = "<table class='layui-table layui-form'>" +
                "<thead>" +
                "<tr>" +
                "<th width='70'>ID</th>" +
                " <th>栏目名</th> " +
                "<th width='70'>状态</th>" +
                "<th width='250'>操作</th>" +
                " </tr> " +
                "</thead> " +
                "<tbody class='x-cate'> ";

        for (Material material : materials) {
            int level = material.getMid();
            if (level < 10) {
                res += "<tr fid='" + material.getMcid() + "' cate-id='" + material.getMid() + "'>" +
                        " <td>" + material.getMid() + "</td> " + "<td><i class='layui-icon x-show' status='true'>&#xe623;</i>" + material.getMaterialname() +
                        "</td>" + " <td>-</td> " + " <td>-</td> ";
            } else if (level > 9999) {
                res += "<tr fid='" + material.getMcid() + "' cate-id='" + material.getMid() + "'>" +
                        " <td>" + material.getMid() + "</td> " + "<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;├" + material.getMaterialname() +
                        "</td>";
                if (material.getIsactive() == 1) {
                    res += "<td>已启用</td>";
                }
                if (material.getIsactive() == 0) {
                    res += "<td>已停用</td>";
                }
                res += " <td><button class='layui-btn layui-btn layui-btn-xs' onclick=\"xadmin.open('编辑','getgooddetail/" + material.getMid() + "')\"><i class='layui-icon'>&#xe63c;</i>查看详细</button>";
                if (material.getIsactive() == 1) {
                    res += "<button class=\"layui-btn-danger layui-btn layui-btn-xs\"  onclick=\"member_del(this,'" + material.getMid() + "','1')\" href=\"javascript:;\" ><i class=\"layui-icon\">&#xe640;</i>停用</button> ";
                }
                if (material.getIsactive() == 0) {
                    res += "<button class=\"layui-btn-normal layui-btn layui-btn-xs\"  onclick=\"member_del(this,'" + material.getMid() + "','0')\" href=\"javascript:;\" ><i class=\"layui-icon\">&#xe669;</i>恢复</button> ";
                }
                res += "<button class='layui-btn-normal layui-btn layui-btn-xs' onclick=\"xadmin.open('编辑','toaddtagpage/" + material.getMid() + "')\"><i class='layui-icon'>&#xe642;</i>增加标签</button>";
                res += "</td>";
            } else if (level < 100 && level > 9) {
                res += "<tr fid='" + material.getMcid() + "' cate-id='" + material.getMid() + "'>" +
                        " <td>" + material.getMid() + "</td> " + "<td>&nbsp;&nbsp;&nbsp;<i class='layui-icon x-show' status='true'>&#xe623;</i>" + material.getMaterialname() +
                        "</td>" + " <td>-</td> " + " <td>-</td> ";
            } else if (level > 99 && level < 1000) {
                res += "<tr fid='" + material.getMcid() + "' cate-id='" + material.getMid() + "'>" +
                        " <td>" + material.getMid() + "</td> " + "<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<i class='layui-icon x-show' status='true'>&#xe623;</i>" + material.getMaterialname() +
                        "</td>" + " <td>-</td> " + " <td>-</td> ";
            } else {
                res += "<tr fid='" + material.getMcid() + "' cate-id='" + material.getMid() + "'>" +
                        " <td>" + material.getMid() + "</td> " + "<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<i class='layui-icon x-show' status='true'>&#xe623;</i>" + material.getMaterialname() +
                        "</td>" + " <td>-</td> " + " <td>-</td> ";
            }
        }

        res += "</tr>" +
                "</tbody>" +
                "</table>";
        httpSession.setAttribute("test1", res);
        return "good/cate";
    }

    @GetMapping("getgooddetail/{mid}")
    public String getDetail(@PathVariable("mid") Integer mid, Model model) {
        PageInfo<Material> pageInfo = goodCenterService.getMaterials(1, 1, mid, null,
                null, null, null, null, null, null, null,
                null, null, null, null, null,
                null, null, null);
        List<Material> list = pageInfo.getList();
        Material material = list.get(0);
        List<Materialtag> materialtags = material.getMaterialtags();
        String tag = "";
        for (Materialtag materialtag : materialtags) {
            tag += materialtag.getTagname();
            tag += ",";
        }
        String relTag;
        if (materialtags.size() != 0) {
            relTag = tag.substring(0, tag.length() - 1);
        } else {
            relTag = tag;
        }

        model.addAttribute("good", material);
        model.addAttribute("tag", relTag);
        return "good/cate-detail";
    }

    @GetMapping("toaddpage")
    public String addpage() {
        return "good/cate-add";
    }

    @PostMapping("good")
    @ResponseBody
    public String addGood(@RequestParam(value = "mid") Integer mid,
                          @RequestParam(value = "materialname") String materialname,
                          @RequestParam(value = "mcid") Integer mcid,
                          @RequestParam(value = "length", required = false) Double length,
                          @RequestParam(value = "width", required = false) Double width,
                          @RequestParam(value = "height", required = false) Double height,
                          @RequestParam(value = "weight", required = false) Double weight,
                          @RequestParam(value = "volumn", required = false) Double volumn,
                          @RequestParam(value = "brand", required = false) String brand,
                          @RequestParam(value = "specifications", required = false) String specifications,
                          @RequestParam(value = "creator") String creator,
                          @RequestParam(value = "isActive", required = false, defaultValue = "1") Integer isActive) {
        boolean b = goodCenterService.addMaterial(mid, materialname, mcid, length, width, height, weight, volumn, brand,
                specifications, creator, isActive);
        return "添加成功";
    }

    @DeleteMapping("delgood/{mid}")
    public String delGood(@PathVariable("mid") Integer mid, @RequestParam("nowState") Integer nowState) {
        System.out.println("拉手动阀手动阀手动阀");
        if (nowState == 1) {
            goodCenterService.deleteMaterial(mid);
        } else {
            goodCenterService.ableMaterial(mid);
        }
        return "good/cate";
    }

    @GetMapping("toaddtagpage/{mid}")
    public String toAddTagPage(Model model, @PathVariable("mid") Integer mid) {
        PageInfo<Material> pageInfo = goodCenterService.getMaterials(1, 1, mid, null,
                null, null, null, null, null, null, null,
                null, null, null, null, null,
                null, null, null);
        List<Material> list = pageInfo.getList();
        Material material = list.get(0);
        model.addAttribute("mid", mid);
        model.addAttribute("mname", material.getMaterialname());
        return "good/tag-add";
    }

    @PostMapping("materialtag")
    @ResponseBody
    public String forAddTag(@RequestParam("mid") Integer mid,
                            @RequestParam("tagname") String tagname){
        goodCenterService.addMaterialtag(null,mid,tagname);
        return "添加成功";
    }
}
