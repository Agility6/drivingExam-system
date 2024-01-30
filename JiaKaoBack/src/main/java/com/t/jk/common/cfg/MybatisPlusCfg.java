package com.t.jk.common.cfg;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName: MybatisPlusCfg
 * Description:
 *
 * @Author agility6
 * @Create 2024/1/30 22:40
 * @Version: 1.0
 */

@Configuration
@MapperScan("com.t.jk.mapper")
public class MybatisPlusCfg {

    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        PaginationInnerInterceptor innerInterceptor = new PaginationInnerInterceptor();
        // 当页面超过总页数时，自动跳回第一页
        innerInterceptor.setOverflow(true);
        interceptor.addInnerInterceptor(innerInterceptor);
        return interceptor;
    }
    // 无需设置
    //    @Bean

    //    public ConfigurationCustomizer configurationCustomizer() {
    //        return configuration -> configuration.setUseDeprecatedExecutor(false);
    //    }
}