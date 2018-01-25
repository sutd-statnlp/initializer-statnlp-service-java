package com.sutd.statnlp.model;

import java.io.Serializable;

public class Message implements Serializable {

   private String title;
    private String content;


    public String getTitle() {
        return title;
    }

    public Message title(String title) {
        this.title = title;
        return this;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public Message content(String content) {
        this.content = content;
        return this;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Message{" +
                ", title='" + getTitle() + "'" +
                ", content='" + getContent() + "'" +
                "}";
    }
}
