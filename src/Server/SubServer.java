package server;

import linalg.Vector3d;

import java.util.UUID;

public class SubServer extends Server {
    private String serverName = UUID.randomUUID().toString().substring(8, 18);
    public String[] ids = new String[0];

    public SubServer() {

    }
    public SubServer(Vector3d position) {
        super(position);
    }

    public SubServer(double x, double y, double z) {
        super(x, y, z);
    }

    public boolean register(Host host) {
        host.addServer(this);
        String[] newids = new String[ids.length + 1];
        System.arraycopy(ids, 0, newids, 0, ids.length);
        newids[newids.length - 1] = host.getID(this, this.serverName);
        ids = newids;
        return true;
    }
}
