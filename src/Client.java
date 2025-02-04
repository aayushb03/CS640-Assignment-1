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
        System.out.println(this.hostname);
        System.out.println(this.port);
        System.out.println(this.time);
    }
}
