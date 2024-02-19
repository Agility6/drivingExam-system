package com.t.jk.common.cfg;

import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.core.metadata.TableInfoHelper;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.t.jk.pojo.vo.list.ExamPlaceCourseVo;
import org.apache.ibatis.builder.MapperBuilderAssistant;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.InitializingBean;
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
public class MybatisPlusCfg implements InitializingBean {

    /**
     * 分页配置
     * @return
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        PaginationInnerInterceptor innerInterceptor = new PaginationInnerInterceptor();
        // 当页面超过总页数时，自动跳回第一页
        innerInterceptor.setOverflow(true);
        interceptor.addInnerInterceptor(innerInterceptor);
        return interceptor;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        /**
         * 首先，用于lambda cache的实体类Entity，才能使用LambdaQueryWrapper<Entity>,
         * 默认情况下，只有BaseMapper<Entity>中的Entity类，才拥有lambda cache
         * 其他类需要通过TableInfoHelper手动添加lambda cache
         */
        MapperBuilderAssistant assistant = new MapperBuilderAssistant(new MybatisConfiguration(), "");
        TableInfoHelper.initTableInfo(assistant, ExamPlaceCourseVo.class);
    }

    // 无需设置
    //    @Bean
    //    public ConfigurationCustomizer configurationCustomizer() {
    //        return configuration -> configuration.setUseDeprecatedExecutor(false);
    //    }
}