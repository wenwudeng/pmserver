package com.xmut.pmserver.contorller;

import com.xmut.pmserver.wrapper.ResponseWrapper;
import com.xmut.pmserver.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    QuestionService questionService;

    /*提问*/
    @RequestMapping("/publish")
    public ResponseWrapper publish(@RequestParam("userid") int userid, String title, String content, String img, String location) {
        if (questionService.addQuestion(userid, title, content, img, location)) {
            return ResponseWrapper.markCustom(true, "3008", "提问成功", null);
        }else {
            return ResponseWrapper.markCustom(false, "3009", "提问失败", null);
        }
    }


    /*指定用户id查找所有提问问题*/
    @RequestMapping("/getAll")
    public ResponseWrapper getAllArticles(@RequestParam int userid) {
        return ResponseWrapper.markCustom(true,"0000","查询成功",questionService.getAllByUserId(userid));
    }

    /*指定问题id查找问题*/
    @RequestMapping("/get")
    public ResponseWrapper getArticle(@RequestParam int id) {
        return ResponseWrapper.markCustom(true,"0000","查询成功",questionService.getOneById(id));
    }

    /*删除问题*/
    @RequestMapping("/delete")
    public ResponseWrapper delete(@RequestParam int id) {
        return ResponseWrapper.markCustom(true,"3008","删除成功",questionService.deleteById(id));
    }

    /*宠友互助*/
    @RequestMapping("/getQuestions")
    public ResponseWrapper getAllQuestions() {
        return ResponseWrapper.markCustom(true, "0000", "查询成功", questionService.getQuestions());
    }
}
