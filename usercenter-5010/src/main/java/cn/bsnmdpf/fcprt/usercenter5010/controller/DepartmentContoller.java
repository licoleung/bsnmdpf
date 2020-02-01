package cn.bsnmdpf.fcprt.usercenter5010.controller;

import cn.bsnmdpf.fcprt.api.pojo.Department;
import cn.bsnmdpf.fcprt.usercenter5010.service.DepartmentService;
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

    @GetMapping("department")
    public List<Department> getDepartments(@RequestParam(value = "did", required = false)Integer did, @RequestParam(value = "deparmentname", required = false)String departmentname, @RequestParam(value = "creator", required = false)String creator, @RequestParam(value = "modifier", required = false)String modifier, @RequestParam(value = "isActive", required = false)Integer isActive, @RequestParam(value = "spare", required = false)String spare){
        List<Department> departments = departmentService.getDepartments(did,departmentname,creator,modifier,isActive,spare);
        return departments;
    }

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
