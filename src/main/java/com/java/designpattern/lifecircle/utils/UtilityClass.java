package com.java.designpattern.lifecircle.utils;

/**
 * 工具类 不希望被实例化
 *
 * @author duanlianjie
 * @date 14/12/2017
 */
public class UtilityClass {

    /**
     * 阻止 默认的实例化构造器
     *
     * @date 27/01/2018
     * @author duanlianjie
     */
    private UtilityClass(){
        throw new AssertionError();
    }
}
