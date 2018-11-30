package com.java.designpattern.lifecircle.singleton.singleenum;

/**
 * 通知中心
 * 类似于公有域,但是更加简洁,且无偿提供序列化机制, 绝对防止多次实例化, 即使面对复杂的序列化或者反射机制的攻击.
 * 正在推广中...
 *
 * @author duanlianjie
 * @date 14/12/2017
 */
public enum NotificationCenter {

    /**
     * 单元素枚举值
     */
    INSTANCE;

    /**
     * 注册观察者
     * @param observer 观察者
     * @date 27/01/2018
     * @author duanlianjie
     */
    public void register(Object observer){};

    /**
     * 发布事件
     * @param event 事件
     * @date 27/01/2018
     * @author duanlianjie
     */
    public void publish(Object event){};
}
