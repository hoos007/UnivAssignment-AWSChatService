package com.hoos007.project.onlinekaraoke.DO;

import org.springframework.stereotype.Repository;

@Repository
public class CreateRoomDO {
    private String userid;

    public CreateRoomDO() {

    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
}
