package cn.bsnmdpf.fcprt.api.service;

import cn.bsnmdpf.fcprt.api.pojo.Company;
import cn.bsnmdpf.fcprt.api.pojo.Department;
import cn.bsnmdpf.fcprt.api.pojo.Role;
import cn.bsnmdpf.fcprt.api.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author LicoLeung
 * @create 2020-02-02 1:15
 */
@FeignClient(value = "usercenter-5010")
public interface UserCenterService {

    //UserController

    @GetMapping("user")
    public List<User> getUsersByParam(@RequestParam(value = "username", required = false) String username, @RequestParam(value = "creator", required = false) String creator, @RequestParam(value = "modifier", required = false) String modifier, @RequestParam(value = "isActive", required = false) Integer isActive, @RequestParam(value = "did", required = false) Integer did, @RequestParam(value = "uid", required = false) Integer uid, @RequestParam(value = "spare", required = false) String spare);

    @PostMapping("user")
    public boolean addUser(@RequestBody User user);

    @DeleteMapping("user/{uid}")
    public boolean deleteUser(@PathVariable("uid") Integer uid);

    @PutMapping("user/{uid}")
    public boolean updateUser(@RequestParam(value = "username", required = false) String username, @RequestParam(value = "modifier", required = false) String modifier, @RequestParam(value = "isActive", required = false) Integer isActive, @RequestParam(value = "did", required = false) Integer did, @PathVariable("uid") Integer uid, @RequestParam(value = "password",required = false) String password, @RequestParam(value = "spare", required = false) String spare);

    //CompanyController

    @GetMapping("company")
    public List<Company> getCompanies(@RequestParam(value = "cid", required = false) Integer cid, @RequestParam(value = "companyname", required = false) String companyname, @RequestParam(value = "creator", required = false) String creator, @RequestParam(value = "modifier", required = false) String modifier, @RequestParam(value = "isActive", required = false) Integer isActive);

    @PostMapping("company")
    public boolean addCompany(@RequestBody Company company);

    @DeleteMapping("company/{cid}")
    public boolean deleteCompany(@PathVariable("cid") Integer cid);

    @PutMapping("company/{cid}")
    public boolean updateCompany(@PathVariable("cid") Integer cid, @RequestParam(value = "companyname", required = false) String companyname, @RequestParam(value = "modifier", required = false) String modifier, @RequestParam(value = "isActive", required = false) Integer isActive);

    //RoleController

    @GetMapping("role")
    public List<Role> getRoles(@RequestParam(value = "rid", required = false) Integer rid, @RequestParam(value = "rolename", required = false) String rolename, @RequestParam(value = "creator", required = false) String creator, @RequestParam(value = "modifier", required = false) String modifier, @RequestParam(value = "isActive", required = false) Integer isActive, @RequestParam(value = "spare", required = false) String spare);

    @PostMapping("role")
    public boolean addRole(@RequestBody Role role);

    @DeleteMapping("role/{rid}")
    public boolean deleteRole(@PathVariable("rid") Integer rid);

    @PutMapping("role/{rid}")
    public boolean updateRole(@PathVariable("rid") Integer rid, @RequestParam(value = "rolename", required = false) String rolename, @RequestParam(value = "modifier", required = false) String modifier, @RequestParam(value = "isActive", required = false) Integer isActive, @RequestParam(value = "spare", required = false) String spare);

    //DepartmentController

    @GetMapping("department")
    public List<Department> getDepartments(@RequestParam(value = "did", required = false)Integer did, @RequestParam(value = "deparmentname", required = false)String departmentname, @RequestParam(value = "creator", required = false)String creator, @RequestParam(value = "modifier", required = false)String modifier, @RequestParam(value = "isActive", required = false)Integer isActive, @RequestParam(value = "spare", required = false)String spare);

    @PostMapping("department")
    public boolean addDepartment(@RequestBody Department department);

    @DeleteMapping("department/{did}")
    public boolean deleteDepartment(@PathVariable("did") Integer did);
}
