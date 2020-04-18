package com.xmut.pmserver.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class CollectionLike {
    private int id;
    private int userId;
    private int articleId;
    private int oId;
    private boolean support;
    private boolean collection;
    private int supportCount;
    private int collectionCount;

    public CollectionLike(int userId,int articleId, int oId, boolean support, boolean collection) {
        this.oId = oId;
        this.userId = userId;
        this.articleId = articleId;
        this.support = support;
        this.collection = collection;
    }

    public CollectionLike(int userId, int articleId, int oId, boolean support) {
        this.userId = userId;
        this.articleId = articleId;
        this.oId = oId;
        this.support = support;
    }

    public CollectionLike(int userId, int articleId,boolean collection, int oId) {
        this.userId = userId;
        this.articleId = articleId;
        this.oId = oId;
        this.collection = collection;
    }


}
