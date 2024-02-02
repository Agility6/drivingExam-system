package com.t.jk.pojo.result;

import com.t.jk.common.enhance.Jsonable;

import java.util.HashMap;

/**
 * ClassName: R
 * Description: 返回给用户的JSON对象
 *
 * @Author agility6
 * @Create 2024/1/31 16:40
 * @Version: 1.0
 */
public class R extends HashMap<String, Object> implements Jsonable {
    private static final String K_CODE = "code";
    private static final String K_MSG = "msg";
    private static final String K_DATA = "data";
    private static final int CODE_SUCCESS = 0;
    private static final int CODE_ERROR_DEFAULT = CodeMsg.BAD_REQUEST.getCode();

    // 默认情况成功
    public R() {
        this(true);
    }

    // 是否成功指定CODE
    public R(boolean success) {
        this(success, null);
    }


    public R(boolean success, String msg) {
        this(success ? CODE_SUCCESS : CODE_ERROR_DEFAULT, msg);
    }

    public R(int code, String msg) {
        put(K_CODE, code);
        put(K_MSG, msg);
    }

    public R(CodeMsg codeMsg) {
        this(codeMsg.getCode(), codeMsg.getMsg());
    }

    public R(String msg, Object data) {
        this(data);
        put(K_MSG, msg);
    }

    /**
     * 默认有数据代表成功
     * @param data
     */
    public R(Object data) {
        put(K_CODE, CODE_SUCCESS);
        put(K_DATA, data);
    }


}
