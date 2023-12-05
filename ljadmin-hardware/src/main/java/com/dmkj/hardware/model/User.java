package com.dmkj.hardware.model;

public class User {
    /** 编号 */
    private int id;
    /** 姓名 */
    private String name;

    public User() {
    }

    public User(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    /**
     * 获取编号
     * 
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * 设置编号
     * 
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 获取姓名
     * 
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置姓名
     * 
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

}
