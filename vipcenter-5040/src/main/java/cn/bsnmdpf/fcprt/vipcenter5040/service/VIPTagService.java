package cn.bsnmdpf.fcprt.vipcenter5040.service;

import cn.bsnmdpf.fcprt.api.pojo.VIPTag;
import cn.bsnmdpf.fcprt.api.pojo.VIPTagExample;
import cn.bsnmdpf.fcprt.vipcenter5040.mapper.VIPTagMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
     * @param vipid 根据vipid查询vip对应的viptag
     * @param vtid
     * @param tagname
     * @return 符合条件的viptag列表
     */
    public List<VIPTag> selectTagByVIPidorTagid(Integer vipid,Integer vtid,String tagname){
        VIPTagExample vipTagExample = new VIPTagExample();
        VIPTagExample.Criteria criteria = vipTagExample.createCriteria();
        if(vipid!=null){
            criteria.andVipidEqualTo(vipid);
        }
        if(vtid!=null){
            criteria.andVtidEqualTo(vtid);
        }
        if(tagname!=null){
            criteria.andTagnameEqualTo(tagname);
        }
        List<VIPTag> vipTags = vipTagMapper.selectByExample(vipTagExample);
        return vipTags;
    }

    /**
     * 增加tag
     * @param vipTag
     * @return 成功返回true，失败返回false
     */
    public boolean addTag(VIPTag vipTag){
        int insert = vipTagMapper.insert(vipTag);
        try {
            if (insert == 1) {
                return true;
            } else {
                throw new Exception("未知错误，请检查VIPTag中的必填字段是否完整");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 删除vipTag
     * @param vtid
     * @return 成功返回true，失败返回false
     */
    public boolean deleteTag(Integer vtid){
        VIPTagExample vipTagExample = new VIPTagExample();
        VIPTagExample.Criteria criteria = vipTagExample.createCriteria();
        criteria.andVtidEqualTo(vtid);
        int i = vipTagMapper.deleteByExample(vipTagExample);
        try {
            if (i == 1) {
                return true;
            } else {
                throw new Exception("未知错误，无法删除，或可能找不到对应vipTagid的vipTag");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
