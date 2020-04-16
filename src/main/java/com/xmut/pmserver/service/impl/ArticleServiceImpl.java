package com.xmut.pmserver.service.impl;

import com.xmut.pmserver.mapper.ArticleMapper;

import com.xmut.pmserver.pojo.Article;
import com.xmut.pmserver.pojo.ShowArticle;
import com.xmut.pmserver.service.ArticleService;
import com.xmut.pmserver.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired(required = false)
    ArticleMapper articleMapper;

    /*发帖*/
    @Override
    public boolean addArticle(@RequestParam int userid, @RequestParam String title, @RequestParam String content,@RequestParam String img,@RequestParam(required = false) String location) {
        Article article = new Article(userid,title,content,img,0,0, Utils.getDate(),true,location);
        if (articleMapper.addArticle(article) == 1) {
            System.out.println("发帖成功"+article);
            return true;
        }
        return false;
    }

    /*删帖*/
    @Override
    public boolean deleteById(int id) {
        if (articleMapper.deleteById(id)==1) {
            return true;
        }
        return false;
    }

    /*按用户id查询所有文章数*/
    @Override
    public List<Article> getAllByUserId(int userid) {
        return articleMapper.findByUserId(userid);
    }

    /**
     * 指定id查询文章
     * @param id
     * @return
     */
    @Override
    public Article getOneById(int id) {
        return articleMapper.getOne(id);
    }

    @Override
    public List<ShowArticle> showArticles() {
        return articleMapper.getArticles();
    }

    @Override
    public List<ShowArticle> getFollowedArticle(int userId) {
        return articleMapper.getFollowedArticle(userId);
    }

}
