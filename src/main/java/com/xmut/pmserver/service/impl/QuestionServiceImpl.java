package com.xmut.pmserver.service.impl;

import com.xmut.pmserver.mapper.QuestionMapper;
import com.xmut.pmserver.pojo.Question;
import com.xmut.pmserver.service.QuestionService;
import com.xmut.pmserver.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired(required = false)
    QuestionMapper QuestionMapper;

    /*提问*/
    @Override
    public boolean addQuestion(@RequestParam int userid, @RequestParam String title, @RequestParam String content,@RequestParam String img,@RequestParam(required = false) String location) {
        Question Question = new Question(userid,title,content,img,0,0,0,Utils.getDate(),true,location);
        if (QuestionMapper.addquestion(Question) == 1) {
            return true;
        }
        return false;
    }

    /*指定删除问题*/
    @Override
    public boolean deleteById(int id) {
        if (QuestionMapper.deleteById(id)==1) {
            return true;
        }
        return false;
    }

    /*按用户id查询所有提问*/
    @Override
    public List<Question> getAllByUserId(int userid) {
        return QuestionMapper.findByUserId(userid);
    }

    /**
     * 指定id查询问题
     * @param id
     * @return
     */
    @Override
    public Question getOneById(int id) {
        return QuestionMapper.getOne(id);
    }
    
}
