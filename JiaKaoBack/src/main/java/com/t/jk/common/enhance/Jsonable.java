package com.t.jk.common.enhance;

import com.fasterxml.jackson.annotation.JsonInclude;
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

    /**
     * 保证不会包含空的数据
     * @return
     * @throws Exception
     */
    default String jsonString () throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setDefaultPropertyInclusion(JsonInclude.Include.NON_NULL);
        return mapper.writeValueAsString(this);
    }
}
