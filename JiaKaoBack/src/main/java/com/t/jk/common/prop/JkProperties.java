package com.t.jk.common.prop;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * ClassName: JkProperties
 * Description:
 *
 * @Author agility6
 * @Create 2024/1/30 23:18
 * @Version: 1.0
 */

@ConfigurationProperties("jk")
@Component
@Data
public class JkProperties {

    private Cfg cfg;

    @Data
    public static class Cfg {
        private String[] corsOrigins;
    }
}
