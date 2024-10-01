package server;

import environment.Environment;
import linalg.Vector3d;

import java.util.UUID;

public class Host extends Server {
    public String host_id = "";
    public Environment environment = new Environment(this.position, 1, this);
    public Server[] servers = new Server[0];
    public String[] server_ids = new String[0];

    public Host() {
        host_id = UUID.randomUUID().toString().substring(14, 18);
    }
    public Host(Vector3d position){
        super(position);
        host_id = UUID.randomUUID().toString().substring(14, 18);
    }

    public String getID(SubServer subserver, String servername){
        String id = environment.id + host_id + servername +UUID.randomUUID().toString().substring(18);
        String[] newserver_ids = new String[server_ids.length + 1];
        System.arraycopy(server_ids, 0, newserver_ids, 0, server_ids.length);
        newserver_ids[server_ids.length] = id;
        server_ids = newserver_ids;
        addServer(subserver);


        return id;
    }

    public void addServer(Server server){
        Server[] newServers = new Server[servers.length + 1];
        System.arraycopy(servers, 0, newServers, 0, servers.length);
        newServers[servers.length] = server;
        servers = newServers;
    }
}
