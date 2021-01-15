package com.xjl.learn.mapper.provider;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

/**
 * @Description:
 * @author: xjl
 * @date: 2020-12-23-9:09
 */
@Slf4j
public class BannerProvider {
    //获取轮播图列表
    public String getBannerList(){

        SQL sql  = new SQL() {
            {
                SELECT("banner_id as bannerId,banner_title as title,banner_url as url,banner_href as href,position")
                        .FROM("banner");
            }
        };
        log.info("[BannerProvider.getBannerList]获取轮播图列表\n" + sql.toString());
        return sql.toString();
    }
    //更新轮播图
    public String updataBannerMsg(Map<String,Object> pd){
        String title = (String) pd.get("title");
        String url = (String) pd.get("url");
        String href = (String) pd.get("href");
        String position = (String) pd.get("position");
        SQL sql = new SQL(){
            {
                UPDATE("banner")
                        .SET("banner_title = #{title}")
                        .SET("banner_url = #{url}")
                        .SET("banner_href = #{href}")
                        .WHERE("position = #{position}");
            }
        };
        return sql.toString();
    }
}
