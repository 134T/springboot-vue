package com.baizhi.places_vue.mapper;

import com.baizhi.places_vue.domain.Attractions;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Entity com.baizhi.places_vue.domain.Attractions
 */
@Transactional(rollbackFor = RuntimeException.class)
public interface AttractionsMapper extends BaseMapper<Attractions> {

}




