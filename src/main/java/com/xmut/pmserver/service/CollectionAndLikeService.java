package com.xmut.pmserver.service;

import com.xmut.pmserver.pojo.BeSupportInfo;
import com.xmut.pmserver.pojo.CollectionLike;
import com.xmut.pmserver.pojo.UserCollections;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CollectionAndLikeService {
    int support(CollectionLike cLike);

    int unSupport(CollectionLike cLike);

/*    int collection(CollectionLike cLike);*/

    int unCollection(CollectionLike cLike);

    CollectionLike getLikeCollectionStatus(int articleId);


    int getCollectionByUserId(int userId);

    /*查询获赞列表及文章信息*/
    List<BeSupportInfo> getBeSupportInfo(int oId);

    /*指定用户id查询当前用户收藏的文章列表信息*/
    List<UserCollections> getUserCollections(int userId);
}
