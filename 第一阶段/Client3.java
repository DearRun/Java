import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Client3 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLoopbackAddress(),5000);
        OutputStream out = socket.getOutputStream();
        FileInputStream file = new FileInputStream("d:\\aaa.txt");
        byte[] b = new byte[1024];
        int len = 0;
        try {
            while ((len=file.read(b))!=-1) {
                out.write(b,0,len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (socket!=null) {
                    socket.close();
                }
                if (out!=null) {
                    out.close();
                }
                if (file!=null) {
                    file.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
