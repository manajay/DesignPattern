package com.java.designpattern.StatePattern;

/**
 * @author 段连洁
 * @date 2017/9/19 0019
 */
public class PowerOnState implements State {

    public Phone phone;

    public PowerOnState(Phone phone) {
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
        System.out.println("手机状态良好，可以拨打电话");
        this.consumePower();
    }

    @Override
    public void text() {
        System.out.println("手机状态良好，可以发送短信");
        this.consumePower();
    }

    @Override
    public void surfTheNet() {
        System.out.println("手机状态良好，可以上网冲浪");
        this.consumePower();
    }

    /**
     *   消耗电量的行为
     *               额外，自己独有的行为
     * @author      manajay.dlj@gmail.com
     * @date        2017/9/19 0019 15:33
     * @version     V1.0.0
     */
    public void consumePower (){
        System.out.println("正在消耗手机电量");
    }
}
