package com.example.springbook2.aopAndLtw.aspectAop;

public class Proxy implements Interface {
    private Interface next;
    public void setNext(Interface next) {this.next = next;}
}
