package com.shj.po;

import java.util.Date;

public class Comment {
    private int comment_id;
    private String content;
    private Date time;

    private User user;
    private Book book;

    public Comment() {
    }

    public Comment(int comment_id, String content, Date time, User user, Book book) {
        this.comment_id = comment_id;
        this.content = content;
        this.time = time;
        this.user = user;
        this.book = book;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "comment_id=" + comment_id +
                ", content='" + content + '\'' +
                ", time=" + time +
                ", user=" + user +
                ", book=" + book +
                '}';
    }

    public int getComment_id() {
        return comment_id;
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
