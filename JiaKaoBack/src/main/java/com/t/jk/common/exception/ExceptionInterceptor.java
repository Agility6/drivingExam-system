package com.t.jk.common.exception;

import com.t.jk.common.util.JsonVos;
import com.t.jk.pojo.vo.JsonVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * ClassName: ExceptionInterceptor
 * Description:
 *
 * @Author agility6
 * @Create 2024/1/31 17:25
 * @Version: 1.0
 */
//@ControllerAdvice
@RestControllerAdvice // 因为要将R当作返回值返回出去
@Slf4j
public class ExceptionInterceptor {

    @ExceptionHandler(Throwable.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public JsonVo handle(Throwable t)  {
        log.error("null", t);
        return JsonVos.error(t);
    }

//    @ExceptionHandler(Throwable.class)
//    public void handle(Throwable t,
//                       HttpServletRequest request,
//                       HttpServletResponse response) throws Exception {
//
//        // 设置返回数据
////        response.setContentType("application/json; charset=UTF-8");
//        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
//        // 需要单独设置编码格式
//        response.setCharacterEncoding(StandardCharsets.UTF_8.displayName());
//
//        response.setStatus(400);
//        response.getWriter().write(Rs.error(t).jsonString());
//        // 如果是DEBUG阶段执行
//        Debugs.run(t::printStackTrace);
//    }

}
