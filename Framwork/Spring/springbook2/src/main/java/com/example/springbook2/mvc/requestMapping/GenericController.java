package com.example.springbook2.mvc.requestMapping;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

public abstract class GenericController<T, K, S> {
    S Service;
    @RequestMapping("/add") public void add(T entity) {}
    @RequestMapping("/update") public void update(T entity) {}
    @RequestMapping("/view") public T view(K id) {return null;}
    @RequestMapping("/delete") public void delete(K id) {}
    @RequestMapping("/list") public List<T> list() {return new ArrayList<>();}
}
