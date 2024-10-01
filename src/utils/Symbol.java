package utils;

import data.enums.Cooridinate;

public class Symbol {
    public String symbol;
    private Condition condition;
    private double value;

    public Symbol(Cooridinate c, Condition condition, double value) {
        this.symbol = c.toString();
        this.condition = condition;
        this.value = value;
    }

    public Condition Add(double n){
        return new Condition(condition, this, value + n);
    }
    public Condition Sub(double n){
        return new Condition(condition, this, value - n);
    }
    public Condition Mul(double n){
        return new Condition(condition, this, value * n);
    }
    public Condition Div(double n){
        return new Condition(condition, this, value / n);
    }
    public Condition Pow(double n){
        return new Condition(condition, this, Math.pow(value, n));
    }
    public Condition Zero(){
        return new Condition(condition, this, 0);
    }
    public Condition Negative(){
        return new Condition(condition, this, -value);
    }
}
