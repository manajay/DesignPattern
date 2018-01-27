package com.java.designpattern.lifecircle.create.constructor;

/**
 * 重叠构造器模式 (telescope constructor)
 * 用于多参数, 但是参数有限,较短, 并且必选 可选共存的对象
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

    public PhoneDevice(String imei, String macAdress) {
        this(imei,macAdress, null);
    }

    public PhoneDevice(String imei, String macAdress, String imsi) {
        this(imei,macAdress,imsi,null);
    }

    public PhoneDevice(String imei, String macAdress, String imsi, String networkType) {
        this(imei,macAdress,imsi,networkType,null,null);
    }

    public PhoneDevice(String imei, String macAdress, String imsi, String networkType, String hardwareName) {
        this(imei,macAdress,imsi,networkType,hardwareName,null);
    }

    public PhoneDevice(String imei, String macAdress, String imsi, String networkType, String hardwareName, String hardwareNumber) {
        this.imei = imei;
        this.macAdress = macAdress;
        this.imsi = imsi;
        this.networkType = networkType;
        this.hardwareName = hardwareName;
        this.hardwareNumber = hardwareNumber;
    }

    @Override
    public String toString() {
        return "重叠constructor模式 PhoneDevice{" +
                "imei='" + imei + '\'' +
                ", macAdress='" + macAdress + '\'' +
                ", imsi='" + imsi + '\'' +
                ", networkType='" + networkType + '\'' +
                ", hardwareName='" + hardwareName + '\'' +
                ", hardwareNumber='" + hardwareNumber + '\'' +
                '}';
    }

    public static void main(String[] args){
        PhoneDevice device = new PhoneDevice("2F22508A-5C0B-4D3E-9503-FB0161098DE6", "C8:25:E1:36:65:6F","460018671511390");
        System.out.printf("device: " + device);
    }
}

