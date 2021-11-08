package org.yzh.protocol;

import org.yzh.protocol.basics.KeyValuePair;
import org.yzh.protocol.commons.Action;
import org.yzh.protocol.commons.Shape;
import org.yzh.protocol.commons.ShapeAction;
import org.yzh.protocol.commons.transform.AttributeId;
import org.yzh.protocol.commons.transform.attribute.*;
import org.yzh.protocol.commons.transform.parameter.ParamADAS;
import org.yzh.protocol.commons.transform.parameter.ParamVideo;
import org.yzh.protocol.commons.transform.passthrough.PeripheralSystem;
import org.yzh.protocol.jsatl12.AlarmId;
import org.yzh.protocol.t808.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * JT/T 808协议单元测试数据
 * @author yezhihao
 * @home https://gitee.com/yezhihao/jt808-server
 */
public class JT808Beans {

    private static final String DEVICE_ID = "09876543210987654321";
    private static final String STR_TIME = "200707192359";
    private static final LocalDateTime TIME = LocalDateTime.of(2020, 7, 7, 19, 23, 59);
    private static final LocalDateTime START_TIME = LocalDateTime.of(2020, 07, 26, 00, 00, 00);
    private static final LocalDateTime END_TIME = LocalDateTime.of(2020, 07, 26, 23, 23, 59);

    //平台RSA公钥|终端RSA公钥
    public static T0A00_8A00 T0A00_8A00() {
        T0A00_8A00 bean = new T0A00_8A00();
        bean.setE(999);
        bean.setN(new byte[128]);
        return bean;
    }

    //终端通用应答|平台通用应答
    public static T0001 T0001() {
        T0001 bean = new T0001();
        bean.setResponseSerialNo(123);
        bean.setResponseMessageId(456);
        bean.setResultCode(3);
        return bean;
    }

    //终端注册
    public static T0100 T0100() {
        T0100 bean = new T0100();
        bean.setProvinceId(31);
        bean.setCityId(115);
        bean.setMakerId("yzh");
        bean.setDeviceModel("www.jtt808.cn");
        bean.setDeviceId(DEVICE_ID);
        bean.setPlateColor(1);
        bean.setPlateNo("测A888888");
        return bean;
    }

    //终端鉴权
    public static T0102 T0102_2013() {
        T0102 bean = new T0102();
        bean.setToken("pmYGzGukO8K4Z5lpIOTg8dqb3eprYaHBbXSPLtdbyG8=");
        return bean;
    }

    public static T0102 T0102_2019() {
        T0102 bean = new T0102();
        bean.setToken("pmYGzGukO8K4Z5lpIOTg8dqb3eprYaHBbXSPLtdbyG8=");
        bean.setImei("123456789012345");
        bean.setSoftwareVersion("www.jtt808.cn");
        return bean;
    }

    //查询终端参数应答
    public static T0104 T0104() {
        T0104 bean = new T0104();
        bean.setResponseSerialNo(104);
        bean.setParameters(parameters());
        return bean;
    }

    //终端参数列表
    public static Map<Integer, Object> parameters() {
        ParamVideo paramVideo = new ParamVideo();
        paramVideo.setRealtimeEncode((byte) 1);
        paramVideo.setRealtimeResolution((byte) 1);
        paramVideo.setRealtimeFrameInterval((byte) 1);
        paramVideo.setRealtimeFrameRate((byte) 1);
        paramVideo.setRealtimeBitRate((byte) 1);
        paramVideo.setStorageEncode((byte) 2);
        paramVideo.setStorageResolution((byte) 2);
        paramVideo.setStorageFrameInterval((byte) 2);
        paramVideo.setStorageFrameRate((byte) 2);
        paramVideo.setStorageBitRate((byte) 2);
        paramVideo.setOdsConfig((byte) 3);
        paramVideo.setAudioEnable((byte) 3);

        Map<Integer, Object> parameters = new TreeMap<>();
        parameters.put(ParamVideo.id, paramVideo);
        parameters.put(ParamADAS.id, new ParamADAS());
        return parameters;
    }

    //查询终端属性应答
    public static T0107 T0107() {
        T0107 bean = new T0107();
        bean.setDeviceType(127);
        bean.setMakerId("yzh");
        bean.setDeviceModel("www.jtt808.cn");
        bean.setDeviceId(DEVICE_ID);
        bean.setIccid("12345678901234567890");
        bean.setFirmwareVersion("www.jtt808.cn");
        bean.setHardwareVersion("www.jtt808.cn");
        bean.setGnssAttribute(127);
        bean.setNetworkAttribute(127);
        return bean;
    }

