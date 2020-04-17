package com.xmut.pmserver.service.impl;

import com.xmut.pmserver.mapper.CollectionAndLikeMapper;
import com.xmut.pmserver.pojo.CollectionLike;
import com.xmut.pmserver.service.CollectionAndLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CollectionLikeServiceImpl implements CollectionAndLikeService {
    @Autowired(required = false)
    CollectionAndLikeMapper mapper;

    @Override
    public int support(CollectionLike cLike) {
        return mapper.support(cLike);
    }

    @Override
    public int unSupport(CollectionLike cLike) {
        return mapper.unSupport(cLike);
    }

/*    @Override
    public int collection(CollectionLike cLike) {
        return mapper.collection(cLike) ;
    }*/

    @Override
    public int unCollection(CollectionLike cLike) {
        return mapper.unCollection(cLike);
    }

    @Override
    public CollectionLike getLikeCollectionStatus(int articleId) {
        return mapper.getLikeCollectionStatus(articleId);
    }
}
