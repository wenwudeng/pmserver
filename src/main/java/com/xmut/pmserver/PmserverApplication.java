package com.xmut.pmserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

@SpringBootApplication
public class PmserverApplication /*extends WebMvcConfigurationSupport*/ {

    public static void main(String[] args) throws IOException {

        SpringApplication.run(PmserverApplication.class, args);

        //指定端口号
        int port = 8888;
        //保留接收信息
        String info = null;
        //1、创建ServerSocket并绑定端口号
        ServerSocket serverSocket = new ServerSocket(port);
        //2、使用accept监听来自客户端的连接
        Socket socket = serverSocket.accept();
        //3、获取客户端信息(字节流转换字符流),并保存至缓冲区
        InputStreamReader is = new InputStreamReader(socket.getInputStream());
        BufferedReader br = new BufferedReader(is);
        while ((info = br.readLine()) != null) {
            System.out.println("服务端收到客户端:" + info);
        }
        socket.shutdownInput();
        //4、通过输出流回应客户端
        PrintWriter os = new PrintWriter(socket.getOutputStream());
        os.write("收到！");
        os.flush();
        socket.shutdownOutput();

        //5、关闭资源
        is.close();
        os.close();
        br.close();
        socket.close();
        serverSocket.close();
    }



}
