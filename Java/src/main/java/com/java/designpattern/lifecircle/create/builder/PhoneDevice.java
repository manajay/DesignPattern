package com.java.designpattern.lifecircle.create.builder;

/**
 * Builder模式, 兼顾了构造器与JavaBeans模式, 既有构造器的安全性, 又有JavaBeans的可读性, 内部的setter方法类似于链式编程
 * 缺点 生成Builder的内存额外开销, 性能稍弱, 适用于参数过多的对象创建.  并且通常再设计开始就使用构造器
 *
 * @author duanlianjie
 * @date 14/12/2017
 */
public class PhoneDevice {

    /**
     * 手机标识(硬件序列号)
     * 必选
     */
    private final String imei;

    /**
     * 手机mac地址
     * 必选
     */
    private final String macAdress;

    /**
     * SIM卡标识
     * 可选
     */
    private final String imsi;

    /**
     * 手机网络类型, wifi , 4G , 3G ...
     * 可选
     */
    private final String networkType;


    /**
     * 手机硬件名称, 如 mt6795
     * 可选
     */
    private final String hardwareName;

    /**
     * 手机硬件识别码 如 2F22508A-5C0B-4D3E-9503-FB0161098DE6
     * 可选
     */
    private final String hardwareNumber;


    public interface Builder<T>{

        /**
         * Builder生成对象方法
         * @date 27/01/2018
         * @author duanlianjie
         */
        T build();
    }

    /**
     * 静态构造器
     * @date 27/01/2018
     * @author duanlianjie
     */
    public static class PhoneDeviceBuilder implements Builder<PhoneDevice> {

        /**
         * 手机标识(硬件序列号)
         * 必选
         */
        private final String imei;

        /**
         * 手机mac地址
         * 必选
         */
        private final String macAdress;

        /**
         * SIM卡标识
         * 可选
         */
        private  String imsi;

        /**
         * 手机网络类型, wifi , 4G , 3G ...
         * 可选
         */
        private  String networkType;


        /**
         * 手机硬件名称, 如 mt6795
         * 可选
         */
        private  String hardwareName;

        /**
         * 手机硬件识别码 如 2F22508A-5C0B-4D3E-9503-FB0161098DE6
         * 可选
         */
        private  String hardwareNumber;

        public PhoneDeviceBuilder(String imei, String macAdress) {
            this.imei = imei;
            this.macAdress = macAdress;
        }

        public PhoneDeviceBuilder setImsi(String imsi) {
            this.imsi = imsi;
            return this;
        }

        public PhoneDeviceBuilder setNetworkType(String networkType) {
            this.networkType = networkType;
            return this;
        }

        public PhoneDeviceBuilder setHardwareName(String hardwareName) {
            this.hardwareName = hardwareName;
            return this;
        }

        public PhoneDeviceBuilder setHardwareNumber(String hardwareNumber) {
            this.hardwareNumber = hardwareNumber;
            return this;
        }

        @Override
        public PhoneDevice build(){
            return new PhoneDevice(this);
        }
    }

    /**
     * 私有构造器, 给Builder使用
     */
    private PhoneDevice(PhoneDeviceBuilder builder){
        imei = builder.imei;
        macAdress = builder.macAdress;
        imsi = builder.imsi;
        networkType = builder.networkType;
        hardwareName = builder.hardwareName;
        hardwareNumber = builder.hardwareNumber;
    }

    @Override
    public String toString() {
        return "Builder模式 PhoneDevice{" +
                "imei='" + imei + '\'' +
                ", macAdress='" + macAdress + '\'' +
                ", imsi='" + imsi + '\'' +
                ", networkType='" + networkType + '\'' +
                ", hardwareName='" + hardwareName + '\'' +
                ", hardwareNumber='" + hardwareNumber + '\'' +
                '}';
    }

    public static void main(String[] args){
        PhoneDeviceBuilder builder = new PhoneDevice.PhoneDeviceBuilder("2F22508A-5C0B-4D3E-9503-FB0161098DE6", "C8:25:E1:36:65:6F").setHardwareName("mt6795").setImsi("460018671511390");
        PhoneDevice device = builder.build();
        System.out.printf("device: " + device);
    }
}
