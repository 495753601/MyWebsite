package com.xjl.learn.service;

import com.xjl.learn.mapper.BannerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @author: xjl
 * @date: 2020-12-23-9:08
 */
@Service
public class BannerService {
    @Autowired(required = false)
    private BannerMapper bannerMapper;

    //获取轮播图列表
    public List<Map<String,Object>> getBannerList(){
        return bannerMapper.getBannerList();
    }

    //修改轮播图信息
    public void updataBannerMsg(Map<String,Object> pd){
        bannerMapper.updataBannerMsg(pd);
    }
}
