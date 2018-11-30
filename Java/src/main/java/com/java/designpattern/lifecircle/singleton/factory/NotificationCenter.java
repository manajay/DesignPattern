package com.java.designpattern.lifecircle.singleton.factory;

/**
 * 通知中心
 * 该方式可能被客户端借助 AccessibleObjectlsetAccessible方法,通过反射机制 调用私有的构造器, 生成新对象
 * 单例的可序列化解决起来麻烦, 需要① 实现 Serialization方法, ② readResolve方法
 *
 * @author duanlianjie
 * @date 14/12/2017
 */
public class NotificationCenter {

    private static final NotificationCenter INSTANCE = new NotificationCenter();

    /**
     * 私有构造器
     * @date 27/01/2018
     * @author duanlianjie
     */
    private NotificationCenter(){};

    /**
     * 工厂方法 返回单例, 可以后期修改此方法, 使不返回唯一单例
     * @date 27/01/2018
     * @author duanlianjie
     */
    public NotificationCenter getInstance(){ return INSTANCE; }

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