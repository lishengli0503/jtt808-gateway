package org.yzh.protocol.t808;

import io.github.yezhihao.protostar.DataType;
import io.github.yezhihao.protostar.annotation.Field;
import io.github.yezhihao.protostar.annotation.Message;
import org.yzh.protocol.basics.JTMessage;
import org.yzh.protocol.commons.JT808;

/**
 * @author yezhihao
 * @home https://gitee.com/yezhihao/jt808-server
 */
@Message(JT808.查询区域或线路数据应答)
public class T0608 extends JTMessage {

    /** @see org.yzh.protocol.commons.Shape */
    @Field(index = 0, type = DataType.BYTE, desc = "查询类型")
    private int type;
    @Field(index = 1, type = DataType.DWORD, desc = "查询返回的数据数量")
    private int total;
    @Field(index = 5, type = DataType.BYTES)
    private byte[] bytes;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }
}