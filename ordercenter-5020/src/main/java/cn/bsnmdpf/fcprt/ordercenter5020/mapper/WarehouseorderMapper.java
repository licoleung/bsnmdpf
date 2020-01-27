package cn.bsnmdpf.fcprt.ordercenter5020.mapper;

import cn.bsnmdpf.fcprt.ordercenter5020.pojo.Warehouseorder;
import cn.bsnmdpf.fcprt.ordercenter5020.pojo.WarehouseorderExample;
import java.util.List;
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