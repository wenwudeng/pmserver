package com.xmut.pmserver.contorller;

import com.xmut.pmserver.pojo.Follow;
import com.xmut.pmserver.wrapper.ResponseWrapper;
import com.xmut.pmserver.service.FollowAndFansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/followAndFans")
public class FollowAndFansController {
    @Autowired
    FollowAndFansService followAndFans;

    @RequestMapping("/follow")
    public ResponseWrapper follow(@RequestParam int userId, @RequestParam int fId) {
        return ResponseWrapper.markCustom(true, "30010", "关注成功", followAndFans.follow(new Follow(userId, fId, true)));
    }

    @RequestMapping("/unFollow")
    public ResponseWrapper unFollow(@RequestParam int userId, @RequestParam int fId) {
        return ResponseWrapper.markCustom(true, "30011", "取消关注", followAndFans.unFollow(new Follow(userId,fId,false)));
    }

    @RequestMapping("isFollow")
    public ResponseWrapper isFollow(@RequestParam int userId, @RequestParam int fId) {
        return ResponseWrapper.markCustom(true, "0000", "查询成功", followAndFans.isFollow(userId, fId));
    }

    @RequestMapping("/getFollows")
    public ResponseWrapper getFollows(@RequestParam int userId) {
        return ResponseWrapper.markCustom(true, "0000", "查询成功", followAndFans.getFollowCount(userId));
    }

    @RequestMapping("/getAllFollowsInfo")
    public ResponseWrapper getAllFollowsInfo(@RequestParam int userId) {
        return ResponseWrapper.markCustom(true, "0000", "查询成功", followAndFans.getAllFollows(userId));
    }

    @RequestMapping("/getFans")
    public ResponseWrapper getFans(@RequestParam int fId) {
        return ResponseWrapper.markCustom(true, "0000", "查询成功", followAndFans.getFansCount(fId));
    }

    @RequestMapping("/getAllFansInfo")
    public ResponseWrapper getAllFansInfo(@RequestParam int fId) {
        return ResponseWrapper.markCustom(true, "0000", "查询成功", followAndFans.getAllFansInfo(fId));
    }



}
