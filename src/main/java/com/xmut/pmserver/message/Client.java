package com.xmut.pmserver.message;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/*
 *   client线程主要是负责：
 *   1.发送信息
 *   2.一直接收信息，并解析
 * */
public class Client {

    public static void main(String[] args) {
        boolean isFirst = true;
        try {
            Socket socket = new Socket("localhost", 9999);
            //开启一个线程接收信息，并解析
            ClientThread thread=new ClientThread(socket);
            thread.setName("Client1");
            thread.start();

            //主线程用来发送信息
            PrintWriter out=new PrintWriter(socket.getOutputStream());

            while(true)
            {
                if (isFirst){
                    out.println("root");
                    isFirst =false;
                }else {
                    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                    String s=br.readLine();
                    out.println(s);
                    System.out.println("客户端发送："+s);
                }
                out.flush();
            }

        }catch(Exception e){
            System.out.println("服务器异常");
        }
    }
}

