package com.t.jk.common.enhance;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.t.jk.common.util.Streams;
import com.t.jk.pojo.vo.PageVo;
import com.t.jk.pojo.vo.req.page.PageReqVo;

import java.util.List;
import java.util.function.Function;

/**
 * ClassName: MpPage
 * Description: 对Page进行封装
 *
 * @Author agility6
 * @Create 2024/1/31 15:14
 * @Version: 1.0
 */
public class MpPage<T> extends Page<T> {

    private final PageReqVo reqVo;

    public MpPage(PageReqVo reqVo) {
        super(reqVo.getPage(), reqVo.getSize());
        this.reqVo = reqVo;
    }

    /**
     * 抽取公共部分
     * @param data
     * @return
     * @param <N>
     */
    private <N> PageVo<N> commonBuildVo(List<N> data) {
        reqVo.setPage(getCurrent());
        reqVo.setSize(getSize());

        PageVo<N> pageVo = new PageVo<>();
        pageVo.setCount(getTotal());
        pageVo.setPages(getPages());
        pageVo.setData(data);
        return pageVo;
    }

    /**
     * 默认就是Vo对象
     * @return
     */
    public PageVo<T> buildVo() {
        PageVo<T> pageVo = commonBuildVo(getRecords());
        return pageVo;
    }

    /**
     * 查询完成后更新
     * @return
     */
    public <R> PageVo<R> buildVo(Function<T, R> function) {
        PageVo<R> pageVo = commonBuildVo(Streams.map(getRecords(), function));
        return pageVo;
    }

}
