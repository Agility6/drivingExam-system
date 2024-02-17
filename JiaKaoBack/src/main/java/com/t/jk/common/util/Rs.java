package com.t.jk.common.util;

import com.t.jk.common.exception.CommonException;
import com.t.jk.pojo.query.PageQuery;
import com.t.jk.pojo.result.CodeMsg;
import com.t.jk.pojo.result.R;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.stream.Collectors;

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

    public static R error() {
        return new R(false);
    }

    public static R error(Throwable t) {
        // 如果错误类型是CommonException
        if (t instanceof CommonException) {
            CommonException ce = (CommonException) t;
            return new R(ce.getCode(), ce.getMessage());
        } else if (t instanceof BindException) {
            BindException be = (BindException) t;
            List<ObjectError> errors = be.getBindingResult().getAllErrors();

            // 函数式编程的方法
            List<String> defautMsgs = errors.stream()
                    .map(ObjectError::getDefaultMessage)
                    .collect(Collectors.toList());
            String msg = StringUtils.collectionToDelimitedString(defautMsgs, ", ");
            return error(msg);
        } else if (t instanceof ConstraintViolationException) {
            ConstraintViolationException cve = (ConstraintViolationException) t;
            List<String> msgs = cve.getConstraintViolations()
                    .stream().map(ConstraintViolation::getMessage)
                    .collect(Collectors.toList());
            String msg = StringUtils.collectionToDelimitedString(msgs, ", ");
            return error(msg);
        } else {
            return error();
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

    public static R ok(CodeMsg msg) {
        return new R(true, msg.getMsg());
    }

    public static R ok() {
        return new R();
    }

    public static R raise(String msg) throws CommonException {
        throw new CommonException(msg);
    }

    public static R raise(CodeMsg codeMsg) throws CommonException {
        throw new CommonException(codeMsg);
    }
}
