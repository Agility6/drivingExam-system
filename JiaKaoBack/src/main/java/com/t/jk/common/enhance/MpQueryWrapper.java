package com.t.jk.common.enhance;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

/**
 * ClassName: MpQueryWrapper
 * Description:
 *
 * @Author agility6
 * @Create 2024/1/31 15:23
 * @Version: 1.0
 */
public class MpQueryWrapper<T> extends QueryWrapper<T> {

    public final MpQueryWrapper<T> like(Object val, String... columns) {
        if (val == null) return this;
        String str = val.toString();
        if (str.isEmpty()) return this;
        return (MpQueryWrapper<T>) nested((w) -> {
            for (String column : columns) {
                w.like(column, str).or();
            }
        });
    }
}
