package com.baizhi.places_vue.mapper;

import com.baizhi.places_vue.domain.Provice;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Entity com.baizhi.places_vue.domain.Provice
 */
@Transactional(rollbackFor = RuntimeException.class)
public interface ProviceMapper extends BaseMapper<Provice> {

}




