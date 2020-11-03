import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class KnockServer {
    public KnockServer() {
    }

    public static void main(String[] args) throws IOException {
        int portNumber = 7;
        ServerSocket serverSocket = null;
        Socket clientSocket = null;
        PrintWriter out = null;

        try {
            serverSocket = new ServerSocket(portNumber);
            clientSocket = serverSocket.accept();
            out = new PrintWriter(clientSocket.getOutputStream(), true);
        } catch (IOException var9) {
            System.out.println("Exception caught when trying to listen on port " + portNumber + " or listening for a connection");
            System.out.println(var9.getMessage());
        }

        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        KnockKnockProtocol knock = new KnockKnockProtocol();
        String outputLine = knock.processInput((String)null);
        out.println(outputLine);
        System.out.println("Server: " + outputLine);

        String inputLine;
        while((inputLine = in.readLine()) != null) {

            System.out.println("Client: " + inputLine);
            outputLine = knock.processInput(inputLine);
            System.out.println("Server: " + outputLine);
            out.println(outputLine);
            if (outputLine.equals("Bye.")) {
                break;
            }
        }

        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }
}

