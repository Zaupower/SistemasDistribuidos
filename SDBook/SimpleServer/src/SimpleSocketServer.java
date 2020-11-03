import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleSocketServer {
    public static void main(String[] args) throws IOException {
        // A new service registred with 1234 port
        ServerSocket ss = new ServerSocket(1234);
        //Accept the connection request made with the server socket
        Socket s = ss.accept();
        // Establishe the output stream from the socket connection
        OutputStream socketOutStream = s.getOutputStream();
        DataOutputStream socketDOS = new DataOutputStream
                (socketOutStream);
        //communicate with the socket data stream with a message
        socketDOS.writeUTF("Hello world");
        //CleanUp
        socketDOS.close();
        socketOutStream.close();
        s.close();
        ss.close();
    }
}
