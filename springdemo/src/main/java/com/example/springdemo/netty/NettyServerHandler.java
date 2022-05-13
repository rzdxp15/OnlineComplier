package com.example.springdemo.netty;

import io.netty.channel.*;
import io.netty.util.concurrent.EventExecutorGroup;


public class NettyServerHandler extends ChannelHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("服务器开始收到来自客户单的消息...");
        System.out.println("原始消息"+msg);

        if(msg.toString().startsWith(ClientBootstap.provederName)){

        }
    }
}
