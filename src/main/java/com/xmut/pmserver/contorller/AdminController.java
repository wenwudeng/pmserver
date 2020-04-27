package com.xmut.pmserver.contorller;

import com.xmut.pmserver.pojo.BackendComment;
import com.xmut.pmserver.pojo.ShowArticle;
import com.xmut.pmserver.pojo.User;
import com.xmut.pmserver.wrapper.ResponseWrapperForBack;
import com.xmut.pmserver.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminService service;

    private   List<User> returnList;

    /*用户管理*/
    @RequestMapping("/user")
    public ResponseWrapperForBack user(@RequestParam(value = "page", defaultValue = "1") int page,
                                       @RequestParam(value = "limit", defaultValue = "10") int size) {
        List<User> userList = service.getAllUsers();
         returnList= new ArrayList<>();
        final int[] i = {0};
        userList.forEach(User -> {
            if (i[0] > (page - 1) * size - 1 && i[0] < page * size) {
                returnList.add(User);
            }
            i[0]++;
        });
        return ResponseWrapperForBack.markSuccess(returnList.size(),userList);
    }

    @RequestMapping("/vague")
    public ResponseWrapperForBack vagueSearch(@RequestParam(value = "value") String value,@RequestParam(value = "page", defaultValue = "1") int page,
                                              @RequestParam(value = "limit", defaultValue = "10") int size) {
        List<User> userList = service.unclearSearch(value);
        returnList= new ArrayList<>();
        final int[] i = {0};
        userList.forEach(User -> {
            if (i[0] > (page - 1) * size - 1 && i[0] < page * size) {
                returnList.add(User);
            }
            i[0]++;
        });
        return ResponseWrapperForBack.markSuccess(returnList.size(),userList);
    }

/*    @RequestMapping("/reset")
    public ResponseWrapper reset(@RequestParam String password,@RequestParam String name) {
        return ResponseWrapper.markSuccess(service.reset(password,name));
    }*/


    /*文章*/
    @CrossOrigin
    @RequestMapping("/getArticles")
    public ResponseWrapperForBack getArticleInfo(@RequestParam(value = "name", defaultValue = "") String name,
                                              @RequestParam(value = "title", defaultValue = "") String title,
                                              @RequestParam(value = "page", defaultValue = "1") int page,
                                              @RequestParam(value = "limit", defaultValue = "10") int size) {
        List<ShowArticle> articles = service.getArticles(title,name);
        List<ShowArticle> list = new ArrayList<>();
        final int[] i = {0};
        articles.forEach( ShowArticle-> {
            if (i[0] > ((page - 1) * size - 1) && i[0] < (page * size)) {
                list.add(ShowArticle);
            }
            i[0]++;
        });
        return ResponseWrapperForBack.markSuccess(articles.size(),list);
    }



    @RequestMapping("/getComments")
    public ResponseWrapperForBack getArticleComment(@RequestParam(value = "title", defaultValue = "") String title,
                                                 @RequestParam(value = "name", defaultValue = "") String username,
                                                 @RequestParam(value = "text", defaultValue = "") String text,
                                                 @RequestParam(value = "page", defaultValue = "1") int page,
                                                 @RequestParam(value = "limit", defaultValue = "10") int size) {
        List<BackendComment> commentList = service.getComments(username, title,text);
        List<BackendComment> returnlist = new ArrayList<>();
        final int[] i = {0};
        commentList.forEach(adminComment -> {
            if (i[0] > ((page - 1) * size - 1) && i[0] < (page * size)) {
                returnlist.add(adminComment);
            }
            i[0]++;
        });
        return ResponseWrapperForBack.markSuccess(commentList.size(), returnlist);
    }

}
