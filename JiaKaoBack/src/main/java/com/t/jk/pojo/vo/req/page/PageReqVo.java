package com.t.jk.pojo.vo.req.page;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * ClassName: PageReqVo
 * Description:
 *
 * @Author agility6
 * @Create 2024/1/31 14:59
 * @Version: 1.0
 */

@Data
public class PageReqVo {

    private static final int DEFAULT_SIZE = 10;

    @ApiModelProperty("页码")
    private long page;
    @ApiModelProperty("每页的大小")
    private long size;

    /**
     * page最小取1
     * @return
     */
    public long getPage() {
        return Math.max(page, 1);
    }

    /**
     * size最小取1
     * @return
     */
    public long getSize() {
        return size < 1 ? DEFAULT_SIZE : size;
    }
}
