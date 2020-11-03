import java.io.IOException;

public class TcpMultiServer {
    public static void main(String[] args) throws IOException {

        int port = 4444;
        ServerThread serverThread = new ServerThread(port);
        serverThread.start();
    }
}