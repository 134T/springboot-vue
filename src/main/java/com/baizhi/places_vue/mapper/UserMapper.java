package com.baizhi.places_vue.mapper;

import com.baizhi.places_vue.domain.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Entity com.baizhi.places_vue.domain.User
 */
@Transactional(rollbackFor = RuntimeException.class)
public interface UserMapper extends BaseMapper<User> {

}




