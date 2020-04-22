package com.xmut.pmserver.service.impl;

import com.xmut.pmserver.mapper.AdminMapper;
import com.xmut.pmserver.pojo.ShowArticle;
import com.xmut.pmserver.pojo.User;
import com.xmut.pmserver.pojo.BackendComment;
import com.xmut.pmserver.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired(required = false)
    AdminMapper mapper;

    @Override
    public List<User> getAllUsers() {
        return  mapper.getAllUsers();
    }

    @Override
    public List<User> unclearSearch(String value) {
        return mapper.unclearSearch(value);
    }

    @Override
    public int reset(String password,String name) {
        return mapper.reset(password, name);
    }

    @Override
    public List<ShowArticle> getArticles(String title, String name) {
        return mapper.getArticles(title,name);
    }

    @Override
    public List<BackendComment> getComments(String name, String title, String content) {
        return mapper.getComments(name,title,content);
    }


}
