import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {

        System.out.println("客户端初始化......");
        Socket client = new Socket("127.0.0.1",5000);
        System.out.println("连接服务器成功！");

        OutputStream out = client.getOutputStream();
        OutputStreamWriter os = new OutputStreamWriter(out,"UTF-8");
        PrintWriter pw = new PrintWriter(os,true);
        Scanner sc = new Scanner(System.in);

        InputStream in = client.getInputStream();
        InputStreamReader is = new InputStreamReader(in,"UTF-8");
        BufferedReader br = new BufferedReader(is);

        while (true) {
            System.out.println("请输入发送的消息：");
            String put = sc.next();
            pw.println(put);
            String get = br.readLine();
            if (get.equals("789")) {
                System.out.println("结束连接！");
                client.close();
                break;
            }
            System.out.println("服务器："+get);
        }
    }
}
