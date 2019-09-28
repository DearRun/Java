import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerDXC {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(5000);
        Socket client = server.accept();
        SD o = new SD(client);
        o.start();
    }
}

class SD extends Thread {
    Socket sk;
    public SD(Socket sk) {
        this.sk = sk;
    }

    @Override
    public void run() {
        try {
            DataInputStream in = new DataInputStream(sk.getInputStream());
            DataOutputStream out = new DataOutputStream(sk.getOutputStream());
            Scanner sc = new Scanner(System.in);
            while (true) {
                String get = in.readUTF();
                System.out.println("客户端"+getName()+":"+get);
                System.out.print("回复"+getName()+":");
                String message = sc.next();
                out.writeUTF(message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                sk.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
