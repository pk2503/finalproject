import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class EmployeeServerLogIn {


    public static void main(String[] args) throws IOException {

        System.out.println("Server is waiting for client.");
        ServerSocket serverSocket = new ServerSocket(6969);
        Socket sc = serverSocket.accept();
        System.out.println("Connection established with client!");
        OutputStreamWriter o = new OutputStreamWriter(sc.getOutputStream());
        BufferedWriter sWriter = new BufferedWriter(o);
        InputStreamReader isr = new InputStreamReader(sc.getInputStream());
        BufferedReader sReader = new BufferedReader(isr);
        if (Boolean.parseBoolean(sReader.readLine())) {
            Account account;
            ArrayList<Account> accountArrayList = new ArrayList<>();
            Scanner Data = new Scanner(new File("D:/ServerEmployeeData/AdminData.txt"), StandardCharsets.UTF_8);
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

                        for (Account value : accountArrayList) {

                            if (Objects.equals(sReader.readLine(), value.Name)
                                    && Objects.equals(sReader.readLine(), value.Password)) {
                                System.out.print("noo");
                                sWriter.write("true" + "\n");
                                sWriter.flush();
                                break;
                            }
                        }

        } else {
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

                        for (Account value : accountArrayList) {

                            if (Objects.equals(sReader.readLine(), value.Name)
                                    && Objects.equals(sReader.readLine(), value.Password)) {
                                System.out.print("yess");
                                sWriter.write("false" + "\n");
                                sWriter.flush();
                                break;
                            }
                        }


        }
    }
}

class Account {
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