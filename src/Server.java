import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private int port;

    public Server(int port) {
        this.port = port;
    }

    public void start() {
        System.out.println(this.port);
        try (ServerSocket serverSocket = new ServerSocket(port);
             Socket clientSocket = serverSocket.accept();
             InputStream in = clientSocket.getInputStream()) {

            byte[] buffer = new byte[1000];
            long bytesRead;
            long totalBytesReceived = 0;
            long startTime = System.currentTimeMillis();

            while ((bytesRead = in.read(buffer)) != -1) {
                totalBytesReceived += bytesRead;
            }

            long endTime = System.currentTimeMillis();
            double duration = (endTime - startTime) / 1000.0;
            long receivedKB = totalBytesReceived / 1000;
            double receivedMbps = (totalBytesReceived * 8.0) / (duration * 1000000.0);

            System.out.printf("received=%d KB rate=%.3f Mbps%n", receivedKB, receivedMbps);

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
