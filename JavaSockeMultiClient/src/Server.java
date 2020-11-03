import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket listener = new ServerSocket(4444);

        System.out.println("SErver waiting for client connection");
        Socket client = listener.accept();
        System.out.println("Connected to client");

        PrintWriter out = new PrintWriter(client.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));

        while (true){
            try {
                String request = in.readLine();
                System.out.println(request);
            }catch (IOException e){
                e.printStackTrace();
            }
        }

    }

    private static String getRandomName() {
        return "Marcelo";
    }
}
