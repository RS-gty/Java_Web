import environment.Environment;
import linalg.Vector3d;
import server.Host;
import server.SubServer;
import signal.Signal;

import java.util.Arrays;

public class Simulation {
    private static final double tps = 1000;

    public static void main(String[] args) {

        SubServer S1 = new SubServer(1,2,2);
        SubServer S2 = new SubServer(1,1,1);
        Host H1 = new Host(1,2,3);
        Host H2 = new Host(1,1,1);
        Environment E1 = new Environment(tps, new Vector3d(1, 2, 3), 4);

        H1.registerEnv(E1);
        H2.registerEnv(E1);
        S1.registerHost(H1);
        S1.registerHost(H2);
        S2.registerHost(H1);
        S2.registerHost(H2);
        System.out.println(Arrays.toString(S1.ids));
        System.out.println(Arrays.toString(S2.ids));

        Signal Sig1 = new Signal(new Vector3d(1, 1, 3),0,  2);
        System.out.println(Sig1.getValue(new Vector3d(1, 2, 3), 1 + 1 * Math.PI));
    }
}