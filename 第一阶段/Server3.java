import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server3 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(5000);
        Socket client = server.accept();
        InputStream in = client.getInputStream();
        FileOutputStream fileout = new FileOutputStream("d:\\login.txt");
        byte[] b = new byte[1024];
        int len = 0;
        try {
            while ((len = in.read(b))!= -1) {
                fileout.write(b,0,len);
            }
            System.out.println("接收完毕！");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (server!=null) {
                server.close();
            }
            if (client!=null) {
                client.close();
            }
            if (fileout!=null) {
                fileout.close();
            }
        }
    }
}