    //终端升级结果通知
    public static T0108 T0108() {
        T0108 bean = new T0108();
        bean.setType(T0108.Beidou);
        bean.setResult(2);
        return bean;
    }

    //位置信息汇报
    public static T0200 T0200() {
        T0200 bean = new T0200();
        bean.setWarnBit(1024);
        bean.setStatusBit(2048);
        bean.setLatitude(116307629);
        bean.setLongitude(40058359);
        bean.setAltitude(312);
        bean.setSpeed(3);
        bean.setDirection(99);
        bean.setDateTime(STR_TIME);
        return bean;
    }

    //位置信息汇报
    public static T0200 T0200_() {
        T0200 bean = new T0200();
        bean.setWarnBit(1024 * 2);
        bean.setStatusBit(2048 * 2);
        bean.setLatitude(116307629 * 2);
        bean.setLongitude(40058359 * 2);
        bean.setAltitude(312 * 2);
        bean.setSpeed(3 * 2);
        bean.setDirection(99 * 2);
        bean.setDateTime(STR_TIME);
        return bean;
    }

    //位置信息汇报
    public static T0200 T0200Attributes() {
        T0200 bean = T0200();
        Map<Integer, Object> attributes = new TreeMap();
        attributes.put(AttributeId.Mileage, 11L);
        attributes.put(AttributeId.Gas, 22);
        attributes.put(AttributeId.Speed, 33);
        attributes.put(AttributeId.AlarmEventId, 44);
        attributes.put(AttributeId.TirePressure, new TirePressure(new byte[]{55, 55, 55}));
        attributes.put(AttributeId.CarriageTemperature, 2);

        attributes.put(AttributeId.OverSpeedAlarm, new OverSpeedAlarm((byte) 66, 66));
        attributes.put(AttributeId.InOutAreaAlarm, new InOutAreaAlarm((byte) 77, 77, (byte) 77));
        attributes.put(AttributeId.RouteDriveTimeAlarm, new RouteDriveTimeAlarm(88, 88, (byte) 88));

        attributes.put(AttributeId.Signal, 99L);
        attributes.put(AttributeId.IoState, 10);
        attributes.put(AttributeId.AnalogQuantity, 20L);
        attributes.put(AttributeId.SignalStrength, 30);
        attributes.put(AttributeId.GnssCount, 40);
        bean.setAttributes(attributes);
        return bean;
    }

    //位置信息汇报
    public static T0200 T0200JSATL12() {
        AlarmADAS alarmADAS = new AlarmADAS();
        alarmADAS.setSerialNo(64);
        alarmADAS.setState(1);
        alarmADAS.setType(1);
        alarmADAS.setLevel(1);
        alarmADAS.setFrontSpeed(10);
        alarmADAS.setFrontDistance(10);
        alarmADAS.setDeviateType(1);
        alarmADAS.setRoadSign(1);
        alarmADAS.setRoadSignValue(10);
        alarmADAS.setSpeed(10);
        alarmADAS.setAltitude(100);
        alarmADAS.setLatitude(111111);
        alarmADAS.setLongitude(222222);
        alarmADAS.setDateTime(TIME);
        alarmADAS.setStatus(1);
        alarmADAS.setAlarmId(new AlarmId(DEVICE_ID, "200827111111", 1, 1, 1));

        AlarmDSM alarmDSM = new AlarmDSM();
        alarmDSM.setSerialNo(65);
        alarmDSM.setState(2);
        alarmDSM.setType(2);
        alarmDSM.setLevel(2);
        alarmDSM.setFatigueDegree(20);
        alarmDSM.setReserved(20);
        alarmDSM.setSpeed(20);
        alarmDSM.setAltitude(200);
        alarmDSM.setLatitude(333333);
        alarmDSM.setLongitude(444444);
        alarmDSM.setDateTime(TIME);
        alarmDSM.setStatus(2);
        alarmDSM.setAlarmId(new AlarmId(DEVICE_ID, "200827111111", 2, 2, 2));

        AlarmTPMS alarmTPMS = new AlarmTPMS();
        alarmTPMS.setSerialNo(66);
        alarmTPMS.setState(3);
        alarmTPMS.setSpeed(30);
        alarmTPMS.setAltitude(300);
        alarmTPMS.setLatitude(555555);
        alarmTPMS.setLongitude(666666);
        alarmTPMS.setDateTime(TIME);
        alarmTPMS.setStatus(3);
        alarmTPMS.setAlarmId(new AlarmId(DEVICE_ID, "200827111111", 3, 3, 3));

        AlarmBSD alarmBSD = new AlarmBSD();
        alarmBSD.setSerialNo(67);
        alarmBSD.setState(4);
        alarmBSD.setType(4);
        alarmBSD.setSpeed(40);
        alarmBSD.setAltitude(400);
        alarmBSD.setLatitude(777777);
        alarmBSD.setLongitude(888888);
        alarmBSD.setDateTime(TIME);
        alarmBSD.setStatus(4);
        alarmBSD.setAlarmId(new AlarmId(DEVICE_ID, "200827111111", 4, 4, 4));


        T0200 bean = T0200();
        Map<Integer, Object> attributes = new TreeMap();
        attributes.put(AlarmADAS.id, alarmADAS);
        attributes.put(AlarmDSM.id, alarmDSM);
        attributes.put(AlarmTPMS.id, alarmTPMS);
        attributes.put(AlarmBSD.id, alarmBSD);

        bean.setAttributes(attributes);
        return bean;
    }

