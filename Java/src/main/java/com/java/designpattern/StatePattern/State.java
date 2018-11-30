package com.java.designpattern.StatePattern;

/**
 * @author 段连洁
 * @date 2017/9/19 0019
 */
public interface State {

    /**
     * 拨打电话
     *
     * @author      manajay.dlj@gmail.com
     * @date        2017/9/19 0019 15:29
     */
    public void call ();

    /**
     * 发送短信
     * @author      manajay.dlj@gmail.com
     * @date        2017/9/19 0019 15:29
     */
    public void text ();

    /**
     *   上网冲浪
     * @author      manajay.dlj@gmail.com
     * @date        2017/9/19 0019 15:29
     */
    public void surfTheNet();
}
