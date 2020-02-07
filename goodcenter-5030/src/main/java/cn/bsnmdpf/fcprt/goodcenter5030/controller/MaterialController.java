package cn.bsnmdpf.fcprt.goodcenter5030.controller;

import cn.bsnmdpf.fcprt.api.pojo.Material;
import cn.bsnmdpf.fcprt.api.pojo.Materialtag;
import cn.bsnmdpf.fcprt.goodcenter5030.service.MaterialService;
import cn.bsnmdpf.fcprt.goodcenter5030.service.MaterialtagService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author LicoLeung
 * @create 2020-02-07 17:24
 */
@RestController
public class MaterialController {

    @Autowired
    private MaterialService materialService;

    @Autowired
    private MaterialtagService materialtagService;

    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request) {
        //转换日期 注意这里的转化要和传进来的字符串的格式一直 如2015-9-9 就应该为yyyy-MM-dd
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));// CustomDateEditor为自定义日期编辑器
    }

    /**
     * 根据条件查询物料列表
     *
     * @param page               页码
     * @param pageSize           页面大小
     * @param mid                物料id
     * @param materialname       物料名称
     * @param mcid               物料类别id
     * @param length             长度
     * @param width              宽度
     * @param height             高度
     * @param weight             重量
     * @param volumn             体积
     * @param brand              品牌
     * @param specifications     规格
     * @param creator            创建者
     * @param lessCreateTime     最大创建时间
     * @param greaterCreateTime  最小创建时间
     * @param modifier           修改者
     * @param lessModifyTime     最大修改时间
     * @param greaterModifiyTime 最小修改时间
     * @param isActive           是否启用
     * @return 物料列表
     */
    @GetMapping("material")
    public PageInfo<Material> getMaterials(@RequestParam(value = "pageSize") int pageSize,
                                           @RequestParam(value = "page") int page,
                                           @RequestParam(value = "mid", required = false) Integer mid,
                                           @RequestParam(value = "materialname", required = false) String materialname,
                                           @RequestParam(value = "mcid", required = false) Integer mcid,
                                           @RequestParam(value = "length", required = false) Double length,
                                           @RequestParam(value = "width", required = false) Double width,
                                           @RequestParam(value = "height", required = false) Double height,
                                           @RequestParam(value = "weight", required = false) Double weight,
                                           @RequestParam(value = "volumn", required = false) Double volumn,
                                           @RequestParam(value = "brand", required = false) String brand,
                                           @RequestParam(value = "specifications", required = false) String specifications,
                                           @RequestParam(value = "creator", required = false) String creator,
                                           @RequestParam(value = "lessCreateTime", required = false) Date lessCreateTime,
                                           @RequestParam(value = "greaterCreateTime", required = false) Date greaterCreateTime,
                                           @RequestParam(value = "modifier", required = false) String modifier,
                                           @RequestParam(value = "lessModifyTime", required = false) Date lessModifyTime,
                                           @RequestParam(value = "greaterModifyTime", required = false) Date greaterModifiyTime,
                                           @RequestParam(value = "isActive", required = false) Integer isActive) {
        PageHelper.startPage(page, pageSize);
        List<Material> materials = materialService.getMaterials(mid, materialname, mcid, length, width, height, weight,
                volumn, brand, specifications, creator, lessCreateTime, greaterCreateTime, modifier, lessModifyTime,
                greaterModifiyTime, isActive);
        //注入标签列表
        for (Material material : materials) {
            List<Materialtag> materialtags = materialtagService.getMaterialtags(null, material.getMid(), null);
            material.setMaterialtags(materialtags);
        }
        PageInfo<Material> materialPageInfo = new PageInfo<>(materials);
        return materialPageInfo;
    }

    /**
     * 新增物料
     *
     * @param mid            物料编码
     * @param materialname   物料名称
     * @param mcid           物料类别编码
     * @param length         长度
     * @param width          宽度
     * @param height         高度
     * @param weight         重量
     * @param volumn         体积
     * @param brand          品牌
     * @param specifications 规格
     * @param creator        创建者
     * @param isActive       是否启用，默认1（启用）
     * @return 成功返回true，失败返回false
     */
    @PostMapping("material")
    public boolean addMaterial(@RequestParam(value = "mid") Integer mid,
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
        Material material = new Material();
        material.setMid(mid);
        material.setMaterialname(materialname);
        material.setMcid(mcid);
        material.setCreator(creator);
        material.setCreatetime(new Date());
        material.setLength(length);
        material.setWidth(width);
        material.setWeight(weight);
        material.setHeight(height);
        material.setVolumn(volumn);
        material.setBrand(brand);
        material.setSpecifications(specifications);
        material.setIsactive(isActive);
        boolean b = materialService.addMaterial(material);
        return b;
    }

    /**
     * 删除/封锁物料
     *
     * @param mid 物料编码
     * @return 成功返回true，失败返回false
     */
    @DeleteMapping("material/{mid}")
    public boolean deleteMaterial(@PathVariable("mid") Integer mid) {
        boolean b = materialService.unableMaterial(mid);
        return b;
    }

    /**
     * 恢复/解封物料
     *
     * @param mid 物料编码
     * @return 成功返回true，失败返回false
     */
    @GetMapping("ablematerial/{mid}")
    public boolean ableMaterial(@PathVariable("mid") Integer mid) {
        boolean b = materialService.ableMaterial(mid);
        return b;
    }

    /**
     * 更新物料
     *
     * @param mid            物料编码
     * @param materialname   物料名称
     * @param mcid           物料类别编码
     * @param length         长度
     * @param width          宽度
     * @param height         高度
     * @param weight         重量
     * @param volumn         体积
     * @param brand          品牌
     * @param specifications 规格
     * @param modifier       修改者
     * @param isActive       是否启用，默认1（启用）
     * @return 成功返回true，失败返回false
     */
    @PutMapping("material/{mid}")
    public boolean updateMaterial(@PathVariable("mid") Integer mid,
                                  @RequestParam(value = "materialname", required = false) String materialname,
                                  @RequestParam(value = "mcid", required = false) Integer mcid,
                                  @RequestParam(value = "length", required = false) Double length,
                                  @RequestParam(value = "width", required = false) Double width,
                                  @RequestParam(value = "height", required = false) Double height,
                                  @RequestParam(value = "weight", required = false) Double weight,
                                  @RequestParam(value = "volumn", required = false) Double volumn,
                                  @RequestParam(value = "brand", required = false) String brand,
                                  @RequestParam(value = "specifications", required = false) String specifications,
                                  @RequestParam(value = "modifier", required = false) String modifier,
                                  @RequestParam(value = "isActive", required = false) Integer isActive) {
        Material material = new Material();
        material.setMid(mid);
        material.setMaterialname(materialname);
        material.setMcid(mcid);
        material.setCreator(modifier);
        material.setModifytime(new Date());
        material.setLength(length);
        material.setWidth(width);
        material.setWeight(weight);
        material.setHeight(height);
        material.setVolumn(volumn);
        material.setBrand(brand);
        material.setSpecifications(specifications);
        material.setIsactive(isActive);
        boolean b = materialService.updateMaterial(material);
        return b;
    }
}
