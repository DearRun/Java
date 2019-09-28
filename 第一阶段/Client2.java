import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
//发送小写文本文件
public class Client2 {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket(InetAddress.getLoopbackAddress(),5000);
        System.out.println("成功连接服务器！");
        DataInputStream in = new DataInputStream(s.getInputStream());
        DataOutputStream out = new DataOutputStream(s.getOutputStream());

        FileInputStream fileInputStream = new FileInputStream("d:\\小写.txt");
        InputStreamReader isr = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(isr);
        String str = null;
        System.out.println("正在发送！");
        while ((str=bufferedReader.readLine())!=null) {
            out.writeUTF(str.toUpperCase());
        }
        System.out.println(in.readUTF());
    }
}
