package com.xmut.pmserver.contorller;

import com.xmut.pmserver.pojo.Article;
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
        }else {
            return ResponseWrapper.markCustom(false, "3007", "发帖失败", null);
        }
    }


    /*根据用户id查找所有文章*/
    @RequestMapping("/getAllArticle")
    public ResponseWrapper getAllArtcles(@RequestParam int userid) {
        return ResponseWrapper.markCustom(true,"0000","查询成功",articleService.getAllByUserId(userid));
    }

}
