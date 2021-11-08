package org.yzh.protocol.commons.transform.attribute;

import io.github.yezhihao.protostar.DataType;
import io.github.yezhihao.protostar.annotation.Field;
import org.yzh.protocol.jsatl12.AlarmId;

import java.time.LocalDateTime;

/**
 * 盲点监测
 */
public class AlarmBSD implements Alarm {

    public static final int id = 0x67;

    public static int id() {
        return id;
    }

    @Field(index = 0, type = DataType.DWORD, desc = "报警ID")
    private long serialNo;
    @Field(index = 4, type = DataType.BYTE, desc = "标志状态：0.不可用 1.开始标志 2.结束标志")
    private int state;
    @Field(index = 5, type = DataType.BYTE, desc = "报警/事件类型：1.后方接近报警 2.左侧后方接近报警 3.右侧后方接近报警")
    private int type;
    @Field(index = 6, type = DataType.BYTE, desc = "车速")
    private int speed;
    @Field(index = 7, type = DataType.WORD, desc = "高程")
    private int altitude;
    @Field(index = 9, type = DataType.DWORD, desc = "纬度")
    private int latitude;
    @Field(index = 13, type = DataType.DWORD, desc = "经度")
    private int longitude;
    @Field(index = 17, type = DataType.BCD8421, length = 6, desc = "日期时间")
    private LocalDateTime dateTime;
    @Field(index = 23, type = DataType.WORD, desc = "车辆状态")
    private int status;
    @Field(index = 25, type = DataType.OBJ, length = 16, desc = "报警标识号", version = {-1, 0})
    @Field(index = 25, type = DataType.OBJ, length = 40, desc = "报警标识号(粤标)", version = 1)
    private AlarmId alarmId;

    public long getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(long serialNo) {
        this.serialNo = serialNo;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getAltitude() {
        return altitude;
    }

    public void setAltitude(int altitude) {
        this.altitude = altitude;
    }

    public int getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public int getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public AlarmId getAlarmId() {
        return alarmId;
    }

    public void setAlarmId(AlarmId alarmId) {
        this.alarmId = alarmId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(300);
        sb.append("AlarmBSD{serialNo=").append(serialNo);
        sb.append(", state=").append(state);
        sb.append(", type=").append(type);
        sb.append(", speed=").append(speed);
        sb.append(", altitude=").append(altitude);
        sb.append(", longitude=").append(longitude);
        sb.append(", latitude=").append(latitude);
        sb.append(", dateTime=").append(dateTime);
        sb.append(", status=").append(status);
        sb.append(", alarmId=").append(alarmId);
        sb.append('}');
        return sb.toString();
    }
}