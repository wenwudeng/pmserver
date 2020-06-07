package com.xmut.pmserver.socket;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/*
 *   服务器线程的作用主要是:
 *   1.接收来自客户端的信息
 *   2.将接收到的信息解析，并转发给目标客户端
 * */
public class ServerThread extends Thread {

    private User user;
    private List<User> list;

    public ServerThread(User user, List<User> list) {
        this.user = user;
        this.list = list;
    }

    public void run() {

        try {
            while (true) {
                // 信息的格式：发送人,收发人,信息体
                //不断地读取客户端发过来的信息
                String msg= user.getBr().readLine();
                System.out.println("服务端收到："+msg);
                String[] str = msg.split(",");

                for (User user : list) {
                    if (user.getName().equals(str[0])) {
                        sendToClient(str[1],msg);
                        break;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(user.getName()+"断开连接");
            MyServerClientManager.getInstance().removeClient(user);
        } finally {
            try {
                user.getBr().close();
                user.getSocket().close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private void sendToClient(String username, String msg) {
        for (User user : list) {
            if (user.getName().equals(username)) {
                try {
                    PrintWriter pw =user.getPw();
                    pw.println(msg);
                    pw.flush();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

