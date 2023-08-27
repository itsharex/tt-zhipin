package com.whoiszxl.zhipin.im.codec;

import cn.hutool.core.thread.ExecutorBuilder;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.whoiszxl.zhipin.im.pack.MessagePack;
import com.whoiszxl.zhipin.im.protocol.ChatMessage;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.handler.codec.MessageToMessageEncoder;
import io.netty.handler.codec.http.websocketx.BinaryWebSocketFrame;

import java.util.List;

/**
 * web socket 的编码器，需要将处理好的消息通过编码后写回到客户端
 * @author whoiszxl
 */
public class WebSocketEncoder extends MessageToMessageEncoder<ChatMessage> {

    @Override
    protected void encode(ChannelHandlerContext ctx, ChatMessage msg, List<Object> out) throws Exception {
        ExecutorBuilder.create().build();
        try {
            String s = JSONUtil.toJsonStr(msg);
            ByteBuf byteBuf = Unpooled.directBuffer(9 + s.length());
            byte[] bytes = s.getBytes();
            byteBuf.writeByte(msg.getAckStatus());
            byteBuf.writeInt(msg.getCommand());
            byteBuf.writeInt(bytes.length);
            byteBuf.writeBytes(bytes);
            out.add(new BinaryWebSocketFrame(byteBuf));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
