package server;

import linalg.Vector3d;

public class SubServer extends Server {
    public SubServer() {

    }
    public SubServer(Vector3d position) {
        super(position);
    }

    public boolean register(Host host) {
        host.addServer(this);
        return true;
    }
}
