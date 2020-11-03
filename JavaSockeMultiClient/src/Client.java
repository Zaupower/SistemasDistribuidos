import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 4444);

        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String serverResponse = input.readLine();

        JOptionPane.showMessageDialog(null, serverResponse);
        socket.close();
        System.exit(0);
    }
}
