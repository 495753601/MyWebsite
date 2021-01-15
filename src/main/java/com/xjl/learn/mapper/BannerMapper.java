package com.xjl.learn.mapper;

import com.xjl.learn.mapper.provider.BannerProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @author: xjl
 * @date: 2020-12-23-9:08
 */
@Mapper
public interface BannerMapper{

    //获取轮播图列表
    @SelectProvider(type = BannerProvider.class, method = "getBannerList")
    public List<Map<String,Object>> getBannerList();
    //修改轮播图信息
    @UpdateProvider(type = BannerProvider.class, method = "updataBannerMsg")
    public void updataBannerMsg(Map<String,Object> pd);
}