package com.java.designpattern.StatePattern;

/**
 * @author 段连洁
 * @date 2017/9/19 0019
 */
public class Phone {


    /**
     * 手机的状态
     */
    public State state;

    /**
     * @description 构造方法
     * @author      manajay.dlj@gmail.com
     * @date        2017/9/19 0019 15:29
     * @version     V1.0
     */
    public Phone (){
        PowerOffState powerOffState = new PowerOffState(this);
        state = powerOffState;
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    /**
     * @description 拨打电话
     * @author      manajay.dlj@gmail.com
     * @date        2017/9/19 0019 15:29
     * @version     V1.0
     */
    public void call() {
         state.call();
    }

    /**
     * @description 发送短信
     * @author      manajay.dlj@gmail.com
     * @date        2017/9/19 0019 15:29
     * @version     V1.0
     */
    public void text() {
        state.text();
    }

    /**
     * @description 上网冲浪
     * @author      manajay.dlj@gmail.com
     * @date        2017/9/19 0019 15:29
     * @version     V1.0
     */
    public void surfTheNet() {
        state.surfTheNet();
    }
}
