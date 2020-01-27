package cn.bsnmdpf.fcprt.usercenter5010.mapper;

import cn.bsnmdpf.fcprt.usercenter5010.pojo.User;
import cn.bsnmdpf.fcprt.usercenter5010.pojo.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);
}