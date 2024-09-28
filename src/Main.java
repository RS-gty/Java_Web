import server.Host;
import server.Server;
import server.SubServer;

public class Main {
    public static void main(String[] args) {

        SubServer S1 = new SubServer();
        Host H1 = new Host();

        S1.register(H1);
        System.out.println(H1.getID());
        System.out.printf(H1.servers.toString());
    }
}