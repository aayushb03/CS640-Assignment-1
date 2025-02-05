import java.io.OutputStream;

import java.net.Socket;

public class Client {
    private String hostname;
    private int port;
    private int time;


    public Client(String hostname, int port, int time) {
        this.hostname = hostname;
        this.port = port;
        this.time = time;
    }

    public void start() {
        try (Socket socket = new Socket(hostname, port); OutputStream out = socket.getOutputStream()) {
            byte[] data = new byte[1000];
            long startTime = System.currentTimeMillis();
            long endTime = startTime + (time * 1000);
            long totalBytesSent = 0;
            
            while (System.currentTimeMillis() < endTime) {
                out.write(data);
                totalBytesSent += data.length;
            }

            long sentKB = totalBytesSent / 1000;
            double sentMbps = (totalBytesSent * 8.0) / (time * 1000000.0);
            System.out.printf("sent=%d KB rate=%.3f Mbps%n", sentKB, sentMbps);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
