package com.example.design.model;

/**
 * Created by Administrator on 2018/1/31.
 */

public class User {
    private int portrait;
    private String name;
    private String desc;
    private int type;
    public static final int TYPE_STATE = 1;
    public static final int TYPE_HUMAN = 2;

    public User(int portrait, String name, String desc) {
        this(portrait, name, desc, TYPE_HUMAN);
    }

    public User(String name) {
        this(0, name, "", TYPE_STATE);
    }

    private User(int portrait, String name, String desc, int type) {
        this.portrait = portrait;
        this.name = name;
        this.desc = desc;
        this.type = type;
    }

    public int getPortrait() {
        return portrait;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public boolean isHuman() {
        return type == TYPE_HUMAN;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
