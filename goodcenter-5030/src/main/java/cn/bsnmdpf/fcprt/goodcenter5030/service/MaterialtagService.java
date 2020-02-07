package cn.bsnmdpf.fcprt.goodcenter5030.service;

import cn.bsnmdpf.fcprt.api.pojo.Materialtag;
import cn.bsnmdpf.fcprt.api.pojo.MaterialtagExample;
import cn.bsnmdpf.fcprt.goodcenter5030.mapper.MaterialtagMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author LicoLeung
 * @create 2020-02-06 21:36
 */
@Service
public class MaterialtagService {


    @Autowired
    private MaterialtagMapper materialtagMapper;

    /**
     * 根据条件查询物料标签列表
     *
     * @param mtid    主键
     * @param mid     物料编码
     * @param tagname 标签名称
     * @return 物料标签列表
     */
    public List<Materialtag> getMaterialtags(Integer mtid, Integer mid, String tagname) {
        MaterialtagExample materialtagExample = new MaterialtagExample();
        MaterialtagExample.Criteria criteria = materialtagExample.createCriteria();
        if (mtid != null)
            criteria.andMtidEqualTo(mtid);
        if (mid != null) {
            criteria.andMidEqualTo(mid);
        }
        if (tagname != null) {
            criteria.andTagnameLike("%" + tagname + "%");
        }
        List<Materialtag> materialtags = materialtagMapper.selectByExample(materialtagExample);
        return materialtags;
    }

    /**
     * 添加物料标签
     *
     * @param materialtag 物料标签
     * @return 成功返回true，失败返回false
     * @throws RuntimeException
     */
    @Transactional
    public boolean addMaterialtag(Materialtag materialtag) throws RuntimeException {
        int insert = materialtagMapper.insertSelective(materialtag);
        if (insert == 1) {
            return true;
        } else {
            throw new RuntimeException("未知错误，请检查物料标签中的必填字段是否完整");
        }
    }

    /**
     * 删除物料标签
     *
     * @param mtid 主键
     * @param mid  物料编码
     * @return 返回删除条数
     * @throws RuntimeException
     */
    @Transactional
    public int deleteMaterialtag(Integer mtid, Integer mid) throws RuntimeException {
        if (mtid == null && mid == null) {
            throw new RuntimeException("不能无删除条件，此操作会删除所有物料标签");
        }
        MaterialtagExample materialtagExample = new MaterialtagExample();
        MaterialtagExample.Criteria criteria = materialtagExample.createCriteria();
        if (mid != null) {
            criteria.andMidEqualTo(mid);
        }
        if (mtid != null) {
            criteria.andMtidEqualTo(mtid);
        }
        int i = materialtagMapper.deleteByExample(materialtagExample);

        if (i == 0) {
            throw new RuntimeException("未知错误，无法删除，或可能找不到对应条件的物料标签");
        } else {
            return i;
        }

    }
}
