package cn.bsnmdpf.fcprt.usercenter5010.mapper;

import cn.bsnmdpf.fcprt.api.pojo.User;
import cn.bsnmdpf.fcprt.api.pojo.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    @Select("select * from tbl_user where username = #{username}")
    User loadUserByUsername(@Param("username") String username);
}