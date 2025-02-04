 public class Iperfer {
 
    static int portNum;
    static int time;
    static String serverHostname;
 
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Error: missing or additonal arguments");
            System.exit(1);
        }

        switch (args[0]) {
            case "-c": {
                parseClientArgs(args);
                break;
            }

            case "-s": {
                parseServerArgs(args);
                break;
            }
                
            default: {
                System.out.println("Error: missing or additonal arguments");
                System.exit(1);
            }

        };

    }

    public static void parseServerArgs(String[] args) {
        for (int i = 1; i < args.length; i++) {

            switch (args[i]) {
                case "-p": {
                    portNum = Integer.parseInt(args[i + 1]);
                    if (validatePortNum(portNum)) {
                        System.out.println("Error: port number must be in the range 1024 to 65535");
                        System.exit(1);
                    }
                    i++;
                    break;
                }
            
                default: {
                    System.out.println("Error: missing or additonal arguments");
                    System.exit(1);
                }

            }
        }

        System.out.println("Server started on port " + portNum);
    }

    public static void parseClientArgs(String[] args) {
        for (int i = 1; i < args.length; i++) {

            switch (args[i]) {
                case "-p": {
                    portNum = Integer.parseInt(args[i + 1]);
                    if (validatePortNum(portNum)) {
                        System.out.println("Error: port number must be in the range 1024 to 65535");
                        System.exit(1);
                    }
                    i++;
                    break;
                }

                case "-t": {
                    time = Integer.parseInt(args[i + 1]);
                    i++;
                    break;
                }

                case "-h": {
                    serverHostname = args[i + 1];
                    i++;

                    break;
                }
            
                default: {
                    System.out.println("Error: missing or additonal arguments");
                    System.exit(1);
                }

            }

        }
        System.out.println("Client started on port " + portNum + " to server " + serverHostname);
    }


    public static boolean validatePortNum(int portNum) {
        return (portNum < 1024 || portNum > 65535);
    }
}