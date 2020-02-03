package cn.bsnmdpf.fcprt.usercenter5010.config;

import cn.bsnmdpf.fcprt.api.pojo.Permission;
import cn.bsnmdpf.fcprt.usercenter5010.mapper.PermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @author LicoLeung
 * @create 2020-02-02 17:22
 */
@Component
public class MyInvocationSecurityMetadataSourceService implements FilterInvocationSecurityMetadataSource {

    @Autowired
    private PermissionMapper permissionMapper;

    private static HashMap<String, Collection<ConfigAttribute>> map =null;

    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        if (null == map) {
            loadResourceDefine();
        }
        //object 中包含用户请求的request 信息
        HttpServletRequest request = ((FilterInvocation) o).getHttpRequest();
        for (Iterator<String> it = map.keySet().iterator(); it.hasNext();) {
            String url = it.next();
            if (new AntPathRequestMatcher( url ).matches( request )) {
                return map.get( url );
            }
        }
        return null;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }

    /**
     * 初始化 所有资源 对应的角色
     */
    public void loadResourceDefine() {
        map = new HashMap<>(16);
        //权限资源 和 角色对应的表  也就是 角色权限 中间表
        List<Permission> rolePermissons = permissionMapper.getRolePermissions();

        //某个资源 可以被哪些角色访问
        for (Permission rolePermisson : rolePermissons) {

            String url = rolePermisson.getUrl();
            String roleName = rolePermisson.getName();
            ConfigAttribute role = new SecurityConfig(roleName);

            if(map.containsKey(url)){
                map.get(url).add(role);
            }else{
                List<ConfigAttribute> list =  new ArrayList<>();
                list.add( role );
                map.put( url , list );
            }
        }
    }
}
