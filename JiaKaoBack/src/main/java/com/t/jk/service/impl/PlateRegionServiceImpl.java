package com.t.jk.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.promeg.pinyinhelper.Pinyin;
import com.t.jk.common.enhance.MpPage;
import com.t.jk.common.enhance.MpQueryWrapper;
import com.t.jk.mapper.PlateRegionMapper;
import com.t.jk.pojo.dto.ProvinceDto;
import com.t.jk.pojo.po.PlateRegion;
import com.t.jk.pojo.query.CityQuery;
import com.t.jk.pojo.query.ProvinceQuery;
import com.t.jk.service.PlateRegionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("plateRegionService")
@Transactional
public class PlateRegionServiceImpl extends ServiceImpl<PlateRegionMapper, PlateRegion> implements PlateRegionService {

    /**
     * 实现添加或更新省份的增加拼音
     * 拦截save和updateByid方法
     */
    @Override
    public boolean save(PlateRegion entity) {
        processPinyin(entity);
        return super.save(entity);
    }

    @Override
    public boolean updateById(PlateRegion entity) {
        processPinyin(entity);
        return super.updateById(entity);
    }

    /**
     * 处理拼音
     * @param region
     */
    private void processPinyin(PlateRegion region) {
        String name = region.getName();
        if (name == null) return;

        region.setPinyin(Pinyin.toPinyin(name, "_"));
    }

    @Override
    @Transactional(readOnly = true)
    public void listProvinces(ProvinceQuery query) {

        MpQueryWrapper<PlateRegion> wrapper = new MpQueryWrapper<>();

        /**
         * 只需要查找名称、车牌、拼音
         */
        wrapper.like(query.getKeyword(),
                PlateRegion::getName,
                PlateRegion::getPlate,
                PlateRegion::getPinyin);

        // 查找省份的parent_id默认为0
        wrapper.eq(PlateRegion::getParentId, 0);

        wrapper.orderByDesc(PlateRegion::getId);

        baseMapper.selectPage(new MpPage<>(query), wrapper).updateQuery();
    }

    @Override
    @Transactional(readOnly = true)
    public void listCities(CityQuery query) {

        MpQueryWrapper<PlateRegion> wrapper = new MpQueryWrapper<>();

        wrapper.like(query.getKeyword(),
                PlateRegion::getName,
                PlateRegion::getPlate,
                PlateRegion::getPinyin);

        Integer parentId = query.getParentId();
        // 判断传入的省份id是否是合法的
        if (parentId != null &&  parentId > 0) {
            wrapper.eq(PlateRegion::getParentId, parentId);
        } else {
            // 否则查询所有的
            wrapper.ne(PlateRegion::getParentId, 0); // parentId不等于0
        }

        wrapper.orderByDesc(PlateRegion::getId);

        baseMapper.selectPage(new MpPage<>(query), wrapper).updateQuery();
    }

    @Override
    @Transactional(readOnly = true)
    public List<PlateRegion> listProvinces() {

        MpQueryWrapper<PlateRegion> wrapper = new MpQueryWrapper<>();
        wrapper.eq(PlateRegion::getParentId, 0);
        //  按照拼音排序
        wrapper.orderByAsc(PlateRegion::getPinyin);
        return baseMapper.selectList(wrapper);
    }

    @Override
    public List<ProvinceDto> listRegions() {
        /**
         * 返回所有省份和城市，树状结构
         * 可以将所有数据查询出来然后在业务层进行处理
         * 或者在dao层进行处理自定义查询
         */
        return baseMapper.selectRegions();
    }
}

