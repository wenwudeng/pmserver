package com.xmut.pmserver.service;

import com.xmut.pmserver.pojo.ShowArticle;
import com.xmut.pmserver.pojo.User;
import com.xmut.pmserver.pojo.BackendComment;

import java.util.List;

public interface AdminService {

    List<User> getAllUsers();

    List<User> unclearSearch(String value);

    int reset(String password,String name);

    /*文章*/
    List<ShowArticle> getArticles(String title,String name);

    /*评论*/
    List<BackendComment> getComments(String name, String title, String content);
}
