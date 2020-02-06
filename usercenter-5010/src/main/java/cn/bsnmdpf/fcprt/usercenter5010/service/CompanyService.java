package cn.bsnmdpf.fcprt.usercenter5010.service;

import cn.bsnmdpf.fcprt.api.pojo.Company;
import cn.bsnmdpf.fcprt.api.pojo.CompanyExample;
import cn.bsnmdpf.fcprt.usercenter5010.mapper.CompanyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author LicoLeung
 * @create 2020-02-01 15:56
 */
@Service
public class CompanyService {

    @Autowired
    private CompanyMapper companyMapper;

    /**
     * 根据查询条件返回公司列表
     *
     * @param cid
     * @param companyname
     * @param creator
     * @param modifier
     * @param isActive
     * @return 符合条件的公司列表
     */
    public List<Company> getCompanies(Integer cid, String companyname, String creator, String modifier, Integer isActive) {
        CompanyExample companyExample = new CompanyExample();
        CompanyExample.Criteria criteria = companyExample.createCriteria();
        if (cid != null) {
            criteria.andCidEqualTo(cid);
        }
        if (companyname != null) {
            companyname = "%" + companyname + "%";
            criteria.andCompanynameLike(companyname);
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
        List<Company> companies = companyMapper.selectByExample(companyExample);
        return companies;
    }

    /**
     * 添加公司
     *
     * @param company
     * @return 成功返回true，失败返回false
     */
    @Transactional
    public boolean addCompany(Company company) throws RuntimeException {
        int insert = companyMapper.insert(company);
        if (insert == 1) {
            return true;
        } else {
            throw new RuntimeException("未知错误，请检查字段是否完整");
        }
    }

    /**
     * 根据cid删除/封锁公司
     *
     * @param cid
     * @return 成功返回true，失败返回false
     */
    @Transactional
    public boolean unableCompanyByCid(Integer cid) throws RuntimeException {
        Company company = new Company();
        company.setIsactive(0);
        CompanyExample companyExample = new CompanyExample();
        CompanyExample.Criteria criteria = companyExample.createCriteria();
        criteria.andCidEqualTo(cid);
        int res = companyMapper.updateByExampleSelective(company, companyExample);
        if (res == 1) {
            return true;
        } else {
            throw new RuntimeException("未知错误，无法删除，或可能找不到对应cid的company");
        }
    }

    /**
     * 根据cid解封公司
     *
     * @param cid
     * @return 成功返回true，失败返回false
     */
    @Transactional
    public boolean ableCompanyByCid(Integer cid) throws RuntimeException {
        Company company = new Company();
        company.setIsactive(1);
        CompanyExample companyExample = new CompanyExample();
        CompanyExample.Criteria criteria = companyExample.createCriteria();
        criteria.andCidEqualTo(cid);
        int res = companyMapper.updateByExampleSelective(company, companyExample);
        if (res == 1) {
            return true;
        } else {
            throw new RuntimeException("未知错误，无法解封，或可能找不到对应cid的company");
        }
    }

    /**
     * 根据cid更新公司
     *
     * @param company
     * @return 成功返回true，失败返回false
     */
    @Transactional
    public boolean updateCompany(Company company) throws RuntimeException {
        CompanyExample companyExample = new CompanyExample();
        CompanyExample.Criteria criteria = companyExample.createCriteria();
        criteria.andCidEqualTo(company.getCid());
        int res = companyMapper.updateByExampleSelective(company, companyExample);
        if (res == 1) {
            return true;
        } else {
            throw new RuntimeException("未知错误，无法更新，或可能找不到对应cid的company");
        }
    }
}
