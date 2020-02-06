package cn.bsnmdpf.fcprt.api.service;

import cn.bsnmdpf.fcprt.api.pojo.Company;
import cn.bsnmdpf.fcprt.api.pojo.Department;
import cn.bsnmdpf.fcprt.api.pojo.Role;
import cn.bsnmdpf.fcprt.api.pojo.User;
import com.github.pagehelper.PageInfo;
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

    /**
     * 根据参数查询用户列表
     *
     * @param username
     * @param creator
     * @param modifier
     * @param isActive
     * @param did
     * @param uid
     * @return 用户列表
     */
    @GetMapping("user")
    public PageInfo<User> getUsersByParam(@RequestParam("pageSize") int pageSize,
                                          @RequestParam("page") int page,
                                          @RequestParam(value = "username", required = false) String username,
                                          @RequestParam(value = "creator", required = false) String creator,
                                          @RequestParam(value = "modifier", required = false) String modifier,
                                          @RequestParam(value = "isActive", required = false) Integer isActive,
                                          @RequestParam(value = "did", required = false) Integer did,
                                          @RequestParam(value = "uid", required = false) Integer uid,
                                          @RequestParam(value = "spare", required = false) String spare);

    /**
     * 添加用户
     *
     * @param user
     * @return 成功返回true，失败返回false
     */
    @PostMapping("user")
    public boolean addUser(@RequestBody User user);

    /**
     * 根据uid删除用户/将用户设为不可用
     *
     * @param uid
     * @return 成功返回true，失败返回false
     */
    @DeleteMapping("user/{uid}")
    public boolean deleteUser(@PathVariable("uid") Integer uid);

    /**
     * 根据uid更新user，有参则更，无参则不变
     *
     * @param username
     * @param modifier
     * @param isActive
     * @param did
     * @param uid
     * @param password
     * @param spare
     * @return 成功返回true，失败返回false
     */
    @PutMapping("user/{uid}")
    public boolean updateUser(@RequestParam(value = "username", required = false) String username, @RequestParam(value = "modifier", required = false) String modifier, @RequestParam(value = "isActive", required = false) Integer isActive, @RequestParam(value = "did", required = false) Integer did, @PathVariable("uid") Integer uid, @RequestParam(value = "password",required = false) String password, @RequestParam(value = "spare", required = false) String spare);

    //CompanyController

    /**
     * 根据条件查询公司列表
     *
     * @param cid
     * @param companyname
     * @param creator
     * @param modifier
     * @param isActive
     * @return 符合条件公司列表
     */
    @GetMapping("company")
    public PageInfo<Company> getCompanies(@RequestParam("pageSize") int pageSize, @RequestParam("page") int page,@RequestParam(value = "cid", required = false) Integer cid, @RequestParam(value = "companyname", required = false) String companyname, @RequestParam(value = "creator", required = false) String creator, @RequestParam(value = "modifier", required = false) String modifier, @RequestParam(value = "isActive", required = false) Integer isActive);

    /**
     * 添加公司
     *
     * @param company
     * @return 成功返回true，失败返回false
     */
    @PostMapping("company")
    public boolean addCompany(@RequestBody Company company);

    /**
     * 删除/封锁公司信息
     *
     * @param cid
     * @return 成功返回true，失败返回false
     */
    @DeleteMapping("company/{cid}")
    public boolean deleteCompany(@PathVariable("cid") Integer cid);

    /**
     * 根据cid更新公司，有参则更，无参则不变
     *
     * @param cid
     * @param companyname
     * @param modifier
     * @param isActive
     * @return 成功返回true，失败返回false
     */
    @PutMapping("company/{cid}")
    public boolean updateCompany(@PathVariable("cid") Integer cid, @RequestParam(value = "companyname", required = false) String companyname, @RequestParam(value = "modifier", required = false) String modifier, @RequestParam(value = "isActive", required = false) Integer isActive);

    //RoleController

    @GetMapping("role")
    public PageInfo<Role> getRoles(@RequestParam("pageSize") int pageSize, @RequestParam("page") int page,@RequestParam(value = "rid", required = false) Integer rid, @RequestParam(value = "rolename", required = false) String rolename, @RequestParam(value = "creator", required = false) String creator, @RequestParam(value = "modifier", required = false) String modifier, @RequestParam(value = "isActive", required = false) Integer isActive, @RequestParam(value = "spare", required = false) String spare);

    @PostMapping("role")
    public boolean addRole(@RequestBody Role role);

    @DeleteMapping("role/{rid}")
    public boolean deleteRole(@PathVariable("rid") Integer rid);

    @PutMapping("role/{rid}")
    public boolean updateRole(@PathVariable("rid") Integer rid, @RequestParam(value = "rolename", required = false) String rolename, @RequestParam(value = "modifier", required = false) String modifier, @RequestParam(value = "isActive", required = false) Integer isActive, @RequestParam(value = "spare", required = false) String spare);

    //DepartmentController

    @GetMapping("department")
    public PageInfo<Department> getDepartments(@RequestParam("pageSize") int pageSize, @RequestParam("page") int page,@RequestParam(value = "did", required = false)Integer did, @RequestParam(value = "deparmentname", required = false)String departmentname, @RequestParam(value = "creator", required = false)String creator, @RequestParam(value = "modifier", required = false)String modifier, @RequestParam(value = "isActive", required = false)Integer isActive, @RequestParam(value = "spare", required = false)String spare);

    @PostMapping("department")
    public boolean addDepartment(@RequestBody Department department);

    @DeleteMapping("department/{did}")
    public boolean deleteDepartment(@PathVariable("did") Integer did);
}
