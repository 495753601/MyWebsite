package com.xjl.learn.controller;

import com.xjl.learn.entity.R;
import com.xjl.learn.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Description:
 * @author: xjl
 * @date: 2020-12-23-9:07
 */
@RestController
public class BannerController {

    @Autowired
    private BannerService bannerService;
    //获取轮播图列表
    @PostMapping("/common/getBannerList")
    public R getBannerList(){
        return R.ok().put("list",bannerService.getBannerList());
    }
    //修改图片信息
    @PostMapping("/common/updataBannerMsg")
    public R updataBannerMsg(@RequestBody Map<String,Object> pd){
        bannerService.updataBannerMsg(pd);
        return R.ok();
    }
}
