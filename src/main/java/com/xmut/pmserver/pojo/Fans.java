package com.xmut.pmserver.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Fans {
        private int id;
        private int userId;
        private int fId;
        private boolean status;

        public Fans(int userId, int fId, boolean status) {
                this.userId = userId;
                this.fId = fId;
                this.status = status;
        }
}
