package com.example.springbook2.mvc.binding.converterAndFormatter;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import java.math.BigDecimal;
import java.util.Date;

public class Product {
    @NumberFormat(pattern = "$###,##0.00")
    BigDecimal price;

    @DateTimeFormat(pattern = "yyyy/MM/dd")
    Date orderDate;

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
