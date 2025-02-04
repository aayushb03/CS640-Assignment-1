import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    private String hostname;
    private int port;
    private int time;

    private final String PAYLOAD = "test";

    public Client(String hostname, int port, int time) {
        this.hostname = hostname;
        this.port = port;
        this.time = time;
    }

    public void start() {
        System.out.println(this.hostname);
        System.out.println(this.port);
        System.out.println(this.time);


        Socket socket = new Socket(hostname, port);
        socket.setSoTimeout(time * 1000);
        PrintWriter pw = new PrintWriter(socket.getOutputStream());


        pw.println(PAYLOAD);
        System.out.println("echo: " + PAYLOAD);

        try {
            while (true) {
                pw.println(PAYLOAD);
                System.out.println("echo: " + PAYLOAD);
            }
        } catch (Exception e) {
            socket.close();
        }

    

    }
}
