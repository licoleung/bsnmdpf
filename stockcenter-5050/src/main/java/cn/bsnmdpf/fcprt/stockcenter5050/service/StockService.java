package cn.bsnmdpf.fcprt.stockcenter5050.service;

import cn.bsnmdpf.fcprt.api.pojo.Stock;
import cn.bsnmdpf.fcprt.api.pojo.StockExample;
import cn.bsnmdpf.fcprt.stockcenter5050.mapper.StockMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author LicoLeung
 * @create 2020-02-04 15:20
 */
@Service
public class StockService {

    @Autowired
    private StockMapper stockMapper;

    /**
     * 根据条件查询仓库列表
     *
     * @param sid                仓库编码
     * @param stockname          仓库名称
     * @param lessVolumn         最大容量
     * @param greaterVolumn      最小容量
     * @param lessUsedVolumn     最大已使用容量
     * @param greaterUsedVolumn  最小已使用容量
     * @param address            地址
     * @param lessWhnum          最大仓位数量
     * @param greaterWhnum       最小仓位数量
     * @param creator            添加者
     * @param lessCreateTime     最大添加时间
     * @param greaterCreateTime  最小添加时间
     * @param modifier           修改者
     * @param lessModifyTime     最大修改时间
     * @param greaterModifiyTime 最小修改时间
     * @param isActive           是否启用
     * @return 符合条件的仓库列表
     */
    public List<Stock> getStockList(Integer sid, String stockname, Double lessVolumn, Double greaterVolumn,
                                    Double lessUsedVolumn, Double greaterUsedVolumn, String address, Integer lessWhnum,
                                    Integer greaterWhnum, String creator, Date lessCreateTime, Date greaterCreateTime,
                                    String modifier, Date lessModifyTime, Date greaterModifiyTime, Integer isActive) {
        StockExample stockExample = new StockExample();
        StockExample.Criteria criteria = stockExample.createCriteria();
        if (sid != null) {
            criteria.andSidEqualTo(sid);
        }
        if (stockname != null) {
            criteria.andStocknameLike("%" + stockname + "%");
        }
        if (lessVolumn != null) {
            criteria.andVolumnLessThanOrEqualTo(lessVolumn);
        }
        if (greaterVolumn != null) {
            criteria.andVolumnGreaterThanOrEqualTo(greaterVolumn);
        }
        if (greaterUsedVolumn != null) {
            criteria.andUsedvolumnGreaterThanOrEqualTo(greaterUsedVolumn);
        }
        if (lessUsedVolumn != null) {
            criteria.andUsedvolumnLessThanOrEqualTo(lessUsedVolumn);
        }
        if (address != null) {
            criteria.andAddressLike("%" + address + "%");
        }
        if (lessWhnum != null) {
            criteria.andWhnumLessThanOrEqualTo(lessWhnum);
        }
        if (greaterWhnum != null) {
            criteria.andWhnumGreaterThanOrEqualTo(greaterWhnum);
        }
        if (lessCreateTime != null) {
            criteria.andCreatetimeLessThanOrEqualTo(lessCreateTime);
        }
        if (greaterCreateTime != null) {
            criteria.andCreatetimeGreaterThanOrEqualTo(greaterCreateTime);
        }
        if (creator != null) {
            criteria.andCreatorLike("%" + creator + "%");
        }
        if (isActive != null) {
            criteria.andIsactiveEqualTo(isActive);
        }
        if (modifier != null) {
            modifier = "%" + modifier + "%";
            criteria.andModifierLike(modifier);
        }
        if (lessModifyTime != null) {
            criteria.andModifytimeLessThanOrEqualTo(lessModifyTime);
        }
        if (greaterModifiyTime != null) {
            criteria.andModifytimeGreaterThanOrEqualTo(greaterModifiyTime);
        }
        List<Stock> stocks = stockMapper.selectByExample(stockExample);
        return stocks;
    }

    /**
     * 添加仓库
     *
     * @param stock
     * @return 成功返回true，失败返回false
     */
    public boolean addStock(Stock stock) {
        int insert = stockMapper.insert(stock);
        try {
            if (insert == 1) {
                return true;
            } else {
                throw new Exception("未知错误，请检查Stock中的必填字段是否完整");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 根据sid删除或封锁stock
     *
     * @param sid
     * @return 成功返回true，失败返回false
     */
    public boolean unableStockBySid(Integer sid) {
        Stock stock = new Stock();
        stock.setIsactive(0);
        StockExample stockExample = new StockExample();
        StockExample.Criteria criteria = stockExample.createCriteria();
        criteria.andSidEqualTo(sid);
        int i = stockMapper.updateByExampleSelective(stock, stockExample);
        try {
            if (i == 1) {
                return true;
            } else {
                throw new Exception("未知错误，无法删除/封锁，或可能找不到对应sid的stock");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 解封stock
     *
     * @param sid
     * @return 成功返回true，失败返回false
     */
    public boolean ableStockBySid(Integer sid) {
        Stock stock = new Stock();
        stock.setIsactive(1);
        StockExample stockExample = new StockExample();
        StockExample.Criteria criteria = stockExample.createCriteria();
        criteria.andSidEqualTo(sid);
        int i = stockMapper.updateByExampleSelective(stock, stockExample);
        try {
            if (i == 1) {
                return true;
            } else {
                throw new Exception("未知错误，无法解封，或可能找不到对应sid的stock");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 更新stock
     *
     * @param stock
     * @return 成功返回true，失败返回false
     */
    public boolean updateStock(Stock stock) {
        StockExample stockExample = new StockExample();
        StockExample.Criteria criteria = stockExample.createCriteria();
        criteria.andSidEqualTo(stock.getSid());
        int i = stockMapper.updateByExampleSelective(stock, stockExample);
        try {
            if (i == 1) {
                return true;
            } else {
                throw new Exception("未知错误，无法更新，或可能找不到对应sid的stock");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
