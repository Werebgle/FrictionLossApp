package com.itstime2gohunting.frictionloss;

public class GpmCalculation {

    private double frictionLoss;
    private double coefficient;
    private double gpm;
    private double length;

    private double gpmResult;
    private double x = 29.7;
    private double diameter;
    private double np;


    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }

    public void setGpm(double gpm) {
        this.gpm = gpm;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getFrictionLoss() {
        frictionLoss = coefficient*(Math.pow((gpm/100), 2))*(length/100);
        return frictionLoss;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    public void setNp(double np) {
        this.np = np;
    }

    public double getGpmResult() {
        gpmResult = x*(Math.pow(diameter, 2))*(Math.sqrt(np));
        return gpmResult;
    }
}
