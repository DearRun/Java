import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
//网络编程-Socket套接字-服务器端
public class ServerClass {
    public static void main(String[] args) throws IOException {
        //创建套接字
        System.out.println("服务端初始化......");
        ServerSocket server = new ServerSocket(5000);
        System.out.println("正在等待客户端连接......");
        Socket client = server.accept();
        System.out.println("连接成功!");

        //接收消息
        InputStream in = client.getInputStream();
        InputStreamReader is = new InputStreamReader(in,"UTF-8");
        BufferedReader br = new BufferedReader(is);

        //发送消息
        OutputStream out = client.getOutputStream();
        OutputStreamWriter os = new OutputStreamWriter(out);
        PrintWriter pw = new PrintWriter(os,true);
        Scanner sc = new Scanner(System.in);

        while (true) {
            String get = br.readLine();
            if (get.equals("789")) {
                System.out.println("结束连接！");
                client.close();
                break;
            }
            System.out.println("客户端："+get);
            System.out.print("回复：");
            String put = sc.next();
            pw.println(put);
        }
    }
}
