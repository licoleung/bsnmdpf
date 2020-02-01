package cn.bsnmdpf.fcprt.usercenter5010.controller;

import cn.bsnmdpf.fcprt.api.pojo.Company;
import cn.bsnmdpf.fcprt.usercenter5010.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author LicoLeung
 * @create 2020-02-01 16:19
 */
@RestController
public class CompanyController {

    @Autowired
    private CompanyService companyService;

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
    public List<Company> getCompanies(@RequestParam(value = "cid", required = false) Integer cid, @RequestParam(value = "companyname", required = false) String companyname, @RequestParam(value = "creator", required = false) String creator, @RequestParam(value = "modifier", required = false) String modifier, @RequestParam(value = "isActive", required = false) Integer isActive) {
        List<Company> companies = companyService.getCompanies(cid, companyname, creator, modifier, isActive);
        return companies;
    }

    /**
     * 添加公司
     *
     * @param company
     * @return 成功返回true，失败返回false
     */
    @PostMapping("company")
    public boolean addCompany(Company company) {
        boolean b = companyService.addCompany(company);
        return b;
    }

    /**
     * 删除/封锁公司信息
     *
     * @param cid
     * @return 成功返回true，失败返回false
     */
    @DeleteMapping("company/{cid}")
    public boolean deleteCompany(@PathVariable("cid") Integer cid) {
        boolean b = companyService.unableCompanyByCid(cid);
        return b;
    }

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
    public boolean updateCompany(@PathVariable("cid") Integer cid, @RequestParam(value = "companyname", required = false) String companyname, @RequestParam(value = "modifier", required = false) String modifier, @RequestParam(value = "isActive", required = false) Integer isActive) {
        Company company = new Company();
        company.setCid(cid);
        company.setCompanyname(companyname);
        company.setModifier(modifier);
        company.setModifytime(new Date());
        company.setIsactive(isActive);
        boolean b = companyService.updateCompany(company);
        return b;
    }
}
