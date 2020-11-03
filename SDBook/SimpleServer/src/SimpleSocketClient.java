import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class SimpleSocketClient {
    public static void main(String[] args) throws IOException {
        //Establish a server connection throgh 1234 port
        Socket s = new Socket("localhost", 1234);
        //Access the input stream of the server socket
        InputStream sIn = s.getInputStream();
        //wrap the socket input stream with data input stream
        DataInputStream sockeDIS = new DataInputStream(sIn);
        //Read from the socket data input stream
        String testString = new String(sockeDIS.readUTF());
        //print the data read
        System.out.println(testString);
        //cleanUp
        sockeDIS.close();
        sIn.close();
        s.close();
    }
}
