package com.itheima.po;

import java.util.List;

public class Book {
	private int book_id;
	private String bookname;
	private String image;
	private String blurb;

	private Type type;
	private List<User> user;
	private List<Comment> comment;
	private List<Chapter> chapter;

    public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

    public Book(String bookname, String image, String blurb, Type type, List<User> user) {
        this.bookname = bookname;
        this.image = image;
        this.blurb = blurb;
        this.type = type;
        this.user = user;
    }

    public Book(int book_id, String bookname, String image, String blurb, Type type, List<User> user, List<Comment> comment, List<Chapter> chapter) {
        this.book_id = book_id;
        this.bookname = bookname;
        this.image = image;
        this.blurb = blurb;
        this.type = type;
        this.user = user;
        this.comment = comment;
        this.chapter = chapter;
    }

    @Override
    public String toString() {
        return "Book{" +
                "book_id=" + book_id +
                ", bookname='" + bookname + '\'' +
                ", image='" + image + '\'' +
                ", blurb='" + blurb + '\'' +
                ", type=" + type +
                ", user=" + user +
                ", comment=" + comment +
                ", chapter=" + chapter +
                '}';
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBlurb() {
        return blurb;
    }

    public void setBlurb(String blurb) {
        this.blurb = blurb;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }

    public List<Comment> getComment() {
        return comment;
    }

    public void setComment(List<Comment> comment) {
        this.comment = comment;
    }

    public List<Chapter> getChapter() {
        return chapter;
    }

    public void setChapter(List<Chapter> chapter) {
        this.chapter = chapter;
    }
}
