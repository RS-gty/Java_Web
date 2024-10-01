import server.Host;
import server.Server;
import server.SubServer;
import utils.Condition;
import data.enums.Cooridinate;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        SubServer S1 = new SubServer();
        SubServer S2 = new SubServer();
        Host H1 = new Host();
        Host H2 = new Host();


        S1.register(H1);
        S2.register(H1);
        S2.register(H2);
        S1.register(H2);

        System.out.printf(Arrays.toString(H1.server_ids));
        System.out.printf(Arrays.toString(S1.ids));
        System.out.printf(Arrays.toString(S2.ids));
        System.out.printf(Arrays.toString(H2.server_ids));
    }
}