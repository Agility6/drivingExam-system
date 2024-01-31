package com.t.jk.common.util;

import com.t.jk.common.exception.CommonException;
import com.t.jk.pojo.query.PageQuery;
import com.t.jk.pojo.result.R;

/**
 * ClassName: Rs
 * Description:
 *
 * @Author agility6
 * @Create 2024/1/31 16:56
 * @Version: 1.0
 */
public class Rs {

    private static final String K_COUNT = "count";

    public static R error(String msg) {
        return new R().setSuccess(false).setMsg(msg);
    }

    public static R error(Throwable t) {
        // 如果错误类型是CommonException
        if (t instanceof CommonException) {
            CommonException e = (CommonException) t;
            R r = new R();
            r.setCode(e.getCode());
            r.setMsg(e.getMessage());
            return r;
        } else {
            return error(t.getMessage());
        }
    }

    public static R ok(PageQuery query) {
        R r = new R();
        r.put(K_COUNT, query.getCount());
        return r.setSuccess(true).setData(query.getData());
    }

    public static R ok(String msg) {
       return new R().setSuccess(true).setMsg(msg);
    }

    public static R ok(Object data) {
        return new R().setSuccess(true).setData(data);
    }

    public static R ok() {
        return new R().setSuccess(true);
    }
}