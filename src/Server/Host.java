package server;

import linalg.Vector3d;

import java.util.UUID;

public class Host extends Server {
    public String host_id = "";
    public Server[] servers = new Server[0];

    public Host() {
        host_id = UUID.randomUUID().toString().substring(0, 8);
    }
    public Host(Vector3d position){
        super(position);
    }

    public String getID(){
        return host_id + UUID.randomUUID().toString().substring(8);
    }

    public void addServer(Server server){
        Server[] newServers = new Server[servers.length + 1];
        System.arraycopy(servers, 0, newServers, 0, servers.length);
        newServers[servers.length] = server;
        servers = newServers;
    }
}
