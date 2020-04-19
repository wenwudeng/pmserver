package com.xmut.pmserver.contorller;


import com.xmut.pmserver.pojo.CollectionLike;
import com.xmut.pmserver.result.ResponseWrapper;
import com.xmut.pmserver.service.CollectionAndLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cLike")
public class CollectionAndLikeController {
    @Autowired
    CollectionAndLikeService service;

    @RequestMapping("/support")
    public ResponseWrapper support(@RequestParam int userId,@RequestParam int articleId,@RequestParam int oId) {
        return ResponseWrapper.markCustom(true, "30012", "支持", service.support(new CollectionLike(userId, articleId, oId, true)));
    }

    @RequestMapping("/unSupport")
    public ResponseWrapper unSupport(@RequestParam int userId,@RequestParam int articleId,@RequestParam int oId) {
        return ResponseWrapper.markCustom(true, "30012", "不支持", service.unSupport(new CollectionLike(userId, articleId, oId, false)));
    }

/*    @RequestMapping("/collection")
    public ResponseWrapper collection(@RequestParam int userId,@RequestParam int articleId,@RequestParam int oId) {
        return ResponseWrapper.markCustom(true, "30013", "收藏", service.collection(new CollectionLike(userId, articleId,true,oId)));
    }*/

    @RequestMapping("/unCollection")
    public ResponseWrapper unCollection(@RequestParam int userId,@RequestParam int articleId,@RequestParam int oId) {
        return ResponseWrapper.markCustom(true, "30013", "取消收藏", service.unCollection(new CollectionLike(userId, articleId,false,oId)));
    }

    @RequestMapping("/geLCollection")
    public ResponseWrapper geLCollection(@RequestParam int articleId) {
        return ResponseWrapper.markCustom(true, "0000", "收藏信息", service.getLikeCollectionStatus(articleId));
    }

    /*指定用户id获取获赞数*/
    @RequestMapping("/getSupport")
    public ResponseWrapper getSupport(@RequestParam int userId) {
        return ResponseWrapper.markCustom(true, "0000", "查询成功", service.getCollectionByUserId(userId));
    }


    /*查询获赞列表及文章信息*/
    @RequestMapping("/getSupportInfo")
    public ResponseWrapper getSupportInfos(@RequestParam int oId) {
        return ResponseWrapper.markCustom(true, "0000", "查询成功", service.getBeSupportInfo(oId));
    }


    /*查询获赞列表及文章信息*/
    @RequestMapping("/getCollection")
    public ResponseWrapper getCollectionInfos(@RequestParam int userId) {
        return ResponseWrapper.markCustom(true, "0000", "查询成功", service.getUserCollections(userId));
    }

}
