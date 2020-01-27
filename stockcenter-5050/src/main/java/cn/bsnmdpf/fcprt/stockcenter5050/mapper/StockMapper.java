package cn.bsnmdpf.fcprt.stockcenter5050.mapper;

import cn.bsnmdpf.fcprt.stockcenter5050.pojo.Stock;
import cn.bsnmdpf.fcprt.stockcenter5050.pojo.StockExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StockMapper {
    long countByExample(StockExample example);

    int deleteByExample(StockExample example);

    int insert(Stock record);

    int insertSelective(Stock record);

    List<Stock> selectByExample(StockExample example);

    int updateByExampleSelective(@Param("record") Stock record, @Param("example") StockExample example);

    int updateByExample(@Param("record") Stock record, @Param("example") StockExample example);
}