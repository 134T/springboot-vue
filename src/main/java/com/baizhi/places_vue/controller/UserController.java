package com.baizhi.places_vue.controller;

import com.baizhi.places_vue.domain.User;
import com.baizhi.places_vue.service.UserService;
import com.baizhi.places_vue.util.VerifyCode;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: 坚持的力量
 * @Date: 2021/10/7 16:00
 * @Version: 11
 */
@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    private static HashMap hashMap = new HashMap();
    @Resource
    private UserService userService;


    @RequestMapping ("/vercode")
    public void code(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //创建验证码生成器实例取得生成图片和随机字符串
        VerifyCode vc = new VerifyCode();
        BufferedImage image = vc.getImage();
        String text = vc.getText();
        //随机字符串存入session中
        HttpSession session = req.getSession();
        session.setAttribute("index_code",text);
        //用流传输
        VerifyCode.output(image,resp.getOutputStream());
    }

    /**
     * @Description:注册页面
     **/
    @PostMapping(value = "/register")
    public HashMap register(HttpSession session, @RequestBody User user, String vcode){

        String indexCode = (String) session.getAttribute("index_code");
        if (indexCode.equalsIgnoreCase(vcode)) {
            QueryWrapper<User> wrapper = new QueryWrapper<>();
            wrapper.eq("username",user.getUsername());

            if (userService.count(wrapper) > 0){
                hashMap.put("status", false);
                hashMap.put("msg", "该用户已存在");
                return hashMap;
            }
            boolean b = userService.save(user);
            if(b) {
                hashMap.put("status", true);
                hashMap.put("msg", "注册成功");
            }else {
                hashMap.put("status", false);
                hashMap.put("msg", "注册失败");
            }
        } else {
            hashMap.put("status", false);
            hashMap.put("msg", "验证码错误！");
        }

        return hashMap;
    }

    /**
     * @Description:登陆
     **/
    @PostMapping("/login")
    public HashMap login(@RequestBody User user) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username",user.getUsername()).eq("password",user.getPassword());
        if (userService.count(wrapper) > 0) {
            hashMap.put("status", true);
            hashMap.put("msg", "登陆成功");
        } else {
            hashMap.put("status", false);
            hashMap.put("msg", "用户名或密码错误！");
        }
        return hashMap;
    }


}
