package com.java.designpattern.lifecircle.create.javabean;

/**
 * JavaBeans模式
 * 构造过程被分散到多个调用中, 但是构造过程中 对象可能处于 不一致的状态,  存在多线程修改对象的可能, 无法保证创建出来的对象是你当前线程想要的.
 *
 * @author duanlianjie
 * @date 14/12/2017
 */
public class PhoneDevice {

    /**
     * 手机标识(硬件序列号)
     * 必选
     */
    private  String imei = "";

    /**
     * 手机mac地址
     * 必选
     */
    private  String macAdress = "";

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

    /**
     * 无参构造器
     *
     * @date 27/01/2018
     * @author duanlianjie
     */
    public PhoneDevice() {
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getMacAdress() {
        return macAdress;
    }

    public void setMacAdress(String macAdress) {
        this.macAdress = macAdress;
    }

    public String getImsi() {
        return imsi;
    }

    public void setImsi(String imsi) {
        this.imsi = imsi;
    }

    public String getNetworkType() {
        return networkType;
    }

    public void setNetworkType(String networkType) {
        this.networkType = networkType;
    }

    public String getHardwareName() {
        return hardwareName;
    }

    public void setHardwareName(String hardwareName) {
        this.hardwareName = hardwareName;
    }

    public String getHardwareNumber() {
        return hardwareNumber;
    }

    public void setHardwareNumber(String hardwareNumber) {
        this.hardwareNumber = hardwareNumber;
    }

    @Override
    public String toString() {
        return " javabean模式  PhoneDevice{" +
                "imei='" + imei + '\'' +
                ", macAdress='" + macAdress + '\'' +
                ", imsi='" + imsi + '\'' +
                ", networkType='" + networkType + '\'' +
                ", hardwareName='" + hardwareName + '\'' +
                ", hardwareNumber='" + hardwareNumber + '\'' +
                '}';
    }

    public static void main(String[] args){
        PhoneDevice device = new PhoneDevice();
        device.setImei("2F22508A-5C0B-4D3E-9503-FB0161098DE6");
        device.setMacAdress("C8:25:E1:36:65:6F");
        device.setImsi("460018671511390");
        System.out.printf("device: " + device);
    }
}
