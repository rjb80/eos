package com.tetra.eos.user.model;

import org.apache.ibatis.type.Alias;

@Alias("com.tetra.eos.user.model.UserVO")
public class UserVO {
    private String userId;
    private String userPw;
    private String userName;
    private boolean useCookie;
     
    public boolean isUseCookie() {
        return useCookie;
    }
     
    public void setUseCookie(boolean useCookie) {
        this.useCookie = useCookie;
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getUserPw() {
        return userPw;
    }
    public void setUserPw(String userPw) {
        this.userPw = userPw;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

}


