package com.baizhi.places_vue.controller;

import com.baizhi.places_vue.domain.Attractions;
import com.baizhi.places_vue.domain.Attractions;
import com.baizhi.places_vue.mapper.AttractionsMapper;
import com.baizhi.places_vue.service.AttractionsService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * @Description:
 * @Author: 坚持的力量
 * @Date: 2021/10/10 15:44
 * @Version: 11
 */
@RestController
@CrossOrigin
@RequestMapping("/attractions")
public class AttractionsController {

    private static HashMap hashMap = new HashMap();
    @Resource
    private AttractionsService attractionsService;
    @Resource
    private AttractionsMapper attractionsMapper;

    /**
     * @Description:获取全部信息
     **/
    @RequestMapping("/getAll")
    public HashMap getAll(Integer currentPage, Integer proviceid){
//        double i = (double)attractionsService.count() / 2;
//        if (currentPage >= (i+1)){
//            currentPage = (int)i;
//        }

        QueryWrapper<Attractions> wrapper = new QueryWrapper<>();
        wrapper.eq("proviceid",proviceid);

        Page<Attractions> attractionsPage = new Page<>(currentPage, 2);
        Page<Attractions> attractionsSelectPage = attractionsMapper.selectPage(attractionsPage, wrapper);

//       获取总页数
        long totalPage = attractionsSelectPage.getPages();
//        当前页数据集合
        List<Attractions> pageRecords = attractionsSelectPage.getRecords();
//        总条数
        long totalNum = attractionsSelectPage.getTotal();

        hashMap.put("totalPage", totalPage);
        hashMap.put("attractions", pageRecords);
        hashMap.put("totalNum", totalNum);

        return hashMap;

    }

    /**
     * @Description:删除景点
     **/
    @RequestMapping("/delAtt")
    public HashMap delAtt(Integer id,Integer currentPage,Integer proviceid){
        boolean b = attractionsService.removeById(id);
        if (b){
            hashMap.put("status",true);
            int siteNum = getSiteNum(proviceid);
            if (siteNum%2 < currentPage){
                hashMap.put("currentPage", currentPage-1);
            }else {
                hashMap.put("currentPage", currentPage);

            }
        }else {
            hashMap.put("status",false);
            hashMap.put("msg", "删除失败！");
        }
        return hashMap;

    }

    /**
     * @Description:通过id获取景点信息
     **/
    @RequestMapping("/getById")
    public HashMap getById(Integer id) {
        Attractions attractions = attractionsService.getById(id);
        if (attractions != null){
            hashMap.put("status",true);
            hashMap.put("attractions",attractions);

        }else {
            hashMap.put("status",false);
            hashMap.put("msg", "删除失败！");
            hashMap.put("msg_update", "获取失败！");

        }
        return hashMap;
    }

    /**
     * @Description:保存修改或添加
     **/
    @PostMapping("/saveEdit")
    public HashMap saveEdit (Attractions attractions, MultipartFile photo) {

        if (photo != null){
            String originalFilename = photo.getOriginalFilename();
            try {
                String pathName = "D:\\idea\\project\\baizhi\\vue2\\src\\main\\resources\\static\\img\\"+originalFilename;
                photo.transferTo(new File(pathName));
                attractions.setPicpath(originalFilename);
                if (attractions.getId() != null){
                    attractionsService.updateById(attractions);
                }else {
                    attractionsService.save(attractions);

                }
                hashMap.put("status",true);
            } catch (IOException e) {
                hashMap.put("status",false);
                hashMap.put("msg", "用户修改失败");
                hashMap.put("msgId", "用户添加失败");
                e.printStackTrace();

            }

        }else {
            attractionsService.updateById(attractions);
            hashMap.put("status",true);
        }
        return hashMap;

    }

    /**
     * @Description:获取总页码
     **/
    @RequestMapping("/getTotalPage")
    public HashMap getTotalPage(Integer proviceid){


        int count = getSiteNum(proviceid);
        int i = count / 2;
        if (count%2 == 0){
            hashMap.put("totalPage", i);
        }else {
            hashMap.put("totalPage", i+1);
        }
        return hashMap;

    }
    /**
     * @Description:获取景点数目
     **/
    private int getSiteNum(Integer proviceid){
        QueryWrapper<Attractions> wrapper = new QueryWrapper<>();
        wrapper.eq("proviceid",proviceid);
        int count = attractionsService.count(wrapper);
        return count;
    }
}
