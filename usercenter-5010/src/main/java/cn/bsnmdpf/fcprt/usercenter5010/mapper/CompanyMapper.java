package cn.bsnmdpf.fcprt.usercenter5010.mapper;

import cn.bsnmdpf.fcprt.usercenter5010.pojo.Company;
import cn.bsnmdpf.fcprt.usercenter5010.pojo.CompanyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CompanyMapper {
    long countByExample(CompanyExample example);

    int deleteByExample(CompanyExample example);

    int insert(Company record);

    int insertSelective(Company record);

    List<Company> selectByExample(CompanyExample example);

    int updateByExampleSelective(@Param("record") Company record, @Param("example") CompanyExample example);

    int updateByExample(@Param("record") Company record, @Param("example") CompanyExample example);
}