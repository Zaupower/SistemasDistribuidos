import java.io.*;
import java.net.*;
import java.util.Date;
import java.util.List;

public class WorkerThread extends Thread{
    private final ServerThread server;
    private Socket socket = null;
    private PrintWriter out;

    public WorkerThread(ServerThread serverThread, Socket socket) {
        this.server = serverThread;
        this.socket = socket;
    }


    public void run() {
        try {
            this.out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null) {

                String BoundleRecebido = "Incoming client message: "+inputLine+" Data: "+
                        new Date() + "IP ADDRESS: "+ socket.getInetAddress();
                String BoundleEnvio =inputLine+" Data: "+ new Date() + "IP ADDRESS: "+
                        socket.getInetAddress();
                List<WorkerThread> workerThreads = server.getWorkerList();
                for (WorkerThread worker: workerThreads){
                    worker.send(BoundleEnvio);
                }
                System.out.println(BoundleEnvio);
                out.println(BoundleEnvio);
                if (inputLine.equals("Bye"))
                    break;
            }
            out.close();
            in.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void send(String msg) {

        out.write(msg);
    }


}