package com.xmut.pmserver.contorller;

import com.xmut.pmserver.pojo.Fans;
import com.xmut.pmserver.pojo.Follow;
import com.xmut.pmserver.result.ResponseWrapper;
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

    /*粉丝*/
    @RequestMapping("/fans")
    public ResponseWrapper fans(@RequestParam int userId, @RequestParam int fId) {
        return ResponseWrapper.markCustom(true, "30010", "回粉成功", followAndFans.fans(new Fans(userId, fId, true)));
    }

    @RequestMapping("/unFans")
    public ResponseWrapper unFans(@RequestParam int userId, @RequestParam int fId) {
        return ResponseWrapper.markCustom(true, "30011", "取消回粉", followAndFans.unFans(new Fans(userId,fId,false)));
    }

    @RequestMapping("isFans")
    public ResponseWrapper isFans(@RequestParam int userId, @RequestParam int fId) {
        return ResponseWrapper.markCustom(true, "0000", "查询成功", followAndFans.isFans(userId, fId));
    }


}
