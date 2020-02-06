package cn.bsnmdpf.fcprt.goodcenter5030.service;

import cn.bsnmdpf.fcprt.api.pojo.Materialtag;
import cn.bsnmdpf.fcprt.goodcenter5030.mapper.MaterialtagMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LicoLeung
 * @create 2020-02-06 21:36
 */
@Service
public class MaterialtagService {

    @Autowired
    private MaterialtagMapper materialtagMapper;

    public List<Materialtag> getMaterialtags(){

    }
}
