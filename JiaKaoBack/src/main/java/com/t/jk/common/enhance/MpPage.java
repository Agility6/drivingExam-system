package com.t.jk.common.enhance;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.t.jk.pojo.query.PageQuery;

/**
 * ClassName: MpPage
 * Description: 对Page进行封装
 *
 * @Author agility6
 * @Create 2024/1/31 15:14
 * @Version: 1.0
 */
public class MpPage<T> extends Page<T> {
    public MpPage(PageQuery query) {
        super(query.getPage(), query.getSize());
    }

    /**
     * 查询完成后更新
     * @param query
     */
    public void updateQuery(PageQuery query) {
        // 填充结果
        query.setCount(getTotal());
        query.setPages(getPages());
        query.setData(getRecords());
        // 客户端传递值可能不规范myBatisPlus会纠正
        query.setPage(getCurrent());
        query.setSize(getSize());
    }

}
