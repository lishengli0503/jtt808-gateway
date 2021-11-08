package org.yzh.protocol.commons.transform.parameter;

import io.github.yezhihao.protostar.util.ByteBufUtils;
import io.netty.buffer.ByteBuf;
import io.swagger.v3.oas.annotations.media.Schema;

import java.nio.charset.StandardCharsets;

/**
 * 胎压监测系统参数
 * @author yezhihao
 * @home https://gitee.com/yezhihao/jt808-server
 */
public class ParamTPMS {

    public static final int id = 0xF366;

    public static int id() {
        return id;
    }

    @Schema(description = "轮胎规格型号(例：195/65R1591V,12个字符,默认值'900R20')")
    private String tireType;
    @Schema(description = "胎压单位：0.kg/cm2 1.bar 2.Kpa 3.PSI(默认值3)")
    private int pressureUnit = -1;
    @Schema(description = "正常胎压值(同胎压单位,默认值140)")
    private int normalValue = -1;
    @Schema(description = "胎压不平衡报警阈值(百分比0~100,达到冷态气压值,默认值20)")
    private int imbalanceThreshold = -1;
    @Schema(description = "慢漏气报警阈值(百分比0~100,达到冷态气压值,默认值5)")
    private int lowLeakThreshold = -1;
    @Schema(description = "低压报警阈值(同胎压单位,默认值110)")
    private int lowPressureThreshold = -1;
    @Schema(description = "高压报警阈值(同胎压单位,默认值189)")
    private int highPressureThreshold = -1;
    @Schema(description = "高温报警阈值(摄氏度,默认值80)")
    private int highTemperatureThreshold = -1;
    @Schema(description = "电压报警阈值(百分比0~100,默认值10)")
    private int voltageThreshold = -1;
    @Schema(description = "定时上报时间间隔(秒,取值0~3600,默认值60,0表示不上报)")
    private int reportInterval = -1;
    @Schema(description = "保留项")
    private byte[] reserved = new byte[6];

    public static int getId() {
        return id;
    }

    public String getTireType() {
        return tireType;
    }

    public void setTireType(String tireType) {
        this.tireType = tireType;
    }

    public int getPressureUnit() {
        return pressureUnit;
    }

    public void setPressureUnit(int pressureUnit) {
        this.pressureUnit = pressureUnit;
    }

    public int getNormalValue() {
        return normalValue;
    }

    public void setNormalValue(int normalValue) {
        this.normalValue = normalValue;
    }

    public int getImbalanceThreshold() {
        return imbalanceThreshold;
    }

    public void setImbalanceThreshold(int imbalanceThreshold) {
        this.imbalanceThreshold = imbalanceThreshold;
    }

    public int getLowLeakThreshold() {
        return lowLeakThreshold;
    }

    public void setLowLeakThreshold(int lowLeakThreshold) {
        this.lowLeakThreshold = lowLeakThreshold;
    }

    public int getLowPressureThreshold() {
        return lowPressureThreshold;
    }

    public void setLowPressureThreshold(int lowPressureThreshold) {
        this.lowPressureThreshold = lowPressureThreshold;
    }

    public int getHighPressureThreshold() {
        return highPressureThreshold;
    }

    public void setHighPressureThreshold(int highPressureThreshold) {
        this.highPressureThreshold = highPressureThreshold;
    }

    public int getHighTemperatureThreshold() {
        return highTemperatureThreshold;
    }

    public void setHighTemperatureThreshold(int highTemperatureThreshold) {
        this.highTemperatureThreshold = highTemperatureThreshold;
    }

    public int getVoltageThreshold() {
        return voltageThreshold;
    }

    public void setVoltageThreshold(int voltageThreshold) {
        this.voltageThreshold = voltageThreshold;
    }

    public int getReportInterval() {
        return reportInterval;
    }

    public void setReportInterval(int reportInterval) {
        this.reportInterval = reportInterval;
    }

    public byte[] getReserved() {
        return reserved;
    }

    public void setReserved(byte[] reserved) {
        this.reserved = reserved;
    }

    public static class S implements io.github.yezhihao.protostar.Schema<ParamTPMS> {

        public static final S INSTANCE = new S();

        private S() {
        }

        @Override
        public ParamTPMS readFrom(ByteBuf input) {
            ParamTPMS message = new ParamTPMS();
            message.tireType = input.readCharSequence(12, StandardCharsets.US_ASCII).toString();
            message.pressureUnit = input.readShort();
            message.normalValue = input.readShort();
            message.imbalanceThreshold = input.readShort();
            message.lowLeakThreshold = input.readShort();
            message.lowPressureThreshold = input.readShort();
            message.highPressureThreshold = input.readShort();
            message.highTemperatureThreshold = input.readShort();
            message.voltageThreshold = input.readShort();
            message.reportInterval = input.readShort();
            input.readBytes(message.reserved);
            return message;
        }

        @Override
        public void writeTo(ByteBuf output, ParamTPMS message) {
            byte[] bytes = message.getTireType().getBytes(StandardCharsets.US_ASCII);
            ByteBufUtils.writeFixedLength(output, 12, bytes);
            output.writeShort(message.pressureUnit);
            output.writeShort(message.normalValue);
            output.writeShort(message.imbalanceThreshold);
            output.writeShort(message.lowLeakThreshold);
            output.writeShort(message.lowPressureThreshold);
            output.writeShort(message.highPressureThreshold);
            output.writeShort(message.highTemperatureThreshold);
            output.writeShort(message.voltageThreshold);
            output.writeShort(message.reportInterval);
            ByteBufUtils.writeFixedLength(output, 6, message.getReserved());
        }
    }
}