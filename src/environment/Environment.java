package environment;

import linalg.Vector3d;
import server.Host;
import server.Server;

import java.util.Arrays;
import java.util.UUID;

public class Environment {
    private double tps;
    private Vector3d center;
    private double radius;
    private String id;
    private Host[] hosts = new Host[0];

    public Environment(double tps, Vector3d center, double radius) {
        this.tps = tps;
        this.center = center;
        this.radius = radius;
        this.id = UUID.randomUUID().toString().substring(0, 8);
    }

    public Environment(double tps, Vector3d center) {
        this.tps = tps;
        this.center = center;
        this.radius = 0;
        this.id = UUID.randomUUID().toString().substring(0, 8);
    }

    public boolean isAccessable(Vector3d dest){
        return radius == 0 || dest.sub(center).norm() <= radius;
    }

    public void register(Host host){
        if (isAccessable(host.position)){
            Host[] newHosts = new Host[hosts.length + 1];
            System.arraycopy(hosts, 0, newHosts, 0, hosts.length);
            newHosts[hosts.length] = host;
            hosts = newHosts;
        }
    }

    public String getId(Host host){
        if (Arrays.asList(hosts).contains(host)){
            return id;
        } else {
            return null;
        }
    }

    public double getTps() {
        return tps;
    }
}
