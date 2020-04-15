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
    public boolean isFollow(int userId, int fId) {
        if (mapper.isFollow(userId, fId) != null) {
            return true;
        }
        return false;
    }

    @Override
    public int getFollowCount(int userId) {
        return mapper.getFollowCount(userId);
    }

    @Override
    public List<AllFollowSInfo> getAllFollows() {
        return mapper.getAllFollowInfo();
    }

    /*粉丝*/
    @Override
    public int fans(Fans fans) {
        return mapper.fans(fans);
    }

    @Override
    public int unFans(Fans fans) {
        return mapper.unFans(fans);
    }

    @Override
    public boolean isFans(int userId, int fId) {
        if (mapper.isFans(userId, fId) != null) {
            return true;
        }
        return false;
    }
}
