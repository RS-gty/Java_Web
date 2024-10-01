package environment;

import linalg.Vector3d;
import server.Server;

import java.util.UUID;

public class Environment {
    private Vector3d center;
    private double radius;
    private Server server;
    public String id;

    public Environment(Vector3d center, double radius, Server server) {
        this.center = center;
        this.radius = radius;
        this.server = server;
        this.id = UUID.randomUUID().toString().substring(0, 8);
    }

    public boolean isAccessable(Vector3d dest){
        return dest.sub(center).norm() <= radius;
    }
}
