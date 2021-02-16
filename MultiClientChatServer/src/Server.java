import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    public static void main(String[] args) throws IOException {

        ArrayList<ServerThread> threadList = new ArrayList<ServerThread>();

        try(ServerSocket serverSocket  =new ServerSocket(5000)){
            while (true){
                Socket socket = serverSocket.accept();
               // GenerateJson gg = new GenerateJson(socket.getOutputStream())
                ServerThread serverThread = new ServerThread(socket, threadList);
                threadList.add(serverThread);
                serverThread.start();
            }
        }catch (Exception e){
            System.out.println("Error occurred in main:"+ e.getStackTrace());
        }
    }
}
