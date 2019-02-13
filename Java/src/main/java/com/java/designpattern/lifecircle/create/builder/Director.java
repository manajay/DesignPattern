package com.java.designpattern.lifecircle.create.builder;

/**
 * 管理者
 *
 * @author ljtwan
 * @date 2019/1/24
 **/
public class Director {

    private Builder builder;

    public Director(Builder builder){
        this.builder = builder;
    }

    /**
     * 构建
     *
     * @author ljtwan
     * @date 8:55 PM 2019/1/24
     * @param
     * @return void
     **/
    public void construct(){
        builder.makeTitle("Greeting");
        builder.makeString("从早上到下午");
        builder.makeItems(new String[]{
                "早上好.",
                "下午好.",
        });
        builder.makeString("晚上");
        builder.makeItems(new String[]{
                "晚上好,",
                "晚安",
                "再见 ",
        });

        // 完成 释放必要资源
        builder.close();
    }
}
