package com.java.designpattern.lifecircle.create.builder;

/**
 * @author ljtwan
 * @date 2019/1/24
 **/
abstract public class Builder {
    /**
     * 构建标题
     *
     * @author ljtwan
     * @date 8:49 PM 2019/1/24
     * @param title 标题
     * @return void
     **/
    public abstract void makeTitle(String title);

    /**
     * 构建文本
     *
     * @author ljtwan
     * @date 8:50 PM 2019/1/24
     * @param string
     * @return void
     **/
    public abstract void makeString(String string);

    /**
     * 构建 子元素
     *
     * @author ljtwan
     * @date 8:50 PM 2019/1/24
     * @param items
     * @return void
     **/
    public abstract void makeItems(String[] items);

    /**
     * 关闭构建
     *
     * @author ljtwan
     * @date 8:51 PM 2019/1/24
     * @param
     * @return void
     **/
    public abstract void close();
}
