package com.example.springbook2.etc;

import java.util.Date;

public class SearchCondition {
    String productNo;
    User user;
    Date datetiem;

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDatetiem() {
        return datetiem;
    }

    public void setDatetiem(Date datetiem) {
        this.datetiem = datetiem;
    }
}
