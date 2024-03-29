package com.t.jk.common.util;

import com.t.jk.common.exception.CommonException;
import com.t.jk.pojo.vo.DataJsonVo;
import com.t.jk.pojo.vo.JsonVo;
import com.t.jk.pojo.result.CodeMsg;
import com.t.jk.pojo.vo.PageJsonVo;
import com.t.jk.pojo.vo.PageVo;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ClassName: JsonVos
 * Description: 封装返回
 *
 * @Author agility6
 * @Create 2024/1/31 16:56
 * @Version: 1.0
 */
public class JsonVos {

    public static JsonVo error(String msg) {
        return new JsonVo(false, msg);
    }

    public static JsonVo error() {
        return new JsonVo(false);
    }

    public static JsonVo error(Throwable t) {
        // 如果错误类型是CommonException
        if (t instanceof CommonException) {
            CommonException ce = (CommonException) t;
            return new JsonVo(ce.getCode(), ce.getMessage());
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

    public static JsonVo ok(CodeMsg msg) {
        return new JsonVo(msg);
    }

    public static JsonVo ok(String msg) {
        return new JsonVo(true, msg);
    }

    public static <T>DataJsonVo<T> ok(T data) {
        return new DataJsonVo<>(data);
    }

    public static <T> PageJsonVo<T> ok(PageVo<T> pageVo) {
        PageJsonVo<T> pageJsonVo = new PageJsonVo<>();
        pageJsonVo.setCount(pageVo.getCount());
        pageJsonVo.setData(pageVo.getData());
        return pageJsonVo;
    }

    public static JsonVo ok() {
        return new JsonVo();
    }

    public static <T> T raise(String msg) throws CommonException {
        throw new CommonException(msg);
    }

    public static <T> T raise(CodeMsg codeMsg) throws CommonException {
        throw new CommonException(codeMsg);
    }
}