    //位置信息查询应答|车辆控制应答
    public static T0201_0500 T0201_0500() {
        T0201_0500 bean = new T0201_0500();
        bean.setResponseSerialNo(26722);
        bean.setWarnBit(10842);
        bean.setStatusBit(29736);
        bean.setLatitude(41957);
        bean.setLongitude(56143);
        bean.setAltitude(48243);
        bean.setSpeed(10001);
        bean.setDirection(300);
        bean.setDateTime(TIME);
        return bean;
    }

    //事件报告
    public static T0301 T0301() {
        T0301 bean = new T0301();
        bean.setEventId(255);
        return bean;
    }

    //提问应答
    public static T0302 T0302() {
        T0302 bean = new T0302();
        bean.setResponseSerialNo(61252);
        bean.setAnswerId(127);
        return bean;
    }

    //信息点播_取消
    public static T0303 T0303() {
        T0303 bean = new T0303();
        bean.setType(255);
        bean.setAction(0);
        return bean;
    }

    //驾驶员身份信息采集上报
    public static T0702 T0702() {
        T0702 bean = new T0702();
        bean.setStatus(2);
        bean.setDateTime("200721183000");
        bean.setCardStatus(0);
        bean.setName("张三");
        bean.setLicenseNo("1234567890123");
        bean.setInstitution("中华人民共和国道路运输从业人员从业资格证");
        bean.setLicenseValidPeriod("20190630");
        return bean;
    }

    //定位数据批量上传
    public static T0704 T0704() {
        T0704 bean = new T0704();
        bean.setType(1);
        List<T0704.Item> item = new ArrayList<>(4);
        item.add(new T0704.Item(T0200()));
        item.add(new T0704.Item(T0200_()));
        item.add(new T0704.Item(T0200()));
        item.add(new T0704.Item(T0200_()));
        bean.setItems(item);
        return bean;
    }

    //CAN总线数据上传
    public static T0705 T0705() {
        T0705 bean = new T0705();
        bean.setDateTime("235959");
        List<T0705.Item> items = new ArrayList<>(3);
        items.add(new T0705.Item(16909060, new byte[]{1, 2, 3, 4, 5, 6, 7, 8}));
        items.add(new T0705.Item(16909060, new byte[]{1, 2, 3, 4, 5, 6, 7, 8}));
        items.add(new T0705.Item(16909060, new byte[]{1, 2, 3, 4, 5, 6, 7, 8}));
        bean.setItems(items);
        return bean;
    }

    //多媒体事件信息上传
    public static T0800 T0800() {
        T0800 bean = new T0800();
        bean.setId(123);
        bean.setType(0);
        bean.setFormat(0);
        bean.setEvent(7);
        bean.setChannelId(1);
        return bean;
    }

    //多媒体数据上传
    public static T0801 T0801() {
        T0801 bean = new T0801();
        bean.setId(123);
        bean.setType(1);
        bean.setFormat(2);
        bean.setEvent(1);
        bean.setChannelId(2);
        bean.setLocation(T0200());
        bean.setPacket(new byte[]{13, 123, 13, 123, 123});
        return bean;
    }

