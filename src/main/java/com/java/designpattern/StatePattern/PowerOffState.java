package com.java.designpattern.StatePattern;

/**
 * @author 段连洁
 * @date 2017/9/19 0019
 */
public class PowerOffState implements State {

    public Phone phone;

    public PowerOffState(Phone phone) {
        this.phone = phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public Phone getPhone() {
        return phone;
    }

    @Override
    public void call() {
        System.out.println("手机已经关机，暂时不能拨打电话");
    }

    @Override
    public void text() {
        System.out.println("手机已经关机，暂时不能发送短信");
    }

    @Override
    public void surfTheNet() {
        System.out.println("手机已经关机，暂时不能上网冲浪");
    }
}
