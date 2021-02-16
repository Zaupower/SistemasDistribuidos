import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Client {
    public static void main(String[] args) {
        try(Socket socket = new Socket("localhost", 5000)){
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            Scanner scanner = new Scanner(System.in);
            String userInput;
            String response;
            String clientName="empty";
            ClientThread clientThread = new ClientThread(socket);
            clientThread.start();
            //loop closes when user enters exit command
            do{
                while (true){
                    TimeUnit.SECONDS.sleep(10);
                    //Send message to server every 10 seconds
                    output.println("Sensor X: readings 345058730953233.234234,234234234./2344523");
                }
//                if(clientName.equals("empty")){
//                    System.out.println("Enter your name");
//                    userInput = scanner.nextLine();
//                    clientName = userInput;
//                    output.println(userInput);
//                    if (userInput.equals("exit")){
//                        break;
//                    }
//                }
//                else {
//                    String message = ("(" + clientName + ")" + "message: ");
//                    System.out.println(message);
//                    userInput = scanner.nextLine();
//                    output.println(message+ " "+ userInput);
//                    if (userInput.equals("exit")){
//                        break;
//                    }
//                }
            }while (!userInput.equals("exit"));

        }catch (Exception e){
            System.out.println(e.getStackTrace());
        }
    }
}
