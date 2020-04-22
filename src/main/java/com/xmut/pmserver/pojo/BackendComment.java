package com.xmut.pmserver.pojo;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BackendComment {
    private int id;
    private String title;
    private String username;
    private String content;
    private String time;
    private boolean status;
}
