package com.xmut.pmserver.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class CommentList {
    private int total;
    private List<CommentItem> list;
}
