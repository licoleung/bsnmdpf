package cn.bsnmdpf.fcprt.vipcenter5040.controller;

import cn.bsnmdpf.fcprt.api.pojo.VIPTag;
import cn.bsnmdpf.fcprt.vipcenter5040.service.VIPTagService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author LicoLeung
 * @create 2020-02-04 13:50
 */
@RestController
public class VIPTagController {

    @Autowired
    private VIPTagService vipTagService;

    /**
     * 给用户添加标签
     *
     * @param vipid
     * @param tagname
     * @return 成功返回true，失败返回false
     */
    @PostMapping("viptag")
    public boolean addTag(@RequestParam(value = "vipid") Integer vipid, @RequestParam(value = "tagname") String tagname) {
        VIPTag vipTag = new VIPTag();
        vipTag.setVipid(vipid);
        vipTag.setTagname(tagname);
        boolean b = vipTagService.addTag(vipTag);
        return b;
    }

    /**
     * 删除用户所有标签或某个标签
     * 两个条件不能全为空，否则在service层会报错
     *
     * @param vtid
     * @param vipid
     * @return 成功返回true，失败返回false
     */
    @DeleteMapping("viptag")
    public int deleteTag(@RequestParam(value = "vtid", required = false) Integer vtid,
                         @RequestParam(value = "vipid", required = false) Integer vipid) {
        int i = vipTagService.deleteTag(vtid, vipid);
        return i;
    }

    /**
     * 查询标签明细
     * @param pageSize
     * @param page
     * @param vtid
     * @param vipid
     * @param tagname
     * @return 标签列表
     */
    @GetMapping("viptag")
    public PageInfo<VIPTag> getTagDetail(@RequestParam(value = "pageSize") int pageSize,
                                         @RequestParam(value = "page") int page,
                                         @RequestParam(value = "vtid", required = false) Integer vtid,
                                         @RequestParam(value = "vipid", required = false) Integer vipid,
                                         @RequestParam(value = "tagname", required = false) String tagname){
        PageHelper.startPage(page,pageSize);
        List<VIPTag> vipTags = vipTagService.selectTagByVIPidorTagid(vipid, vtid, tagname);
        PageInfo<VIPTag> pageInfo = new PageInfo<>(vipTags);
        return pageInfo;
    }
}
