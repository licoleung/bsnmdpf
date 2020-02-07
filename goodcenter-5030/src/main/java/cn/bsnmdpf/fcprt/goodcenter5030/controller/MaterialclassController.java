package cn.bsnmdpf.fcprt.goodcenter5030.controller;

import cn.bsnmdpf.fcprt.api.pojo.Materialclass;
import cn.bsnmdpf.fcprt.goodcenter5030.service.MaterialclassService;
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
 * @create 2020-02-07 19:38
 */
@RestController
public class MaterialclassController {

    @Autowired
    private MaterialclassService materialclassService;

    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request) {
        //转换日期 注意这里的转化要和传进来的字符串的格式一直 如2015-9-9 就应该为yyyy-MM-dd
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));// CustomDateEditor为自定义日期编辑器
    }

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
                                                      @RequestParam(value = "lessCreateTime", required = false) Date lessCreateTime,
                                                      @RequestParam(value = "greaterCreateTime", required = false) Date greaterCreateTime,
                                                      @RequestParam(value = "modifier", required = false) String modifier,
                                                      @RequestParam(value = "lessModifyTime", required = false) Date lessModifyTime,
                                                      @RequestParam(value = "greaterModifyTime", required = false) Date greaterModifiyTime,
                                                      @RequestParam(value = "isActive", required = false) Integer isActive) {
        PageHelper.startPage(page, pageSize);
        List<Materialclass> materialclasses = materialclassService.getMaterialclasses(mcid, parentMcid, classname, level, creator, lessCreateTime, greaterCreateTime, modifier, lessModifyTime, greaterModifiyTime, isActive);
        PageInfo<Materialclass> pageInfo = new PageInfo<>(materialclasses);
        return pageInfo;
    }

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
                                       @RequestParam(value = "isActive", required = false) Integer isActive) {
        Materialclass materialclass = new Materialclass();
        materialclass.setMcid(mcid);
        materialclass.setParentmcid(parentMcid);
        materialclass.setClassname(classname);
        materialclass.setLevel(level);
        materialclass.setModifier(modifier);
        materialclass.setModifytime(new Date());
        materialclass.setIsactive(isActive);
        boolean b = materialclassService.updateMaterialclass(materialclass);
        return b;
    }

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
                                    @RequestParam(value = "isActive", required = false, defaultValue = "1") Integer isActive) {
        Materialclass materialclass = new Materialclass();
        materialclass.setMcid(mcid);
        materialclass.setParentmcid(parentMcid);
        materialclass.setClassname(classname);
        materialclass.setLevel(level);
        materialclass.setCreator(creator);
        materialclass.setCreatetime(new Date());
        materialclass.setIsactive(isActive);
        boolean b = materialclassService.addMaterialclass(materialclass);
        return b;
    }
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
                                   @RequestParam(value = "parentMcid", required = false) Integer parentMcid) {
        int i = materialclassService.deleteMaterialclass(mcid, parentMcid);
        return i;
    }


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
                                    @RequestParam(value = "parentMcid", required = false) Integer parentMcid) {
        int i = materialclassService.recoverMaterialclass(mcid, parentMcid);
        return i;
    }
}
