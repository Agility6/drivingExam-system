package com.t.jk.common.util;

import com.t.jk.common.exception.CommonException;
import com.t.jk.pojo.query.PageQuery;
import com.t.jk.pojo.result.R;

/**
 * ClassName: Rs
 * Description: 封装返回
 *
 * @Author agility6
 * @Create 2024/1/31 16:56
 * @Version: 1.0
 */
public class Rs {

    private static final String K_COUNT = "count";

    public static R error(String msg) {
        return new R(false, msg);
    }

    public static R error(Throwable t) {
        // 如果错误类型是CommonException
        if (t instanceof CommonException) {
            CommonException e = (CommonException) t;
            return new R(e.getCode(), e.getMessage());
        } else {
            return error(t.getMessage());
        }
    }

    public static R ok(PageQuery query) {
       R r = new R(query.getData());
       r.put(K_COUNT, query.getCount());
       return r;
    }

    public static R ok(String msg) {
        return new R(true, msg);
    }

    public static R ok(Object data) {
        return new R(data);
    }

    public static R ok() {
        return new R();
    }
}
