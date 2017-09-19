package com.java.designpattern.StatePattern;

/**
 * @author 段连洁
 * @date 2017/9/19 0019
 */
public interface State {

    /**
     * @description 拨打电话
     * @author      manajay.dlj@gmail.com
     * @date        2017/9/19 0019 15:29
     * @version     V1.0
     */
    public void call ();

    /**
     * @description 发送短信
     * @author      manajay.dlj@gmail.com
     * @date        2017/9/19 0019 15:29
     * @version     V1.0
     */
    public void text ();

    /**
     * @description 上网冲浪
     * @author      manajay.dlj@gmail.com
     * @date        2017/9/19 0019 15:29
     * @version     V1.0
     */
    public void surfTheNet();
}
