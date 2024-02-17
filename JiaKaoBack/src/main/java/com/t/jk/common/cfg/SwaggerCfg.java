package com.t.jk.common.cfg;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestParameterBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.schema.ScalarType;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ParameterType;
import springfox.documentation.service.RequestParameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: SwaggerCfg
 * Description:
 *
 * @Author agility6
 * @Create 2024/2/17 16:25
 * @Version: 1.0
 */
@Configuration
public class SwaggerCfg implements InitializingBean {
    /**
     * enable控制是否生成文档 开发阶段是需要文档
     * Environment springboot读取配置文件
     * select().paths()或者是apis() 筛选哪一些Controller生成文档
     * 忽略参数假如需要传入session不需要展示不重要的参数，使用ignoredParameterTypes
     * groupName进行分组
     */

    @Autowired
    private Environment environment;
    private boolean enable; // 只需要设置一次,afterPropertiesSet设置即可

    @Bean
    public Docket metadatadocket(Environment environment) {
        return basicDocket()
                .groupName("元数据")
                .apiInfo(apiInfo("元数据文档", "元数据文档描述"))
                .select()
                .paths(PathSelectors.regex("/(dict.*|plate.*)"))
                .build();
    }

    @Bean
    public Docket examdocket(Environment environment) {
        return basicDocket()
                .groupName("考场")
                .apiInfo(apiInfo("考场文档", "考场文档描述"))
                .select()
                .paths(PathSelectors.regex("/exam.*"))
                .build();
    }

    private Docket basicDocket() {

        return new Docket(DocumentationType.SWAGGER_2)
//                .globalRequestParameters(getGlobalRequestParameters())
                .ignoredParameterTypes(
                        HttpSession.class,
                        HttpServletRequest.class,
                        HttpServletResponse.class)
                .enable(enable);
    }

//    private List<RequestParameter> getGlobalRequestParameters() {
//
//        List<RequestParameter> parameters = new ArrayList<>();
//        parameters.add(new RequestParameterBuilder()
//                .name("token")
//                .description("用户登录令牌")
//                .in(ParameterType.HEADER)
//                .query(q -> q.model((m -> m.scalarModel(ScalarType.STRING))))
//                .build());
//
//        return parameters;
//    }

    private ApiInfo apiInfo(String title, String description) {
        return new ApiInfoBuilder()
                .title(title)
                .description(description)
                .version("1.0.0")
                .build();
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        enable = environment.acceptsProfiles(Profiles.of("dev"));
    }
}