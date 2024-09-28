package server;

import linalg.Vector3d;

public class Server {
    public Vector3d position;
    private String[] ids;

    public Server(){
        position = new Vector3d(0,0,0);
    }

    public Server(Vector3d position){
        this.position = position;
    }
}
