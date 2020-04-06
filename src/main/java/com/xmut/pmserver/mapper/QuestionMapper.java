package com.xmut.pmserver.mapper;

import com.xmut.pmserver.pojo.Question;
import com.xmut.pmserver.pojo.QuestionHelp;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface QuestionMapper {

    /**
     * 提问
     * @param question
     */
    @Insert("insert into question values (null,#{question.userid},#{question.title},#{question.content}," +
            "#{question.img},#{question.location},#{question.like},#{question.collect},#{question.answer},#{question.time},#{question.status})")
    int addquestion(@Param("question") Question question);


    /*删除问题*/
    @Delete("delete from question where id = #{id}")
    int deleteById(@Param("id") int id);

    /*按用户id查找所有提问*/
    @Select("select * from question where userid = #{userid}")
    List<Question> findByUserId(@Param("userid") int userid);

    /*指定id查询问题*/
    @Select("select * from question where id = #{id}")
    Question getOne(@Param("id") int id);


    /*查询所有问题及用户头像、用户名*/
    @Select("select q.id qId,q.userid uId,q.title,q.content,q.img,q.location,\n" +
            "\t\t\t\t\t\tq.like,q.answer,q.time,u.photo,u.user_name userNam \n" +
            "\t\t\t\t\t\t\t\tfrom question q,user u \n" +
            "\t\t\t\t\t\t\t\t\t\twhere q.userid = u.id;")
    List<QuestionHelp> getQuestions();

}
