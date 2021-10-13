import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

public class server {
    public static void main(String[] args) throws IOException {
        System.out.println("Server is waiting for client.");
        ServerSocket serverSocket = new ServerSocket(7969);
        Socket sc = serverSocket.accept();
        System.out.println("Connection established with client!");
        OutputStreamWriter o = new OutputStreamWriter(sc.getOutputStream());
        BufferedWriter sWriter = new BufferedWriter(o);

        Account account;
        ArrayList<Account> accountArrayList = new ArrayList<>();
        Scanner Data = new Scanner(new File("D:/ServerEmployeeData/EmployeData.txt"), StandardCharsets.UTF_8);
        String str = Data.next();
        Data.close();
        Scanner data = new Scanner(str).useDelimiter(",");
        while (data.hasNext()) {
            account = new Account(data.next(),
                    data.next(),
                    Integer.parseInt((data.next())),
                    data.next(),
                    data.next());
            accountArrayList.add(account);
        }
        String s = "";
        for (int i = 0; i < accountArrayList.size(); i++) {
            s = s+accountArrayList.get(i).Name+",";
        }
        sWriter.write(s+"\n");
        sWriter.flush();
    }
}
