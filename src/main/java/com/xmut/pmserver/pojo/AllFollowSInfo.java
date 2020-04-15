package com.xmut.pmserver.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 查看所有关注者数据实体
 */
@Data
@NoArgsConstructor
public class AllFollowSInfo {
    private int id;
    private String userName;
    private String photo;
    private boolean status;
}
