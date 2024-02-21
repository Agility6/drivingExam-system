package com.t.jk.common.shiro;

import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * ClassName: ShiroCfg
 * Description:
 *
 * @Author agility6
 * @Create 2024/2/21 10:37
 * @Version: 1.0
 */

@Configuration
public class ShiroCfg {

    @Bean
    public Realm realm() {
        return new TokenRealm(new TokenMatcher());
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(Realm realm) {
        ShiroFilterFactoryBean filterBean = new ShiroFilterFactoryBean();

        // 安全管理器
        filterBean.setSecurityManager(new DefaultWebSecurityManager(realm));

        // 添加自定义Filter
        Map<String, Filter> filters = new HashMap<>();
        filters.put("token", new TokenFilter());
        filterBean.setFilters(filters);

        // 设置url拦截
        Map<String, String> urlMap = new LinkedHashMap<>(); // 要保证验证的顺序
        urlMap.put("/sysUser/captcha", "anon"); // 获取验证码不需要验证
        urlMap.put("/sysUser/login", "anon"); // 登录页面不需要验证
        urlMap.put("/**", "token"); // 剩下的路线走我自己的filter
        filterBean.setFilterChainDefinitionMap(urlMap);

        return filterBean;
    }
}
