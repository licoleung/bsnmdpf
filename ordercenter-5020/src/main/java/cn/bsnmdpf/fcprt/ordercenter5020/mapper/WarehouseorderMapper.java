package cn.bsnmdpf.fcprt.ordercenter5020.mapper;

import java.util.List;

import cn.bsnmdpf.fcprt.api.pojo.Warehouseorder;
import cn.bsnmdpf.fcprt.api.pojo.WarehouseorderExample;
import org.apache.ibatis.annotations.Param;

public interface WarehouseorderMapper {
    long countByExample(WarehouseorderExample example);

    int deleteByExample(WarehouseorderExample example);

    int insert(Warehouseorder record);

    int insertSelective(Warehouseorder record);

    List<Warehouseorder> selectByExample(WarehouseorderExample example);

    int updateByExampleSelective(@Param("record") Warehouseorder record, @Param("example") WarehouseorderExample example);

    int updateByExample(@Param("record") Warehouseorder record, @Param("example") WarehouseorderExample example);
}