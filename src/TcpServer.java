
import java.net.*;
import java.io.*;

public class TcpServer {

    private ServerSocket ss;
    private Socket s;
    private BufferedReader in;  //character
    private PrintWriter out;    //character
    private String msg;

    public TcpServer() {

        try {
            //step 1 open port
            ss = new ServerSocket(8888);

            while (true) {
                //step 2 wait for connect from client
                s = ss.accept();    //เหมือน wait()

                //step 3 create input and output
                in = new BufferedReader(new InputStreamReader(s.getInputStream()));  //byte to character to buffered
                out = new PrintWriter(s.getOutputStream()); //byte to character

                //step 4 process
                msg = in.readLine();    //echo server ส่งอะไรมา ตอบอันนั้นกลับ
                out.println(msg);       //echo server
                out.flush();

                //step 5 close
                s.close();
            }
            //ss.close();

        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }

    }

    public static void main(String[] args) {
        new TcpServer();

    }
}
