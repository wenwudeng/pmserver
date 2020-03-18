package com.xmut.pmserver.mapper;

import com.xmut.pmserver.pojo.User;
import org.apache.ibatis.jdbc.SQL;

public class UserDynaSqlProvider {

    public String update(User user) {
        return new SQL() {{
            UPDATE("user");
            if (user.getPhoto() != null) {
                SET("photo = #{photo}");
            }
            if (user.getUserName() != null) {
                SET("user_name = #{userName}");
            }
            if (user.getGender() != null) {
                SET("gender = #{gender}");
            }
            if (user.getCity() != null) {
                SET("city = #{city}");
            }
            if (user.getProfile() != null) {
                SET("profile = #{profile}");
            }
            if (user.getPet() != null) {
                SET("pet = #{pet}");
            }
            WHERE("user_id = #{userId}");
        }}.toString();
    }




}
