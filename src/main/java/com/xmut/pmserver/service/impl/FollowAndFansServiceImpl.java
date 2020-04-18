package com.xmut.pmserver.service.impl;

import com.xmut.pmserver.mapper.FollowAndFansMapper;
import com.xmut.pmserver.pojo.AllFollowSInfo;
import com.xmut.pmserver.pojo.Fans;
import com.xmut.pmserver.pojo.Follow;
import com.xmut.pmserver.service.FollowAndFansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FollowAndFansServiceImpl implements FollowAndFansService {
    @Autowired(required = false)
    FollowAndFansMapper mapper;

    @Override
    public int follow(Follow follow) {
        return mapper.follow(follow);
    }

    @Override
    public int unFollow(Follow follow) {
        return mapper.unFollow(follow);
    }

    @Override
    public int isFollow(int userId, int fId) {
        Object object = mapper.isFollow(userId, fId);
        if (object != null) {
            int temp = ((Boolean) object == true ? 1 : 0);
            return temp;
        }
        return 0;
    }

    @Override
    public int getFollowCount(int userId) {
        return mapper.getFollowCount(userId);
    }

    @Override
    public List<AllFollowSInfo> getAllFollows(int userId) {
        return mapper.getAllFollowInfo(userId);
    }


    /*粉丝*/
    @Override
    public int getFansCount(int fId) {
        return mapper.getFansCount(fId);
    }

    @Override
    public List<AllFollowSInfo> getAllFansInfo(int fId) {
        return mapper.getAllFansInfo(fId);
    }


}
