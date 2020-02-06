package cn.bsnmdpf.fcprt.usercenter5010.service;

import cn.bsnmdpf.fcprt.api.pojo.Department;
import cn.bsnmdpf.fcprt.api.pojo.DepartmentExample;
import cn.bsnmdpf.fcprt.usercenter5010.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author LicoLeung
 * @create 2020-02-01 16:45
 */
@Service
public class DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    /**
     * 根据条件查询部门列表
     *
     * @param did
     * @param departmentname
     * @param creator
     * @param modifier
     * @param isActive
     * @param spare
     * @return 符合条件的部门列表
     */
    public List<Department> getDepartments(Integer did, String departmentname, String creator, String modifier, Integer isActive, String spare) {
        DepartmentExample departmentExample = new DepartmentExample();
        DepartmentExample.Criteria criteria = departmentExample.createCriteria();
        if (did != null) {
            criteria.andDidEqualTo(did);
        }
        if (departmentname != null) {
            departmentname = "%" + departmentname + "%";
            criteria.andDepartmentnameLike(departmentname);
        }
        if (modifier != null) {
            modifier = "%" + modifier + "%";
            criteria.andModifierLike(modifier);
        }
        if (creator != null) {
            creator = "%" + creator + "%";
            criteria.andCreatorLike(creator);
        }
        if (isActive != null) {
            criteria.andIsactiveEqualTo(isActive);
        }
        if (spare != null) {
            criteria.andSpareEqualTo(spare);
        }
        List<Department> departments = departmentMapper.selectByExample(departmentExample);
        return departments;
    }

    /**
     * 增加部门
     *
     * @param department
     * @return 成功返回true，失败返回false
     */
    @Transactional
    public boolean addDepartment(Department department) throws RuntimeException {
        int insert = departmentMapper.insert(department);
        if (insert == 1) {
            return true;
        } else {
            throw new RuntimeException("未知错误，请检查字段是否完整");
        }
    }

    /**
     * 根据did删除/封锁部门
     *
     * @param did
     * @return 成功返回true，失败返回false
     */
    @Transactional
    public boolean unableDepartmentByDid(Integer did) throws RuntimeException {
        Department department = new Department();
        department.setIsactive(0);
        DepartmentExample departmentExample = new DepartmentExample();
        DepartmentExample.Criteria criteria = departmentExample.createCriteria();
        criteria.andDidEqualTo(did);
        int res = departmentMapper.updateByExampleSelective(department, departmentExample);
        if (res == 1) {
            return true;
        } else {
            throw new RuntimeException("未知错误，无法删除，或可能找不到对应did的department");
        }
    }

    /**
     * 根据did解封部门
     *
     * @param did
     * @return 成功返回true，失败返回false
     */
    @Transactional
    public boolean ableDepartmentByDid(Integer did) throws RuntimeException {
        Department department = new Department();
        department.setIsactive(1);
        DepartmentExample departmentExample = new DepartmentExample();
        DepartmentExample.Criteria criteria = departmentExample.createCriteria();
        criteria.andDidEqualTo(did);
        int res = departmentMapper.updateByExampleSelective(department, departmentExample);
        if (res == 1) {
            return true;
        } else {
            throw new RuntimeException("未知错误，无法解封，或可能找不到对应did的department");
        }
    }

    /**
     * 根据did更新部门
     *
     * @param department
     * @return 成功返回true，失败返回false
     */
    @Transactional
    public boolean updateDepartment(Department department) throws RuntimeException {
        DepartmentExample departmentExample = new DepartmentExample();
        DepartmentExample.Criteria criteria = departmentExample.createCriteria();
        criteria.andDidEqualTo(department.getDid());
        int res = departmentMapper.updateByExampleSelective(department, departmentExample);
        if (res == 1) {
            return true;
        } else {
            throw new RuntimeException("未知错误，无法更新，或可能找不到对应did的department");
        }
    }
}
