package com.xmut.pmserver.service;

import com.xmut.pmserver.pojo.Article;

import java.util.List;

public interface ArticleService {
    /**
     * 增加文章
     * @param userid 用户id
     * @param title 文章标题
     * @param content 文章内容
     * @param img   文章图片url地址
     * @param location 定位
     */
    boolean addArticle(int userid, String title, String content, String img, String location);

    /**
     * 按用户id查询所有文章
     * @param userid 用户id
     * @return 返回用户所有文章集合
     */
    List<Article> getAllByUserId(int userid);
}
