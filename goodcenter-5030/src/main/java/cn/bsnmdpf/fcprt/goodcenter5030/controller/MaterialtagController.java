package cn.bsnmdpf.fcprt.goodcenter5030.controller;

import cn.bsnmdpf.fcprt.api.pojo.Materialtag;
import cn.bsnmdpf.fcprt.goodcenter5030.service.MaterialtagService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author LicoLeung
 * @create 2020-02-07 19:08
 */
@RestController
public class MaterialtagController {

    @Autowired
    private MaterialtagService materialtagService;

    /**
     * 根据条件获取物料标签列表
     *
     * @param pageSize 页面大小
     * @param page     页码
     * @param mtid     主键
     * @param mid      物料编码
     * @param tagname  标签名称
     * @return 物料标签列表
     */
    @GetMapping("materialtag")
    public PageInfo<Materialtag> getMaterialtags(@RequestParam(value = "pageSize") int pageSize,
                                                 @RequestParam(value = "page") int page,
                                                 @RequestParam(value = "mtid", required = false) Integer mtid,
                                                 @RequestParam(value = "mid", required = false) Integer mid,
                                                 @RequestParam(value = "tagname", required = false) String tagname) {
        PageHelper.startPage(page, pageSize);
        List<Materialtag> materialtags = materialtagService.getMaterialtags(mtid, mid, tagname);
        PageInfo<Materialtag> pageInfo = new PageInfo<>(materialtags);
        return pageInfo;
    }

    /**
     * 添加物料标签
     *
     * @param mtid    主键
     * @param mid     物料编码
     * @param tagname 标签名称
     * @return 成功返回true，失败返回false
     */
    @PostMapping("materialtag")
    public boolean addMaterialtag(@RequestParam(value = "mtid", required = false) Integer mtid,
                                  @RequestParam(value = "mid") Integer mid,
                                  @RequestParam(value = "tagname") String tagname) {
        Materialtag materialtag = new Materialtag();
        materialtag.setMid(mid);
        materialtag.setMtid(mtid);
        materialtag.setTagname(tagname);
        boolean b = materialtagService.addMaterialtag(materialtag);
        return b;
    }

    /**
     * 删除物料标签
     * mtid和mid至少存在一个条件，否则在service层报错
     *
     * @param mtid 主键
     * @param mid  物料编码
     * @return 被删除的数量
     */
    @DeleteMapping("material")
    public int deleteMaterialtag(@RequestParam(value = "mtid", required = false) Integer mtid,
                                 @RequestParam(value = "mid", required = false) Integer mid) {
        int i = materialtagService.deleteMaterialtag(mtid, mid);
        return i;
    }
}
