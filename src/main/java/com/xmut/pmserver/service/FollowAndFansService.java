package com.xmut.pmserver.service;

import com.xmut.pmserver.pojo.AllFollowSInfo;
import com.xmut.pmserver.pojo.Fans;
import com.xmut.pmserver.pojo.Follow;

import java.util.List;

public interface FollowAndFansService {
    /*关注*/
    int follow(Follow follow);

    int unFollow(Follow follow );

    boolean isFollow(int userId,int fId);

    int getFollowCount(int userId);

    List<AllFollowSInfo> getAllFollows();

    /*粉丝*/
    int fans(Fans fans);

    int unFans(Fans fans);

    boolean isFans(int userId, int fId);

}
