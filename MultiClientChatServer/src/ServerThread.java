import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class ServerThread extends Thread{
    private Socket socket;
    private ArrayList<ServerThread> threadList;
    private PrintWriter output;
    private boolean lastRead = false;

    public  ServerThread(Socket socket, ArrayList<ServerThread> threads) throws IOException {
        this.socket = socket;
        this.threadList = threads;
    }

    @Override
    public void run(){
        try{
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            output = new PrintWriter(socket.getOutputStream(), true);

            //Infinite loop for thread instance
            while (true){
                String outputString = input.readLine();
                lastRead = true;
                //If user types exit command
                if(outputString.equals("exit")){
                    break;
                }
                //Metood para verificar se recebe mensagens com regularidade NAO FEITO
                //monitoring();
                printToAllClients("From server: "+outputString);

                log(outputString);
                System.out.println("Server received "+ outputString);
            }
        }catch (Exception e){
            System.out.println("Error ocurred" + e.getStackTrace());
        }
    }

    private void printToAllClients(String outputString) {
        for (ServerThread sT: threadList){
            sT.output.println(outputString);
        }
    }

//    private void monitoring() throws InterruptedException {
//        System.out.println("LastRead Antes "+lastRead);
//
//        System.out.println("Entrou em monitorizacao");
//        lastRead = false;
//        TimeUnit.SECONDS.sleep(12);
//
//        if (lastRead == false){
//            System.out.println("Last Read depois "+lastRead);
//        }else {
//            System.out.println("Monitorizacao ok");
//        }
//
//    }
    static void log(String s) {
        try (PrintWriter out = new PrintWriter(new BufferedWriter(
                new FileWriter("log"  + ".txt", true)))) {
            out.println(s);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
