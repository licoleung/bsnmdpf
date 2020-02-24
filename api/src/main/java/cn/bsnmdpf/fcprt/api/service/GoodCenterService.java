package cn.bsnmdpf.fcprt.api.service;

import cn.bsnmdpf.fcprt.api.pojo.Material;
import cn.bsnmdpf.fcprt.api.pojo.Materialclass;
import cn.bsnmdpf.fcprt.api.pojo.Materialtag;
import com.github.pagehelper.PageInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author LicoLeung
 * @create 2020-02-07 20:10
 */
@FeignClient(value = "goodcenter-5030")
public interface GoodCenterService {

    //MaterialController

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
                                           @RequestParam(value = "lessCreateTime", required = false) String lessCreateTime,
                                           @RequestParam(value = "greaterCreateTime", required = false) String greaterCreateTime,
                                           @RequestParam(value = "modifier", required = false) String modifier,
                                           @RequestParam(value = "lessModifyTime", required = false) String lessModifyTime,
                                           @RequestParam(value = "greaterModifyTime", required = false) String greaterModifiyTime,
                                           @RequestParam(value = "isActive", required = false) Integer isActive);

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
                               @RequestParam(value = "isActive", required = false, defaultValue = "1") Integer isActive);

    /**
     * 删除/封锁物料
     *
     * @param mid 物料编码
     * @return 成功返回true，失败返回false
     */
    @DeleteMapping("material/{mid}")
    public boolean deleteMaterial(@PathVariable("mid") Integer mid);


    /**
     * 恢复/解封物料
     *
     * @param mid 物料编码
     * @return 成功返回true，失败返回false
     */
    @GetMapping("ablematerial/{mid}")
    public boolean ableMaterial(@PathVariable("mid") Integer mid);

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
                                  @RequestParam(value = "isActive", required = false) Integer isActive);

    //MaterialtagController


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
                                                 @RequestParam(value = "tagname", required = false) String tagname);


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
                                  @RequestParam(value = "tagname") String tagname);
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
                                 @RequestParam(value = "mid", required = false) Integer mid);

    //MaterialclassController


    /**
     * 获取物料分类列表
     *
     * @param mcid               主键
     * @param parentMcid         父主键
     * @param classname          分类名称
     * @param level              等级
     * @param creator            创建者
     * @param lessCreateTime     最大创建时间
     * @param greaterCreateTime  最小创建时间
     * @param modifier           修改者
     * @param lessModifyTime     最大修改时间
     * @param greaterModifiyTime 最小修改时间
     * @param isActive           是否启用
     * @return 符合条件的物料分类列表
     */
    @GetMapping("materialclass")
    public PageInfo<Materialclass> getMaterialclasses(@RequestParam(value = "pageSize") int pageSize,
                                                      @RequestParam(value = "page") int page,
                                                      @RequestParam(value = "mcid", required = false) Integer mcid,
                                                      @RequestParam(value = "parentMcid", required = false) Integer parentMcid,
                                                      @RequestParam(value = "classname", required = false) String classname,
                                                      @RequestParam(value = "level", required = false) Integer level,
                                                      @RequestParam(value = "creator", required = false) String creator,
                                                      @RequestParam(value = "lessCreateTime", required = false) String lessCreateTime,
                                                      @RequestParam(value = "greaterCreateTime", required = false) String greaterCreateTime,
                                                      @RequestParam(value = "modifier", required = false) String modifier,
                                                      @RequestParam(value = "lessModifyTime", required = false) String lessModifyTime,
                                                      @RequestParam(value = "greaterModifyTime", required = false) String greaterModifiyTime,
                                                      @RequestParam(value = "isActive", required = false) Integer isActive);

    /**
     * 更新物料分类
     *
     * @param mcid       物料分类主键
     * @param parentMcid 父分类主键
     * @param classname  分类名称
     * @param level      等级
     * @param modifier   修改者
     * @param isActive   是否启用
     * @return
     */
    @PutMapping("materialclass/{mcid}")
    public boolean updateMaterialclass(@PathVariable(value = "mcid") Integer mcid,
                                       @RequestParam(value = "parentMcid", required = false) Integer parentMcid,
                                       @RequestParam(value = "classname", required = false) String classname,
                                       @RequestParam(value = "level", required = false) Integer level,
                                       @RequestParam(value = "modifier", required = false) String modifier,
                                       @RequestParam(value = "isActive", required = false) Integer isActive);

    /**
     * 新增物料分类
     *
     * @param mcid       物料分类主键
     * @param parentMcid 父分类主键
     * @param classname  分类名称
     * @param level      等级
     * @param creator    创建者
     * @param isActive   是否启用
     * @return
     */
    @PostMapping("materialclass")
    public boolean addMaterialclass(@RequestParam(value = "mcid") Integer mcid,
                                    @RequestParam(value = "parentMcid", required = false, defaultValue = "0") Integer parentMcid,
                                    @RequestParam(value = "classname") String classname,
                                    @RequestParam(value = "level", required = false, defaultValue = "1") Integer level,
                                    @RequestParam(value = "creator") String creator,
                                    @RequestParam(value = "isActive", required = false, defaultValue = "1") Integer isActive);
    /***
     * 删除/封锁物料分类
     * mcid和parentMcid必须至少存在一个条件
     * @param mcid 物料分类编码
     * @param parentMcid 父分类编码
     * @return 返回被删除/封锁条数
     * @throws RuntimeException
     */
    @DeleteMapping("materialclass")
    public int deleteMaterialclass(@RequestParam(value = "mcid", required = false) Integer mcid,
                                   @RequestParam(value = "parentMcid", required = false) Integer parentMcid);


    /**
     * 恢复/解封物料分类
     * mcid和parentMcid必须至少存在一个条件
     *
     * @param mcid       物料分类编码
     * @param parentMcid 父分类编码
     * @return 返回被恢复/解封条数
     * @throws RuntimeException
     */
    @GetMapping("ablematerialclass")
    public int recoverMaterialclass(@RequestParam(value = "mcid", required = false) Integer mcid,
                                    @RequestParam(value = "parentMcid", required = false) Integer parentMcid);
}
