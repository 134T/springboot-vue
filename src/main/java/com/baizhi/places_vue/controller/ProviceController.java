package com.baizhi.places_vue.controller;

import com.baizhi.places_vue.domain.Provice;
import com.baizhi.places_vue.mapper.ProviceMapper;
import com.baizhi.places_vue.service.ProviceService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * @Description:
 * @Author: 坚持的力量
 * @Date: 2021/10/7 22:06
 * @Version: 11
 */
@RestController
@CrossOrigin
@RequestMapping("/province")
public class ProviceController {

    private static HashMap hashMap = new HashMap();
    @Resource
    private ProviceService proviceService;

    @Resource
    private ProviceMapper proviceMapper;

    /**
     * @Description:获取全部信息
     **/
    @RequestMapping("/getAll")
    public HashMap getAll(Integer currentPage){

        Page<Provice> provicePage = new Page<>(currentPage, 2);
        Page<Provice> proviceSelectPage = proviceMapper.selectPage(provicePage, null);

//       获取总页数
        long totalPage = proviceSelectPage.getPages();
//        当前页数据集合
        List<Provice> pageRecords = proviceSelectPage.getRecords();
//        总条数
        long totalNum = proviceSelectPage.getTotal();


        hashMap.put("totalPage", totalPage);
        hashMap.put("provinces", pageRecords);
        hashMap.put("totalNum", totalNum);


        return hashMap;

    }

    /**
     * @Description:增加地名
     **/
    @PostMapping("/addPro")
    public HashMap addPro(@RequestBody Provice provice) {

        QueryWrapper<Provice> wrapper = new QueryWrapper<>();
        wrapper.eq("name",provice.getName());
        if (proviceService.count(wrapper) > 0) {
            hashMap.put("status", false);
            hashMap.put("msg", "该地名已存在！");
        } else {
            if (proviceService.save(provice)) {
                hashMap.put("status", true);
                if (proviceService.count()%2 == 0){
                    hashMap.put("totalPage", proviceService.count()/2);
                }else {
                    hashMap.put("totalPage", proviceService.count()/2+1);
                }
            } else {
                hashMap.put("status", false);
                hashMap.put("msg", "数据保存失败！");
            }
        }
        return hashMap;

    }

    /**
     * @Description:删除地名
     **/
    @RequestMapping("/delProvice")
    public HashMap delProvice(Integer id,Integer currentPage) {

        if (proviceService.removeById(id)){
            hashMap.put("status",true);
            if(proviceService.count()%2 == 0 && currentPage > proviceService.count()/2){
                hashMap.put("currentPage",currentPage-1);
            }else {
                hashMap.put("currentPage",currentPage);
            }
        }else {
            hashMap.put("status",false);
            hashMap.put("msg","删除失败！");
        }
        return hashMap;

    }

    /**
     * @Description:通过id获取地名信息
     **/
    @RequestMapping("/getById")
    public HashMap getById(Integer id) {
        Provice provice = proviceService.getById(id);
        hashMap.put("provice", provice);
        return hashMap;
    }

    /**
     * @Description:修改地名信息
     **/
    @RequestMapping("/updateProvince")
    public HashMap updateProvice(@RequestBody Provice provice){
        boolean b = proviceService.updateById(provice);
        if (b){
            hashMap.put("status", true);
        }else {
            hashMap.put("status", false);
            hashMap.put("msg", "修改失败！");
        }
        return hashMap;

    }
}
