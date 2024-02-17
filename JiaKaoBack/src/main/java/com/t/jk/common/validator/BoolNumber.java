package com.t.jk.common.validator;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * ClassName: BoolNumber
 * Description:
 *
 * @Author agility6
 * @Create 2024/2/8 16:33
 * @Version: 1.0
 */

@Documented // 生成文档
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD) // 只能是属性
@Constraint(validatedBy = BoolNumber.BoolNumberValidator.class) // 约束
public @interface BoolNumber {
    String message() default "只能是0和1";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
    class BoolNumberValidator implements ConstraintValidator<BoolNumber, Short> {
        @Override
        public boolean isValid(Short aShort, ConstraintValidatorContext constraintValidatorContext) {
            return aShort == null || aShort == 0 || aShort == 1;
        }
    }
}
