package com.t.jk.pojo.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * ClassName: DataJsonVo
 * Description:
 *
 * @Author agility6
 * @Create 2024/2/18 23:43
 * @Version: 1.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class DataJsonVo<T> extends JsonVo {

    private T data;

    public DataJsonVo() {}

    public DataJsonVo(String msg, T data) {
        super(true, msg);
        this.data = data;
    }

    public DataJsonVo(T data) {
       this(null, data);
    }
}
