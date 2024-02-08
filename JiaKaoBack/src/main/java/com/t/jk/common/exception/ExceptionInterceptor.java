package com.t.jk.common.exception;

import com.t.jk.common.util.Debugs;
import com.t.jk.common.util.Rs;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.management.MemoryType;
import java.nio.charset.StandardCharsets;

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

        // 设置返回数据
//        response.setContentType("application/json; charset=UTF-8");
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        // 需要单独设置编码格式
        response.setCharacterEncoding(StandardCharsets.UTF_8.displayName());

        response.setStatus(400);
        response.getWriter().write(Rs.error(t).jsonString());
        // 如果是DEBUG阶段执行
        Debugs.run(t::printStackTrace);
    }

}
