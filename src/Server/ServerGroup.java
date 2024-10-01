package server;

public class ServerGroup {
    public Server[] servers;

    public ServerGroup() {
    }

    public ServerGroup register(Server server) {
        Server[] newServers = new Server[servers.length + 1];
        System.arraycopy(servers, 0, newServers, 0, servers.length);
        newServers[servers.length] = server;
        servers = newServers;
        return this;
    }
}