    //存储多媒体数据检索应答
    public static T0802 T0802() {
        T0802 bean = new T0802();
        bean.setResponseSerialNo(123);
        List<T0802.Item> items = new ArrayList<>(4);
        items.add(new T0802.Item(1, 1, 1, 1, T0200()));
        items.add(new T0802.Item(2, 1, 1, 1, T0200_()));
        items.add(new T0802.Item(3, 1, 1, 1, T0200()));
        items.add(new T0802.Item(4, 1, 1, 1, T0200_()));
        bean.setItems(items);
        return bean;
    }

    //摄像头立即拍摄命令应答
    public static T0805 T0805() {
        T0805 bean = new T0805();
        bean.setResponseSerialNo(62656);
        bean.setResult(0);
        bean.setId(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        return bean;
    }

    //数据压缩上报
    public static T0901 T0901() {
        T0901 bean = new T0901();
        bean.setBody(new byte[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        return bean;
    }

    //补传分包请求
    public static T8003 T8003() {
        T8003 bean = new T8003();
        bean.setResponseSerialNo(4249);
        bean.setId(new short[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        return bean;
    }

    //终端注册应答
    public static T8100 T8100() {
        T8100 bean = new T8100();
        bean.setResponseSerialNo(38668);
        bean.setResultCode(T8100.Success);
        bean.setToken("chwD0SE1fchwD0SE1fchwD0SE1f");
        return bean;
    }

    //设置终端参数
    public static T8103 T8103() {
        T8103 bean = new T8103();
        bean.setParameters(parameters());
        return bean;
    }

    //终端控制
    public static T8105 T8105() {
        T8105 bean = new T8105();
        bean.setCommand(123);
        bean.setParameter("as;123;zxc;123;");
        return bean;
    }

    //查询指定终端参数
    public static T8106 T8106() {
        T8106 bean = new T8106(1, 3, 5, 7, 9, 127);
        return bean;
    }

    //下发终端升级包
    public static T8108 T8108() {
        T8108 bean = new T8108();
        bean.setType(T8108.Beidou);
        bean.setMakerId("yzh");
        bean.setVersion("www.jtt808.cn");
        bean.setPacket(new byte[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        return bean;
    }

    //临时位置跟踪控制
    public static T8202 T8202() {
        T8202 bean = new T8202();
        bean.setInterval(5);
        bean.setValidityPeriod(600);
        return bean;
    }

    //人工确认报警消息
    public static T8203 T8203() {
        T8203 bean = new T8203();
        bean.setResponseSerialNo(123);
        bean.setType(40286);
        return bean;
    }

    //提问下发
    public static T8302 T8302() {
        List<T8302.Option> options = new ArrayList<>(2);
        options.add(new T8302.Option(1, "www.jtt808.cn"));
        options.add(new T8302.Option(2, "www.jtt808.cn"));
        T8302 bean = new T8302("123", 1);
        bean.setOptions(options);
        return bean;
    }

    //信息点播菜单设置
    public static T8303 T8303() {
        T8303 bean = new T8303();
        bean.setType(Action.Append);
        int i = 0;
        bean.addInfo(i++, "军事");
        bean.addInfo(i++, "国内");
        bean.addInfo(i++, "国际");
        bean.addInfo(i++, "股票");
        bean.addInfo(i++, "基金");
        bean.addInfo(i++, "外汇");
        bean.addInfo(i++, "体育");
        bean.addInfo(i++, "娱乐");
        bean.addInfo(i++, "汽车");
        return bean;
    }

    //信息服务
    public static T8304 T8304() {
        T8304 bean = new T8304();
        bean.setType(123);
        bean.setContent("美上将:中国导弹可将关岛\"从地图上移除\"");
        return bean;
    }

    //电话回拨
    public static T8400 T8400() {
        T8400 bean = new T8400();
        bean.setType(T8400.Normal);
        bean.setPhoneNumber("1234567890123");
        return bean;
    }

    //设置电话本
    public static T8401 T8401() {
        T8401 bean = new T8401();
        bean.setType(Action.Append);
        bean.addContact(new T8401.Contact(2, "12345678901", "张三"));
        bean.addContact(new T8401.Contact(1, "123123", "李四"));
        bean.addContact(new T8401.Contact(3, "123123", "王五"));
        return bean;
    }

    //车辆控制
    public static T8500 T8500() {
        T8500 bean = new T8500();
        bean.setSign(123);
        return bean;
    }

    //设置圆形区域
    public static T8600 T8600(int version) {
        T8600 bean = new T8600();
        bean.setAction(ShapeAction.Modify);
        List<T8600.Circle> items = new ArrayList<>(5);
        if (version == 2013) {
            items.add(new T8600.Circle(1, 0, 123123, 112312, 123, START_TIME, END_TIME, 200, 30));
            items.add(new T8600.Circle(2, 0, 123123, 112312, 123, START_TIME, END_TIME, 200, 30));
            items.add(new T8600.Circle(3, 0, 123123, 112312, 123, START_TIME, END_TIME, 200, 30));
            items.add(new T8600.Circle(4, 0, 123123, 112312, 123, START_TIME, END_TIME, 200, 30));
            items.add(new T8600.Circle(5, 0, 123123, 112312, 123, START_TIME, END_TIME, 200, 30));
        } else {
            items.add(new T8600.Circle(1, 0, 123123, 112312, 123, START_TIME, END_TIME, 200, 30, 40, "测试围栏1"));
            items.add(new T8600.Circle(2, 0, 123123, 112312, 123, START_TIME, END_TIME, 200, 30, 40, "测试围栏2"));
            items.add(new T8600.Circle(3, 0, 123123, 112312, 123, START_TIME, END_TIME, 200, 30, 40, "测试围栏3"));
            items.add(new T8600.Circle(4, 0, 123123, 112312, 123, START_TIME, END_TIME, 200, 30, 40, "测试围栏4"));
            items.add(new T8600.Circle(5, 0, 123123, 112312, 123, START_TIME, END_TIME, 200, 30, 40, "测试围栏5"));
        }
        bean.setItems(items);
        return bean;
    }

    //删除圆形区域|删除矩形区域|删除多边形区域|删除路线
    public static T8601 T8601() {
        T8601 bean = new T8601(1, 2, 3, 65535);
        return bean;
    }

    //设置矩形区域
    public static T8602 T8602(int version) {
        T8602 bean = new T8602();
        bean.setAction(ShapeAction.Update);
        List<T8602.Rectangle> items = new ArrayList<>(5);
        if (version == 2013) {
            items.add(new T8602.Rectangle(1, 0, 123123, 112312, 123123, 112312, START_TIME, END_TIME, 200, 30));
            items.add(new T8602.Rectangle(2, 0, 123123, 112312, 123123, 112312, START_TIME, END_TIME, 200, 30));
            items.add(new T8602.Rectangle(3, 0, 123123, 112312, 123123, 112312, START_TIME, END_TIME, 200, 30));
            items.add(new T8602.Rectangle(4, 0, 123123, 112312, 123123, 112312, START_TIME, END_TIME, 200, 30));
            items.add(new T8602.Rectangle(5, 0, 123123, 112312, 123123, 112312, START_TIME, END_TIME, 200, 30));
        } else {
            items.add(new T8602.Rectangle(1, 0, 123123, 112312, 123123, 112312, START_TIME, END_TIME, 200, 30, 40, "测试围栏1"));
            items.add(new T8602.Rectangle(2, 0, 123123, 112312, 123123, 112312, START_TIME, END_TIME, 200, 30, 40, "测试围栏2"));
            items.add(new T8602.Rectangle(3, 0, 123123, 112312, 123123, 112312, START_TIME, END_TIME, 200, 30, 40, "测试围栏3"));
            items.add(new T8602.Rectangle(4, 0, 123123, 112312, 123123, 112312, START_TIME, END_TIME, 200, 30, 40, "测试围栏4"));
            items.add(new T8602.Rectangle(5, 0, 123123, 112312, 123123, 112312, START_TIME, END_TIME, 200, 30, 40, "测试围栏5"));
        }
        bean.setItems(items);
        return bean;
    }

    //设置多边形区域
    public static T8604 T8604(int version) {
        T8604 bean = new T8604();
        bean.setId(3);
        bean.setAttribute(0);
        bean.setStartTime(START_TIME);
        bean.setEndTime(END_TIME);
        bean.setMaxSpeed(123);
        bean.setDuration(60);
        bean.addPoint(345, 123);
        bean.addPoint(345, 123);
        bean.addPoint(345, 123);
        bean.addPoint(345, 123);
        bean.addPoint(345, 123);
        if (version >= 2019) {
            bean.setNightMaxSpeed(40);
            bean.setName("测试围栏");
        }
        return bean;
    }

    //设置路线
    public static T8606 T8606(int version) {
        T8606 bean = new T8606();
        bean.setId(59397);
        bean.setAttribute(0);
        bean.setStartTime(START_TIME);
        bean.setEndTime(END_TIME);
        List<T8606.Line> item = new ArrayList<>(4);
        if (version == 2013) {
            item.add(new T8606.Line(1, 1, 31234567, 121234567, 9, 0, 1, 2, 3, 4));
            item.add(new T8606.Line(2, 1, 31234567, 121234567, 9, 0, 1, 2, 3, 4));
            item.add(new T8606.Line(3, 1, 31234567, 121234567, 9, 0, 1, 2, 3, 4));
            item.add(new T8606.Line(4, 1, 31234567, 121234567, 9, 0, 1, 2, 3, 4));
        } else {
            item.add(new T8606.Line(1, 1, 31234567, 121234567, 9, 0, 1, 2, 3, 4, 5));
            item.add(new T8606.Line(2, 1, 31234567, 121234567, 9, 0, 1, 2, 3, 4, 5));
            item.add(new T8606.Line(3, 1, 31234567, 121234567, 9, 0, 1, 2, 3, 4, 5));
            item.add(new T8606.Line(4, 1, 31234567, 121234567, 9, 0, 1, 2, 3, 4, 5));
            bean.setName("测试区域");
        }
        bean.setItems(item);
        return bean;
    }

    //查询区域或线路数据
    public static T8608 T8608() {
        T8608 bean = new T8608();
        bean.setTotal(Shape.Route);
        bean.setId(new int[]{2, 4, 6, 8, 999999999});
        return bean;
    }

    //多媒体数据上传应答
    public static T8800 T8800() {
        T8800 bean = new T8800();
        bean.setMediaId(49503);
        bean.setId(new short[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        return bean;
    }

    //摄像头立即拍摄命令
    public static T8801 T8801() {
        T8801 bean = new T8801();
        bean.setChannelId(1);
        bean.setCommand(2);
        bean.setTime(3);
        bean.setSave(1);
        bean.setResolution(4);
        bean.setQuality(5);
        bean.setBrightness(255);
        bean.setContrast(127);
        bean.setSaturation(127);
        bean.setChroma(255);
        return bean;
    }

    //存储多媒体数据检索
    public static T8802 T8802() {
        T8802 bean = new T8802();
        bean.setType(0);
        bean.setChannelId(1);
        bean.setEvent(3);
        bean.setEndTime(TIME);
        bean.setStartTime(TIME);
        return bean;
    }

    //存储多媒体数据上传命令
    public static T8803 T8803() {
        T8803 bean = new T8803();
        bean.setType(0);
        bean.setChannelId(1);
        bean.setEvent(3);
        bean.setEndTime(TIME);
        bean.setStartTime(TIME);
        bean.setDelete(0);
        return bean;
    }

    //录音开始命令
    public static T8804 T8804() {
        T8804 bean = new T8804();
        bean.setCommand(0x01);
        bean.setTime(6328);
        bean.setSave(1);
        bean.setAudioSamplingRate(0);
        return bean;
    }

    //单条存储多媒体数据检索上传命令
    public static T8805 T8805() {
        T8805 bean = new T8805();
        bean.setId(28410);
        bean.setDelete(1);
        return bean;
    }

    //数据上行透传
    public static T0900 T0900() {
        T0900 bean = new T0900();
        KeyValuePair<Integer, Object> message = new KeyValuePair<>();
        bean.setMessage(message);

        PeripheralSystem peripheralSystem = new PeripheralSystem();
        peripheralSystem.addItem((byte) 1, "测试公司1", "TEST-001", "1.1.0", "1.1.1", "device_id_1", "user_code_1");
        peripheralSystem.addItem((byte) 2, "测试公司2", "TEST-002", "1.2.0", "1.1.2", "device_id_2", "user_code_2");
        peripheralSystem.addItem((byte) 3, "测试公司3", "TEST-003", "1.3.0", "1.1.3", "device_id_3", "user_code_3");

        message.setId(PeripheralSystem.ID);
        message.setValue(peripheralSystem);
        return bean;
    }

    //事件设置
    public static T8301 T8301() {
        T8301 bean = new T8301();
        bean.setType(Action.Append);
        bean.addEvent(1, "test");
        bean.addEvent(2, "测试2");
        bean.addEvent(3, "www.jtt808.cn");
        return bean;
    }

    //文本信息下发
    public static T8300 T8300_2013() {
        T8300 bean = new T8300("测试123@456#abc!...结束", 1, 1, 1, 1, 1, 1);
        return bean;
    }

    public static T8300 T8300_2019() {
        T8300 bean = new T8300(1, "测试123@456#abc!...结束", 1, 1, 1, 1, 1, 1);
        return bean;
    }
}