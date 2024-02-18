package com.t.jk.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.t.jk.common.enhance.MpPage;
import com.t.jk.common.enhance.MpQueryWrapper;
import com.t.jk.common.mapStruct.MapStructs;
import com.t.jk.mapper.DictItemMapper;
import com.t.jk.pojo.po.DictItem;
import com.t.jk.pojo.vo.PageVo;
import com.t.jk.pojo.vo.list.DictItemVo;
import com.t.jk.pojo.vo.req.page.DictItemPageReqVo;
import com.t.jk.service.DictItemService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("dictItemService")
@Transactional
public class DictItemServiceImpl extends ServiceImpl<DictItemMapper, DictItem> implements DictItemService {

    @Override
    @Transactional(readOnly = true)
    public PageVo<DictItemVo> list(DictItemPageReqVo query) {
        // 查询
        MpQueryWrapper<DictItem> wrapper = new MpQueryWrapper<>();
        wrapper.like(query.getKeyword(), DictItem::getName, DictItem::getValue);
        Integer typeId = query.getTypeId();
        if (typeId != null && typeId > 0) {
            wrapper.eq(DictItem::getTypeId, typeId);
        }

        wrapper.orderByDesc(DictItem::getId);

        return baseMapper
                .selectPage(new MpPage<>(query), wrapper)
                .buildVo(MapStructs.INSTANCE::po2vo);

    }
}

