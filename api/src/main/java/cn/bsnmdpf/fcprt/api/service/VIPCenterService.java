package cn.bsnmdpf.fcprt.api.service;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author LicoLeung
 * @create 2020-02-04 14:51
 */
@FeignClient(value = "vipcenter-5040")
public interface VIPCenterService {
}
