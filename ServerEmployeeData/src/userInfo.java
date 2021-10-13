import java.io.BufferedWriter;
import java.io.File;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

public class userInfo {
    public static void main(String[] args) {
        try {
            System.out.println("Server is waiting for client.");
            ServerSocket serverSocket = new ServerSocket(1999);
            Socket sc = serverSocket.accept();
            System.out.println("Connection established with client!");
            OutputStreamWriter o = new OutputStreamWriter(sc.getOutputStream());
            BufferedWriter sWriter = new BufferedWriter(o);

            Account account;
            ArrayList<Account> accountArrayList = new ArrayList<>();
            Scanner Data = new Scanner(new File("EmployeData.txt"), StandardCharsets.UTF_8);
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

            sWriter.write(accountArrayList.size() + "\n");
            Thread serverListener = new Thread(() -> {
                while (true) {
                    try {
                        int i;
                        i = 0;
                        i++;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            serverListener.start();
            for (Account value : accountArrayList) {
                sWriter.write(value.Name + "\n");
                sWriter.write(value.Password + "\n");
                sWriter.write(value.Sex + "\n");
                sWriter.write(value.ID + "\n");
                sWriter.write(value.DOB + "\n");
                sWriter.flush();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Account implements Serializable {
    String Name;
    String Password;
    String Sex;
    int ID;
    String DOB;

    public Account(String Name, String Password, int ID, String Sex, String DOB) {
        this.Name = Name;
        this.Password = Password;
        this.ID = ID;
        this.Sex = Sex;
        this.DOB = DOB;
    }
}
