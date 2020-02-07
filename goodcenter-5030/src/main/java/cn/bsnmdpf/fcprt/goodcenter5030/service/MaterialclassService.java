package cn.bsnmdpf.fcprt.goodcenter5030.service;

import cn.bsnmdpf.fcprt.api.pojo.Materialclass;
import cn.bsnmdpf.fcprt.api.pojo.MaterialclassExample;
import cn.bsnmdpf.fcprt.goodcenter5030.mapper.MaterialclassMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author LicoLeung
 * @create 2020-02-07 16:47
 */
@Service
public class MaterialclassService {

    @Autowired
    private MaterialclassMapper materialclassMapper;

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
    public List<Materialclass> getMaterialclasses(Integer mcid, Integer parentMcid, String classname, Integer level,
                                                 String creator, Date lessCreateTime, Date greaterCreateTime,
                                                 String modifier, Date lessModifyTime, Date greaterModifiyTime, Integer isActive) {
        MaterialclassExample materialclassExample = new MaterialclassExample();
        MaterialclassExample.Criteria criteria = materialclassExample.createCriteria();
        if (mcid != null) {
            criteria.andMcidEqualTo(mcid);
        }
        if (parentMcid != null) {
            criteria.andParentmcidEqualTo(parentMcid);
        }
        if (classname != null) {
            criteria.andClassnameLike("%" + classname + "%");
        }
        if (level != null) {
            criteria.andLevelEqualTo(level);
        }
        if (creator != null) {
            criteria.andCreatorEqualTo(creator);
        }
        if (lessCreateTime != null) {
            criteria.andCreatetimeLessThanOrEqualTo(lessCreateTime);
        }
        if (greaterCreateTime != null) {
            criteria.andCreatetimeGreaterThanOrEqualTo(greaterCreateTime);
        }
        if (modifier != null) {
            modifier = "%" + modifier + "%";
            criteria.andModifierLike(modifier);
        }
        if (lessModifyTime != null) {
            criteria.andModifytimeLessThanOrEqualTo(lessModifyTime);
        }
        if (greaterModifiyTime != null) {
            criteria.andModifytimeGreaterThanOrEqualTo(greaterModifiyTime);
        }
        if (isActive != null) {
            criteria.andIsactiveEqualTo(isActive);
        }
        List<Materialclass> materialclasses = materialclassMapper.selectByExample(materialclassExample);
        return materialclasses;
    }

    /**
     * 添加物料分类
     *
     * @param materialclass
     * @return 成功返回true，失败返回false
     * @throws RuntimeException
     */
    @Transactional
    public boolean addMaterialclass(Materialclass materialclass) throws RuntimeException {
        int insert = materialclassMapper.insert(materialclass);
        if (insert == 1) {
            return true;
        } else {
            throw new RuntimeException("未知错误，请检查materialclass中的必填字段是否完整");
        }
    }

    /***
     * 删除/封锁物料分类
     * mcid和parentMcid必须至少存在一个条件
     * @param mcid 物料分类编码
     * @param parentMcid 父分类编码
     * @return 返回被删除/封锁条数
     * @throws RuntimeException
     */
    @Transactional
    public int deleteMaterialclass(Integer mcid, Integer parentMcid) throws RuntimeException {
        if (mcid == null && parentMcid == null) {
            throw new RuntimeException("删除条件不能全部为空，此操作会删除所有数据");
        }
        MaterialclassExample materialclassExample = new MaterialclassExample();
        MaterialclassExample.Criteria criteria = materialclassExample.createCriteria();
        if (parentMcid != null) {
            criteria.andParentmcidEqualTo(parentMcid);
        }
        if (mcid != null) {
            criteria.andMcidEqualTo(mcid);
        }
        Materialclass materialclass = new Materialclass();
        materialclass.setIsactive(0);
        int i = materialclassMapper.updateByExampleSelective(materialclass, materialclassExample);
        if (i == 0) {
            throw new RuntimeException("无法删除，请检查条件是否正确");
        } else {
            return i;
        }
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
    @Transactional
    public int recoverMaterialclass(Integer mcid, Integer parentMcid) throws RuntimeException {
        if (mcid == null && parentMcid == null) {
            throw new RuntimeException("条件不能全部为空，此操作会修改所有数据");
        }
        MaterialclassExample materialclassExample = new MaterialclassExample();
        MaterialclassExample.Criteria criteria = materialclassExample.createCriteria();
        if (parentMcid != null) {
            criteria.andParentmcidEqualTo(parentMcid);
        }
        if (mcid != null) {
            criteria.andMcidEqualTo(mcid);
        }
        Materialclass materialclass = new Materialclass();
        materialclass.setIsactive(1);
        int i = materialclassMapper.updateByExampleSelective(materialclass, materialclassExample);
        if (i == 0) {
            throw new RuntimeException("无法恢复，请检查条件是否正确");
        } else {
            return i;
        }
    }

    /**
     * 更新物料分类
     *
     * @param materialclass 物料分类
     * @return 成功返回true，失败返回false
     * @throws RuntimeException
     */
    @Transactional
    public boolean updateMaterialclass(Materialclass materialclass) throws RuntimeException {
        MaterialclassExample materialclassExample = new MaterialclassExample();
        MaterialclassExample.Criteria criteria = materialclassExample.createCriteria();
        criteria.andMcidEqualTo(materialclass.getMcid());
        int i = materialclassMapper.updateByExampleSelective(materialclass, materialclassExample);
        if (i == 0) {
            throw new RuntimeException("无法恢复，请检查条件是否正确");
        } else {
            return true;
        }
    }
}
