package com.shj.po;

import java.util.List;

public class Type {
    private int type_id;
    private String typename;

    private List<Book> book;

    public Type() {
    }

    public Type(String typename) {
        this.typename = typename;
    }

    public Type(int type_id, String typename, List<Book> book) {
        this.type_id = type_id;
        this.typename = typename;
        this.book = book;
    }

    @Override
    public String toString() {
        return "Type{" +
                "type_id=" + type_id +
                ", typename='" + typename + '\'' +
                ", book=" + book +
                '}';
    }

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public List<Book> getBook() {
        return book;
    }

    public void setBook(List<Book> book) {
        this.book = book;
    }
}
