import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args)  {


        try {
            System.out.println("Waiting for clients...");
            ServerSocket ss = new ServerSocket(7);
            Socket soc = ss.accept();
            InetAddress localAddress = soc.getLocalAddress();
            InetAddress serverAddress = ss.getInetAddress();
            System.out.println("Connection established");
            BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
            String str = in.readLine();

            PrintWriter out = new PrintWriter(soc.getOutputStream(), true);
            out.println(localAddress+":"+ serverAddress + ":" + str);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
