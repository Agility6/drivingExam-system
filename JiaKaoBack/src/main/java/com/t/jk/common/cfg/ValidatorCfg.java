package com.t.jk.common.cfg;

import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.validation.Validation;
import javax.validation.Validator;

/**
 * ClassName: ValidatorCfg
 * Description:
 *
 * @Author agility6
 * @Create 2024/2/17 16:14
 * @Version: 1.0
 */
@Configuration
public class ValidatorCfg {

    // 快速失败
    @Bean
    public Validator validator() {
        return Validation
                .byProvider(HibernateValidator.class)
                .configure()
                .failFast(true)
                .buildValidatorFactory().getValidator();
    }
}
