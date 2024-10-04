package signal;

import linalg.Vector3d;

import java.lang.Math;

public class Signal {
    private double tick;
    private double amplitude, period, phase;
    private Vector3d position;
    private double velocity = 1;

    public Signal(Vector3d position, double tick) {
        this.position = position;
        this.tick = tick;
        this.amplitude = 1.0;
        this.period = 2 * Math.PI;
        this.phase = 0.0;
    }

    public Signal(Vector3d position, double tick, double amplitude) {
        this.position = position;
        this.tick = tick;
        this.amplitude = amplitude;
        this.period = 2 * Math.PI;
        this.phase = 0.0;
    }

    public Signal(Vector3d position, double tick, double amplitude, double period) {
        this.position = position;
        this.tick = tick;
        this.amplitude = amplitude;
        this.period = period;
        this.phase = 0.0;
    }

    public Signal(Vector3d position, double tick, double amplitude, double period, double phase) {
        this.position = position;
        this.tick = tick;
        this.amplitude = amplitude;
        this.period = period;
        this.phase = phase;
    }

    public double getValue(Vector3d position, double c_tick){
        double p_tick = (this.position.sub(position).norm()) / velocity + this.tick;
        return (c_tick - p_tick >= 0) ? this.amplitude * Math.sin((2 * Math.PI / this.period) * (c_tick - p_tick) + this.phase) : 0.0;
    }
}
