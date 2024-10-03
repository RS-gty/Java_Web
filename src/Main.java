import environment.Environment;
import linalg.Vector3d;
import server.Host;
import server.Server;
import server.SubServer;
import utils.Condition;
import data.enums.Cooridinate;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        SubServer S1 = new SubServer(1,2,2);
        SubServer S2 = new SubServer(1,1,1);
        Host H1 = new Host(1,2,3);
        Host H2 = new Host(1,1,1);
        Environment E1 = new Environment(new Vector3d(1, 2, 3), 1);

        H1.registerEnv(E1);
        S1.registerHost(H1);
        System.out.println(Arrays.toString(S1.ids));
    }
}