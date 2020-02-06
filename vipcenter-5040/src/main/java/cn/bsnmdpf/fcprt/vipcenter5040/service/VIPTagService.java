package cn.bsnmdpf.fcprt.vipcenter5040.service;

import cn.bsnmdpf.fcprt.api.pojo.VIPTag;
import cn.bsnmdpf.fcprt.api.pojo.VIPTagExample;
import cn.bsnmdpf.fcprt.vipcenter5040.mapper.VIPTagMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author LicoLeung
 * @create 2020-02-03 22:15
 */
@Service
public class VIPTagService {

    @Autowired
    private VIPTagMapper vipTagMapper;

    /**
     * 根据条件查询tag列表
     *
     * @param vipid   根据vipid查询vip对应的viptag
     * @param vtid
     * @param tagname
     * @return 符合条件的viptag列表
     */
    public List<VIPTag> selectTagByVIPidorTagid(Integer vipid, Integer vtid, String tagname) {
        VIPTagExample vipTagExample = new VIPTagExample();
        VIPTagExample.Criteria criteria = vipTagExample.createCriteria();
        if (vipid != null) {
            criteria.andVipidEqualTo(vipid);
        }
        if (vtid != null) {
            criteria.andVtidEqualTo(vtid);
        }
        if (tagname != null) {
            criteria.andTagnameEqualTo(tagname);
        }
        List<VIPTag> vipTags = vipTagMapper.selectByExample(vipTagExample);
        return vipTags;
    }

    /**
     * 增加tag
     *
     * @param vipTag
     * @return 成功返回true，失败返回false
     */
    @Transactional
    public boolean addTag(VIPTag vipTag) throws RuntimeException {
        int insert = vipTagMapper.insert(vipTag);
            if (insert == 1) {
                return true;
            } else {
                throw new RuntimeException("未知错误，请检查VIPTag中的必填字段是否完整");
            }
    }

    /**
     * 删除vipTag
     *
     * @param vtid
     * @return 成功返回true，失败返回false
     */
    @Transactional
    public int deleteTag(Integer vtid, Integer vipid) throws RuntimeException {
        try {
            if (vtid == null && vipid == null) {
                throw new Exception("不允许无任何删除条件，此操作会删除所有标签");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        VIPTagExample vipTagExample = new VIPTagExample();
        VIPTagExample.Criteria criteria = vipTagExample.createCriteria();
        if (vtid != null) {
            criteria.andVtidEqualTo(vtid);
        }
        if (vipid != null) {
            criteria.andVipidEqualTo(vipid);
        }
        int i = vipTagMapper.deleteByExample(vipTagExample);

        if (i == 0) {
            throw new RuntimeException("无删除任何标签，请检查条件是否正确");
        }
        return i;
    }
}
