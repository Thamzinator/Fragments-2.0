package com.example.tcssi.fragments.Discussion;

import java.util.Date;

public class BlogPost extends BlogPostId{

    public String desc, header, user_id;
    public Date timestamp;


    public BlogPost(){}

    public BlogPost(String desc, String header, String user_id, Date timestamp) {
        this.desc = desc;
        this.header = header;
        this.user_id = user_id;
        this.timestamp = timestamp;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public Date getTimestamp() {

        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

}
