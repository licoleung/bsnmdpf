package cn.bsnmdpf.fcprt.usercenter5010.controller;

import cn.bsnmdpf.fcprt.api.pojo.Department;
import cn.bsnmdpf.fcprt.usercenter5010.service.DepartmentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author LicoLeung
 * @create 2020-02-01 16:57
 */
@RestController
public class DepartmentContoller {

    @Autowired
    private DepartmentService departmentService;

    /**
     * 根据条件获取部门列表
     * @param pageSize
     * @param page
     * @param did
     * @param departmentname
     * @param creator
     * @param modifier
     * @param isActive
     * @param spare
     * @return 部门列表
     */
    @GetMapping("department")
    public PageInfo<Department> getDepartments(@RequestParam("pageSize") int pageSize,@RequestParam("page") int page,@RequestParam(value = "did", required = false)Integer did, @RequestParam(value = "deparmentname", required = false)String departmentname, @RequestParam(value = "creator", required = false)String creator, @RequestParam(value = "modifier", required = false)String modifier, @RequestParam(value = "isActive", required = false)Integer isActive, @RequestParam(value = "spare", required = false)String spare){
        PageHelper.startPage(page, pageSize);
        List<Department> departments = departmentService.getDepartments(did,departmentname,creator,modifier,isActive,spare);
        PageInfo<Department> pageInfo = new PageInfo<>(departments);
        return pageInfo;
    }

    /**
     * 更新部门
     * @param department
     * @return
     */
    @PostMapping("department")
    public boolean addDepartment(Department department){
        boolean b = departmentService.addDepartment(department);
        return b;
    }

    @DeleteMapping("department/{did}")
    public boolean deleteDepartment(@PathVariable("did") Integer did){
        boolean b = departmentService.unableDepartmentByDid(did);
        return b;
    }


}
