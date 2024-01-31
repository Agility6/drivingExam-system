package com.t.jk.common.exception;

import com.t.jk.common.util.Rs;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ClassName: ExceptionInterceptor
 * Description:
 *
 * @Author agility6
 * @Create 2024/1/31 17:25
 * @Version: 1.0
 */
@ControllerAdvice
public class ExceptionInterceptor {

    @ExceptionHandler(Throwable.class)
    public void handle(Throwable t,
                       HttpServletRequest request,
                       HttpServletResponse response) throws Exception {

        response.setStatus(400);
        response.getWriter().write(Rs.error(t).json());
    }

}
