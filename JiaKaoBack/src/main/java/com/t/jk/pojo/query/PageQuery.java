package com.t.jk.pojo.query;

import lombok.Data;

import java.util.List;

/**
 * ClassName: PageQuery
 * Description:
 *
 * @Author agility6
 * @Create 2024/1/31 14:59
 * @Version: 1.0
 */

@Data
public class PageQuery {

    private static final int DEFAULT_SIZE = 10;

    private long page;
    private long size;

    /**
     * 当前页的数据
     */
    private List<?> data;

    /**
     * 总数
     */
    private long count;
    /**
     * 总页数
     */
    private long pages;

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
