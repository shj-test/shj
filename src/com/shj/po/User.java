package com.shj.po;

import java.util.List;

public class User {
	private Integer user_id;
	private String username;
	private String password;
	private String nickname;
	private String pseudonym;
	private String status;

	private List<User> user;
	private List<Book> book;
	private List<Account> account;
	private List<Comment> comment;

    public User() {
    }

    public User(Integer user_id, String username, String password, String nickname, String pseudonym) {
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.pseudonym = pseudonym;
    }

    public User(String username, String password, String nickname, String pseudonym) {
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.pseudonym = pseudonym;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(Integer user_id, String username, String password, String nickname, String pseudonym, String status, List<User> user, List<Book> book, List<Account> account, List<Comment> comment) {
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.pseudonym = pseudonym;
        this.status = status;
        this.user = user;
        this.book = book;
        this.account = account;
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", pseudonym='" + pseudonym + '\'' +
                ", status='" + status + '\'' +
                ", user=" + user +
                ", book=" + book +
                ", account=" + account +
                ", comment=" + comment +
                '}';
    }

    public Integer getUser_id() {
        return user_id;
    }

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPseudonym() {
        return pseudonym;
    }

    public void setPseudonym(String pseudonym) {
        this.pseudonym = pseudonym;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Book> getBook() {
        return book;
    }

    public void setBook(List<Book> book) {
        this.book = book;
    }

    public List<Account> getAccount() {
        return account;
    }

    public void setAccount(List<Account> account) {
        this.account = account;
    }

    public List<Comment> getComment() {
        return comment;
    }

    public void setComment(List<Comment> comment) {
        this.comment = comment;
    }
}
