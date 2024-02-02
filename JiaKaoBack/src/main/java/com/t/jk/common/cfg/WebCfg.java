package com.t.jk.common.cfg;

import com.t.jk.common.prop.JkProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * ClassName: WebCfg
 * Description:
 *
 * @Author agility6
 * @Create 2024/1/30 23:16
 * @Version: 1.0
 */

@Configuration
public class WebCfg implements WebMvcConfigurer {

    @Autowired
    private JkProperties properties;

    /**
     * 处理跨域
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins(properties.getCfg().getCorsOrigins())
                .allowCredentials(true)
                .allowedMethods("GET", "POST");
    }
}
