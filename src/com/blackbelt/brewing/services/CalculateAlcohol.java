package com.blackbelt.brewing.services;

/**
 * Created by mholloway on 3/28/17.
 */
public class CalculateAlcohol {

    //No Arg consturctor
    public void CalculateAlcohol(){};

    public double getPercent(double startBrix, double endBrix) {
        double abv = (calculateGravity(startBrix) - calculateGravity(endBrix)) * 131;
        return (double) Math.round(abv * 100)/100;
    }

    private Double calculateGravity(double brix) {
        Double gravity = (brix / (258.6-((brix / 258.2)*227.1))) + 1;
        return gravity;
    }
}
