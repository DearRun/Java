import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientDXC {
    public static void main(String[] args) {
        try {
            Socket client = new Socket("172.16.1.200",5987);
            DataOutputStream out = new DataOutputStream(client.getOutputStream());
            DataInputStream in = new DataInputStream(client.getInputStream());
            Scanner sc = new Scanner(System.in);
            try {
                while (true) {
                    String put = sc.next();
                    out.writeUTF("杨鲜银:"+put);
                    String get = in.readUTF();
                    System.out.println(get);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                client.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
dsbauifhbwejfh
