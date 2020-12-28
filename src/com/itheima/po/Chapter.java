package com.itheima.po;

public class Chapter {
    private int chapter_id;
    private String chaptername;
    private String content;

    private Book book;

    public Chapter() {
    }

    public Chapter(String chaptername, String content, Book book) {
        this.chaptername = chaptername;
        this.content = content;
        this.book = book;
    }

    public Chapter(int chapter_id, String chaptername, String content, Book book) {
        this.chapter_id = chapter_id;
        this.chaptername = chaptername;
        this.content = content;
        this.book = book;
    }

    @Override
    public String toString() {
        return "Chapter{" +
                "chapter_id=" + chapter_id +
                ", chaptername='" + chaptername + '\'' +
                ", content='" + content + '\'' +
                ", book=" + book +
                '}';
    }

    public int getChapter_id() {
        return chapter_id;
    }

    public void setChapter_id(int chapter_id) {
        this.chapter_id = chapter_id;
    }

    public String getChaptername() {
        return chaptername;
    }

    public void setChaptername(String chaptername) {
        this.chaptername = chaptername;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
