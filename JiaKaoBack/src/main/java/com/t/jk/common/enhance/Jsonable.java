package com.t.jk.common.enhance;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * ClassName: Jsonable
 * Description: 将数据返回JSON
 *
 * @Author agility6
 * @Create 2024/1/31 17:33
 * @Version: 1.0
 */
public interface Jsonable {
    default String json() throws Exception {
        return new ObjectMapper().writeValueAsString(this);
    }
}
