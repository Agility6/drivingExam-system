package com.t.jk.common.exception;

import com.t.jk.pojo.result.CodeMsg;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * ClassName: CommonException
 * Description:
 *
 * @Author agility6
 * @Create 2024/1/31 17:39
 * @Version: 1.0
 */

@EqualsAndHashCode(callSuper = true)
@Data
public class CommonException extends RuntimeException {

    private static final int CODE_DEFAULT = CodeMsg.BAD_REQUEST.getCode();
    private int code;

    public CommonException() {
        this(CODE_DEFAULT, null);
    }

    public CommonException(String msg) {
        this(msg, null);
    }

    public CommonException(int code, String msg) {
        this(code, msg, null);
    }

    public CommonException(CodeMsg codeMsg) {
        this(codeMsg, null);
    }

    public CommonException(CodeMsg codeMsg, Throwable cause) {
        this(codeMsg.getCode(), codeMsg.getMsg(), cause);
    }

    /**
     *
     * @param msg
     * @param cause error info context
     */
    public CommonException(String msg, Throwable cause) {
        this(CODE_DEFAULT, msg, cause);
    }

    public CommonException(int code, String msg, Throwable cause) {
        super(msg, cause);
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
