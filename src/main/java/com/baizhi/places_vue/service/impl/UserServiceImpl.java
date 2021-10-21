package com.baizhi.places_vue.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baizhi.places_vue.domain.User;
import com.baizhi.places_vue.service.UserService;
import com.baizhi.places_vue.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author asus
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
implements UserService{

}




