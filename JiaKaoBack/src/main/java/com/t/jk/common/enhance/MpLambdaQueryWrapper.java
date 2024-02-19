package com.t.jk.common.enhance;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;

/**
 * ClassName: MpLambdaQueryWrapper
 * Description: 对LambdaQueryWrapper进行封装
 *
 * @Author agility6
 * @Create 2024/1/31 15:23
 * @Version: 1.0
 */
public class MpLambdaQueryWrapper<T> extends LambdaQueryWrapper<T> {

    @SafeVarargs
    public final MpLambdaQueryWrapper<T> like(Object val, SFunction<T, ?>... funcs) {

        // 判空
        if (val == null) return this;
        String str = val.toString();
        if (str.length() == 0) return this;

        return (MpLambdaQueryWrapper<T>) nested((w) -> {
            for (SFunction<T, ?> func : funcs) {
                w.like(func, str).or();
            }
        });
    }
}
