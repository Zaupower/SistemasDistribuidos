import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerThread extends  Thread{
    private final int serverPort;
    private ArrayList<WorkerThread> workerThreads = new ArrayList<>();

    public ServerThread(int serverPort) {
        this.serverPort = serverPort;
    }

    public List<WorkerThread> getWorkerList(){
        return workerThreads;
    }

    @Override
    public void run() {

        ServerSocket serverSocket = null;
        try {
             serverSocket = new ServerSocket(serverPort);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            System.out.println("About to accept client connection");
            Socket clientSocket = serverSocket.accept();
            System.out.println("Accepted connection from"+ clientSocket);
            WorkerThread workerThread = new WorkerThread(this,clientSocket);
            workerThreads.add(workerThread);
            workerThread.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

