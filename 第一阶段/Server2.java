import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
//接收文件 并将小写转换为大写
public class Server2 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(5000);
        System.out.println("正在等待客户机上线！");
        Socket s = server.accept();
        System.out.println("客户机已上线！");
        //接收文件
        DataInputStream in = new DataInputStream(s.getInputStream());
        //文件写入
        DataOutputStream out = new DataOutputStream(s.getOutputStream());
        File file = new File("d:\\Dixie.txt");
        DataOutputStream fileout = new DataOutputStream(new FileOutputStream(file));
        System.out.println("正在接收文件！");
        while (in.readBoolean()) {
            fileout.writeBytes(in.readUTF());
        }

        System.out.println("接收完成!");
        out.writeUTF("文件已收到！");
    }
}
