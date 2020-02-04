package cn.bsnmdpf.fcprt.stockcenter5050.mapper;

import cn.bsnmdpf.fcprt.api.pojo.Warehouse;
import cn.bsnmdpf.fcprt.api.pojo.WarehouseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface WarehouseMapper {
    long countByExample(WarehouseExample example);

    int deleteByExample(WarehouseExample example);

    int insert(Warehouse record);

    int insertSelective(Warehouse record);

    List<Warehouse> selectByExample(WarehouseExample example);

    int updateByExampleSelective(@Param("record") Warehouse record, @Param("example") WarehouseExample example);

    int updateByExample(@Param("record") Warehouse record, @Param("example") WarehouseExample example);

    @Select("select * from tbl_warehouse where sid = #{sid}")
    List<Warehouse> selectBySid(@Param("sid") Integer sid);
}