package com.xmut.pmserver.contorller;

import com.xmut.pmserver.result.ResponseWrapper;
import com.xmut.pmserver.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    ArticleService articleService;

    /*发贴*/
    @RequestMapping("/publish")
    public ResponseWrapper publish(@RequestParam("userid") int userid, String title, String content, String img, String location) {
        if (articleService.addArticle(userid, title, content, img, location)) {
            return ResponseWrapper.markCustom(true, "3006", "发帖成功", null);
        } else {
            return ResponseWrapper.markCustom(false, "3007", "发帖失败", null);
        }
    }


    /*指定用户id查找所有文章*/
    @RequestMapping("/getAllArticle")
    public ResponseWrapper getAllArticles(@RequestParam int userid) {
        return ResponseWrapper.markCustom(true, "0000", "查询成功", articleService.getAllByUserId(userid));
    }

    /*指定文查id找文章*/
    @RequestMapping("/getArticle")
    public ResponseWrapper getArticle(@RequestParam int id) {
        return ResponseWrapper.markCustom(true, "0000", "查询成功", articleService.getOneById(id));
    }

    /*删除文章*/
    @RequestMapping("/delete")
    public ResponseWrapper delete(@RequestParam int id) {
        return ResponseWrapper.markCustom(true, "3008", "删除成功", articleService.deleteById(id));
    }

    /*查询所有文章及作者信息*/
    @RequestMapping("/getArticles")
    public ResponseWrapper getArticles() {
        return ResponseWrapper.markCustom(true, "0000", "查询成功", articleService.showArticles());
    }
}
