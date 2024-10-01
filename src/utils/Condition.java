package utils;

import data.enums.Cooridinate;

public class Condition {
    public double x, y, z, t;
    private String[] symbols = {"x", "y", "z", "t"};

    public Condition() {
    }

    public Condition(Condition c, Symbol s, double value) {
        this.x = c.x;
        this.y = c.y;
        this.z = c.z;
        this.t = c.t;
        switch (s.symbol) {
            case "x" -> this.x = value;
            case "y" -> this.y = value;
            case "z" -> this.z = value;
            case "t" -> this.t = value;
        }
    }

    public Symbol getSymbol(Cooridinate c) {
        double value = 0;
        switch (c) {
            case Cooridinate.x -> value = this.x;
            case Cooridinate.y -> value = this.y;
            case Cooridinate.z -> value = this.z;
            case Cooridinate.t -> value = this.t;
        }
        return new Symbol(c, this, value);
    }

    public double get_Sum_Value() {
        return x + y + z + t;
    }
}
