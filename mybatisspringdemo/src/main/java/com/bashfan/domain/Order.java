package com.bashfan.domain;

public class Order {
    private int order_id;
    private String order_no;
    private long money;
    private int user_id;
    private User user;

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getOrder_no() {
        return order_no;
    }

    public void setOrder_no(String order_no) {
        this.order_no = order_no;
    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Order{" +
                "order_id=" + order_id +
                ", order_no='" + order_no + '\'' +
                ", money=" + money +
                ", user_id=" + user_id +
                ", user=" + user +
                '}';
    }
}
