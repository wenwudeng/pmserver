package com.xmut.pmserver.socket;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 *   作用：一直接收服务端转发过来的信息
 * */
public class ClientThread extends Thread {
    private Socket socket;

    public ClientThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            InputStream inputStream = socket.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader br = new BufferedReader(inputStreamReader);
            try {
                // 信息的格式：say,发送人,收发人,信息体
                while (true) {
                    String msg=br.readLine();
                   // System.out.println("服务端发来的消息"+msg);
                    String[] str = msg.split(",");
                    switch (str[0]) {
                        case "say":
                           /* System.out.println(str[1] + " 对   " + "您" + " 说:  "
                                    + str[3]); */
                            System.out.println(str[1] + "对您说：" + str[3]);
                            break;
                        default:
                            break;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}

