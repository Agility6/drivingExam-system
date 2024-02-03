package com.t.jk.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import com.t.jk.common.exception.CommonException;
import com.t.jk.common.util.Rs;
import com.t.jk.pojo.result.CodeMsg;
import com.t.jk.pojo.result.R;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;

/**
 * ClassName: BaseController
 * Description:
 *
 * @Author agility6
 * @Create 2024/1/31 22:49
 * @Version: 1.0
 */
public abstract class BaseController<T> {

    protected abstract IService<T> getService();

    @PostMapping("/remove")
    public R remove(String id) {
        if (getService().removeByIds(Arrays.asList(id.split(",")))) {
            return Rs.ok(CodeMsg.REMOVE_OK);
        } else {
            return Rs.raise(CodeMsg.REMOVE_ERROR);
        }
    }

    @PostMapping("/save")
    public R save(T entity) {
        if (getService().saveOrUpdate(entity)) {
            return Rs.ok(CodeMsg.SAVE_OK);
        } else {
            return Rs.raise(CodeMsg.SAVE_ERROR);
        }
    }
}
