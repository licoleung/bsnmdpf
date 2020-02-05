package cn.bsnmdpf.fcprt.stockcenter5050.service;

import cn.bsnmdpf.fcprt.api.pojo.OnHand;
import cn.bsnmdpf.fcprt.api.pojo.OnHandExample;
import cn.bsnmdpf.fcprt.stockcenter5050.mapper.OnHandMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author LicoLeung
 * @create 2020-02-05 22:26
 */
@Service
public class OnHandService {

    @Autowired
    private OnHandMapper onHandMapper;

    public List<OnHand> getOnHands(Integer ohid,Integer mid,String mname,Integer whid,String whname,Integer sid,
                                   String stockname,Integer lessNnum,Integer greaterNnum,Double lessVolumn,
                                   Double greaterVolumn,Double lessWeight,Double greaterWeight){
        OnHandExample onHandExample = new OnHandExample();
        OnHandExample.Criteria criteria = onHandExample.createCriteria();
        if(ohid!=null){
            criteria.andOhidEqualTo(ohid);
        }
        if(mid!=null){
            criteria.andMidEqualTo(mid);
        }
        if(mname!=null){
            criteria.andMnameLike("%"+mname+"%");
        }
        if(whid!=null){
            criteria.andWhidEqualTo(whid);
        }
        if(whname!=null){
            criteria.andWhnameLike("%"+whname+"%");
        }
        if(sid!=null){
            criteria.andSidEqualTo(sid);
        }
        if(stockname!=null){
            criteria.andStocknameLike("%"+stockname+"%");
        }
        if(lessNnum!=null){
            criteria.andNnumLessThanOrEqualTo(lessNnum);
        }
        if(greaterNnum!=null){
            criteria.andNnumGreaterThanOrEqualTo(greaterNnum);
        }
        if(lessVolumn!=null){
            criteria.andVolumnLessThanOrEqualTo(lessVolumn);
        }
        if(greaterVolumn!=null){
            criteria.andVolumnGreaterThanOrEqualTo(greaterVolumn);
        }
        if(lessWeight!=null){
            criteria.andWeightLessThanOrEqualTo(lessWeight);
        }
        if(greaterWeight!=null){
            criteria.andWeightGreaterThanOrEqualTo(greaterWeight);
        }
        List<OnHand> onHands = onHandMapper.selectByExample(onHandExample);
        return onHands;
    }

    @Transactional
    public boolean addOnHand(OnHand onHand) throws RuntimeException{
        int insert = onHandMapper.insert(onHand);
        if (insert == 1) {
            return true;
        } else {
            throw new RuntimeException("未知错误，请检查onhand中的必填字段是否完整");
        }
    }

    @Transactional
    public boolean update(OnHand onHand) throws RuntimeException {
        OnHandExample onHandExample = new OnHandExample();
        OnHandExample.Criteria criteria = onHandExample.createCriteria();
        criteria.andOhidEqualTo(onHand.getOhid());
        int i = onHandMapper.updateByExampleSelective(onHand, onHandExample);
        if (i == 1) {
            return true;
        } else {
            throw new RuntimeException("未知错误，无法更新，或可能找不到对应ohid的onhand");
        }
    }
}
