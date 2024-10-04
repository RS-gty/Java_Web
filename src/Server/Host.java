package server;

import environment.Environment;
import linalg.Vector3d;

import java.util.Arrays;
import java.util.UUID;

public class Host extends Server {
    private String host_id = "";
    private Environment environment;
    private String eid;
    private Server[] servers = new Server[0];
    private String[] server_ids = new String[0];

    public Host(Vector3d position){
        super(position);
        this.host_id = UUID.randomUUID().toString().substring(13, 18);
    }
    public Host(double x, double y, double z){
        super(x, y, z);
        this.host_id = UUID.randomUUID().toString().substring(13, 18);
    }

    public String getID(SubServer subserver){
        String id = eid + this.host_id + UUID.randomUUID().toString().substring(18);

        if (Arrays.asList(servers).contains(subserver)){
            String[] newserver_ids = new String[server_ids.length + 1];
            System.arraycopy(server_ids, 0, newserver_ids, 0, server_ids.length);
            newserver_ids[server_ids.length] = id;
            server_ids = newserver_ids;
            return id;
        } else {
            return null;
        }
    }

    public void registerEnv(Environment environment){
        this.environment = environment;
        environment.register(this);
        String eid = environment.getId(this);
        if (eid != null){
            this.tps = environment.getTps();
            this.eid = eid;
        } else {
            throw new IllegalArgumentException("register environment failed");
        }
    }

    public void register(SubServer subserver){
        if (environment.isAccessable(subserver.position)){
            addServer(subserver);
        }
    }

    public double getTps(){
        return tps;
    }

    private void addServer(Server server){
        Server[] newServers = new Server[servers.length + 1];
        System.arraycopy(servers, 0, newServers, 0, servers.length);
        newServers[servers.length] = server;
        servers = newServers;
    }
}
