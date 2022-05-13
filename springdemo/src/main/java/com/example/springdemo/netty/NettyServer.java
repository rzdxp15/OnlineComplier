package com.example.springdemo.netty;


import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

public class NettyServer {
    public static void startserver(String hostname,int port){
        startserver0(hostname,port);
    }

    private static void startserver0(String hostname, int port) {
        EventLoopGroup bossGroup=new NioEventLoopGroup();
        EventLoopGroup worksGroup=new NioEventLoopGroup();

        try {
            ServerBootstrap bootstrap=new ServerBootstrap();
            bootstrap.group(bossGroup,worksGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline pipeline=ch.pipeline();
                            pipeline.addLast(new StringDecoder());
                            pipeline.addLast(new StringEncoder());
                            pipeline.addLast( new NettyServerHandler());

                        }
                    });
            ChannelFuture channelFuture=bootstrap.bind(hostname,port).sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            bossGroup.shutdownGracefully();
            worksGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) {

    }
}