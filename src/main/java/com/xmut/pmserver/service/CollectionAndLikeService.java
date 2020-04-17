package com.xmut.pmserver.service;

import com.xmut.pmserver.pojo.CollectionLike;

public interface CollectionAndLikeService {
    int support(CollectionLike cLike);

    int unSupport(CollectionLike cLike);

/*    int collection(CollectionLike cLike);*/

    int unCollection(CollectionLike cLike);

    CollectionLike getLikeCollectionStatus(int articleId);
}
