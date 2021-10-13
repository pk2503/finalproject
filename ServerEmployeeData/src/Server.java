import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {


        try {
            System.out.println("Server is waiting for client.");
            ServerSocket serverSocket = new ServerSocket(9997);
            Socket sc = serverSocket.accept();
            System.out.println("Connection established with client!");
            InputStreamReader isr = new InputStreamReader(sc.getInputStream());
            BufferedReader sReader = new BufferedReader(isr);
            FileWriter Writer = new FileWriter("EmployeData.txt", true);

            Thread serverCreateAccountListener = new Thread(() -> {
                while (true) {
                    try {
                        Writer.write(sReader.readLine() + ","
                                + sReader.readLine() + ","
                                + sReader.readLine() + ","
                                + sReader.readLine() + ","
                                + sReader.readLine() + ",");
                        Writer.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });serverCreateAccountListener.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}//now i will show u the part done by Tahmim Jawad 011 183 091

