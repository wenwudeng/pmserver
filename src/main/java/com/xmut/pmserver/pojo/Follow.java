package com.xmut.pmserver.pojo;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Follow {
    private int id;
    private int userId;
    private int fId;
    private boolean status;

    public Follow(int userId, int fId, boolean status) {
        this.userId = userId;
        this.fId = fId;
        this.status = status;
    }
}
