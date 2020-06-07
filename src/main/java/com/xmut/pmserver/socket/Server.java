package com.xmut.pmserver.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

//服务器类
public class Server {

    public static void main(String[] args) throws Exception {

        // 实例化一个list,用于保存所有的User
        MyServerClientManager manager = MyServerClientManager.getInstance();
        // 创建绑定到特定端口的服务器套接字
        @SuppressWarnings("resource")
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务端正在开始~");
        // 循环监听客户端连接
        while (true) {
            Socket socket = serverSocket.accept();
            // 每接受一个线程，就随机生成一个一个新用户
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String[] str = br.readLine().split(",");
            User user = new User(str[0],socket);
            System.out.println(user.getName() + "已连接...");
            manager.addClient(user);
            // 创建一个新的线程，接收信息并转发
            ServerThread thread = new ServerThread(user, manager.getClientList());
            thread.start();
        }
    }
}
