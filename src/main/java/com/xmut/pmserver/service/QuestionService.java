package com.xmut.pmserver.service;

import com.xmut.pmserver.pojo.Question;

import java.util.List;

public interface QuestionService {
    /**
     * 提问
     * @param userid 用户id
     * @param title 文章标题
     * @param content 文章内容
     * @param img   文章图片url地址
     * @param location 定位
     */
    boolean addQuestion(int userid, String title, String content, String img, String location);


    /**
     * 指定id删除提问
     * @param id
     * @return
     */
    boolean deleteById(int id);

    /**
     * 按用户id查询所有问题
     * @param userid 用户id
     * @return 返回用户所有文章集合
     */
    List<Question> getAllByUserId(int userid);

    /**
     * 指定提问id查找提问
     * @param id
     * @return
     */
    Question getOneById(int id);
}
