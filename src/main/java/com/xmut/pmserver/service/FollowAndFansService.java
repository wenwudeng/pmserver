package com.xmut.pmserver.service;

import com.xmut.pmserver.pojo.AllFollowSInfo;
import com.xmut.pmserver.pojo.Fans;
import com.xmut.pmserver.pojo.Follow;

import java.util.List;

public interface FollowAndFansService {
    /*关注*/
    int follow(Follow follow);

    int unFollow(Follow follow );

    int isFollow(int userId,int fId);

    int getFollowCount(int userId);

    List<AllFollowSInfo> getAllFollows(int userId);

    /*粉丝*/
    int getFansCount(int fId);

    /*粉丝信息*/
    List<AllFollowSInfo> getAllFansInfo(int fId);

}
