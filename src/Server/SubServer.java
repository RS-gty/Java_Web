package server;

import linalg.Vector3d;

import java.util.UUID;

public class SubServer extends Server {
    private String serverName = UUID.randomUUID().toString().substring(8, 18);
    public String[] ids = new String[0];

    public SubServer(Vector3d position) {
        super(position);
    }

    public SubServer(double x, double y, double z) {
        super(x, y, z);
    }

    public void registerHost(Host host) {
        host.register(this);
        if (host.getID(this) != null) {
            this.tps = host.getTps();
            String[] newids = new String[ids.length + 1];
            System.arraycopy(ids, 0, newids, 0, ids.length);
            newids[newids.length - 1] = host.getID(this);
            ids = newids;
        } else {
            throw new IllegalArgumentException("register host failed");
        }
    }
}
