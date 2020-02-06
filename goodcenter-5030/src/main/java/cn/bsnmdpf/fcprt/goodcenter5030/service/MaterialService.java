package cn.bsnmdpf.fcprt.goodcenter5030.service;

import cn.bsnmdpf.fcprt.api.pojo.Material;
import cn.bsnmdpf.fcprt.api.pojo.MaterialExample;
import cn.bsnmdpf.fcprt.goodcenter5030.mapper.MaterialMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author LicoLeung
 * @create 2020-02-06 16:13
 */
@Service
public class MaterialService {

    @Autowired
    private MaterialMapper materialMapper;

    /**
     * 根据条件查询物料列表
     *
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
    public List<Material> getMaterials(Integer mid, String materialname, Integer mcid, Double length, Double width, Double height,
                                       Double weight, Double volumn, String brand, String specifications, String creator, Date lessCreateTime, Date greaterCreateTime,
                                       String modifier, Date lessModifyTime, Date greaterModifiyTime, Integer isActive) {
        MaterialExample materialExample = new MaterialExample();
        MaterialExample.Criteria criteria = materialExample.createCriteria();
        if (mid != null) {
            criteria.andMidEqualTo(mid);
        }
        if (materialname != null) {
            criteria.andMaterialnameLike("%" + materialname + "%");
        }
        if (mcid != null) {
            criteria.andMcidEqualTo(mcid);
        }
        if (length != null) {
            criteria.andLengthEqualTo(length);
        }
        if (width != null) {
            criteria.andWidthEqualTo(width);
        }
        if (height != null) {
            criteria.andHeightEqualTo(height);
        }
        if (weight != null) {
            criteria.andWeightEqualTo(weight);
        }
        if (volumn != null) {
            criteria.andVolumnEqualTo(volumn);
        }
        if (brand != null) {
            criteria.andBrandLike("%" + brand + "%");
        }
        if (specifications != null) {
            criteria.andSpecificationsEqualTo(specifications);
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
        List<Material> materials = materialMapper.selectByExample(materialExample);
        return materials;
    }

    /**
     * 添加物料
     *
     * @param material
     * @return 成功返回true，失败返回false
     */
    public boolean addMaterial(Material material) {
        int insert = materialMapper.insert(material);
        if (insert == 1) {
            return true;
        } else {
            throw new RuntimeException("未知错误，请检查instockbill中的必填字段是否完整");
        }
    }

    /**
     * 根据mid，删除/封锁物料
     *
     * @param mid 物料主键
     * @return 成功返回true，失败返回false
     */
    public boolean unableMaterial(Integer mid) {
        Material material = new Material();
        material.setIsactive(0);
        MaterialExample materialExample = new MaterialExample();
        MaterialExample.Criteria criteria = materialExample.createCriteria();
        criteria.andMidEqualTo(mid);
        int i = materialMapper.updateByExampleSelective(material, materialExample);
        if (i == 1) {
            return true;
        } else {
            throw new RuntimeException("未知错误，无法封锁/删除，或可能找不到对应mid的物料");
        }
    }

    /**
     * 根据mid，恢复/解封物料
     *
     * @param mid 物料主键
     * @return 成功返回true，失败返回false
     */
    public boolean ableMaterial(Integer mid) {
        Material material = new Material();
        material.setIsactive(1);
        MaterialExample materialExample = new MaterialExample();
        MaterialExample.Criteria criteria = materialExample.createCriteria();
        criteria.andMidEqualTo(mid);
        int i = materialMapper.updateByExampleSelective(material, materialExample);
        if (i == 1) {
            return true;
        } else {
            throw new RuntimeException("未知错误，无法解封/恢复，或可能找不到对应mid的物料");
        }
    }

    /**
     * 更新物料
     *
     * @param material
     * @return 成功返回true，失败返回false
     */
    public boolean updateMaterial(Material material) {
        MaterialExample materialExample = new MaterialExample();
        MaterialExample.Criteria criteria = materialExample.createCriteria();
        criteria.andMidEqualTo(material.getMcid());
        int i = materialMapper.updateByExampleSelective(material, materialExample);
        if (i == 1) {
            return true;
        } else {
            throw new RuntimeException("未知错误，无法更新，或可能找不到对应mid的物料");
        }
    }
}