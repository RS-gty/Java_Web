package server;

import linalg.Vector3d;

public class Server {
    public Vector3d position;
    protected double tps;

    public Server(Vector3d position){
        this.position = position;
    }

    public Server(double x, double y, double z){
        this.position = new Vector3d(x, y, z);
    }
}
